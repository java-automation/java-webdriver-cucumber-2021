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

import static support.TestContext.getDriver;

// Home_work_4 Usps

public class UspsStepDefs {
    @When("I go to {string} under {string}")
    public void iGoToUnder(String mail, String business) throws InterruptedException {

        WebElement sendBusiness = getDriver().findElement(By.xpath("//li[@class='menuheader']/a[contains(@href,'business/')]"));
        new Actions(getDriver()).moveToElement(sendBusiness).perform();
        Thread.sleep(3000);

        //getDriver().findElement(By.xpath("//li[@class='tool-eddm']/a[contains(@href,'eddm')]")).click();---- the same as bellow
        getDriver().findElement(By.xpath("//li[@class='tool-eddm']/a[contains(text(),'" + mail + "')]")).click();


    }

    @And("I search for {string}")
    public void iSearchFor(String address) throws InterruptedException {
        getDriver().findElement(By.xpath("//input[@id='cityOrZipCode']")).sendKeys(address);
        Thread.sleep(3000);
    }

    @Then("I click search")
    public void iClickSearch() throws InterruptedException {
        getDriver().findElement(By.xpath("//div[@class='search-btn-container search-btn-wrapper form-group']/a[contains(text(),'Search')]")).click();
        Thread.sleep(7000);
    }


    @And("I choose view as {string} on the map")
    public void iChooseViewAsOnTheMap(String table) throws InterruptedException {

        WebElement refineSearch = getDriver().findElement(By.xpath("//div[@class='col-9 step-1-map-wrapper']"));

        new Actions(getDriver()).moveToElement(refineSearch).perform();
       Thread.sleep(3000);

      //  getDriver().findElement(By.xpath("//a/span[contains(text(),'Table')]")).click(); ----the same as bellow
        getDriver().findElement(By.xpath("//a/span[contains(text(),'" + table + "')]")).click();

        Thread.sleep(5000);


    }


    @When("I select all in the table")
    public void iSelectAllInTheTable() throws InterruptedException {
        getDriver().findElement(By.xpath("//thead/tr[1]/th[1]/label[1]/span[1]")).click();
        ////label/input[@id='select-all-checkboxes']/span[@class='checkbox']

        Thread.sleep(5000);
    }

    @And("I close modal window")
    public void iCloseModalWindow() throws InterruptedException {

        WebElement window = getDriver().findElement(By.xpath("//body/div[@id='drop-off-location-modal']/div[1]/div[1]"));
        new Actions(getDriver()).moveToElement(window).perform();
        Thread.sleep(3000);

        //getDriver().findElement(By.xpath("//div[@class='modal-header']/a[@data-dismiss='modal']/span[@class='visuallyhidden']")).click();

        getDriver().findElement(By.xpath("//a[@id='closeAndUpdateTotals']")).click();
        Thread.sleep(3000);
    }

    @Then("I verify that summary of all rows of Cost column is equal Approximate Cost in Order Summar")
    public void iVerifyThatSummaryOfAllRowsOfCostColumnIsEqualApproximateCostInOrderSummar() throws InterruptedException {

     WebElement summary = getDriver().findElement(By.xpath("//div[@class=' gray-box flex-column']"));
      //  WebDriverWait wait = new WebDriverWait(getDriver(), 5);
      //  wait.until(titleContains("$3810.60"));

     String price = "Approximate Cost";
        WebDriverWait wait = new WebDriverWait(getDriver(), 2);
        wait.until(ExpectedConditions.textToBePresentInElement(summary,price));




    }

   // Home_work_12/28/21



    @When("I go to Lookup ZIP page by address")
    public void iGoToLookupZIPPageByAddress() throws InterruptedException {

        WebElement sendMenu = getDriver().findElement(By.xpath("//a[@id='mail-ship-width']"));
        new Actions(getDriver()).moveToElement(sendMenu).perform();
        Thread.sleep(3000);
        getDriver().findElement(By.xpath("//li[@class='tool-zip']/a[contains(@href,'zip')]")).click();

        getDriver().findElement(By.xpath("//a[text()='Find by Address']")).click();

    }

