package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import support.ShipmentEndpoint;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class UpsShipmentForm extends UpsBasePage {

    // fields
    @FindBy(xpath = "//select[@name='cac_country']")
    private WebElement country;

    @FindBy(xpath = "//input[@name='cac_companyOrName']")
    private WebElement companyOrName;

    @FindBy(xpath = "//input[@name='cac_contactName']")
    private WebElement contactName;

    @FindBy(xpath = "//input[@name='cac_singleLineAddress']")
    private WebElement singleLineAddress;

    @FindBy(xpath = "//ngb-typeahead-window/button")
    private List<WebElement> suggestionsList;

    @FindBy(xpath = "//button[contains(@id,'singleLineAddressEditButton')]/preceding-sibling::p")
    private WebElement singleLineAddressProcessed;

    @FindBy(xpath = "//button[contains(@id,'singleLineAddressEditButton')]")
    private WebElement addressEditButton;

    @FindBy(xpath = "//input[@name='cac_addressLine1']")
    private WebElement addressLine1;

    @FindBy(xpath = "//input[@name='cac_addressLine2']")
    private WebElement addressLine2;

    @FindBy(xpath = "//input[@name='cac_addressLine3']")
    private WebElement addressLine3;

    @FindBy(xpath = "//input[@name='cac_postalCode']")
    private WebElement zipCode;

    @FindBy(xpath = "//input[@name='cac_city']")
    private WebElement city;

    @FindBy(name="cac_state")
    private WebElement state;

    @FindBy(xpath = "//input[@name='cac_email']")
    private WebElement email;

    @FindBy(xpath = "//input[@name='cac_phone']")
    private WebElement phone;

    @FindBy(xpath = "//input[@name='cac_extension']")
    private WebElement extension;

    // methods
    public boolean formDisplayed() {
        return country.isDisplayed();
    }

    public void fillCounty(String country) {
        new Select(this.country).selectByVisibleText(country); 
    }

    public void fillName(String name) {
        companyOrName.sendKeys(name);
    }

    // lesson 17 (01/27/2022) implementation
//    public void fillSingleLineAddress(String address) {
//        singleLineAddress.sendKeys(address);
//        for (WebElement item: suggestionsList) {
//            System.out.println(item.getText());
//        }
//        suggestionsList.get(0).click();
//        System.out.println("address parameter: " + address);
//        assertThat(singleLineAddressProcessed.getText()).isEqualTo(address);
//    }

    public void fillSingleLineAddress(String address) {
        singleLineAddress.sendKeys(address);
        wait.until(driver -> suggestionsList.size()>0 && suggestionsList.get(0).isDisplayed());
        new Actions(getDriver()).sendKeys(Keys.RETURN).perform();
        wait.until(driver -> singleLineAddressProcessed.isDisplayed());
    }

    public void fillMultiLineAddress(String address1, String city, String state, String zipCode) {
        addressEditButton.click();
        addressLine1.sendKeys(address1);
        this.zipCode.sendKeys(zipCode);
        this.city.sendKeys(city);
        new Select(this.state).selectByValue(state);
        wait.until(driver -> this.city.getAttribute("value").equals(city.toUpperCase()));
    }

    public void fillEmail(String email) {
        this.email.sendKeys(email);
    }

    public void fillPhone(String phone) {
        this.phone.sendKeys(phone);
    }

    public void fillOutForm(ShipmentEndpoint endpoint) {
        fillCounty(endpoint.getCountry());
        fillName(endpoint.getName());
        if (endpoint.getType().equals("residential") || endpoint.getSingleLineAddressLength() <= 35) {
            fillSingleLineAddress(endpoint.getSingleLineAddress());
        } else {
            fillMultiLineAddress(endpoint.getAddress1(),endpoint.getCity(),endpoint.getState(),endpoint.getZipCode());
        }
        fillEmail(endpoint.getEmail());
        fillPhone(endpoint.getPhone());
        try {
            Thread.sleep(300); // to be removed after bug fix
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
