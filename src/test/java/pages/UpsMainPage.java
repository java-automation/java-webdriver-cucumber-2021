package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UpsMainPage extends Page {

    // constructor
    public UpsMainPage() {
        url  = "https://www.ups.com/us/en/Home.page";
        title = "Global Shipping & Logistics Services | UPS - United States";
    }

    @FindBy(xpath = "//ul[@role='menubar']//a[normalize-space()='Shipping']")
    public WebElement menubarShipping;
    @FindBy(xpath = "//ul[@role='presentation']//a[normalize-space()='Create a Shipment']")
    public WebElement submenuCreateAShipment;
}
