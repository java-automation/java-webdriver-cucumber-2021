package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static support.TestContext.getDriver;

public class UpsShipmentPage extends Page {

    // constructor
    public UpsShipmentPage() {
        url = "https://www.ups.com/ship/guided/origin";
        title = "UPS Shipping";
    }

    @FindBy(xpath = "//button[@id='nbsBackForwardNavigationContinueButton']")
    public WebElement continueButton;

    @FindBy(xpath = "//select[@id='origin-cac_country']")
    private WebElement countryOrTerritory;

    @FindBy(xpath = "//input[@id='origin-cac_companyOrName']")
    private WebElement fullNameOrCompany;

    @FindBy(xpath = "//input[@id='origin-cac_singleLineAddress']")
    private WebElement address;

    @FindBy(xpath = "//input[@id='origin-cac_email']")
    private WebElement email;

    @FindBy(xpath = "//input[@id='origin-cac_phone']")
    private WebElement phone;

    @FindBy(xpath = "//input[@id='origin-cac_extension']")
    private WebElement phoneExtension;

    By popupAddress = By.xpath("//ngb-typeahead-window/button/ngb-highlight");
    By insertedAddress = By.xpath("//p[@class='ng-star-inserted']");


    @FindBy(xpath = "//div[@id='origin_agentSummaryNameLine']")
    private WebElement nameLineResult;

    @FindBy(xpath = "//div[@id='origin_agentSummaryAddressLine']")
    private WebElement addressLineResult;

    @FindBy(xpath = "//div[@id='origin_agentSummaryCountryLine']")
    private WebElement countryLineResult;

    @FindBy(xpath = "//div[@id='origin_agentSummaryContactLine']")
    private WebElement contactLineResult;


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

    public void setFullNameOrCompany(String sValue) {
        fullNameOrCompany.sendKeys(sValue);
    }

    public void setAddress(String sValue) {
        address.sendKeys(sValue);
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.elementToBeClickable(popupAddress));
        new Actions(getDriver()).click(getDriver().findElement(popupAddress)).perform();
        new WebDriverWait(getDriver(), 5).until(ExpectedConditions.visibilityOfElementLocated(insertedAddress));
    }

    public void setEmail(String sValue) {
        email.sendKeys(sValue);
    }

    public WebElement getPhone() {
        return phone;
    }

    public WebElement getPhoneExtension() {
        return phoneExtension;
    }

    public void setPhone(String sValue) {
        phone.sendKeys(sValue);
    }

    public String getNameLineResultText() {
        return nameLineResult.getText();
    }

    public String getAddressLineResult() {
        return addressLineResult.getText();
    }

    public String getCountryLineResult() {
        return countryLineResult.getText();
    }

    public String getContactLineResult() {
        return contactLineResult.getText();
    }
}
