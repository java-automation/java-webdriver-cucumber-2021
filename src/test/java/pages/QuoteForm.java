package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static support.TestContext.getDriver;

public class QuoteForm {

    //constructor
    public QuoteForm() {
        PageFactory.initElements(getDriver(), this);  //init means initialization
    }

    //fields
    private String url = "https://skryabin.com/market/quote.html";

    @FindBy (xpath = "//input[@name='username']") // lazy instantiation
    private WebElement username;

    @FindBy (xpath = "//input[@name='email']") // lazy instantiation
    private WebElement email;

    @FindBy (xpath = "//input[@name='password']") // lazy instantiation
    private WebElement password;

    @FindBy (xpath = "//input[@name='confirmPassword']") // lazy instantiation
    private WebElement confirmPassword;

    @FindBy (xpath = "//input[@id='name']") // lazy instantiation
    private WebElement name;

    //name dialogue
    @FindBy (xpath = "//input[@id='firstName']") // lazy instantiation
    private WebElement firstName;

    @FindBy (xpath = "//input[@id='lastName']") // lazy instantiation
    private WebElement lastName;

    @FindBy (xpath = "//span[text()='Save']") // lazy instantiation
    private WebElement save;

    @FindBy (xpath = "//input[@value='male']") // lazy instantiation
    private WebElement male;

    @FindBy (xpath = "//input[@name='agreedToPrivacyPolicy']") // lazy instantiation
    private WebElement privacyPolicy;

    @FindBy (xpath = "//button[@type='submit']") // lazy instantiation
    private WebElement submitButton;

    @FindBy (xpath = "//input[@name='phone']") // lazy instantiation
    private WebElement phone;

    @FindBy (xpath = "//input[@id='contactPersonName']")
    private WebElement contactPerson;


    //methods
    public void open() {
        getDriver().get(url);
    }

    public void fillUsername(String value) {
        username.sendKeys(value);
    }

    public void fillEmail (String value) {
        email.sendKeys(value);
    }

    public void fillPasswords (String value) {
        password.sendKeys(value);
        confirmPassword.sendKeys(value);
    }

    public void fillName (String firstNameValue, String lastNameValue) {
        name.click();
        firstName.sendKeys(firstNameValue);
        lastName.sendKeys(lastNameValue);
        save.click();

    }

    public void selectGender () {
        male.click();
    }

    public void fillPhoneNumber (String value) {
        phone.sendKeys(value);
    }

    public void acceptPrivacyPolicy () {
        if(!privacyPolicy.isSelected()) {
            privacyPolicy.click();
        }
    }

    public void declinePrivacyPolicy () {
        if (privacyPolicy.isSelected()) {
            privacyPolicy.click();
        }
    }

    public void submit () {
        submitButton.click();

    }

    public void contactPersonName (String value){
        getDriver().switchTo().frame("additionalInfo");
        contactPerson.sendKeys(value);
        getDriver().switchTo().defaultContent();
    }

}
