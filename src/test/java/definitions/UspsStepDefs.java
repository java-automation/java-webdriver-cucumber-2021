package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static java.lang.Thread.sleep;
import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class UspsStepDefs {
    @When("I go to Lookup ZIP page by address")
    public void iGoToLookupZIPPageByAddress() throws InterruptedException {
        getDriver().findElement(By.xpath("//a[@id='mail-ship-width']")).click();
        getDriver().findElement(By.xpath("//a[contains(@href,'ZipLookupAction')]")).click();
        getDriver().findElement(By.xpath("//a[contains(text(),'Find by Address')]")).click();

        sleep(500);


    }

    @And("I fill out {string} street, {string} city, {string} state")
    public void iFillOutStreetCityState(String street, String city, String state) throws InterruptedException {
        getDriver().findElement(By.xpath("//input[@id='tAddress']")).sendKeys(street);
        getDriver().findElement(By.xpath("//input[@id='tCity']")).sendKeys(city);
        getDriver().findElement(By.xpath("//select[@id='tState']")).click();
        getDriver().findElement(By.xpath("//select[@id='tState']//option[@value='" + state + "']")).click();
        Thread.sleep(2000);
        getDriver().findElement(By.xpath("//a[@id='zip-by-address']")).click();



    }

    @Then("I validate {string} zip code exists in the result")
    public void iValidateZipCodeExistsInTheResult(String zip) throws InterruptedException {
        Thread.sleep(1000);
        WebElement resultContainer = getDriver().findElement(By.xpath("//div[@id='zipByAddressDiv']"));
        String resultString = resultContainer.getText();
        System.out.println(resultString);

        assertThat(resultString).contains(zip);





//        String resultPage = getDriver().findElement(By.xpath("//li[@class='list-group-item paginate'][1]")).getText();
//        assertThat(resultPage).contains(code);
//        getDriver().findElements(By.xpath("//div[@class='zip-code-by-address-body-wrapper']")).contains(code);
    }
}
