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
                getDriver().findElement(By.xpath("//ul[@class='nav-list']//a[contains(@class,'nav-first-element')]")).click();
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
}
