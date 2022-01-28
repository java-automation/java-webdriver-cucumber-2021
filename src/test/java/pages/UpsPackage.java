package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Locale;

public class UpsPackage extends Page {
    public UpsPackage() {
        String url = "https://www.ups.com/ship/guided/package";
    }

    @FindBy(id = "nbsShipmentPackagesPackage0")
    public WebElement packageSection;

    @FindBy(id = "nbsPackagePackageWeightField0")
    private WebElement weight;

    @FindBy(xpath = "//select[@id='nbsPackagePackagingTypeDropdown0']")
    private WebElement typeDropDown;

    @FindBy(xpath = "//select[@id='nbsPackagePackagingTypeDropdown0']/option")
    private List<WebElement> typeDropDownOptionsList;

    public void fillWeight(String value) {
        weight.sendKeys(value);
    }

    public void selectType(String value) {
        String chooseType = typeDropDownOptionsList.stream().filter(el -> el.getText().toLowerCase(Locale.ROOT).contains(value.toLowerCase(Locale.ROOT))).toList().get(0).getText();
        new Select(typeDropDown).selectByVisibleText(chooseType);
    }

}
