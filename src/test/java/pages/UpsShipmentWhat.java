package pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class UpsShipmentWhat extends UpsShipmentPage {

    public UpsShipmentWhat() {
        urlRegExp = ".*www.ups.com/ship/guided/package.*";
    }

    // fields
    @FindBy(xpath = "//select[contains(@name,'PackagingTypeDropdown')]")
    private WebElement packageType;

    @FindBy(xpath = "//input[contains(@name,'PackageWeightField')]")
    private WebElement packageWeight;

    @FindBy(xpath = "//input[contains(@name,'PackageWeightField')]/..//span[contains(@class,'ups-icon-check')]")
    private WebElement packageWeightCheckmark;

    // methods
    public void setPackageTypeAndWeight(String type, String weight) {
        new Select(packageType).selectByVisibleText(type);
        // can also put wait here since BUG reveals itself when fields are filled too fast
        packageWeight.sendKeys(weight);
        wait.until(ExpectedConditions.visibilityOf(packageWeightCheckmark));
        // waiting explicitTimeOut of time set in config.yml or till weight field empties out due to BUG
        try {
            wait.until(driver -> packageWeight.getAttribute("value").isEmpty());
            packageWeight.sendKeys(weight);
        } catch (TimeoutException e) {}
    }
}