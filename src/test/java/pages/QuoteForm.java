package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Map;

import static support.TestContext.getDriver;

public class QuoteForm extends Page {

    public QuoteForm() {
        url  = "https://skryabin.com/market/quote.html";
        title = "Get a Quote";
    }

    @FindBy(xpath = "//input[@name='username']")
    private WebElement username;

    @FindBy(xpath = "//input[@name='email']")
    private WebElement email;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement password;

    @FindBy(xpath = "//input[@name='confirmPassword']")
    private WebElement confirmPassword;

    @FindBy(xpath = "//input[@id='name']")
    private WebElement name;

    // name dialog
    @FindBy(xpath = "//input[@id='firstName']")
    private WebElement firstName;

    @FindBy(xpath = "//input[@id='middleName']")
    private WebElement middleName;

    @FindBy(xpath = "//input[@id='lastName']")
    private WebElement lastName;

    @FindBy(xpath = "//span[text()='Save']")
    private WebElement save;

    @FindBy(xpath = "//input[@name='agreedToPrivacyPolicy']")
    private WebElement privacyPolicy;

    @FindBy(id = "formSubmit")
    private WebElement submitButton;


    public void fillUsername(String value) {
        username.sendKeys(value);
    }

    public void fillEmail(String value) {
        email.sendKeys(value);
    }

    public void fillPasswordFields(String value) {
        password.sendKeys(value);
        confirmPassword.sendKeys(value);
    }

    private void fillOutFirstLastName(String firstNameValue, String lastNameValue) {
        name.click();
        firstName.sendKeys(firstNameValue);
        lastName.sendKeys(lastNameValue);
    }

    public void fillName(String firstNameValue, String lastNameValue) {
        fillOutFirstLastName(firstNameValue, lastNameValue);
        save.click();
    }

    public void fillName(String firstNameValue, String middleNameValue, String lastNameValue) {
        fillOutFirstLastName(firstNameValue, lastNameValue);
        middleName.sendKeys(middleNameValue);
        save.click();
    }

    public void fillName(Map<String, String> user) {
        fillName(user.get("firstName"), user.get("middleName"), user.get("lastName"));
    }

    public void acceptPrivacyPolicy() {
        if (!privacyPolicy.isSelected()) {
            privacyPolicy.click();
        }
    }

    public void declinePrivacyPolicy() {
        if (privacyPolicy.isSelected()) {
            privacyPolicy.click();
        }
    }

    public void submit() {
        submitButton.click();
    }
}