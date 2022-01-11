package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class QuoteResults extends QuoteForm {

    private final String resultsFrame = "//*[@id='quotePageResult']";


    // +++ REQUIRED +++
    @FindBy(xpath = resultsFrame + "//*[@name='username']")
    private WebElement username;

    @FindBy(xpath = resultsFrame + "//*[@name='email']")
    private WebElement email;

    @FindBy(xpath = resultsFrame + "//*[@name='password']")
    private WebElement password;

    @FindBy(xpath = resultsFrame + "//*[@name='name']")
    private WebElement name;

    @FindBy(xpath = resultsFrame + "//*[@name='firstName']")
    private WebElement firstName;

    @FindBy(xpath = resultsFrame + "//*[@name='middleName']")
    private WebElement middleName;

    @FindBy(xpath = resultsFrame + "//*[@name='lastName']")
    private WebElement lastName;

    @FindBy(xpath = resultsFrame + "//*[@name='agreedToPrivacyPolicy']")
    private WebElement privacyPolicy;

    @FindBy(xpath = resultsFrame + "//button[@id='return']")
    private WebElement returnButton;

    // +++ OPTIONAL +++
    @FindBy(xpath = resultsFrame + "//*[@name='phone']")
    private WebElement phone;

    @FindBy(xpath = resultsFrame + "//*[@name='dateOfBirth']")
    private WebElement dateOfBirth;

    @FindBy(xpath = resultsFrame + "//*[@name='countryOfOrigin']")
    private WebElement country;

    @FindBy(xpath = resultsFrame + "//*[@name='gender']")
    private WebElement gender;

    @FindBy(xpath = resultsFrame + "//*[@name='allowedToContact']")
    private WebElement allowedToContact;

    @FindBy(xpath = resultsFrame + "//*[@name='address']")
    private WebElement address;

    @FindBy(xpath = resultsFrame + "//*[@name='carMake']")
    private WebElement carMake;

    @FindBy(xpath = resultsFrame + "//*[@name='contactPersonName']")
    private WebElement contactName;

    @FindBy(xpath = resultsFrame + "//*[@name='contactPersonPhone']")
    private WebElement contactPhone;

    @FindBy(xpath = resultsFrame + "//*[@name='thirdPartyAgreement']")
    private WebElement thirdPartyAgreement;

    @FindBy(xpath = resultsFrame + "//*[@name='attachmentName']")
    private WebElement attachment;


    public String getUsername() {
        return username.getText();
    }

    public String getEmail() {
        return email.getText();
    }

    public String getPassword() {
        return password.getText();
    }

    @Override
    public String getName() {
        return name.getText();
    }

    public String getFirstName() {
        return firstName.getText();
    }

    public String getMiddleName() {
        return middleName.getText();
    }

    public String getLastName() {
        return lastName.getText();
    }

    public String getPrivacyPolicy() {
        return privacyPolicy.getText();
    }

    public void returnToQuoteForm() {
        returnButton.click();
    }

    public String getPhone() {
        return phone.getText();
    }

    public String getDateOfBirth() {
        return dateOfBirth.getText();
    }

    public String getCountry() {
        return country.getText();
    }

    public String getGender() {
        return gender.getText();
    }

    public String getAllowedToContact() {
        return allowedToContact.getText();
    }

    public String getAddress() {
        return address.getText();
    }

    public String getCarMake() {
        return carMake.getText();
    }

    public String getContactName() {
        return contactName.getText();
    }

    public String getContactPhone() {
        return contactPhone.getText();
    }

    public String getThirdPartyAgreement() {
        return thirdPartyAgreement.getText();
    }

    public String getAttachmentName() {
        return attachment.getText();
    }
}
