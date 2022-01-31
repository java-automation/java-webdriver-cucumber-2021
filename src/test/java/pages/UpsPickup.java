package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class UpsPickup extends UpsCreateShipment {

    public UpsPickup() {
        setUrl("https://www.ups.com/ship/guided/pickup-service");
        setTitle("UPS Shipping");
    }

    private final String upsellTileLabelLocator = ".upsell-service-tiles label";

    @FindBy(css = upsellTileLabelLocator)
    private List<WebElement> upsellTileLabels;

    @FindBy(css = upsellTileLabelLocator + " p.serviceCard_footer-price")
    private List<WebElement> upsellTilePrices;


    public String getCheapestOptionText() {
        return upsellTileLabels.get(getCheapestTileIndex()).getText();
    }

    public void selectCheapestOption() {
        waitForSpinnerToBeInvisible();
        WebElement cheapestOption = upsellTilePrices.get(getCheapestTileIndex());
        //scrolling since prices are on the bottom and user may want to see them before clicking
        scrollToElementWithOffset(cheapestOption, 100);
        cheapestOption.click();
        waitForSpinnerToBeInvisible();
    }

    private int getCheapestTileIndex() {
        int minIndex = 0;
        double minValue = Double.parseDouble(upsellTilePrices.get(minIndex).getText().substring(1));
        double value;
        for (int i = 1; i < upsellTilePrices.size(); i++) {
            value = Double.parseDouble(upsellTilePrices.get(i).getText().substring(1));
            if (value < minValue) minIndex = i;
        }
        return minIndex;
    }
}
