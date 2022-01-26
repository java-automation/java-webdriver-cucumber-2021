package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class QuoteResult extends Page {

    public QuoteResult() {
        setUrl("https://skryabin.com/market/quote.html");
        setTitle("Get a Quote");
    }

    private final String resultContainerXPath = "//*[@id='quotePageResult']";


    @FindBy(xpath = resultContainerXPath)
    private WebElement resultContainer;

    // +++ REQUIRED +++
    @FindBy(xpath = resultContainerXPath + "//*[@name='username']")
    private WebElement username;

    @FindBy(xpath = resultContainerXPath + "//*[@name='email']")
    private WebElement email;

    @FindBy(xpath = resultContainerXPath + "//*[@name='password']")
    private WebElement password;

    @FindBy(xpath = resultContainerXPath + "//*[@name='name']")
    private WebElement name;

    @FindBy(xpath = resultContainerXPath + "//*[@name='firstName']")
    private WebElement firstName;

    @FindBy(xpath = resultContainerXPath + "//*[@name='middleName']")
    private WebElement middleName;

    @FindBy(xpath = resultContainerXPath + "//*[@name='lastName']")
    private WebElement lastName;

    @FindBy(xpath = resultContainerXPath + "//*[@name='agreedToPrivacyPolicy']")
    private WebElement privacyPolicy;

    @FindBy(xpath = resultContainerXPath + "//button[@id='return']")
    private WebElement returnButton;

    // +++ OPTIONAL +++
    @FindBy(xpath = resultContainerXPath + "//*[@name='phone']")
    private WebElement phone;

    @FindBy(xpath = resultContainerXPath + "//*[@name='dateOfBirth']")
    private WebElement dateOfBirth;

    @FindBy(xpath = resultContainerXPath + "//*[@name='countryOfOrigin']")
    private WebElement country;

    @FindBy(xpath = resultContainerXPath + "//*[@name='gender']")
    private WebElement gender;

    @FindBy(xpath = resultContainerXPath + "//*[@name='allowedToContact']")
    private WebElement allowedToContact;

    @FindBy(xpath = resultContainerXPath + "//*[@name='address']")
    private WebElement address;

    @FindBy(xpath = resultContainerXPath + "//*[@name='carMake']")
    private WebElement carMake;

    @FindBy(xpath = resultContainerXPath + "//*[@name='contactPersonName']")
    private WebElement contactName;

    @FindBy(xpath = resultContainerXPath + "//*[@name='contactPersonPhone']")
    private WebElement contactPhone;

    @FindBy(xpath = resultContainerXPath + "//*[@name='thirdPartyAgreement']")
    private WebElement thirdPartyAgreement;

    @FindBy(xpath = resultContainerXPath + "//*[@name='attachmentName']")
    private WebElement attachment;

    public String getResultContainerText() {
        return resultContainer.getText();
    }

    public String getUsername() {
        return username.getText();
    }

    public String getEmail() {
        return email.getText();
    }

    public String getPassword() {
        return password.getText();
    }

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

    public boolean isAcceptedPrivacyPolicy() {
        return Boolean.parseBoolean(privacyPolicy.getText());
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

    public boolean isAllowedToContact() {
        return Boolean.parseBoolean(allowedToContact.getText());
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
