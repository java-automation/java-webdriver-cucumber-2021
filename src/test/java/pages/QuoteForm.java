package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class QuoteForm extends Page {

    //constructor
    public QuoteForm() {

        url = "https://skryabin.com/market/quote.html";
        title = "Get a Quote";
    }


    //fields


    @FindBy(xpath = "//input[@name='username']")
    private WebElement username;
    @FindBy(xpath = "//label[@id='username-error']")
    private List<WebElement> usernameError;

    @FindBy(xpath = "//input[@name='email']")
    private WebElement email;
    @FindBy(xpath = "//label[@id='email-error']")
    private List<WebElement> emailError;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement password;
    @FindBy(xpath = "//label[@id='password-error']")
    private List<WebElement> passwordError;


    @FindBy(xpath = "//input[@name='confirmPassword']")
    private WebElement confirmPassword;

    @FindBy(xpath = "//input[@id='name']")
    private WebElement name;
    @FindBy(xpath = "//label[@id='name-error']")
    private List<WebElement> nameError;

    @FindBy(xpath = "//input[@name='agreedToPrivacyPolicy']")
    private WebElement privacyPolicy;
    @FindBy(xpath = " //label[@id='agreedToPrivacyPolicy-error']")
    private List<WebElement> privacyPolicyError;

    @FindBy(xpath = "//input[@id='firstName']")
    private WebElement firstName;


    @FindBy(xpath = "//input[@id='middleName']")
    private WebElement middleName;

    @FindBy(xpath = "//input[@id='lastName']")
    private WebElement lastName;

    @FindBy(xpath = "//span[text()='Save']")
    private WebElement save;


    @FindBy(id = "formSubmit")
    private WebElement submitButton;

    @FindBy(name = "countryOfOrigin")
    private WebElement country;

    //dateOfBirth
    @FindBy(xpath = "//input[@id='dateOfBirth']")
    private WebElement dateOfBirthField;
    //year
    @FindBy(xpath = "//select[@data-handler='selectYear']/option[@value='1991']")
    private WebElement year;

    //month
    @FindBy(xpath = "//select[@data-handler='selectMonth']/option[@value='8']")
    private WebElement month;

    @FindBy(xpath = "//input[@name='phone']")
    private WebElement phone;

    @FindBy(xpath = "//input[@value='male']")
    private WebElement genderMale;

    @FindBy(xpath = "//textarea[@id='address']")
    private WebElement address;

    @FindBy(xpath = "//input[@name='allowedToContact']")
    private WebElement allowToContact;

    @FindBy(xpath = "//button[@id='thirdPartyButton']")
    private WebElement thirdPartyAgreement;

    //methods
    public void open(String page) {

        switch (page) {
            case "quote" -> getDriver().get("https://skryabin.com/market/quote.html");
        }

    }

    public void fillUsername(String value) {
        username.sendKeys(value);
    }

    public void fillEmail(String value) {
        email.sendKeys(value);
    }

    public void fillPassword(String value) {
        password.sendKeys(value);
        confirmPassword.sendKeys(value);
    }

    public void fillFirstAndLastName(String firstNameValue, String lastNameValue) {
        name.click();
        firstName.sendKeys(firstNameValue);
        lastName.sendKeys(lastNameValue);

    }

    public void fillName(String firstNameValue, String lastNameValue) {
        fillFirstAndLastName(firstNameValue, lastNameValue);
        save.click();

    }

    public void fillName(String firstNameValue, String middleNameValue, String lastNameValue) {
        fillFirstAndLastName(firstNameValue, lastNameValue);
        middleName.sendKeys(middleNameValue);
        save.click();
    }

    public void acceptPrivacyPolicy() {
        if (!privacyPolicy.isSelected()) {
            privacyPolicy.click();
        }
    }

    public void declinePrivacyPolicy() {
        if (privacyPolicy.isSelected()) {
            privacyPolicy.click();
        }
    }

    public void fillCountryOfOrigin(String value) {
        Select selectCountry = new Select(country);
        selectCountry.selectByValue(value);
    }

    public void fillPhone(String value) {
        phone.sendKeys(value);
    }

    public void fillGender() {
        genderMale.click();
    }

    public void fillAddress(String value) {
        address.sendKeys(value);
    }

    public void selectAllowToContact() {
        allowToContact.click();
    }

    public void selectAgreement() {
        thirdPartyAgreement.click();
        getDriver().switchTo().alert().accept();
    }

    public void fillDateOfBirth() {
        dateOfBirthField.click();

        year.click();
        month.click();
        //day
        getDriver().findElement(By.xpath("//a[contains(text(),'30')]")).click();

//        Select selectYear= new Select(year);
//        selectYear.selectByValue(yearValue);
//        Select selectMonth = new Select(month);
//        selectMonth.selectByValue(monthValue);
//        getDriver().findElement(By.xpath("//a[contains(text(),'30')]")).click();


//        getDriver().findElement(By.xpath("//select[@data-handler='selectMonth']/option[@value='8']")).click();
//        Select year = new Select(getDriver().findElement(By.xpath("//select[@data-handler='selectYear']")));
//        year.selectByValue("1991");
//        getDriver().findElement(By.xpath("//a[contains(text(),'30')]")).click();

    }

    public void submit() {
        submitButton.click();
    }

    public WebElement fieldErrorText(String field) {
        return getDriver().findElement(By.xpath("//label[@id='" + field + "-error']"));

    }

    public void filloutField(String field, String text) {
        getDriver().findElement(By.xpath("//input[@name='" + field + "']")).sendKeys(text);
    }

    public WebElement field(String field) {
        return getDriver().findElement(By.xpath("//input[@name='" + field + "']"));
    }

//
//    public void errorNotPresent(String errorReference) {
//        switch (errorReference) {
//            case "username" -> checkErrorNotThere(usernameError);
//            default -> throw new Error("unknown reference");
//
//        }
//    }
//
//    private void checkErrorNotThere(WebElement usernameError) {
//        //to do
//    }


    public boolean isUsernameErrorVisible() {
        return isErrorVisible(usernameError);
    }

    public boolean isEmailErrorVisible() {
        return isErrorVisible(emailError);
    }

    public boolean isNameErrorVisible() {
        return isErrorVisible(nameError);
    }

    public boolean isPasswordErrorVisible() {
        return isErrorVisible(passwordError);
    }

    public boolean isPrivacyPolicyErrorVisible() {
        return isErrorVisible(privacyPolicyError);
    }

    private boolean isErrorVisible(List<WebElement> errorElement) {
        return errorElement
                .stream()
                .findFirst()
                .filter(WebElement::isDisplayed)
                .isPresent();
    }

    public String getUsernameErrorText() {
        return getErrorText(usernameError, "Username");
    }

    private String getErrorText(List<WebElement> errorElement, String elementName) {
        return errorElement
                .stream()
                .findFirst()
                .filter(WebElement::isDisplayed)
                .orElseThrow(() -> new Error(elementName + " error element does not exist or is not visible!"))
                .getText();
    }
}
