package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CareersLoginPage extends Page {
    // constructor
    public CareersLoginPage() {
        url  = "https://skryabin-careers.herokuapp.com/login";
    }

    @FindBy(xpath = "//label[@for='loginUsername']/following-sibling::input")
    private WebElement username;

    @FindBy(xpath = "//label[@for='loginPassword']/following-sibling::input")
    private WebElement password;

    @FindBy(xpath = "//button[@id='loginButton']")
    public WebElement submitButton;

    public void setUsername(String sName) {
        username.sendKeys(sName);
    }

    public void setPassword(String sPassword) {
        password.sendKeys(sPassword);
    }
}
