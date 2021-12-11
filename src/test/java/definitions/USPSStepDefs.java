package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static support.TestContext.getDriver;


public class USPSStepDefs extends HelperStepDefs {
    public static final String MOBILE_HAMBURGER_ACTIVE_DROPDOWN_MENU_XPATH = "//a[@class='mobile-hamburger active']";
    private static final String STREET_XPATH = "//input[@id='tAddress']";
    private static final String STATE_XPATH = "//select[@id='tState']";
    private static final String CITY_XPATH = "//input[@id='tCity']";
    private static final String ZIP_CODE_LINK_XPATH = "//a[@data-gtm-label='zip-code-link']";
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
    public static final String QUICK_TOOL_TRACK_OPTION_XPATH = "//div[@class='quicktools track-opt']";
    private final WebDriverWait wait = new WebDriverWait(getDriver(), 5, 200);


    @When("I go to Lookup ZIP page by address")
    public void iGoToLookupZIPPageByAddress() throws Exception {
        if ((getWebElement(NAV_LIST_XPATH).isDisplayed())) {
            System.out.println("I run from Navigation list menu");
            iGoToLookupZIPPageByAddressThroughNavigationPanel();

        } else if ((getWebElement(A_CLASS_MOBILE_HAMBURGER_IMG_XPATH)).isDisplayed()) {
            System.out.println("I run from hamburger menu");
            iGoToLookupZIPPageByAddressThroughHamburgerMenuBar();

        } else if (getWebElement(QUICK_TOOL_TRACK_OPTION_XPATH).isDisplayed()) {
            iGoToLookupZIPPageByAddressBySetWindowSize();
        } else
            throw new Error("There is no Navigation panel, hamburger menu or Quick Options panel in the USPS start page.");
    }

    public void iGoToLookupZIPPageByAddressBySetWindowSize() {
        System.out.println("I run from resizing initial window and Quick Tool Option panel ");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ZIP_CODE_LINK_XPATH)));
        setSize(700, 700);
        click(ZIP_CODE_LINK_XPATH);
        iClickByAddress();
    }

    private void iClickByAddress() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(BY_ADDRESS_BUTTON_XPATH)));
        click(BY_ADDRESS_BUTTON_XPATH);
    }

    @And("I fill out {string} street, {string} city, {string} state")
    public void iFillOutStreetCityState(String street, String city, String state) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(STREET_XPATH)));
        type(STREET_XPATH, street);
        type(CITY_XPATH, city);
        selectByValue(STATE_XPATH, state);
        click(FIND_BUTTON_XPATH);
    }

    @Then("I validate {string} zip code exists in the result")
    public void iValidateZipCodeExistsInTheResult(String zipcode) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(HEADER_ZIPCODE_BY_ADDRESS_XPATH)));
        assertEquals(HEADER_ZIPCODE_BY_ADDRESS_TEXT, getText(HEADER_ZIPCODE_BY_ADDRESS_XPATH));
        getDriver().findElements(By.xpath(ZIPCODE_BY_RESULTS_ADDRESS_XPATH))
                .forEach(el -> {
                    assertTrue(el.getText().contains(zipcode));
                    System.out.println(el.getText());
                });
    }

    @When("I go to Lookup ZIP page by address with resizing initial window and Quick Tool Tracking options panel")
    public void iGoToLookupZIPPageByAddressWithResizingInitialWindowAndQuickToolTrackingOptionsPanel() {
        iGoToLookupZIPPageByAddressBySetWindowSize();
    }

    @When("I go to Lookup ZIP page by address through navigation panel")
    public void iGoToLookupZIPPageByAddressThroughNavigationPanel() {
        if ((getWebElement(NAV_LIST_XPATH).isDisplayed())) {
            System.out.println("I run from Navigation panel menu");
            new Actions(getDriver())
                    .moveToElement(getWebElement(NAVIGATION_QUICKTOOLS_MENU_ITEM_XPATH))
                    .build()
                    .perform();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ZIPCODE_LOOK_IN_NAVQUICKTOOLS_MENU_XPATH)));

            WebElement zipCodeLookUpIcon = getWebElementFromListByAttributeValue(
                    ZIPCODE_LOOK_IN_NAVQUICKTOOLS_MENU_XPATH, "alt", ZIPCODE_LOOK_UP_ICON_NAVIGATION_QUICKTOOLS_TEXT);

            new Actions(getDriver()).moveToElement(zipCodeLookUpIcon)
                    .click()
                    .perform();
            iClickByAddress();
        } else throw new Error("Navigation panel doesn't display in start USPS page");
    }

    @When("I go to Lookup ZIP page by address through hamburger menu bar")
    public void iGoToLookupZIPPageByAddressThroughHamburgerMenuBar() {
        setSize(700, 700);
        if ((getWebElement(A_CLASS_MOBILE_HAMBURGER_IMG_XPATH)).isDisplayed()) {
            System.out.println("I run from hamburger menu");
            click(A_CLASS_MOBILE_HAMBURGER_IMG_XPATH);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(MOBILE_HAMBURGER_ACTIVE_DROPDOWN_MENU_XPATH)));
            click(NAVQUICKTOOLS_A_ARIA_EXPANDED_FALSE_XPATH);
            getWebElementFromListByAttributeValue(NAVQICKTOOLS_MENU_ITEM_XPATH, "alt", ZIPCODE_LOOK_UP_ICON_NAVIGATION_QUICKTOOLS_TEXT).click();
            iClickByAddress();
        } else throw new Error("Hamburger panel is not displayed in USPS page");
    }
}
