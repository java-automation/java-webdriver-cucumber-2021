package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Map;

import static org.junit.Assert.assertEquals;
import static support.TestContext.getDriver;

public class SubmitAppForm {

    public SubmitAppForm() {
        PageFactory.initElements(getDriver(), this);
    }

    public static final String PASSWORD_ENTERED = "[entered]";
    public static final String AGREED_PRIVACY_TRUE = "true";
    public static final String SUBMITTED_APPLICATION_PASSWORD_XPATH = "//b[@name='password']";
    public static final String SUBMITTED_APPLICATION_NAME_XPATH = "//b[@name='name']";
    public static final String SUBMITTED_APPLICATION_FIRSTNAME_XPATH = "//b[@name='firstName']";
    public static final String SUBMITTED_APPLICATION_MIDDLE_NAME_XPATH = "//b[@name='middleName']";
    public static final String SUBMITTED_APPLICATION_LASTNAME_XPATH = "//b[@name='lastName']";
    public static final String SUBMITTED_APPLICATION_USERNAME_XPATH = "//b[@name='username']";
    public static final String SUBMITTED_APPLICATION_EMAIL_XPATH = "//b[@name='email']";
    public static final String SUBMITTED_APPLICATION_AGREED_TO_PRIVACY_POLICY_XPATH = "//b[@name='agreedToPrivacyPolicy']";
    public static final String SUBMITTED_APPLICATION_PAGE_RESULT_XPATH = "//div[@id='quotePageResult']";

    @FindBy(xpath = SUBMITTED_APPLICATION_NAME_XPATH)
    private WebElement name;
    @FindBy(xpath = SUBMITTED_APPLICATION_FIRSTNAME_XPATH)
    private WebElement firstName;
    @FindBy(xpath = SUBMITTED_APPLICATION_MIDDLE_NAME_XPATH)
    private WebElement middleName;
    @FindBy(xpath = SUBMITTED_APPLICATION_LASTNAME_XPATH)
    private WebElement lastName;
    @FindBy(xpath = SUBMITTED_APPLICATION_USERNAME_XPATH)
    private WebElement username;
    @FindBy(xpath = SUBMITTED_APPLICATION_EMAIL_XPATH)
    private WebElement email;
    @FindBy(xpath = SUBMITTED_APPLICATION_AGREED_TO_PRIVACY_POLICY_XPATH)
    private WebElement privacyPolicy;
    @FindBy(xpath = SUBMITTED_APPLICATION_PAGE_RESULT_XPATH)
    private WebElement pageResult;
    @FindBy(xpath = SUBMITTED_APPLICATION_PASSWORD_XPATH)
    private WebElement password;


    public void assertFullName(Map<String, String> user) {
        assertEquals(name.getText(), getFullName(user));
    }

    private String getFullName(Map<String, String> user) {
        if (user.get("middleName") == null || user.get("middleName") == "") {
            return "%s %s".formatted(user.get("firstName"), user.get("lastName"));
        } else
            return "%s %s %s".formatted(user.get("firstName"), user.get("middleName"), user.get("lastName"));
    }

    public void firstName(Map<String, String> user) {
        if (user.get("firstName") != "" && user.get("firstName") != null)
            assertEquals(firstName.getText(), user.get("firstName"));
    }

    public void middleName(Map<String, String> user) {
        if (user.get("middleName") != "" && user.get("middleName") != null)
            assertEquals(middleName.getText(), user.get("middleName"));
    }

    public void lastName(Map<String, String> user) {
        if (user.get("lastName") != "" || user.get("lastName") != null)
            assertEquals(lastName.getText(), user.get("lastName"));
    }

    public void assertEmail(Map<String, String> user) {
        assertEquals(email.getText(), user.get("email"));
    }

    public void assertUsername(Map<String, String> user) {
        assertEquals(username.getText(), user.get("username"));
    }

    public void assertPassword() {
        assertEquals(password.getText(), PASSWORD_ENTERED);
    }

    public void agreedPrivacy() {  //why do we need that assertion, if without it data will not be submitted?
        assertEquals(privacyPolicy.getText(), AGREED_PRIVACY_TRUE);
    }
}
