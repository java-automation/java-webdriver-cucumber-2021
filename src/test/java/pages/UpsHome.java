package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UpsHome extends Page {

    public UpsHome() {
        setUrl("https://www.ups.com/us/en/Home.page");
        setTitle("Global Shipping & Logistics Services | UPS - United States");
    }

    @FindBy(css = ".nav.jobs-list .widget-link-ship")
    private WebElement shipMenuButton;

    @FindBy(css = ".implicit_privacy_prompt button")
    private WebElement privacyPromptCloseButton;

    public void createShipment() {
        shipMenuButton.click();
    }

    public void closePrivacyPrompt() {
        privacyPromptCloseButton.click();
    }
}
