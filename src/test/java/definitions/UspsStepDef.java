package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.eo.Se;
import org.assertj.core.data.Percentage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.DOUBLE;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;
import static support.TestContext.getDriver;

public class UspsStepDef {
    @When("I go to Lookup ZIP page by address")
    public void iGoToLookupZIPPageByAddress() {
        getDriver().findElement(By.xpath("//a[@class='nav-first-element menuitem']")).click();
        getDriver().findElement(By.xpath("//img[contains(@alt, 'Zip Code™ Lookup Icon')]")).click();
        getDriver().findElement(By.xpath("//a[contains(text(),'Find by Address')]")).click();

    }

    @And("I fill out {string} street, {string} city, {string} state")
    public void iFillOutStreetCityState(String street, String city, String state) {
        getDriver().findElement(By.xpath("//input[@id='tAddress']")).sendKeys(street);
        getDriver().findElement(By.xpath("//input[@id='tCity']")).sendKeys(city);
        Select findState = new Select(getDriver().findElement(By.xpath("//select[@id='tState']")));
        findState.selectByValue(state);
        getDriver().findElement(By.xpath("//a[@id='zip-by-address']")).click();


    }

    @Then("I validate {string} zip code exists in the result")
    public void iValidateZipCodeExistsInTheResult(String zip) throws InterruptedException {
        WebElement resultContainer = getDriver().findElement(By.xpath("//div[@id='zipByAddressDiv']"));
        WebDriverWait wait = new WebDriverWait(getDriver(), 5);
        wait.until(textToBePresentInElement(resultContainer, zip));
        String zipResult = resultContainer.getText();
        assertThat(zipResult).contains(zip);
    }

    @When("I go to Calculate Price Page")
    public void iGoToCalculatePricePage() {
        WebElement quickTools = getDriver().findElement(By.xpath("//a[@class='nav-first-element menuitem']"));
        Actions action = new Actions (getDriver());
        action.moveToElement(quickTools).perform();
        getDriver().findElement(By.xpath("//img[@alt='Calculate a Price Icon']")).click();
//        getDriver().findElement(By.xpath("//a[@class='nav-first-element menuitem']")).click();


    }

    @And("I select {string} with {string} shape")
    public void iSelectWithShape(String dest, String shape) {
        Select destination = new Select(getDriver().findElement(By.xpath("//select[@id='CountryID']")));
        destination.selectByVisibleText(dest);
        getDriver().findElement(By.xpath("//input[@value='"+ shape + "']")).click();

    }

    @And("I define {string} quantity")
    public void iDefineQuantity(String quantity) {
        getDriver().findElement(By.xpath("//input[@id='quantity-0']")).sendKeys("2");
        getDriver().findElement(By.xpath("//input[@value='Calculate']")).click();


    }

    @Then("I calculate the price and validate cost is {string}")
    public void iCalculateThePriceAndValidateCostIs(String expCost) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 5);
