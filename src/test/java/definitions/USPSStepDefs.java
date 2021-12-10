package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static support.TestContext.getDriver;

public class USPSStepDefs {
    public static final String MOBILE_HAMBURGER_ACTIVE_DROPDOWN_MENU_XPATH = "//a[@class='mobile-hamburger active']";
    private static final String STREET_XPATH = "//input[@id='tAddress']";
    private static final String STATE_XPATH = "//select[@id='tState']";
    private static final String CITY_XPATH = "//input[@id='tCity']";
    private static final String ZIP_CODE_LINK_XPATH = "//a[@data-gtm-label='zip-code-link']";
    private static final String LOOK_UP_A_ZIP_CODE_XPATH = "//div[@class='zip_code_container']//h1";
    private static final String BY_ADDRESS_BUTTON_XPATH = "//div[@class='link-header-holder']//a[@data-location='byaddress']";
    private static final String FIND_BUTTON_XPATH = "//a[@id='zip-by-address']";
    private static final String HEADER_ZIPCODE_BY_ADDRESS_XPATH = "//div[@class='zip_code_address_results active']//h2";
    private static final String HEADER_ZIPCODE_BY_ADDRESS_TEXT = "ZIP Code™ by Address";
    private static final String ZIPCODE_BY_RESULTS_ADDRESS_XPATH = "//div[@class='zipcode-result-address']";
    public static final String NAV_LIST_XPATH = "//ul[@class='nav-list']";
    public static final String A_CLASS_MOBILE_HAMBURGER_IMG_XPATH = "//a[@class='mobile-hamburger']/img";
    public static final String NAVQUICKTOOLS_A_ARIA_EXPANDED_FALSE_XPATH = "//a[@name='navquicktools']/../a[@aria-expanded='false']";
    public static final String NAVQICKTOOLS_MENU_ITEM_XPATH = "//a[@name='navquicktools']/../a[@aria-expanded='false']/..//div[@class='active']//li//img";
    public static final String NAVIGATION_QUICKTOOLS_MENU_ITEM_XPATH = "//a[@name='navquicktools']//..//a[@class='nav-first-element menuitem']";
    public static final String ZIPCODE_LOOK_IN_NAVQUICKTOOLS_MENU_XPATH = "//a[@name='navquicktools']//..//a[@class='nav-first-element menuitem']//..//li/a/img";
    public static final String ZIPCODE_LOOK_UP_ICON_NAVIGATION_QUICKTOOLS_TEXT = "Zip Code™ Lookup Icon";


    @When("I go to Lookup ZIP page by address")
    public void iGoToLookupZIPPageByAddress() throws Exception {
        if ((QuoteStepDefs.getWebElement(NAV_LIST_XPATH).isDisplayed())) {
            System.out.println("I run from Navigation list menu");
            Rectangle res = getDriver().findElement(By.xpath(NAVIGATION_QUICKTOOLS_MENU_ITEM_XPATH)).getRect();
            System.out.println(res.getX());
            new Actions(getDriver())
                    .moveToElement(QuoteStepDefs.getWebElement(NAVIGATION_QUICKTOOLS_MENU_ITEM_XPATH))
                    .build()
                    .perform();
            PredefinedStepDefs.iWaitForSec(4);

            WebElement zipCodeLookUpIcon = getWebElementFromMenuList(
                    ZIPCODE_LOOK_IN_NAVQUICKTOOLS_MENU_XPATH, "alt", ZIPCODE_LOOK_UP_ICON_NAVIGATION_QUICKTOOLS_TEXT);

            new Actions(getDriver()).moveToElement(zipCodeLookUpIcon)
                    .build()
                    .perform();
            zipCodeLookUpIcon.click();
            PredefinedStepDefs.iWaitForSec(4);
            iClickByAddress();

        } else if ((QuoteStepDefs.getWebElement(A_CLASS_MOBILE_HAMBURGER_IMG_XPATH)).isDisplayed()) {
            System.out.println("I run from hamburger menu");
            QuoteStepDefs.click(A_CLASS_MOBILE_HAMBURGER_IMG_XPATH);
            PredefinedStepDefs.iWaitForElementWithXpathToBeDisplayed(MOBILE_HAMBURGER_ACTIVE_DROPDOWN_MENU_XPATH);
            QuoteStepDefs.click(NAVQUICKTOOLS_A_ARIA_EXPANDED_FALSE_XPATH);
            getWebElementFromMenuList(NAVQICKTOOLS_MENU_ITEM_XPATH, "alt", ZIPCODE_LOOK_UP_ICON_NAVIGATION_QUICKTOOLS_TEXT).click();
            iClickByAddress();

        } else iGoToLookupZIPPageByAddressByResizingInitialWindow();
    }

    private WebElement getWebElementFromMenuList(String xpath, String attributeName, String attributeValue) {
        List<WebElement> menuItemList = getDriver().findElements(By.xpath(xpath));
        List<String> menuItemAttributes = new ArrayList<>();
        menuItemList.forEach(el -> menuItemAttributes.add(el.getAttribute(attributeName)));
        return menuItemList.get(menuItemAttributes.indexOf(attributeValue));
    }

