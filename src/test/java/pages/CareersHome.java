package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CareersHome extends Page {
    public CareersHome() {
        url = "https://skryabin-careers.herokuapp.com/";
    }

    @FindBy(xpath = "//a[@href='/login']")
    private WebElement loginButton;
    @FindBy(xpath = "//span[@class='logout-box']/a")
    private WebElement loggedUserName;
    @FindBy(xpath = "//a[@href='/recruit']")
    private WebElement recruitButton;

    public void clickLogin() {
        loginButton.click();
    }

    public String getLoggedUserName() {
        return loggedUserName.getText();
    }

    public void clickRecruit() {
        recruitButton.click();
    }
}
