package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static support.TestContext.getDriver;

public class UpsHomePage {

    public UpsHomePage() {
        PageFactory.initElements(getDriver(),this);
        closeCookiesDialogIfDisplayed();
    }

    @FindBy(xpath = "//div[@class='implicit_privacy_prompt implicit_consent']//button[contains(@class,'close')]")
    private List<WebElement> websiteUsesCookiesDialogCloseButton;

    @FindBy(xpath="//ul[contains(@class,'jobs-list')]//span[text()='Ship']")
    private WebElement ship;

    public void closeCookiesDialogIfDisplayed() {
        websiteUsesCookiesDialogCloseButton.stream()
                                           .findFirst()
                                           .filter(WebElement::isDisplayed)
                                           .ifPresent(WebElement::click);
    }

    public void gotoCreateShipmentPage() {
        ship.click();
    }

}
