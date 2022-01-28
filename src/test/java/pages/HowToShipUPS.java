package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static support.TestContext.getDriver;

public class HowToShipUPS {

    public HowToShipUPS() {

        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(xpath = "//span/p[@id='nbsServiceTileTotalCharge0_0_0']")
    private WebElement nextDayAirEarly;

    @FindBy(xpath = "//span/p[@id='nbsServiceTileTotalCharge0_0_1']")
    private WebElement nextDayAir;

    @FindBy(xpath = "//span/p[@id='nbsServiceTileTotalCharge0_0_2']")
    private WebElement nextDayAirSaver;

    @FindBy(xpath = "//span/p[@id='nbsServiceTileTotalCharge0_1_0']")
    private WebElement upsSecondDayAirAM;   //span/p[@id='nbsServiceTileTotalCharge0_1_1']

    @FindBy(xpath = "//span[@class='serviceCard_wrapper serviceCard_titleless']")
    private WebElement upsSecondDayAir;

    @FindBy(xpath = "//div[@class='ups-accordion_expand'] ")  //div/fieldset[@id='nbsServiceGridControl']
    private WebElement shippingPriceResult;


    public String getPriceResult() {
        return shippingPriceResult.getText();
    }

    public void cheapestOption() {
        upsSecondDayAir.click();


    }
}

