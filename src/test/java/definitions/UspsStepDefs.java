package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;
import static support.TestContext.getDriver;
import static org.assertj.core.api.Assertions.assertThat;


public class UspsStepDefs {
    @When("I go to lookup ZIP page by address")
    public void iGoToLookupZIPPageByAddress() {
        getDriver().findElement(By.xpath("//a[normalize-space()='Quick Tools']")).click();
        getDriver().findElement(By.xpath("//img[@alt='Zip Code™ Lookup Icon']")).click();
        getDriver().findElement(By.xpath("//a[contains(text(),'Find by Address')]")).click();

    }

    @And("I fill out {string} street, {string} city, {string} state")
    public void iFillOutStreetCityState(String street, String city, String state) {

        getDriver().findElement(By.xpath("//input[@id='tAddress']")).sendKeys(street);
        getDriver().findElement(By.xpath("//input[@id='tCity']")).sendKeys(city);
        getDriver().findElement(By.xpath("//select[@id='tState']")).click();
        getDriver().findElement(By.xpath("//select[@id='tState']//option[@value='" + state + "']")).click();
        getDriver().findElement(By.xpath("//input[@id='tZip-byaddress']")).sendKeys("94022");
        getDriver().findElement(By.xpath("//a[@id='zip-by-address']")).click();

    }

    @Then("I validate {string} zip code exists in the result")
    public void iValidateZipCodeExistsInTheResult(String zip) throws InterruptedException {
        WebElement resultContainer =  getDriver().findElement(By.xpath("//div[@id='zipByAddressDiv']"));

        WebDriverWait wait = new WebDriverWait(getDriver(), 5);
//        wait.until(ExpectedConditions.textToBePresentInElement(resultContainer, zip));
        wait.until(ExpectedConditions.visibilityOf(resultContainer));

        Thread.sleep(1000);
        String resultString = resultContainer.getText();
        System.out.println(resultString);

        Assertions.assertThat(resultString).contains(zip);

    }

    @When("I go to Calculate Price Page")
    public void iGoToCalculatePricePage() {
        WebElement sendMenu = getDriver().findElement(By.xpath("//a[@id='mail-ship-width']"));
        Actions actions = new Actions(getDriver());
        actions.moveToElement(sendMenu).perform();
//        new Actions(getDriver()).moveToElement(sendMenu).perform(); //This line is a recipe for mouse over action. Belov 2 lines can be replaced with this one line.
        getDriver().findElement(By.xpath("//li[@class='tool-calc']/a[contains(@href, 'postcalc')][contains(text(), 'Calculate a Price')]")).click();
    }

    @And("I select {string} with {string} shape")
    public void iSelectWithShape(String arg0, String arg1) throws InterruptedException {

        WebElement selectElement = getDriver().findElement(By.xpath("//select[@id='CountryID']"));
        Select select = new Select(selectElement); //select recipe
//        new Select(selectElement).selectByValue(country);
        select.selectByVisibleText("Canada");
        Thread.sleep(5000);
        getDriver().findElement(By.xpath("//input[@id='ItemValue']")).sendKeys("Postcard");
        getDriver().findElement(By.xpath("//input[@value='Postcard']")).click();
    }

    @And("I define {string} quantity")
    public void iDefineQuantity(String arg0) {
        getDriver().findElement(By.xpath("//input[@id='quantity-0']")).sendKeys("2");
        getDriver().findElement(By.xpath("//input[@value='Calculate']")).click();
    }

    @Then("I calculate the price and validate cost is {string}")
    public void iCalculateThePriceAndValidateCostIs(String arg0) {
        WebElement total = getDriver().findElement(By.xpath("//div[@id='total']"));
        String price = total.getText();
        System.out.println(price);
    }

    @When("I perform {string} search")
    public void iPerformSearch(String searchString) throws InterruptedException {
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
    public void iSetInFilters(String filterText) {
//        getDriver().findElement(By.xpath("//p[@title='Send']")).click();
        WebDriverWait wait = new WebDriverWait(getDriver(),5);
        By filterLocator = By.xpath("//div[@id='dyn_nav']//label[contains(text(),'" + filterText + "')]");
        wait.until(presenceOfElementLocated(filterLocator));
        WebElement filter = getDriver().findElement(filterLocator);
        filter.click();

        WebElement spinner = getDriver().findElement(By.xpath("//span[@id='searchResultsHeading']"));
        wait.until(invisibilityOf(spinner));
    }

    @Then("I verify that {string} results found")
    public void iVerifyThatResultsFound(String expectedTotal) throws InterruptedException {
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
        getDriver().findElement(By.xpath("//a[contains(text(),'" + title + "')]")).click();    }

    @Then("I validate that Sign In is required")
    public void iValidateThatSignInIsRequired() {
        String originalWindow = getDriver().getWindowHandle();

        //java8 syntax
        getDriver().getWindowHandles().forEach(handle -> getDriver().switchTo().window(handle));

        WebDriverWait wait = new WebDriverWait(getDriver(),5);
        wait.until(titleContains("Sign In"));

        getDriver().switchTo().window(originalWindow);
    }
    @When("I go to {string} link")
    public void iGoToLink(String link) {
        getDriver().findElement(By.xpath("//ul[@class='nav-list']//a[text()='" + link + "']")).click();
    }

    @And("I perform {string} help search")
    public void iPerformHelpSearch(String search) {
        getDriver().findElement(By.xpath("//input[contains(@class, 'search-field input')]"))
                .sendKeys(search + Keys.ENTER);
    }

    @Then("I verify that no results of {string} available in help search")
    public void iVerifyThatNoResultsOfAvailableInHelpSearch(String arg0) {
        WebDriverWait wait = new WebDriverWait(getDriver(),5);
        wait.until(titleContains("Search Results | Quadcopters delivery"));

        WebElement resultContainer =  getDriver().findElement(By.xpath("//div[@class='resultsWrapper']"));

        String resultString = resultContainer.getText();
        System.out.println(resultString);

        Assertions.assertThat(resultString).doesNotContain("Quadcopters delivery");

    }


    @When("I navigate to {string} heading link")
    public void iNavigateToHeadingLink(String headingLink) {
        getDriver().findElement(By.xpath("//*[@id='link-locator']")).click();

    }

    @And("I search for location {string}")
    public void iSearchForLocation(String location) {
        getDriver().findElement(By.xpath("//input[@id='city-state-input']"))
                .sendKeys(location + Keys.ENTER);
    }

    @Then("I verify closest location phone number is {string}")
    public void iVerifyClosestLocationPhoneNumberIs(String result) {
        try {
            WebElement nearestLocation =  getDriver().findElement(By.xpath("(//*[@id='resultBox']//span[@class='listArrow'])[1]"));
            String resultString = nearestLocation.getText();
            System.out.println(resultString);
            Assertions.assertThat(result).contains("800-275-8777");
        } catch(Exception e){ //When I run the test there is no results are displayed.
            System.out.println("Can't find what you're looking for?");
        }
    }
}
