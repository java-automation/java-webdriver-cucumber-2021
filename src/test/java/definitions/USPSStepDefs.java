package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
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
    public static final String QUICK_TOOL_TRACK_OPTION_BUTTON_LINK_XPATH = "//div[@class='quicktools track-opt']//a[@class='button--link']";
    public static final String CALCULATOR_DESTINATION_SELECT_XPATH = "//select[@id='CountryID']";
    public static final String CALCULATOR_SUBMIT_PANEL_XPATH = "//input[@type='submit']";
    public static final String CALCULATOR_POSTCARD_QUANTITY_XPATH = "//input[@id='quantity-0']";
    public static final String CALCULATOR_POSTCARD_BUTTON_CALCULATE_XPATH = "//input[@type='button'][@value='Calculate']";
    public static final String CALCULATOR_POSTCARD_TOTAL_PRICE_XPATH = "//div[@id='total']";
    private final WebDriverWait wait = new WebDriverWait(getDriver(), 5, 200);


    @When("I go to Lookup ZIP page by address")
    public void iGoToLookupZIPPageByAddress() throws Error {
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

    @When("I go to Calculate Price Page")
    public void iGoToCalculatePricePage() {
        System.out.println("I run from resizing initial window and Quick Tool Option panel ");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(QUICK_TOOL_TRACK_OPTION_BUTTON_LINK_XPATH)));
        setSize(700, 700);
        getWebElementFromListByAttributeValue(QUICK_TOOL_TRACK_OPTION_BUTTON_LINK_XPATH, "data-gtm-label", "calculate-price-link").click();
    }

    @And("I select {string} with {string} shape")
    public void iSelectWithShape(String destination, String shape) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(CALCULATOR_DESTINATION_SELECT_XPATH)));
        Select list = new Select(getDriver().findElement(By.xpath(CALCULATOR_DESTINATION_SELECT_XPATH)));
        click(CALCULATOR_DESTINATION_SELECT_XPATH);
        list.selectByVisibleText(destination);
        getWebElementFromListByAttributeValue(CALCULATOR_SUBMIT_PANEL_XPATH, "value", shape).click();
    }

    @And("I define {string} quantity")
    public void iDefineQuantity(String quantity) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CALCULATOR_POSTCARD_QUANTITY_XPATH)));
        type(CALCULATOR_POSTCARD_QUANTITY_XPATH, quantity);
        assertEquals(0, getTotalPrice(), 0.0);
        click(CALCULATOR_POSTCARD_BUTTON_CALCULATE_XPATH);
    }

    private double getTotalPrice() {
        return parseDouble(getWebElement(CALCULATOR_POSTCARD_TOTAL_PRICE_XPATH).getText());
    }

    private double getPrice(String xpath) {
        return parseDouble(getWebElement(xpath).getText());
    }

    private double parseDouble(String price) throws NumberFormatException {
        return Double.parseDouble(price.replaceAll("[$,]", ""));
    }

    @Then("I calculate the price and validate cost is {string}")
    public void iCalculateThePriceAndValidateCostIs(String price) throws NumberFormatException {
        Double price_0 = getPrice("//div[@id='price-0']");
        Double quantity = Double.parseDouble(getWebElement("//input[@id='quantity-0']").getAttribute("value"));
        System.out.println("Quantity = " + quantity + "price = " + price_0);
        System.out.println("Total price =  " + getTotalPrice());
        assertEquals(price_0 * quantity, parseDouble(price), 0.0);
        assertEquals(getTotalPrice(), parseDouble(price), 0.0);
    }
}
