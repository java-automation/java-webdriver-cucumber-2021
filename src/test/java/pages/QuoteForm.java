package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static support.TestContext.getDriver;

public class QuoteForm {

    //constructor
    public QuoteForm() {
        PageFactory.initElements(getDriver(), this);
    }

    //fields
    private String url = "https://skryabin.com/market/quote.html";

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

    //name dialog
    @FindBy(xpath = "//input[@id='firstName']")
    private WebElement firstName;

    @FindBy(xpath = "//input[@name='lastName']")
    private WebElement lastName;

    @FindBy(xpath = "//input[@name='middleName']")
    private WebElement middleName;

    @FindBy(xpath = "//span[text()='Save']")
    private WebElement save;

    @FindBy(xpath = "//input[@name='agreedToPrivacyPolicy']")
    private WebElement privacyPolicy;

    @FindBy(id = "formSubmit")
    private WebElement submitButton;

    //validation
    private String requiredField = "//label[@id='%s-error']";

    @FindBy(xpath = "//b[@name='name']")
    private WebElement verifyName;

    @FindBy(id = "return")
    private WebElement returnButton;

    //methods
    public void open() {
        getDriver().get(url);
    }

    public void fillUsername(String value) {
        username.sendKeys(value);
    }

    public void fillEmail(String value) {
        email.clear();
        email.sendKeys(value);
    }

    public void fillPasswordFields(String value) {
        password.sendKeys(value);
        confirmPassword.sendKeys(value);
    }

    public void fillPassword(String value) {
        password.sendKeys(value);
    }

    public void fillConfirmPassword(String value) {
        confirmPassword.sendKeys(value);
    }

    public void fillName(String firstNameValue, String lastNameValue) {
        name.click();
        firstName.sendKeys(firstNameValue);
        lastName.sendKeys(lastNameValue);
        save.click();
    }

    public void fillFullName(String firstNameValue, String lastNameValue, String middleNameValue) {
        name.click();
        firstName.sendKeys(firstNameValue);
        lastName.sendKeys(lastNameValue);
        middleName.sendKeys(middleNameValue);
        save.click();
    }

    public void acceptPrivacyPolicy() {
        if(!privacyPolicy.isSelected()) {
            privacyPolicy.click();
        }

    }
    public void declinePrivacyPolicy() {
        if(privacyPolicy.isSelected()) {
            privacyPolicy.click();
        }
    }

    public void submit() {
        submitButton.click();
    }

    public void returnBack() {
        returnButton.click();
    }

    public String getWebElement(String field) {
        return String.format(requiredField, field);

    }

    public void checkRequiredFieldErrorNotPresent(String field) {
        if(getDriver().findElements(By.xpath(getWebElement(field))).size() == 1){
            assertThat(getDriver().findElement(By.xpath(getWebElement(field))).isDisplayed());
        } else {
            assertThat(getDriver().findElements(By.xpath(getWebElement(field)))).hasSize(0);
        }
    }

    public void checkRequiredFieldErrorPresent(String field) {
        assertThat(getDriver().findElements(By.xpath(getWebElement(field)))).hasSize(1);

    }

    public void checkRequiredFieldErrorIsCorrect(String field, String error) {
        WebElement requiredFieldDynamic = getDriver().findElement(By.xpath(getWebElement(field)));
        assertThat(requiredFieldDynamic.getText()).isEqualTo(error);
    }

    public void fillField(String fieldName, String value) {
        switch (fieldName) {
            case "username":
                this.fillUsername(value);
                break;
            case "email":
                this.fillEmail(value);
                break;
            case "password":
                this.fillPassword(value);
                break;
            case "confirmPassword":
                this.fillConfirmPassword(value);
                break;
            default:
                System.out.println("This field name is not an option.");
        }
    }

    public void verifyName(String field, String value) {
        System.out.println(verifyName.getText());
        assertThat(verifyName.getText().equals(value));
    }

    public boolean returnButtonIsDisplayed() {
        return returnButton.isDisplayed();
    }
}
