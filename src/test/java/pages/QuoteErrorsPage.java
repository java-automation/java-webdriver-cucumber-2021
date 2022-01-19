package pages;

import definitions.HelperStepDefs;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

    public void iDonTSeeErrorMessage(String requiredFieldName) {
        switch (requiredFieldName) {
            case "username": {
                if (isPresent(By.xpath(USERNAME_ERROR_XPATH))) {
                    assertFalse(getDriver().findElement(By.xpath(USERNAME_ERROR_XPATH)).isDisplayed());
                } else
                    assertFalse(isPresent(By.xpath(USERNAME_ERROR_XPATH)));
                break;
            }
            case "email": {
                if (isPresent(By.xpath(EMAIL_ERROR_XPATH))) {
                    assertFalse(getDriver().findElement(By.xpath(EMAIL_ERROR_XPATH)).isDisplayed());
                } else
                    assertFalse(isPresent(By.xpath(EMAIL_ERROR_XPATH)));
                break;
            }
            case "password": {
                if (isPresent(By.xpath(PASSWORD_ERROR_XPATH))) {
                    assertFalse(getDriver().findElement(By.xpath(PASSWORD_ERROR_XPATH)).isDisplayed());
                } else
                    assertFalse(isPresent(By.xpath(PASSWORD_ERROR_XPATH)));
                break;
            }
            case "confirmPassword": {
                if (isPresent(By.xpath(CONFIRM_PASSWORD_ERROR_XPATH))) {
                    assertFalse(getDriver().findElement(By.xpath(CONFIRM_PASSWORD_ERROR_XPATH)).isDisplayed());
                } else
                    assertFalse(isPresent(By.xpath(CONFIRM_PASSWORD_ERROR_XPATH)));
                break;
            }
            case "name": {
                if (isPresent(By.xpath(NAME_ERROR_XPATH))) {
                    assertFalse(getDriver().findElement(By.xpath(NAME_ERROR_XPATH)).isDisplayed());
                } else
                    assertFalse(isPresent(By.xpath(NAME_ERROR_XPATH)));
                break;
            }
            case "agreedToPrivacyPolicy": {
                if (isPresent(By.xpath(PRIVACY_POLICY_ERROR_XPATH))) {
                    assertFalse(getDriver().findElement(By.xpath(PRIVACY_POLICY_ERROR_XPATH)).isDisplayed());
                } else
                    assertFalse(isPresent(By.xpath(PRIVACY_POLICY_ERROR_XPATH)));
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
                Assert.assertEquals(privacyPolicy.getText(), message);
                break;
            }
            case "username": {
                Assert.assertEquals(username.getText(), message);
                break;
            }
            case "email": {
                Assert.assertEquals(email.getText(), message);
                break;
            }
            case "password": {
                Assert.assertEquals(passwordEmpty.getText(), message);
                break;
            }
            case "name": {
                Assert.assertEquals(name.getText(), message);
                break;
            }
            case "confirmPassword": {
                Assert.assertEquals(confirmPassword.getText(), message);
                break;
            }
            default: {
                throw new Error("Field " + requiredFieldName + " is not required");
            }
        }
    }
}
