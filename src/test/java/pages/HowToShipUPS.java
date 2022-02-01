package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static support.TestContext.getDriver;

public class HowToShipUPS extends UpsControls{

    public HowToShipUPS() {

        //PageFactory.initElements(getDriver(), this);
    }

//    @FindBy(xpath = "//span/p[@id='nbsServiceTileTotalCharge0_0_0']")
//    private WebElement nextDayAirEarly;
//
//    @FindBy(xpath = "//span/p[@id='nbsServiceTileTotalCharge0_0_1']")
//    private WebElement nextDayAir;
//
//    @FindBy(xpath = "//span/p[@id='nbsServiceTileTotalCharge0_0_2']")
//    private WebElement nextDayAirSaver;
//
//    @FindBy(xpath = "//span/p[@id='nbsServiceTileTotalCharge0_1_0']")
//    private WebElement upsSecondDayAirAM;   //span/p[@id='nbsServiceTileTotalCharge0_1_1']
//
//    @FindBy(xpath = "//span[@class='serviceCard_wrapper serviceCard_titleless']")
//    private WebElement upsSecondDayAir;
//
//    @FindBy(xpath = "//div[@class='ups-accordion_expand'] ")  //div/fieldset[@id='nbsServiceGridControl']
//    private WebElement shippingPriceResult;

    @FindBy(xpath = "//*[contains(@class,'upsell-service-tiles')]//*[contains(@id,'nbsServiceTileTotalCharge')]")
    List<WebElement> priceElements;

    private WebElement getElementByPrice(String price) {
        return getDriver().findElement(By.xpath("//*[contains(@class,'upsell-service-tiles')]//*[contains(@id,'nbsServiceTileTotalCharge')][contains(text(),'" + price + "')]/ancestor::label"));
    }

    public void selectCheapestOption() throws InterruptedException {
        double cheapestPrice = Double.MAX_VALUE;
        for (WebElement singleElement : priceElements) {
            double elementPrice = Double.parseDouble(singleElement.getText().replace("$", ""));
            System.out.println(elementPrice);
            if (elementPrice < cheapestPrice) {
                cheapestPrice = elementPrice;
            }
        }
        System.out.println("Cheapest price: " + cheapestPrice);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement cheapestPriceElement = getElementByPrice(String.valueOf(cheapestPrice));
        clickWithJS(cheapestPriceElement);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.sleep(1000);
        }
    }
}

