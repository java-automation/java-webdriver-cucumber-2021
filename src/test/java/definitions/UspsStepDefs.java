package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static support.TestContext.getDriver;


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
    public void iValidateZipCodeExistsInTheResult(String arg0) throws InterruptedException {

        WebElement resultContainer =  getDriver().findElement(By.xpath("//div[@id='zipByAddressDiv']"));
        Thread.sleep(1000);
        String resultString = resultContainer.getText();
        System.out.println(resultString);




    }
}
