package pages;

import org.openqa.selenium.support.PageFactory;

import static support.TestContext.getDriver;

public class QuotePage {

    private String url;
    private String title;

    public QuotePage() {
        PageFactory.initElements(getDriver(), this);
    }

    public void open() {
        getDriver().get(getURL());
    }

    public void refresh() {
        getDriver().navigate().refresh();
    }

    public String getURL() {
        return url;
    }

    public void setURL(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
