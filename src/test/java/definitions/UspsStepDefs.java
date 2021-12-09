package definitions;

import org.junit.Assert;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import static support.TestContext.getDriver;
import static org.assertj.core.api.AbstractBooleanAssert.setPrintAssertionsDescription;
import org.openqa.selenium.WebElement;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;

public class UspsStepDefs {
    Actions action = new Actions(getDriver());

    @When("I go to Lookup ZIP page by address")
    public void iGoToLookupZIPPageByAddress()  {
        //Actions action = new Actions(getDriver());

//        action.moveToElement(getDriver().findElement(By.xpath("//a[@id='mail-ship-width']"))).perform();
//        Thread.sleep(2000);
//        action.moveToElement(getDriver().findElement(By.xpath("//a[text()='Look Up a ZIP Code']"))).click().build().perform();

        action.moveToElement(getDriver().findElement(By.xpath("//a[@id='mail-ship-width']"))).click(getDriver().findElement(By.xpath("//a[text()='Look Up a ZIP Code']"))).build().perform();
        action.moveToElement(getDriver().findElement(By.xpath("//a[contains(text(),'Find by Address')]"))).click().build().perform();

        // Send : //a[@id='mail-ship-width']
        // Look up Zip  Code : //a[text()='Look Up a ZIP Code']
        // Find by Address : //a[contains(text(),'Find by Address')]
        //Street Address input : //input[@id='tAddress']
        // City input : //input[@id='tCity']
        // State Dropdown: //select[@id='tState']
        // In State Dropdown state CA : //select[@id='tState']/option[@value='CA']
        // Button FIND : //a[@id='zip-by-address']
    }

    @And("I fill out {string} street, {string} city, {string} state")
    public void iFillOutStreetCityState(String street, String city, String state) throws InterruptedException {

        getDriver().findElement(By.xpath("//input[@id='tAddress']")).sendKeys(street);
        getDriver().findElement(By.xpath("//input[@id='tCity']")).sendKeys(city);

        getDriver().findElement(By.xpath("//select[@id='tState']")).click();
        getDriver().findElement(By.xpath("//select[@id='tState']/option[@value='"+state+"']")).click();
        //action.moveToElement(getDriver().findElement(By.xpath("//select[@id='tState']/option[@value='CA']"))).click().build().perform();
        //Thread.sleep(5000);
        getDriver().findElement(By.xpath("//a[@id='zip-by-address']")).click();
        Thread.sleep(3000);

    }

    @Then("I validate {string} zip code exists in the result")
    public void iValidateZipCodeExistsInTheResult(String zipCode) {

     //  //div[@id='zipByAddressDiv']
     //  //div[@class='zipcode-result-address']         // 10 results
     //  //*[@class='zipcode-result-address']//strong   // 10 zip codes
     //   (//*[@class='zipcode-result-address']//strong)[1]
     //   //*[@class='zipcode-result-address']//strong   // resTest

     // For validation Error messages   String errorMessage=getDriver().findElement(By.xpath("//div[contains(@class,'server-error address-tAddress')]")).getText();
      //  System.out.println("Incorrect address Error: "+ errorMessage);
        // //div[contains(@class,'server-error address-tCity')]

// Assertion 1
//        String res=getDriver().findElement(By.xpath("//div[@id='zipByAddressDiv']//strong")).getText();
//        String resTest1=getDriver().findElement(By.xpath("//div[@id='zipByAddressDiv']")).getText(); // w/out //strong RETURNS ALL ADDRESSES
//        System.out.println("Zip Code for provided address: " + res);
//        assertThat(resTest1).contains(zipCode);  // WHY TEST "PASSED" If assertion is incorrect ?!

        // Assertion 3 (Should be modified ? )
          List<WebElement> results = getDriver().findElements(By.xpath("//*[@class='zipcode-result-address']//strong"));


          for (WebElement res: results){
              System.out.println(res.getText());
              if (!res.getText().contains(zipCode)){
                  throw new Error ("Assertion failed: " + res.getText());
              }
          }


// Assertion 2
//        if (!resTest1.contains(zipCode)){
//           throw new Error ("Result doesn't contain the expected zip code: "+zipCode);
//        }




    }
}
