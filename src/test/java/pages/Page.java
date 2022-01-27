package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import static support.TestContext.getDriver;

public class Page {

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
}
