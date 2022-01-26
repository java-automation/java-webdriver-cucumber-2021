package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static support.TestContext.getDriver;

public class SubmitedInfoQuoteForm {

    // constructor
    public SubmitedInfoQuoteForm() {
        PageFactory.initElements(getDriver(), this);
    }

    // fields
    private String url = "https://skryabin.com/market/quote.html";

    @FindBy(xpath = "//div[@id='quotePageResult']")
    private WebElement resultText;

    @FindBy(xpath = "//b[@name='agreedToPrivacyPolicy']")
    private WebElement agreed;

    @FindBy(xpath = "//b[@name='password']")
    private WebElement password;

    //methods
    public void open() {
        getDriver().get(url);
    }

    public String getSubmittedFormData() {
        return resultText.getText();
    }

    public String getAgreedToPrivacyPolicy() {
        return agreed.getText();
    }
}








