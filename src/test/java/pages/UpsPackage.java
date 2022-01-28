package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UpsPackage extends Page {
    public UpsPackage() {
        String url = "https://www.ups.com/ship/guided/package";
    }

    @FindBy(id = "nbsShipmentPackagesPackage0")
    public WebElement packageSection;

    @FindBy(id = "nbsPackagePackageWeightField0")
    private WebElement weight;

    public void fillWeight(String value) {
        weight.sendKeys(value);
    }
}
