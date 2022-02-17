package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.Map;

public class CareerNewPositionPage extends Page{

    @FindBy(xpath = "//label[@for='positionTitle']/../input") // or label[@for='positionTitle']
    private WebElement titleField;

    @FindBy(xpath = "//label[@for='positionDescription']/../textarea")
    private WebElement descriptionField;

    @FindBy(xpath = "//label[@for='positionAddress']/../input")
    private WebElement addressField;

    @FindBy(xpath = "//label[@for='positionCity']/../input")
    private WebElement cityField;

    @FindBy(xpath = "//label[@for='positionZip']/../input")
    private WebElement zipCode;

    @FindBy(xpath = "//input[@id='positionDateOpen']")
    private WebElement dateField;

    @FindBy(xpath = "//button[@id='positionSubmit']")
    private WebElement submitButton;

    @FindBy(xpath = "//select")
    private WebElement state;

    public void clickSubmit(){
        submitButton.click();
    }

    public void filloutTitle(String value){
        titleField.sendKeys(value);
    }

    public void filloutDescription(String value){
        descriptionField.sendKeys(value);
    }

    public void filloutAddress(String value){
        addressField.sendKeys(value);
    }

    public void filloutCity(String value){
        cityField.sendKeys(value);
    }

    public void filloutZipcode(String value){
        zipCode.sendKeys(value);
    }

    public void filloutDate(String value){
        dateField.sendKeys(value);
    }

    public void selectState(String value){
        new Select(state).selectByVisibleText(value);
    }


    public void createPosition(Map<String,String> data){
        filloutTitle(data.get("title"));
        filloutDescription(data.get("description"));
        filloutAddress(data.get("address"));
        filloutCity(data.get("city"));
        selectState(data.get("state"));
        filloutZipcode(data.get("zipcode"));
        filloutDate(data.get("date"));

    }

}
