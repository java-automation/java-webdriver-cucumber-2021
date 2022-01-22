package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static support.TestContext.getDriver;

public class QuoteFormResult {

    //constructor
    public QuoteFormResult() {
        PageFactory.initElements(getDriver(), this);  //init means initialization
    }


    //fields

    @FindBy (id = "quotePageResul")
    private WebElement resultContainer;

    @FindBy (xpath = "//b[@name='password']")
    private WebElement password;

    @FindBy(xpath = "//b[@name='firstName']") // lazy instantiation
    private WebElement firstName;

    @FindBy(xpath = "//b[@name='lastName']") // lazy instantiation
    private WebElement lastName;

    @FindBy(xpath = "//b[@name='email']") // lazy instantiation
    private WebElement email;

    @FindBy(xpath = "//b[@name='name']")
    private WebElement name;

    @FindBy(xpath = "//b[@name='gender']")
    private WebElement genderType;

    @FindBy(xpath = "//b[@name='agreedToPrivacyPolicy']")
    private WebElement privacyPolicyResult;

    @FindBy(xpath = "//b[@name='phone']")
    private WebElement phoneNumber;



    //methods
    public String getFirstNameResult() {
        return firstName.getText();
    }

    public String getLastNameResult() {
        return lastName.getText();
    }

    public String getEmailResult() {
        return email.getText();
    }

    public String getFullName() {
        return name.getText();
    }

    public String getGenderType() {
        return genderType.getText();
    }

    public String getPolicyResult() {
        return privacyPolicyResult.getText();
    }

    public String getPhoneNumber() {
        return phoneNumber.getText();
    }

    public String getResultContainer() {
        return resultContainer.getText();
    }

    public String getPassword() {
        return password.getText();
    }

    public boolean isAgreedToPrivacyPolicy() {
        return Boolean.parseBoolean( privacyPolicyResult.getText());

    }
}




