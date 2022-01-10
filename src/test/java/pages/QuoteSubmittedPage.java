package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static support.TestContext.getDriver;

public class QuoteSubmittedPage {

    //constructor
    public QuoteSubmittedPage() {
        PageFactory.initElements(getDriver(), this);
    }

    //selectors

    @FindBy(xpath = "//span[text()='Username']")
    private WebElement username;

    @FindBy(xpath = "//span[text()='Last Name']")
    private WebElement lastName;

    @FindBy(xpath = "//span[text()='First Name']")
    private WebElement firstName;

    @FindBy(xpath = "//span[text()='Email']")
    private WebElement email;


    @FindBy(xpath = "//span[text()='Name']")
    private WebElement name;

    @FindBy(xpath = "//span[text()='Agreed To Privacy Policy']")
    private WebElement privacyPolicy;


//methods

    public void verifyUsernameIsDisplayed() {
        username.isDisplayed();
    }

    public void verifyLastNameIsDisplayed() {
        lastName.isDisplayed();
    }

    public void verifyFirstNameIsDisplayed() {
        firstName.isDisplayed();
    }

    public void verifyEmailIsDisplayed() {
        email.isDisplayed();
    }

    public void verifyNameIsDisplayed() {
        name.isDisplayed();
    }

    public void verifyPrivacyPolicyIsDisplayed() {
        privacyPolicy.isDisplayed();
    }
}
