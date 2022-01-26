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
        getWait().until(log -> getLogs(LogType.PERFORMANCE)
                .getAll()
                .stream()
                .filter(entry -> entry.getMessage().contains("https://www.ups.com/ship/api/LookupAndValidation/GetOptionsAvailability"))
                .filter(entry -> entry.getMessage().contains("application/json"))
                //.filter(entry -> entry.getMessage().contains("\"status\": 200"))
                .toList().size() > 0);
    }

    public void fillPackageWeight(int weight) {
        packageWeight.sendKeys(String.valueOf(weight));
        waitForLocalStorageUpdate();
        getWait().until(log -> getLogs(LogType.PERFORMANCE)
                .getAll()
                .stream()
                .filter(entry -> entry.getMessage().contains("https://www.ups.com/ship/api/RatingAndProcessing/RateShipmentForAllServices"))
                .filter(entry -> entry.getMessage().contains("application/json"))
                //.filter(entry -> entry.getMessage().contains("\"status\": 200"))
                .toList().size() > 0);
    }
}
