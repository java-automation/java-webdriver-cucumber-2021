package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CareersLogin extends CareersHome {

    public CareersLogin() {
        setUrl("https://skryabin-careers.herokuapp.com/login");
        setTitle("Careers Portal");
    }

    @FindBy(xpath = "//label[@for='loginUsername']/../input")
    private WebElement usernameInput;

    @FindBy(xpath = "//label[@for='loginPassword']/../input")
    private WebElement passwordInput;

    @FindBy(id = "loginButton")
    private WebElement submitButton;


    public void fillUsername(String username) {
        usernameInput.sendKeys(username);
    }

    public void fillPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void submitCredentials() {
        submitButton.click();
    }
}
