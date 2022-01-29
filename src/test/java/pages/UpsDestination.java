package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class UpsDestination extends UpsControls {

    public UpsDestination() {
        url = "https://www.ups.com/ship/guided/destination";
    }

    @FindBy(id = "origin_showSummaryAddress")
    private WebElement resultContainer;

    @FindBy(id = "destination-cac_country")
    private WebElement country;

    @FindBy(id = "destination-cac_singleLineAddress")
    private WebElement address;

    @FindBy(xpath = "//*[@id='destination-singleLineAddressEditButton']/../p")
    private WebElement filledAddress;

    @FindBy(xpath = "//ngb-typeahead-window/button")
    private List<WebElement> suggestionsList;

    @FindBy(id = "destination-cac_companyOrName")
    private WebElement name;

    @FindBy(css = ".ups-lever_switch")
    private WebElement residentialSwitch;

    @FindBy(id = "vm.residentialAddressControlId")
    private WebElement residentialHiddenCheckbox;

    @FindBy(id = "nbsAddressClassificationContinue")
    private WebElement residentialPopupContinue;

    public String getResultSummary() {
        return resultContainer.getText();
    }

    public void selectCountry(String value) {
        new Select(country).selectByVisibleText(value);
    }
    public void fillName(String value) {
        name.sendKeys(value);
    }
    public void fillAddress(String value) {
        address.sendKeys(value);
        suggestionsList.get(0).click();
        assertThat(filledAddress.getText()).isEqualTo(value);
    }

    public void checkResidentialAddressSwitch() {
        WebDriver driver = getDriver();

        if (!residentialHiddenCheckbox.isSelected()) {
            residentialSwitch.click();
        }
        residentialPopupContinue.click();
    }

    public void uncheckResidentialAddressSwitch() {
        if (residentialHiddenCheckbox.isSelected()) {
            residentialSwitch.click();
        }
        residentialPopupContinue.click();
    }
}