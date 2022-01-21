package pages;

import definitions.HelperStepDefs;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static support.TestContext.getDriver;

public class QuoteErrorsPage extends HelperStepDefs {
    public static final String DEFAULT_ERROR_TEXT = "This field is required.";
    public static final String USERNAME_ERROR_XPATH = "//label[@id='username-error']";
    public static final String EMAIL_ERROR_XPATH = "//label[@id='email-error']";
    public static final String PASSWORD_ERROR_XPATH = "//label[@id='password-error']";
    public static final String PASSWORD_EMPTY_ERROR_XPATH = "//label[@id='password-error']";
    public static final String PASSWORD_INVALID_ERROR_XPATH = "//label[@id='password-error']";
    public static final String CONFIRM_PASSWORD_ERROR_XPATH = "//label[@id='confirmPassword-error']";
    public static final String CONFIRM_PASSWORD_EMPTY_ERROR_XPATH = "//label[@id='confirmPassword-error']";
    public static final String CONFIRM_PASSWORD_INVALID_ERROR_XPATH = "//label[@id='confirmPassword-error']";
    public static final String NAME_ERROR_XPATH = "//label[@id='name-error']";
    public static final String PRIVACY_POLICY_ERROR_XPATH = "//label[@id='agreedToPrivacyPolicy-error']";
    public static final String ERRORS_XPATH = "//label[@class='error']";
    public static final String PRIVACY_POLICY_ERROR_MESSAGE = " - Must check! ";

    //constructor
    public QuoteErrorsPage() {
        PageFactory.initElements(getDriver(), this);
    }

    //field
    @FindBy(xpath = USERNAME_ERROR_XPATH)
    private WebElement username;
    @FindBy(xpath = EMAIL_ERROR_XPATH)
    private WebElement email;
    @FindBy(xpath = PASSWORD_ERROR_XPATH)
    private WebElement password;
    @FindBy(xpath = PASSWORD_EMPTY_ERROR_XPATH)
    private WebElement passwordEmpty;
    @FindBy(xpath = PASSWORD_INVALID_ERROR_XPATH)
    private WebElement passwordInvalid;
    @FindBy(xpath = CONFIRM_PASSWORD_ERROR_XPATH)
    private WebElement confirmPassword;
    @FindBy(xpath = CONFIRM_PASSWORD_EMPTY_ERROR_XPATH)
    private WebElement confirmPasswordEmpty;
    @FindBy(xpath = CONFIRM_PASSWORD_INVALID_ERROR_XPATH)
    private WebElement confirmPasswordInvalid;
    @FindBy(xpath = NAME_ERROR_XPATH)
    private WebElement name;
    @FindBy(xpath = PRIVACY_POLICY_ERROR_XPATH)
    private WebElement privacyPolicy;

    @FindAll({@FindBy(xpath = USERNAME_ERROR_XPATH)})
    private List<WebElement> listUserNameError;

    public List<WebElement> getListUserNameError() {
        return listUserNameError;
    }

    @FindAll({@FindBy(xpath = EMAIL_ERROR_XPATH)})
    private List<WebElement> listEmailError;

    public List<WebElement> getListEmailError() {
        return listEmailError;
    }

    @FindAll({@FindBy(xpath = PASSWORD_ERROR_XPATH)})
    private List<WebElement> listPasswordError;

    public List<WebElement> getListPasswordError() {
        return listPasswordError;
    }

    @FindAll({@FindBy(xpath = CONFIRM_PASSWORD_ERROR_XPATH)})
    private List<WebElement> listConfirmPasswordError;

    public List<WebElement> getListConfirmPasswordError() {
        return listConfirmPasswordError;
    }


    @FindAll({@FindBy(xpath = NAME_ERROR_XPATH)})
    private List<WebElement> listNameError;

    public List<WebElement> getListNameError() {
        return listNameError;
    }

    @FindAll({@FindBy(xpath = PRIVACY_POLICY_ERROR_XPATH)})
    private List<WebElement> listPrivacyPolicyError;

    public List<WebElement> getPrivacyPolicyError() {
        return listPrivacyPolicyError;
    }

    public boolean isPresent(List<WebElement> list) {
        return list.size() > 0;
    }

    public boolean isElementVisible(List<WebElement> list) {
        if (isPresent(list)) {
            return list.get(0).isDisplayed();
        } else return false;
    }

    public void iDonTSeeErrorMessage(String requiredFieldName) {
        switch (requiredFieldName) {
            case "username": {
                assertFalse(isElementVisible(listUserNameError));
                break;
            }
            case "email": {
                assertFalse(isElementVisible(listEmailError));
                break;
            }
            case "password": {
                assertFalse(isElementVisible(listPasswordError));
                break;
            }
            case "confirmPassword": {
                assertFalse(isElementVisible(listConfirmPasswordError));
                break;
            }
            case "name": {
                assertFalse(isElementVisible(listNameError));
                break;
            }
            case "agreedToPrivacyPolicy": {
                assertFalse(isElementVisible(listPrivacyPolicyError));
                break;
            }
            default: {
                throw new Error("Field " + requiredFieldName + " is not required");
            }
        }
    }

    public void iSeeErrorMessage(String requiredFieldName, String message) {
        switch (requiredFieldName) {
            case "agreedToPrivacyPolicy": {
                assertEquals(privacyPolicy.getText(), message);
                break;
            }
            case "username": {
                assertEquals(username.getText(), message);
                break;
            }
            case "email": {
                assertEquals(email.getText(), message);
                break;
            }
            case "password": {
                assertEquals(passwordEmpty.getText(), message);
                break;
            }
            case "name": {
                assertEquals(name.getText(), message);
                break;
            }
            case "confirmPassword": {
                assertEquals(confirmPassword.getText(), message);
                break;
            }
            default: {
                throw new Error("Field " + requiredFieldName + " is not required");
            }
        }
    }
}
