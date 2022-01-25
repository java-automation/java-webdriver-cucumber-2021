package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import static support.TestContext.getDriver;

public class UpsShipmentForm extends UpsBasePage {

    // fields
    @FindBy(xpath = "//select[@name='cac_country']")
    private WebElement country;

    @FindBy(xpath = "//input[@name='cac_companyOrName']")
    private WebElement companyOrName;

    @FindBy(xpath = "//input[@name='cac_contactName']")
    private WebElement contactName;

    @FindBy(xpath = "//input[@name='cac_singleLineAddress']")
    private WebElement singleLineAddress;

    @FindBy(xpath = "//input[@name='cac_singleLineAddress']/following-sibling::ngb-typeahead-window")
    private WebElement addressPredictionsList;

    @FindBy(xpath = "//input[@name='cac_singleLineAddress']/following-sibling::ngb-typeahead-window//button")
    private WebElement addressPredictionsListItem;

    @FindBy(xpath = "//button[contains(@id,'singleLineAddressEditButton')]/preceding-sibling::p")
    private WebElement singleLineAddressProcessed;

    @FindBy(xpath = "//button[contains(@id,'singleLineAddressEditButton')]")
    private WebElement addressEditButton;

    @FindBy(xpath = "//input[@name='cac_addressLine1']")
    private WebElement addressLine1;

    @FindBy(xpath = "//input[@name='cac_addressLine2']")
    private WebElement addressLine2;

    @FindBy(xpath = "//input[@name='cac_addressLine3']")
    private WebElement addressLine3;

    @FindBy(xpath = "//input[@name='cac_postalCode']")
    private WebElement zipCode;

    @FindBy(xpath = "//input[@name='cac_city']")
    private WebElement city;

    @FindBy(name="cac_state")
    private WebElement state;

    @FindBy(xpath = "//input[@name='cac_email']")
    private WebElement email;

    @FindBy(xpath = "//input[@name='cac_phone']")
    private WebElement phone;

    @FindBy(xpath = "//input[@name='cac_extension']")
    private WebElement extension;

    // methods
    public void fillOutForm(String country, String name, String address1, String city, String state,
                              String zipCode, String email, String phone, String type) {
        new Select(this.country).selectByVisibleText(country);
        companyOrName.sendKeys(name);
        this.email.sendKeys(email);
        this.phone.sendKeys(phone);
        if (type.equals("residential") || address1.length()+city.length()+state.length()+zipCode.length()+2 <= 35) {
            singleLineAddress.sendKeys(String.join(",", address1, city, state) + " " + zipCode);
            wait.until(driver -> addressPredictionsListItem.isDisplayed());
            new Actions(getDriver()).sendKeys(Keys.RETURN).perform();
            wait.until(driver -> singleLineAddressProcessed.isDisplayed());
        } else {
            addressEditButton.click();
            addressLine1.sendKeys(address1);
            this.zipCode.sendKeys(zipCode);
            this.city.sendKeys(city);
            new Select(this.state).selectByValue(state);
            wait.until(driver -> this.city.getAttribute("value").equals(city.toUpperCase()));
        }
    }

    public boolean isSwitchedTo() {
        return country.isDisplayed();
    }
}
