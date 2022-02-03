package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Map;

public class CareersLogin extends UpsBasePage {


    @FindBy(xpath="//label[@for='loginUsername']/../input")
    private WebElement username;

    @FindBy(xpath="//label[@for='loginPassword']/../input")
    private WebElement password;

    @FindBy(id="loginButton")
    private WebElement submit;

    public void login(String usernameValue, String passwordValue) {
        username.sendKeys(usernameValue);
        password.sendKeys(passwordValue);
        submit.click();
    }

    public void login(Map<String, String> user) {
        login(user.get("email"), user.get("password"));
    }

}
