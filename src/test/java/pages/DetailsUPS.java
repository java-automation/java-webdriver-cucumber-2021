package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DetailsUPS extends UpsControls{

    public DetailsUPS(){

    }
    @FindBy(xpath = "//input[@id='nbsShipmentDescription']")
    private WebElement descriptionOfShipment;

    @FindBy(xpath = "//input[@id='nbsDirectDeliveryOnlyOptionBaseOptionSwitch']")
    private WebElement deliveryCheckBox;

    @FindBy(xpath = "//span[@id='total-charges-spinner']")
    private WebElement totalCharge;



    public void fillDescriptionOfShipment(){
        descriptionOfShipment.sendKeys();
    }

    public void clickCheckBox(){
        deliveryCheckBox.click();
    }

    public void checkTotalCharge(){
        double updatedPrice;



        totalCharge.click();
    }
}
