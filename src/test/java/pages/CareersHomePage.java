package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CareersHomePage extends Page {
    // constructor
    public CareersHomePage() {
        url  = "https://skryabin-careers.herokuapp.com";
    }

    @FindBy(xpath = "//a[contains(@href,'login')]/button")
    public WebElement loginButton;

    @FindBy(xpath = "//button[normalize-space()='Logout']")
    public WebElement logoutButton;

    @FindBy(xpath = "//button[normalize-space()='Logout']/preceding::a")
    private WebElement loginName;

    @FindBy(xpath = "//button[normalize-space()='Recruit']")
    public WebElement recruitButton;

    public String getLoginName() {
        return loginName.getText();
    }
}
