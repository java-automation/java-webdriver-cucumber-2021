package definitions;

import io.cucumber.java.en.*;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.*;
import org.openqa.selenium.support.ui.*;
import java.util.*;
import static java.lang.Integer.parseInt;
import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class UspsStepDefs {
    WebDriverWait wait = new WebDriverWait(getDriver(), 5);
    Actions actions = new Actions(getDriver());

    @When("I go to Lookup ZIP page by address")
    public void iGoToLookupZIPPageByAddress() {
        getDriver().findElement(By.xpath("//*[@id='navquicktools']/..")).click();
        getDriver().findElement(By.xpath("//p[contains(text(),'Look Up')]")).click();
        assertThat(getDriver().getTitle().toLowerCase()).contains("zip code");
        wait.until(ExpectedConditions.titleContains("zip code"));
    }

    @And("I fill out {string} street, {string} city, {string} state")
    public void iFillOutStreetCityState(String street, String city, String state) {
        getDriver().findElement(By.xpath("//a[@data-location='byaddress'][contains(text(),'By Address')]")).click();
        getDriver().findElement(By.xpath("//input[@id='tAddress']")).sendKeys(street);
        getDriver().findElement(By.xpath("//input[@id='tCity']")).sendKeys(city);
        getDriver().findElement(By.xpath("//select[@id='tState']//option[@value='" + state + "']")).click();
    }

    @Then("I validate {string} zip code exists in the result")
    public void iValidateZipCodeExistsInTheResult(String zip) throws InterruptedException {
        getDriver().findElement(By.xpath("//a[@id='zip-by-address']")).click();
       // getDriver().findElement(By.xpath("//ul[contains(@class,'entered-address')]")).isDisplayed();
        Thread.sleep(2000);
        wait(2000);
        assertThat(getDriver().findElement(By.xpath("//ul[contains(@class,'industry-detail')]//li[1]")).getText()).contains(zip);
    }

    @When("I go to Calculate Price Page")
    public void iGoToCalculatePricePage() {
        actions.moveToElement(getDriver().findElement(By.xpath("//a[@id='mail-ship-width']")), 10, 10).perform();
        getDriver().findElement(By.xpath("//li[contains(@class,'-calc')]//a[contains(text(),'Calculate a Price')]")).click();
    }

    @And("I select {string} with {string} shape")
    public void iSelectWithShape(String destCountry, String shapeType) {
        getDriver().findElement(By.xpath("//select[@id='CountryID']//option[text()='" + destCountry + "']")).click();
        getDriver().findElement(By.xpath("//input[@id='option_1']")).click();
        assertThat(getDriver().findElement(By.xpath("//*[@id='maincontent']//h2")).getText()).isEqualTo(shapeType);
    }

    @And("I define {string} quantity")
    public void iDefineQuantity(String quantity) {
        getDriver().findElement(By.xpath("//input[@id='quantity-0']")).sendKeys(quantity);
    }

    @Then("I calculate the price and validate cost is {string}")
    public void iCalculateThePriceAndValidateCostIs(String cost) {
        getDriver().findElement(By.xpath("//input[@value='Calculate']")).click();
        assertThat(getDriver().findElement(By.xpath("//*[@id='cost-0']")).getText()).isEqualTo(cost);
    }

    @When("I perform {string} search")
    public void iPerformSearch(String search) {
        getDriver().findElement(By.xpath("//li[contains(@class,'nav-search')]")).click();
        getDriver().findElement(By.xpath("//input[contains(@id,'--search-track-search')]")).sendKeys(search);
        getDriver().findElement(By.xpath("//*[@class='empty-search']//a[contains(text(),'" + search.toUpperCase() + "')]")).click();
    }

    @And("I set {string} in filters")
    public void iSetInFilters(String websiteFilter) {
        getDriver().findElement(By.xpath("//a[contains(@class,'sub-catagory')]//p[@title='" + websiteFilter + "']")).click();
        //wait.until(ExpectedConditions.invisibilityOf(getDriver().findElement(By.xpath("//span[@title='Filter by Media Type']"))));
    }

    @Then("I verify that {string} results found")
    public void iVerifyThatResultsFound(String numResults) {
        wait.until(ExpectedConditions.invisibilityOf(getDriver().findElement(By.xpath("//*[contains(@class,'spinner-content')]//h5"))));
        Assert.assertTrue(getDriver().findElement(By.xpath("//ul[@class='pagination']//li[@class='next disabled']")).isDisplayed());
        List<WebElement> elements = getDriver().findElements(By.xpath("//ul[@id='records']//li"));
        Assert.assertEquals(elements.size(), parseInt(numResults));
    }

    @When("I select {string} in results")
    public void iSelectInResults(String title) {
        getDriver().findElement(By.xpath("//ul[@id='records']//span[contains(text(),'" + title + "')]")).click();
    }

    @And("I click {string} button")
    public void iClickButton(String button) {
        getDriver().findElement(By.xpath("//a[contains(text(),'" + button + " ')]")).click();
    }

    @Then("I validate that Sign In is required")
    public void iValidateThatSignInIsRequired() {
        GenericStepDefs.iSwitchToANewWindow();
        wait.until(ExpectedConditions.visibilityOf(getDriver().findElement(By.xpath("//h1[contains(@id,'sign-in')]"))));
        Assert.assertTrue(getDriver().getTitle().toLowerCase().contains("sign in"));
        assertThat(getDriver().findElement(By.xpath("//h1[contains(@id,'sign-in')]")).getText()).isEqualTo("Sign In To Your Account");
        Assert.assertTrue(getDriver().findElement(By.xpath("//button[@id='btn-submit']")).isDisplayed());

    }
}
