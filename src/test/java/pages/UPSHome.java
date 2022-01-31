package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UPSHome extends Page {
    //constructor
    public UPSHome() {
        url = "https://www.ups.com/us/en/Home.page";
    }

    //@FindBy(xpath = "//a[@id='tabs_0_tab_2']/span")
    @FindBy(css = ".widget-link-ship.nav-link")
    private WebElement ship;

    @FindBy(xpath = "//div[@role='alert']")
    private WebElement cookieWindow;

    @FindBy(xpath = "//div[@role='alert']/button/span")
    private WebElement cookieWindowCloser;


    public void closeCookieWindow() {
        if (cookieWindow.isDisplayed()) {
            cookieWindowCloser.click();
        }
    }

    public void openShipment() {
        ship.click();
    }



}
