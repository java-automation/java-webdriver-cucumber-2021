package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

import static support.TestContext.getDriver;

public class UspsStepDefs {
    @When("I go to Lookup ZIP page by address")
    public void iGoToLookupZIPPageByAddress() {
        getDriver().findElement(By.xpath("//a[@id='mail-ship-width']")).click();
        getDriver().findElement(By.partialLinkText("Look Up a ZIP Code")).click();
        getDriver().findElement(By.partialLinkText("Find by Address")).click();

    }

    @And("I fill out {string} street, {string} city, {string} state")
    public void iFillOutStreetCityState(String arg0, String arg1, String arg2) {
        getDriver().findElement(By.xpath("//input[@id='tAddress']")).sendKeys("4970 El Camino Real");
        getDriver().findElement(By.xpath("//input[@id='tCity']")).sendKeys("Los Altos");
        getDriver().findElement(By.xpath("//select[@id='tState']/option[@value='CA']")).click();
        getDriver().findElement(By.xpath("//a[@id='zip-by-address']")).click();
    }

    @Then("I validate {string} zip code exists in the result")
    public void iValidateZipCodeExistsInTheResult(String zip) {
    List<WebElement> elements = getDriver().findElements(By.xpath("//li[@class='list-group-item paginate']"));
    for (WebElement el : elements) {
        el.getText();
        Assertions.assertThat(el).isIn("94022");
    }

    }

    @When("I go to Calculate Price Page")
    public void iGoToCalculatePricePage() {
        WebElement sendMenu = getDriver().findElement(By.xpath("//a[@id='mail-ship-width']"));
        new Actions(getDriver()).moveToElement(sendMenu).perform();
        getDriver().findElement(By.xpath("//li[@class='tool-calc']/a[contains(@href,'postcalc.usps.com')]")).click();

    }

    @And("I select {string} with {string} shape")
    public void iSelectWithShape(String country, String mailType) {
        WebElement selectElement = getDriver().findElement(By.xpath("//select[@id='CountryID']"));
        new Select(selectElement).selectByVisibleText(country);
        getDriver().findElement(By.xpath("//input[@id='option_1']")).click();

    }


    @And("I define {string} quantity")
    public void iDefineQuantity(String quantity) {
        getDriver().findElement(By.xpath("//input[@id='quantity-0']")).sendKeys(quantity);
        getDriver().findElement(By.xpath("//input[@value='Calculate']")).click();
    }

    @Then("I calculate the price and validate cost is {string}")
    public void iCalculateThePriceAndValidateCostIs(String cost) {
        String costResult = getDriver().findElement(By.xpath("//div[@id='total']")).getText();
        assertThat(costResult).isEqualTo(cost);
    }

    @When("I perform {string} search")
    public void iPerformSearch(String search) {
//        getDriver().findElement( By.xpath("//li[@class='nav-search menuheader']")).click();
        WebElement searchMenu = getDriver().findElement(By.xpath("//li[@class='nav-search menuheader']"));
        new Actions(getDriver()).moveToElement(searchMenu).perform();
        getDriver().findElement(By.xpath("//a[contains(@href, 'Free%20Boxes')]")).click();
    }

    @And("I set {string} in filters")
    public void iSetInFilters(String send) {
        getDriver().findElement(By.xpath("//p[@title='Send']")).click();
    }

    @Then("I verify that {string} results found")
    public void iVerifyThatResultsFound(String results) {
        List<WebElement> searchResults = getDriver().findElements(By.xpath("//ul[@id='records']/li"));
        assertThat(searchResults.size()).isEqualTo(7);
//        if (searchResults.size() == 7){
//            System.out.println("7 results found");
//        } else {
//            System.out.println("results number doesn't match");
//        }
    }

    @When("I select {string} in results")
    public void iSelectInResults(String arg0) {
        getDriver().findElement(By.xpath("//span[@id='title_22']")).click();
    }

    @And("I click {string} button")
    public void iClickButton(String arg0) {
        getDriver().findElement(By.xpath("//a[contains(@href,'cns')][contains(@class,'button--primary')]")).click();
    }

    @Then("I validate that Sign In is required")
    public void iValidateThatSignInIsRequired() {
        ArrayList<String> tabs2 = new ArrayList<String>(getDriver().getWindowHandles());
        getDriver().switchTo().window(tabs2.get(1));
            String title = getDriver().getTitle();
            assertThat(title).contains("Sign In");

        }
}
