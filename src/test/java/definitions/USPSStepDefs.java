package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import support.TestContext;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.openqa.selenium.support.ui.ExpectedConditions.not;
import static support.TestContext.getDriver;

public class USPSStepDefs {

    WebElement container;

    @When("I go to Lookup ZIP page by address")
    public void iGoToLookupZIPPageByAddress() {
        getDriver().findElement(By.xpath("//a[normalize-space()='Quick Tools']")).click();
        getDriver().findElement(By.xpath("//a[@name='navquicktools']/..//a[contains(normalize-space(),'Look Up a') and contains(normalize-space(),'ZIP Code')]")).click();
        waitForElements(5,"//a[normalize-space()='Find by Address']");
        getDriver().findElement(By.xpath("//a[normalize-space()='Find by Address']")).click();
    }

    @And("I fill out {string} street, {string} city, {string} state")
    public void iFillOutStreetCityState(String sStreet, String sCity, String sState) {
        getDriver().findElement(By.xpath("//input[@id='tAddress']")).sendKeys(sStreet);
        getDriver().findElement(By.xpath("//input[@id='tCity']")).sendKeys(sCity);
        getDriver().findElement(By.xpath("//select[@id='tState']")).click();
        getDriver().findElement(By.xpath("//select[@id='tState']/option[@value='" + sState + "']")).click();
    }

    @And("I click button Find")
    public void iClickButtonFind() {
        getDriver().findElement(By.xpath("//a[@id='zip-by-address']")).click();
    }

    @And("I wait result being loaded")
    public void iWaitResultBeingLoaded() {
        waitForElements(5,"//div[@class='zipcode-result-address']");
    }

