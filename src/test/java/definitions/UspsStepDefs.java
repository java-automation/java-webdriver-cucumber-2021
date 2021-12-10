package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static support.TestContext.getDriver;

public class UspsStepDefs {

    @When("I go to Lookup ZIP page by address through {string}")
    public void iGoToLookupZIPPageByAddress(String strategy) {
        if (strategy.equals("quick tools")) {
            getDriver().findElement(By.xpath("//ul[@class='nav-list']//a[contains(@class,'nav-first-element')]")).click();
            getDriver().findElement(By.xpath("//a[@role='menuitem']/img[contains(@alt,'Zip Code')]")).click();
        } else if (strategy.equals("send")) {
            getDriver().findElement(By.xpath("//a[@id='mail-ship-width']")).click();
            getDriver().findElement(By.xpath("//a[contains(@href,'ZipLookupAction')]")).click();
        } else throw new Error("Unknown strategy: " + strategy);
        getDriver().findElement(By.xpath("//a[contains(@class,'btn-primary zip-code-home')][@data-location='byaddress']")).click();
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
        List<WebElement> results = getDriver().findElements(By.xpath("//div[@id='zipByAddressDiv']//li[contains(@class,'list-group-item')]"));
        for (WebElement el : results) assertThat(el.getText()).contains(zip);
    }
}
