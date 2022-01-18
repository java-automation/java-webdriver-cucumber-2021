package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_old.Ac;
import org.assertj.core.api.Assertions;
import org.assertj.core.data.Percentage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;
import static org.openqa.grid.common.SeleniumProtocol.WebDriver;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;
import static support.TestContext.getDriver;

public class UspsStepDefs {

    @When("I go to Lookup ZIP page by address")
    public void iGoToLookupZIPPageByAddress() {
        WebElement sendMenuButton = getDriver().findElement(By.xpath("//a[@id='mail-ship-width']"));

        //mouseover
        Actions actions = new Actions(getDriver());
        actions.moveToElement(sendMenuButton).perform(); // offset = 100*100 - area to cover around element

        WebElement lookUpZip = getDriver().findElement(By.xpath("//li[@class='tool-zip']//a[contains(@href,'zip')]"));
        WebDriverWait wait = new WebDriverWait(getDriver(),5);
        wait.until(elementToBeClickable(lookUpZip));
        lookUpZip.click();

//        getDriver().findElement(By.xpath("//a[text()='Look Up a ZIP Code']")).click(); better avoid Text!
        getDriver().findElement(By.xpath("//a[@data-location='byaddress' and contains(@class,'zip-code-home') and contains(@class,'primary')]")).click();

    }

    @And("I fill out {string} street, {string} city, {string} state")
    public void iFillOutStreetCityState(String street, String city, String state) throws InterruptedException {
        getDriver().findElement(By.xpath("//input[@id='tAddress']")).sendKeys(street);
        getDriver().findElement(By.xpath("//input[@id='tCity']")).sendKeys(city);
//        getDriver().findElement(By.xpath("//input[@id='tState']")).click();
       // getDriver().findElement(By.xpath("//select[@id='tState']/option[@value='CA']")).click();
      //  getDriver().findElement(By.xpath("//select[@id='tState']/option[@value='" +state + "']")).click();

        // select
        WebElement selectElement = getDriver().findElement(By.xpath("//select[@id='tState']"));
        new Select(selectElement).selectByValue(state);

        Thread.sleep(2000);
        getDriver().findElement(By.id("zip-by-address")).click();
    }

    @Then("I validate {string} zip code exists in the result")
    public void iValidateZipCodeExistsInTheResult(String zipCode) {
        WebElement resultContainer = getDriver().findElement(By.id("zipByAddressDiv"));

        WebDriverWait wait = new WebDriverWait(getDriver(),5);

        wait.until(textToBePresentInElement(resultContainer,zipCode));
        wait.until(visibilityOf(resultContainer));
        wait.until(driver -> resultContainer.getText().length() > 0);
        wait.until(titleContains("ZIP Code™ Lookup | USPS"));
//        wait.until(driver -> driver.getTitle().equals("ZIP Code™ Lookup | USPS")); // lambda expression
        // use it when you don't have needed method in ExpectedConditions. You need to check specific scenario

        String resultString = resultContainer.getText();
        System.out.println(resultString);

        assertThat(resultString).contains(zipCode);
    }

    @When("I go to Calculate Price Page")
    public void iGoToCalculatePricePage() {
        WebElement sendMenuButton = getDriver().findElement(By.
                xpath("//a[@id='mail-ship-width']"));
        new Actions(getDriver()).
                moveToElement(sendMenuButton).
                perform();
        getDriver().findElement(By
                .xpath("//li[@class='tool-calc']//a[contains(text(),'Calculate a Price')]"))
                .click();
    }

    @When("I perform {string} search")
    public void iPerformSearch(String search) {
        WebElement searchIcon = getDriver().findElement(By.xpath("//a[@id='navsearch']/.."));
        WebElement searchInput = getDriver().findElement
                (By.xpath("//input[@id='global-header--search-track-search']"));

        new Actions(getDriver())
                .moveToElement(searchIcon)
                .sendKeys(searchInput, search)
                .sendKeys(Keys.ENTER) // enter button
                .perform();

//        getDriver().findElement(
////                By.xpath("//input[@id='global-header--search-track-search']/..//input[@value='Search']"));
//
//        // simulate enter button
////        searchInput.sendKeys(search + Keys.ENTER);
    }

    @And("I set {string} in filters")
    public void iSetInFilters(String filterText) {
        WebElement filterEl = getDriver().
                findElement(By.xpath("//label[contains(text(),'" + filterText +"')]"));
      // by locator
        By filterLocator = By.xpath("//label[contains(text(),'" + filterText +"')]");
        WebDriverWait wait = new WebDriverWait(getDriver(),5);
        wait.until(presenceOfElementLocated(filterLocator));
        filterEl.click();

        // spinner on the load page
        WebElement spinner = getDriver().findElement(By
                .xpath("//div[@class='white-spinner-container']"));
        wait.until(invisibilityOf(spinner));
    }

