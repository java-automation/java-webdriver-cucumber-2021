package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.PersonData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static support.TestContext.getDriver;

public class QuoteStepDefs extends HelperStepDefs {
    public static final String TITLE_GET_A_QUOTE_TEXT = "Get a Quote";
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
    public static final String PHONE_XPATH = "//input[@name='phone']";
    public static final String COUNTRY_OF_ORIGIN_Russia_OPTION_XPATH = "//select[@name='countryOfOrigin']/option[@value='Russia']";
    public static final String COUNTRY_OF_ORIGIN_XPATH = "//select[@name='countryOfOrigin']";
    public static final String GENDER_FEMALE_VALUE_XPATH = "//input[@name='gender'][@value='female']";
    public static final String GENDER_XPATH = "//input[@name='gender']";
    public static final String ADDRESS_XPATH = "//textarea[@id='address']";
    public static final String CAR_MAKE_XPATH = "//select[@name='carMake']";
    public static final String CAR_MAKE_OTHER_OPTION_XPATH = "//select[@name='carMake']/option[@value='Other']";
    public static final String THIRD_PARTY_BUTTON_XPATH = "//button[@id='thirdPartyButton']";
    public static final String DATE_OF_BIRTH_XPATH = "//input[@id='dateOfBirth']";
    public static final String ALLOWED_TO_CONTACT_CHECKBOX_XPATH = "//input[@name='allowedToContact']";

    public static final String SUBMITTED_APPLICATION_PASSWORD_XPATH = "//b[@name='password']";
    public static final String SUBMITTED_APPLICATION_NAME_XPATH = "//b[@name='name']";
    public static final String SUBMITTED_APPLICATION_FIRSTNAME_XPATH = "//b[@name='firstName']";
    public static final String SUBMITTED_APPLICATION_MIDDLE_NAME_XPATH = "//b[@name='middleName']";
    public static final String SUBMITTED_APPLICATION_LASTNAME_XPATH = "//b[@name='lastName']";
    public static final String SUBMITTED_APPLICATION_USERNAME_XPATH = "//b[@name='username']";
    public static final String SUBMITTED_APPLICATION_EMAIL_XPATH = "//b[@name='email']";
    public static final String SUBMITTED_APPLICATION_AGREED_TO_PRIVACY_POLICY_XPATH = "//b[@name='agreedToPrivacyPolicy']";
    public static final String SUBMITTED_APPLICATION_PAGE_RESULT_XPATH = "//div[@id='quotePageResult']";
    public static final String SUBMITTED_APPLICATION_PAGE_CAR_MAKE_XPATH = "//b[@name='carMake']";
    public static final String SUBMITTED_APPLICATION_PAGE_PHONE_XPATH = "//b[@name='phone']";
    public static final String SUBMITTED_APPLICATION_PAGE_COUNTRY_OF_ORIGIN_XPATH = "//b[@name='countryOfOrigin']";
    public static final String SUBMITTED_APPLICATION_PAGE_GENDER_XPATH = "//b[@name='gender']";
    public static final String SUBMITTED_APPLICATION_PAGE_DATE_OF_BIRTH = "//b[@name='dateOfBirth']";
    public static final String SUBMITTED_APPLICATION_PAGE_ADDRESS_XPATH = "//b[@name='address']";
    public static final String SUBMITTED_APPLICATION_PAGE_THIRD_PARTY_AGREEMENT_XPATH = "//b[@name='thirdPartyAgreement']";
    public static final String SUBMITTED_APPLICATION_PAGE_ALLOWED_TO_CONTACT_XPATH = "//b[@name='allowedToContact']";

    public static final String SUBMITTED_APPLICATION_PASSWORD_ENTERED_TEXT = "[entered]";
    public static final String SUBMITTED_APPLICATION_AGREEMENT_PRIVACY_POLICY_TEXT = "true";
    public static final String SUBMITTED_APPLICATION_PAGE_ALLOWED_TO_CONTACT_TEXT = "true";
    public static final String SUBMITTED_APPLICATION_THIRD_PARTY_AGREEMENT_TEXT = "accepted";

    PersonData person = new PersonData("Irina", "Aleksandrovna", "Gavrilova", "gavrilova.irina", "passioninsoftwaretesting@gmail.com",
            "p1234", "p1234", "512111111", "Russia", "Female", "here is an address", "Other", "01/25/2000");

