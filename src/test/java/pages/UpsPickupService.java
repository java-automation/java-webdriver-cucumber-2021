package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static support.TestContext.getConfig;
import static support.TestContext.getDriver;

public class UpsPickupService extends UpsControls {

    @FindBy(xpath = "//*[contains(@class,'upsell-service-tiles')]//*[contains(@id,'nbsServiceTileTotalCharge')]")
    List<WebElement> priceElements;

    private WebElement getElementByPrice(String price) {
        return getDriver().findElement(By.xpath("//*[contains(@class,'upsell-service-tiles')]//*[contains(@id,'nbsServiceTileTotalCharge')][contains(text(),'" + price + "')]/ancestor::label"));
    }

    public void selectCheapestOption() {
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
        }
    }


}