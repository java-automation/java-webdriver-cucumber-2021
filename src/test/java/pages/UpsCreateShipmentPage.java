package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static support.TestContext.getDriver;

public class UpsCreateShipmentPage extends Page {
    //constructor
    public UpsCreateShipmentPage() {
        url = "https://www.ups.com/ship/guided/origin?tx=24968987274335228&loc=en_US";
    }

    @FindBy(xpath = "//input[@name='cac_companyOrName']")
    private WebElement name;

    @FindBy(xpath = "//input[@name='cac_email']")
    private WebElement email;

    @FindBy(xpath = "//input[@name='cac_phone']")
    private WebElement phone;

    @FindBy(xpath = "//input[@name='cac_singleLineAddress']")
    private WebElement address;

    @FindBy(xpath = "//select[@name='cac_country']")
    private WebElement country;

    @FindBy(id = "nbsBackForwardNavigationContinueButton")
    private WebElement submitButton;

    @FindBy(id = "iw_placeholder1473252365894")
    private WebElement theWholeMenu;


    public void selectCountry(String countryName) {
        new Select(country).selectByVisibleText(countryName);
    }

    public void fillName(String value) {
        name.sendKeys(value);
    }

    public void fillEmail(String value) {
        email.sendKeys(value);
    }

    public void fillPhone(String value) {
        phone.sendKeys(value);
    }

    public void fillAddress(String value) throws InterruptedException {
        address.sendKeys(value);
        Thread.sleep(1000);
        address.sendKeys(Keys.ENTER);
    }

    public void submit() throws InterruptedException {
        Thread.sleep(1000);
        //submitButton.click();
        JavascriptExecutor executor = (JavascriptExecutor)getDriver();
        executor.executeScript("arguments[0].click();", submitButton);
    }

    public void waitTillOpen() {
        new WebDriverWait(getDriver(), 8).until(ExpectedConditions.visibilityOf(theWholeMenu));
    }

    public String nameFieldValue() {
        return name.getText();
    }

    public String addressFieldValue() {
        return address.getText();
    }

    public String emailFieldValue() {
        return email.getText();
    }

    public String phoneFieldValue() {
        return phone.getText();
    }







}
