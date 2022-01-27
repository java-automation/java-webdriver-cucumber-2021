package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Map;

import static org.junit.Assert.assertEquals;
import static support.TestContext.getDriver;

public class QuoteForm extends Page {

    //constructor
    public QuoteForm() {
        url  = "https://skryabin.com/market/quote.html";
        title = "Get a Quote";
    }

    //fields
    WebDriverWait wait = new WebDriverWait(getDriver(), 5);
    String url = "https://skryabin.com/market/quote.html";
    public static final String QUOTE_PAGE_RESULT_XPATH = "//div[@id='quotePageResult']";
    public static final String PRIVACY_POLICY_XPATH = "//input[@name='agreedToPrivacyPolicy']";
    public static final String USERNAME_XPATH = "//input[@name='username']";
    public static final String EMAIL_XPATH = "//input[@name='email']";
    public static final String PASSWORD_XPATH = "//input[@name='password']";
    public static final String NAME_XPATH = "//input[@id='name']";
    public static final String FIRST_NAME_XPATH = "//input[@id='firstName']";
    public static final String MIDDLE_NAME_XPATH = "//input[@id='middleName']";
    public static final String LASTNAME_XPATH = "//input[@id='lastName']";
    public static final String SAVE_NAME_BUTTON_XPATH = "//span[text()='Save']";
    public static final String CONFIRM_PASSWORD_XPATH = "//input[@name='confirmPassword']";
    public static final String SUBMIT_BUTTON = "//button[@id='formSubmit']";
    public static final String ERRORS_XPATH = "//label[@class='error']";

    @FindBy(xpath = USERNAME_XPATH)
    private WebElement username;
    @FindBy(xpath = NAME_XPATH)
    private WebElement name;
    @FindBy(xpath = FIRST_NAME_XPATH)
    private WebElement firstName;
    @FindBy(xpath = MIDDLE_NAME_XPATH)
    private WebElement middleName;
    @FindBy(xpath = LASTNAME_XPATH)
    private WebElement lastName;
    @FindBy(xpath = SAVE_NAME_BUTTON_XPATH)
    private WebElement saveNameButton;
    @FindBy(xpath = EMAIL_XPATH)
    private WebElement email;
    @FindBy(xpath = PASSWORD_XPATH)
    private WebElement password;
    @FindBy(xpath = CONFIRM_PASSWORD_XPATH)
    private WebElement confirmPassword;
    @FindBy(xpath = PRIVACY_POLICY_XPATH)
    private WebElement privacyPolicy;
    @FindBy(xpath = SUBMIT_BUTTON)
    private WebElement submitButton;


    //methods
    public void open(String url) {
        getDriver().get(url);
    }

    public void fillUsername(String value) {
        username.clear();
        username.sendKeys(value);
        assertEquals(getDriver().findElement(By.xpath(USERNAME_XPATH)).getAttribute("value"), value);
    }

    public void fillName(Map<String, String> user) {
        name.click();
        if (user.get("firstName") != null)
            firstName.sendKeys(user.get("firstName"));
        if (user.get("middleName") != null)
            middleName.sendKeys(user.get("middleName"));
        if (user.get("lastName") != null)
            lastName.sendKeys(user.get("lastName"));
        saveNameButton.click();
    }

    public void fillName(String first, String middle, String last) {
        name.click();
        if ((first != null) && (!first.equals(""))) {
            firstName.clear();
            firstName.sendKeys(first);
        }
        if ((middle != null) && (!middle.equals(""))) {
            middleName.clear();
            middleName.sendKeys(middle);
        }
        if ((last != null) && (!last.equals(""))) {
            lastName.clear();
            lastName.sendKeys(last);
        }
        saveNameButton.click();
    }

    public void fillEmail(String value) {
        email.clear();
        email.sendKeys(value);
        assertEquals(getDriver().findElement(By.xpath(EMAIL_XPATH)).getAttribute("value"), value);

    }

    public void fillPassword(String value) {
        password.sendKeys(value);
        confirmPassword.sendKeys(value);
    }
    public void fillPasswordFields(String value) {
        password.sendKeys(value);
        confirmPassword.sendKeys(value);
    }

    public void fillOutOnlyPasswordField(String value) {
        password.clear();
        password.sendKeys(value);
    }

    public void fillOutOnlyConfirmPasswordField(String value) {
        confirmPassword.clear();
        confirmPassword.sendKeys(value);
    }

    public void selectPrivacyPolicy() {
        if (!privacyPolicy.isSelected()) {
            privacyPolicy.click();
        }
    }
    public void acceptPrivacyPolicy() {
        if (!privacyPolicy.isSelected()) {
            privacyPolicy.click();
        }
    }

    public void deSelectPrivacyPolicy() {
        if (privacyPolicy.isSelected()) {
            privacyPolicy.click();
        }
    }

    public void submit() {
        submitButton.click();
        if (!isPresent(By.xpath(ERRORS_XPATH))) {
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(QUOTE_PAGE_RESULT_XPATH)));
        } else
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(ERRORS_XPATH)));
    }

    public void assertFieldValue(String field, String value) {
        switch (field) {
            case "name": {
                assertEquals(name.getAttribute("value"), value);
                break;
            }
            default: {
                throw new Error("Unknown field to verify!");
            }
        }
    }
}
