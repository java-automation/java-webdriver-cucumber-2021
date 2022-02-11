package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import static support.TestContext.getDriver;

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
    private WebElement datePickerInput;

    @FindBy(id = "datepicker-popper")
    private List<WebElement> datePickerPopper;

    @FindBy(xpath = "//div[contains(@class,'year-read-view')]")
    private WebElement datePickerYearSelect;

    private WebElement getDatePickerYearOption(String year) {
        return getDriver().findElement(By.xpath("//div[contains(@class,'year-option')][contains(normalize-space(.),'" + year + "')]"));
    }

    @FindBy(xpath = "//div[contains(@class,'month-read-view')]")
    private WebElement datePickerMonthSelect;

    private WebElement getDatePickerMonthOption(String month) {
        return getDriver().findElement(By.xpath("//div[contains(@class,'month-option')][contains(normalize-space(.),'" + month + "')]"));
    }

    private WebElement getDatePickerDayOption(String day) {
        return getDriver().findElement(By.xpath("//div[contains(@class,'day')][contains(normalize-space(.),'" + day + "')]"));
    }

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

    public boolean isDatePickerVisible() {
        return datePickerPopper.stream().findFirst().isPresent();
    }

    public void pickDate(String date) {
        datePickerInput.sendKeys(date);
    }

    public void pickDate(String year, String month, String day) {
        datePickerInput.click();
        datePickerYearSelect.click();
        getDatePickerYearOption(year).click();
        datePickerMonthSelect.click();
        getDatePickerMonthOption(month).click();
        getDatePickerDayOption(day).click();
        getWait().until(driver -> !isDatePickerVisible());
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

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate parsedDate = LocalDate.parse(data.get("dateOpen"), formatter);
        pickDate(String.valueOf(parsedDate.getYear()),
                parsedDate.getMonth().getDisplayName(TextStyle.FULL, Locale.US),
                String.valueOf(parsedDate.getDayOfMonth()));

        submitNewPositionForm();
        getWait().until(driver -> isPositionVisible(title));
    }
}
