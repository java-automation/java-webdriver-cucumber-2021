package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import static support.TestContext.getDriver;

public class UpsShipmentOriginSection {
// https://www.ups.com/ship/guided/origin?loc=en_US
// https://www.ups.com/ship/guided/origin?tx=63090532541409287&loc=en_US

    public UpsShipmentOriginSection() {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(xpath = "//select[@name='cac_country']")
    private WebElement country;

    @FindBy(name = "cac_companyOrName")
    private WebElement companyOrName;

    @FindBy(name = "cac_contactName")
    private WebElement contactName;

    @FindBy(name = "cac_singleLineAddress")
    private WebElement singleLineAddress;

    @FindBy(id = "origin-singleLineAddressEditButton")
    private WebElement addressEditButton;

    @FindBy(name = "cac_addressLine1")
    private WebElement addressLine1;

    @FindBy(name = "cac_addressLine2")
    private WebElement addressLine2;

    @FindBy(name = "cac_addressLine3")
    private WebElement addressLine3;

    @FindBy(name = "cac_postalCode")
    private WebElement zipCode;

    @FindBy(name = "cac_city")
    private WebElement city;

    @FindBy(name="cac_state")
    private WebElement state;

    @FindBy(name = "cac_email")
    private WebElement email;

    @FindBy(name = "cac_phone")
    private WebElement phone;

    @FindBy(name = "cac_extension")
    private WebElement extension;

    @FindBy(name = "agent_emailCheckbox")
    private WebElement sendStatusUpdates;

    @FindBy(name = "returnSwitch")
    private WebElement returnSwitch; // Use a different return address?

    // methods
    public void fillOutOrigin(String country, String name, String address1, String city, String state,
                              String zipCode, String email, String phone) {
        new Select(this.country).selectByVisibleText(country);
        companyOrName.sendKeys(name);
        // addressEditButton.sendKeys(address);
        addressEditButton.click();
        addressLine1.sendKeys(address1);
        this.zipCode.sendKeys(zipCode);
        this.city.sendKeys(city);
        new Select(this.state).selectByValue(state);
        this.email.sendKeys(email);
        this.phone.sendKeys(phone);
    }

}
