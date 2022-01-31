package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UpsReview extends UpsCreateShipment {

    public UpsReview() {
        setUrl("https://www.ups.com/ship/single-page");
        setTitle("UPS Shipping");
    }

    @FindBy(id = "nbsBackForwardNavigationCancelShipmentButton")
    private WebElement cancelShipmentButton;

    @FindBy(id = "nbsCancelShipmentWarningYes")
    private WebElement cancelShipmentWarningYes;

    //destination summary is in parent class UpsCreateShipment

    //destination
    @FindBy(id = "destination_agentSummaryNameLine")
    private WebElement destinationSummaryName;

    @FindBy(id = "destination_agentSummaryAddressLine")
    private WebElement destinationSummaryAddress;

    @FindBy(id = "destination_agentSummaryCountryLine")
    private WebElement destinationSummaryCountry;

    @FindBy(id = "destination_agentSummaryContactLine")
    private WebElement destinationSummaryContact;

    @FindBy(id = "destination_agentSummaryResidentialLine")
    private WebElement destinationSummaryResidential;

    @FindBy(id = "nbsSpaShipmentPackages")
    private WebElement packageSummary;

    @FindBy(id = "nbsServiceReviewDeliveryDay")
    private WebElement deliveryDaySummary;

    @FindBy(id = "nbsOptionsDrawerShipmentOptions")
    private WebElement optionsSummary;

    @FindBy(id = "nbsSpaPayment")
    private WebElement paymentSummary;


    public void cancelShipment() {
        //avoiding footer
        scrollToElementWithOffset(cancelShipmentButton, 100);
        cancelShipmentButton.click();
        waitForModalDialog();
        cancelShipmentWarningYes.click();
        waitForFirstLoad();
    }

    public String getDestinationSummaryName() {
        return destinationSummaryName.getText();
    }

    public String getDestinationSummaryAddress() {
        return destinationSummaryAddress.getText();
    }

    public String getDestinationSummaryCountry() {
        return destinationSummaryCountry.getText();
    }

    public String getDestinationSummaryContact() {
        return destinationSummaryContact.getText();
    }

    public String getDestinationSummaryResidential() {
        return destinationSummaryResidential.getText();
    }

    public String getPackageSummaryText() {
        return packageSummary.getText();
    }

    public String getDeliveryDaySummaryText() {
        return deliveryDaySummary.getText();
    }

    public String getOptionsSummaryText() {
        return optionsSummary.getText();
    }

    public String getPaymentSummaryText() {
        return paymentSummary.getText();
    }
}
