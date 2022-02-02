package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CareersNewPosition extends Page {

    @FindBy(xpath = "//label[@for='positionTitle']/following-sibling::input")
    private WebElement positionTitle;

    @FindBy(xpath = "//label[@for='positionDescription']/following-sibling::textarea")
    private WebElement positionDescription;

    @FindBy(xpath = "//label[@for='positionCity']/following-sibling::input")
    private WebElement positionCity;

    @FindBy(xpath = "//label[@for='positionState']/following-sibling::select")
    private WebElement positionState;

    @FindBy(id = "positionDateOpen")
    private WebElement positionDateOpen;

    @FindBy(id = "positionSubmit")
    private WebElement submitButton;

    public void setPositionTitle(String sTitle) {
        positionTitle.sendKeys(sTitle);
    }

    public void setPositionDescription(String sDescription) {
        positionDescription.sendKeys(sDescription);
    }

    public void setPositionCity(String sCity) {
        positionCity.sendKeys(sCity);
    }

    public void setPositionStateByValue(String sValue) {
        new Select(positionState).selectByValue(sValue);
    }

    public void setPositionStateByVisibleText(String sText) {
        new Select(positionState).selectByVisibleText(sText);
    }

    public void setPositionDateOpen(String sDate) {
        positionDateOpen.sendKeys(sDate);
    }

    public void clickSubmitButton() {
        submitButton.click();
    }
}
