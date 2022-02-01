package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.NoSuchElementException;

import static support.TestContext.getDriver;

public class CareerRecruite extends Page {
    public CareerRecruite() {
        url = "https://skryabin-careers.herokuapp.com/recruit";
    }

    @FindBy(xpath = "//div[@class='card bg-white mb-3']//*[@class='card-title']")
    private List<WebElement> cardTitles;
    @FindBy(xpath = "//h4[text()='Principal Automation Engineer']/ancestor::div[@class='card bg-white mb-3']")
    private WebElement cardPosition;
    @FindBy(xpath = "//h4[text()='Principal Automation Engineer']/ancestor::div[@class='card bg-white mb-3']//button")
    private WebElement positionCardCloseButton;
    public WebElement getCardPosition() {
        return cardPosition;
    }

    public WebElement positionCard(String title) { //it is an approach to deal with dynamic elements;
        return getDriver().findElement(By.xpath("//h4[text()='" + title + "']/ancestor::div[@class='card bg-white mb-3']"));
    }

    public WebElement positionCardCloseButton(String title) {
        return getDriver().findElement(By.xpath("//h4[text()='" + title + "']/ancestor::div[@class='card bg-white mb-3']//button"));
    }

    public void removePositionByTitle(String title) {
        new Actions(getDriver())
                .moveToElement(positionCard(title))
                .perform();
        wait.until(ExpectedConditions.elementToBeClickable(positionCardCloseButton)).click();
        wait.until(ExpectedConditions.invisibilityOf(positionCard(title)));
    }

    public boolean isPositionCardVisible(String title) {
        try {
            return positionCard(title).isDisplayed();
        } catch (NoSuchElementException exception) {
            return false;
        }
    }
}
