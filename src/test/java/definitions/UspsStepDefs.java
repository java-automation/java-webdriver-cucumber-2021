package definitions;

import io.cucumber.java.en.*;
import org.assertj.core.api.*;
import org.openqa.selenium.*;

import static support.TestContext.getDriver;

public class UspsStepDefs {
    @When("I go to Lookup ZIP page by address")
    public void iGoToLookupZIPPageByAddress() {
        getDriver().findElement(By.xpath("//*[@id='navquicktools']/..")).click();
        getDriver().findElement(By.xpath("//p[contains(text(),'Look Up')]")).click();
        Assertions.assertThat(getDriver().getTitle().toLowerCase()).contains("zip code");
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
        Assertions.assertThat(getDriver().findElement(By.xpath("//ul[contains(@class,'industry-detail')]//li[1]")).getText()).contains(zip);
    }
}
