package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;
import static support.TestContext.getDriver;

public class UspsStepDefs {
    WebDriverWait wait = new WebDriverWait(getDriver(), 5);

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
//        getDriver().findElement(By.xpath("//select[@id='tState']/option[@value='" + state + "']")).click();
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

        assertThat(resultString).contains(zip);
    }

    @When("I perform {string} search")
    public void iPerformSearch(String searchString) {
        // Axes:
        //starting_tag/following-sibling::tagname[predicate]
        //starting_tag/ancestor::tagname[predicate]

        WebElement searchIcon = getDriver().findElement(By.xpath("//a[@id='navsearch']/.."));
        WebElement searchInput = getDriver().findElement(By.xpath("//input[@id='global-header--search-track-search']"));
        //input[@id='global-header--search-track-search']/../input[@value='Search']

        Actions actions = new Actions(getDriver());
        actions
                .moveToElement(searchIcon)
                .sendKeys(searchInput, searchString)
                .sendKeys(Keys.ENTER)
                .perform();
    }

    @And("I set {string} in filters")
    public void iSetInFilters(String filterText) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(getDriver(), 5);
        By filterLocator = By.xpath("//div[@id='dyn_nav']//label[contains(text(),'" + filterText + "')]");
        wait.until(presenceOfElementLocated(filterLocator));
        WebElement filter = getDriver().findElement(filterLocator);
        filter.click();

        WebElement spinner = getDriver().findElement(By.xpath("//div[@class='white-spinner-container']"));
        wait.until(invisibilityOf(spinner));
    }

    @Then("I verify that {string} results found")
    public void iVerifyThatResultsFound(String expectedTotal) {
        WebElement heading = getDriver().findElement(By.xpath("//span[@id='searchResultsHeading']"));
        assertThat(heading.getText()).contains(expectedTotal);

        int expectedCount = Integer.parseInt(expectedTotal);
        List<WebElement> totalResults = getDriver().findElements(By.xpath("//ul[@id='records']/li"));
        assertThat(totalResults.size()).isEqualTo(expectedCount);
    }

    @When("I select {string} in results")
    public void iSelectInResults(String result) {
        getDriver().findElement(By.xpath("//ul[@id='records']//span[text()='" + result + "']")).click();
    }

    @And("I click {string} button")
    public void iClickButton(String title) {
        getDriver().findElement(By.xpath("//a[contains(text(),'" + title + "')]")).click();
    }

    @Then("I validate that Sign In is required")
    public void iValidateThatSignInIsRequired() throws InterruptedException {
        String originalWindow = getDriver().getWindowHandle();

        getDriver().getWindowHandles().forEach(handle -> getDriver().switchTo().window(handle));

        WebDriverWait wait = new WebDriverWait(getDriver(), 5);
        wait.until(titleContains("Sign In"));

        getDriver().switchTo().window(originalWindow);
    }

    @When("I go to {string} under {string}")
    public void iGoToUnder(String mailType, String tabName) {
        WebElement tabOnPage = getDriver().findElement(By.xpath("//ul[@class='nav-list']//following-sibling::a[contains(text(), '" + tabName + "')][2]"));
        new Actions(getDriver()).moveToElement(tabOnPage).perform();
        getDriver().findElement(By.xpath("//a[contains(text(),'" + mailType + "')]")).click();
    }

    @And("I search for {string}")
    public void iSearchFor(String addressToSearch) throws InterruptedException {
        getDriver().findElement(By.xpath("//input[@id='cityOrZipCode']")).sendKeys(addressToSearch);
        getDriver().findElement(By.xpath("//a[@role='button'][contains(text(), 'Search')]")).click();
    }

    @And("I choose view as {string} on the map")
    public void iChooseViewAsOnTheMap(String viewType) {
        WebElement spinner = getDriver().findElement(By.xpath("//div[@class='white-spinner-container']"));
        wait.until(invisibilityOf(spinner));

        getDriver().findElement(By.xpath("//span[contains(text(), '" + viewType + "')]")).click();
    }

    @When("I select all in the table")
    public void iSelectAllInTheTable() {
        getDriver().findElement(By.xpath("//input[@id='select-all-checkboxes']")).click();
    }

    @And("I close modal window")
    public void iCloseModalWindow() {
        getDriver().findElement(By.xpath("//a[@id='closeAndUpdateTotals']")).click();
    }

    @Then("I verify that summary of all rows of Cost column is equal Approximate Cost in Order Summary")
    public void iVerifyThatSummaryOfAllRowsOfCostColumnIsEqualApproximateCostInOrderSummary() {
        List<WebElement> totalResult = getDriver().findElements(By.xpath("//tr/descendant::td[9]"));
        Double sum = 0.0;
        for (WebElement el : totalResult) {
            Double elInDouble = Double.parseDouble(el.getText().replace("$", ""));
            System.out.println(elInDouble);
            sum += elInDouble;
        }
        Double approximateCost = Double.parseDouble(getDriver().findElement(By.xpath("//p[@id='approximateCost']"))
                .getText()
                .replace("$", ""));
        System.out.println("sum = " + new DecimalFormat("###.00").format(sum) + ", approximateCost = " + new DecimalFormat("###.00").format(approximateCost));
        assertEquals(new DecimalFormat("###.00").format(sum), new DecimalFormat("###.00").format(approximateCost));
    }

