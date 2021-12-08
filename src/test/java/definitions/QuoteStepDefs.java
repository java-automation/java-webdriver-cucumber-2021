package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.PersonData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static support.TestContext.getDriver;

public class QuoteStepDefs {

    public static final String PRIVACY_POLICY_XPATH = "//input[@name='agreedToPrivacyPolicy']";
    public static final String USERNAME_XPATH = "//input[@name='username']";
    public static final String EMAIL_XPATH = "//input[@name='email']";
    public static final String PASSWORD_XPATH = "//input[@name='password']";
    public static final String NAME_XPATH = "//input[@id='name']";
    public static final String FIRST_NAME_XPATH = "//input[@id='firstName']";
    public static final String MIDDLE_NAME_XPATH = "//input[@id='middleName']";
    public static final String LASTNAME_XPATH = "//input[@id='lastName']";
    public static final String SAVE_NAME_BUTTON_XPATH = "//span[text()='Save']";
    public static final String CONFIRM_PASSWORD_XPATH = "//input[@name='confirmPassword']";
    public static final String SUBMIT_BUTTON = "//button[@id='formSubmit']";


    public static final String SUBMITTED_APPLICATION_PASSWORD_XPATH = "//b[@name='password']";
    public static final String SUBMITTED_APPLICATION_NAME_XPATH = "//b[@name='name']";
    public static final String SUBMITTED_APPLICATION_FIRSTNAME_XPATH = "//b[@name='firstName']";
    public static final String SUBMITTED_APPLICATION_MIDDLE_NAME_XPATH = "//b[@name='middleName']";
    public static final String SUBMITTED_APPLICATION_LASTNAME_XPATH = "//b[@name='lastName']";
    public static final String SUBMITTED_APPLICATION_USERNAME_XPATH = "//b[@name='username']";
    public static final String SUBMITTED_APPLICATION_EMAIL_XPATH = "//b[@name='email']";
    public static final String SUBMITTED_APPLICATION_AGREED_TO_PRIVACY_POLICY_XPATH = "//b[@name='agreedToPrivacyPolicy']";
    public static final String SUBMITTED_APPLICATION_PAGE_RESULT_XPATH = "//div[@id='quotePageResult']";
    public static final String TITLE_GET_A_QUOTE_TEXT = "Get a Quote";
    public static final String SUBMITTED_APPLICATION_PASSWORD_ENTERED_TEXT = "[entered]";
    public static final String SUBMITTED_APPLICATION_AGREEMENT_PRIVACY_POLICY_TEXT = "true";


    PersonData person = new PersonData("Irina", "Aleksandrovna", "Gavrilova", "gavrilova.irina", "passioninsoftwaretesting@gmail.com",
            "p1234", "p1234");

    @When("I fill out required fields")
    public void iFillOutRequiredFields() {
        type(USERNAME_XPATH, person.getUsername());
        type(EMAIL_XPATH, person.getEmail());
        type(PASSWORD_XPATH, person.getPassword());
        type(CONFIRM_PASSWORD_XPATH, person.getConfirmPassword());
        type(CONFIRM_PASSWORD_XPATH, person.getConfirmPassword());
        click(NAME_XPATH);
        type(FIRST_NAME_XPATH, person.getFirstName());
        type(MIDDLE_NAME_XPATH, person.getMiddleName());
        type(LASTNAME_XPATH, person.getLastName());
        click(SAVE_NAME_BUTTON_XPATH);
        System.out.println(getWebElement(NAME_XPATH).getAttribute("value"));
        assertEquals(getWebElement(NAME_XPATH).getAttribute("value"),
                getFullName());
        if (!getWebElement(PRIVACY_POLICY_XPATH).isSelected()) {
            click(PRIVACY_POLICY_XPATH);
        }
    }

    private String getFullName() {
        return person.getFirstName() + " " + person.getMiddleName() + " " + person.getLastName();
    }

    private WebElement getWebElement(String xpath) {
        return getDriver().findElement(By.xpath(xpath));
    }

    public void click(String xpath) {
        getDriver().findElement(By.xpath(xpath)).click();
    }

    public void type(String xpath, String text) {
        click(xpath);
        getDriver().findElement(By.xpath(xpath)).clear();
        getDriver().findElement(By.xpath(xpath)).sendKeys(text);
    }

    @And("I submit the page")
    public void iSubmitThePage() {
        click(SUBMIT_BUTTON);
    }


    @Then("I verify the required fields")
    public void iVerifyTheRequiredFields() {
        String resultText = getWebElement(SUBMITTED_APPLICATION_PAGE_RESULT_XPATH).getText();
        System.out.println(resultText);
        assertThat(resultText).contains(person.getUsername(),
                getFullName(),
                person.getEmail());
        assertThat(resultText).doesNotContain(TITLE_GET_A_QUOTE_TEXT);
        assertThat(getWebElement(SUBMITTED_APPLICATION_AGREED_TO_PRIVACY_POLICY_XPATH).getText()).isEqualTo(SUBMITTED_APPLICATION_AGREEMENT_PRIVACY_POLICY_TEXT);
        assertThat(getWebElement(SUBMITTED_APPLICATION_PASSWORD_XPATH).getText()).isEqualTo(SUBMITTED_APPLICATION_PASSWORD_ENTERED_TEXT);
        assertEquals(getWebElement(SUBMITTED_APPLICATION_USERNAME_XPATH).getText(), person.getUsername());
        assertEquals(getWebElement(SUBMITTED_APPLICATION_NAME_XPATH).getText(), getFullName());
        assertEquals(getWebElement(SUBMITTED_APPLICATION_FIRSTNAME_XPATH).getText(), person.getFirstName());
        assertEquals(getWebElement(SUBMITTED_APPLICATION_MIDDLE_NAME_XPATH).getText(), person.getMiddleName());
        assertEquals(getWebElement(SUBMITTED_APPLICATION_LASTNAME_XPATH).getText(), person.getLastName());
        assertEquals(getWebElement(SUBMITTED_APPLICATION_EMAIL_XPATH).getText(), person.getEmail());
    }
}
