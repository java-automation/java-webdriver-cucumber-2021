package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.data.Percentage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.charset.StandardCharsets;
import java.sql.Time;
import java.util.List;

import static java.lang.Thread.sleep;
import static org.assertj.core.api.Assertions.*;
import static support.TestContext.getDriver;

public class UspsStepDefs {
    @When("I go to Lookup ZIP page by address")
    public void iGoToLookupZIPPageByAddress() throws InterruptedException {
        WebElement sendMenu = getDriver().findElement(By.xpath("//a[@id='mail-ship-width']"));
        Actions actions = new Actions(getDriver());
        actions.moveToElement(sendMenu).perform();

        getDriver().findElement(By.xpath("//a[text()= 'Look Up a ZIP Code']")).click();
        getDriver().findElement(By.xpath("//a[contains(text(),'Find by Address')]")).click();

        //  getDriver().findElement(By.xpath("//h2[@class='header-2 center']//a[text()='Look Up a ZIP Code']")).click();
        // getDriver().findElement(By.xpath("//a[contains(text(),'Find by Address')]")).click();
    }

    @And("I fill out {string} street, {string} city, {string} state")
    public void iFillOutStreetCityState(String street, String city, String state) {
        getDriver().findElement(By.xpath("//input[@id='tAddress']")).sendKeys(street);
        getDriver().findElement(By.xpath("//input[@id='tCity']")).sendKeys(city);
        getDriver().findElement(By.xpath("//select[@id='tState']/option[@value='" + state + "']")).click();
        getDriver().findElement(By.xpath("//a[@id='zip-by-address']")).click();
    }

    @Then("I validate {string} zip code exists in the result")
    public void iValidateZipCodeExistsInTheResult(String zip) throws InterruptedException {
        Thread.sleep(1000);
        WebElement resultContainer = getDriver().findElement(By.xpath("//div[@id='zipByAddressDiv']"));
        String resultString = resultContainer.getText();
        System.out.println(resultString);

        assertThat(resultString).contains(zip);

    }

    @When("I go to Calculate Price Page")
    public void iGoToCalculatePricePage() {
        WebElement sendMenu = getDriver().findElement(By.xpath("//a[@id='mail-ship-width']"));
        Actions actions = new Actions(getDriver());
        actions.moveToElement(sendMenu).perform();
        getDriver().findElement(By.xpath("//li[@class='tool-calc']/a[text()='Calculate a Price']")).click();

    }

    @And("I select {string} with {string} shape")
    public void iSelectWithShape(String country, String shape) throws InterruptedException {
        getDriver().findElement(By.xpath("//select[@id='CountryID']/option[text()='" + country + "']")).click();
        getDriver().findElement(By.xpath("//div[@class='col-xs-6 col-sm-3 col-md-2']//input[@id='option_1']")).click();


    }

    @And("I define {string} quantity")
    public void iDefineQuantity(String quantity) {
        getDriver().findElement(By.xpath("//input[@id='quantity-0']")).sendKeys(quantity);
        getDriver().findElement(By.xpath("//input[@type='button']")).click();
    }

    @Then("I calculate the price and validate cost is {string}")
    public void iCalculateThePriceAndValidateCostIs(String price) {
        WebElement total = getDriver().findElement(By.xpath("//div[@id='total']"));
        WebDriverWait wait = new WebDriverWait(getDriver(), 5);
        wait.until(ExpectedConditions.visibilityOf(total));

        String resultString = total.getText();
        assertThat(resultString).contains(price);
    }

    @When("I perform {string} search")
    public void iPerformSearch(String search) {
        WebElement searchBar = getDriver().findElement(By.xpath("//a[contains(text(),'Search USPS.com')]"));
        Actions actions = new Actions(getDriver());
        actions.moveToElement(searchBar).perform();
        getDriver().findElement(By.xpath("//input[@id='global-header--search-track-search']")).sendKeys(search + "\n"); // Enter button


    }

    @And("I set {string} in filters")
    public void iSetInFilters(String send) {
//        WebDriverWait wait = new WebDriverWait(getDriver(), 5);
//        wait.until(ExpectedConditions.visibilityOf(getDriver().findElement(By.xpath("//div[@id='dyn_nav_col']"))));
//        WebElement filter =getDriver().findElement(By.xpath("//div//label[text()='"+filterOption+"']"));
//        wait.until(ExpectedConditions.visibilityOf(filter)).click();
//        wait.until(ExpectedConditions.visibilityOf(getDriver().findElement(By.xpath("//span[@id='searchResultsHeading']"))));

        By filter = By.xpath("//p[@title='" + send + "']");
        WebDriverWait wait = new WebDriverWait(getDriver(), 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(filter)).click();
        wait.until(ExpectedConditions.visibilityOf(getDriver().findElement(By.xpath("//span[@id='searchResultsHeading']"))));
    }

    @Then("I verify that {string} results found")
    public void iVerifyThatResultsFound(String numOfResults) {
        WebElement searchResults = getDriver().findElement(By.xpath("//span[@id='searchResultsHeading']"));// to locate the result number
        String number = searchResults.getText();
        assertThat(number).contains(numOfResults + " results found for");
    }

