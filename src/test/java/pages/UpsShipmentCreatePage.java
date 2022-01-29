package pages;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static support.TestContext.getDriver;

public class UpsShipmentCreatePage extends UpsBasePage {

    public UpsShipmentCreatePage() {
        closeCookiesDialogIfDisplayed();
    }

    // fields
    @FindBy(id = "nbsBackForwardNavigationContinueButton")
    private WebElement continueButton;

    @FindBy(id = "nbsBackForwardNavigationCancelShipmentButton")
    private WebElement cancelShipmentButton;

    @FindBy(xpath = "//page-validation-errors")
    private WebElement errorsSection;

    // methods
    public void submitShipmentForm() {
        try {
            continueButton.click();
        } catch (ElementClickInterceptedException e) {
            ((JavascriptExecutor)getDriver()).executeScript("arguments[0].scrollIntoView({" +
                    "behavior: 'auto',block: 'center',inline: 'center'});", continueButton);
            continueButton.click();
        }
    }
}
