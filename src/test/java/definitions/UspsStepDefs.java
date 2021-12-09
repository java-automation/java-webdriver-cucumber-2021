package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

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
}
