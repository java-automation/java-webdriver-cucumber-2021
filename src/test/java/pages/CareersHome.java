package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CareersHome extends Page {

    public CareersHome(){
    }

    @FindBy(xpath = "//a[@href='/login']")
    private WebElement loginButton;

    @FindBy(xpath = "//span[@class='logout-box']/a")
    private WebElement loggedUserName;

    @FindBy(xpath="//a[@href='/recruit']")
    private WebElement recruitButton;


    public void clickRecruit() {
        recruitButton.click();
    }
    public void clickLogin(){
        loginButton.click();
    }

    public String getLoggedUserNameText(){
        return loggedUserName.getText();
    }
}
