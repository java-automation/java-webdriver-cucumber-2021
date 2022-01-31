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
        //to clear PERFORMANCE buffer, then we check for latest response after selecting an option
        //getLogs(LogType.PERFORMANCE);
        new Select(packageTypeSelect).selectByVisibleText(type);
        waitForOptionsAvailabilityResponse();
    }

    public void fillPackageWeight(String weight) {
        //we assume buffer was cleared at the time of package selection, if not - need to request the latest logs only
        packageWeight.sendKeys(weight);
        waitForRateShipmentResponse();
    }
}
