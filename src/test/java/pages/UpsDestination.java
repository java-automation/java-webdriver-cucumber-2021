package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UpsDestination extends Page {

    public UpsDestination() {
        url = "https://www.ups.com/ship/guided/destination";
    }

    @FindBy(id = "origin_showSummaryAddress")
    private WebElement resultContainer;

    public String getResultSummary() {
        return resultContainer.getText();
    }

}