    @When("I fill out required fields")
    public void iFillOutRequiredFields() {
        type(USERNAME_XPATH, person.getUsername());
        type(EMAIL_XPATH, person.getEmail());
        type(PASSWORD_XPATH, person.getPassword());
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

    @And("I fill out optional fields")
    public void iFillOutOptionalFields() {
        type(PHONE_XPATH, person.getPhone());
        type(DATE_OF_BIRTH_XPATH, person.getDateOfBirth());
        type(ADDRESS_XPATH, person.getAddress());

        click(COUNTRY_OF_ORIGIN_XPATH);
        selectByValue(COUNTRY_OF_ORIGIN_XPATH, person.getCountryOfOrigin());
        selectByValue(CAR_MAKE_XPATH, person.getCarMake());

        List<WebElement> genderList = getDriver().findElements(By.xpath(GENDER_XPATH));
        List<String> genderValue = new ArrayList<>();
        genderList.forEach(el -> genderValue.add(el.getAttribute("value")));
        genderList.get(genderValue.indexOf(person.getGender().toLowerCase())).click();

        click(THIRD_PARTY_BUTTON_XPATH);
        PredefinedStepDefs.iAcceptAlert();

        if (!getWebElement(ALLOWED_TO_CONTACT_CHECKBOX_XPATH).isSelected()) {
            click(ALLOWED_TO_CONTACT_CHECKBOX_XPATH);
        }
    }

    private String getFullName() {
        return person.getFirstName() + " " + person.getMiddleName() + " " + person.getLastName();
    }

    @And("I submit the page")
    public void iSubmitThePage() {
        click(SUBMIT_BUTTON);
    }


    @Then("I verify the required fields")
    public void iVerifyTheRequiredFields() {
        String resultText = getText(SUBMITTED_APPLICATION_PAGE_RESULT_XPATH);
        System.out.println(resultText);
        assertThat(resultText).contains(person.getUsername(),
                getFullName(),
                person.getEmail());
        assertThat(resultText).doesNotContain(TITLE_GET_A_QUOTE_TEXT);
        assertThat(getText(SUBMITTED_APPLICATION_AGREED_TO_PRIVACY_POLICY_XPATH)).isEqualTo(SUBMITTED_APPLICATION_AGREEMENT_PRIVACY_POLICY_TEXT);
        assertThat(getText(SUBMITTED_APPLICATION_PASSWORD_XPATH)).isEqualTo(SUBMITTED_APPLICATION_PASSWORD_ENTERED_TEXT);
        assertEquals(getText(SUBMITTED_APPLICATION_USERNAME_XPATH), person.getUsername());
        assertEquals(getText(SUBMITTED_APPLICATION_NAME_XPATH), getFullName());
        assertEquals(getText(SUBMITTED_APPLICATION_FIRSTNAME_XPATH), person.getFirstName());
        assertEquals(getText(SUBMITTED_APPLICATION_MIDDLE_NAME_XPATH), person.getMiddleName());
        assertEquals(getText(SUBMITTED_APPLICATION_LASTNAME_XPATH), person.getLastName());
        assertEquals(getText(SUBMITTED_APPLICATION_EMAIL_XPATH), person.getEmail());
    }

    @And("I verify the optional fields")
    public void iVerifyTheOptionalFields() {
        assertTrue(getText(SUBMITTED_APPLICATION_PAGE_CAR_MAKE_XPATH).contains(person.getCarMake()));
        assertEquals(getText(SUBMITTED_APPLICATION_PAGE_PHONE_XPATH), person.getPhone());
        assertEquals(getText(SUBMITTED_APPLICATION_PAGE_COUNTRY_OF_ORIGIN_XPATH), person.getCountryOfOrigin());
        assertEquals(getText(SUBMITTED_APPLICATION_PAGE_GENDER_XPATH), person.getGender().toLowerCase());
        assertEquals(getText(SUBMITTED_APPLICATION_PAGE_ADDRESS_XPATH), person.getAddress());
        assertEquals(getText(SUBMITTED_APPLICATION_PAGE_DATE_OF_BIRTH), person.getDateOfBirth());
        assertEquals(getText(SUBMITTED_APPLICATION_PAGE_THIRD_PARTY_AGREEMENT_XPATH), SUBMITTED_APPLICATION_THIRD_PARTY_AGREEMENT_TEXT);
        assertEquals(getText(SUBMITTED_APPLICATION_PAGE_ALLOWED_TO_CONTACT_XPATH), SUBMITTED_APPLICATION_PAGE_ALLOWED_TO_CONTACT_TEXT);
    }
}
