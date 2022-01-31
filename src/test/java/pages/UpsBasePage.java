package pages;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.function.Supplier;
import static support.TestContext.getConfig;
import static support.TestContext.getDriver;

public class UpsBasePage {

    protected String url;
    protected String urlRegExp;

    protected WebDriverWait wait = new WebDriverWait(getDriver(),getConfig().getExplicitTimeOut(),200);

    // constructor
    public UpsBasePage() {
        PageFactory.initElements(getDriver(), this);
    }

    // fields
    @FindBy(css=".close_btn_thick")
    private List<WebElement> closeBanner;

    // methods
    public void open() {
        getDriver().get(url);
    }

    public boolean urlMatches() {
        return getDriver().getCurrentUrl().matches(urlRegExp);
    }

    public void waitForUrlMatch() {
        wait.withMessage("Did not jump to " + getClass() + " page.").until(driver -> urlMatches());
        wait.withMessage((Supplier<String>) null);
    }

    public void refreshPage() {
        getDriver().navigate().refresh();
    }

    public void closeCookiesDialogIfDisplayed() {
        closeBanner.stream()
                   .findFirst()
                   .filter(WebElement::isDisplayed)
                   .ifPresent(WebElement::click);
    }

    public void clickTryThenJS(WebElement button){
        try {
            button.click();
        } catch (ElementClickInterceptedException e) {
            ((JavascriptExecutor)getDriver()).executeScript("arguments[0].scrollIntoView({" +
                    "behavior: 'auto',block: 'center',inline: 'center'});", button);
            button.click();
        }
    }

    public void clickWithJS(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].click();", element);
    }
}
