package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OpenPositionCareers extends Page{

    public OpenPositionCareers(){

    }

    @FindBy(xpath = "//div/input[@class='form-control']")
    private WebElement titleOfPosition;

    @FindBy(xpath = "//div/textarea[@class='form-control']")
    private WebElement descriptionOfPosition;

    @FindBy(xpath = "//label[@for='positionCity']/../input")
    private WebElement cityOfPosition;

    @FindBy(xpath = "//select[@class='form-control']/option[contains(text(),'Nevada')]")
    private WebElement stateOfPosition;

    @FindBy(id="positionSubmit")
    private WebElement submitPosition;

    @FindBy(id="positionDateOpen")
    private WebElement selectDate;


    public void fillOutDate(String value) {
        selectDate.sendKeys(value);
    }


    public void clickSubmitPosition() {
        submitPosition.click();
    }

//    public void fillOutState(String value) {
//        stateOfPosition.sendKeys(value);
//    }

    public void fillOutState() {
        stateOfPosition.click();
    }

    public void fillOutCity(String value) {
        cityOfPosition.sendKeys(value);
    }

    public void fillOutTitle(String value) {
        titleOfPosition.sendKeys(value);
    }

    public void fillDescription(String value){
        descriptionOfPosition.sendKeys(value);
    }
}
