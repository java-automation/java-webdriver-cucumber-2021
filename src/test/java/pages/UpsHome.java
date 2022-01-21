package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UpsHome extends UpsPage {

    public UpsHome() {
        setUrl("https://www.ups.com/us/en/Home.page");
        setTitle("Global Shipping & Logistics Services | UPS - United States");
    }

    @FindBy(css = ".nav.jobs-list .widget-link-ship")
    private WebElement shipMenuButton;

    public void createShipment() {
        shipMenuButton.click();
    }
}
