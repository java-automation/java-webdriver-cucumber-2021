package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.NoSuchElementException;
import pages.QuoteForm;
import pages.QuoteFormSubmitted;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getData;

public class QuoteOopStepDefs {

    QuoteForm form = new QuoteForm();
    QuoteFormSubmitted formSubmitted = new QuoteFormSubmitted();

    @Given("I go to {string} page oop")
    public void iGoToPageOop(String page) {
        form.open();
    }

    @When("I fill out {string} required fields oop")
    public void iFillOutRequiredFieldsOop(String userType) {
        Map<String, String> user = getData(userType);
        form.fillUsername(user.get("username"));
        form.fillEmail(user.get("email"));
        form.fillPasswordFields(user.get("password"));
        form.fillName(user.get("firstName"), "", user.get("lastName"));
        form.acceptPrivacyPolicy();
    }

    @And("I submit the page oop")
    public void iSubmitThePageOop() {
        form.submit();
    }

    @Then("I verify {string} required fields oop")
    public void iVerifyTheRequiredFieldsOop(String userType) {
        Map<String, String> user = getData(userType);
        assertThat(formSubmitted.getName()).isEqualTo(user.get("firstName") + " " + user.get("lastName"));
        assertThat(formSubmitted.getUserName()).isEqualTo(user.get("username"));
        assertThat(formSubmitted.getEmail()).isEqualTo(user.get("email"));
        assertThat(formSubmitted.getPassword()).isEqualTo("[entered]");
        assertThat(formSubmitted.getAgreedToPrivacyPolicy()).isEqualTo("true");
    }

    @Then("I don't see {string} error message")
    public void iDonTSeeErrorMessage(String sField) {
        assertThat(form.isErrorMessageVisible(sField, "")).isFalse();
    }

    @Then("I see {string} error message {string}")
    public void iSeeErrorMessage(String sField, String sMessage) {
        assertThat(form.isErrorMessageVisible(sField, sMessage)).isTrue();
    }

    @When("I fill out {string} field with {string}")
    public void iFillOutFieldWith(String sField, String sValue) {
        switch (sField) {
            case "username":
                form.fillUsername(sValue);
                break;
            case "email":
                form.fillEmail(sValue);
                break;
            case "password":
                form.fillPasswordField(sValue);
                break;
            case "confirmPassword":
                form.fillConfirmPasswordField(sValue);
                break;
            default:
                break;
        }
    }

    @When("I fill out name field with first name {string} and last name {string}")
    public void iFillOutNameFieldWithFirstNameAndLastName(String sFirstName, String sLastName) {
        form.fillName(sFirstName, "", sLastName);
    }

    @Then("I verify {string} field value {string}")
    public void iVerifyFieldValue(String sField, String sValue) {
        switch (sField) {
            case "name":
                assertThat(form.getNameFieldContents().equals(sValue)).isTrue();
                break;
            default:
                break;
        }
    }

    @When("I fill out name field with first name {string}, middle name {string}, last name {string}")
    public void iFillOutNameFieldWithFirstNameMiddleNameLastName(String sFirstName, String sMiddleName, String sLastName) {
        form.fillName(sFirstName, sMiddleName, sLastName);
    }
}
