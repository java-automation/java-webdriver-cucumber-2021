package definitions;

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
import pages.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import static support.TestContext.getData;
import static support.TestContext.getDriver;

public class UPSStepDefs extends Page {
    public static final By CONFIRM_BUTTON = By.xpath("//button[@id='preferences_prompt_submit'][contains(text(),'Confirm')]");
    public static final By CLOSE_BUTTON_WEBSITE_COOKIES = By.xpath("//div[@class='implicit_privacy_prompt implicit_consent']/button/span[@class='icon ups-icon-x']");
    public static final By DROP_DOWN_MENU_ADDRESS = By.xpath("//ngb-typeahead-window[@class='dropdown-menu show ng-star-inserted']/button");
    public static final By DROP_DOWN_MENU_ADDRESS_SUGGESTED_ADDRESSES = By.xpath("//ngb-typeahead-window[@class='dropdown-menu show ng-star-inserted']/button/ngb-highlight");
    private final WebDriverWait wait = new WebDriverWait(getDriver(), 10, 200);

    Map<String, String> shipFromData = getData("originHW", "ups");
    Map<String, String> shipToData = getData("destinationHW", "ups");
    Map<String, String> originData = getData("origin", "ups");
    Map<String, String> destinationData = getData("destination", "ups");
    Map<String, String> packageData = getData("package", "ups");

    UpsHome homePage = new UpsHome();
    UpsOrigin originPage = new UpsOrigin();
    UpsDestination destinationPage = new UpsDestination();
    UpsPackage packagePage = new UpsPackage();
    UpsPickupService pickupServicePage = new UpsPickupService();
    UpsOptions optionsPage = new UpsOptions();
    UpsControls controls = new UpsControls();
    UpsPayment payment = new UpsPayment();
    UpsReview review = new UpsReview();

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
        Thread.sleep(1000);
        new Actions(getDriver())
                .sendKeys(getDriver().findElement(By.xpath("//input[@id='origin-cac_singleLineAddress']")), Keys.ENTER)
                .perform();
        Thread.sleep(1000);
        if (isPresent(By.xpath("//input[@id='origin-cac_addressLine1']"))) {
            assertEquals(getDriver().findElement(By.xpath("//input[@id='origin-cac_addressLine1']"))
                            .getAttribute("value"),
                    shipFromData.get("street"));
        } else if (isPresent(By.xpath("//div[@class='ng-star-inserted']/p[@class='ng-star-inserted']"))) {
            String enteredAddress = getDriver().findElement(By.xpath("//div[@class='ng-star-inserted']/p[@class='ng-star-inserted']"))
                    .getText();
            System.out.println("Entered Address: " + enteredAddress);
            assertTrue(enteredAddress.contains(shipFromData.get("street")));
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
        assertTrue(shipTo.contains(shipFromData.get("zipcode")));
        assertTrue(shipTo.contains(shipFromData.get("state")));
        assertTrue(shipTo.contains(shipFromData.get("city")));
        assertTrue(shipTo.contains(shipFromData.get("phone")));
        assertTrue(shipTo.contains(shipFromData.get("email")));
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
        String currentUrl = getDriver().getCurrentUrl();
        System.out.println("currentUrl = " + currentUrl);
        if (currentUrl.contains("origin"))
            controls.submit();
        else if (currentUrl.contains("destination")) {
            controls.submit();
        } else if (currentUrl.contains("package")) {
            controls.submit();
        } else if (currentUrl.contains("pickup-service")) {
            clickWithJS(controls.continueButton);
            wait.until(ExpectedConditions.textToBePresentInElement(optionsPage.getSectionHeader(), "Almost done. Let's check a few more details."));
        } else if (currentUrl.contains("options")) {
            controls.submit();
        } else if (currentUrl.contains("payment")) {
            controls.review();
        } else throw new Error("Unknown page!");
    }


    @Then("I verify origin shipment fields submitted")
    public void iVerifyOriginShipmentFieldsSubmitted() {
        String actualSummary = destinationPage.getResultSummary();
        assertThat(actualSummary).contains(originData.get("name"));
        assertThat(actualSummary).contains(originData.get("address"));
        assertThat(actualSummary).contains(originData.get("email"));
        assertThat(actualSummary).contains(originData.get("phone"));
    }

    @When("I fill out destination shipment fields 1")
    public void iFillOutDestinationShipmentFields() throws InterruptedException {
        destinationPage.selectCountry(shipToData.get("country"));
        destinationPage.fillName(("%s %s %s").formatted(shipToData.get("firstName"), shipToData.get("middleName"), shipToData.get("lastName")));
        destinationPage.fillAddress(shipToData.get("address"));
        destinationPage.fillEmail(shipToData.get("email"));
        destinationPage.fillPhone(shipToData.get("phone"));
        Thread.sleep(500);
    }

