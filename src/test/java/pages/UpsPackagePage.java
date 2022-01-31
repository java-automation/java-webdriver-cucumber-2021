package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static support.TestContext.getDriver;

public class UpsPackagePage extends Page {
    //constructor
    public UpsPackagePage() {
        url = "https://www.ups.com/ship/guided/package?tx=24968987274335228&loc=en_US";
    }

    @FindBy(id = "nbsPackagePackageWeightField0")
    private WebElement weight;

    @FindBy(id = "nbsPackagePackagingTypeDropdown0")
    private WebElement packagingTypeSelector;

    public void setWeight(String value) {
        weight.sendKeys(value);
    }

    public void selectPackagingType(String type) {
//        new WebDriverWait(getDriver(),5).until(ExpectedConditions.visibilityOf(packagingTypeSelector));
        new Select(packagingTypeSelector).selectByVisibleText(type);
    }



}
