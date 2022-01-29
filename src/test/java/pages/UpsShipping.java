package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class UpsShipping extends UpsControls {

    @FindBy(id = "nbsPackagePackagingTypeDropdown0")
    WebElement packageType;

    @FindBy(id = "nbsPackagePackageWeightField0")
    WebElement packageWeight;

    public void selectPackageType(String text) {
        new Select(packageType).selectByVisibleText(text);
    }

    public void fillPackageWeight(String value) {
        packageWeight.sendKeys(value);
    }

}