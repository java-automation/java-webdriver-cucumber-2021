package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static support.TestContext.getWait;

public class UpsOrigin extends UpsCreateShipment {

    public UpsOrigin() {
        setUrl("https://www.ups.com/ship/guided/origin");
        setTitle("UPS Shipping");
    }


    @FindBy(id = "origin-cac_country")
    private WebElement originCountry;

    @FindBy(id = "origin-cac_companyOrName")
    private WebElement originCompanyOrName;

    @FindBy(id = "origin-cac_singleLineAddress")
    private List<WebElement> originAddress;

    @FindBy(id = "origin-cac_addressLine1")
    private List<WebElement> originAddress1;

    @FindBy(css = ".dropdown-menu > .dropdown-item.active")
    private WebElement firstDropDownAddress;

    @FindBy(id = "origin-cac_postalCode")
    private WebElement originPostalCode;

    @FindBy(id = "origin-cac_city")
    private WebElement originCity;

    @FindBy(id = "origin-cac_email")
    private WebElement originEmail;

    @FindBy(id = "origin-cac_phone")
    private WebElement originPhone;

    @FindBy(xpath = "//button[@id='origin-singleLineAddressEditButton']/../p")
    private WebElement processedOriginAddress;


    public void selectOriginCountry(String countryName) {
        new Select(originCountry).selectByVisibleText(countryName);
    }

    public void fillOriginCompanyOrName(String name) {
        originCompanyOrName.sendKeys(name);
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

    public boolean isFirstLoad() {
        return (originCompanyOrName.getAttribute("value").isEmpty() &&
                originAddress.get(0).getAttribute("value").isEmpty() &&
                originEmail.getAttribute("value").isEmpty()) &&
                originPhone.getAttribute("value").isEmpty();
    }
}
