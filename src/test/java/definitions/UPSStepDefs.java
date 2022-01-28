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
    DestinationPageUPS destinationPage = new DestinationPageUPS();
    ShipFromPageUPS shippingPage = new ShipFromPageUPS();
    PackageUPS packPage = new PackageUPS();
    HowToShipUPS shippingOption = new HowToShipUPS();


    Map<String, String> sender = getData("shipFromInfo");
    Map<String, String> recipient = getData("recipient");

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
        Thread.sleep(3000);
        shippingPage.fillEmail(sender.get("email"));
        shippingPage.fillPhone(sender.get("phone"));



    }

    @And("I submit the shipment form")
    public void iSubmitTheShipmentForm() {

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
        Thread.sleep(1000);
        destinationPage.fillCompanyOrName(recipient.get("recipientName"));
        Thread.sleep(2000);
        destinationPage.fillAddress(recipient.get("destinationAddress"));
        Thread.sleep(2000);
        destinationPage.fillEmail(recipient.get("email"));
        destinationPage.fillPhone(recipient.get("phone"));


    }

    @And("I {string} residential address")
    public void iResidentialAddress(String confirmAddress) {




    }

    @And("I set packaging type and weight")
    public void iSetPackagingTypeAndWeight() throws InterruptedException {

        Thread.sleep(2000);

        new Select(getDriver().findElement(By.xpath("//select[@id='nbsPackagePackagingTypeDropdown0']"))).selectByVisibleText("UPS Pak");

        getDriver().findElement(By.xpath("//input[@id='nbsPackagePackageWeightField0']")).sendKeys("2");

       // getDriver().findElement(By.xpath("//section[@class='panel panel-default ng-star-inserted']")).click();

        getDriver().findElement(By.xpath("//div[@class='ups-even panel-body ng-star-inserted']")).click();


    }

    @Then("I verify total charges appear")
    public void iVerifyTotalChargesAppear() throws InterruptedException {

        String shippingChoice = shippingOption.getPriceResult();

        assertThat(shippingChoice).contains("nextDayAirEarly");
        assertThat(shippingChoice).contains("nextDayAir");
        assertThat(shippingChoice).contains("nextDayAirSaver");
        assertThat(shippingChoice).contains("upsSecondDayAirAM");
        assertThat(shippingChoice).contains("upsSecondDayAir");
    }

    @And("I select cheapest delivery option")
    public void iSelectCheapestDeliveryOption() throws InterruptedException {

        Thread.sleep(2000);

        shippingOption.cheapestOption();

    }
}
