package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class SubmittedQuoteForm {

    public final String OBFUSCATED_PASSWORD = "[entered]";

    // constructor
    public SubmittedQuoteForm() {
        PageFactory.initElements(getDriver(), this);
    }

    // fields
    @FindBy(xpath = "//legend[contains(@class,'applicationResult')]")
    private WebElement title;

    @FindBy(id = "quotePageResult")
    private WebElement pageResult;

    @FindBy(xpath = "//b[@name='username']")
    private WebElement username;

    @FindBy(xpath = "//b[@name='username']/preceding-sibling::span")
    private WebElement usernameLabel;

    @FindBy(xpath = "//b[@name='firstName']")
    private WebElement firstName;

    @FindBy(xpath = "//b[@name='firstName']/preceding-sibling::span")
    private WebElement firstNameLabel;

    @FindBy(xpath = "//b[@name='middleName']")
    private WebElement middleName;

    @FindBy(xpath = "//b[@name='middleName']")
    private List<WebElement> middleNameList;

    @FindBy(xpath = "//b[@name='middleName']/preceding-sibling::span")
    private WebElement middleNameLabel;

    @FindBy(xpath = "//b[@name='lastName']")
    private WebElement lastName;

    @FindBy(xpath = "//b[@name='lastName']")
    private List<WebElement> lastNameList;

    @FindBy(xpath = "//b[@name='lastName']/preceding-sibling::span")
    private WebElement lastNameLabel;

    @FindBy(xpath = "//b[@name='name']")
    private WebElement name;

    @FindBy(xpath = "//b[@name='name']/preceding-sibling::span")
    private WebElement nameLabel;

    @FindBy(xpath = "//b[@name='location']")
    private WebElement location;

    @FindBy(xpath = "//b[@name='location']/preceding-sibling::span")
    private WebElement locationLabel;

    @FindBy(xpath = "//b[@name='email']")
    private WebElement email;

    @FindBy(xpath = "//b[@name='email']/preceding-sibling::span")
    private WebElement emailLabel;

    @FindBy(xpath = "//b[@name='password']")
    private WebElement password;

    @FindBy(xpath = "//b[@name='password']/preceding-sibling::span")
    private WebElement passwordLabel;

    @FindBy(xpath = "//b[@name='agreedToPrivacyPolicy']")
    private WebElement agreedToPrivacyPolicy;

    @FindBy(xpath = "//b[@name='agreedToPrivacyPolicy']/preceding-sibling::span")
    private WebElement agreedToPrivacyPolicyLabel;

    @FindBy(xpath = "//b[@name='currentDate']")
    private WebElement currentDate;

    @FindBy(xpath = "//b[@name='currentDate']/preceding-sibling::span")
    private WebElement currentDateLabel;

    @FindBy(xpath = "//b[@name='currentTime']")
    private WebElement currentTime;

    @FindBy(xpath = "//b[@name='currentTime']/preceding-sibling::span")
    private WebElement currentTimeLabel;

    @FindBy(id = "return")
    private WebElement returnButton;

    //methods
    public void verifyOnSubmittedFormPage() {
        assertThat((pageResult).isDisplayed()).isTrue();
    }

    public void verifyUsername(String username) {
        assertThat(this.username.getText()).isEqualTo(username);
    }

    public void verifyEmail(String email) {
        assertThat(this.email.getText()).isEqualTo(email);
    }

    public void verifyFirstName(String firstName) {
        assertThat(this.firstName.getText()).isEqualTo(firstName);
    }

    public void verifyMiddleName(String middleName) {
        assertThat(this.middleName.getText()).isEqualTo(middleName);
    }

    public void verifyNoMiddleName() {
        assertThat(this.middleNameList == null || this.middleNameList.size() == 0).isTrue();
    }

    public void verifyLastName(String lastName) {
        assertThat(this.lastName.getText()).isEqualTo(lastName);
    }

    public void verifyNoLastName() {
        assertThat(this.lastNameList == null || this.lastNameList.size() == 0).isTrue(); }

    public void verifyName(String firstName, String middleName, String lastName) {
        assertThat(this.name.getText()).isEqualTo(
                               (firstName+" "+middleName+" "+lastName).replaceAll("[ ]+"," ").trim());
    }

    public void verifyPassword() {
        assertThat(this.password.getText()).isEqualTo(OBFUSCATED_PASSWORD);
    }
}
