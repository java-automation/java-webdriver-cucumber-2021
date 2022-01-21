package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static support.TestContext.getDriver;

public class UpsHomePage {

    public UpsHomePage() {
        PageFactory.initElements(getDriver(),this);
    }

    @FindBy(xpath="//ul[contains(@class,'jobs-list')]//span[text()='Ship']")
    private WebElement ship;

    public void gotoCreateShipmentPage() {
        ship.click();
    }

}
