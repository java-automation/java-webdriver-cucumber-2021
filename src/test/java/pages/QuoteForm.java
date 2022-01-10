package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Map;

import static support.TestContext.getDriver;

public class QuoteForm {

    //constructor
    public QuoteForm() {
        PageFactory.initElements(getDriver(), this);
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
        username.sendKeys(value);
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

    public void fillEmail(String value) {
        email.sendKeys(value);
    }

    public void fillPassword(String value) {
        password.sendKeys(value);
        confirmPassword.sendKeys(value);
    }

    public void selectPrivacyPolicy() {
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
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(QUOTE_PAGE_RESULT_XPATH)));
    }
}
