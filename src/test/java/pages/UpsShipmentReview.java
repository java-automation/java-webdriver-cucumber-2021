package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class UpsShipmentReview extends UpsShipmentPage {

    public UpsShipmentReview() {
        urlRegExp = ".*www.ups.com/ship/single-page.*";
    }

    // Ship From
    @FindBy(id = "origin_showSummaryAddress")
    private WebElement origin;

    // Ship To
    @FindBy(id = "destination_showSummaryAddress")
    private WebElement destination;

    // Package Information
    @FindBy(xpath = "//package-review")
    private WebElement packageReview;

    // Shipping service
    @FindBy(xpath = "//shipment-services//span[contains(@class,'confirm')]/..")
    private WebElement dropOffOrPickup;

    @FindBy(id = "nbsServiceReviewDeliveryDay")
    private WebElement deliveryDay;

    // Additional Options
    @FindBy(xpath = "//shipment-options//p")
    private List<WebElement> descriptionOfGoods;

    @FindBy(id = "optionReviewdirectDeliveryShip")
    private WebElement directDeliveryOption;

    // Payment
    @FindBy(xpath = "//span[contains(@id,'PaymentSummaryBillPayPalSummary')]")
    private WebElement payPalPaymentMethod;

    // methods
    public String getOriginSummary() {
        return origin.getText();
    }

    public String getDestinationSummary() {
        return destination.getText();
    }

    public String getPackageSummary() {
        return packageReview.getText();
    }

    public String getDropOffOrPickupSummary() {
        return dropOffOrPickup.getText();
    }

    public String getDeliveryDaySummary() {
        return deliveryDay.getText();
    }

    public String getGoodsSummary() {
        return descriptionOfGoods.stream().map(WebElement::getText).collect(Collectors.joining());
    }

    public String getPaymentMethodSummary() {
        return payPalPaymentMethod.getText();
    }
}
