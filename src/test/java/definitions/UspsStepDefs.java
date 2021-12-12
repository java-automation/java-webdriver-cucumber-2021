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
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;

public class UspsStepDefs {
    //Actions action = new Actions(getDriver());

    @When("I go to Lookup ZIP page by address")
    public void iGoToLookupZIPPageByAddress()  {
        Actions action = new Actions(getDriver());

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
    public void iFillOutStreetCityState(String street, String city, String state) {

        getDriver().findElement(By.xpath("//input[@id='tAddress']")).sendKeys(street);
        getDriver().findElement(By.xpath("//input[@id='tCity']")).sendKeys(city);

        // WORKING
        getDriver().findElement(By.xpath("//select[@id='tState']")).click(); // !!! skip it if its SELECT. BUT NOT IF ITS DIV
        getDriver().findElement(By.xpath("//select[@id='tState']/option[@value='"+state.toUpperCase()+"']")).click();

        // "//select[@id='tState']/option[@value='CA']"
        // action.moveToElement(stateMenu).click().build().perform();
        
       /* // Working with Select :
        WebElement stateMenu = getDriver().findElement(By.xpath("//select[@id='tState']"));
        Select option = new Select(stateMenu);
        option.selectByValue(state);*/
        getDriver().findElement(By.xpath("//a[@id='zip-by-address']")).click();

        /* //CHECK LATER !!!!
        WebElement stateMenu =getDriver().findElement(By.xpath("//select[@id='tState']"));
        Thread.sleep(3000);

        action.moveToElement(stateMenu).click().build().perform();
        action.moveToElement(getDriver().findElement(By.xpath("//select[@id='tState']/option[@value='CA']")))
                .perform();*/

        //Thread.sleep(5000);
        //UNSEL getDriver().findElement(By.xpath("//a[@id='zip-by-address']")).click();
        //Thread.sleep(3000);

    }

    @Then("I validate {string} zip code exists in the result")
    public void iValidateZipCodeExistsInTheResult(String zipCode)  {

     //  //div[@id='zipByAddressDiv']
     //  //div[@class='zipcode-result-address']         // 10 results
     //  //*[@class='zipcode-result-address']//strong   // 10 zip codes
     //   (//*[@class='zipcode-result-address']//strong)[1]
     //   //*[@class='zipcode-result-address']//strong   // resTest


// Assertion 1
        WebElement results=getDriver().findElement(By.xpath("//div[@id='zipByAddressDiv']"));

        WebDriverWait wait = new WebDriverWait(getDriver(), 5);
        wait.until(webDriver -> results.getText().length()>0);

        String res=getDriver().findElement(By.xpath("//div[@id='zipByAddressDiv']//strong")).getText();
        System.out.println("Zip Code for provided address: " + res);

        String resultsString =results.getText(); // w/out //strong RETURNS ALL ADDRESSES

        assertThat(resultsString).contains(zipCode);  // WHY TEST "PASSED" If assertion is incorrect ?!

       /* // Assertion 3 (Should be modified ? )
          List<WebElement> results = getDriver().findElements(By.xpath("//*[@class='zipcode-result-address']//strong"));
          WebDriverWait wait = new WebDriverWait(getDriver(), 5);
          for (WebElement res: results){
              System.out.println(res.getText());
              if (!res.getText().contains(zipCode)){
                  throw new Error ("Assertion failed: " + res.getText());
              }
          }*/


// Assertion 2
//        if (!resTest1.contains(zipCode)){
//           throw new Error ("Result doesn't contain the expected zip code: "+zipCode);
//        }


        /*// ASSERTION 4
        WebElement resultContainer = getDriver().findElement(By.xpath("//div[@id='zipByAddressDiv']"));

        WebDriverWait wait = new WebDriverWait(getDriver(), 5);
        wait.until(driver -> resultContainer.getText().length() > 0);

        String resultString = resultContainer.getText();
        System.out.println(resultString);

        assertThat(resultString).contains(zipCode);*/

    }

    @When("I go to Calculate Price Page")
    public void iGoToCalculatePricePage() {
        Actions action = new Actions(getDriver());
        
        WebElement sendMenu = getDriver().findElement(By.xpath("//a[@id='mail-ship-width']"));
        WebElement calculate = getDriver().findElement(By.xpath("//li[@class='tool-calc']/a[text()='Calculate a Price']"));
        action.moveToElement(sendMenu).click(calculate).build().perform();
        
    }

    @And("I select {string} with {string} shape")
    public void iSelectWithShape(String country, String parcelType) {
        WebElement countryMenu = getDriver().findElement(By.xpath("//select[@id='CountryID']"));
        new Select(countryMenu).selectByVisibleText(country);

        getDriver().findElement(By.xpath("//input[@name='action'][@value='"+parcelType+"']")).click();
    }

    @And("I define {string} quantity")
    public void iDefineQuantity(String quantity) {
        getDriver().findElement(By.id("quantity-0")).sendKeys(quantity);
    }

    @Then("I calculate the price and validate cost is {string}")
    public void iCalculateThePriceAndValidateCostIs(String cost) {
        getDriver().findElement(By.xpath("//input[@type='button']")).click();

        String resultCost = getDriver().findElement(By.xpath("//div[@id='cost-0']")).getText();
        String totalCost = getDriver().findElement(By.xpath("//div[@id='total']")).getText();
        System.out.println("Cost: "+resultCost);

        assertThat(resultCost).isEqualTo(cost);
        assertThat(totalCost).isEqualTo(cost);
        
    }

    @When("I perform {string} search")
    public void iPerformSearch(String product) {
        // Search : //a[@class='menuitem'][@href='#']
        // Free Boxes : (//a[contains(@href,'Free%20Boxes')])[1]
        // Filters : //a[@class='show-filters mobile']
        Actions action = new Actions(getDriver());

        action.moveToElement(getDriver().findElement(By.xpath("//a[@class='menuitem'][@href='#']"))).perform();
        action.moveToElement(getDriver().findElement(By.xpath("(//a[contains(@href,'Free%20Boxes')])[1]")))
                .click().build().perform();



    }

    @And("I set {string} in filters")
    public void iSetInFilters(String filterOption) {
        // //div[@id='dyn_nav']
        // //input[@id='category-checkbox-5']/..//label[text()='Send']  works
        // //div[@class='dn-attr-txt']//label[text()='Send']
        // //div//label[text()='Send']

        WebDriverWait wait = new WebDriverWait(getDriver(),6);
        wait.until(ExpectedConditions.visibilityOf(getDriver()
                .findElement(By.xpath("//div[@id='dyn_nav_col']"))));

        WebElement filter =getDriver().findElement(By.xpath("//div//label[text()='"+filterOption+"']"));

        wait.until(ExpectedConditions.visibilityOf(filter)).click();

        wait.until(ExpectedConditions.visibilityOf(getDriver()
                .findElement(By.xpath("//span[@id='searchResultsHeading']"))));

    }
    @Then("I verify that {string} results found")
    public void iVerifyThatResultsFound(String numOfResults) {
        //  //ul[@id='records'] => 7 li class= col-gl-12 col-md-12 result-item
        //  //a[@ctype='c']  => 7 links !!!

        WebElement searchResults = getDriver().findElement(By.xpath("//span[@id='searchResultsHeading']"));
        System.out.println(searchResults.getText());
        assertThat(searchResults.getText()).contains(numOfResults+" results found for");
        
    }

    @When("I select {string} in results")
    public void iSelectInResults(String resultOption) {
        getDriver().findElement(By.xpath("//span[contains(text(),'"+resultOption+"')]")).click();
    }

    @And("I click {string} button")
    public void iClickButton(String buttonText) {
        getDriver().findElement(By.xpath("//a[text()='"+buttonText+" ']")).click();

    }

    @Then("I validate that Sign In is required")
    public void iValidateThatSignInIsRequired() {
        for ( String handle : getDriver().getWindowHandles()){
            getDriver().switchTo().window(handle);

            if (getDriver().getTitle().equals("USPS.com® - Sign In")){
                String signIn =getDriver()
                        .findElement(By.xpath("//h1[@id='sign-in-to-your-account-header']")).getText();

                assertThat(signIn).contains("Sign In To Your Account");

                System.out.println(signIn);

                //getDriver().close();
            }
        } getDriver().quit();

    }
}
