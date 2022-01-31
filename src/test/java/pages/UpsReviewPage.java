package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static support.TestContext.getDriver;

public class UpsReviewPage extends Page{
    //constructor
    public UpsReviewPage() {
        url = "https://www.ups.com/ship/single-page?tx=33768945850377068&loc=en_US";
    }

    @FindBy(id = "origin_showSummaryAddress")
    private WebElement shipFromBlock;

    @FindBy(id = "destination_showSummaryAddress")
    private WebElement shipToBlock;

    @FindBy(id = "nbsBackForwardNavigationCancelShipmentButton")
    private WebElement cancelButton;

    @FindBy(id = "nbsCancelShipmentWarningYes")
    private WebElement yesButton;

    public String getShipFromText() {
        new WebDriverWait(getDriver(), 5).until(ExpectedConditions.visibilityOf(shipFromBlock));
        return shipFromBlock.getText();
    }

    public String getShipToText() {
        return shipToBlock.getText();
    }

    public void cancelShipmentForm() {
        JavascriptExecutor executor = (JavascriptExecutor)getDriver();
        executor.executeScript("arguments[0].click();", cancelButton);
        yesButton.click();
    }


}
