package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class UpsOrigin extends Page{


    public UpsOrigin(){
        url = "https://www.ups.com/ship/guided/origin";
    }
    @FindBy(xpath = "//input[@id='origin-cac_companyOrName']")
    private WebElement name;
// css .dropdown-menu > .dropdown-item.active
    @FindBy(xpath = "//input[@id='origin-cac_singleLineAddress']")
    private WebElement addressField;

    @FindBy(xpath = "//button[@class='dropdown-item active']")
    private WebElement addressDropdown;

    @FindBy(xpath = "//input[@id='origin-cac_email']")
    private WebElement email;

    @FindBy(xpath = "//input[@id='origin-cac_phone']")
    private WebElement phone;

    @FindBy(xpath = "//button[@id='nbsBackForwardNavigationContinueButton']")
    private WebElement continueButton;

    @FindBy(xpath = "//select[@id='origin-cac_country']")
    private WebElement countryDropdown;

    public void selectCountry(String destination){
        Select select = new Select(countryDropdown);
        select.selectByVisibleText(destination);
    }
    public void fillName(String value){
        name.sendKeys(value);
    }

    public void fillAddress(String value){
        addressField.sendKeys(value);
        addressDropdown.click();

    }

    public void fillEmail(String value){
        email.sendKeys(value);
    }
    public void fillPhone(String value){
        phone.sendKeys(value);
    }
    public void submit(){
        continueButton.click();
    }
}
