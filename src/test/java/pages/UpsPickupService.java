package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    public List<WebElement> getRecommendedPrice() {
        return recommendedPrice;
    }

    public List<WebElement> getCheapestPrice() {
        return cheapestPrice;
    }

    public WebElement getTotalPrice() {
        return totalPrice;
    }
}
