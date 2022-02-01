package pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class UpsOptions extends Page {

    public UpsOptions() {
        url = "https://www.ups.com/ship/guided/options";
    }

    @FindBy(xpath = "//section/h2")
    private WebElement sectionHeader;

    @FindBy(xpath = "//label[@for='nbsSaturdayDeliveryOptionBaseOptionSwitch']")
    private WebElement saturdayDelivery;

    @FindBy(xpath = "//strong[@class='ups-form_label ups-lever_label ups-cn_label']")
    private List<WebElement> checkBoxes;

    @FindBy(xpath = "//input[@id='nbsShipmentDescription']")
    private WebElement description;

    @FindBy(xpath = "//div[@class='ups-lever_rlabel ng-star-inserted']")
    private List<WebElement> checkBoxSelected;

    @FindBy(xpath = "//saturday-delivery-option//div[@class='ups-lever_rlabel ng-star-inserted']")
    private WebElement saturdaySelected;

    @FindBy(xpath = "//direct-delivery-only-option//div[@class='ups-lever_rlabel ng-star-inserted']")
    private WebElement directDeliverySelected;

    public WebElement getSectionHeader() {
        return sectionHeader;
    }

    public WebElement getSaturdayDelivery() {
        return saturdayDelivery;
    }

    public WebElement getSaturdaySelected() {
        return saturdaySelected;
    }

    public WebElement getDirectDeliverySelected() {
        return directDeliverySelected;
    }

    public WebElement getCheckBox(String text) {
        return checkBoxes.stream().filter(el -> el.getText().contains(text)).toList().get(0);
    }

    public List<WebElement> getCheckBoxSelected() {
        return checkBoxSelected;
    }

    public void fillDescriptions(String value) {
        description.sendKeys(value);
        Assert.assertEquals(description.getAttribute("value"), value);
    }

}
