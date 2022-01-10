package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

import static support.TestContext.getDriver;

public class QuoteResults {

    private WebElement field;

    //constructor
    public QuoteResults() {
        PageFactory.initElements(getDriver(), this);
    }

    //fields
    private String fieldName;

    @FindBy(xpath = "//b[@name='username']")
    private WebElement username;

    @FindBy(xpath = "//b[@name='email']")
    private WebElement email;

    @FindBy(xpath = "//b[@name='password']")
    private WebElement password;

    @FindBy(xpath = "//b[@name='name']")
    private WebElement name;

    @FindBy(xpath = "//b[@name='firstName']")
    private WebElement firstName;

    @FindBy(xpath = "//b[@name='lastName']")
    private WebElement lastName;

    @FindBy(xpath = "//b[@name='agreedToPrivacyPolicy']")
    private WebElement privacyPolicy;

    public String getUsernameValue() {
        return username.getText();
    }
    public String getEmailValue() {
        return email.getText();
    }
    public boolean getPasswordValue() {
        if(password.getText().equals("[entered]")) {
            return true;
        }
        return false;
    }
    public String getFirstNameValue() {
        return firstName.getText();
    }
    public String getLastNameValue() {
        return lastName.getText();
    }
    public boolean getNameValue() {
        if(name.getText().equals(firstName.getText() + " " + lastName.getText())) {
            return true;
        }
        return false;
    }
    public boolean getPrivacyPolicyValue() {
        if(privacyPolicy.getText().equals("true")) {
            return true;
        }
        return false;
    }



//    public String getValue(String field) {
//        System.out.println(this.field.getText());
//        return this.field.getText();
//    }
}
