package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class QuoteResults extends QuoteForm {

    private final String resultsFrame = "//*[@id='quotePageResult']";

    @FindBy(xpath = resultsFrame + "//*[@name='username']")
    private WebElement username;

    @FindBy(xpath = resultsFrame + "//*[@name='email']")
    private WebElement email;

    @FindBy(xpath = resultsFrame + "//*[@name='password']")
    private WebElement password;

    @FindBy(xpath = resultsFrame + "//*[@name='name']")
    private WebElement name;

    @FindBy(xpath = resultsFrame + "//*[@name='firstName']")
    private WebElement firstName;

    @FindBy(xpath = resultsFrame + "//*[@name='middleName']")
    private WebElement middleName;

    @FindBy(xpath = resultsFrame + "//*[@name='lastName']")
    private WebElement lastName;

    @FindBy(xpath = resultsFrame + "//*[@name='agreedToPrivacyPolicy']")
    private WebElement privacyPolicy;

    @FindBy(xpath = resultsFrame + "//button[@id='return']")
    private WebElement returnButton;

    public String getUsername() {
        return username.getText();
    }

    public String getEmail() {
        return email.getText();
    }

    public String getPassword() {
        return password.getText();
    }

    public String getName() {
        return name.getText();
    }

    public String getFirstName() {
        return firstName.getText();
    }

    public String getMiddleName() {
        return middleName.getText();
    }

    public String getLastName() {
        return lastName.getText();
    }

    public String getPrivacyPolicy() {
        return privacyPolicy.getText();
    }

    public void returnToQuoteForm() {
        returnButton.click();
    }
}
