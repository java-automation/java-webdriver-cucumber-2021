package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static support.TestContext.getDriver;

public class QuoteFormResults {

    //constructor
    public QuoteFormResults(){
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(xpath = "//b[@name='firstName']")
    private WebElement firstNameResult;

    @FindBy(xpath = "//b[@name='lastName']")
    private WebElement lastNameResult;

    @FindBy(xpath = " //b[@name='name']")
    private WebElement fullName;

    @FindBy(xpath = "//b[@name='email']")
    private WebElement emailResult;

    @FindBy(xpath = "//b[@name='agreedToPrivacyPolicy']")
    private WebElement privacyPolicyResult;

    @FindBy(xpath = "//b[@name='username']")
    private WebElement userNameResult;

    @FindBy(xpath = "//b[@name='phone']")
    private WebElement phoneResult;

    @FindBy(xpath = "//b[@name='address']")
    private WebElement addressResult;

    @FindBy(xpath = "//b[@name='dateOfBirth']")
    private WebElement dateOfBirthResult;

    @FindBy(xpath = "//b[@name='countryOfOrigin']")
    private WebElement countryOfOriginResult;

    @FindBy(xpath = "//b[@name='location']")
    private WebElement locationResult;

    @FindBy(xpath = "//b[@name='gender']")
    private WebElement gender;



    public String getFirstNameResult(){
        return firstNameResult.getText();
    }

    public String getLastNameResult(){
        return lastNameResult.getText();
    }

    public String getFullName(){
        return fullName.getText();
    }

    public String getEmailResult(){
        return emailResult.getText();
    }

    public String getPrivacyPolicyResult(){
        return privacyPolicyResult.getText();
    }

    public String getUserNameResult(){
        return userNameResult.getText();
    }
    public String getDateOfBirth (){ return dateOfBirthResult.getText();}
    public String getCountryOfOrigin (){ return countryOfOriginResult.getText();}

    public String getAddress(){
        return addressResult.getText();
    }
    public String getPhoneResult(){
      return  phoneResult.getText();
    }


    public String getGender(){
        return gender.getText();
    }

}

