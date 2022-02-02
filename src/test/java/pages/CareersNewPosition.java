package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.assertEquals;

public class CareersNewPosition extends Page {
    public CareersNewPosition() {
        url = "https://skryabin-careers.herokuapp.com/new_position";
    }

    @FindBy(xpath = "//label[@for='positionTitle']//../input")
    private WebElement title;
    @FindBy(xpath = "//label[@for='positionDescription']//../textarea")
    private WebElement description;
    @FindBy(xpath = "//label[@for='positionCity']//../input")
    private WebElement city;
    @FindBy(xpath = "//label[@for='positionState']//../select")
    private WebElement state;
    @FindBy(xpath = "//input[@id='positionDateOpen']")
    private WebElement dateOpen;
    @FindBy(xpath = "//button[@id='positionSubmit']")
    private WebElement submitButton;

    public void fillTitle(String value) {
        fillField(title, value);
    }

    public void fillDescription(String value) {
        fillField(description, value);
    }

    public void fillCity(String value) {
        fillField(city, value);
    }

    public void fillDateOpen(String value) {
        fillField(dateOpen, value);
    }

    public void fillState(String value) {
        new Select(state)
                .selectByValue(value);
        assertEquals(state.getAttribute("value"), value);
    }

    public void fillField(WebElement webElement, String value) {
        webElement.sendKeys(value);
        assertEquals(webElement.getAttribute("value"), value);
    }

    public void submit() {
        submitButton.click();
    }
}
