package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

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

    @FindBy (id = "username-error")
    private List<WebElement> usernameError;                                 // Username Error

    @FindBy (xpath = "//input[@name='email']") // lazy instantiation
    private WebElement email;

    @FindBy (id = "email-error")                             // Email Error
    private List<WebElement> emailError;

    @FindBy (xpath = "//input[@name='password']") // lazy instantiation
    private WebElement password;

    @FindBy (id = "password-error")
    private List<WebElement> passwordError;                                 // Password Error

    @FindBy (xpath = "//input[@name='confirmPassword']") // lazy instantiation
    private WebElement confirmPassword;

    @FindBy (xpath = "//input[@id='name']") // lazy instantiation
    private WebElement name;

    @FindBy (id = "name-error")
    private List<WebElement> nameError;                                     // Name Error

    //name dialogue
    @FindBy (xpath = "//input[@id='firstName']") // lazy instantiation
    private WebElement firstName;

    @FindBy (xpath = "//input[@id='middleName']")
    private WebElement middleName;

    @FindBy (xpath = "//input[@id='lastName']") // lazy instantiation
    private WebElement lastName;

    @FindBy (xpath = "//span[text()='Save']") // lazy instantiation
    private WebElement save;

    @FindBy (xpath = "//input[@value='male']") // lazy instantiation
    private WebElement male;

    @FindBy (xpath = "//input[@name='agreedToPrivacyPolicy']") // lazy instantiation
    private WebElement privacyPolicy;

    @FindBy (id= "agreedToPrivacyPolicy-error")                  // Privacy Policy Error
    private List<WebElement> privacyPolicyError;

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

    public void refreshPage() {
        getDriver().navigate().refresh();
    }

    public void fillEmail (String value) {
        email.sendKeys(value);
    }

    public void fillPasswords (String value) {
        password.sendKeys(value);
        confirmPassword.sendKeys(value);
    }

    public void fillName (String firstNameValue, String middleNameValue,String lastNameValue) {
        name.click();
        firstName.sendKeys(firstNameValue);
        middleName.sendKeys(middleNameValue);
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

    public boolean isErrorMessageVisible(String fieldName) {
        WebElement errorMessageElement = getErrorMessageElement(fieldName);
        return (errorMessageElement != null) && errorMessageElement.isDisplayed();
    }


    public String getErrorMessage(String fieldName) {
        WebElement errorMessageElement = getErrorMessageElement(fieldName);
        if ((errorMessageElement == null) || !errorMessageElement.isDisplayed())
            throw new Error("Message element does not exist or is not visible!");
        return errorMessageElement.getText();
    }



    private WebElement getErrorMessageElement(String fieldName) {

       List<WebElement> list = switch (fieldName) {
            case "username" -> usernameError;
            case "email" -> emailError;
            case  "password" -> passwordError;
            case "name" -> nameError;
            case "agreedToPrivacyPolicy" -> privacyPolicyError;
            default -> throw new Error("Unknown field name reference: " + fieldName);
        };

        return list.size() > 0 ? list.get(0) : null;
    }
}
