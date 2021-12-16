package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.grid.common.SeleniumProtocol.WebDriver;
import static support.TestContext.getDriver;

public class UspsStepDefs {

    @When("I go to Lookup ZIP page by address")
    public void iGoToLookupZIPPageByAddress() {
        WebElement sendMenuButton = getDriver().findElement(By.xpath("//a[@id='mail-ship-width']"));

        //mouseover
        Actions actions = new Actions(getDriver());
        actions.moveToElement(sendMenuButton).perform(); // offset = 100*100 - area to cover around element

        WebElement lookUpZip = getDriver().findElement(By.xpath("//li[@class='tool-zip']//a[contains(@href,'zip')]"));
        WebDriverWait wait = new WebDriverWait(getDriver(),5);
        wait.until(ExpectedConditions.elementToBeClickable(lookUpZip));
        lookUpZip.click();

//        getDriver().findElement(By.xpath("//a[text()='Look Up a ZIP Code']")).click(); better avoid Text!
        getDriver().findElement(By.xpath("//a[@data-location='byaddress' and contains(@class,'zip-code-home') and contains(@class,'primary')]")).click();

    }

    @And("I fill out {string} street, {string} city, {string} state")
    public void iFillOutStreetCityState(String street, String city, String state) throws InterruptedException {
        getDriver().findElement(By.xpath("//input[@id='tAddress']")).sendKeys(street);
        getDriver().findElement(By.xpath("//input[@id='tCity']")).sendKeys(city);
//        getDriver().findElement(By.xpath("//input[@id='tState']")).click();
       // getDriver().findElement(By.xpath("//select[@id='tState']/option[@value='CA']")).click();
      //  getDriver().findElement(By.xpath("//select[@id='tState']/option[@value='" +state + "']")).click();

        // select
        WebElement selectElement = getDriver().findElement(By.xpath("//select[@id='tState']"));
        new Select(selectElement).selectByValue(state);

        Thread.sleep(2000);
        getDriver().findElement(By.id("zip-by-address")).click();
    }

    @Then("I validate {string} zip code exists in the result")
    public void iValidateZipCodeExistsInTheResult(String zipCode) {
        WebElement resultContainer = getDriver().findElement(By.id("zipByAddressDiv"));

        WebDriverWait wait = new WebDriverWait(getDriver(),5);

        wait.until(ExpectedConditions.textToBePresentInElement(resultContainer,zipCode));
        wait.until(ExpectedConditions.visibilityOf(resultContainer));
        wait.until(driver -> resultContainer.getText().length() > 0);
        wait.until(ExpectedConditions.titleContains("ZIP Code™ Lookup | USPS"));
//        wait.until(driver -> driver.getTitle().equals("ZIP Code™ Lookup | USPS")); // lambda expression
        // use it when you don't have needed method in ExpectedConditions. You need to check specific scenario

        String resultString = resultContainer.getText();
        System.out.println(resultString);

        Assertions.assertThat(resultString).contains(zipCode);
    }

}
