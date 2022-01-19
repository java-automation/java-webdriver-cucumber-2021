package pages;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static support.TestContext.getDriver;

public class SubmittedQuote {

    //constructor
    public SubmittedQuote() {
        PageFactory.initElements(getDriver(), this);
    }

    //fields

    @FindBy(xpath = "//b[@name='username']")
    private WebElement username;

    @FindBy(xpath = "//b[@name='email']")
    private WebElement email;

    @FindBy(xpath = "//b[@name='name']")
    private WebElement name;

    @FindBy(xpath = "//div[@id='quotePageResult']")
    private WebElement block; //the whole block

    //methods
    public void verifyUsername(String value) {
        Assertions.assertThat(username.getText()).isEqualTo(value); //мы берем значение, которое отправилоь сюда из класса QuoteOopStepDefs (resultPage.verifyUsername(user.get("username"));) и используем его как параметр - value
    }

    public void verifyEmail(String value) {
        Assertions.assertThat(email.getText()).isEqualTo(value);
    }

    public void verifyName(String firstNameValue, String lastNameValue) {
        Assertions.assertThat(name.getText()).isEqualTo(firstNameValue + " " + lastNameValue);
    }

    public void verifyPassword(String value) {
        Assertions.assertThat(block.getText()).doesNotContain(value);
    }






}
