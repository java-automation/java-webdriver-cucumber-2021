package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import pages.ShipFromPageUPS;

import java.util.Map;

import static support.TestContext.getData;
import static support.TestContext.getDriver;

public class UPSStepDefs {

    ShipFromPageUPS shippingPage = new ShipFromPageUPS();

    Map<String, String> sender = getData("shipFromInfo");


    @And("I go to Create a Shipment")
    public void iGoToCreateAShipment() {

        getDriver().findElement(By.xpath("//a[@id='ups-menuLinks2']")).click();
        getDriver().findElement(By.xpath("//em[contains(text(),'Package & Freight')]")).click();

    }


    @When("I fill out origin shipment fields")
    public void iFillOutOriginShipmentFields()  {




       //new Select(getDriver().findElement(By.xpath("//select[@id='origin-cac_country']"))).selectByVisibleText("United States");
       // Thread.sleep(2000);

//        getDriver().findElement(By.xpath("//select[@name='cac_country']/option[contains(text(),'United States')]")).click();
//        Thread.sleep(3000);




        shippingPage.fillCountry(sender.get("country"));
        shippingPage.fillCompanyOrName(sender.get("companyOrName"));
        shippingPage.fillAddressLine(sender.get("addressLine"));
        shippingPage.fillAddressLine2(sender.get("addressLine2"));
        shippingPage.fillCity(sender.get("city"));
        shippingPage.fillZipCode(sender.get("zipCode"));
        shippingPage.fillState(sender.get("state"));
        shippingPage.fillEmail(sender.get("email"));
        shippingPage.fillPhone(sender.get("phone"));



      //  new Select(getDriver().findElement(By.xpath("//select[@id='origin-cac_state']"))).selectByVisibleText(sender.get("state"));
     //   Thread.sleep(2000);

//        getDriver().findElement(By.xpath("//select[@id='origin-cac_state']/option[contains(text(),'Illinois')]")).click();
//        Thread.sleep(2000);



    }
}
