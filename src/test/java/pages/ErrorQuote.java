package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static support.TestContext.getDriver;

public class ErrorQuote {

    public ErrorQuote(){

        PageFactory.initElements(getDriver(),this);
    }


    //Fields for error


    @FindBy(xpath = "//label[@id='username-error']")
    private WebElement usernameError;


    @FindBy(xpath = "//label[@id='email-error']")
    private WebElement emailError;

    @FindBy(xpath = "//label[@id='password-error']")
    private WebElement passwordError;

    @FindBy(xpath = "//label[@id='confirmPassword-error']")
    private WebElement confirmPasswordError;

    @FindBy(xpath = "//label[@id='name-error']")
    private WebElement nameError;

    @FindBy(xpath = "//label[@id='agreedToPrivacyPolicy-error']")
    private WebElement privacyPolicyError;

//fields for fields


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

    @FindBy(xpath = "//input[@id='lastName']")
    private WebElement lastName;

    @FindBy(xpath = "//span[text()='Save']")
    private WebElement save;

    @FindBy(xpath = "//input[@name='agreedToPrivacyPolicy']")
    private WebElement privacyPolicy;

    @FindBy(id = "formSubmit")
    private WebElement submitButton;


//methods

    public void seeUsernameError(String value) {
        usernameError.sendKeys(value);
    }

    public void seeEmailError(String value) {

        emailError.sendKeys(value);
    }

    public void seePasswordFieldError(String value) {
        passwordError.sendKeys(value);
        confirmPasswordError.sendKeys(value);

    }

    public void seeNameError(String value) {
        nameError.sendKeys(value);

    }

    public void seeAcceptPrivacyPolicyError(){
            privacyPolicyError.sendKeys(privacyPolicyError.getCssValue("- Must check!"));
        }



        }
