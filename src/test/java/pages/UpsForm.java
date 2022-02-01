package pages;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

import java.util.*;

import static support.TestContext.getData;
import static support.TestContext.getDriver;

public class UpsForm {

    Actions actions = new Actions(getDriver());
    Map<String, String> user = getData("user");
    WebDriverWait wait = new WebDriverWait(getDriver(), 5);
    JavascriptExecutor executor = (JavascriptExecutor) getDriver();

    //constructor
    public UpsForm() {
        PageFactory.initElements(getDriver(), this);
    }

    //fields
    @FindBy(xpath = "//button[contains(@class,'close_btn_thick')]")
    private WebElement cookiesModal;

    @FindBy(xpath = "//a[contains(@class,'nav-link widget-link-ship')]")
    private WebElement createShipment;

    @FindBy(xpath = "//*[contains(@id,'origin-cac_country')]")
    private WebElement originCountry;

    @FindBy(xpath = "//*[contains(@id,'origin-cac_companyOrName')]")
    private WebElement originFullName;

    @FindBy(xpath = "//*[contains(@id,'origin_agentSummaryNameLine')]")
    private WebElement verifyOriginFullName;

    @FindBy(xpath = "//*[contains(@id,'destination-cac_companyOrName')]")
    private WebElement destinationFullName;

    @FindBy(xpath = "//*[contains(@id,'origin-cac_singleLineAddress')]")
    private WebElement originAddress;

    @FindBy(xpath = "//button[contains(@id,'ngb-typeahead-2-0')]")
    private WebElement selectOriginAddress;

    @FindBy(xpath = "//button[contains(@id,'ngb-typeahead-8-0')]")
    private WebElement selectDestinationAddress;

    @FindBy(xpath = "//*[contains(@id,'origin_agentSummaryAddressLine')]")
    private WebElement verifyOriginAddress;

    @FindBy(xpath = "//*[contains(@id,'destination-cac_singleLineAddress')]")
    private WebElement destinationAddress;

    @FindBy(xpath = "//*[contains(@id,'origin-cac_email')]")
    private WebElement originEmail;

    @FindBy(xpath = "//*[contains(@id,'origin-cac_phone')]")
    private WebElement originPhone;

    @FindBy(xpath = "//*[contains(@id,'origin_agentSummaryContactLine')]")
    private WebElement verifyOriginEmailAndPhone;

    @FindBy(xpath = "//*[contains(@class,'ups-form_ctaGroup')]")
    private WebElement ctaGroup;

    @FindBy(xpath = "//*[contains(@id,'nbsBackForwardNavigationContinueButton')]")
    private WebElement submit;

    @FindBy(xpath = "//*[contains(@id,'nbsBackForwardNavigationReviewPrimaryButton')]")
    private WebElement review;

    @FindBy(xpath = "//*[contains(@id,'nbsBackForwardNavigationBackButton')]")
    private WebElement back;

    @FindBy(xpath = "//*[contains(@id,'nbsBackForwardNavigationCancelShipmentButton')]")
    private WebElement cancelShipment;

    @FindBy(xpath = "//*[contains(@class,'ups-lever_switch_bg')]")
    private WebElement toggleSwitch;

    @FindBy(xpath = "//*[contains(@class,'ups-lever_switch_yes')]")
    private WebElement toggleSwitchYes;

    @FindBy(xpath = "//*[contains(@id,'nbsAddressClassificationContinue')]")
    private WebElement continueButton;

    @FindBy(xpath = "//option[text()='UPS Pak']")
    private WebElement packageType;

    @FindBy(xpath = "//input[contains(@id,'PackageWeight')]")
    private WebElement packageWeight;

    @FindBy(xpath = "//*[@id='nbsBalanceBarTotalCharges']")
    private WebElement totalCharges;

    @FindBy(xpath = "//*[@id='Cheapest']")
    private WebElement cheapestShippingOption;

    @FindBy(xpath = "//*[@id='nbsShipmentDescription']")
    private WebElement shippingDescription;

    @FindBy(xpath = "//*[contains(@class,'ups-lever_rlabel')]//strong[contains(text(),'Saturday Delivery')]")
    private WebElement saturdayDelivery;

    @FindBy(xpath = "//*[@for='nbsDirectDeliveryOnlyOptionBaseOptionSwitch']")
    private WebElement deliverOnlyToReceiverAddress;

    @FindBy(xpath = "//*[@id='other-ways-to-pay-tile']/..")
    private WebElement paymentPayPal;

    @FindBy(xpath = "//*[@for='payment-card-tile']")
    private WebElement paymentCreditCard;

    @FindBy(xpath = "//*[contains(@id,'origin_showSummaryAddress')]")
    private WebElement shipFromSection;

    @FindBy(xpath = "//*[contains(@id,'destination_showSummaryAddress')]")
    private WebElement shipToSection;

    @FindBy(xpath = "//*[@drawerid='packageDrawer']/li")
    private WebElement packageInfoSection;

    @FindBy(xpath = "//*[@id='additionalOptionsDrawer']/..")
    private WebElement additionalOptionsSection;

