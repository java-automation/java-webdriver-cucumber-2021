package pages;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.*;
import org.openqa.selenium.support.*;

import java.util.*;

import static support.TestContext.getData;
import static support.TestContext.getDriver;

public class UpsForm {

    Actions actions = new Actions(getDriver());
    Map<String, String> user = getData("user");

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

    @FindBy(xpath = "//*[contains(@id,'nbsBackForwardNavigationContinueButton')]")
    private WebElement submit;

    @FindBy(xpath = "//*[contains(@id,'vm.residentialAddressControlId')]")
    private WebElement toggleYes;

    @FindBy(xpath = "//*[contains(@id,'nbsAddressClassificationContinue')]")
    private WebElement continueButton;


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
        Thread.sleep(2000);
        originEmail.sendKeys(email);
        Thread.sleep(2000);
        originPhone.sendKeys(phone);
        Thread.sleep(2000);
    }
    public void submit() {
        actions.moveToElement(submit).click().perform();
    }

    public void verifyOrigin() {
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
        toggleYes.click();
        continueButton.click();
    }
}
