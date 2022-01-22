package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.QuoteForm;
import pages.UpsMainPage;
import pages.UpsShipmentPage;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getData;
import static support.TestContext.getDriver;

public class UpsOopStepDefs {

    UpsMainPage form = new UpsMainPage();
    UpsShipmentPage shipForm = new UpsShipmentPage();

    Map<String, String> origin = getData("ups_origin");

    By spinner = By.xpath("//img[@id='spinnerImg']");

    By checkOutAddressBlock = By.xpath("//div[contains(@class,'ups-group_condensed')]");


    public void waitForSpinner(int iSeconds) {
        WebDriverWait wait = new WebDriverWait(getDriver(),iSeconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(spinner));
    }

    public void waitForSpinnerDisappear(int iSeconds) {
        WebDriverWait wait = new WebDriverWait(getDriver(),iSeconds);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(spinner));
    }

    @Given("I go to {string} main page")
    public void iGoToMainPage(String arg0) {
        form.open();
    }

    @And("I go to Create a Shipment")
    public void iGoToCreateAShipment() {
        form.menubarShipping.click();
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.elementToBeClickable(form.submenuCreateAShipment));
        form.submenuCreateAShipment.click();
//        waitForSpinner(20);
        waitForSpinnerDisappear(60);
        shipForm.waitContinueButtonAvailable(60);
    }

    @When("I fill out origin shipment fields")
    public void iFillOutOriginShipmentFields() {
        shipForm.setCountryOrTerritoryByText(origin.get("countryName"));
        shipForm.setFullNameOrCompany(origin.get("fullName"));
        shipForm.setAddress(origin.get("address"));
        shipForm.setEmail(origin.get("email"));
        shipForm.setPhone(origin.get("phone"));
        new Actions(getDriver()).doubleClick(shipForm.getPhoneExtension()).perform();   //looks like without field exit after text set it doesn't save, so just making exit to the nearest field
    }

    @And("I submit the shipment form")
    public void iSubmitTheShipmentForm() {
        if (getDriver().findElement(By.xpath("//div[@role='alert']/button[@class='close_btn_thick']")).isDisplayed()) {
            getDriver().findElement(By.xpath("//div[@role='alert']/button[@class='close_btn_thick']")).click();
        }
        shipForm.continueButton.click();
    }

    @Then("I verify origin shipment fields submitted")
    public void iVerifyOriginShipmentFieldsSubmitted() {
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.visibilityOfElementLocated(checkOutAddressBlock));
        assertThat(shipForm.getNameLineResultText()).contains(origin.get("fullName"));
        assertThat(shipForm.getAddressLineResult()).contains(origin.get("address"));
        assertThat(shipForm.getCountryLineResult()).contains(origin.get("countryShortName"));
        assertThat(shipForm.getContactLineResult()).contains(origin.get("email"));
        assertThat(shipForm.getContactLineResult()).contains(origin.get("phone"));
    }
}
