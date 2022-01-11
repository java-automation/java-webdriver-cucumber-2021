package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import static support.TestContext.getDriver;

public class QuoteForm {

    private String url = "https://skryabin.com/market/quote.html";

    //required
    @FindBy(xpath = "//input[@name='username']")
    private WebElement username;

    @FindBy(xpath = "//input[@name='email']")
    private WebElement email;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement password;

    @FindBy(xpath = "//input[@name='confirmPassword']")
    private WebElement confirmPassword;

    @FindBy(xpath = "//input[@id='name']")
    private WebElement name;

    //name modal dialog ->
    @FindBy(xpath = "//input[@id='firstName']")
    private WebElement firstName;

    @FindBy(xpath = "//input[@id='middleName']")
    private WebElement middleName;

    @FindBy(xpath = "//input[@id='lastName']")
    private WebElement lastName;

    @FindBy(xpath = "//*[@id='nameDialog']/..//*[text()='Save']")
    private WebElement saveButton;
    // <- name modal dialog

    @FindBy(xpath = "//input[@name='agreedToPrivacyPolicy']")
    private WebElement privacyPolicy;

    @FindBy(id = "formSubmit")
    private WebElement submitButton;

    //optional
    @FindBy(xpath = "//input[@name='phone']")
    private WebElement phone;

    //date picker ->
    @FindBy(xpath = "//input[@name='dateOfBirth']")
    private WebElement datePicker;

    @FindBy(xpath = "//*[@id='ui-datepicker-div']//select[@data-handler='selectYear']")
    private WebElement datePickerYear;

    @FindBy(xpath = "//*[@id='ui-datepicker-div']//select[@data-handler='selectMonth']")
    private WebElement datePickerMonth;

    private final String datePickerDay = "//*[@id='ui-datepicker-div']//td[@data-handler='selectDay']";
    // <- date picker

    @FindBy(xpath = "//select[@name='countryOfOrigin']")
    private WebElement country;

    private final String gender = "//input[@name='gender']";

    @FindBy(xpath = "//input[@name='allowedToContact']")
    private WebElement allowedToContact;

    @FindBy(xpath = "//textarea[@name='address']")
    private WebElement address;

    @FindBy(xpath = "//select[@name='carMake']")
    private WebElement carMake;

    //additional info iframe ->
    private final String iframe = "additionalInfo";

    @FindBy(xpath = "//input[@id='contactPersonName']")
    private WebElement contactName;

    @FindBy(xpath = "//input[@id='contactPersonPhone']")
    private WebElement contactPhone;
    // <- additional info iframe

    @FindBy(id = "thirdPartyButton")
    private WebElement thirdPartyButton;

    @FindBy(xpath = "//input[@name='attachment']")
    private WebElement attachmentButton;

    public QuoteForm() {
        PageFactory.initElements(getDriver(), this);
    }

    public void open() {
        getDriver().get(url);
    }

    public void fillUsername(String value) {
        username.sendKeys(value);
    }

    public void fillEmail(String value) {
        email.sendKeys(value);
    }

    public void fillPasswords(String value) {
        password.sendKeys(value);
        confirmPassword.sendKeys(value);
    }

    public void fillName(String firstNameValue, String middleNameValue, String lastNameValue) {
        name.click();
        firstName.sendKeys(firstNameValue);
        middleName.sendKeys(middleNameValue);
        lastName.sendKeys(lastNameValue);
        saveButton.click();
    }

    public String getName() {
        return name.getAttribute("value");
    }

    public void acceptPrivacyPolicy() {
        if (!privacyPolicy.isSelected()) privacyPolicy.click();
    }

    public void declinePrivacyPolicy() {
        if (privacyPolicy.isSelected()) privacyPolicy.click();
    }

    public void submit() {
        submitButton.click();
    }

    public void fillPhone(String value) {
        phone.sendKeys(value);
    }

    public void fillDateOfBirth(String year, String month, String day) throws InterruptedException {
        datePicker.click();
        new Select(datePickerYear).selectByValue(year);
        new Select(datePickerMonth).selectByValue(String.valueOf(Integer.parseInt(month) - 1));
        Thread.sleep(1000);
        getDriver().findElement(By.xpath(datePickerDay + "/a[normalize-space(.)='" + day + "']")).click();
    }

    public void selectCountry(String value) {
        new Select(country).selectByValue(value);
    }

    public void selectGender(String value) {
        getDriver().findElement(By.xpath(gender + "[@value='" + value + "']")).click();
    }

    public void allowToContact() {
        if (!allowedToContact.isSelected()) allowedToContact.click();
    }

    public void disallowToContact() {
        if (allowedToContact.isSelected()) allowedToContact.click();
    }

    public void fillAddress(String value) {
        address.sendKeys(value);
    }

    public void selectCarMakes(String[] values) {
        Select carMakeSelect = new Select(carMake);
        for (String carMake : values) carMakeSelect.selectByValue(carMake);
    }

    public void fillAdditionalInfo(String contactNameValue, String contactPhoneValue) {
        getDriver().switchTo().frame(iframe);
        contactName.sendKeys(contactNameValue);
        contactPhone.sendKeys(contactPhoneValue);
        getDriver().switchTo().defaultContent();
    }

    public void accept3rdPartyAgreement() {
        thirdPartyButton.click();
        getDriver().switchTo().alert().accept();
    }

    public void decline3rdPartyAgreement() {
        thirdPartyButton.click();
        getDriver().switchTo().alert().dismiss();
    }

    public void attachFile(String filePath) {
        attachmentButton.sendKeys(filePath);
    }
}
