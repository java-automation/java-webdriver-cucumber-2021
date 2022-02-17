package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Map;

import static support.TestContext.getData;
import static support.TestContext.getDriver;

public class CareersRecruit extends Page {
    Map<String, String> data;

    @FindBy(xpath = "//a[@class='text-blue text-decoration-none']/h4[text()='New Position']")
    private WebElement newPositionButton;

    @FindBy(xpath = "//h4[@class='card-title']")
    private WebElement allCardTitles;

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

    public void openNewPosition() {
        newPositionButton.click();
    }

    public boolean isPositionCardVisible(String title) {
        try {
            return positionCard(title).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }

    }


    public boolean isCardCreated() {
        data = getData("position", "career");
        boolean result = false;
        String expCard = data.get("title");
        List<WebElement> cards = getDriver().findElements(By.xpath("//h4[@class='card-title']"));
        getWait().until(ExpectedConditions.visibilityOfAllElements(cards));
        for (WebElement el : cards) {
            if (el.getText().equals(expCard)) {
                result = true;
            }
        }
        return result;
    }

    public void removePosition(){

        data = getData("position", "career");
        removePositionByTitle(data.get("title"));
    }
}