    public void iGoToLookupZIPPageByAddressByResizingInitialWindow() {
        System.out.println("I run from resizing initial window and ");
        PredefinedStepDefs.iWaitForElementWithXpathToBePresent(ZIP_CODE_LINK_XPATH);
        PredefinedStepDefs.iResizeWindowToAnd(700, 700);
        QuoteStepDefs.click(ZIP_CODE_LINK_XPATH);
        iClickByAddress();
    }

    private void iClickByAddress() {
        PredefinedStepDefs.iWaitForElementWithXpathToBePresent(LOOK_UP_A_ZIP_CODE_XPATH);
        PredefinedStepDefs.iWaitForElementWithXpathToBePresent(BY_ADDRESS_BUTTON_XPATH);
        QuoteStepDefs.click(BY_ADDRESS_BUTTON_XPATH);
        PredefinedStepDefs.iWaitForElementWithXpathToBePresent(STREET_XPATH);
    }

    @And("I fill out {string} street, {string} city, {string} state")
    public void iFillOutStreetCityState(String street, String city, String state) {
        QuoteStepDefs.type(STREET_XPATH, street);
        QuoteStepDefs.type(CITY_XPATH, city);
        QuoteStepDefs.getListOfValue(STATE_XPATH, state);
        QuoteStepDefs.click(FIND_BUTTON_XPATH);
    }

    @Then("I validate {string} zip code exists in the result")
    public void iValidateZipCodeExistsInTheResult(String zipcode) {
        PredefinedStepDefs.iWaitForElementWithXpathToBePresent(HEADER_ZIPCODE_BY_ADDRESS_XPATH);
        assertEquals(HEADER_ZIPCODE_BY_ADDRESS_TEXT, QuoteStepDefs.getText(HEADER_ZIPCODE_BY_ADDRESS_XPATH));
        getDriver().findElements(By.xpath(ZIPCODE_BY_RESULTS_ADDRESS_XPATH))
                .forEach(el -> {
                    assertTrue(el.getText().contains(zipcode));
                    System.out.println(el.getText());
                });
    }

    @When("I go to Lookup ZIP page by address with resizing initial window and Quick Tool Tracking options panel")
    public void iGoToLookupZIPPageByAddressWithResizingInitialWindowAndQuickToolTrackingOptionsPanel() {
        iGoToLookupZIPPageByAddressByResizingInitialWindow();
    }

    @When("I go to Lookup ZIP page by address through navigation panel")
    public void iGoToLookupZIPPageByAddressThroughNavigationPanel() throws Exception {
        if ((QuoteStepDefs.getWebElement(NAV_LIST_XPATH).isDisplayed())) {
            System.out.println("I run from Navigation list menu");
            Rectangle res = getDriver().findElement(By.xpath(NAVIGATION_QUICKTOOLS_MENU_ITEM_XPATH)).getRect();
            System.out.println(res.getX());
            new Actions(getDriver())
                    .moveToElement(QuoteStepDefs.getWebElement(NAVIGATION_QUICKTOOLS_MENU_ITEM_XPATH))
                    .build()
                    .perform();
            PredefinedStepDefs.iWaitForSec(4);


            WebElement zipCodeLookUpIcon = getWebElementFromMenuList(
                    ZIPCODE_LOOK_IN_NAVQUICKTOOLS_MENU_XPATH, "alt", ZIPCODE_LOOK_UP_ICON_NAVIGATION_QUICKTOOLS_TEXT);

            new Actions(getDriver()).moveToElement(zipCodeLookUpIcon)
                    .build()
                    .perform();
            zipCodeLookUpIcon.click();
            PredefinedStepDefs.iWaitForSec(4);
            iClickByAddress();
        } else throw new Error("Navigation panel doesn't display in start USPS page");
    }

    @When("I go to Lookup ZIP page by address through hamburger menu bar")
    public void iGoToLookupZIPPageByAddressThroughHamburgerMenuBar() {
        PredefinedStepDefs.iResizeWindowToAnd(700, 700);
        if ((QuoteStepDefs.getWebElement(A_CLASS_MOBILE_HAMBURGER_IMG_XPATH)).isDisplayed()) {
            System.out.println("I run from hamburger menu");
            QuoteStepDefs.click(A_CLASS_MOBILE_HAMBURGER_IMG_XPATH);
            PredefinedStepDefs.iWaitForElementWithXpathToBeDisplayed(MOBILE_HAMBURGER_ACTIVE_DROPDOWN_MENU_XPATH);
            QuoteStepDefs.click(NAVQUICKTOOLS_A_ARIA_EXPANDED_FALSE_XPATH);
            getWebElementFromMenuList(NAVQICKTOOLS_MENU_ITEM_XPATH, "alt", ZIPCODE_LOOK_UP_ICON_NAVIGATION_QUICKTOOLS_TEXT).click();
            iClickByAddress();
        } else throw new Error("Hamburger panel is not displayed in USPS page");
    }
}
