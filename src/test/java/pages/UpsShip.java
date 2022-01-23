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

    // origin
    
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

    @FindBy(xpath = "//button[@id='origin-singleLineAddressEditButton']/preceding-sibling::p")
    private WebElement processedOriginAddress;

    @FindBy(id = "origin_agentSummaryNameLine")
    private WebElement originSummaryName;

    @FindBy(id = "origin_agentSummaryAddressLine")
    private WebElement originSummaryAddress;

    @FindBy(id = "origin_agentSummaryCountryLine")
    private WebElement originSummaryCountry;

    @FindBy(id = "origin_agentSummaryContactLine")
    private WebElement originSummaryContact;
    
    // destination

    @FindBy(css = "destination .ups-section")
    private WebElement destinationSection;

    @FindBy(id = "destination-cac_country")
    private WebElement destinationCountry;

    @FindBy(id = "destination-cac_companyOrName")
    private WebElement destinationName;

    @FindBy(id = "destination-cac_singleLineAddress")
    private List<WebElement> destinationAddress;

    @FindBy(id = "destination-cac_addressLine1")
    private List<WebElement> destinationAddress1;

    @FindBy(id = "destination-cac_postalCode")
    private WebElement destinationPostalCode;

    @FindBy(id = "destination-cac_city")
    private WebElement destinationCity;

    @FindBy(id = "destination-cac_email")
    private WebElement destinationEmail;

    @FindBy(id = "destination-cac_phone")
    private WebElement destinationPhone;

    @FindBy(xpath = "//button[@id='destination-singleLineAddressEditButton']/preceding-sibling::p")
    private WebElement processedDestinationAddress;
    
    // common
    
    @FindBy(css = ".dropdown-menu > .dropdown-item")
    private WebElement firstDropDownAddress;
    
    @FindBy(id = "nbsBackForwardNavigationContinueButton")
    private WebElement continueButton;
    
    
    // origin

    public void waitForOriginFormToLoad() {
        getWait().until(ExpectedConditions.visibilityOf(originSection));
    }
    
    public void selectOriginCountry(String countryName) {
        new Select(originCountry).selectByVisibleText(countryName);
    }

    public void fillOriginName(String name) {
        originName.sendKeys(name);
    }

    public void fillOriginAddress(String address) {
        sendKeysToCorrectAddressField(originAddress1, originAddress, address);
        getWait().until(ExpectedConditions.visibilityOf(firstDropDownAddress)).click();
    }

    public void fillOriginAddress1(String address) {
        sendKeysToCorrectAddressField(originAddress, originAddress1, address);
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
    
    // destination

    public void selectDestinationCountry(String countryName) {
        new Select(destinationCountry).selectByVisibleText(countryName);
    }

    public void fillDestinationName(String name) {
        destinationName.sendKeys(name);
    }

    public void fillDestinationAddress(String address) {
        sendKeysToCorrectAddressField(destinationAddress1, destinationAddress, address);
        getWait().until(ExpectedConditions.visibilityOf(firstDropDownAddress)).click();
    }

    public void fillDestinationAddress1(String address) {
        sendKeysToCorrectAddressField(destinationAddress, destinationAddress1, address);
    }

    public String getProcessedDestinationAddress() {
        return getWait().until(ExpectedConditions.visibilityOf(processedDestinationAddress)).getText();
    }

    public void fillDestinationPostalCode(String code) {
        destinationPostalCode.sendKeys(code);
    }

    public void fillDestinationCity(String city) {
        destinationCity.sendKeys(city);
    }

    public void fillDestinationEmail(String email) {
        destinationEmail.sendKeys(email);
    }

    public void fillDestinationPhone(String phone) {
        destinationPhone.sendKeys(phone);
    }
    
    // common

    public void submitForm() {
        continueButton.click();
    }
    
    // utility

    private void sendKeysToCorrectAddressField(List<WebElement> toBeInvisible, List<WebElement> toBeVisible, String address) {
        getWait().until(driver -> toBeInvisible.stream().findFirst().isEmpty());
        toBeVisible.stream().findFirst().ifPresent(element -> element.sendKeys(address));
    }
}
