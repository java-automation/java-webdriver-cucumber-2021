package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Locale;

import static support.TestContext.getDriver;

public class UpsShipmentPage extends Page {

    // constructor
    public UpsShipmentPage() {
        url = "https://www.ups.com/ship/guided/origin";
        title = "UPS Shipping";
    }

    @FindBy(xpath = "//h2[contains(@class,'ups-section_heading') and normalize-space()='Hello. Where are you shipping from?']")
    public WebElement header;

    @FindBy(xpath = "//button[@id='nbsBackForwardNavigationContinueButton']")
    public WebElement continueButton;

    @FindBy(xpath = "//button[@id='nbsBackForwardNavigationReviewPrimaryButton']")
    public WebElement reviewButton;

    @FindBy(xpath = "//button[@id='nbsBackForwardNavigationCancelShipmentButton']")
    public WebElement cancelButton;

    @FindBy(xpath = "//button[@id='nbsCancelShipmentWarningYes']")
    public WebElement yesForCancel;

    @FindBy(xpath = "//select[@id='origin-cac_country']")
    private WebElement countryOrTerritory;

    @FindBy(xpath = "//select[@id='destination-cac_country']")
    private WebElement countryOrTerritoryDestination;

    @FindBy(xpath = "//input[@id='origin-cac_companyOrName']")
    private WebElement fullNameOrCompany;

    @FindBy(xpath = "//input[@id='destination-cac_companyOrName']")
    private WebElement fullNameOrCompanyDestination;

    @FindBy(xpath = "//input[@id='origin-cac_singleLineAddress']")
    private WebElement address;

    @FindBy(xpath = "//input[@id='destination-cac_singleLineAddress']")
    private WebElement addressDestination;

    @FindBy(xpath = "//input[@id='origin-cac_email']")
    private WebElement email;

    @FindBy(xpath = "//input[@id='destination-cac_email']")
    private WebElement emailDestination;

    @FindBy(xpath = "//input[@id='origin-cac_phone']")
    private WebElement phone;
    @FindBy(xpath = "//input[@id='destination-cac_phone']")
    private WebElement phoneDestination;

    @FindBy(xpath = "//input[@id='origin-cac_extension']")
    private WebElement phoneExtension;
    @FindBy(xpath = "//input[@id='destination-cac_extension']")
    private WebElement phoneExtensionDestination;

    By popupAddress = By.xpath("(//ngb-typeahead-window/button/ngb-highlight)[1]");
    By insertedAddress = By.xpath("//p[@class='ng-star-inserted' and not(normalize-space()='UPS may use the email address and/or mobile number provided to update your receiver about the status of their package.')]");
    By sliderResidential = By.xpath("//span[@class='ups-lever_switch_yes']");


    @FindBy(xpath = "//div[@id='origin_agentSummaryNameLine']")
    private WebElement nameLineResult;
    @FindBy(xpath = "//div[@id='destination_agentSummaryNameLine']")
    private WebElement destinationNameLineResult;

    @FindBy(xpath = "//div[@id='origin_agentSummaryAddressLine']")
    private WebElement addressLineResult;
    @FindBy(xpath = "//div[@id='destination_agentSummaryAddressLine']")
    private WebElement destinationAddressLineResult;

    @FindBy(xpath = "//div[@id='origin_agentSummaryCountryLine']")
    private WebElement countryLineResult;
    @FindBy(xpath = "//div[@id='destination_agentSummaryCountryLine']")
    private WebElement destinationCountryLineResult;

    @FindBy(xpath = "//div[@id='origin_agentSummaryContactLine']")
    private WebElement contactLineResult;
    @FindBy(xpath = "//div[@id='destination_agentSummaryContactLine']")
    private WebElement destinationContactLineResult;


    @FindBy(xpath = "//span[@class='ups-lever_switch']")
    private WebElement residentialSlider;
    @FindBy(xpath = "//button[@id='nbsAddressClassificationContinue']")
    private WebElement confirmResidentialButtonContinue;


    //methods
    public void waitContinueButtonAvailable(int iSeconds) {
        WebDriverWait wait = new WebDriverWait(getDriver(),iSeconds);
        wait.until(ExpectedConditions.elementToBeClickable(continueButton));
    }

    public void waitForm(int iSeconds) {
        WebDriverWait wait = new WebDriverWait(getDriver(), iSeconds);
//        wait.until(ExpectedConditions)
    }

    public void setCountryOrTerritoryByText(String sValue) {
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='origin-cac_country']")));
        countryOrTerritory.click();
        By country = By.xpath("//select[@id='origin-cac_country']/option[normalize-space()='" + sValue + "']");
        getDriver().findElement(country).click();
    }

    public void setCountryOrTerritoryDestinationByText(String sValue) {
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='destination-cac_country']")));
        countryOrTerritoryDestination.click();
        By country = By.xpath("//select[@id='destination-cac_country']/option[normalize-space()='" + sValue + "']");
        getDriver().findElement(country).click();
    }

    public void setFullNameOrCompany(String sValue) {
        fullNameOrCompany.sendKeys(sValue);
    }

    public void setFullNameOrCompanyDestination(String sValue) {
        fullNameOrCompanyDestination.sendKeys(sValue);
    }

    public void setAddress(String sValue) {
        address.sendKeys(sValue);
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.elementToBeClickable(popupAddress));
        new Actions(getDriver()).click(getDriver().findElement(popupAddress)).perform();
        new WebDriverWait(getDriver(), 5).until(ExpectedConditions.visibilityOfElementLocated(insertedAddress));
    }

    public void setAddressDestination(String sValue) {
        addressDestination.sendKeys(sValue);
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.elementToBeClickable(popupAddress));
        new Actions(getDriver()).click(getDriver().findElement(popupAddress)).perform();
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.visibilityOfElementLocated(insertedAddress));
    }

    public void setEmail(String sValue) {
        email.sendKeys(sValue);
    }

    public void setEmailDestination(String sValue) {
        emailDestination.sendKeys(sValue);
    }

    public WebElement getPhone() {
        return phone;
    }

    public WebElement getPhoneDestination() {
        return phoneDestination;
    }

    public WebElement getPhoneExtension() {
        return phoneExtension;
    }

    public WebElement getPhoneExtensionDestination() {
        return phoneExtensionDestination;
    }

    public void setPhone(String sValue) {
        phone.sendKeys(sValue);
    }

    public void setPhoneDestination(String sValue) {
        phoneDestination.sendKeys(sValue);
    }

    public String getNameLineResultText() {
        return nameLineResult.getText();
    }
    public String getDestinationNameLineResultText() {
        return destinationNameLineResult.getText();
    }

    public String getAddressLineResult() {
        return addressLineResult.getText();
    }
    public String getDestinationAddressLineResult() {
        return destinationAddressLineResult.getText();
    }

    public String getCountryLineResult() {
        return countryLineResult.getText();
    }
    public String getDestinationCountryLineResult() {
        return destinationCountryLineResult.getText();
    }

    public String getContactLineResult() {
        return contactLineResult.getText();
    }
    public String getDestinationContactLineResult() {
        return destinationContactLineResult.getText();
    }

    public void setResidentialSliderTo(String sSliderValue) {
        if ((sSliderValue.toLowerCase() == "yes") || (sSliderValue.toLowerCase() == "no")) {
            By sliderResidential = By.xpath("//span[@class='ups-lever_switch_']" + sSliderValue.toLowerCase());
        } else {
            throw new Error("Wrong slider value");
        }
        if (!getDriver().findElement(sliderResidential).isDisplayed()) {
            residentialSlider.click();
        }
        confirmResidentialButtonContinue.click();
    }
}
