package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.UpsDestination;
import pages.UpsHome;
import pages.UpsOrigin;

import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static support.TestContext.getData;
import static support.TestContext.getDriver;

public class UPSStepDefs extends HelperStepDefs {
    public static final By CONFIRM_BUTTON = By.xpath("//button[@id='preferences_prompt_submit'][contains(text(),'Confirm')]");
    public static final By CLOSE_BUTTON_WEBSITE_COOKIES = By.xpath("//div[@class='implicit_privacy_prompt implicit_consent']/button/span[@class='icon ups-icon-x']");
    public static final By DROP_DOWN_MENU_ADDRESS = By.xpath("//ngb-typeahead-window[@class='dropdown-menu show ng-star-inserted']/button");
    public static final By DROP_DOWN_MENU_ADDRESS_SUGGESTED_ADDRESSES = By.xpath("//ngb-typeahead-window[@class='dropdown-menu show ng-star-inserted']/button/ngb-highlight");
    private final WebDriverWait wait = new WebDriverWait(getDriver(), 10, 200);

    Map<String, String> shipFromData = getData("originHW", "ups");
    Map<String, String> shipToData = getData("destinationHW", "ups");
    Map<String, String> originData = getData("origin", "ups");
    Map<String, String> destinationData = getData("destination", "ups");
    UpsHome homePage = new UpsHome();
    UpsOrigin originPage = new UpsOrigin();
    UpsDestination destinationPage = new UpsDestination();

