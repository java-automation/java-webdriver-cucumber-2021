package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.NoSuchElementException;

import static support.TestContext.getDriver;

public class CareersRecruiterPage extends Page {

    public CareersRecruiterPage(){

    }
    @FindBy(xpath = "div[@class='card bg-white mb-3']")
    private List<WebElement> cards;


    private WebElement positionCard(String title) {
        return getDriver().findElement(By.xpath("//h4[text()='" + title + "']/ancestor::div[@class='card bg-white mb-3']"));
       //return getDriver().findElement(By.xpath("//h4[text()='Principal Automation Engineer']/ancestor::div[@class='card bg-white mb-3']"));

    }
    private WebElement positionCardCloseButton(String title) {
        return getDriver().findElement(By.xpath("//h4[text()='" + title + "']/ancestor::div[@class='card bg-white mb-3']//button"));

    }

    public void removePositionByTitle(String title)  {
        new Actions(getDriver()).moveToElement(positionCard(title)).perform();
        getWait().until(ExpectedConditions.elementToBeClickable(positionCardCloseButton(title)));
        positionCardCloseButton(title).click();
        getWait().until(ExpectedConditions.invisibilityOf(positionCard(title)));
        // clickWithJS( positionCardCloseButton(title));
    }

    public boolean isPositionCardVisible(String title){
        try{
            return positionCard(title).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }


    }

}
