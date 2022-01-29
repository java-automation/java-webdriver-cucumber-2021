package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

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
}
