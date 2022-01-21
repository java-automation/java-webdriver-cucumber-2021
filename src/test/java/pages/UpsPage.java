package pages;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static support.TestContext.getDriver;

public class UpsPage {

    private String url;
    private String title;

    private final WebDriverWait wait;

    public UpsPage() {
        PageFactory.initElements(getDriver(), this);
        wait = new WebDriverWait(getDriver(), 3);
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
}
