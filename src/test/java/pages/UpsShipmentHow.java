package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Comparator;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static support.TestContext.getDriver;

public class UpsShipmentHow extends UpsShipmentPage {

    public UpsShipmentHow() {
        urlRegExp = ".*www.ups.com/ship/guided/pickup-service.*";
    }

    // fields
    @FindBy(xpath = "//div[@class='ups-accordion_list']//p[contains(@class,'serviceCard_footer-price')]")
    private List<WebElement> allServices;

    @FindBy(xpath = "//input[contains(@name,'DropOffDatePicker')]") // Tip: clear several time before sendKeys
    private WebElement datePicker;

    // top three shipping service options
    @FindBy(xpath = "//*[contains(@class,'upsell-service-tiles')]//*[contains(@id,'nbsServiceTileTotalCharge')]")
    List<WebElement> priceElements;

    // top three shipping service options - cards (labels) by price
    private WebElement getElementByPrice(String price) {
        return getDriver().findElement(By.xpath("//*[contains(@class,'upsell-service-tiles')]" +
                "//*[contains(@id,'nbsServiceTileTotalCharge')][contains(text(),'" + price + "')]/ancestor::label"));
    }

    // methods
    public void selectCheapestOption() {
        wait.until(driver -> urlMatches());
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        WebElement minPriceElem = allServices.stream().min(Comparator.comparingDouble(elem -> {
            try { return formatter.parse(elem.getText()).doubleValue();
            } catch (ParseException e) {
                throw new Error(e);
            }})).orElseThrow();
        ((JavascriptExecutor)getDriver()).executeScript("arguments[0].scrollIntoView({" +
                                                 "behavior: 'auto',block: 'center',inline: 'center'});", minPriceElem);
        String minPrice = minPriceElem.getText();
        minPriceElem.click();
        assertThat(minPrice).isEqualTo(getTotalCharges());
    }

    // lesson 17 (01/27/2022) implementation
//    public void selectCheapestOption() {
//        double cheapestPrice = Double.MAX_VALUE;
//        for (WebElement singleElement : priceElements) {
//            double elementPrice = Double.parseDouble(singleElement.getText().replace("$", ""));
//            System.out.println(elementPrice);
//            if (elementPrice < cheapestPrice) {
//                cheapestPrice = elementPrice;
//            }
//        }
//        System.out.println("Cheapest price: " + cheapestPrice);
//
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        WebElement cheapestPriceElement = getElementByPrice(String.valueOf(cheapestPrice));
//        clickWithJS(cheapestPriceElement);
//
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
}
