package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static support.TestContext.getDriver;

public class CareersRecruit extends Page {


    @FindBy(xpath = "//a[@class='text-blue text-decoration-none']/h4[text()='New Position']")
    private WebElement newPositionButton;

    private WebElement positionCard(String title) {
        return getDriver().findElement(By.xpath("//h4[text()='" + title + "']/ancestor::div[@class='card bg-white mb-3']"));
    }

    private WebElement positionCardCloseButton(String title) {
        return getDriver().findElement(By.xpath("//h4[text()='" + title + "']/ancestor::div[@class='card bg-white mb-3']//button"));
    }

    public void removePositionByTitle(String title) {
        new Actions(getDriver()).moveToElement(positionCard(title)).perform();
        getWait().until(ExpectedConditions.elementToBeClickable(positionCardCloseButton(title)));
        positionCardCloseButton(title).click();
        getWait().until(ExpectedConditions.invisibilityOf(positionCard(title)));
    }
    public void openNewPosition(){
        newPositionButton.click();
    }

    public boolean isPositionCardVisible(String title) {
        try {
            return positionCard(title).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }

    }
    public List<WebElement> candidates(){

    }

}
