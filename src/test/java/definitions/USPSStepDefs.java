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

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.*;
import java.util.stream.Collectors;

import static definitions.PredefinedStepDefs.iClickOnElementUsingJavaScriptWithXpath;
import static java.lang.System.out;
import static java.lang.Thread.sleep;
import static org.junit.Assert.*;
import static org.openqa.selenium.Keys.ENTER;
import static org.openqa.selenium.Keys.TAB;
import static support.TestContext.getDriver;


public class USPSStepDefs extends HelperStepDefs {
    public static final String MOBILE_HAMBURGER_ACTIVE_DROPDOWN_MENU_XPATH = "//a[@class='mobile-hamburger active']";
    public static final String INPUT_CONTAINS_CLASS_SEARCH_FIELD = "//input[contains(@class,'search-field')]";
    public static final String FIND_USPS_LOCATIONS_SEARCH_BUTTON = "//a[@id='searchLocations']";
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
    public static final String NAVIGATION_SEARCH_ICON_XPATH = "//li[@class='nav-search menuheader']//a[@class='menuitem']";
    public static final String NAVIGATION_SEARCH_ICON_MENU_ACTIVE_XPATH = "//li[@class='nav-search menuheader']//a[@class='menuitem active']";
    public static final String CLASS_REQUIRED_XPATH = "//div[@id='sign-in-wrap']//span[@class='required']";
    public static final String LOGIN_REGISTER_HEADER_XPATH = "//a[@id='login-register-header']";
    public static final String NEXT_TO_CLICK_XPATH = "//ul[@class='pagination']/li[@class='page-item active']/a/following::li[@class='page-item']/a[1]";
    public static final String RECORD_URL_XPATH = "//div[@class='search-results']/ul/li/p/a[contains(@class,'record-url')]";
    public static final String NEXT_DISABLE_PAGINATION_XPATH = "//ul[@class='pagination']/li[@class='next disabled']/a";
    public static final String NO_RESULTS_SEARCH_IMG_XPATH = "//img[contains(@src,'no-results')]";
    public static final String LIST_EACH_SEARCH_RESULTS_XPATH = "//div[@class='listContent']//knowledgeui-result-stencil";
    public static final String LIST_OF_SEARCH_RESULTS_XPATH = "//div[@class='listContent']//ul[@class='slds-has-dividers--bottom']//li[contains(@class,'kbResultStencil')]";
    public static final String FIELD_NON_EMPTY_SEARCH_CONTENT_XPATH = "//div[@class='listContent']//ul[@class='slds-has-dividers--bottom']";
    public static final String NO_RESULTS_TITLE = "//div[contains(@class,'noResultsTitle')]";
    public static final String EMPTY_SEARCH_CONTENT_XPATH = "//div[contains(@class,'showEmptyContent')]//div[@class='emptyListContent']";
    public static final String FIND_USPS_LOCATION = "//input[@id='city-state-input']";
    public static final String ASK_USPS_PHONE_XPATH = "//p[@class='ask-usps']";
    public static final String LIST_USPS_OFFICE_H2_XPATH = "//div[@class='location-address']/h2";
    public static final String LINK_LOCATOR_LOCATIONS_XPATH = "//a[@id='link-locator']";
    public static final String LIST_ITEM_LOCATION = "//div[contains(@class,'list-item-location')]";
    public static final String SHOW_MORE_BUTTON_XPATH = "//div[contains(@class,'slds-text-align--center')]/button[@type='button']";
    private final WebDriverWait wait = new WebDriverWait(getDriver(), 10, 200);


    @When("I go to Lookup ZIP page by address")
    public void iGoToLookupZIPPageByAddress() throws Error {
        if ((getWebElement(NAV_LIST_XPATH).isDisplayed())) {
            out.println("I run from Navigation list menu");
            iGoToLookupZIPPageByAddressThroughNavigationPanel();

        } else if ((getWebElement(A_CLASS_MOBILE_HAMBURGER_IMG_XPATH)).isDisplayed()) {
            out.println("I run from hamburger menu");
            iGoToLookupZIPPageByAddressThroughHamburgerMenuBar();

        } else if (getWebElement(QUICK_TOOL_TRACK_OPTION_XPATH).isDisplayed()) {
            iGoToLookupZIPPageByAddressBySetWindowSize();
        } else
            throw new Error("There is no Navigation panel, hamburger menu or Quick Options panel in the USPS start page.");
    }

