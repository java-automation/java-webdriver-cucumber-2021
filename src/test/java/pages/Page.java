package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static support.TestContext.*;

public class Page {

    private String url;
    private String title;

    private final WebDriverWait wait;

    public Page() {
        PageFactory.initElements(getDriver(), this);
        wait = new WebDriverWait(getDriver(), getConfig().getExplicitWait());
    }

    public void open() {
        getDriver().get(getUrl());
    }

    public void refresh() {
        getDriver().navigate().refresh();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public WebDriverWait getWait() {
        return wait;
    }

    public LogEntries getLogs(String type) {
        return getDriver().manage().logs().get(type);
    }

    public void scrollToElementWithOffset(WebElement element, int offset) {
        getExecutor().executeScript("arguments[0].scrollIntoView(false);", element);
        getExecutor().executeScript("window.scrollBy(0, " + offset + ");", element);
    }

    public void waitForAjaxToComplete()
    {
        wait.until(driver -> getExecutor().executeScript("return (window.jQuery != null) && (jQuery.active === 0);"));
    }
}
