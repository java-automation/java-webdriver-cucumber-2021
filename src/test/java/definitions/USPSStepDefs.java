package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.DurationAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class USPSStepDefs {
    @When("I go to Lookup ZIP page by address")
    public void iGoToLookupZIPPageByAddress() {
        getDriver().findElement(By.xpath("//a[normalize-space()='Quick Tools']")).click();
        getDriver().findElement(By.xpath("//a[@name='navquicktools']/..//a[contains(normalize-space(),'Look Up a') and contains(normalize-space(),'ZIP Code')]")).click();
        waitForElements(5,"//a[normalize-space()='Find by Address']");
        getDriver().findElement(By.xpath("//a[normalize-space()='Find by Address']")).click();
    }

    @And("I fill out {string} street, {string} city, {string} state")
    public void iFillOutStreetCityState(String sStreet, String sCity, String sState) {
        getDriver().findElement(By.xpath("//input[@id='tAddress']")).sendKeys(sStreet);
        getDriver().findElement(By.xpath("//input[@id='tCity']")).sendKeys(sCity);
        getDriver().findElement(By.xpath("//select[@id='tState']")).click();
        getDriver().findElement(By.xpath("//select[@id='tState']/option[@value='" + sState + "']")).click();
    }

    @And("I click button Find")
    public void iClickButtonFind() {
        getDriver().findElement(By.xpath("//a[@id='zip-by-address']")).click();
    }

    @And("I wait result being loaded")
    public void iWaitResultBeingLoaded() {
        waitForElements(5,"//div[@class='zipcode-result-address']");
    }

    public void waitForElements(int iSeconds, String sXPath) {
        WebDriverWait wait = new WebDriverWait(getDriver(),iSeconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sXPath)));
    }

    @Then("I validate {string} zip code exists in the result")
    public void iValidateZipCodeExistsInTheResult(String sZipCode) {
        boolean isExist = false;
        List<WebElement> lItems = getDriver().findElements(By.xpath("//div[@class='zipcode-result-address']"));
        for (WebElement el : lItems) {
            if (el.getText().contains(sZipCode)){
                isExist = true;
                System.out.println(el.getText());
                break;
            }
        }
        assertThat(isExist).isTrue();
    }

    @And("I go back to search form")
    public void iGoBackToSearchForm() {
        getDriver().findElement(By.xpath("//div[@id='zip-lookup-app']//div[@class='button-container']/a[@title='byaddress']")).click();
    }
}
