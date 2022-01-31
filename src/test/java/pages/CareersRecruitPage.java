package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static support.TestContext.getDriver;

public class CareersRecruitPage extends Page {

    // constructor
    public CareersRecruitPage() {
        url  = "https://skryabin-careers.herokuapp.com/recruit";
    }

    public By getPositionByTitle(String sTitle) {
        return By.xpath("//h4[@class='card-title' and normalize-space()='" + sTitle + "']");
    }

    public WebElement getCloseCardButtonByTitle(String sTitle) {
        return getDriver().findElement(By.xpath("//h4[@class='card-title' and normalize-space()='" + sTitle + "']/ancestor::div[contains(@class,'card')]//button[@class='style-close']"));
    }


}
