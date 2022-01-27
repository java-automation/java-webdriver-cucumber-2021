package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class UpsPackage extends UpsCreateShipment {

    public UpsPackage() {
        setUrl("https://www.ups.com/ship/guided/package");
        setTitle("UPS Shipping");
    }


    @FindBy(id = "nbsPackagePackagingTypeDropdown0")
    private WebElement packageTypeSelect;

    @FindBy(id = "nbsPackagePackageWeightField0")
    private WebElement packageWeight;


    public void selectPackagingType(String type) {
        new Select(packageTypeSelect).selectByVisibleText(type);
        waitForLocalStorageUpdate();
        waitForOptionsAvailabilityRequest();
    }

    public void fillPackageWeight(int weight) {
        packageWeight.sendKeys(String.valueOf(weight));
        waitForLocalStorageUpdate();
        waitForRateShipmentRequest();
    }
}
