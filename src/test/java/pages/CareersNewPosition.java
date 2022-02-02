package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.Map;

public class CareersNewPosition extends CareersRecruit {

    public CareersNewPosition() {
        setUrl("https://skryabin-careers.herokuapp.com/new_position");
        setTitle("Careers Portal");
    }

    @FindBy(css = "label[for='positionTitle']+input")
    private WebElement title;

    @FindBy(css = "label[for='positionDescription']+textarea")
    private WebElement description;

    @FindBy(css = "label[for='positionCity']+input")
    private WebElement city;

    @FindBy(css = "label[for='positionState']+select")
    private WebElement stateSelect;

    @FindBy(id = "positionDateOpen")
    private WebElement datePicker;

    @FindBy(id = "positionSubmit")
    private WebElement submitButton;


    public void fillTitle(String titleValue) {
        title.sendKeys(titleValue);
    }

    public void fillDescription(String descriptionValue) {
        description.sendKeys(descriptionValue);
    }

    public void fillCity(String cityValue) {
        city.sendKeys(cityValue);
    }

    public void selectState(String state) {
        new Select(stateSelect).selectByValue(state);
    }

    public void pickDate(String date) {
        //TODO: use custom select and click instead of sending keys
        datePicker.sendKeys(date);
    }

    public void submitNewPositionForm() {
        submitButton.click();
    }

    public void createPositionFromMap(Map<String, String> data) {
        String title = data.get("title");
        fillTitle(title);
        fillDescription(data.get("description"));
        fillCity(data.get("city"));
        selectState(data.get("state"));
        pickDate(data.get("date"));
        submitNewPositionForm();
        getWait().until(driver -> isPositionVisible(title));
    }
}
