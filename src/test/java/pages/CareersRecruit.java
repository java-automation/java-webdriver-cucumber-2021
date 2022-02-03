package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class CareersRecruit extends CareersHome {

    public CareersRecruit(){
        url = "https://skryabin-careers.herokuapp.com/recruit";
        urlRegExp = "https://skryabin-careers.herokuapp.com/recruit";
    }

    @FindBy(xpath = "//div[contains(@class,'card']")
    private List<WebElement> cards;

    @FindBy(xpath = "//a[contains(@href,'new_position')]")
    private WebElement newPositionButton;

    private WebElement positionCardTitle(String title) {
        return getDriver().findElement(By.xpath("//h4[text()='" + title + "']"));
    }

    private WebElement positionCard(String title) {
//        return positionCardTitle(title).findElement(By.xpath("./ancestor::div[contains(" +
//                                                               "concat(' ',normalize-space(@class),' '),' card ')]"));

        return getDriver().findElement(By.xpath("//h4[text()='" + title + "']/ancestor::div[contains(" +
                "concat(' ',normalize-space(@class),' '),' card ')]"));
    }

    private WebElement positionCardCloseButton(String title) {
        return positionCard(title).findElement(By.xpath(".//button"));
    }

    public void removePositionByTitle(String title) {
        new Actions(getDriver()).moveToElement(positionCard(title)).perform();
        getWait().until(ExpectedConditions.elementToBeClickable(positionCardCloseButton(title)));
        positionCardCloseButton(title).click();
        getWait().until(ExpectedConditions.invisibilityOf(positionCard(title)));
    }

    public boolean isPositionCardVisible(String title) {
        try {
            return positionCard(title).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void createNewPosition() {
        newPositionButton.click();
    }

    public void goToCardDetails(String title) {
        positionCardTitle(title).click();
    }

    public int numberOfPositionCandidates(String title) {
        String cardHeader = positionCard(title).findElement(By.xpath(".//div[contains(@class,'card-header')]")).getText();
        Matcher m = Pattern.compile(".*(\\d+).*").matcher(cardHeader);
        assertThat(m.find()).as("Card header should contain number of candidates for this card's position." +
                                                                                    " Number was not found").isTrue();
        return Integer.parseInt(m.group(1));
    }
}
