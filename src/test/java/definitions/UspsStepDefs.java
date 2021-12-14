package definitions;

import io.cucumber.java.DataTableType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class UspsStepDefs {

    private MailingAddress testAddress = null;

    @DataTableType(replaceWithEmptyString = "[blank]")
    public MailingAddress convert(Map<String, String> entry) {
        return new MailingAddress(
                entry.get("street"),
                entry.get("city"),
                entry.get("state"),
                entry.get("zip")
        );
    }

    public void waitTillVisible(By locator) {
        new WebDriverWait(getDriver(), 10, 200)
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitForOverlayToHide() {
        List<WebElement> overlays = getDriver().findElements(By.xpath("//div[contains(@class,'white-spinner-wrapper')]"));
        if (overlays.size() != 0) {
            new WebDriverWait(getDriver(), 3).until(driver -> !overlays.get(0).isDisplayed());
        }
    }

    private void throughToolsMenuToZIPlookupChoicesPage() {
        WebElement quickToolsMenu = getDriver().findElement(By.xpath("//li[contains(@class,'qt-nav')]"));
        quickToolsMenu.click();
        By lookupZipMenuLocator = By.xpath("//li[contains(@class,'qt-nav')]//a[contains(@href,'zip-code-lookup')]");
        waitTillVisible(lookupZipMenuLocator);
        getDriver().findElement(lookupZipMenuLocator).click();
    }

    @When("I go to Lookup ZIP page by address")
    public void iGoToLookupZIPPageByAddress() {
        throughToolsMenuToZIPlookupChoicesPage();
        getDriver().findElement(By.xpath("//div[@id='zip-lookup-welcome']" +
                "//a[contains(@href,'byaddress')][contains(@class,'btn-primary')]")).click();
    }

    private void mouseOverToSendMenu() {
        WebElement sendMenu = getDriver().findElement(By.id("mail-ship-width"));
        new Actions(getDriver()).moveToElement(sendMenu).perform();
        new WebDriverWait(getDriver(),5).until(driver ->
             getDriver().findElement(By.xpath("//a[@id='navmailship']/following-sibling::div")).getSize().height > 0);
    }

    @When("I go to Lookup ZIP page by address via Send menu mouseover")
    public void iGoToLookupZIPPageByAddressDiffPath() {
        mouseOverToSendMenu();
        getDriver().findElement(By.xpath("//li[contains(@class,'tool-zip')]//a[contains(@href,'zip-code-lookup')]")).click();
        // alternative xpath with all predicates related to the same tag
        By byAddressButton = By.xpath("//a[contains(@href,'byaddress')]" +
                                                "[contains(@class,'btn-primary')][contains(@class,'zip-code-home')]");
        waitTillVisible(byAddressButton);
        getDriver().findElement(byAddressButton).click();
    }

    @When("I go to Lookup ZIP page by address on small screen")
    public void iGoToLookupZIPPageByAddressOnSmallScreen() {
        getDriver().findElement(By.xpath("//a[@data-gtm-label='zip-code-link']")).click();
        By byAddressButton = By.xpath("//div[@id='zip-lookup-welcome']" +
                                                   "//a[contains(@href,'byaddress')][contains(@class,'btn-primary')]");
        waitTillVisible(byAddressButton);
        getDriver().findElement(byAddressButton).click();
    }

    @When("I go to Lookup ZIP page by address on small screen via hamburger menu and Quick Tools")
    public void toZipByAddressOnSmallScreenViaHamMenuQuickTools() {
        getDriver().findElement(By.xpath("//a[contains(@class,'mobile-hamburger')]")).click();
        throughToolsMenuToZIPlookupChoicesPage();
        By byAddressButton = By.xpath("//div[@id='zip-lookup-welcome']//a[contains(@href,'byaddress')]");
        waitTillVisible(byAddressButton);
        getDriver().findElement(byAddressButton).click();
    }

    @When("I go to Lookup ZIP page by address on small screen via hamburger menu and Send")
    public void toZipByAddressOnSmallScreenViaHamMenuSend() {
        getDriver().findElement(By.xpath("//a[contains(@class,'mobile-hamburger')]")).click();
        getDriver().findElement(By.id("mail-ship-width")).click();
        By lookupZipMenuLocator = By.xpath("//li[contains(@class,'tool-zip')]//a[contains(@href,'zip-code-lookup')]");
        waitTillVisible(lookupZipMenuLocator);
        getDriver().findElement(lookupZipMenuLocator).click();
        getDriver().findElement(By.xpath("//div[@id='zip-lookup-welcome']//a[contains(@href,'byaddress')]")).click();
    }

    @And("I fill out random street, city, state")
    public void iFillOutStreetCityState(List<MailingAddress> locations) {
        int choice = (int) (Math.random() * locations.size());
        testAddress = locations.get(choice);
        iFillOutStreetCityState(testAddress.getStreet(), testAddress.getCity(), testAddress.getState());
    }

    @And("I fill out {string} street, {string} city, {string} state")
    public void iFillOutStreetCityState(String street, String city, String state) {
        getDriver().findElement(By.xpath("//input[@id='tAddress']")).sendKeys(street);
        getDriver().findElement(By.xpath("//input[@id='tCity']")).sendKeys(city);
        Select stateSelect = new Select(getDriver().findElement(By.xpath("//select[@id='tState']")));
        stateSelect.selectByValue(state);
        getDriver().findElement(By.xpath("//a[@id='zip-by-address']")).click();
        // behind the scenes: xhr request with response like:
        // {"resultStatus":"SUCCESS","addressList":[{"addressLine1":"4970 EL CAMINO REAL","city":"LOS ALTOS",
        // "state":"CA","zip5":"94022","zip4":"1460","carrierRoute":"C043","countyName":"SANTA CLARA",
        // "deliveryPoint":"99","checkDigit":"4","cmar":"N","elot":"0216","elotIndicator":"D","recordType":"H",
        // "dpvConfirmation":"D","defaultFlag":"Y"},{"addressLine1":"4970 EL CAMINO REAL","city":"LOS ALTOS",
        // "state":"CA","zip5":"94022","zip4":"1460","carrierRoute":"C043","countyName":"SANTA CLARA",
        // "deliveryPoint":"99","checkDigit":"4","cmar":"N"}, ... ]}
    }

    @Then("I validate {string} zip code exists in the result")
    public void iValidateZipCodeExistsInTheResult(String zipCode) {
        if (zipCode.equals("test") && testAddress != null) {
            zipCode = testAddress.getZip();
            System.out.println("Checking " + zipCode + " zip code");
        }
        waitTillVisible(By.xpath("//div[contains(@class,'result-address-wrapper')]"));
        List<WebElement> resultElements = getDriver()
                .findElements(By.xpath("//div[contains(@class,'zipcode-result-address')]"));
        resultElements.removeIf(el -> !el.isDisplayed());
        assertThat(resultElements.size()).isGreaterThan(0);
        for (WebElement elem : resultElements) {
            assertThat(elem.getText()).contains(zipCode);
        }
    }

    @When("I go to Calculate Price Page")
    public void iGoToCalculatePricePage() {
        mouseOverToSendMenu();
        getDriver().findElement(
                By.xpath("//a[@id='navmailship']//following-sibling::div//a[contains(@href,'postcalc')]")).click();
    }

    @And("I select {string} with {string} shape")
    public void iSelectWithShape(String country, String shape) {
        //waitTillVisible(By.id("CountryID"));
        Select countrySelect = new Select(getDriver().findElement(By.id("CountryID")));
        countrySelect.selectByVisibleText(country);
        getDriver().findElement(By.xpath(("//input[@value='" + shape + "']"))).click();
        // Request URL: https://postcalc.usps.com/Calculator/Postcard?country=10150&ccode=GB&omil=False&dmil=False
        //                                                            &mdt=12%2F10%2F2021&mdz=23%3A59&m=8
    }

    @And("I define {string} quantity")
    public void iDefineQuantity(String quantity) {
        getDriver().findElement(By.xpath("//input[@id='quantity-0']")).sendKeys(quantity);
    }

    @Then("I calculate the price and validate cost is {string}")
    public void iCalculateThePriceAndValidateCostIs(String total) {
        getDriver().findElement(By.xpath("//input[@value='Calculate']")).click();
        assertThat(getDriver().findElement(By.xpath("//div[@id='total']")).getText()).isEqualTo(total);
    }

    @When("I perform {string} search")
    public void iPerformSearch(String category) {
        WebElement searchIcon =
               getDriver().findElement(By.xpath("//ul[contains(@class,'nav-list')]/li[contains(@class,'nav-search')]"));
        new Actions(getDriver()).moveToElement(searchIcon).perform();
        By searchBarLoc = By.xpath("//li[contains(@class,'nav-search')]//input[@name='q']");
        waitTillVisible(searchBarLoc);
        getDriver().findElement(searchBarLoc).click();
        getDriver().findElement(searchBarLoc).sendKeys(category + Keys.RETURN);
        // searchIcon.findElement(By.xpath(".//input[contains(@class,'input--search')]")).click();
    }

    @And("I set {string} in filters")
    public void iSetInFilters(String filter) {
        waitTillVisible(By.xpath("//div[@id='dyn_nav_col']//p[@title='Send']/label"));
        waitForOverlayToHide();
        WebElement sendCheckboxLabel = getDriver().findElement(By.xpath("//div[@id='dyn_nav_col']//p[@title='Send']/label"));
        if (!sendCheckboxLabel.isSelected()) sendCheckboxLabel.click();
    }

    @Then("I verify that {string} results found")
    public void iVerifyThatResultsFound(String numOfResults) {
        Pattern p = Pattern.compile(".*\\((\\d+)\\)");
        Matcher m = p.matcher(getDriver().findElement(By.xpath("//div[@id='dyn_nav_col']//p[@title='Send']/label"))
                                                                                                          .getText());
        if (m.find()) {
            assertThat(m.group(1)).isEqualTo(numOfResults);
        }
        assertThat(getDriver().findElement(By.id("searchResultsHeading")).getText()).contains(numOfResults);
        new WebDriverWait(getDriver(), 10, 200).until(driver -> getDriver()
                           .findElements(By.xpath("//ul[@id='records']/li")).size() == Integer.parseInt(numOfResults));
    }

    @When("I select {string} in results")
    public void iSelectInResults(String selection) {
        waitForOverlayToHide();
        List<WebElement> list = getDriver().findElements(By.xpath("//ul[@id='records']/li"));
        for (WebElement el : list) {
            if (el.getText().contains(selection)) {
                el.findElement(By.xpath(".//a")).click();
                break;
            }
        }
    }

    @And("I click {string} button")
    public void iClickButton(String button) {
        By buttonLoc = By.xpath("//a[contains(@class,'button--primary')]");
        waitTillVisible(buttonLoc);
        getDriver().findElement(buttonLoc).click();
    }

    @Then("I validate that Sign In is required")
    public void iValidateThatSignInIsRequired() {
        for (String handle : getDriver().getWindowHandles()) {
            getDriver().switchTo().window(handle);
        }
        waitTillVisible(By.xpath("//input[@name='username']"));
        assertThat(getDriver().findElements(By.xpath("//input[@name='password']")).size()).isEqualTo(1);
        assertThat(getDriver().findElements(By.xpath("//button[@id='btn-submit']")).size()).isEqualTo(1);
    }
}

    class MailingAddress {

    private String street;
    private String city;
    private String state;
    private String zip;

    @Override
    public String toString() {
        return "MailAddress{" +
                "street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                '}';
    }

    MailingAddress(String street, String city, String state, String zip) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZip() { return zip; }

    public void setZip(String zip) { this.zip = zip; }
}