package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import static org.assertj.core.api.Assertions.*;
import static support.TestContext.getDriver;

public class UspsStepDefs {

    @When("I go to Lookup ZIP page by address")
    public void iGoToLookupZIPPageByAddress() throws InterruptedException {
        WebElement sendMenu = getDriver().findElement(By.xpath("//a[@id='mail-ship-width']"));
        new Actions(getDriver()).moveToElement(sendMenu).perform();
        getDriver().findElement(By.xpath("//li[@class='tool-zip']/a[contains(@href,'zip')]")).click();
        getDriver().findElement(By.xpath("//a[contains(@href,'byaddress')][contains(@class,'zip-code-home')][contains(@class,'primary')]")).click();
    }

    @And("I fill out {string} street, {string} city, {string} state")
    public void iFillOutStreetCityState(String street, String city, String state) {
        getDriver().findElement(By.xpath("//input[@id='tAddress']")).sendKeys(street);
        getDriver().findElement(By.xpath("//input[@id='tCity']")).sendKeys(city);

        WebElement selectElement = getDriver().findElement(By.xpath("//select[@id='tState']"));
        new Select(selectElement).selectByValue(state);
//      getDriver().findElement(By.xpath("//select[@id='tState']/option[@value='" + state + "']")).click();
        getDriver().findElement(By.xpath("//a[@id='zip-by-address']")).click();
    }

    @Then("I validate {string} zip code exists in the result")
    public void iValidateZipCodeExistsInTheResult(String zip) {
        WebElement resultContainer = getDriver().findElement(By.xpath("//div[@id='zipByAddressDiv']"));

        WebDriverWait wait = new WebDriverWait(getDriver(), 5);
//        wait.until(ExpectedConditions.visibilityOf(resultContainer));
//        wait.until(ExpectedConditions.textToBePresentInElement(resultContainer, zip));
        wait.until(driver -> resultContainer.getText().length() > 0);

        String resultString = resultContainer.getText();
        System.out.println(resultString);

        assertThat(resultString).contains(zip);
    }

    @When("I go to Calculate Price Page")
    public void iGoToCalculatePricePage() {
        WebElement sendMenu = getDriver().findElement(By.xpath("//a[@id='mail-ship-width']"));
        new Actions(getDriver()).moveToElement(sendMenu).perform();
        getDriver().findElement(By.xpath("//a[contains(text(),'Calculate a Price')]")).click();
    }

    @And("I select {string} with {string} shape")
    public void iSelectWithShape(String destination, String shape) {
        WebElement selectElement = getDriver().findElement(By.xpath("//select[@id='CountryID']"));
        new Select(selectElement).selectByVisibleText(destination);
        getDriver().findElement(By.xpath("//input[@name='action'][@value='" + shape + "']")).click();
    }

    @And("I define {string} quantity")
    public void iDefineQuantity(String quantity) {
        getDriver().findElement(By.xpath("//input[@id='quantity-0']")).sendKeys(quantity);
    }

    @Then("I calculate the price and validate cost is {string}")
    public void iCalculateThePriceAndValidateCostIs(String cost) {
        getDriver().findElement(By.xpath("//input[@value='Calculate']")).click();
        String totalCost = getDriver().findElement(By.xpath("//div[@id='total']")).getText();
        assertThat(totalCost).isEqualTo(cost);
    }

    @When("I perform {string} search")
    public void iPerformSearch(String searchString) throws InterruptedException {
        //WebElement searchIcon = getDriver().findElement(By.xpath("//a[@id='navsearch']/following-sibling::a"));
        //Axes:
        //starting_tag/following-sibling::tagname[predicate]
        //starting_tag/ancestor::tagname[predicate] - all the way up

        WebElement searchIcon = getDriver().findElement(By.xpath("//a[@id='navsearch']/.."));
        WebElement searhInput = getDriver().findElement(By.xpath("//input[@id='global-header--search-track-search']"));
        //   //input[@id='global-header--search-track-search']/../input[@value='Search']
        Actions actions = new Actions(getDriver());

        actions.moveToElement(searchIcon).perform();

        Thread.sleep(5000);


//        WebElement search = getDriver().findElement(By.xpath("//a[contains(text(),'Search USPS.com')]"));
//        new Actions(getDriver()).moveToElement(search).perform();
//        WebElement searchItem = (getDriver().findElement(By.xpath("(//a[@role='menuitem'][text()='" + searchString.toUpperCase() + "'])[1]")));
//        new Actions(getDriver()).moveToElement(searchItem).click().perform();
    }

    @And("I set {string} in filters")
    public void iSetInFilters(String filter) {
        WebElement searchResults = getDriver().findElement(By.xpath("//div[@id='dyn_nav_col']"));
        new WebDriverWait(getDriver(), 5).until(ExpectedConditions.visibilityOf(searchResults));
        getDriver().findElement(By.xpath("//a[@class='sub-catagory']//label[text()='" + filter + "']")).click();
    }

    @Then("I verify that {string} results found")
    public void iVerifyThatResultsFound(String num) {
        String resultNum = getDriver().findElement(By.xpath("//span[@id='searchResultsHeading'][contains(text(),'"+num+"')]")).getText();
        assertThat(resultNum).contains(num);
    //    for (String handle : getDriver().getWindowHandles()) {
      //      getDriver().switchTo().window(handle);
        }
     //   WebElement searchResults = getDriver().findElement(By.xpath("//span[@id='searchResultsHeading']"));
     //   System.out.println(searchResults.getText());
      //  assertThat(searchResults.getText()).contains(num);
   // }

    @When("I select {string} in results")
    public void iSelectInResults(String resultOption) {
        getDriver().findElement(By.xpath("//span[contains(text(),'" + resultOption + "')]")).click();
    }

    @And("I click {string} button")
    public void iClickButton(String btnName) {
        getDriver().findElement(By.xpath("//a[text()='" + btnName + " ']")).click();
    }

    @Then("I validate that Sign In is required")
    public void iValidateThatSignInIsRequired() {
        // switch to new window
        for (String handle : getDriver().getWindowHandles()) {
            getDriver().switchTo().window(handle);
        }
        getDriver().findElement(By.xpath("//form[@id='loginForm']")).isDisplayed();
    }
}