    public void iGoToLookupZIPPageByAddressBySetWindowSize() {
        out.println("I run from resizing initial window and Quick Tool Option panel ");
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
                    out.println(el.getText());
                });
    }

    @When("I go to Lookup ZIP page by address with resizing initial window and Quick Tool Tracking options panel")
    public void iGoToLookupZIPPageByAddressWithResizingInitialWindowAndQuickToolTrackingOptionsPanel() {
        iGoToLookupZIPPageByAddressBySetWindowSize();
    }

    @When("I go to Lookup ZIP page by address through navigation panel")
    public void iGoToLookupZIPPageByAddressThroughNavigationPanel() {
        if ((getWebElement(NAV_LIST_XPATH).isDisplayed())) {
            out.println("I run from Navigation panel menu");
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
            out.println("I run from hamburger menu");
            click(A_CLASS_MOBILE_HAMBURGER_IMG_XPATH);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(MOBILE_HAMBURGER_ACTIVE_DROPDOWN_MENU_XPATH)));
            click(NAVQUICKTOOLS_A_ARIA_EXPANDED_FALSE_XPATH);
            getWebElementFromListByAttributeValue(NAVQICKTOOLS_MENU_ITEM_XPATH, "alt", ZIPCODE_LOOK_UP_ICON_NAVIGATION_QUICKTOOLS_TEXT).click();
            iClickByAddress();
        } else throw new Error("Hamburger panel is not displayed in USPS page");
    }

    @When("I go to Calculate Price Page")
    public void iGoToCalculatePricePage() {
        out.println("I run from resizing initial window and Quick Tool Option panel ");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(QUICK_TOOL_TRACK_OPTION_BUTTON_LINK_XPATH)));
        setSize(700, 700);
        getWebElementFromListByAttributeValue(QUICK_TOOL_TRACK_OPTION_BUTTON_LINK_XPATH, "data-gtm-label", "calculate-price-link").click();
    }

    @And("I select {string} with {string} shape")
    public void iSelectWithShape(String destination, String shape) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(CALCULATOR_DESTINATION_SELECT_XPATH)));
        new Select(getDriver().findElement(By.xpath(CALCULATOR_DESTINATION_SELECT_XPATH)))
                .selectByVisibleText(destination);
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
        out.println("Quantity = " + quantity + "price = " + price_0);
        out.println("Total price =  " + getTotalPrice());
        assertEquals(price_0 * quantity, parseDouble(price), 0.0);
        assertEquals(getTotalPrice(), parseDouble(price), 0.0);
    }

    @When("I perform {string} search")
    public void iPerformSearch(String searchText) {
        assertTrue(getWebElement(LOGIN_REGISTER_HEADER_XPATH).getText().contains("Sign In"));
        if ((getWebElement(NAVIGATION_SEARCH_ICON_XPATH).isDisplayed())) {
            out.println("I run from Navigation panel menu");
            new Actions(getDriver())
                    .moveToElement(getWebElement(NAVIGATION_SEARCH_ICON_XPATH))
                    .click()
                    .perform();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(NAVIGATION_SEARCH_ICON_MENU_ACTIVE_XPATH)));

            WebElement webElement = getWebElementFromListByPartOfAttributeValue("//div[@class='repos']//div[@class='empty-search']//ul/li/a[@role='menuitem']", "href", searchText.replace(" ", "%20"));

            new Actions(getDriver()).moveToElement(webElement)
                    .click()
                    .perform();
        } else throw new Error("Navigation panel doesn't display in start USPS page");
    }

    @And("I set {string} in filters")
    public void iSetInFilters(String checkboxTitle) {
        wait.until(ExpectedConditions.elementToBeClickable(getWebElementFromListByAttributeValue("//p[@class='checkbox-container dn-attr-a']", "title", checkboxTitle)));
        if (getDriver().findElements(By.xpath("//p[@class='checkbox-container dn-attr-a'][@title='" + checkboxTitle + "']//input[@checked]")).size() == 0) {
            getDriver()
                    .findElements(By.xpath("//p[@class='checkbox-container dn-attr-a']"))
                    .stream()
                    .filter(el -> el.getAttribute("title").contains(checkboxTitle))
                    .collect(Collectors.toList())
                    .get(0).click();
        }
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@id='searchResultsHeading']"))));
    }

    @When("I select {string} in results")
    public void iSelectInResults(String linkText) {
        getDriver().findElements(By.xpath("//ul[@id='records']//span/span"))
                .stream()
                .filter(el -> el.getText().contains(linkText))
                .collect(Collectors.toList())
                .get(0).click();
    }

    @And("I click {string} button")
    public void iClickButton(String button) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class='button--primary']")));
        List<String> windowHandle = getDriver().getWindowHandles().stream().toList();
        int openedWindowsBefore = windowHandle.size();
        getWebElement("//a[@class='button--primary']").click();
        assertEquals(openedWindowsBefore + 1, getDriver().getWindowHandles().size());
    }

    @Then("I validate that Sign In is required")
    public void iValidateThatSignInIsRequired() {
        if (!getDriver().getTitle().contains("Sign In".toLowerCase(Locale.ROOT))) {
            for (String handle : getDriver().getWindowHandles()) {
                getDriver().switchTo().window(handle);
            }
            assertTrue(getWebElement(CLASS_REQUIRED_XPATH).isDisplayed());
        }
    }

    @Then("I verify that {string} results found")
    public void iVerifyThatResultsFound(String searchResults) throws InterruptedException {
        out.println("search Results: " + getText("//span[@id='searchResultsHeading']"));
        assertEquals(Arrays.stream(getText("//span[@id='searchResultsHeading']").split(" ")).toList().get(0), searchResults);
        if (getDriver().findElements(By.xpath("//ul[@class='pagination']/li[@class='page-item']")).size() == 0) {
            assertEquals(getDriver().findElements(By.xpath("//div[@class='search-results']/ul/li")).size(), Integer.parseInt(searchResults));
        } else
            assertTrue(getDriver().findElements(By.xpath("//div[@class='search-results']/ul/li")).size() <= Integer.parseInt(searchResults));
        iAmCountingSearchResults();
    }

    private int iAmCountingSearchResults() throws InterruptedException {
        int counts = resultsInThePage();
        while ((getDriver().findElements(By.xpath(NEXT_DISABLE_PAGINATION_XPATH)).size() == 0)) {
            new Actions(getDriver())
                    .moveToElement(getDriver().findElement(By.xpath(NEXT_TO_CLICK_XPATH)))
                    .sendKeys(TAB)
                    .sendKeys(TAB)
                    .perform();
            getDriver().findElement(By.xpath(NEXT_TO_CLICK_XPATH)).click();
            wait.until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath(RECORD_URL_XPATH))));
            if (getDriver().findElements(By.xpath(NEXT_TO_CLICK_XPATH)).size() > 0) {
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath(NEXT_TO_CLICK_XPATH)));
            }
            sleep(3000);  //because of Rate limiting of USPS site
            counts += resultsInThePage();
        }
        out.println("Found results: " + counts);
        return counts;
    }

    private int resultsInThePage() {
        List<WebElement> results = getDriver().findElements(By.xpath(RECORD_URL_XPATH));
        return results.size();
    }

    @When("I go to {string} under {string}")
    public void iGoToUnder(String toolsSubMenuItem, String menuItem) {
        new Actions(getDriver())
                .moveToElement(
                        getDriver().findElement(By.xpath("//a[@class='menuitem'][contains(@href,'" + menuItem.toLowerCase(Locale.ROOT) + "')]")))
                .perform();
        new Actions(getDriver())
                .moveToElement(
                        getDriver().findElement(By.xpath("//a[@role='menuitem'][contains(text(),'" + toolsSubMenuItem + "')]")))
                .click()
                .perform();
        wait.until(ExpectedConditions.textToBePresentInElement(getDriver().findElement(By.xpath("//div[contains(@class,'main-header')]/h1")), toolsSubMenuItem));
    }

    @And("I search for {string}")
    public void iSearchFor(String address) {
        getDriver().findElement(By.xpath("//input[@id='cityOrZipCode']")).sendKeys(address);
        getDriver().findElement(By.xpath("//a[@role='button'][contains(@class,'search-btn')]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='searchProcessing']//div[@class='spinner-content']/h5")));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='searchProcessing']//div[@class='spinner-content']/h5")));
    }

    @And("I choose view as {string} on the map")
    public void iChooseViewAsOnTheMap(String viewAs) {
        new Actions(getDriver())
                .moveToElement(getDriver().findElement(By.xpath("//span[@class='table-view-icon'][contains(text(),'" + viewAs + "')]")))
                .click()
                .click()
                .perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[contains(@class,'target-audience-table')]")));
    }

    @When("I select all in the table")
    public void iSelectAllInTheTable() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//table[contains(@class,'target-audience-table')]/tbody")));
        new Actions(getDriver())
                .moveToElement(getDriver().findElement(By.xpath("//input[@id='select-all-checkboxes']//../span")))
                .click()
                .perform();
    }

    @And("I close modal window")
    public void iCloseModalWindow() {
        assertTrue(getDriver().findElement(By.xpath("//div[@id='drop-off-location-modal']/div[@class='modal-dialog medium']")).isDisplayed());
        new Actions(getDriver())
                .moveToElement(getDriver().findElement(By.xpath("//a[@id='closeAndUpdateTotals']")))
                .click()
                .perform();
        assertFalse(getDriver().findElement(By.xpath("//div[@id='drop-off-location-modal']/div[@class='modal-dialog medium']")).isDisplayed());
    }

    @Then("I verify that summary of all rows of Cost column is equal Approximate Cost in Order Summary")
    public void iVerifyThatSummaryOfAllRowsOfCostColumnIsEqualApproximateCostInOrderSummary() {
        List<WebElement> costList = getDriver().findElements(By.xpath("//table[contains(@class,'target-audience-table')]/tbody/tr/td[9]/p"));
        BigDecimal sum = new BigDecimal(0);
        for (WebElement el : costList) {
            sum = sum.add(new BigDecimal(el.getText().replace("$", "")));
        }
        BigDecimal approximateCost = new BigDecimal(getDriver().findElement(By.xpath("//p[@id='approximateCost']")).getText().replace("$", ""));
        assertEquals(sum.toString(), approximateCost.toString());
    }

    @When("I go to {string} tab")
    public void iGoToTab(String menuItem) {
        getDriver().findElement(By.xpath("//a[@role='menuitem'][contains(text(),'" + menuItem + "')]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(INPUT_CONTAINS_CLASS_SEARCH_FIELD)));
    }

    @And("I perform {string} help search")
    public void iPerformHelpSearch(String searchQuery) {
        getDriver().findElement(By.xpath(INPUT_CONTAINS_CLASS_SEARCH_FIELD)).sendKeys(searchQuery);
        new Actions(getDriver())
                .sendKeys(ENTER)
                .perform();
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(FIELD_NON_EMPTY_SEARCH_CONTENT_XPATH)));
    }

    @Then("I verify that {string} results of {string} available in help search")
    public void iVerifyThatResultsOfAvailableInHelpSearch(String doWeHaveResultsAvailable, String searchQuery) {
        if (doWeHaveResultsAvailable.toLowerCase(Locale.ROOT).equals("no")) {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(NO_RESULTS_SEARCH_IMG_XPATH)));
            assertEquals(getDriver().findElements(By.xpath(LIST_EACH_SEARCH_RESULTS_XPATH)).size(), 0);
            assertTrue(getDriver().findElement(By.xpath(EMPTY_SEARCH_CONTENT_XPATH)).isDisplayed());
            assertTrue(getDriver().findElement(By.xpath(NO_RESULTS_SEARCH_IMG_XPATH)).isDisplayed());
            out.println(getDriver().findElement(By.xpath(NO_RESULTS_TITLE)).getText());
        } else {
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(LIST_OF_SEARCH_RESULTS_XPATH)));
            assertTrue(getDriver().findElements(By.xpath(LIST_EACH_SEARCH_RESULTS_XPATH)).size() > 0);
            String text = getDriver().findElement(By.xpath(FIELD_NON_EMPTY_SEARCH_CONTENT_XPATH)).getText();
            assertTrue(text.contains(searchQuery)
                    || Arrays
                    .stream(searchQuery.split(" ")).anyMatch(text::contains));
            out.println(MessageFormat.format("We''ve found {0} results", getDriver().findElements(By.xpath(LIST_EACH_SEARCH_RESULTS_XPATH)).size()));
        }
    }

    @When("I navigate to {string} heading link")
    public void iNavigateToHeadingLink(String menuItem) {
        getDriver()
                .findElements(By.xpath(LINK_LOCATOR_LOCATIONS_XPATH)).forEach(WebElement::click);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FIND_USPS_LOCATION)));
    }

    @And("I search for location {string}")
    public void iSearchForLocation(String location) {
        getDriver().findElement(By.xpath(FIND_USPS_LOCATION)).sendKeys(location);
        getDriver().findElement(By.xpath(FIND_USPS_LOCATIONS_SEARCH_BUTTON)).click();
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(LIST_ITEM_LOCATION)));
    }

    @Then("I verify closest location phone number is {string}")
    public void iVerifyClosestLocationPhoneNumberIs(String phone) {
        wait.until(ExpectedConditions.elementToBeClickable
                        (getDriver().findElements(By.xpath(LIST_USPS_OFFICE_H2_XPATH)).get(0)))
                .click();
        wait.until(ExpectedConditions.elementToBeClickable
                (getDriver().findElements(By.xpath(LIST_USPS_OFFICE_H2_XPATH)).get(0)));
        String actual = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ASK_USPS_PHONE_XPATH))).getText();
        assertTrue(actual.contains(phone));
    }

    private boolean isContains(String searchQuery) {
        return getDriver().findElement(By.xpath("//div[@class='listContent']//li[contains(@class,'kbResultStencil')]/..")).getText().contains(searchQuery);
    }

    @Then("I verify that no results of {string} available in help search")
    public void iVerifyThatResultsOfAvailableInHelpSearch(String searchQuery) {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(LIST_OF_SEARCH_RESULTS_XPATH)));
        assertTrue(getDriver().findElements(By.xpath(LIST_EACH_SEARCH_RESULTS_XPATH)).size() > 0);
        Map<Integer, String> resultsMap = new HashMap<>();
        List<String> links = new ArrayList<>();
        while ((getDriver().findElement(By.xpath("//button[contains(text(),'Show More')]")).isDisplayed()) && (!isContains(searchQuery))) {
            getDriver().findElements(By.xpath("//div[@class='listContent']//ul[@class='slds-has-dividers--bottom']//li[contains(@class,'kbResultStencil')]//a")).forEach(el -> {
                new Actions(getDriver()).moveToElement(el).perform();
                resultsMap.put(
                        getDriver().findElements(By.xpath("//div[@class='listContent']//ul[@class='slds-has-dividers--bottom']//li[contains(@class,'kbResultStencil')]//a")).indexOf(el),
                        el.getAttribute("href"));
                links.add(el.getAttribute("href"));
                links.iterator().hasNext();
            });
            out.println(resultsMap);
            iClickOnElementUsingJavaScriptWithXpath("//button[contains(text(),'Show More')]");
            out.println(getDriver().findElement(By.xpath("//div[contains(@class,'searchResultsGridHeader')]")).getText());
            wait.until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='listContent']//li[contains(@class,'kbResultStencil')]/.."))));
        }
        assertFalse(isContains(searchQuery));
        out.println("We've found " + getDriver().findElements(By.xpath(LIST_OF_SEARCH_RESULTS_XPATH)).size() + " results");
    }

}


