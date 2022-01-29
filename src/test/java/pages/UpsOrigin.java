package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class UpsOrigin extends UpsControls {

    public UpsOrigin() {
        url = "https://www.ups.com/ship/guided/origin";
    }

    @FindBy(id = "origin-cac_country")
    private WebElement country;

    @FindBy(id = "origin-cac_companyOrName")
    private WebElement name;

    @FindBy(id = "origin-cac_singleLineAddress")
    private WebElement address;

    @FindBy(xpath = "//button[@id='origin-singleLineAddressEditButton']/../p")
    private WebElement filledAddress;

    @FindBy(id = "origin-cac_email")
    private WebElement email;

    @FindBy(id = "origin-cac_phone")
    private WebElement phone;

    @FindBy(css = ".ngb-highlight")
    private WebElement suggestionHighlight;

    @FindBy(xpath = "//ngb-typeahead-window/button")
    private List<WebElement> suggestionsList;

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
    public void fillEmail(String value) {
        email.sendKeys(value);
    }
    public void fillPhone(String value) {
        phone.sendKeys(value);
    }
}