    @And("I go to {string} 1")
    public void iGoToCreateAShipment(String textLink) {
        if (getDriver().findElement(By.xpath("//span[@class='icon ups-icon-hamburger']")).isDisplayed()) {
            getDriver().findElement(By.xpath("//span[@class='icon ups-icon-hamburger']")).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'hamburger-menu show')]")));
            getDriver().findElements(By.xpath("//div[contains(@class,'hamburger-menu show')]//li[@class='nav-item']/a"))
                    .stream().filter(el -> el.getText().equals("Shipping"))
                    .collect(Collectors.toList())
                    .get(0).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'hamburger-menu')]//div[@class='sub-menu collapse show']")));
            getDriver().findElements(By.xpath("//div[contains(@class,'hamburger-menu')]//div[@class='sub-menu collapse show']//a"))
                    .stream().filter(el -> el.getText().equals(textLink))
                    .collect(Collectors.toList())
                    .get(0).click();

        } else {
            getDriver().findElement(By.xpath("//div[@id='ups-navigation-container'][1]//a[@id='mainNavDropdown1']")).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='mainNavMenu1']//a")));
            new Actions(getDriver())
                    .moveToElement(
                            getDriver().findElements(By.xpath("//div[@id='mainNavMenu1']//a"))
                                    .stream().filter(el -> el.getText().equals(textLink))
                                    .collect(Collectors.toList())
                                    .get(0))
                    .click()
                    .perform();
        }
        wait.until(ExpectedConditions.textToBePresentInElement(getDriver().findElement(By.xpath("//h1/span")), textLink));
    }

    @When("I fill out origin shipment fields 1")
    public void iFillOutOriginShipmentFields1() throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@id='origin-cac_country']")));
        if (isVisible(CLOSE_BUTTON_WEBSITE_COOKIES)) {
            getDriver().findElement(CLOSE_BUTTON_WEBSITE_COOKIES).click();
        }
        new Select(getDriver().findElement(By.xpath("//select[@id='origin-cac_country']")))
                .selectByVisibleText(shipFromData.get("country"));
        getDriver().findElement(By.xpath("//input[@id='origin-cac_companyOrName']"))
                .sendKeys(("%s %s").formatted(shipFromData.get("firstName"), shipFromData.get("lastName")));
        new Actions(getDriver())
                .sendKeys(getDriver().findElement(By.xpath("//input[@id='origin-cac_singleLineAddress']")),
                        shipFromData.get("street"))
                .perform();
        Thread.sleep(3000);
        new Actions(getDriver())
                .sendKeys(getDriver().findElement(By.xpath("//input[@id='origin-cac_singleLineAddress']")), Keys.ENTER)
                .perform();
        Thread.sleep(3000);
        if (isPresent(By.xpath("//input[@id='origin-cac_addressLine1']"))) {
            assertEquals(getDriver().findElement(By.xpath("//input[@id='origin-cac_addressLine1']"))
                            .getAttribute("value"),
                    shipFromData.get("street"));
        } else if (isPresent(By.xpath("//div[@class='ng-star-inserted']/p[@class='ng-star-inserted']"))) {
            String enteredAddress = getDriver().findElement(By.xpath("//div[@class='ng-star-inserted']/p[@class='ng-star-inserted']"))
                    .getText();
            System.out.println("Entered Address: " + enteredAddress);
            Assert.assertTrue(enteredAddress.contains(shipFromData.get("street")));
        } else {
            assertEquals(
                    getDriver().findElement(By.xpath("//input[@id='origin-cac_singleLineAddress']"))
                            .getAttribute("value"),
                    shipFromData.get("street"));
        }
        if (isPresent(By.xpath("//input[@id='origin-cac_postalCode']"))) {
            getDriver().findElement(By.xpath("//input[@id='origin-cac_postalCode']"))
                    .sendKeys(shipFromData.get("zipcode"));
            getDriver().findElement(By.xpath("//input[@id='origin-cac_city']"))
                    .sendKeys(shipFromData.get("city"));
            new Select(getDriver().findElement(By.xpath("//select[@id='origin-cac_state']")))
                    .selectByVisibleText(shipFromData.get("state"));
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='origin-cac_phone']")))
                .click();
        WebElement phone = getDriver().findElement(By.xpath("//input[@id='origin-cac_phone']"));
        phone.sendKeys(shipFromData.get("phone"));
        new Actions(getDriver())
                .click(phone)
                .sendKeys(phone, Keys.ENTER)
                .perform();
        WebElement email = getDriver().findElement(By.xpath("//input[@id='origin-cac_email']"));
        email.sendKeys(shipFromData.get("email"));
        new Actions(getDriver())
                .click(email)
                .sendKeys(email, Keys.ENTER)
                .perform();
        System.out.println("phone entered: " + phone.getAttribute("value"));
        System.out.println("email entered: " + email.getAttribute("value"));
    }

    @And("I submit the shipment form 1")
    public void iSubmitTheShipmentForm1() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@id='nbsBackForwardNavigationContinueButton']"))).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='ups-section']")));
    }

    @Then("I verify origin shipment fields submitted 1")
    public void iVerifyOriginShipmentFieldsSubmitted1() {
        String shipTo = getDriver().findElement(By.xpath("//div[@class='ups-section']")).getText();
        System.out.println("Ship to: " + shipTo);
        assertTrue(shipTo.contains(shipFromData.get("street")));
    }

    //from Day16_class_work

    @And("I go to Create a Shipment")
    public void iGoToCreateAShipment() {
        homePage.closeBanner();
        homePage.openShipment();
    }

    @When("I fill out origin shipment fields")
    public void iFillOutOriginShipmentFields() throws InterruptedException {
        originPage.selectCountry(originData.get("country"));
        originPage.fillName(originData.get("name"));
        originPage.fillAddress(originData.get("address"));
        originPage.fillEmail(originData.get("email"));
        originPage.fillPhone(originData.get("phone"));
        Thread.sleep(500); // to be removed after bugfix #
    }

    @And("I submit the shipment form")
    public void iSubmitTheShipmentForm() {
        originPage.submit();
    }

    @Then("I verify origin shipment fields submitted")
    public void iVerifyOriginShipmentFieldsSubmitted() {
        String actualSummary = destinationPage.getResultSummary();
        assertThat(actualSummary).contains(originData.get("name"));
        assertThat(actualSummary).contains(originData.get("address"));
        assertThat(actualSummary).contains(originData.get("email"));
        assertThat(actualSummary).contains(originData.get("phone"));
    }
}
