package pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Locale;

public class UpsReview extends Page {
    public UpsReview() {
        url = "https://www.ups.com/ship/single-page?tx=84985068604147304&loc=en_US";
    }

    @FindBy(xpath = "//div[@id='origin_showSummaryAddress']")
    private WebElement origin;

    @FindBy(xpath = "//div[@id='destination_showSummaryAddress']")
    private WebElement destination;

    @FindBy(xpath = "//div[@id='destination_showSummaryAddress']//div[@id='destination_agentSummaryResidentialLine']")
    private WebElement residentialSummary;

    @FindBy(xpath = "//package-drawer//div[@class='ups-drawer-content']")
    private WebElement packageInfo;

    @FindBy(xpath = "//pickup-service-drawer//div[@class='ups-drawer-content']")
    private WebElement shippingService;

    @FindBy(xpath = "//options-drawer//div[@class='ups-drawer-content']")
    private WebElement additionalOptions;

    @FindBy(xpath = "//payment-drawer//div[@class='ups-drawer-content']")
    private WebElement payments;

    public WebElement getOrigin() {
        return origin;
    }

    public WebElement getDestination() {
        return destination;
    }

    public WebElement getResidentialSummary() {
        return residentialSummary;
    }

    public void assertOrigin(String value) {
        assertValue(origin, value);
    }

    public void assertDestination(String value) {
        assertValue(destination, value);
    }

    public void assertResidential(String value) {
        assertValue(residentialSummary, value);
    }

    public void assertPackageInformation(String value) {
        assertValue(packageInfo, value);
    }

    public void assertShippingService(String value) {
        assertValue(shippingService, value);
    }

    public void assertAdditionalOptions(String value) {
        assertValue(additionalOptions, value);
    }

    public void assertPayments(String value) {
        assertValue(payments, value);
    }

    public void assertValue(WebElement webElement, String value) {
        if ((value != null) && (!value.equals(""))) {
            Assert.assertTrue(webElement.getText().toLowerCase(Locale.ROOT).contains(value.toLowerCase(Locale.ROOT)));
        }
    }

}
