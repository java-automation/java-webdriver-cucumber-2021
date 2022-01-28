package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;

import static support.TestContext.getDriver;

public class Page {

    public static final By TOTAL_PRICE_BAR_HEADER = By.xpath("//div[@id='nbsBalanceBarHeader']");
    public final WebDriverWait wait = new WebDriverWait(getDriver(), 10, 200);
    public final By CONTINUE_BUTTON_XPATH = By.xpath("//button[@id='nbsBackForwardNavigationContinueButton']");
    public final By PACKAGE_SECTION_XPATH = By.id("nbsShipmentPackagesPackage0");

    /*  public final By CHEAPEST_PRICE_SELECT = By.xpath("//div[@id='Cheapest']//span[@class='serviceCard_header-icon ups-icon-checkcircle-solid']");
  /*  @FindBy(id = "nbsBackForwardNavigationContinueButton")
     public WebElement continueButton;*/
    protected String url;
    protected String title;

    // constructor
    public Page() {
        PageFactory.initElements(getDriver(), this);
    }

    //methods
    public void open() {
        getDriver().get(url);
    }

    public void refreshPage() {
        getDriver().navigate().refresh();
    }

    public boolean isPresent(By locator) {
        return getDriver().findElements(locator).size() > 0;
    }

    public boolean isVisible(By locator) {
        if (getDriver().findElements(locator).size() > 0) {
            return getDriver().findElement(locator).isDisplayed();
        } else return false;
    }
/*
    public void submit() {
        wait.until(ExpectedConditions.presenceOfElementLocated(CONTINUE_BUTTON_XPATH)).click();
    }*/

    public boolean isWebElementPresent(WebElement el) {
        try {
            wait.until(ExpectedConditions.visibilityOf(el));
            return el.isDisplayed();
        } catch (NoSuchElementException | TimeoutException exception) {
            return false;
        }
    }
}
