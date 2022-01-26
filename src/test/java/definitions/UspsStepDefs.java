package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.data.Percentage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;
import java.util.Locale;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static java.lang.Double.parseDouble;
import static support.TestContext.getDriver;

public class UspsStepDefs {

    //******* @usps1 ******* Scenario: Validate zip code for address ***************************************

    @When("I go to Lookup ZIP page by address")
    public void iGoToLookupZIPPageByAddress() throws InterruptedException {
        WebElement sendMenu = getDriver().findElement(By.xpath("//a[@id='mail-ship-width']"));
        new Actions(getDriver()).moveToElement(sendMenu).perform();
        getDriver().findElement(By.xpath("//li[@class='tool-zip']/a[contains(@href,'zip')]")).click();
        getDriver().findElement(By.xpath("//a[contains(@href,'byaddress')][contains(@class,'zip-code-home')][contains(@class,'primary')]")).click();
    }

    @And("I fill out {string} street, {string} city, {string} state")
    public void iFillOutStreetCityState(String street, String city, String state) {
        getDriver().findElement(By.xpath("//input[@id='tAddress']")).sendKeys(street);
        getDriver().findElement(By.xpath("//input[@id='tCity']")).sendKeys(city);

        WebElement selectElement = getDriver().findElement(By.xpath("//select[@id='tState']"));
        new Select(selectElement).selectByValue(state);
//      getDriver().findElement(By.xpath("//select[@id='tState']/option[@value='" + state + "']")).click();
        getDriver().findElement(By.xpath("//a[@id='zip-by-address']")).click();
    }

    @Then("I validate {string} zip code exists in the result")
    public void iValidateZipCodeExistsInTheResult(String zip) {
        WebElement resultContainer = getDriver().findElement(By.xpath("//div[@id='zipByAddressDiv']"));

        WebDriverWait wait = new WebDriverWait(getDriver(), 5);
//        wait.until(ExpectedConditions.visibilityOf(resultContainer));
//        wait.until(ExpectedConditions.textToBePresentInElement(resultContainer, zip));
        wait.until(driver -> resultContainer.getText().length() > 0);

        String resultString = resultContainer.getText();
        System.out.println(resultString);

        Assertions.assertThat(resultString).contains(zip);
    }

    //******* @usps2 ******* Scenario: Calculate price ***************************************

    @When("I go to Calculate Price Page")
    public void iGoToCalculatePricePage() {
        WebElement sendMenu = getDriver().findElement(By.xpath("//a[@id='mail-ship-width']"));
        new Actions(getDriver()).moveToElement(sendMenu).perform();
        getDriver().findElement(By.xpath("//a[contains(text(),'Calculate a Price')]")).click();
    }

    @And("I select {string} with {string} shape")
    public void iSelectWithShape(String destination, String shape) {
        WebElement selectElement = getDriver().findElement(By.xpath("//select[@id='CountryID']"));
        new Select(selectElement).selectByVisibleText(destination);
        getDriver().findElement(By.xpath("//input[@name='action'][@value='" + shape + "']")).click();
    }

    @And("I define {string} quantity")
    public void iDefineQuantity(String quantity) {
        getDriver().findElement(By.xpath("//input[@id='quantity-0']")).sendKeys(quantity);
    }

    @Then("I calculate the price and validate cost is {string}")
    public void iCalculateThePriceAndValidateCostIs(String cost) {
        getDriver().findElement(By.xpath("//input[@value='Calculate']")).click();
        String totalCost = getDriver().findElement(By.xpath("//div[@id='total']")).getText();
        Assertions.assertThat(totalCost).isEqualTo(cost);
    }

    //******* @usps3 ******* Scenario: Verify location ***************************************

    @When("I perform {string} search")
    public void iPerformSearch(String searchString) throws InterruptedException {
        //WebElement searchIcon = getDriver().findElement(By.xpath("//a[@id='navsearch']/following-sibling::a"));
        //Axes:
        //starting_tag/following-sibling::tagname[predicate]
        //starting_tag/ancestor::tagname[predicate] - all the way up

        WebElement searchIcon = getDriver().findElement(By.xpath("//a[@id='navsearch']/.."));
        WebElement searchInput = getDriver().findElement(By.xpath("//input[@id='global-header--search-track-search']"));
        //   //input[@id='global-header--search-track-search']/../input[@value='Search']

        Actions actions = new Actions(getDriver());
        actions
                .moveToElement(searchIcon)
                .sendKeys(searchInput, searchString)
                .sendKeys(Keys.ENTER)
                .perform();
        //searchInput.sendKeys(searchString + Keys.ENTER);

//        Thread.sleep(5000);
//        WebElement search = getDriver().findElement(By.xpath("//a[contains(text(),'Search USPS.com')]"));
//        new Actions(getDriver()).moveToElement(search).perform();
//        WebElement searchItem = (getDriver().findElement(By.xpath("(//a[@role='menuitem'][text()='" + searchString.toUpperCase() + "'])[1]")));
//        new Actions(getDriver()).moveToElement(searchItem).click().perform();
    }