    @When("I select {string} in results")
    public void iSelectInResults(String link) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 5);
        wait.until(ExpectedConditions.visibilityOf(getDriver().findElement(By.xpath("//div[@class='search-results']"))));
        getDriver().findElement(By.xpath("//span[contains(text(),'" + link + "')]")).click();
    }

    @And("I click {string} button")
    public void iClickButton(String button) {
        getDriver().findElement(By.xpath("//a[contains(text(),'" + button + "')]")).click();

    }

    @Then("I validate that Sign In is required")
    public void iValidateThatSignInIsRequired() {

        for (String handle : getDriver().getWindowHandles()) {
            getDriver().switchTo().window(handle);

            if (getDriver().getTitle().equals("USPS.com® - Sign In")) {
                String signIn = getDriver().findElement(By.xpath("//h1[@id='sign-in-to-your-account-header']")).getText();
                assertThat(signIn).contains("Sign In To Your Account");
                System.out.println(signIn);
            }
        }
    }

    @When("I navigate to {string} heading link")
    public void iNavigateToHeadingLink(String navigation) {
        getDriver().findElement(By.xpath("//a[@id='link-locator'][contains(text(),'" + navigation + "')]")).click();
    }

    @And("I search for location {string}")
    public void iSearchForLocation(String location) throws InterruptedException {
        getDriver().findElement(By.xpath("//input[@id='city-state-input']")).sendKeys(location);
        getDriver().findElement(By.xpath("//button[@id='within-select']")).click();
        getDriver().findElement(By.xpath("//a[contains(text(),'10 Miles')]")).click();
        getDriver().findElement(By.xpath("//a[@id='searchLocations']")).click();
        sleep(1000);
        getDriver().findElement(By.xpath("//div[@class='list-item-location popover-trigger']//p[text()='221 MAIN ST LOS ALTOS, CA 94022-2937']")).click();
//        getDriver().findElement(By.xpath("//div[@class='list-item-location popover-trigger']//p[contains(text(),'" + location + "')]")).click();
    }

    @Then("I verify closest location phone number is {string}")
    public void iVerifyClosestLocationPhoneNumberIs(String phoneNumber) throws InterruptedException {
        WebElement searchResults = getDriver().findElement(By.xpath("//div[@class='phone-wrapper']//p[contains(text(),'" + phoneNumber + "')]"));// to locate the result number
        String number = searchResults.getText();
        sleep(1000);
        System.out.println(number);
        sleep(1000);
        assertThat(number).contains(phoneNumber);
    }

    @When("I navigate to {string} tab")
    public void iNavigateToTab(String help) {
        getDriver().findElement(By.xpath("//a[@id='navhelp']/..")).click();
    }

    @And("I perform {string} help search")
    public void iPerformHelpSearch(String search) {
        getDriver().findElement(By.xpath("//div[@class='searchBox']//input")).sendKeys(search + Keys.ENTER);
    }

    @Then("I verify that no results of {string} available in help search")
    public void iVerifyThatNoResultsOfAvailableInHelpSearch(String searchQuery) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 5);
        By resultLocator = By.xpath("//div[@class='resultsWrapper']//li[contains(@class,'kbResultStencil')]"); //checks the first result of the page
        wait.until(ExpectedConditions.visibilityOfElementLocated(resultLocator));
        String resultBox = getDriver().findElement(By.xpath("//div[@class='resultsWrapper']")).getText();
        assertThat(resultBox).doesNotContainIgnoringCase(searchQuery);
    }

    @When("I go to {string} under {string}")
    public void iGoToUnder(String subMenuItem, String menuItem) {
        WebElement menuItemElement = getDriver().findElement(By.xpath("//a[@role='menuitem'][text()='" + menuItem + "']"));
        WebElement subMenuItemElement = getDriver().findElement(By.xpath("//a[@role='menuitem'][text()='" + subMenuItem + "']"));

        new Actions(getDriver())
                .moveToElement(menuItemElement)
                .click(subMenuItemElement)
                .perform();
    }

    @And("I search for {string}")
    public void iSearchFor(String text) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        By searchLocator = new By.ById("cityOrZipCode");
        wait.until(ExpectedConditions.presenceOfElementLocated(searchLocator)).sendKeys(text);
        getDriver().findElement(By.cssSelector(".eddm-search-btn")).click();
        WebElement spinner = getDriver().findElement(By.id("searchProcessing"));
        wait.until(ExpectedConditions.visibilityOf(spinner));
        wait.until(ExpectedConditions.invisibilityOf(spinner));
    }

    @And("I choose view as {string} on the map")
    public void iChooseViewAsOnTheMap(String viewAs) {
        getDriver().findElement(By.xpath("//span[text()='" +viewAs+ "']")).click();

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
    public void iVerifyThatSummaryOfAllRowsOfCostColumnIsEqualApproximateCostInOrderSummary() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 5);
        String totalRoutesText = getDriver().findElement(By.id("totalRoutesSelected")).getText();
        int totalRoutes = Integer.parseInt(totalRoutesText); // converting string to integer
        List<WebElement> costElements = getDriver().findElements(By.xpath("//table[contains(@class,'target-audience-table')]//td[9]"));
        assertThat(costElements.size()).isEqualTo(totalRoutes);

        double totalCostSum = 0;
        for (WebElement costElement: costElements){
            wait.until(driver -> !costElement.getText().isEmpty());
            double costElementDouble = Double.parseDouble(costElement.getText().replace("$", ""));
            totalCostSum = totalCostSum + costElementDouble;
        }
        System.out.println(totalCostSum);
        String approximateCostString = getDriver().findElement(By.id("approximateCost")).getText().replace("$", "");
        double approximateCost = Double.parseDouble(approximateCostString);
        assertThat(approximateCost).isCloseTo(totalCostSum, Percentage.withPercentage(1));
    }
}
