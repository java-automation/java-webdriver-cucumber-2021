package pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import support.ShipmentEndpoint;

public class UpsShipmentDestination extends UpsShipmentPage {

    private UpsShipmentForm destForm = new UpsShipmentForm();

    public UpsShipmentDestination() {
        urlRegExp = ".*www.ups.com/ship/guided/destination.*";
    }

    // origin summary fields
    @FindBy(xpath = "//ship-app-agent-summary")
    private WebElement originInfoWrapper;

    @FindBy(id = "origin_showSummaryAddress")
    private WebElement origin_summary;

    @FindBy(id = "origin_agentSummaryNameLine")
    private WebElement origin_agentName;

    @FindBy(id = "origin_agentSummaryAddressLine")
    private WebElement origin_agentAddress;

    @FindBy(id = "origin_agentSummaryCountryLine")
    private WebElement origin_agentCountry;

    @FindBy(id = "origin_agentSummaryContactLine")
    private WebElement origin_agentContact; // email and phone number

    @FindBy(id = "origin_agentSummaryResidentialLine")
    private WebElement origin_agentResidential;

    // fields of the modal dialog to set address residential or not
    @FindBy(css = ".ups-lever_switch")
    private WebElement residentialSwitch;

    @FindBy(xpath = "//span[@class='ups-lever_switch_no']")
    private WebElement nonResidentialSwitchPos;

    @FindBy(xpath = "//span[@class='ups-lever_switch_yes']")
    private WebElement residentialSwitchPos;

    @FindBy(id = "vm.residentialAddressControlId")
    private WebElement residentialHiddenCheckbox;

    @FindBy(id = "nbsAddressClassificationContinue")
    private WebElement residentialPopupContinue;


    // methods
    public boolean destinationFormDisplayed() {
        return urlMatches() & destForm.formDisplayed();
    }

    public String getOriginSummary() {
        wait.until(driver -> originInfoWrapper.isDisplayed());
        return origin_summary.getText();
    }

    public void fillOutDestination(ShipmentEndpoint dest) {
        wait.until(driver -> destinationFormDisplayed());
        destForm.fillOutForm(dest);
    }

    private boolean isAddressSwitchResidential() {
        return residentialSwitchPos.isDisplayed() && !nonResidentialSwitchPos.isDisplayed();
    }

    private boolean isAddressSwitchNonResidential() {
        return !residentialSwitchPos.isDisplayed() && nonResidentialSwitchPos.isDisplayed();
    }

    private void waitModalDialogDisplayedWithRetry(){
        try {
            waitModalDialogDisplayed();
        } catch (TimeoutException e) {
            submitShipmentForm();
            waitModalDialogDisplayed();
        }
    }

    public void checkResidentialAddressSwitch(){
        waitModalDialogDisplayedWithRetry();
        if (isAddressSwitchNonResidential()) residentialSwitch.click();
        wait.until(driver -> isAddressSwitchResidential());
        residentialPopupContinue.click();
    }

    public void uncheckResidentialAddressSwitch(){
        waitModalDialogDisplayedWithRetry();
        if (isAddressSwitchResidential()) residentialSwitch.click();
        wait.until(driver -> isAddressSwitchNonResidential());
        residentialPopupContinue.click();
    }

}
