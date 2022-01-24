package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.seleniumhq.jetty9.server.handler.IPAccessHandler;
import pages.QuoteForm;
import pages.UpsMainPage;
import pages.UpsPackagePage;
import pages.UpsShipmentPage;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getData;
import static support.TestContext.getDriver;

public class UpsOopStepDefs {

    UpsMainPage form = new UpsMainPage();
    UpsShipmentPage shipForm = new UpsShipmentPage();
    UpsPackagePage packagePage = new UpsPackagePage();

    Map<String, String> origin = getData("ups_origin");
    Map<String, String> destination = getData("ups_destination");

    JavascriptExecutor js = (JavascriptExecutor) getDriver();

    By spinner = By.xpath("//img[@id='spinnerImg']");

    By checkOutAddressBlock = By.xpath("//div[contains(@class,'ups-group_condensed')]");

    String totalCharges;


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
        WebElement currentButton = shipForm.continueButton;
        String sButtonCaption = "";

        if (getDriver().findElement(By.xpath("//div[@role='alert']/button[@class='close_btn_thick']")).isDisplayed()) {
            getDriver().findElement(By.xpath("//div[@role='alert']/button[@class='close_btn_thick']")).click();
        }

        try {
            sButtonCaption = currentButton.getText();
//            new Actions(getDriver()).moveToElement(currentButton).click(currentButton).perform();
        } catch (NoSuchElementException e) {
            currentButton = shipForm.reviewButton;
        } finally {
            js.executeScript("arguments[0].scrollIntoView();", currentButton);
            new Actions(getDriver()).moveToElement(currentButton).click(currentButton).perform();
        }

//        if (shipForm.continueButton.isDisplayed()) {
//            js.executeScript("arguments[0].scrollIntoView();", shipForm.continueButton);
//            new Actions(getDriver()).moveToElement(shipForm.continueButton).click(shipForm.continueButton).perform();
//        } else if (shipForm.reviewButton.isDisplayed()) {
//            js.executeScript("arguments[0].scrollIntoView();", shipForm.reviewButton);
//            new Actions(getDriver()).moveToElement(shipForm.reviewButton).click(shipForm.reviewButton).perform();
//        }
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

    @When("I fill out destination shipment fields")
    public void iFillOutDestinationShipmentFields() {
        shipForm.setCountryOrTerritoryDestinationByText(destination.get("countryName"));
        shipForm.setFullNameOrCompanyDestination(destination.get("fullName"));
        shipForm.setAddressDestination(destination.get("address"));
        shipForm.setEmailDestination(destination.get("email"));
        shipForm.setPhoneDestination(destination.get("phone"));
        new Actions(getDriver()).doubleClick(shipForm.getPhoneExtensionDestination()).perform();   //looks like without field exit after text set it doesn't save, so just making exit to the nearest field
    }

    @And("I {string} residential address")
    public void iResidentialAddress(String sConfirmOrNot) {
        if (sConfirmOrNot.toLowerCase() == "confirm") {
            shipForm.setResidentialSliderTo("yes");
        } else {
            shipForm.setResidentialSliderTo("no");
        }
    }

    @And("I set packaging type and weight")
    public void iSetPackagingTypeAndWeight() {
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.elementToBeClickable(packagePage.getPackagingType()));
        packagePage.setPackagingType("UPS Express Box - Small");
        new WebDriverWait(getDriver(), 5).until(ExpectedConditions.textToBePresentInElement(packagePage.getDescriptionBlock(), "UPS Express Box"));
        do
            packagePage.setWeight("2");
        while (!packagePage.getWeightValue().contains("2"));
        new WebDriverWait(getDriver(), 5).until(ExpectedConditions.textToBePresentInElementValue(packagePage.getWeight(), "2"));
    }

    @Then("I verify total charges appear")
    public void iVerifyTotalChargesAppear() {
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.visibilityOf(packagePage.getTotalCharges()));
    }

    @And("I select cheapest delivery option")
    public void iSelectCheapestDeliveryOption() {
        new WebDriverWait(getDriver(), 5).until(ExpectedConditions.elementToBeClickable(packagePage.getCheapestDelivery()));
        packagePage.getCheapestDelivery().click();
        new WebDriverWait(getDriver(), 5).until(ExpectedConditions.visibilityOf(packagePage.getCheapestDeliverySelected()));
        assertThat(packagePage.getCheapestDeliverySelected().isDisplayed()).isTrue();
    }

    @And("I set description and check Saturday Delivery type if available")
    public void iSetDescriptionAndCheckSaturdayDeliveryTypeIfAvailable() {
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.elementToBeClickable(packagePage.getDescription()));
        packagePage.setDescription("Some description");
        assertThat(packagePage.getDescription().getAttribute("value")).isEqualTo("Some description");
    }

    @And("I check Deliver only to receiver's address")
    public void iCheckDeliverOnlyToReceiverSAddress() {
        totalCharges = packagePage.getTotalCharges().getText().trim();
        packagePage.setDeliverOnlyToReciever();
    }

    @Then("I verify total charges changed")
    public void iVerifyTotalChargesChanged() {
        new WebDriverWait(getDriver(), 5).until(ExpectedConditions.visibilityOf(packagePage.totalChargesSpinner));
        new WebDriverWait(getDriver(), 5).until(ExpectedConditions.invisibilityOf(packagePage.totalChargesSpinner));
        assertThat(packagePage.getTotalCharges().getText().trim()).isNotEqualTo(totalCharges);
    }

    @And("I select Paypal payment type")
    public void iSelectPaypalPaymentType() {
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.elementToBeClickable(packagePage.getPaypalPayment()));
        packagePage.getPaypalPayment().click();
        new WebDriverWait(getDriver(), 5).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//section[@class='ng-untouched ng-pristine ng-valid']")));
    }

    @Then("I review all recorded details on the review page")
    public void iReviewAllRecordedDetailsOnTheReviewPage() {
//        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.visibilityOf(packagePage.getFinalResults()));
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.visibilityOfElementLocated(checkOutAddressBlock));
        assertThat(shipForm.getNameLineResultText()).contains(origin.get("fullName"));
        assertThat(shipForm.getAddressLineResult()).contains(origin.get("address"));
        assertThat(shipForm.getContactLineResult()).contains(origin.get("email"));
        assertThat(shipForm.getContactLineResult()).contains(origin.get("phone"));
        assertThat(shipForm.getDestinationNameLineResultText()).contains(destination.get("fullName"));
        assertThat(shipForm.getDestinationContactLineResult()).contains(destination.get("email"));
        assertThat(shipForm.getDestinationContactLineResult()).contains(destination.get("phone"));
    }

    @And("I cancel the shipment form")
    public void iCancelTheShipmentForm() {
        js.executeScript("arguments[0].scrollIntoView();", shipForm.cancelButton);
        shipForm.cancelButton.click();
        new WebDriverWait(getDriver(), 5).until(ExpectedConditions.elementToBeClickable(shipForm.yesForCancel));
        shipForm.yesForCancel.click();
    }

    @Then("I verify shipment form is reset")
    public void iVerifyShipmentFormIsReset() {
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.visibilityOf(shipForm.header));
    }
}
