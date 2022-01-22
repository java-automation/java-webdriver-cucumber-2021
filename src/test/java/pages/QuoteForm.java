package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static support.TestContext.getDriver;

public class QuoteForm extends Page {

    // constructor
    public QuoteForm() {
        url  = "https://skryabin.com/market/quote.html";
        title = "Get a Quote";
    }

    @FindBy(xpath = "//input[@name='username']")
    private WebElement username;
    @FindBy(xpath = "//input[@name='username']/following-sibling::label[@class='error']")
    private WebElement usernameError;

    @FindBy(xpath = "//input[@name='email']")
    private WebElement email;
    @FindBy(xpath = "//input[@name='email']/following-sibling::label[@class='error']")
    private WebElement emailError;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement password;
    @FindBy(xpath = "//input[@name='password']/following-sibling::label[@class='error']")
    private WebElement passwordError;

    @FindBy(xpath = "//input[@name='confirmPassword']")
    private WebElement confirmPassword;
    @FindBy(xpath = "//input[@name='confirmPassword']/following-sibling::label[@class='error']")
    private WebElement confirmPasswordError;

    @FindBy(xpath = "//input[@id='name']")
    private WebElement name;
    @FindBy(xpath = "//input[@id='name']/following-sibling::label[@class='error']")
    private WebElement nameError;

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
    @FindBy(xpath = "//input[@name='agreedToPrivacyPolicy']/following-sibling::label[@class='error']")
    private WebElement privacyPolicyError;

    @FindBy(id = "formSubmit")
    private WebElement submitButton;

    //methods
    public void open() {
        getDriver().get(url);
    }

    public void fillUsername(String value) {
        username.sendKeys(value);
    }

    public void fillEmail(String value) {
        email.sendKeys(value);
    }

    public void fillPasswordField(String value) {
        password.clear();
        password.sendKeys(value);
    }

    public void fillConfirmPasswordField(String value) {
        confirmPassword.clear();
        confirmPassword.sendKeys(value);
    }

    public void fillPasswordFields(String value) {
        password.sendKeys(value);
        confirmPassword.sendKeys(value);
    }

    public void fillName(String firstNameValue, String middleNameValue, String lastNameValue) {
        name.click();
        firstName.sendKeys(firstNameValue);
        middleName.sendKeys((middleNameValue));
        lastName.sendKeys(lastNameValue);
        save.click();
    }

    public String getNameFieldContents() {
        return name.getAttribute("value");
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

    public boolean isErrorMessageVisible(String sField, String sMessage) throws NoSuchElementException {
        try {
            switch (sField) {
                case "username":
                    return usernameError.isDisplayed() && usernameError.getText().contains(sMessage);
                case "email":
                    return emailError.isDisplayed() && emailError.getText().contains(sMessage);
                case "password":
                    return passwordError.isDisplayed() && passwordError.getText().contains(sMessage);
                case "confirmPassword":
                    return confirmPasswordError.isDisplayed() && confirmPasswordError.getText().contains(sMessage);
                case "name":
                    return nameError.isDisplayed() && nameError.getText().contains(sMessage);
                case "agreedToPrivacyPolicy":
                    return privacyPolicyError.isDisplayed() && privacyPolicyError.getText().contains(sMessage);
                default:
                    return false;
            }
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
