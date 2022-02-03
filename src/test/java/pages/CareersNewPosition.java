package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import static support.TestContext.getDriver;

public class CareersNewPosition extends CareersHome {

    public CareersNewPosition() {
        url = "https://skryabin-careers.herokuapp.com/new_position";
    }

    // fields
    @FindBy(xpath = "//label[@for='positionTitle']/following-sibling::input")
    private WebElement title;

    @FindBy(xpath = "//label[@for='positionDescription']/following-sibling::textarea")
    private WebElement description;

    @FindBy(xpath = "//label[@for='positionAddress']/following-sibling::input")
    private WebElement address;

    @FindBy(xpath = "//label[@for='positionCity']/following-sibling::input")
    private WebElement city;

    @FindBy(xpath = "//label[@for='positionState']/following-sibling::select")
    private WebElement state;

    @FindBy(xpath = "//label[@for='positionZip']/following-sibling::input")
    private WebElement zip;

    @FindBy(xpath = "//input[@id='positionDateOpen']")
    private WebElement dateOpen;

    @FindBy(xpath = "//div[@class='react-datepicker__month-read-view']")
    private WebElement monthDropdown;

    @FindBy(xpath = "//div[@class='react-datepicker__year-read-view']")
    private WebElement yearDropdown;

    @FindBy(xpath = "(//div[@class='react-datepicker__year-option'])[1]")
    private WebElement yearDropdownUpArrow;

    @FindBy(xpath = "(//div[@class='react-datepicker__year-option'])[last()]")
    private WebElement yearDropdownDownArrow;

    @FindBy(xpath = "//div[@class='react-datepicker__year-option']")
    private List<WebElement> yearDropdownVisibleChoices;

    @FindBy(id = "positionSubmit")
    private WebElement submitButton;

    private WebElement getMonth(String monthName){
        return getDriver().findElement(By.xpath("//div[@class='react-datepicker__month-option'][text()='" +
                                                                                                     monthName + "']"));
    }

    private WebElement getMonth(int monthNumber){
        return getMonth(monthName(monthNumber));
    }

    private WebElement getYear(int year){
        return getDriver().findElement(By.xpath("//div[@class='react-datepicker__year-option'][text()='" + year + "']"));
    }

    private WebElement getDay(int day){
        return getDriver().findElement(By.xpath("//div[contains(@class,'react-datepicker__day--" +
                     String.format("%03d",day) + "')][not(contains(@class,'react-datepicker__day--outside-month'))]"));
    }

    // methods
    private String monthName(int monthNumber){
        String[] months = new String[]{"January","February","March","April","May","June",
                "July","August","September","October","November","December"};
        return months[monthNumber-1];
    }

    private void selectMonthByName(String monthName){
        monthDropdown.click();
        getMonth(monthName).click();
    }

    private void selectMonthByNumber(int monthNumber){
        selectMonthByName(monthName(monthNumber));
    }

    private void selectYear(int year){
        yearDropdown.click();
        int listSize = yearDropdownVisibleChoices.size();
        int topYear = Integer.parseInt(yearDropdownVisibleChoices.get(1).getText());
        int bottomYear = Integer.parseInt(yearDropdownVisibleChoices.get(listSize-2).getText());
        if (year > topYear) {
            for (int i=0; i<year-topYear; i++) {
                yearDropdownUpArrow.click();
            }
        }
        if (year < bottomYear) {
            for (int i=0; i<bottomYear-year; i++) {
                yearDropdownDownArrow.click();
            }
        }
        getYear(year).click();
    }

    private void selectDay(int day){
        getDay(day).click();
    }

    public void selectDateOpen(String dateValue){
        dateOpen.click();
        LocalDate date = LocalDate.parse(dateValue, DateTimeFormatter.ofPattern("M/d/yyyy"));
        selectYear(date.getYear());
        selectMonthByNumber(date.getMonthValue());
        selectDay(date.getDayOfMonth());
    }

    public void fillDateOpen(String date){
        dateOpen.sendKeys(date);
    }

    public void fillTitle(String titleValue){
        title.sendKeys(titleValue);
    }

    public void fillDescription(String descriptionValue){
        description.sendKeys(descriptionValue);
    }

    public void fillAddress(String addressValue){
        address.sendKeys(addressValue);
    }

    public void fillCity(String cityValue){
        city.sendKeys(cityValue);
    }

    public void selectStateByName(String stateName){
        new Select(state).selectByVisibleText(stateName);
    }

    public void fillZip(String zipValue){
        zip.sendKeys(zipValue);
    }

    public void submit(){
        submitButton.click();
    }
}