    @And("I set {string} in filters")
    public void iSetInFilters(String filterText) {
        //WebElement filter = getDriver().findElement(By.xpath("//div[@id='dyn_nav']//label[contains(text(), 'Send')]"));
        //  WebElement filter = getDriver().findElement(By.xpath("//div[@id='dyn_nav']//label[contains(text(), '"+filterText+"')]"))

        WebDriverWait wait = new WebDriverWait(getDriver(), 5);
        By filterLocator = By.xpath("//div[@id='dyn_nav']//label[contains(text(),'" + filterText + "')]");
        wait.until(ExpectedConditions.presenceOfElementLocated(filterLocator));
        WebElement filter = getDriver().findElement(filterLocator);
        filter.click();

        WebElement spinner = getDriver().findElement(By.xpath("//div[@class='white-spinner-container']"));
        wait.until(ExpectedConditions.invisibilityOf(spinner));

//        WebElement searchResults = getDriver().findElement(By.xpath("//div[@id='dyn_nav_col']"));
//        new WebDriverWait(getDriver(), 5).until(ExpectedConditions.visibilityOf(searchResults));
//        getDriver().findElement(By.xpath("//a[@class='sub-catagory']//label[text()='" + filterText + "']")).click();
    }

    @Then("I verify that {string} results found")
    public void iVerifyThatResultsFound(String expectedTotal) {
        WebElement heading = getDriver().findElement(By.xpath("//span[@id='searchResultsHeading']"));
        Assertions.assertThat(heading.getText()).contains(expectedTotal);

        // count the results
        int expectedCount = Integer.parseInt(expectedTotal);
        List<WebElement> totalResults = getDriver().findElements(By.xpath("//ul[@id='records']/li"));
        Assertions.assertThat(totalResults.size()).isEqualTo(expectedCount);

//        String resultNum = getDriver().findElement(By.xpath("//span[@id='searchResultsHeading'][contains(text(),'" + num + "')]")).getText();
//        assertThat(resultNum).contains(expectedTotal);
    }

    @When("I select {string} in results")
    public void iSelectInResults(String result) {
        getDriver().findElement(By.xpath("//ul[@id='records']//span[text()='" + result + "']")).click();
    }

    @And("I click {string} button")
    public void iClickButton(String btnName) {
        getDriver().findElement(By.xpath("//a[contains(text(),'" + btnName + "')]")).click();

//      getDriver().findElement(By.xpath("//a[text()='" + btnName + " ']")).click();
    }

    @Then("I validate that Sign In is required")
    public void iValidateThatSignInIsRequired() {
        String originalWindow = getDriver().getWindowHandle();

        getDriver().getWindowHandles().forEach(handle -> getDriver().switchTo().window(handle));

        WebDriverWait wait = new WebDriverWait(getDriver(), 5);
        wait.until(ExpectedConditions.titleContains("Sign In"));

        getDriver().switchTo().window(originalWindow);

        // switch to new window
//        for (String handle : getDriver().getWindowHandles()) {
//            getDriver().switchTo().window(handle);
//        }
//        getDriver().findElement(By.xpath("//form[@id='loginForm']")).isDisplayed();
    }

    //******* @usps4 ******* Scenario: Every door direct mail ***************************************

    @When("I go to {string} under {string}")
    public void iGoToUnder(String subMenuItem, String menuItem) {
        WebElement menuItemElement = getDriver().findElement(By.xpath("//a[@role='menuitem'][text()='" + menuItem + "']"));
        WebElement subMenuItemElement = getDriver().findElement(By.xpath("//li/a[@role='menuitem'][text()='" + subMenuItem + "']"));
        new Actions(getDriver())
                .moveToElement(menuItemElement)
                .click(subMenuItemElement)
                .perform();
    }

