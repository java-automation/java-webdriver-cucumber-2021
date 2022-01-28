package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.stream.IntStream;

public class UpsShipmentPackageKindSection extends UpsBasePage {

    public UpsShipmentPackageKindSection() {
        urlRegExp = ".*www.ups.com/ship/guided/package.*";
    }

    // fields
    @FindBy(xpath = "//shipment-packages")
    private WebElement packageKindFormWrapper;

    @FindBy(xpath = "//select[contains(@name,'PackagingTypeDropdown')]")
    private WebElement packageType;

    @FindBy(xpath = "//input[contains(@name,'PackageWeightField')]")
    private WebElement packageWeight;

    @FindBy(xpath = "//input[contains(@name,'PackageWeightField')]/..//span[contains(@class,'ups-icon-check')]")
    private WebElement packageWeightCheckmark;

    // methods
    public void setPackageTypeAndWeight(String type, String weight) {
        new Select(packageType).selectByVisibleText(type);
        int i=0;
        do {
            i++;
            packageWeight.sendKeys(weight);
            wait.until(ExpectedConditions.visibilityOf(packageWeightCheckmark));
        } while (packageWeight.getAttribute("value").equals("") || i>2);
    }
}
