package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static support.TestContext.getDriver;

public class UpsDetailsPage extends Page {
    //constructor
    public UpsDetailsPage() {
        url = "https://www.ups.com/ship/guided/options?tx=24968987274335228&loc=en_US";
    }

    @FindBy(id = "nbsShipmentDescription")
    private WebElement descriptionField;

    @FindBy(xpath = "//div/strong[contains(text(), 'Saturday Delivery')]/../..")
    private WebElement saturdayDelivery;

    @FindBy(xpath = "//label[@for='nbsDirectDeliveryOnlyOptionBaseOptionSwitch']")
    private WebElement onlyToReceiverAddress;

    @FindBy(id = "nbsBalanceBarTotalCharges")
    private WebElement totalCharges;

    public void fillDescription(String value) {
        new WebDriverWait(getDriver(), 3).until(ExpectedConditions.visibilityOf(descriptionField));
        descriptionField.sendKeys(value);
    }

    public void checkSaturdayDelivery() {
        JavascriptExecutor executor = (JavascriptExecutor)getDriver();
        executor.executeScript("arguments[0].click();", saturdayDelivery);
    }

    public void checkDeliverOnlyToReceiverAddress() {
        JavascriptExecutor executor = (JavascriptExecutor)getDriver();
        executor.executeScript("arguments[0].click();", onlyToReceiverAddress);
    }

    public String getTotalCharges() {
        return totalCharges.getText();
    }

}
