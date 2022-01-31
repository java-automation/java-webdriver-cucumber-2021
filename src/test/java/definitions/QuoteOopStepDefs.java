package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.QuoteForm;
import pages.SubmittedQuoteForm;

import java.util.Map;
import java.util.Objects;
import static support.TestContext.getData;

public class QuoteOopStepDefs {

    QuoteForm form = new QuoteForm();
    SubmittedQuoteForm submittedForm = new SubmittedQuoteForm();

    @When("I fill out {string} required fields oop")
    public void iFillOutRequiredFieldsOop(String userType) {
        Map<String, String> user = getData(userType);
        form.fillUsername(user.get("username"));
        form.fillEmail(user.get("email"));
        form.fillPasswordFields(user.get("password"));
        if (user.get("middleName") != null) {
            form.fillName(user.get("firstName"), user.get("middleName"), user.get("lastName"));
        } else {
            form.fillName(user.get("firstName"), user.get("lastName"));
        }
        form.acceptPrivacyPolicy();
    }

    @And("I submit the page oop")
    public void iSubmitThePageOop() {
        form.submit();
    }

    @Then("I verify {string} required fields oop")
    public void iVerifyTheRequiredFieldsOop(String userType) {
        Map<String, String> expectedUser = getData(userType);
        submittedForm.verifyUsername(expectedUser.get("username"));
        submittedForm.verifyEmail(expectedUser.get("email"));
        submittedForm.verifyFirstName(expectedUser.get("firstName"));
        if (expectedUser.get("middleName") != null) {
            submittedForm.verifyMiddleName(expectedUser.get("middleName"));
        } else {
            submittedForm.verifyNoMiddleName();
        }
        if (expectedUser.get("lastName") != null) {
            submittedForm.verifyLastName(expectedUser.get("lastName"));
        } else {
            submittedForm.verifyNoLastName();
        }
        submittedForm.verifyName(Objects.toString(expectedUser.get("firstName"),""),
                                Objects.toString(expectedUser.get("middleName"),""),
                                Objects.toString(expectedUser.get("lastName"),""));
        submittedForm.verifyPassword();
    }

    @Then("I don't see {string} error message")
    public void iDonTSeeErrorMessage(String field) {
        form.assertNoError(field);
    }

    @Then("I see {string} error message {string}")
    public void iSeeErrorMessage(String field, String errorMessage) {
        form.assertErrorMessage(field, errorMessage);
    }

    @When("I fill out {string} field with {string}")
    public void iFillOutFieldWith(String field, String value) {
        form.fillOutField(field, value);
    }

    @When("I fill out name field with first name {string} and last name {string}")
    public void iFillOutNameFieldWithFirstNameAndLastName(String firstName, String lastName) {
        form.fillName(firstName, lastName);
    }

    @When("I fill out name field with first name {string}, middle name {string}, last name {string}")
    public void iFillOutNameFieldWithFirstNameMiddleNameLastName(String firstName, String middleName, String lastName) {
        form.fillName(firstName, middleName, lastName);
    }

    @Then("I verify {string} field value {string}")
    public void iVerifyFieldValue(String field, String value) {
        form.assertFieldValue(field, value);
    }
}
