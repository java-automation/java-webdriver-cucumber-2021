package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static support.TestContext.getConfig;
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

    public WebDriverWait getWait() {
        return new WebDriverWait(getDriver(), getConfig().explicitTimeout);
    }

    public void clickWithJS(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].click();", element);
    }

}