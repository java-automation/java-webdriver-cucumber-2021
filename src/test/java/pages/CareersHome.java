package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CareersHome extends Page {

    public CareersHome() {
        setUrl("https://skryabin-careers.herokuapp.com");
        setTitle("Careers Portal");
    }

    @FindBy(xpath = "//div[@class='navbar-buttons']//a[@href='/login']/button")
    private WebElement loginButton;

    @FindBy(xpath = "//span[@class='logout-box']//button")
    private List<WebElement> logoutButton;

    @FindBy(xpath = "//span[@class='logout-box']/a")
    private WebElement profileLink;

    @FindBy(xpath = "//div[@class='navbar-buttons']//a[@href='/recruit']/button")
    private List<WebElement> recruitButton;


    public void openLoginPage() {
        loginButton.click();
    }

    public boolean isLogOutButtonPresent() {
        return logoutButton.stream().findFirst().isPresent();
    }

    public String getProfileName() {
        return profileLink.getText();
    }

    public boolean isRecruitButtonPresent() {
        return recruitButton.stream().findFirst().isPresent();
    }

    public void openRecruitPage() {
        recruitButton.get(0).click();
    }
}
