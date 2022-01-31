package pages;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static support.TestContext.getDriver;

public class QuoteResult extends Page{
    //constructor
//    public QuoteResult() {
//        PageFactory.initElements(getDriver(), this);
//    }
    //we extracted this constructor to the other class and it is supposed to be deleted here

    //fields
//   private String url = "https://skryabin.com/market/quote.html"; //мы extracted это в другой класс и перенесли присваивание значения в констрактор ниже

    //constructor for parameters
    public QuoteResult() {
        url = "https://skryabin.com/market/quote.html";
        title = "Subbmited result"; //supposed to be a bug
    }

    @FindBy(xpath = "//b[@name='username']")
    private WebElement username;

    @FindBy(xpath = "//b[@name='email']")
    private WebElement email;

    @FindBy(xpath = "//b[@name='name']")
    private WebElement name;

    @FindBy(xpath = "//b[@name='password']")
    private WebElement password;

    @FindBy(xpath = "//b[@name='agreedToPrivacyPolicy']")
    private WebElement agreedToPrivacyPolicy;

    @FindBy(id= "quotePageResult")
    private WebElement resultContainer; //the whole block


    //methods
//    public void open() {
//        getDriver().get(url);
//    }
    //this method is extracted to the other class and it is supposed to be deleted here

//    public void refreshPage() {
//        getDriver().navigate().refresh();
//    }
    //this method is extracted to the other class and it is supposed to be deleted here


    //methods for verification - variant 1
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
        Assertions.assertThat(resultContainer.getText()).doesNotContain(value);
    }

    //methods for verification - variant 2
    public String getResultContainerText() {
        return resultContainer.getText();
    }

    public String getPasswordText() {
        return password.getText();
    }

    public Boolean isAgreedToPrivacyPolicy() {
        return Boolean.parseBoolean(agreedToPrivacyPolicy.getText());
    }
}