    @And("I search for {string}")
    public void iSearchFor(String text) {
        getDriver().findElement(By.id("cityOrZipCode")).sendKeys(text);
        getDriver().findElement(By.cssSelector(".eddm-search-btn")).click();

        WebElement spinner = getDriver().findElement(By.id("searchProcessing"));
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(spinner));
        wait.until(ExpectedConditions.invisibilityOf(spinner));
    }

    @And("I choose view as {string} on the map")
    public void iChooseViewAsOnTheMap(String viewAs) {
        getDriver().findElement(By.xpath("//span[text()='" + viewAs + "']")).click();
    }

    @When("I select all in the table")
    public void iSelectAllInTheTable() {
        getDriver().findElement(By.id("select-all-checkboxes")).click();
    }

    @And("I close modal window")
    public void iCloseModalWindow() {
        WebElement closeModal = getDriver().findElement(By.xpath("//div[@id='drop-off-location-modal']//a[@class='close']"));
        new WebDriverWait(getDriver(), 5).until(ExpectedConditions.elementToBeClickable(closeModal));
        closeModal.click();
    }

    @Then("I verify that summary of all rows of Cost column is equal Approximate Cost in Order Summary")
    public void iVerifyThatSummaryOfAllRowsOfCostColumnIsEqualApproximateCostInOrderSummary() throws ParseException {
        Locale locale = new Locale("en", "US");
        NumberFormat formatter = NumberFormat.getCurrencyInstance(locale);
        WebDriverWait wait = new WebDriverWait(getDriver(), 5);
        String totalRoutesText = getDriver().findElement(By.id("totalRoutesSelected")).getText();
        int totalRoutes = Integer.parseInt(totalRoutesText);
        List<WebElement> costElements = getDriver().findElements(By.xpath("//table[contains(@class, 'target-audience-table')]//td[9]"));
        Assertions.assertThat(costElements.size()).isEqualTo(totalRoutes);

        double totalCostSum = 0;
        for (WebElement costElement : costElements) {
            wait.until(driver -> !costElement.getText().isEmpty());
            double costElementDouble = formatter.parse(costElement.getText()).doubleValue();
            totalCostSum = totalCostSum + costElementDouble;
        }
        System.out.println("Total calculated: " + totalCostSum);
        String approximateCostString = getDriver().findElement(By.id("approximateCost")).getText();
        double approximateCost = formatter.parse(approximateCostString).doubleValue();
        System.out.println("Approximate cost: " + approximateCost);
        Assertions.assertThat(approximateCost).isCloseTo(totalCostSum, Percentage.withPercentage(0.5));
    }
//******* @usps5 ******* Scenario: Quadcopters delivery ***************************************

    @When("I go to {string} menu tab")
    public void iGoToMenuTab(String menuTab) {
        WebElement tabOption = getDriver().findElement(By.xpath("//a[@class='menuitem' and text()='" + menuTab + "']"));
        WebElement faqs = getDriver().findElement(By.xpath("//div[@class='repos']//a[contains(@href,'faq.usps')]"));
        new Actions(getDriver())
                .moveToElement(tabOption)
                .click(faqs)
                .perform();
        WebDriverWait wait = new WebDriverWait(getDriver(), 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By
                .xpath("//div[contains(@class,'search-field-wrapper')]")));

//        getDriver().findElement(By.xpath("//a[@class='menuitem'][contains(text(),'" + menuTab + "')]")).click();
//        WebElement helpButton = getDriver().findElement(By.xpath("//a[@role='menuitem'][contains(text(), '" + menuTab + "')]"));
//        helpButton.click();
//        getDriver().getWindowHandles().forEach(handle -> getDriver().switchTo().window(handle));
//        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='135:0']")));
    }

    @And("I perform {string} help search")
    public void iPerformHelpSearch(String searchHelpString) {
        WebElement searchField = getDriver().findElement(By
                .xpath("//input[contains(@class,'uiInputTextForAutocomplete')]"));
        new Actions(getDriver())
                .sendKeys(searchField, searchHelpString)
                .sendKeys(Keys.ENTER)
                .perform();
    }

    @Then("I verify that no results of {string} available in help search")
    public void iVerifyThatNoResultsOfAvailableInHelpSearch(String arg0) {
    }

    //******* @usps6 ******* Scenario: Phone number of the nearest Mail Pickup ****************************

    @When("I navigate to {string} heading link")
    public void iNavigateToHeadingLink(String headingLink) {
        getDriver().findElement(By.xpath("//a[@id='link-locator']")).click();
    }

    @And("I search for location {string}")
    public void iSearchForLocation(String location) {
        getDriver().findElement(By.xpath("//input[@id='city-state-input']")).sendKeys(location);
        getDriver().findElement(By.xpath("//a[@id='searchLocations']")).click();
    }

    @Then("I verify closest location phone number is {string}")
    public void iVerifyClosestLocationPhoneNumberIs(String phoneNum) throws InterruptedException {
        Thread.sleep(2000);

//        By resultLocator = By.xpath("//div[@id='resultBox']");
//        WebDriverWait wait = new WebDriverWait(getDriver(), 20);
//        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(resultLocator));

        getDriver().findElement(By.xpath("//div[@id='resultBox']/div[1]")).click();

        WebElement resultString = getDriver().findElement(By.xpath("//p[@id='detailTollFree']/p"));
        Assertions.assertThat(resultString.getText()).contains(phoneNum);
    }
}