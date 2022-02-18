package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static support.TestContext.getDriver;

public class CareerRecruit extends Page {
    public CareerRecruit() {
        url = "https://skryabin-careers.herokuapp.com/recruit";
    }

    @FindBy(xpath = "//div[@class='card bg-white mb-3']//*[@class='card-title']")
    private List<WebElement> cardTitles;

    ////h4[@class='position-name']
    @FindBy(xpath = "//a[@href='/new_position']//*[@class='card-title']")
    private WebElement newPositionLink;


    public WebElement positionCard(String title) { //it is an approach to deal with dynamic elements;
        return getDriver().findElement(By.xpath("//h4[text()='" + title + "']/ancestor::div[@class='card bg-white mb-3']"));
    }

    public By positionCardBy(String title) { //it is an approach to deal with dynamic elements;
        return (By.xpath("//h4[text()='" + title + "']/ancestor::div[@class='card bg-white mb-3']"));
    }

    public WebElement positionCardCloseButton(String title) { //it is an approach to deal with dynamic elements;
        return getDriver().findElement(By.xpath("//h4[text()='" + title + "']/ancestor::div[@class='card bg-white mb-3']//button"));
    }

    public void removePositionByTitle(String title) {
        new Actions(getDriver())
                .moveToElement(positionCard(title))
                .perform();
        getWait().until(ExpectedConditions.elementToBeClickable(positionCardCloseButton(title))).click();
        getWait().until(ExpectedConditions.invisibilityOf(positionCard(title)));
    }


    public boolean isPositionCardVisible(String title) {
        try {
            getWait().until(ExpectedConditions.visibilityOf(positionCard(title)));
            return true;
        } catch (TimeoutException | NoSuchElementException e) {
            return false;
        }
    }

    public void clickNewPosition() {
        getWait().until(ExpectedConditions.visibilityOf(newPositionLink)).click();
    }
}
