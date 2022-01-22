package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.QuoteForm;
import pages.QuoteFormSubmitted;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getData;

public class QuoteOopStepDefs {

    QuoteForm formPage = new QuoteForm();
    QuoteFormSubmitted formSubmitted = new QuoteFormSubmitted();

    @Given("I go to {string} page oop")
    public void iGoToPageOop(String page) {
        formPage.open();
    }

    @When("I fill out {string} required fields oop")
    public void iFillOutRequiredFieldsOop(String userType) {
        Map<String, String> user = getData(userType);
        formPage.fillUsername(user.get("username"));
        formPage.fillEmail(user.get("email"));
        formPage.fillPasswordFields(user.get("password"));
        formPage.fillName(user.get("firstName"), "", user.get("lastName"));
        formPage.acceptPrivacyPolicy();
    }

    @And("I submit the page oop")
    public void iSubmitThePageOop() {
        formPage.submit();
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
        assertThat(formPage.isErrorMessageVisible(sField, "")).isFalse();
    }

    @Then("I see {string} error message {string}")
    public void iSeeErrorMessage(String sField, String sMessage) {
        assertThat(formPage.isErrorMessageVisible(sField, sMessage)).isTrue();
    }

    @When("I fill out {string} field with {string}")
    public void iFillOutFieldWith(String sField, String sValue) {
        switch (sField) {
            case "username":
                formPage.fillUsername(sValue);
                break;
            case "email":
                formPage.fillEmail(sValue);
                break;
            case "password":
                formPage.fillPasswordField(sValue);
                break;
            case "confirmPassword":
                formPage.fillConfirmPasswordField(sValue);
                break;
            default:
                break;
        }
    }

    @When("I fill out name field with first name {string} and last name {string}")
    public void iFillOutNameFieldWithFirstNameAndLastName(String sFirstName, String sLastName) {
        formPage.fillName(sFirstName, "", sLastName);
    }

    @Then("I verify {string} field value {string}")
    public void iVerifyFieldValue(String sField, String sValue) {
        switch (sField) {
            case "name":
                assertThat(formPage.getNameFieldContents().equals(sValue)).isTrue();
                break;
            default:
                break;
        }
    }

    @When("I fill out name field with first name {string}, middle name {string}, last name {string}")
    public void iFillOutNameFieldWithFirstNameMiddleNameLastName(String sFirstName, String sMiddleName, String sLastName) {
        formPage.fillName(sFirstName, sMiddleName, sLastName);
    }
}
