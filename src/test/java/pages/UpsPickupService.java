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



    @FindBy(xpath = "//p[contains(@class,'date')]")
    private List<WebElement> deliverDate;

    @FindBy(xpath = "//span[@class='icon ups-icon-calendar']")
    private WebElement calendarIcon;

    @FindBy(xpath = "//div[@class='ups-official_datepicker']")
    private WebElement datePicker;

    @FindBy(xpath = "//button[@class='ups-official_datepicker_date_chooser_btn ups-official_datepicker_today']")
    private WebElement officialDatePickerToday;

    @FindBy(xpath = "//button[@disabled]")
    private List<WebElement> disableButtonDatePicker;

    @FindBy(xpath = "//div[@class='ups-official_datepicker_table_container']//button[@type='button']")
    private List<WebElement> buttonsDatePicker;


    @FindBy(xpath = "//button[@type='button'][contains(text(),'Close')]")
    private WebElement closeButtonDatePicker;

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
        System.out.println("minPrice = " + minPrice);
        return cardList.get(priceDoubleList.indexOf(minPrice));
    }

    public WebElement getCalendarIcon() {
        return calendarIcon;
    }

    public WebElement getDatePicker() {
        return datePicker;
    }

    public WebElement getCloseButtonDatePicker() {
        return closeButtonDatePicker;
    }

    public List<WebElement> getDeliverDate() {
        return deliverDate;
    }
    public boolean doWeHaveSaturdayDelivery() {
        return deliverDate.stream().filter(el -> el.getText().contains("Saturday")).toList().size() > 0;
    }

    public List<WebElement> getAvailableDatePicker() {
        return buttonsDatePicker.stream().filter(el ->
                (!disableButtonDatePicker.contains(el))).toList();
    }


}
