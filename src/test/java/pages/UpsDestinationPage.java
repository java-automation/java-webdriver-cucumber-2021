package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static support.TestContext.getDriver;

public class UpsDestinationPage extends Page {
    //constructor
    public UpsDestinationPage() {
        url = "https://www.ups.com/ship/guided/destination?tx=24968987274335228&loc=en_US";
    }

    @FindBy(id = "origin_showSummaryAddress")
    private WebElement resultContainer;

    @FindBy(id = "nbsAddressClassificationContinue")
    private WebElement continueButtonInWindow;

    @FindBy(xpath = "//common-switch[@controlid='vm.residentialAddressControlId']/label/span")
    private WebElement switcher;

    public String getResultContainerTextInfo() { //возвращает String
        new WebDriverWait(getDriver(), 3).until(ExpectedConditions.visibilityOf(resultContainer));
        return resultContainer.getText();
    }

    public void switchTheResidentialAddress(String option) throws Exception {
        new WebDriverWait(getDriver(), 3).until(ExpectedConditions.visibilityOf(continueButtonInWindow));
        switch(option) {
            case "confirm":
                switcher.click();
                break;
            case "dismiss":
                break;
            default:
                throw new Exception("Unknown action: " + option);
        }
        continueButtonInWindow.click();
    }





}
