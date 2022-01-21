package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class UpsShipmentDestSection {
//https://www.ups.com/ship/guided/destination?tx=10175282400775576&loc=en_US

    public UpsShipmentDestSection() {
        PageFactory.initElements(getDriver(),this);
    }

    private String urlRegExp = ".*destination.*";

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
                assertThat(originSummary.toLowerCase()).contains(origin.get(key).toLowerCase());
            }
        }
    }

    public boolean isSwitchedTo() {
        return getDriver().getCurrentUrl().matches(urlRegExp);
    }
}
