package pages;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;

import static support.TestContext.getDriver;

public class QuoteForm {

    //constructor
    public QuoteForm() {
        PageFactory.initElements(getDriver(), this);
    }

    //fields
   private String url = "https://skryabin.com/market/quote.html";

   @FindBy(xpath = "//input[@name='username']")
   private WebElement username; //= getDriver().findElement(By.xpath("//input[@name='username']"));

    @FindBy(xpath = "//input[@name='email']")
    private WebElement email;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement password;

    @FindBy(xpath = "//input[@name='confirmPassword']")
    private WebElement confirmPassword;

    @FindBy(xpath = "//input[@name='agreedToPrivacyPolicy']")
    private WebElement privacyPolicy;

    @FindBy(xpath = "//input[@name='name']") //поле name, нажав на которое откроется доп окно ввода
    private WebElement name;

    //name window
    @FindBy(xpath = "//input[@name='firstName']")
    private WebElement firstname;

    @FindBy(xpath = "//input[@name='middleName']")
    private WebElement middlename;

    @FindBy(xpath = "//input[@name='lastName']")
    private WebElement lastname;

    @FindBy(xpath = "//span[text()='Save']") //save button в окне, где вводили имя
    private WebElement saveButton;


    @FindBy(xpath = "//button[@id='formSubmit']")
    private WebElement submit;

    //methods
    public void open() {
        getDriver().get(url);
    }

    public void fillUsername(String value) {
        username.clear();
        username.sendKeys(value);
    }

    public void fillEmail(String value) {
        email.clear();
        email.sendKeys(value);
    }

    public void fillPasswordFields(String value) {
        password.clear();
        password.sendKeys(value);
        confirmPassword.clear();
        confirmPassword.sendKeys(value);
    }

    public void fillPasswordField(String value) {
        password.clear();
        password.sendKeys(value);
    }

    public void fillConfirmPasswordField(String value) {
        confirmPassword.clear();
        confirmPassword.sendKeys(value);
    }

    public void fillName(String firstNameValue, String lastNameValue) {
        name.click();

        firstname.clear();
        firstname.sendKeys(firstNameValue);

        lastname.clear();
        lastname.sendKeys(lastNameValue);

        saveButton.click();
    }

    public void fillName(String firstNameValue, String middleNameValue, String lastNameValue) {
        name.click();

        firstname.clear();
        firstname.sendKeys(firstNameValue);

        middlename.clear();
        middlename.sendKeys(firstNameValue);

        lastname.clear();
        lastname.sendKeys(lastNameValue);

        saveButton.click();
    }

    public void acceptPrivacyPolicy() {
        if(!privacyPolicy.isSelected()) {
            privacyPolicy.click();
        }
    }

    public void submit() {
        submit.click();
    }

    public void verifyFieldValue(String field, String value) {
        Assertions.assertThat(getDriver().findElement(By.xpath("//input[@name='" + field + "']")).getText()).isEqualTo(value);
    }


    //Methods For Error Messages
    public void errorMessageIsNotVisible(String field) {
//        Assertions.assertThat(getDriver().findElement(By.xpath("//label[@id='name-error']")).getText()).hasSize(0);
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), 0,5);
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//label[@id='" + field + "-error']"))); //ждем появления всех элементов
        } catch(TimeoutException exception) {
            System.out.println("Element is not visible: " + field); //если этого не происходит, ловим exception, чтобы программа проверяла дальше, а не fail весь сценарий
        }
    }

    public void errorMessageIsVisible(String field, String message) {
        Assertions.assertThat(getDriver().findElement(By.xpath("//label[@id='" + field + "-error']")).getText()).isEqualTo(message);
    }
}
