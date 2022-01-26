package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static support.TestContext.*;

public class UpsShip extends Page {

    private final LocalStorage localStorage;

    public UpsShip() {
        setUrl("https://www.ups.com/ship?loc=en_US");
        setTitle("UPS Shipping");
        localStorage = ((WebStorage) getDriver()).getLocalStorage();
    }

    public LocalStorage getLocalStorage() {
        return localStorage;
    }

    // origin

    @FindBy(css = "origin .ups-section")
    private WebElement originSection;

    @FindBy(id = "origin-cac_country")
    private WebElement originCountry;

    @FindBy(id = "origin-cac_companyOrName")
    private WebElement originCompanyOrName;

    @FindBy(id = "origin-cac_contactName")
    private WebElement originContactName;

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
    private WebElement destinationCompanyOrName;

    @FindBy(id = "destination-cac_contactName")
    private WebElement destinationContactName;

    @FindBy(id = "destination-cac_singleLineAddress")
    private List<WebElement> destinationAddress;

    @FindBy(id = "destination-cac_addressLine1")
    private List<WebElement> destinationAddress1;

    @FindBy(id = "destination-cac_postalCode")
    private WebElement destinationPostalCode;

    @FindBy(id = "destination-cac_city")
    private WebElement destinationCity;

    @FindBy(id = "destination-cac_phone")
    private WebElement destinationPhone;

    @FindBy(xpath = "//button[@id='destination-singleLineAddressEditButton']/preceding-sibling::p")
    private WebElement processedDestinationAddress;

    @FindBy(css = "input#destination-cac_classification+label")
    private WebElement destinationIsResidentialNonUS;

    // modal isResidential

    @FindBy(css = ".modal-dialog")
    private List<WebElement> modalWindow;

    @FindBy(css = ".ups-lever_switch_bg")
    private WebElement modalSwitch;

    @FindBy(css = ".ups-lever_switch_yes")
    private WebElement modalYes;

    @FindBy(id = "nbsAddressClassificationContinue")
    private WebElement modalContinueButton;

    // what

    @FindBy(id = "nbsPackagePackagingTypeDropdown0")
    private WebElement packageTypeSelect;

    @FindBy(id = "nbsPackagePackageWeightField0")
    private WebElement packageWeight;

    // how

    @FindBy(id = "nbsBalanceBarTotalCharges")
    private WebElement totalCharges;

    // common

    @FindBy(css = ".dropdown-menu > .dropdown-item")
    private WebElement firstDropDownAddress;

    @FindBy(id = "nbsBackForwardNavigationContinueButton")
    private WebElement continueButton;

    @FindBy(css = "img[src*='ajax-loader']")
    private List<WebElement> spinner;

    // origin

    public void waitForFirstLoad() {
        waitForSpinnerToBeAbsent();
        getWait().until(ExpectedConditions.visibilityOf(originSection));
    }

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

    // common

    public void submitForm() {
        waitForLocalStorageUpdate();
        continueButton.click();
    }

    public void confirmDestinationIsResidentialUS() {
        getWait().until(driver -> modalWindow.stream().findFirst().isPresent());
        if (!modalYes.isDisplayed()) {
            modalSwitch.click();
            getWait().until(ExpectedConditions.visibilityOf(modalYes));
        }
        modalContinueButton.click();
    }

    public void denyDestinationIsResidentialUS() {
        getWait().until(driver -> modalWindow.stream().findFirst().isPresent());
        if (modalYes.isDisplayed()) {
            modalSwitch.click();
            getWait().until(ExpectedConditions.invisibilityOf(modalYes));
        }
        modalContinueButton.click();
    }

    public void selectPackagingType(String type) {
        new Select(packageTypeSelect).selectByVisibleText(type);
        waitForLocalStorageUpdate();
        getWait().until(log -> getLogs(LogType.PERFORMANCE)
                .getAll()
                .stream()
                .filter(entry -> entry.getMessage().contains("https://www.ups.com/ship/api/LookupAndValidation/GetOptionsAvailability"))
                .filter(entry -> entry.getMessage().contains("application/json"))
                //.filter(entry -> entry.getMessage().contains("\"status\": 200"))
                .toList().size() > 0);
    }

    public void fillPackageWeight(int weight) {
        packageWeight.sendKeys(String.valueOf(weight));
        waitForLocalStorageUpdate();
        getWait().until(log -> getLogs(LogType.PERFORMANCE)
                .getAll()
                .stream()
                .filter(entry -> entry.getMessage().contains("https://www.ups.com/ship/api/RatingAndProcessing/RateShipmentForAllServices"))
                .filter(entry -> entry.getMessage().contains("application/json"))
                //.filter(entry -> entry.getMessage().contains("\"status\": 200"))
                .toList().size() > 0);
    }

    public boolean isTotalChargesVisible() {
        return totalCharges.isDisplayed();
    }

    // utility

    private void sendKeysToCorrectAddressField(List<WebElement> toBeInvisible, List<WebElement> toBeVisible, String address) {
        getWait().until(driver -> toBeInvisible.stream().findFirst().isEmpty());
        toBeVisible.stream().findFirst().ifPresent(element -> element.sendKeys(address));
    }

    private void waitForSpinnerToBeAbsent() {
        if (modalWindow.stream().findFirst().isEmpty())
            getWait().until(driver -> spinner.stream().findFirst().isEmpty());
    }

    private void waitForLocalStorageUpdate() {
        String localStorageValue = getLocalStorage().getItem("GULP_SC2");
        getWait().until(value -> !localStorageValue.equals(getLocalStorage().getItem("GULP_SC2")));
    }

//    public void printSelectOptionsWithResidentialStatus() throws InterruptedException {
//        Select select = new Select(destinationCountry);
//        List<WebElement> list = select.getOptions();
//        for (int j = 1; j < 266; j++) {
//            select.selectByIndex(j);
//            Thread.sleep(500);
//            System.out.println(list.get(j).getText());
//            System.out.println(destinationAddress1.stream().findFirst().isPresent());
//
//        }
//    }
}
