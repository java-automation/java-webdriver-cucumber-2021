package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

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

    // methods
    public void setPackageTypeAndWeight(String type, String weight) {
        new Select(packageType).selectByVisibleText(type);
        packageWeight.sendKeys(weight);
    }
}
