package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UpsHome extends Page{

    public UpsHome(){
        url = "https://www.ups.com/us/en/Home.page";

    }

    @FindBy(xpath = "//button[@class='close_btn_thick']")
    private WebElement closeBanner;

    @FindBy(css = ".nav-link.widget-link-ship")
    private WebElement shipMenuButton;


    public void closeBanner(){
    closeBanner.click();
    }

    public void openShipment(){
        shipMenuButton.click();
    }



}
