package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UpsHome extends UpsPage{

    public UpsHome(){
        url = "https://www.ups.com/us/en/Home.page";

    }

    @FindBy(xpath = "//button[@class='close_btn_thick']")
    private WebElement closePrivacyNoticeButton;

    @FindBy(xpath = "//a[@id='tabs_0_tab_1']/span[@class='job-text']")
    private WebElement shipMenuButton;


    public void closePrivacyNotice(){
    closePrivacyNoticeButton.click();
    }

    public void



}
