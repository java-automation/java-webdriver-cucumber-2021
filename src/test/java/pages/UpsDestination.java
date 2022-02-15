package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static support.TestContext.getWait;

public class UpsDestination extends UpsCreateShipment {

    public UpsDestination() {
        setUrl("https://www.ups.com/ship/guided/destination");
        setTitle("UPS Shipping");
    }


    // destination

    @FindBy(css = "destination .ups-section")
    private WebElement destinationSection;

    @FindBy(id = "destination-cac_country")
    private WebElement destinationCountry;

    @FindBy(id = "destination-cac_companyOrName")
    private WebElement destinationCompanyOrName;

    @FindBy(id = "destination-cac_contactName")
    private WebElement destinationContactName;

    @FindBy(id = "destination-cac_singleLineAddress")
    private List<WebElement> destinationAddress;

    @FindBy(id = "destination-cac_addressLine1")
    private List<WebElement> destinationAddress1;

    @FindBy(css = ".dropdown-menu > .dropdown-item.active")
    private WebElement firstDropDownAddress;

    @FindBy(id = "destination-cac_postalCode")
    private WebElement destinationPostalCode;

    @FindBy(id = "destination-cac_city")
    private WebElement destinationCity;

    @FindBy(id = "destination-cac_phone")
    private WebElement destinationPhone;

    @FindBy(xpath = "//button[@id='destination-singleLineAddressEditButton']/../p")
    private WebElement processedDestinationAddress;

    @FindBy(css = "input#destination-cac_classification+label")
    private WebElement destinationIsResidentialNonUS;

    // modal isResidential

    @FindBy(css = ".ups-lever_switch_bg")
    private WebElement modalSwitch;

    @FindBy(css = ".ups-lever_switch_yes")
    private WebElement modalYes;

    @FindBy(id = "nbsAddressClassificationContinue")
    private WebElement modalContinueButton;


    public void selectDestinationCountry(String countryName) {
        new Select(destinationCountry).selectByVisibleText(countryName);
    }

    public void fillDestinationCompanyOrName(String name) {
        destinationCompanyOrName.sendKeys(name);
    }

    public void fillDestinationContactName(String contact) {
        destinationContactName.sendKeys(contact);
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

    public void fillDestinationPhone(String phone) {
        destinationPhone.sendKeys(phone);
    }

    public void confirmDestinationIsResidentialNonUS() {
        if (!destinationIsResidentialNonUS.isSelected()) destinationIsResidentialNonUS.click();
    }

    public void denyDestinationIsResidentialNonUS() {
        if (destinationIsResidentialNonUS.isSelected()) destinationIsResidentialNonUS.click();
    }

    public void confirmDestinationIsResidentialUS() {
        waitForModalDialog();
        if (!modalYes.isDisplayed()) {
            modalSwitch.click();
            getWait().until(ExpectedConditions.visibilityOf(modalYes));
        }
        modalContinueButton.click();
    }

    public void denyDestinationIsResidentialUS() {
        waitForModalDialog();
        if (modalYes.isDisplayed()) {
            modalSwitch.click();
            getWait().until(ExpectedConditions.invisibilityOf(modalYes));
        }
        modalContinueButton.click();
    }
}
