package pages;

import io.cucumber.java.de.Wenn;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static support.TestContext.getDriver;

public class CareersRecruit extends CareersHome {

    public CareersRecruit() {
        setUrl("https://skryabin-careers.herokuapp.com/recruit");
        setTitle("Careers Portal");
    }

    private WebElement getPositionCard(String positionTitle) {
        String buttonXPath = "//a[contains(@href,'positions')]/h4[@class='card-title'][normalize-space(.)='" + positionTitle + "']/../../..";
        return getDriver().findElement(By.xpath(buttonXPath));
    }

    public void removePosition(String positionTitle) {
        WebElement card = getPositionCard(positionTitle);
        new Actions(getDriver())
                .moveToElement(card)
                .moveByOffset(card.getSize().getHeight() / 2 - 30,-card.getSize().getHeight() / 2 + 30)
                .click()
                .perform();
    }

    public boolean isPositionVisible(String positionTitle) {
        WebElement card;
        try {
            card = getPositionCard(positionTitle);
            getWait().until(ExpectedConditions.visibilityOf(card));
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
        return !card.getText().isEmpty();
    }
}
