package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static support.TestContext.getDriver;


public class UspsStepDefs {
    @When("I go to lookup ZIP page by address")
    public void iGoToLookupZIPPageByAddress() {
        getDriver().findElement(By.xpath("//a[normalize-space()='Quick Tools']")).click();
        getDriver().findElement(By.xpath("//img[@alt='Zip Code™ Lookup Icon']")).click();
        getDriver().findElement(By.xpath("//a[contains(text(),'Find by Address')]")).click();

    }

    @And("I fill out {string} street, {string} city, {string} state")
    public void iFillOutStreetCityState(String street, String city, String state) {

        getDriver().findElement(By.xpath("//input[@id='tAddress']")).sendKeys(street);
        getDriver().findElement(By.xpath("//input[@id='tCity']")).sendKeys(city);
        getDriver().findElement(By.xpath("//select[@id='tState']")).click();
        getDriver().findElement(By.xpath("//select[@id='tState']//option[@value='" + state + "']")).click();
        getDriver().findElement(By.xpath("//input[@id='tZip-byaddress']")).sendKeys("94022");
        getDriver().findElement(By.xpath("//a[@id='zip-by-address']")).click();

    }

    @Then("I validate {string} zip code exists in the result")
    public void iValidateZipCodeExistsInTheResult(String zip) throws InterruptedException {
        WebElement resultContainer =  getDriver().findElement(By.xpath("//div[@id='zipByAddressDiv']"));

        WebDriverWait wait = new WebDriverWait(getDriver(), 5);
//        wait.until(ExpectedConditions.textToBePresentInElement(resultContainer, zip));
        wait.until(ExpectedConditions.visibilityOf(resultContainer));

        Thread.sleep(1000);
        String resultString = resultContainer.getText();
        System.out.println(resultString);

        Assertions.assertThat(resultString).contains(zip);

    }

    @When("I go to Calculate Price Page")
    public void iGoToCalculatePricePage() {
        WebElement sendMenu = getDriver().findElement(By.xpath("//a[@id='mail-ship-width']"));
        Actions actions = new Actions(getDriver());
        actions.moveToElement(sendMenu).perform();
//        new Actions(getDriver()).moveToElement(sendMenu).perform(); //This line is a recipe for mouse over action. Belov 2 lines can be replaced with this one line.
        getDriver().findElement(By.xpath("//li[@class='tool-calc']/a[contains(@href, 'postcalc')][contains(text(), 'Calculate a Price')]")).click();
    }

    @And("I select {string} with {string} shape")
    public void iSelectWithShape(String arg0, String arg1) throws InterruptedException {

        WebElement selectElement = getDriver().findElement(By.xpath("//select[@id='CountryID']"));
        Select select = new Select(selectElement); //select recipe
//        new Select(selectElement).selectByValue(country);
        select.selectByVisibleText("Canada");
        Thread.sleep(5000);
        getDriver().findElement(By.xpath("//input[@id='ItemValue']")).sendKeys("Postcard");
        getDriver().findElement(By.xpath("//input[@value='Postcard']")).click();
    }

    @And("I define {string} quantity")
    public void iDefineQuantity(String arg0) {
        getDriver().findElement(By.xpath("//input[@id='quantity-0']")).sendKeys("2");
        getDriver().findElement(By.xpath("//input[@value='Calculate']")).click();
    }

    @Then("I calculate the price and validate cost is {string}")
    public void iCalculateThePriceAndValidateCostIs(String arg0) {
        WebElement total = getDriver().findElement(By.xpath("//div[@id='total']"));
        String price = total.getText();
        System.out.println(price);
    }

    @When("I perform {string} search")
    public void iPerformSearch(String arg0) throws InterruptedException {
        WebElement searchIcon = getDriver().findElement(By.xpath("//li[@class='nav-search menuheader']"));
        Actions actions = new Actions(getDriver());
        actions.moveToElement(searchIcon).perform();
        getDriver().findElement(By.xpath("//input[@id='global-header--search-track-search']"))
                .sendKeys("Free Boxes" + Keys.ENTER);
        Thread.sleep(5000);
    }

    @And("I set {string} in filters")
    public void iSetInFilters(String arg0) {
        getDriver().findElement(By.xpath("//p[@title='Send']")).click();
    }

    @Then("I verify that {string} results found")
    public void iVerifyThatResultsFound(String arg0) throws InterruptedException {
        WebElement resultContainer = getDriver().findElement(By.xpath("//div[@id='main_res']"));
        String results = resultContainer.getText();
        System.out.println(results);
        Thread.sleep(5000);

    }

    @When("I select {string} in results")
    public void iSelectInResults(String arg0) {
        getDriver().findElement(By.xpath("//span[@id='title_22']")).click();
    }

    @And("I click {string} button")
    public void iClickButton(String arg0) {
        getDriver().findElement(By.xpath("//a[contains(@href, 'kig')]")).click();
    }

    @Then("I validate that Sign In is required")
    public void iValidateThatSignInIsRequired() {
        // switch to new window
        for (String handle : getDriver().getWindowHandles()) {
            getDriver().switchTo().window(handle);
        }
        String result = getDriver().findElement(By.xpath("//h1[@id='sign-in-to-your-account-header']")).getText();
        Assertions.assertThat(result.equals("Sign In To Your Account"));
    }
}
