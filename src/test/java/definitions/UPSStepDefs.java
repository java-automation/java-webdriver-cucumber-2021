package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import pages.*;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getData;
import static support.TestContext.getDriver;

public class UPSStepDefs {

    HomeUPS homePage = new HomeUPS();
    ShipFromPageUPS shippingPage = new ShipFromPageUPS();
    DestinationPageUPS destinationPage = new DestinationPageUPS();
    PackageUPS packPage = new PackageUPS();
    HowToShipUPS shippingOption = new HowToShipUPS();
    DetailsUPS details = new DetailsUPS();
    ReviewPageUPS reviewInfo = new ReviewPageUPS();


    Map<String, String> sender = getData("shipFromInfo");
    Map<String, String> recipient = getData("recipient");
    Map<String,String> packageData = getData("packageType");

//    Map<String, String> senderData = getData("sender", "ups");
//    Map<String, String> recipientData = getData("recipient", "ups");


    @And("I go to Create a Shipment")
    public void iGoToCreateAShipment() {

        getDriver().findElement(By.xpath("//a[@id='ups-menuLinks2']")).click();
        getDriver().findElement(By.xpath("//em[contains(text(),'Package & Freight')]")).click();

    }


    @When("I fill out origin shipment fields")
    public void iFillOutOriginShipmentFields() throws InterruptedException {

       //new Select(getDriver().findElement(By.xpath("//select[@id='origin-cac_country']"))).selectByVisibleText("United States");
       // Thread.sleep(2000);

//        getDriver().findElement(By.xpath("//select[@name='cac_country']/option[contains(text(),'United States')]")).click();
//        Thread.sleep(3000);


        shippingPage.fillCountry(sender.get("country"));
        shippingPage.fillCompanyOrName(sender.get("companyOrName"));
        Thread.sleep(1000);
        shippingPage.fillAddress(sender.get("addressLine"));
        Thread.sleep(2000);
        shippingPage.fillEmail(sender.get("email"));
        shippingPage.fillPhone(sender.get("phone"));



    }

    @And("I submit the shipment form")
    public void iSubmitTheShipmentForm() throws InterruptedException {


        shippingPage.continueButton();



    }

    @Then("I verify origin shipment fields submitted")
    public void iVerifyOriginShipmentFieldsSubmitted() {


        String actualSummary = destinationPage.getResultSummary();

        assertThat(actualSummary).contains(sender.get("companyOrName"));
       // assertThat(actualSummary).contains(sender.get("addressLine"));
        assertThat(actualSummary).contains(sender.get("email"));
        assertThat(actualSummary).contains(sender.get("phone"));


    }

    @When("I fill out destination shipment fields")
    public void iFillOutDestinationShipmentFields() throws InterruptedException {

        shippingPage.fillCountry(recipient.get("country"));
        destinationPage.fillCompanyOrName(recipient.get("recipientName"));
        destinationPage.fillAddress(recipient.get("destinationAddress"));

    }

    @And("I {string} residential address")
    public void iResidentialAddress(String confirmAddress) {

        if (confirmAddress.equals("confirm")) {
            destinationPage.checkResidentialAddressSwitch();
        } else {
            destinationPage.uncheckResidentialAddressSwitch();
        }
    }

    @And("I set packaging type and weight")
    public void iSetPackagingTypeAndWeight() throws InterruptedException {

        Thread.sleep(2000);

        new Select(getDriver().findElement(By.xpath("//select[@id='nbsPackagePackagingTypeDropdown0']"))).selectByVisibleText("UPS Pak");
        getDriver().findElement(By.xpath("//input[@id='nbsPackagePackageWeightField0']")).sendKeys("2");
        getDriver().findElement(By.xpath("//section[@class='panel panel-default ng-star-inserted']")).click();
        getDriver().findElement(By.xpath("//div[@class='ups-even panel-body ng-star-inserted']")).click();


    }

    @Then("I verify total charges appear")
    public void iVerifyTotalChargesAppear() throws InterruptedException {

        assertThat(shippingOption.areTotalChargesAppear()).isTrue();
    }

    @And("I select cheapest delivery option")
    public void iSelectCheapestDeliveryOption() throws InterruptedException {

       shippingOption.selectCheapestOption();
       shippingOption.clickWithJS(getDriver().findElement(By.id("continueButton")));

    }

    @And("I set description and check Saturday Delivery type if available")
    public void iSetDescriptionAndCheckSaturdayDeliveryTypeIfAvailable() {

       getDriver().findElement(By.xpath("//input[@id='nbsShipmentDescription']")).sendKeys("Saturday Delivery type if available");

    }

    @And("I check Deliver only to receiver's address")
    public void iCheckDeliverOnlyToReceiverSAddress() {

        details.clickCheckBox();
    }

    @Then("I verify total charges changed")
    public void iVerifyTotalChargesChanged() {


    }

    @And("I select Paypal payment type")
    public void iSelectPaypalPaymentType() {

        getDriver().findElement(By.xpath("//div[@id='tile-5']")).click();
    }

    @Then("I review all recorded details on the review page")
    public void iReviewAllRecordedDetailsOnTheReviewPage() {
    }

    @And("I cancel the shipment form")
    public void iCancelTheShipmentForm() {

       reviewInfo.cancel();
    }

    @Then("I verify shipment form is reset")
    public void iVerifyShipmentFormIsReset() {

    }
}