//HOMEWORK 12 task3
    @When("I go to {string} tab")
    public void iGoToTab(String tabName) {
        getDriver().findElement(By.xpath("//ul[@role='menubar']//a[text()= '"+tabName+"']")).click();
    }

    @And("I perform {string} help search")
    public void iPerformHelpSearch(String searchValue) throws InterruptedException {
        wait.until(presenceOfElementLocated(By.xpath("//input[contains(@class,'search-field input')]")));
        getDriver().findElement(By.xpath("//input[contains(@class,'search-field input')]")).sendKeys(searchValue);
        getDriver().findElement(By.xpath("//input[contains(@class,'search-field input')]")).sendKeys(Keys.ENTER);

    Thread.sleep(5000);
    }

    @Then("I verify that no results of {string} available in help search")
    public void iVerifyThatNoResultsOfAvailableInHelpSearch(String expect) {
        String result = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='resultsWrapper']//div[@class='listContent']"))).getText();
        int sizeResultList = getDriver().findElements(By.xpath("//ul[@class='slds-has-dividers--bottom']/li")).size();
        WebElement button = getDriver().findElement(By.xpath("//button[@class='slds-button slds-button_brand']"));
        //Assertions.assertThat(sizeResultList).isEqualTo(0);
        Assertions.assertThat(result).contains(expect);

    }


//    HOMEWORK 12 task4
    @When("I navigate to {string} heading link")
    public void iNavigateToHeadingLink(String utilityLinksBar) {
        getDriver().findElement(By.xpath("//a[@id='link-locator'][@href='https://tools.usps.com/find-location.htm']")).click();
    }

    @And("I search for location {string}")
    public void iSearchForLocation(String addressToSearch) {
        getDriver().findElement(By.xpath("//input[@id='city-state-input']")).sendKeys(addressToSearch);
        getDriver().findElement(By.xpath("//a[@id='searchLocations']")).click();
    }

    @Then("I verify closest location phone number is {string}")
    public void iVerifyClosestLocationPhoneNumberIs(String tellNumber) throws InterruptedException{
        getDriver().findElement(By.xpath("//div[@id='1370964']")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[@id='detailTollFree']")));
        WebElement addressSearchResult = getDriver().findElement(By.xpath("//p[@id='detailTollFree']"));
//        WebElement addressSearcResult = getDriver().findElements(By.xpath("//div[@id='1370964']/descendant::p[contains(text(),'"+tellNumber+"')]"));
        assertThat(addressSearchResult.getText()).contains(tellNumber);
    }

}