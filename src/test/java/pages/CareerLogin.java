package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.security.SecureRandom;
import java.util.Map;

public class CareerLogin extends Page{
    @FindBy(xpath = "//label[@for='loginUsername']/../input")
    private WebElement username;

    @FindBy(xpath = "//label[@for='loginPassword']/../input")
    private WebElement password;

    @FindBy(xpath = "//button[@id='loginButton']")
    private WebElement submitButton;

    @FindBy(xpath = "//span[@class='logout-box']/a")
    private WebElement loggedUserName;

    public void login(String usernameValue, String passwordValue){
        username.sendKeys(usernameValue);
        password.sendKeys(passwordValue);
        submitButton.click();
    }

    public void login(Map<String, String> user){
        login(user.get("email"), user.get("password"));
    }

    public String getLoggedUserNameText(){
        return loggedUserName.getText();
    }

}
