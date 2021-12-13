package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import static java.lang.Thread.sleep;
import static org.assertj.core.api.Assertions.assertThat;
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
}
