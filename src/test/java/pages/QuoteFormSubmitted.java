package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static support.TestContext.getDriver;

public class QuoteFormSubmitted {

    // constructor
    public QuoteFormSubmitted() {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(name = "name")
    private WebElement name;

    @FindBy(name = "username")
    private WebElement username;

    @FindBy(name = "email")
    private WebElement email;

    @FindBy(name = "agreedToPrivacyPolicy")
    private WebElement agreedToPrivacyPolicy;

    @FindBy(name = "password")
    private WebElement password;

    public String getName() {
        return name.getText();
    }

    public String getUserName() {
        return username.getText();
    }

    public String getEmail() {
        return email.getText();
    }

    public String getAgreedToPrivacyPolicy() {
        return agreedToPrivacyPolicy.getText().toLowerCase();
    }

    public String getPassword() {
        return password.getText();
    }
}
