package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UpsHomePage extends UpsBasePage {

    public UpsHomePage() {
        url = "https://www.ups.com/us/en/Home.page";
        urlRegExp = ".*www.ups.com/us/en/Home.page";
        closeCookiesDialogIfDisplayed();
    }

    // fields
    @FindBy(xpath="//ul[contains(@class,'jobs-list')]//span[text()='Ship']")
    private WebElement ship;

    // methods
    public void gotoCreateShipmentPage() {
        ship.click();
    }

}
