package pages;

import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static support.TestContext.getDriver;
import static support.TestContext.getExecutor;

public class UpsPage {

    private String url;
    private String title;

    private final WebDriverWait wait;
    private final LocalStorage localStorage;

    public UpsPage() {
        PageFactory.initElements(getDriver(), this);
        wait = new WebDriverWait(getDriver(), 5);
        localStorage = ((WebStorage) getDriver()).getLocalStorage();
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

    public void waitForAjaxToComplete()
    {
        wait.until(driver -> getExecutor().executeScript("return (window.jQuery != null) && (jQuery.active === 0);"));
    }

    public LocalStorage getLocalStorage() {
        return localStorage;
    }

    public LogEntries getLogs() {
        return getDriver().manage().logs().get(LogType.PERFORMANCE);
    }
}
