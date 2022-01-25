package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static support.TestContext.getDriver;

public class ShipFromPageUPS {


    public ShipFromPageUPS(){

        PageFactory.initElements(getDriver(),this);

    }

    WebDriverWait wait = new WebDriverWait(getDriver(),5);


    //fields

    @FindBy(xpath = "//select[@name='cac_country']")
    private WebElement country;


    @FindBy(xpath = "//input[@id='origin-cac_companyOrName']")
    private WebElement companyOrName;

    @FindBy(xpath = "//input[@id='destination-cac_contactName']")
    private WebElement contactName;

// //input[@id='origin-cac_singleLineAddress'] --- when page opens
    @FindAll({ @FindBy(xpath = "//input[@id='origin-cac_singleLineAddress']"), @FindBy(xpath = "//input[@id='destination-cac_singleLineAddress']")})
    private List<WebElement> addressList;


    //@FindAll({@FindBy(how = How.ID, using = "foo"),
    //           @FindBy(className = "bar")})

    @FindBy(xpath = "//input[@id='origin-cac_singleLineAddress']")
    private WebElement addressPageOpen;


    @FindBy(xpath = "//input[@id='destination-cac_singleLineAddress']")
    private WebElement addressLine;

    @FindBy(xpath = "//input[@id='destination-cac_addressLine1']")
    private WebElement addressLine1;

    @FindBy(xpath = "//input[@id='destination-cac_addressLine2']")
    private WebElement addressLine2;

    @FindBy(xpath = "//input[@id='destination-cac_addressLine3']")
    private WebElement addressLine3;

    @FindBy(xpath = "//input[@id='destination-cac_city']")
    private WebElement city;

    @FindBy(xpath = "//input[@id='origin-cac_postalCode']")
    private WebElement zipCode;

    @FindBy(xpath = "//select[@id='origin-cac_state']/option[contains(text(),'Illinois')]")
    private WebElement state;

    @FindBy(xpath = "//input[@id='origin-cac_email']")
    private WebElement email;

    @FindBy(xpath = "//input[@id='origin-cac_phone']")
    private WebElement phone;

    @FindBy(xpath = "//span/button[@id='nbsBackForwardNavigationContinueButton']")
    private WebElement continueButton;


// methods

    public void fillCountry(String value) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@name='cac_country']")));
        new Select(country).selectByVisibleText(value);

       // country.sendKeys(value);
    }

    public void fillCompanyOrName(String value) {
        companyOrName.sendKeys(value);
    }

    public void fillContactName(String value){
        companyOrName.sendKeys(value);
    }

    public void fillAddressLine(String value){
        addressList.get(0).sendKeys(value);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//ngb-highlight"))).get(0).click();


    }
    public void fillAddressLine1(String value) {
        addressLine1.sendKeys(value);
    }
    public void fillAddressLine2(String value) {
        addressLine2.sendKeys(value);
    }
    public void fillAddressLine3(String value) {
        addressLine3.sendKeys(value);
    }

    public void fillCity(String value){
        city.sendKeys(value);
    }
    public void fillZipCode(String value){
        zipCode.sendKeys(value);
    }
    public void fillState(String value){

        new Select(state).selectByVisibleText(value);
       // state.sendKeys(value);
    }

    public void fillEmail(String value){
        email.sendKeys(value);
    }

    public void fillPhone(String value){
        phone.sendKeys(value);
    }
    public void continueButton(){
        continueButton.click();
    }

}


