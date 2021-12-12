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

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class UspsStepDefs {

        @When("I go to lookup zip page by address")
        public void iGoToLookupZipPageByAddress() {
            WebElement sendMenu = getDriver().findElement(By.id("mail-ship-width"));
            new Actions(getDriver()).moveToElement(sendMenu).perform();
            getDriver().findElement(By.xpath("//li[@class='tool-zip']/a[contains(@href, 'zip')]")).click();
            getDriver().findElement(By.xpath("//a[contains(@href,'byaddress')][contains(@class,'zip-code-home')][contains(@class,'primary')]")).click();
    }

    @And("I fill out {string} street, {string} city, {string} state")
    public void iFillOutStreetCityState(String street, String city, String state) {
            getDriver().findElement(By.id("tAddress")).sendKeys(street);
            getDriver().findElement(By.id("tCity")).sendKeys(city);
            WebElement selectState = getDriver().findElement(By.id("tState"));
            new Select(selectState).selectByValue(state);
            getDriver().findElement(By.xpath("//a[@id='zip-by-address']")).click();
    }

    @Then("I validate {string} zip code exists in the result")
    public void iValidateZipCodeExistsInTheResult(String zipCode) {
           WebElement pageResult = getDriver().findElement(By.xpath("//div[@id='zipByAddressDiv']"));
           WebDriverWait wait = new WebDriverWait(getDriver(), 5);
           wait.until(ExpectedConditions.visibilityOf(pageResult));
           assertThat(pageResult.getText()).contains(zipCode);

    }
}
