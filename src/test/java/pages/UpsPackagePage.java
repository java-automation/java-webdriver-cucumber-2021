package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static support.TestContext.getDriver;

public class UpsPackagePage extends Page {
    // constructor
    public UpsPackagePage() {
        url = "https://www.ups.com/ship/guided/package";
        title = "Package";
    }

    static final String typeXPath = "//select[@id='nbsPackagePackagingTypeDropdown0']";
    @FindBy(xpath = typeXPath)
    private WebElement packagingType;

    @FindBy(xpath = "//input[@id='nbsPackagePackageWeightField0']")
    private WebElement weight;

    By declaredValue = By.xpath("//input[@id='nbsPackageDeclaredValueField0']");

    @FindBy(xpath = "//p[@class='ng-star-inserted']")
    private WebElement descriptionBlock;

    @FindBy(xpath = "//span[@id='nbsBalanceBarTotalCharges']")
    private WebElement totalCharges;

    @FindBy(xpath = "//span[@id='total-charges-spinner']")
    private WebElement totalChargesValue;

    @FindBy(xpath = "(//div[@id='Cheapest'])[1]")
    private WebElement cheapestDelivery;

    @FindBy(xpath = "(//div[@id='Cheapest'])[1]//span[contains(@class,'ups-icon-checkcircle')]")
    private WebElement cheapestDeliverySelected;

    @FindBy(xpath = "//input[@id='nbsShipmentDescription']")
    private WebElement description;

    @FindBy(xpath = "//label[@for='nbsDirectDeliveryOnlyOptionBaseOptionSwitch']")
    private WebElement deliverOnlyToReceiver;

    @FindBy(xpath = "//span[contains(normalize-space(),'PayPal')]")
    private WebElement paypalPayment;

    @FindBy(xpath = "//img[contains(@src,'ajax-loader-transparent.gif')]")
    public WebElement totalChargesSpinner;

    @FindBy(xpath = "//div[@id='nbsSinglePageContainer']")
    private WebElement finalResults;

    //----------------------------------------------------------------------
    public void setPackagingType(String sType) {
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.xpath(typeXPath)));
        packagingType.click();
        By type = By.xpath(typeXPath + "/option[normalize-space()='" + sType + "']");
        new WebDriverWait(getDriver(), 5).until(ExpectedConditions.elementToBeClickable(type));
        getDriver().findElement(type).click();
    }

    public void setWeight(String sWeight) {
        weight.click();
        weight.sendKeys(sWeight + Keys.TAB);
    }

    public String getWeightValue() {
        return weight.getAttribute("value");
    }

    public String getPackagingTypeText() {
        return packagingType.getText();
    }

    public WebElement getPackagingType() {
        return packagingType;
    }

    public WebElement getDeclaredValue() {
        return getDriver().findElement(declaredValue);
    }

    public WebElement getDescriptionBlock() {
        return descriptionBlock;
    }

    public WebElement getTotalCharges() {
        return totalCharges;
    }

    public WebElement getWeight() {
        return weight;
    }

    public WebElement getCheapestDelivery() {
        return cheapestDelivery;
    }

    public WebElement getCheapestDeliverySelected() {
        return cheapestDeliverySelected;
    }

    public void setDescription(String sText) {
        description.sendKeys(sText + Keys.TAB);
    }

    public WebElement getDescription() {
        return description;
    }

    public void setDeliverOnlyToReciever() {
        new WebDriverWait(getDriver(), 5).until(ExpectedConditions.elementToBeClickable(deliverOnlyToReceiver));
        deliverOnlyToReceiver.click();
    }

    public WebElement getTotalChargesValue() {
        return totalChargesValue;
    }

    public WebElement getPaypalPayment() {
        return paypalPayment;
    }

    public WebElement getFinalResults() {
        return finalResults;
    }
}
