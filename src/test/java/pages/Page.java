package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static support.TestContext.*;

public class Page {

    private String url;
    private String title;

    public Page() {
        PageFactory.initElements(getDriver(), this);
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

    public List<LogEntry> getLogs(String type) {
        return getDriver().manage().logs().get(type).getAll();
    }

    public void scrollToElementWithOffset(WebElement element, int offset) {
        getExecutor().executeScript("arguments[0].scrollIntoView(false);", element);
        getExecutor().executeScript("window.scrollBy(0, " + offset + ");", element);
    }

    public void waitForAjaxToComplete()
    {
        getWait().until(driver -> getExecutor().executeScript("return (window.jQuery != null) && (jQuery.active === 0);"));
    }
}
