package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class UpsPickupService extends Page {
    public UpsPickupService() {
        url = "https://www.ups.com/ship/guided/pickup-service";
    }

    @FindBy(xpath = "//div[@id='Recommended']//span[@class='serviceCard_header-icon ups-icon-checkcircle-solid']")
    private List<WebElement> recommendedPrice;

    @FindBy(xpath = "//div[@id='Cheapest']//span[@class='serviceCard_wrapper']")
    private List<WebElement> cheapestPrice;

    @FindBy(css = "#nbsBalanceBarTotalCharges #total-charges-spinner")
    private WebElement totalPrice;

    @FindBy(xpath = "//div[@class='ups-wrap_inner']//span/p[contains(@class,'price')]")
    private List<WebElement> priceList;

    @FindBy(xpath = "//div[@class='ups-wrap_inner']//span/p[contains(@class,'price')]/ancestor::label")
    private List<WebElement> cardList;


    public List<WebElement> getRecommendedPrice() {
        return recommendedPrice;
    }

    public List<WebElement> getCheapestPrice() {
        return cheapestPrice;
    }

    public WebElement getTotalPrice() {
        return totalPrice;
    }

    public WebElement getMinPrice() {
        ArrayList<Double> priceDoubleList = new ArrayList<>();
        priceList
                .forEach(el -> priceDoubleList.add(Double.parseDouble(el.getText().replace("$", ""))));
        Double minPrice = priceDoubleList.stream().min(Double::compare).orElseThrow();
        System.out.println("priceDoubleList.indexOf(minPrice) = " + priceDoubleList.indexOf(minPrice));
        return cardList.get(priceDoubleList.indexOf(minPrice));
    }
}
