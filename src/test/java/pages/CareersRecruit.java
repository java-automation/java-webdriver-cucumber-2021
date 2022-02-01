package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static support.TestContext.getActions;
import static support.TestContext.getDriver;

public class CareersRecruit extends CareersHome {

    public CareersRecruit() {
        setUrl("https://skryabin-careers.herokuapp.com/recruit");
        setTitle("Careers Portal");
    }

    private String getPositionCardXPathByTitle(String title) {
        return "//h4[@class='card-title'][normalize-space(.)='" + title + "']/ancestor::div[contains(@class,'card') and not(contains(@class,'body'))]";
    }

    private WebElement getPositionCard(String title) {
        return getDriver().findElement(By.xpath(getPositionCardXPathByTitle(title)));
    }

    private WebElement getPositionCardCloseButton(String title) {
        return getDriver().findElement(By.xpath(getPositionCardXPathByTitle(title) + "//button"));
    }

    public void removePosition(String positionTitle) {
        WebElement card = getPositionCard(positionTitle);
        getActions().moveToElement(card).perform();
        getWait().until(ExpectedConditions.elementToBeClickable(getPositionCardCloseButton(positionTitle))).click();
        getWait().until(ExpectedConditions.invisibilityOf(card));
    }

    public boolean isPositionVisible(String positionTitle) {
        try {
            return getPositionCard(positionTitle).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