    //methods
    public void dismissCookiesModal() {
        cookiesModal.click();
    }
    public void createShipment() {
        createShipment.click();
    }
    public void fillOrigin(String fullName, String address, String email, String phone) throws InterruptedException {

        //originCountry.click();
        originFullName.sendKeys(fullName);
        Thread.sleep(2000);
        originAddress.sendKeys(address);
        Thread.sleep(2000);
        selectOriginAddress.click();
        Thread.sleep(3000);
        originEmail.sendKeys(email);
        Thread.sleep(2000);
        originPhone.sendKeys(phone);
        Thread.sleep(2000);
    }
    public void submit() {
        //actions.moveToElement(submit).perform();

        // Scrolling down the page till the element is found
        executor.executeScript("arguments[0].scrollIntoView();", cancelShipment);
        //executor.executeScript("window.scrollBy(0, " + offset + ");", submit);
        //System.out.println(ctaGroup.getText());
        if(ctaGroup.getText().contains("Continue")) {
            if(submit.isDisplayed()) {
                wait.until(ExpectedConditions.elementToBeClickable(submit));
                submit.click();
            } else if(continueButton.isDisplayed()) {
                wait.until(ExpectedConditions.elementToBeClickable(continueButton));
                continueButton.click();
            }
        } else {
            wait.until(ExpectedConditions.elementToBeClickable(review));
            review.click();
        }
        //submit.click();
       // System.out.println("And I submitted form by clicking continue button with xpath:" + submit);
    }

    public void verifyOrigin() {
        wait.until(ExpectedConditions.textToBe(By.xpath("//h2[contains(text(),'Where is your shipment going?')]"), "Where is your shipment going?"));
        Assert.assertEquals(user.get("fullName"), verifyOriginFullName.getText());
        Assert.assertEquals(user.get("address"), verifyOriginAddress.getText());
        Assert.assertEquals(user.get("email") + ", " + user.get("phone"), verifyOriginEmailAndPhone.getText());
    }

    public void fillDestinationFields(String fullName, String address) throws InterruptedException {
        destinationFullName.sendKeys(fullName);
        Thread.sleep(2000);
        destinationAddress.sendKeys(address);
        Thread.sleep(2000);
        selectDestinationAddress.click();
        Thread.sleep(2000);
    }

    public void confirmResidentialAddress() {
        toggleSwitch.click();
        wait.until(ExpectedConditions.textToBe(By.xpath("//*[contains(@class,'ups-lever_switch_yes')]"), "Yes"));
        continueButton.click();
    }

    public void setPackageType() {
        packageType.click();
    }

    public void setPackageWeight() {
        packageWeight.sendKeys("2");
    }

    public String getTotalCharges() {
        return totalCharges.getText();
    }

    public void checkTotal() {
        System.out.println(getTotalCharges());
        Assert.assertTrue(totalCharges.isDisplayed());
    }

    public void selectOption() {
        System.out.println(cheapestShippingOption.getText());
        cheapestShippingOption.click();
    }

    public void setShippingDescription() {
        shippingDescription.sendKeys("Study materials.");
    }

    public void checkSaturdayDelivery() {
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@class,'ups-lever_rlabel')]//strong[contains(text(),'Saturday Delivery')]")));
//        Dimension numOfElem = saturdayDelivery.getSize();
//        if(numOfElem > 0 && saturdayDelivery.isDisplayed()) {
//            saturdayDelivery.click();
//        }
    }

    public void checkDeliverOnlyToAddress() {
        deliverOnlyToReceiverAddress.click();
    }

    public void  selectPaymentMethod(String paymentMethod) throws InterruptedException {
        Thread.sleep(2000);
//        if(paymentMethod == "Credit Card") {
//           // executor.executeScript("arguments[0].scrollIntoView();", paymentCreditCard);
//            paymentCreditCard.click();
//        } else if(paymentMethod == "Paypal") {
            executor.executeScript("arguments[0].scrollIntoView();", paymentPayPal);
            Thread.sleep(3000);
            wait.until(ExpectedConditions.elementToBeClickable(paymentPayPal));
            paymentPayPal.click();
            Thread.sleep(2000);
//        }
    }

    public void cancelShipment() {
        cancelShipment.click();
    }

    public void reviewShipFromDetails() {
        executor.executeScript("arguments[0].scrollIntoView();", shipFromSection);
        System.out.println(shipFromSection.getText());
        Assert.assertTrue(shipFromSection.getText().contains(user.get("fullName")));
        Assert.assertTrue(shipFromSection.getText().contains(user.get("address")));
        Assert.assertTrue(shipFromSection.getText().contains(user.get("email")));
        Assert.assertTrue(shipFromSection.getText().contains(user.get("phone")));
    }

    public void reviewShipToDetails() {
        executor.executeScript("arguments[0].scrollIntoView();", shipToSection);
        Assert.assertTrue(shipToSection.getText().contains(user.get("sendToName")));
        Assert.assertTrue(shipToSection.getText().contains(user.get("sendToAddress")));
    }

    public void reviewPackageInformation() {
        executor.executeScript("arguments[0].scrollIntoView();", packageInfoSection);
        Assert.assertTrue(packageInfoSection.getText().contains(user.get("packageType")));
        Assert.assertTrue(packageInfoSection.getText().contains(user.get("packageWeight")));
    }

    public void reviewAdditionalOptions() {
        executor.executeScript("arguments[0].scrollIntoView();", additionalOptionsSection);
        Assert.assertTrue(additionalOptionsSection.getText().contains(user.get("DeliverOnlyToReceiverAddress")));
    }
}
