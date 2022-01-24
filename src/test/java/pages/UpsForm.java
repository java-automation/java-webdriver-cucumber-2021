package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

import java.util.*;

import static support.TestContext.getData;
import static support.TestContext.getDriver;

public class UpsForm {

    //constructor
    public UpsForm() {
        PageFactory.initElements(getDriver(), this);
    }

    //fields
    @FindBy(xpath = "//a[contains(@class,'nav-link widget-link-ship')]")
    private WebElement createShipment;

    @FindBy(xpath = "//*[contains(@id,'origin-cac_country')]")
    private WebElement originCountry;

    @FindBy(xpath = "//*[contains(@id,'origin-cac_companyOrName')]")
    private WebElement originFullName;

    @FindBy(xpath = "//*[contains(@id,'origin_agentSummaryNameLine')]")
    private WebElement verifyOriginFullName;

    @FindBy(xpath = "//*[contains(@id,'origin-cac_singleLineAddress')]")
    private WebElement originAddress;

    @FindBy(xpath = "//*[contains(@id,'origin_agentSummaryAddressLine')]")
    private WebElement verifyOriginAddress;

    @FindBy(xpath = "//*[contains(@id,'origin-cac_email')]")
    private WebElement originEmail;

    @FindBy(xpath = "//*[contains(@id,'origin-cac_phone')]")
    private WebElement originPhone;

    @FindBy(xpath = "//*[contains(@id,'origin_agentSummaryContactLine')]")
    private WebElement verifyOriginEmailAndPhone;

    @FindBy(xpath = "//*[contains(@id,'nbsBackForwardNavigationContinueButton')]")
    private WebElement submit;

    //methods
    public void createShipment() {
        createShipment.click();
    }
    public void fillOrigin(String fullName, String address, String email, String phone) {

        //originCountry.click();
        originFullName.sendKeys(fullName);
        originAddress.sendKeys(address);
        originEmail.sendKeys(email);
        originPhone.sendKeys(phone);
    }
    public void submit() { submit.click(); }
}
