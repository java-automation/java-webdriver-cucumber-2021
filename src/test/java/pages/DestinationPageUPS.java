package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static support.TestContext.getDriver;

public class DestinationPageUPS {

    public DestinationPageUPS() {
        String url = "https://www.ups.com/ship/guided/destination";

        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(xpath = "//div[@id='origin_showSummaryAddress']")
    private WebElement resultOfSender;

    @FindBy(xpath = "//input[@id='destination-cac_companyOrName']")
    private WebElement recipientName;

    @FindBy(xpath = "//input[@id='destination-cac_singleLineAddress']")
    private WebElement destinationAddress;

    @FindBy(css = ".ngb-highlight")
    private WebElement suggestionHighlight;

    @FindBy(xpath = "//input[@id='destination-cac_email']")
    private WebElement email;

    @FindBy(xpath = "//input[@id='destination-cac_phone']")
    private WebElement phone;


    public void fillAddress(String value) throws InterruptedException {

        destinationAddress.sendKeys(value);
        Thread.sleep(2000);
        suggestionHighlight.click();
    }

    public void fillCompanyOrName(String value) {
        recipientName.sendKeys(value);
    }

    public void fillEmail(String value){
        email.sendKeys(value);
    }

    public void fillPhone(String value){
        phone.sendKeys(value);
    }
    public String getResultSummary() {
        return resultOfSender.getText();

    }
}






