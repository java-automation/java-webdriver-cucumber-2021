package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CareersPositionDetails extends CareersHome {

    public CareersPositionDetails(){
        urlRegExp = "https://skryabin-careers.herokuapp.com/positions/\\d+";
    }

    // fields
    @FindBy(xpath = "//label[@for='positionTitle']/../span")
    private WebElement title;

    @FindBy(xpath = "//label[@for='positionDescription']/../span")
    private WebElement description;

    @FindBy(xpath = "//label[@for='positionAddress']/../span")
    private WebElement address;

    @FindBy(xpath = "//label[@for='positionCity']/../span")
    private WebElement city;

    @FindBy(xpath = "//label[@for='positionState']/../span")
    private WebElement state;

    @FindBy(xpath = "//label[@for='positionZip']/../span")
    private WebElement zip;

    @FindBy(xpath = "//label[@for='positionDateOpen']/..//span")
    private WebElement dateOpen;

    public String getTitle(){
        return title.getText();
    }

    public String getDescription(){
        return description.getText();
    }

    public String getAddress(){
        return address.getText();
    }

    public String getCity(){
        return city.getText();
    }

    public String getState(){
        return state.getText();
    }

    public String getZip(){
        return zip.getText();
    }

    public String getDateOpen(){
        return dateOpen.getText();
    }

}
