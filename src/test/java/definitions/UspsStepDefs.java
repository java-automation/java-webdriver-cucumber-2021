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

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static support.TestContext.getDriver;

public class UspsStepDefs {

    @When("I go to Lookup ZIP page by address through {string}")
    public void iGoToLookupZIPPageByAddress(String strategy) {
        WebElement sendButton = getDriver().findElement(By.xpath("//a[@id='mail-ship-width']"));
        switch (strategy) {
            case "quick tools" -> {
                getDriver().findElement(By.xpath("//ul[@class='nav-list']/li[contains(@class,'qt-nav')]")).click();
                getDriver().findElement(By.xpath("//a[@role='menuitem']/img[contains(@alt,'Zip Code')]")).click();
            }
            case "send" -> {
                sendButton.click();
                getDriver().findElement(By.xpath("//a[contains(@href,'ZipLookupAction')]")).click();
            }
            case "mouseover" -> {
                new Actions(getDriver()).moveToElement(sendButton).perform();
                getDriver().findElement(By.xpath("//li[@class='tool-zip']/a[contains(@href,'zip-code-lookup')]")).click();
            }
            default -> throw new Error("Unknown strategy: " + strategy);
        }
        WebElement findByAddress = getDriver().findElement(By.xpath("//a[@class='btn-primary zip-code-home'][@data-location='byaddress']"));
        new WebDriverWait(getDriver(), 3).until(ExpectedConditions.visibilityOf(findByAddress)).click();
    }

    @And("I fill out {string} street, {string} city, {string} state")
    public void iFillOutStreetCityState(String address, String city, String state) {
        getDriver().findElement(By.xpath("//input[@id='tAddress']")).sendKeys(address);
        getDriver().findElement(By.xpath("//input[@id='tCity']")).sendKeys(city);
        new Select(getDriver().findElement(By.xpath("//select[@id='tState']"))).selectByValue(state);
        getDriver().findElement(By.xpath("//a[@id='zip-by-address']")).click();
    }

    @Then("I validate {string} zip code exists in all results")
    public void iValidateZipCodeExistsInTheResult(String zip) {
        String containerXPath = "//div[@id='zipByAddressDiv']";
        new WebDriverWait(getDriver(), 3).until(ExpectedConditions.visibilityOf(getDriver().findElement(By.xpath(containerXPath))));
        List<WebElement> results = getDriver().findElements(By.xpath(containerXPath + "//li[contains(@class,'list-group-item')]"));
        for (WebElement el : results) assertThat(el.getText()).contains(zip);
    }

    @When("I go to Calculate Price Page")
    public void iGoToCalculatePricePage() {
        new Actions(getDriver()).moveToElement(getDriver().findElement(By.xpath("//ul[@class='nav-list']/li[contains(@class,'qt-nav')]"))).perform();
        getDriver().findElement(By.xpath("//a[@role='menuitem']/img[contains(@alt,'Calculate a Price')]")).click();
    }

    @And("I select {string} with {string} shape")
    public void iSelectWithShape(String country, String shape) {
        new Select(getDriver().findElement(By.xpath("//select[@id='CountryID']"))).selectByVisibleText(country);
        getDriver().findElement(By.xpath("//input[@value='" + shape + "']")).click();
    }

    @And("I define {string} quantity")
    public void iDefineQuantity(String quantity) {
        getDriver().findElement(By.xpath("//input[@id='quantity-0']")).sendKeys(quantity);
    }

    @Then("I calculate the price and validate cost is {string}")
    public void iCalculateThePriceAndValidateCostIs(String totalCost) {
        getDriver().findElement(By.xpath("//input[@value='Calculate']")).click();
        assertThat(getDriver().findElement(By.xpath("//*[@id='total']")).getText()).isEqualTo(totalCost);
    }

    @When("I perform {string} search")
    public void iPerformSearch(String query) {
        String navSearchXPath = "//li[contains(@class,'nav-search')]";
        new Actions(getDriver()).moveToElement(getDriver().findElement(By.xpath(navSearchXPath))).perform();
        getDriver().findElement(By.xpath(navSearchXPath + "//input[@name='q']")).sendKeys(query);
        getDriver().findElement(By.xpath(navSearchXPath + "//input[@value='Search']")).click();
    }

    @And("I set {string} in filters")
    public void iSetInFilters(String filterName) {
        By sendFilter = By.xpath("//p[@title='" + filterName + "']");
        new WebDriverWait(getDriver(), 3).until(ExpectedConditions.visibilityOfElementLocated(sendFilter));
        getDriver().findElement(sendFilter).click();
    }

    @Then("I verify that {string} results found")
    public void iVerifyThatResultsFound(String amountOfResults) {
        WebElement spinner = getDriver().findElement(By.xpath("//div[@class='spinner-content']"));
        new WebDriverWait(getDriver(),3).until(ExpectedConditions.invisibilityOf(spinner));
        List<WebElement> results = getDriver().findElements(By.xpath("//ul[@id='records']/li"));
        assertThat(results.size()).isEqualTo(Integer.parseInt(amountOfResults));
    }

    @When("I select {string} in results")
    public void iSelectInResults(String resultToChoose) {
        getDriver().findElement(By.xpath("//ul[@id='records']//a//*[contains(normalize-space(),'" + resultToChoose + "')]")).click();
    }

    @And("I click {string} button")
    public void iClickButton(String buttonText) {
        getDriver().findElement(By.xpath("//a[@class='button--primary'][contains(normalize-space(),'" + buttonText + "')]")).click();
    }

    @Then("I validate that Sign In is required")
    public void iValidateThatSignInIsRequired() {
        for (String handle : getDriver().getWindowHandles()) {
            getDriver().switchTo().window(handle);
            if (getDriver().getCurrentUrl().contains("https://www.usps.com/ship/priority-mail")) continue;
            assertThat(getDriver().getCurrentUrl()).contains("https://reg.usps.com");
            assertThat(getDriver().findElement(By.xpath("//button[@id='btn-submit']"))).isNotNull();
            assertThat(getDriver().findElement(By.xpath("//a[@id='sign-up-button']"))).isNotNull();
        }
    }
}