    public void waitForElements(int iSeconds, String sXPath) {
        WebDriverWait wait = new WebDriverWait(getDriver(),iSeconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sXPath)));
    }

    @Then("I validate {string} zip code exists in the result")
    public void iValidateZipCodeExistsInTheResult(String sZipCode) {
        boolean isExist = false;
        List<WebElement> lItems = getDriver().findElements(By.xpath("//div[@class='zipcode-result-address']"));
        for (WebElement el : lItems) {
            if (el.getText().contains(sZipCode)){
                isExist = true;
                System.out.println(el.getText());
                break;
            }
        }
        assertThat(isExist).isTrue();
    }

    @And("I go back to search form")
    public void iGoBackToSearchForm() {
        getDriver().findElement(By.xpath("//div[@id='zip-lookup-app']//div[@class='button-container']/a[@title='byaddress']")).click();
    }

    @When("I go to Calculate Price page")
    public void iGoToCalculatePricePage() {
        new Actions(getDriver()).moveToElement(getDriver().findElement(By.xpath("//a[@id='mail-ship-width']"))).perform();
        getDriver().findElement(By.xpath("//a[normalize-space()='Calculate a Price' and ancestor::ul/h3[normalize-space()='Tools']]")).click();
    }

    @And("I select {string} with {string} shape")
    public void iSelectWithShape(String sDestination, String sShape) {
        WebElement destination = getDriver().findElement(By.xpath("//select[@id='CountryID']"));
        new Select(destination).selectByVisibleText(sDestination);
        getDriver().findElement(By.xpath("//input[@value='Postcard']")).click();
    }

    @And("I define {string} quantity")
    public void iDefineQuantity(String sQnt) {
        getDriver().findElement(By.xpath("//input[@placeholder='Quantity']")).sendKeys(sQnt);
    }

    @Then("I calculate the price and validate cost is {string}")
    public void iCalculateThePriceAndValidateCostIs(String sTotal) {
        getDriver().findElement(By.xpath("//input[@value='Calculate']")).click();
        assertThat(getDriver().findElement(By.xpath("//div[@id='total']")).getText()).isEqualTo(sTotal);
    }

    @When("I perform {string} search")
    public void iPerformSearch(String sSearch) {
        new Actions(getDriver()).moveToElement(getDriver().findElement(By.xpath("//a[normalize-space()='Search USPS.com']"))).perform();
        getDriver().findElement(By.xpath("//a[normalize-space()='" + sSearch.toUpperCase() + "' and ancestor::nav//div/p[normalize-space()='Top Searches']]")).click();
    }

    public void waitForSpinnerDisappear(int iSeconds) {
        WebElement spinner = getDriver().findElement(By.xpath("//div[@class='white-spinner-wrapper']"));
        WebDriverWait wait = new WebDriverWait(getDriver(),iSeconds);
        wait.until(ExpectedConditions.invisibilityOf(spinner));
    }

    @And("I set {string} in filters")
    public void iSetInFilters(String sFilter) {
        waitForSpinnerDisappear(10);
        getDriver().findElement(By.xpath("//label[contains(normalize-space(),'" + sFilter + "')]")).click();
        waitForSpinnerDisappear(10);
    }

    @Then("I verify that {string} results found")
    public void iVerifyThatResultsFound(String sResultsAmount) {
        assertThat(getDriver().findElement(By.xpath("//span[@id='searchResultsHeading']")).getText()).contains(sResultsAmount + " results found for");
    }

    @When("I select {string} in results")
    public void iSelectInResults(String sSelect) {
        getDriver().findElement(By.xpath("//span[normalize-space()='" + sSelect + "']/ancestor::a")).click();
        waitForElements(10, "//a[contains(normalize-space(),'Ship Now')]");
    }

    @And("I click {string} button")
    public void iClickButton(String sButton) {
        getDriver().findElement(By.xpath("//a[contains(normalize-space(),'" + sButton + "')]")).click();
    }

    @Then("I validate that Sign In is required")
    public void iValidateThatSignInIsRequired() throws InterruptedException {
        assertThat(isSignInPageOpened()).isTrue();
    }

    public Boolean isSignInPageOpened() throws InterruptedException {
        for (String handle : getDriver().getWindowHandles()) {
            getDriver().switchTo().window(handle);
            WebDriverWait wait = new WebDriverWait(getDriver(),5);
            if (getDriver().getTitle().contains("Sign In")) {
                wait.until(ExpectedConditions.visibilityOf(getDriver().findElement(By.xpath("//h1[normalize-space()='Sign In To Your Account']"))));
                return true;
            }
        }
        return false;
    }

    @When("I go to {string} under {string}")
    public void iGoToUnder(String sChildMenu, String sParentMenu) {
        new Actions(getDriver()).moveToElement(getDriver().findElement(By.xpath("//a[normalize-space()='" + sParentMenu + "']"))).perform();
        getDriver().findElement(By.xpath("//a[normalize-space()='" + sChildMenu + "' and ancestor::ul/h3[normalize-space()='Tools']]")).click();
        waitForElements(5, "//input[@id='cityOrZipCode']");
    }

    @And("I search for {string}")
    public void iSearchFor(String sAdr) {
        getDriver().findElement(By.xpath("//input[@id='cityOrZipCode']")).sendKeys(sAdr);
        getDriver().findElement(By.xpath("//a[normalize-space()='Search' and @role='button']")).click();
        waitForSpinnerDisappear(30);
    }

    @And("I choose view as {string} on the map")
    public void iChooseViewAsOnTheMap(String sView) {
        getDriver().findElement(By.xpath("//span[normalize-space()='" + sView + "']/..")).click();
        WebDriverWait tableResult = new WebDriverWait(getDriver(), 5);
        tableResult.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//table[contains(@class,'target-audience-table')]/tbody")));
    }

    @When("I select all in the table")
    public void iSelectAllInTheTable() {
        getDriver().findElement(By.xpath("//input[@id='select-all-checkboxes']")).click();
        waitForElements(5, "//div[@id='drop-off-location-modal']");
    }

    @And("I close modal window")
    public void iCloseModalWindow() {
        WebDriverWait modalWait = new WebDriverWait(getDriver(), 5);
        modalWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@id='drop-off-location-modal']")));
        WebElement button = getDriver().findElement(By.xpath("//a[@id='closeAndUpdateTotals']"));
        new Actions(getDriver()).moveToElement(button).click().perform();
        modalWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='drop-off-location-modal']")));
    }

    @Then("I verify that summary of all rows of Cost column is equal Approximate Cost in Order Summary")
    public void iVerifyThatSummaryOfAllRowsOfCostColumnIsEqualApproximateCostInOrderSummary() {
        WebDriverWait tableResult = new WebDriverWait(getDriver(), 5);
        tableResult.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//table[contains(@class,'target-audience-table')]/tbody")));
        List<WebElement> lItems = getDriver().findElements(By.xpath("//table[contains(@class,'target-audience-table')]/tbody/tr/td[9]/p"));
        double sum = 0.0;
        for (WebElement el : lItems) {
            sum += Double.parseDouble(el.getText().replace("$", ""));
        }
        DecimalFormatSymbols dFS = new DecimalFormatSymbols();
        dFS.setDecimalSeparator('.');
        DecimalFormat dF = new DecimalFormat("#.##", dFS);
        assertThat(getDriver().findElement(By.xpath("//p[@id='approximateCost']")).getText()).contains(dF.format(sum));
    }

    @When("I go to {string} tab")
    public void iGoToTab(String sTab) {
//        waitForElements(10, "//li[@class='menuheader']/a[normalize-space()='" + sTab + "']");
        getDriver().findElement(By.xpath("//li[@class='menuheader']/a[normalize-space()='" + sTab + "']")).click();
        waitForElements(5, "//div[contains(@class,'acn-page-layout-container-body')]");
    }

    @And("I perform {string} help search")
    public void iPerformHelpSearch(String sSearchText) {
        getDriver().findElement(By.xpath("//input[@placeholder='Search for a topic']")).sendKeys(sSearchText);
        getDriver().findElement(By.xpath("//button[@title='Search' and contains(@class,'search-button')]")).click();
        waitForElements(10, "//div[contains(@class,'searchResultsGridHeader')]");
    }

    @Then("I verify that no results of {string} available in help search")
    public void iVerifyThatNoResultsOfAvailableInHelpSearch(String sSearchText) {
        assertThat(getDriver().findElement(By.xpath("//div[@class='resultsWrapper']")).getText()).doesNotContain(sSearchText);
    }

    @When("I navigate to {string} heading link")
    public void iNavigateToHeadingLink(String sNavLink) {
        getDriver().findElement(By.xpath("//a[@id='link-locator']")).click();
        waitForElements(5, "//input[@id='city-state-input']");
    }

    @And("I search for location {string}")
    public void iSearchForLocation(String sSearch) {
        container = getDriver().findElement(By.xpath("//div[@class='po-location']"));
        container.findElement(By.xpath("//input[@id='city-state-input']")).sendKeys(sSearch);
        By buttonSearch = By.xpath("//a[@id='searchLocations']");
        new WebDriverWait(getDriver(), 5, 1).until(ExpectedConditions.elementToBeClickable(buttonSearch));
//        container.findElement(buttonSearch).click();
        new Actions(getDriver()).moveToElement(getDriver().findElement(buttonSearch)).perform();
        new Actions(getDriver()).click(getDriver().findElement(buttonSearch)).perform();
        By results = By.xpath("//div[@id='resultBox']/div[1]");
        WebDriverWait tableResult = new WebDriverWait(getDriver(), 20);
        tableResult.until(ExpectedConditions.elementToBeClickable(results));
    }

    @Then("I verify closest location phone number is {string}")
    public void iVerifyClosestLocationPhoneNumberIs(String sPhone) {
        By elements = By.xpath("//div[contains(@class,'list-item-location')]");
        new WebDriverWait(getDriver(), 5, 1000).until(ExpectedConditions.presenceOfAllElementsLocatedBy(elements));
        List<WebElement> addresses = container.findElements(elements);

        new Actions(getDriver()).moveToElement(addresses.get(0)).perform();

        By fullInfo = By.xpath("//div[@class='po-location-detail-view']//div[@class='phone-wrapper']");

        do {
            new Actions(getDriver()).click(addresses.get(0)).perform();
        } while (!container.findElement(fullInfo).isDisplayed());

        assertThat(container.findElement(By.xpath("//div[@class='po-location-detail-view']//div[@class='phone-wrapper']")).getText()).contains(sPhone);
    }
}
