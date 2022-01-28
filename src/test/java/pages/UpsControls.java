package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class UpsControls extends Page {

    public final By CHEAPEST_PRICE_SELECT = By.xpath("//div[@id='Cheapest']//span[@class='serviceCard_header-icon ups-icon-checkcircle-solid']");

    @FindBy(id = "nbsBackForwardNavigationContinueButton")
    public WebElement continueButton;

    public void submit() {
        wait.until(ExpectedConditions.presenceOfElementLocated(CONTINUE_BUTTON_XPATH)).click();
    }
}
