package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static support.TestContext.getDriver;

public class QuoteForm extends QuotePage {

    public QuoteForm() {
        setURL("https://skryabin.com/market/quote.html");
        setTitle("Get a Quote");
    }

    // +++ REQUIRED +++
    @FindBy(xpath = "//input[@name='username']")
    private WebElement username;

    @FindBy(id = "username-error")
    private List<WebElement> usernameError;

    @FindBy(xpath = "//input[@name='email']")
    private WebElement email;

    @FindBy(id = "email-error")
    private List<WebElement> emailError;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement password;

    @FindBy(id = "password-error")
    private List<WebElement> passwordError;

    @FindBy(xpath = "//input[@name='confirmPassword']")
    private WebElement confirmPassword;

    @FindBy(id = "confirmPassword-error")
    private List<WebElement> confirmPasswordError;

    @FindBy(xpath = "//input[@id='name']")
    private WebElement name;

    @FindBy(id = "name-error")
    private List<WebElement> nameError;


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

    @FindBy(id = "agreedToPrivacyPolicy-error")
    private List<WebElement> privacyPolicyError;

    @FindBy(id = "formSubmit")
    private WebElement submitButton;


    // +++ OPTIONAL +++
    @FindBy(xpath = "//input[@name='phone']")
    private WebElement phone;


    //date picker ->
    @FindBy(xpath = "//input[@name='dateOfBirth']")
    private WebElement datePicker;

    @FindBy(xpath = "//*[@id='ui-datepicker-div']//select[@data-handler='selectYear']")
    private WebElement datePickerYear;

    @FindBy(xpath = "//*[@id='ui-datepicker-div']//select[@data-handler='selectMonth']")
    private WebElement datePickerMonth;

    @FindBy(xpath = "//*[@id='ui-datepicker-div']//td[@data-handler='selectDay']")
    private List<WebElement> datePickerDays;
    // <- date picker


    @FindBy(xpath = "//select[@name='countryOfOrigin']")
    private WebElement country;

    @FindBy(xpath = "//input[@name='gender'][@value='male']")
    private WebElement genderMale;

    @FindBy(xpath = "//input[@name='gender'][@value='female']")
    private WebElement genderFemale;

    @FindBy(xpath = "//input[@name='allowedToContact']")
    private WebElement allowedToContact;

    @FindBy(xpath = "//textarea[@name='address']")
    private WebElement address;

    @FindBy(xpath = "//select[@name='carMake']")
    private WebElement carMake;


    //additional info iframe ->
    @FindBy(name = "additionalInfo")
    private WebElement iframe;

    @FindBy(xpath = "//input[@id='contactPersonName']")
    private WebElement contactName;

    @FindBy(xpath = "//input[@id='contactPersonPhone']")
    private WebElement contactPhone;
    // <- additional info iframe


    @FindBy(id = "thirdPartyButton")
    private WebElement thirdPartyButton;

    @FindBy(xpath = "//input[@name='attachment']")
    private WebElement attachmentButton;


    public void fillUsername(String value) {
        username.clear();
        username.sendKeys(value);
    }

    public boolean isUsernameErrorVisible() {
        return isErrorVisible(usernameError);
    }

    public String getUsernameErrorText() {
        return getErrorText(usernameError, "Username");
    }

    public void fillEmail(String value) {
        email.clear();
        email.sendKeys(value);
    }

    public String getEmail() {
        return email.getAttribute("value");
    }

    public boolean isEmailErrorVisible() {
        return isErrorVisible(emailError);
    }

    public String getEmailErrorText() {
        return getErrorText(emailError, "Email");
    }

    public void fillPasswords(String value) {
        password.clear();
        password.sendKeys(value);
        confirmPassword.clear();
        confirmPassword.sendKeys(value);
    }

    public void fillPassword(String value) {
        password.clear();
        password.sendKeys(value);
    }

    public boolean isPasswordErrorVisible() {
        return isErrorVisible(passwordError);
    }

    public String getPasswordErrorText() {
        return getErrorText(passwordError, "Password");
    }

    public void fillConfirmPassword(String value) {
        confirmPassword.clear();
        confirmPassword.sendKeys(value);
    }

    public boolean isConfirmPasswordErrorVisible() {
        return isErrorVisible(confirmPasswordError);
    }

    public String getConfirmPasswordErrorText() {
        return getErrorText(confirmPasswordError, "Confirm password");
    }

    public void fillName(String firstNameValue, String lastNameValue) {
        fillFirstAndLastName(firstNameValue, lastNameValue);
        saveButton.click();
    }

    public void fillName(String firstNameValue, String middleNameValue, String lastNameValue) {
        fillFirstAndLastName(firstNameValue, lastNameValue);
        middleName.sendKeys(middleNameValue);
        saveButton.click();
    }

    private void fillFirstAndLastName(String firstNameValue, String lastNameValue) {
        name.click();
        firstName.sendKeys(firstNameValue);
        lastName.sendKeys(lastNameValue);
    }

    public String getName() {
        return name.getAttribute("value");
    }

    public boolean isNameErrorVisible() {
        return isErrorVisible(nameError);
    }

    public String getNameErrorText() {
        return getErrorText(nameError, "Name");
    }

    public void acceptPrivacyPolicy() {
        if (!privacyPolicy.isSelected()) privacyPolicy.click();
    }

    public void declinePrivacyPolicy() {
        if (privacyPolicy.isSelected()) privacyPolicy.click();
    }

    public boolean isPrivacyPolicyErrorVisible() {
        return isErrorVisible(privacyPolicyError);
    }

    public String getPrivacyPolicyErrorText() {
        return getErrorText(privacyPolicyError, "Privacy policy");
    }

    public void submit() {
        submitButton.click();
    }

    public void fillPhone(String value) {
        phone.clear();
        phone.sendKeys(value);
    }

    public void fillDateOfBirth(String year, String month, String day) {
        datePicker.click();
        new Select(datePickerYear).selectByValue(year);
        new Select(datePickerMonth).selectByValue(String.valueOf(Integer.parseInt(month) - 1));
        datePickerDays.get(Integer.parseInt(day) - 1).click();
    }

    public void selectCountry(String value) {
        new Select(country).selectByValue(value);
    }

    public void selectGender(String value) {
        if (value.equals("male")) genderMale.click();
        else if (value.equals("female")) genderFemale.click();
    }

    public void allowToContact() {
        if (!allowedToContact.isSelected()) allowedToContact.click();
    }

    public void disallowToContact() {
        if (allowedToContact.isSelected()) allowedToContact.click();
    }

    public void fillAddress(String value) {
        address.clear();
        address.sendKeys(value);
    }

    public void selectCarMakes(String[] values) {
        Select carMakeSelect = new Select(carMake);
        for (String carMake : values) carMakeSelect.selectByValue(carMake);
    }

    public void fillAdditionalInfo(String contactNameValue, String contactPhoneValue) {
        getDriver().switchTo().frame(iframe);
        contactName.clear();
        contactName.sendKeys(contactNameValue);
        contactPhone.clear();
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

    private boolean isErrorVisible(List<WebElement> errorElement) {
        return errorElement
                .stream()
                .findFirst()
                .filter(WebElement::isDisplayed)
                .isPresent();
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
