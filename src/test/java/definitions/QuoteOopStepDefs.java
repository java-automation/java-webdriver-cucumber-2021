package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.QuoteErrorsPage;
import pages.QuoteForm;
import support.TestContext;

import java.util.Map;

public class QuoteOopStepDefs extends HelperStepDefs {

    QuoteForm form = new QuoteForm();
    QuoteErrorsPage error = new QuoteErrorsPage();

    @Given("I go to {string} page oop")
    public void iGoToPageOop(String urlString) {
        if (urlString.equals("quote")) {
            form.open("https://skryabin.com/market/quote.html");
        } else throw new Error("Unknown page to open!");
    }

    @When("I fill out {string} required fields oop")
    public void iFillOutRequiredFieldsOop(String userType) {
        Map<String, String> user = TestContext.getData(userType);
        form.fillUsername(user.get("username"));
        form.fillName(user);
        form.fillEmail(user.get("email"));
        form.fillPassword(user.get("password"));
        form.selectPrivacyPolicy();
    }

    @And("I submit the page oop")
    public void iSubmitThePageOop() {
        form.submit();
    }


    @Given("I open {string} page")
    public void iOpenPage(String url) {
        iGoToPageOop(url);
    }

    @Then("I don't see {string} error message")
    public void iDonTSeeErrorMessage(String requiredFieldName) {
        error.iDonTSeeErrorMessage(requiredFieldName);
    }

    @Then("I see {string} error message {string}")
    public void iSeeErrorMessage(String requiredFieldName, String message) {
        error.iSeeErrorMessage(requiredFieldName, message);
    }

    @When("I fill out {string} field with {string}")
    public void iFillOutFieldWith(String field, String text) {
        switch (field) {
            case "username": {
                form.fillUsername(text);
                break;
            }
            case "email": {
                form.fillEmail(text);
                break;
            }
            case "password": {
                form.fillOutOnlyPasswordField(text);
                break;
            }
            case "confirmPassword": {
                form.fillOutOnlyConfirmPasswordField(text);
                break;
            }
            default:
                throw new Error("Can't recognize" + field + " field to fill out!");
        }
    }

    @When("I fill out name field with first name {string} and last name {string}")
    public void iFillOutNameFieldWithFirstNameAndLastName(String firstName, String lastName) {
        form.fillName(firstName, "", lastName);
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