    @And("I {string} residential address")
    public void iResidentialAddress(String button) {
        String shipToEnteredContainer = destinationPage.getShipToAddressContainer().getText();
        System.out.println("ShipTo entered address: \n" + shipToEnteredContainer);
        System.out.println("Address: " + shipToData.get("address"));
        System.out.println("Full Name: " + destinationPage.getFullShipToName());
        destinationPage.switchNoToYes();
        assertTrue(shipToEnteredContainer.contains(shipToData.get("street")));
        assertTrue(shipToEnteredContainer.contains(shipToData.get("state")));
        assertTrue(shipToEnteredContainer.contains(shipToData.get("zipcode")));
        assertTrue(shipToEnteredContainer.contains(shipToData.get("firstName")));
        assertTrue(shipToEnteredContainer.contains(shipToData.get("middleName")));
        assertTrue(shipToEnteredContainer.contains(shipToData.get("lastName")));
        destinationPage.continueModalWindow();
        wait.until(ExpectedConditions.presenceOfElementLocated(PACKAGE_SECTION_XPATH));
    }

    @And("I set packaging type and weight")
    public void iSetPackagingTypeAndWeight() {
        packagePage.selectType(packageData.get("type"));
        packagePage.fillWeight(packageData.get("weight"));
    }

    @Then("I verify total charges appear")
    public void iVerifyTotalChargesAppear() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(TOTAL_PRICE_BAR_HEADER));
        assertFalse(pickupServicePage.getTotalPrice().getText().isEmpty());
        assertTrue(Double.parseDouble(pickupServicePage.getTotalPrice().getText().replace("$", "")) > 0);
        System.out.println("Total price for the package: " + pickupServicePage.getTotalPrice().getText());
    }

    @And("I select cheapest delivery option")
    public void iSelectCheapestDeliveryOption() throws InterruptedException {
        pickupServicePage.getMinPrice().click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(controls.CHEAPEST_PRICE_SELECT));
        assertTrue(pickupServicePage.getCheapestPrice().get(0).isDisplayed());
        int i = 0;
        do {
            clickWithJS(pickupServicePage.getCalendarIcon());
            List<WebElement> dates = pickupServicePage.getAvailableDatePicker();
            wait.until(ExpectedConditions.visibilityOf(pickupServicePage.getDatePicker()));
            WebElement dateToClick = dates.get(i);
            clickWithJS(dateToClick);
            i++;
            Thread.sleep(2000);
            wait.until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(TOTAL_CHARGES_SPINNER)));
        } while (!pickupServicePage.doWeHaveSaturdayDelivery());

        new Actions(getDriver())
                .moveToElement(controls.continueButton)
                .perform();
    }

    @And("I set description and check Saturday Delivery type")
    public void iSetDescriptionAndCheckSaturdayDeliveryType() {
        optionsPage.fillDescriptions(packageData.get("descriptions"));
        int i = optionsPage.getCheckBoxSelected().size();
        if (isElementPresent(optionsPage.getSaturdayDelivery())) {
            clickWithJS(optionsPage.getSaturdayDelivery());
        }
        assertEquals(optionsPage.getCheckBoxSelected().size(), i + 1);
        //wait.until(ExpectedConditions.visibilityOf(optionsPage.getSaturdaySelected()));
    }

    @And("I check Deliver only to receiver's address")
    public void iCheckDeliverOnlyToReceiverSAddress() {

    }

    @And("I check {string}")
    public void iCheck(String text) {
        int i = optionsPage.getCheckBoxSelected().size();
        WebElement checkBox = optionsPage.getCheckBox(text);
        if (!checkBox.isSelected()) {
            clickWithJS(checkBox);
        }
        assertEquals(optionsPage.getCheckBoxSelected().size(), i + 1);
        // wait.until(ExpectedConditions.visibilityOf(optionsPage.getDirectDeliverySelected()));
    }

    @Then("I verify total charges changed")
    public void iVerifyTotalChargesChanged() {
        System.out.println("Total charger: " + getDriver().findElement(TOTAL_CHARGES_SPINNER).getText());
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(TOTAL_CHARGES_SPINNER)));
    }

    @And("I select Paypal payment type")
    public void iSelectPaypalPaymentType() {
        payment.selectPayPal();
    }

    @Then("I review all recorded details on the review page")
    public void iReviewAllRecordedDetailsOnTheReviewPage() {
        review.assertOrigin(originData.get("firstName"));
        review.assertOrigin(originData.get("lastName"));
        review.assertOrigin(originData.get("street"));
        review.assertOrigin(originData.get("city"));
        review.assertOrigin(originData.get("zipcode"));

        review.assertDestination(destinationData.get("firstName"));
        review.assertDestination(destinationData.get("middleName"));
        review.assertDestination(destinationData.get("lastName"));
        review.assertDestination(destinationData.get("street"));
        review.assertDestination(destinationData.get("city"));
        review.assertDestination(destinationData.get("zipcode"));

        review.assertResidential(packageData.get("residential"));
        review.assertPackageInformation(packageData.get("weight"));
        review.assertPackageInformation(packageData.get("type"));

        review.assertAdditionalOptions(packageData.get("description"));
        review.assertPayments(packageData.get("payment"));
    }

    @And("I cancel the shipment form")
    public void iCancelTheShipmentForm() {
        controls.cancel();
    }

    @Then("I verify shipment form is reset")
    public void iVerifyShipmentFormIsReset() {
        wait.until(ExpectedConditions.visibilityOf(originPage.getAddress()));
        System.out.println("Great Job!");
    }
}
