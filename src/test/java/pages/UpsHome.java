package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UpsHome extends Page {

    public UpsHome() {
        url = "https://www.ups.com/us/en/Home.page";
    }

    @FindBy(css = ".widget-link-ship.nav-link")
    private WebElement ship;

    @FindBy(css = ".close_btn_thick")
    private WebElement closeBanner;

    public void openShipment() {
        ship.click();
    }

    public void closeBanner() {
        if (closeBanner.isDisplayed()) {
            closeBanner.click();
        }
    }

}
