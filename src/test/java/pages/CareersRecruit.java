package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static support.TestContext.*;

public class CareersRecruit extends CareersHome {

    public CareersRecruit() {
        setUrl("https://skryabin-careers.herokuapp.com/recruit");
        setTitle("Careers Portal");
    }

    @FindBy(xpath = "//a[@href='/candidates']/h4")
    private WebElement listCandidatesLink;

    @FindBy(xpath = "//a[@href='/new_position']/h4")
    private WebElement createPositionLink;

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

    public void clickNewPosition() {
        createPositionLink.click();
    }
}
