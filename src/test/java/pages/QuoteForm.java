package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;
import junit.framework.AssertionFailedError;

import static support.TestContext.getDriver;

public class QuoteForm {

    public static class InputField {
        public static final String USERNAME = "username";
        public static final String EMAIL = "email";
        public static final String PASSWORD = "password";
        public static final String CONFIRM_PASSWORD = "confirmPassword";
        public static final String NAME = "name";
        public static final String PRIVACY_POLICY = "agreedToPrivacyPolicy";
    }

    // constructor
    public QuoteForm() {
        PageFactory.initElements(getDriver(), this);
    }

    // fields
    private String url  = "https://skryabin.com/market/quote.html";

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

    // error messages
    @FindBy(id = "username-error")
    private List<WebElement> usernameErrors;

    @FindBy(id = "email-error")
    private List<WebElement> emailErrors;

    @FindBy(id = "password-error")
    private List<WebElement> passwordErrors;

    @FindBy(id = "confirmPassword-error")
    private List<WebElement> confirmPasswordErrors;

    @FindBy(id = "name-error")
    private List<WebElement> nameErrors;

    @FindBy(id = "agreedToPrivacyPolicy-error")
    private List<WebElement> privacyPolicyErrors;

    //methods
    public void open() {
        getDriver().get(url);
    }

    public WebElement getElement(String field) {
        return switch (field) {
            case InputField.USERNAME -> username;
            case InputField.EMAIL -> email;
            case InputField.PASSWORD -> password;
            case InputField.CONFIRM_PASSWORD -> confirmPassword;
            case InputField.NAME -> name;
            case InputField.PRIVACY_POLICY -> privacyPolicy;
            default -> throw new Error("No input fields associated with the description \"" + field + "\"");
        };
    }

    public void fillOutField (String field, String value) {
        getElement(field).clear();
        getElement(field).sendKeys(value);
    }

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

    public void fillName(String firstNameValue, String lastNameValue) {
        name.click();
        firstName.sendKeys(firstNameValue);
        lastName.sendKeys(lastNameValue);
        save.click();
    }

    public void fillName(String firstNameValue, String middleNameValue, String lastNameValue) {
        name.click();
        firstName.sendKeys(firstNameValue);
        middleName.sendKeys(middleNameValue);
        lastName.sendKeys(lastNameValue);
        save.click();
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

    public void assertFieldValue(String field, String value) {
        assertThat(getElement(field).getAttribute("value")).isEqualTo(value);
    }

    public Optional<WebElement> getErrorElementFor(String field) {
        List<WebElement> errors = switch (field) {
            case InputField.USERNAME -> usernameErrors;
            case InputField.EMAIL -> emailErrors;
            case InputField.PASSWORD -> passwordErrors;
            case InputField.CONFIRM_PASSWORD -> confirmPasswordErrors;
            case InputField.NAME -> nameErrors;
            case InputField.PRIVACY_POLICY -> privacyPolicyErrors;
            default -> throw new Error("No input fields associated with the description \"" + field + "\"");
        };
        return errors.stream().findFirst();
    }

    public void assertNoError(String field) {
        assertThat(getErrorElementFor(field).isEmpty() || !getErrorElementFor(field).get().isDisplayed()).isTrue();
    }

    public void assertErrorMessage(String inputField, String errorMessage) {
        WebElement errorElem = getErrorElementFor(inputField).orElseThrow(AssertionFailedError::new);
        assertThat(errorElem.getText()).isEqualTo(errorMessage);
    }

}
