package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CareersHome extends UpsBasePage {

    public CareersHome() {
        url = "https://skryabin-careers.herokuapp.com/";
    }

    @FindBy(xpath="//a[@href='/login']")
    private WebElement loginButton;

    @FindBy(xpath="//a[@href='/recruit']")
    private WebElement recruitButton;

    @FindBy(xpath="//span[@class='logout-box']/a")
    private WebElement loggedUserName;

    public void clickLogin() {
        loginButton.click();
    }

    public void clickRecruit() {
        recruitButton.click();
    }

    public String getLoggedUserNameText() {
        return loggedUserName.getText();
    }
}