    @Then("I verify that {string} results found")
    public void iVerifyThatResultsFound(String resultCount) {

        WebElement resultHeader = getDriver().findElement(By.xpath("//span[@id='searchResultsHeading']"));
        assertThat(resultHeader.getText()).contains(resultCount);

        // another way to solve it
        int expectedCount = Integer.parseInt(resultCount);
        List<WebElement> totalResults = getDriver().findElements(By.xpath("//ul[@id='records']/li"));
        assertThat(totalResults.size()).isEqualTo(expectedCount);
    }

    @When("I select {string} in results")
    public void iSelectInResults(String selectedResult) {
        getDriver().findElement(
                By.xpath("//ul[@id='records']//span[contains(text(),'"+selectedResult+"')]")).click();
    }

    @And("I click {string} button")
    public void iClickButton(String button) {
        getDriver().findElement(By.
                xpath("//a[contains(text(),'"+button+"')]")).click();
    }

    @Then("I validate that Sign In is required")
    public void iValidateThatSignInIsRequired() {
        Set<String> windowHandles =  getDriver().getWindowHandles(); // ordered list
        String originalWindowHandle = getDriver().getWindowHandle(); // current single window!

        for (String handle : windowHandles) {
            getDriver().switchTo().window(handle); // switch to the last open window!
            // no matter how many of them
        }
        //  windowHandles.forEach(handle -> getDriver().switchTo().window(handle)); // same in lambda

        WebDriverWait wait = new WebDriverWait(getDriver(),5);
        wait.until(titleContains("Sign In"));

        getDriver().switchTo().window(originalWindowHandle);
    }

    @When("I go to {string} under {string}")
    public void iGoToUnder(String subMenuItem, String menuItem) {
        WebElement menuItemElement = getDriver().findElement(By.
                xpath("//a[@id='navbusiness']/../a[text()='" + menuItem +"']"));
        WebElement subMenuItemElement = getDriver().findElement(By.
                xpath("//li/a[@role='menuitem'][text()='" +subMenuItem +"']"));
        new Actions(getDriver()).
                moveToElement(menuItemElement).
                click(subMenuItemElement).
                perform();
    }

    @And("I search for {string}")
    public void iSearchFor(String searchAddress) {
        getDriver().findElement(By
                .xpath("//input[@id='cityOrZipCode']")).sendKeys(searchAddress);
        getDriver().findElement(By
                .cssSelector(".eddm-search-btn")).click();
              //  By.xpath("//a[@class='btn-primary eddm-search-btn']")).click();
    }

    @And("I choose view as {string} on the map")
    public void iChooseViewAsOnTheMap(String viewAs) {
        WebElement spinner = getDriver().findElement(By.id("searchProcessing"));
        WebDriverWait wait = new WebDriverWait(getDriver(),10);
        wait.until(visibilityOf(spinner));
        wait.until(invisibilityOf(spinner));

        getDriver().findElement(By.
                xpath("//span[text() ='" + viewAs + "']")).click();
    }

    @When("I select all in the table")
    public void iSelectAllInTheTable() {
        getDriver().
                findElement(By.id("select-all-checkboxes")).click();
    }

    @And("I close modal window")
    public void iCloseModalWindow() {

    }

    @Then("I verify that summary of all rows of Cost column is equal Approximate Cost in Order Summary")
    public void iVerifyThatSummaryOfAllRowsOfCostColumnIsEqualApproximateCostInOrderSummary() {
        String totalRoutesText = getDriver().findElement(By.id("totalRoutesSelected")).getText();
        int totalRoutes = Integer.parseInt(totalRoutesText);
        List<WebElement> costElements = getDriver().findElements(By.
                xpath("//table[contains(@class,'target-audience-table')]//td[9]"));
        assertThat(costElements).size().isEqualTo(totalRoutes);

        double totalCostSum = 0;
        for (WebElement costElement : costElements) {
            double costElementDouble = Double.parseDouble(costElement.getText().replace("$", ""));
            totalCostSum = totalCostSum + costElementDouble;
        }

        String approximateCostString = getDriver().findElement(By
                .id("approximateCost")).getText().replace("$", "");
        double approximateCost = Double.parseDouble(approximateCostString);

        assertThat(approximateCost).isCloseTo(totalCostSum, Percentage.withPercentage(1));
    }

    @And("I select {string} with {string} shape")
    public void iSelectWithShape(String country, String shape) {
        WebElement selectList = getDriver().findElement(By.xpath("//select[@id='CountryID']"));
        new Select(selectList).selectByVisibleText(country);

        getDriver().findElement(By.id("option_1")).click();
    }

    @And("I define {string} quantity")
    public void iDefineQuantity(String quantity) {
        getDriver().findElement(By.
                xpath("//input[@id='quantity-0']")).sendKeys(quantity);
        getDriver().findElement(By.
                xpath("//input[@value='Calculate']")).click();
    }

    @Then("I calculate the price and validate cost is {string}")
    public void iCalculateThePriceAndValidateCostIs(String price) {
        String totalPrice = getDriver().findElement(By.xpath("//div[@id='total']")).getText();
        assertThat(price).isEqualTo(totalPrice);
    }
}