//        WebElement waitCost = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='total']")));
        String cost = getDriver().findElement(By.xpath("//div[@id='total']")).getText();
        assertThat(cost).isEqualTo(expCost);

    }

    @When("I perform {string} search")
    public void iPerformSearch(String search) {
        Actions hoverSearch = new Actions(getDriver());
        WebElement searchIcon = getDriver().findElement(By.xpath("//a[@id='navsearch']/.."));
        hoverSearch.moveToElement(searchIcon).perform();
        getDriver().findElement(By.xpath("//input[@id='global-header--search-track-search']")).sendKeys(search + Keys.RETURN);
        //getDriver().findElement(By.xpath("//input[@id='global-header--search-track-search']")).sendKeys(Keys.RETURN);


    }

    @And("I set {string} in filters")
    public void iSetInFilters(String filter) {
        getDriver().findElement(By.xpath("//label[contains(text(),'"+ filter +"')]")).click();
    }

    @Then("I verify that {string} results found")
    public void iVerifyThatResultsFound(String expTotal) {
        String results = getDriver().findElement(By.xpath("//span[@id='searchResultsHeading']")).getText();
        assertThat(results).contains(expTotal);
        // OR using list

//        int expectedCount = Integer.parseInt(expTotal);
//        List<WebElement> totalResult = getDriver().findElements(By.xpath("//ul[@id='records'/li]"));
//        assertThat(totalResult.size()).isEqualTo(expectedCount);
        
    }

    @When("I select {string} in results")
    public void iSelectInResults(String searchResult) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(getDriver(),5);
        WebElement spinner = getDriver().findElement(By.xpath("//div[@class='spinner-content']"));
        wait.until(ExpectedConditions.invisibilityOf(spinner));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='"+searchResult+"']")));
        getDriver().findElement(By.xpath("//*[text()='"+searchResult+"']")).click();

        
    }

    @And("I click {string} button")
    public void iClickButton(String button) {
        getDriver().findElement(By.xpath("//*[text()='"+button+"']")).click();
    }

    @Then("I validate that Sign In is required")
    public void iValidateThatSignInIsRequired() {
        // switch to new window
        /*

         Set<String> windowHandles =getDriver().getWindowHandles();
        String currentWindowHandle = getDriver().getWindowHandle();
        windowHandles.forEach(handle -> getDriver().switchTo().window(handle));

         */
        String originalWindowHandle = getDriver().getWindowHandle();
        for (String handle : getDriver().getWindowHandles()) {
            getDriver().switchTo().window(handle);
        }
        WebDriverWait wait = new WebDriverWait(getDriver(),5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='password']")));
        getDriver().findElement(By.xpath("//input[@id='username']")).clear();
        getDriver().findElement(By.xpath("//input[@id='password']")).click();
        getDriver().findElement(By.xpath("//button[@id='btn-submit']")).click();
        getDriver().manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class='error-txt-blk'])[1]")));
        String error = getDriver().findElement(By.xpath("(//span[@class='error-txt-blk'])[1]")).getText();
        String expError = "Your Username must be at least 6 characters long";
        assertThat(error).contains(expError);

        getDriver().switchTo().window(originalWindowHandle);
    }

    @When("I go to {string} under {string}")
    public void iGoToUnder(String subMenuItem, String menuItem) {
      WebElement menuItemElement =  getDriver().findElement(By.xpath("//a[@role='menuitem'][text()='"+menuItem+"']"));
      WebElement subMenuItemElement = getDriver().findElement(By.xpath("//li/a[@role='menuitem'][text()='"+subMenuItem+"']"));
      new Actions(getDriver()).moveToElement(menuItemElement).click(subMenuItemElement).perform();
    }

    @And("I search for {string}")
    public void iSearchFor(String text) {
        getDriver().findElement(By.cssSelector(".location-input")).sendKeys(text);
        getDriver().findElement(By.cssSelector(".eddm-search-btn")).click();
        WebElement spinner = getDriver().findElement(By.id("searchProcessing"));
        WebDriverWait wait = new WebDriverWait(getDriver(),8);
        wait.until(ExpectedConditions.visibilityOf(spinner));
        wait.until(ExpectedConditions.invisibilityOf(spinner));

    }

    @And("I choose view as {string} on the map")
    public void iChooseViewAsOnTheMap(String viewAs) {
        getDriver().findElement(By.cssSelector(".table-view-icon")).click();


    }

    ////div[@id='searchProcessing']/div[@class='white-spinner-container']
    ////td[last()-1]

    @When("I select all in the table")
    public void iSelectAllInTheTable() {
        getDriver().findElement(By.xpath("//input[@id='select-all-checkboxes']/..")).click();

    }

    public void spinnerOnOff(){
        WebElement spinner = getDriver().findElement(By.id("searchProcessing"));
        WebDriverWait wait = new WebDriverWait(getDriver(),8);
        wait.until(ExpectedConditions.visibilityOf(spinner));
        wait.until(ExpectedConditions.invisibilityOf(spinner));
    }

    @And("I close modal window")
    public void iCloseModalWindow() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(getDriver(),2);
        WebElement closeButton = getDriver().findElement(By.xpath("//a[@id='closeAndUpdateTotals']"));
        wait.until(ExpectedConditions.visibilityOf(closeButton));
        closeButton.click();
    }

    @Then("I verify that summary of all rows of Cost column is equal Approximate Cost in Order Summary")
    public void iVerifyThatSummaryOfAllRowsOfCostColumnIsEqualApproximateCostInOrderSummary() throws InterruptedException, ParseException {
        Locale locale = new Locale("en", "US");
        NumberFormat formatter = NumberFormat.getCurrencyInstance(locale);
        WebDriverWait wait = new WebDriverWait(getDriver(), 5);
        String totalRoutesText = getDriver().findElement(By.id("totalRoutesSelected")).getText();
        int totalRoutes = Integer.parseInt(totalRoutesText);
        List<WebElement> costElements = getDriver().findElements(By.xpath("//table[contains(@class, 'target-audience-table')]//td[9]"));
        assertThat(costElements.size()).isEqualTo(totalRoutes);

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
        assertThat(approximateCost).isCloseTo(totalCostSum, Percentage.withPercentage(0.5));
    }

    @When("I go to {string} tab")
    public void iGoToTab(String page) throws InterruptedException {
        Actions action = new Actions(getDriver());
        WebElement search = getDriver().findElement(By.xpath("(//a[@id='navsearch']/../a)[2]"));
        action.moveToElement(search).perform();

    }

    @And("I perform {string} help search")
    public void iPerformHelpSearch(String searchText) throws InterruptedException {
        Actions action = new Actions(getDriver());
        getDriver().findElement(By.xpath("//input[@id='global-header--search-track-search']")).sendKeys(searchText);
        action.sendKeys(Keys.ENTER).perform();

    }

    @Then("I verify that no results of {string} available in help search")
    public void iVerifyThatNoResultsOfAvailableInHelpSearch(String searchText) {

        String actualSearchText = getDriver().findElement(By.xpath("//div[@class='col-12  form-group not-found-error']/p")).getText();
        String expectedSearch = "Sorry, we could not find any results for your search term " + "\""+ searchText +"\"";

        assertThat(expectedSearch).isEqualTo(actualSearchText);



    }


}
