package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginCareers extends Page {


    public LoginCareers(){

       // PageFactory.initElements(getDriver(),this);
    }
    @FindBy(xpath = "//input[@placeholder='Please enter an Email']")
    private WebElement username;

    @FindBy(xpath = "//input[@placeholder='Please enter a Password']")
    private WebElement password;


    @FindBy(xpath = "//button[@id='loginButton']")
    private WebElement submit;


    public void clickSubmit(){
        submit.click();
    }

    public void fillPassword(String value){
        password.sendKeys(value);
    }

    public void fillUserName(String value){
        username.sendKeys(value);

    }
}