    @And("I fill out {string} street, {string} city, {string} state")
    public void iFillOutStreetCityState(String street, String city, String state) throws InterruptedException {
        getDriver().findElement(By.xpath("//input[@name='tAddress']")).sendKeys(street);
        getDriver().findElement(By.xpath("//input[@name='tCity']")).sendKeys(city);

        WebElement selectElement = getDriver().findElement(By.xpath("//select[@id='tState']"));
        new Select(selectElement).selectByValue(state);
        getDriver().findElement(By.xpath("//select[@id='tState']/option[@value='" + state + "']")).click();
        getDriver().findElement(By.xpath("//a[@id='zip-by-address']")).click();

//        getDriver().findElement(By.xpath("//select[@id='tState']")).click();
//        Thread.sleep(3000);
//        getDriver().findElement(By.xpath("//select[@id='tState']/option[@value='IL']")).click();
//        Thread.sleep(3000);
       // getDriver().findElement(By.xpath("//a[@id='zip-by-address']")).click();
    }

    @Then("I validate {string} zip code exists in the result")
    public void iValidateZipCodeExistsInTheResult(String zip) throws InterruptedException {

        WebElement resultContainer = getDriver().findElement(By.xpath("//div[@id='zipByAddressDiv']"));
        WebDriverWait wait = new WebDriverWait(getDriver(), 5);

        wait.until(ExpectedConditions.visibilityOf(resultContainer));
        wait.until(ExpectedConditions.textToBePresentInElement(resultContainer, zip));
//        wait.until(driver -> resultContainer.getText().length() > 0);
//
//
//        String resultString = resultContainer.getText();
//        System.out.println(resultString);
//
//        Assertions.assertThat(resultString).contains(zip);
//
//        Thread.sleep(3000);
//        getDriver().findElement(By.xpath("//a[@id='zip-by-address']")).click();
//        Thread.sleep(3000);
//
//        String resultZip = getDriver().findElement(By.xpath("//div[@id='zip-lookup-app']")).getText();
//        System.out.println(resultZip);
//        Assertions.assertThat(resultZip).contains("60605");
//        Thread.sleep(3000);


        }

    // Home_work_12/28/21

    @When("I go to {string}  tab")
    public void iGoToTab(String tab) throws InterruptedException {

        getDriver().findElement(By.xpath("//li[@class='menuheader']//a[text()='" + tab + "']")).click();

        Thread.sleep(4000);
    }

    @And("I perform {string} help search")
    public void iPerformHelpSearch(String search) throws InterruptedException {

      WebElement searchMenu = getDriver().findElement(By.xpath("//div[@class='searchBox']"));
      new Actions(getDriver()).moveToElement(searchMenu).perform();
        Thread.sleep(3000);

        getDriver().findElement(By.xpath("//div[@class='searchBox']")).click();
        //getDriver().findElement(By.xpath("//div[@class='searchBox']")).sendKeys(search);

        Thread.sleep(3000);

        getDriver().findElement(By.xpath("//button[@class='slds-button slds-button_brand search-button']")).click();
    }

    @Then("I verify that no results of {string} available in help search")
    public void iVerifyThatNoResultsOfAvailableInHelpSearch(String result) {

        WebElement resultArticles = getDriver().findElement(By.xpath("//div[@class='resultsWrapper']"));
        WebDriverWait wait = new WebDriverWait(getDriver(), 5);

        wait.until(ExpectedConditions.visibilityOf(resultArticles));
        wait.until(ExpectedConditions.textToBePresentInElement(resultArticles, result));

    }


    //Home_work_12/28/21
    @When("I navigate to {string} heading link")
    public void iNavigateToHeadingLink(String tab) {

        getDriver().findElement(By.xpath("//div//a[text()='" + tab + "']")).click();
    }

    @And("I search for location {string}")
    public void iSearchForLocation(String location) throws InterruptedException {

        getDriver().findElement(By.xpath("//input[@id='city-state-input']")).sendKeys(location);
        Thread.sleep(1000);

        getDriver().findElement(By.xpath("//div//a[@id='searchLocations']")).click();
        Thread.sleep(1000);

    }

    @Then("I verify closest location phone number is {string}")
    public void iVerifyClosestLocationPhoneNumberIs(String number) {

        getDriver().findElement(By.xpath("//div[@id='1370964']")).click();

        WebElement showingResults = getDriver().findElement(By.xpath("//div[@class='col-md-4 col-sm-4 col-xs-12 location-address-phone']"));
        WebDriverWait wait = new WebDriverWait(getDriver(), 4);

        wait.until(ExpectedConditions.visibilityOf(showingResults));
        wait.until(ExpectedConditions.textToBePresentInElement(showingResults, number));

    }
}

