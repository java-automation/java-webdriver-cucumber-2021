package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UpsOptions extends Page {

    public UpsOptions() {
        url = "https://www.ups.com/ship/guided/options";
    }

    @FindBy(xpath = "//section/h2")
    private WebElement sectionHeader;

    public WebElement getSectionHeader() {
        return sectionHeader;
    }
}
