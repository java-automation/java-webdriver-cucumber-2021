package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class UpsShip extends UpsPage {

    public UpsShip() {
        setUrl("https://www.ups.com/ship?loc=en_US");
        setTitle("UPS Shipping");
    }

    @FindBy(css = "origin .ups-section")
    private WebElement originSection;

    @FindBy(id = "origin-cac_country")
    private WebElement originCountry;

    @FindBy(id = "origin-cac_companyOrName")
    private WebElement originName;

    @FindBy(id = "origin-cac_singleLineAddress")
    private List<WebElement> originAddress;

    @FindBy(id = "origin-cac_addressLine1")
    private List<WebElement> originAddress1;

    @FindBy(id = "origin-cac_postalCode")
    private WebElement originPostalCode;

    @FindBy(id = "origin-cac_city")
    private WebElement originCity;

    @FindBy(id = "origin-cac_email")
    private WebElement originEmail;

    @FindBy(id = "origin-cac_phone")
    private WebElement originPhone;

    @FindBy(css = ".dropdown-menu > .dropdown-item")
    private WebElement firstDropDownOptionOriginAddress;

    @FindBy(xpath = "//button[@id='origin-singleLineAddressEditButton']/preceding-sibling::p")
    private WebElement processedOriginAddress;

    @FindBy(id = "nbsBackForwardNavigationContinueButton")
    private WebElement continueButton;

    @FindBy(id = "origin_agentSummaryNameLine")
    private WebElement originSummaryName;

    @FindBy(id = "origin_agentSummaryAddressLine")
    private WebElement originSummaryAddress;

    @FindBy(id = "origin_agentSummaryCountryLine")
    private WebElement originSummaryCountry;

    @FindBy(id = "origin_agentSummaryContactLine")
    private WebElement originSummaryContact;

    public void selectOriginCountry(String countryName) {
        new Select(originCountry).selectByVisibleText(countryName);
    }

    public void fillOriginName(String name) {
        originName.sendKeys(name);
    }

    public void fillOriginAddress(String address) {
        sendKeysToCorrectOriginAddressField(originAddress1, originAddress, address);
        getWait().until(ExpectedConditions.visibilityOf(firstDropDownOptionOriginAddress)).click();
    }

    public void fillOriginAddress1(String address) {
        sendKeysToCorrectOriginAddressField(originAddress, originAddress1, address);
    }

    private void sendKeysToCorrectOriginAddressField(List<WebElement> toBeInvisible, List<WebElement> toBeVisible, String address) {
        getWait().until(driver -> toBeInvisible.stream().findFirst().isEmpty());
        toBeVisible.stream().findFirst().ifPresent(element -> element.sendKeys(address));
    }

    public String getProcessedOriginAddress() {
        return getWait().until(ExpectedConditions.visibilityOf(processedOriginAddress)).getText();
    }

    public void fillOriginPostalCode(String code) {
        originPostalCode.sendKeys(code);
    }

    public void fillOriginCity(String city) {
        originCity.sendKeys(city);
    }

    public void fillOriginEmail(String email) {
        originEmail.sendKeys(email);
    }

    public void fillOriginPhone(String phone) {
        originPhone.sendKeys(phone);
    }

    public void submitForm() {
        continueButton.click();
    }

    public String getOriginSummaryName() {
        return originSummaryName.getText();
    }

    public String getOriginSummaryAddress() {
        return originSummaryAddress.getText();
    }

    public String getOriginSummaryCountry() {
        return originSummaryCountry.getText();
    }

    public String getOriginSummaryContact() {
        return originSummaryContact.getText();
    }

    public void waitForPageLoad() {
        getWait().until(ExpectedConditions.visibilityOf(originSection));
    }
}
