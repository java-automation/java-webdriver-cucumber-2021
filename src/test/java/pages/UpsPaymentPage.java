package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static support.TestContext.getDriver;

public class UpsPaymentPage extends Page {
    //constructor
    public UpsPaymentPage() {
        url = "https://www.ups.com/ship/guided/payment?tx=24968987274335228&loc=en_US";
    }

    @FindBy(xpath="//label/span[contains(text(), 'PayPal')]")
    private WebElement payPal;

    @FindBy(id = "nbsBackForwardNavigationReviewPrimaryButton")
    private WebElement reviewButton;

    public void selectPayPal() {
        new WebDriverWait(getDriver(), 5).until(ExpectedConditions.visibilityOf(payPal));
        payPal.click();
    }

    public void submitReviewButton() {
        JavascriptExecutor executor = (JavascriptExecutor)getDriver();
        executor.executeScript("arguments[0].click();", reviewButton);
    }
}
