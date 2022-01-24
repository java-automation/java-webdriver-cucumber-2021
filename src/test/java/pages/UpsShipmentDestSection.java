package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class UpsShipmentDestSection extends UpsShipmentOriginSection {

    public UpsShipmentDestSection() {
    }

    private WebDriverWait wait = new WebDriverWait(getDriver(),10,200);

    @FindBy(xpath = "//destination")
    private WebElement destinationFormWrapper;

    // origin summary
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

    //modal dialog
    @FindBy(xpath = "//div[contains(@class,'modal-content')]")
    private WebElement modalDialog;

    @FindBy(xpath = "//span[@class='ups-lever_switch_no']")
    private WebElement nonResidentialSwitchPos;

    @FindBy(xpath = "//span[@class='ups-lever_switch_yes']")
    private WebElement residentialSwitchPos;

    @FindBy(xpath = "//button[@id='nbsAddressClassificationContinue']")
    private WebElement dialogContinueButton;

    // methods
    public void verifyOrigin(Map<String, String> origin) {
        String originSummary = origin_summary.getText();
        for (String key : origin.keySet()) {
            if (key.equals("country")) {
                // ISO2 country codes from country names
                Map<String, String> countries = new HashMap<>();
                for (String iso : Locale.getISOCountries()) {
                    Locale l = new Locale("", iso);
                    countries.put(l.getDisplayCountry(), iso);
                }
                assertThat(originSummary).contains(countries.get(origin.get(key)));
            } else {
                String originValueLowcase = origin.get(key).toLowerCase();
                if (key.equals("type")) {continue;}
                if (key.equals("address1")) {
                    originValueLowcase = originValueLowcase.replace("blvd", "boulevard");
                }
                assertThat(originSummary.toLowerCase()).contains(originValueLowcase);
            }
        }
    }

    public void fillOutDestination(String country, String name, String address1, String city, String state,
                              String zipCode, String email, String phone, String type) {
        fillOutOrigin(country,name,address1,city,state,zipCode,email,phone,type);
    }

    private boolean isAddressSwitchResidential() {
        return residentialSwitchPos.isDisplayed() && !nonResidentialSwitchPos.isDisplayed();
    }

    private boolean isAddressSwitchNonResidential() {
        return !residentialSwitchPos.isDisplayed() && nonResidentialSwitchPos.isDisplayed();
    }

    public void confirmResidential(){
        wait.until(driver -> modalDialog.isDisplayed());
        if (isAddressSwitchNonResidential()) nonResidentialSwitchPos.click();
        wait.until(driver -> isAddressSwitchResidential());
        dialogContinueButton.click();
    }

    public void confirmNonResidential(){
        wait.until(driver -> modalDialog.isDisplayed());
        if (isAddressSwitchResidential()) residentialSwitchPos.click();
        wait.until(driver -> isAddressSwitchNonResidential());
        dialogContinueButton.click();
    }

    @Override
    public boolean isSwitchedTo() {
        return destinationFormWrapper.isDisplayed();
    }

}
