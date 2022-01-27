package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.QuoteErrorsPage;
import pages.QuoteForm;
import pages.QuoteResult;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getData;

public class QuoteOopStepDefs extends HelperStepDefs {

    QuoteErrorsPage error = new QuoteErrorsPage();
    QuoteForm formPage = new QuoteForm();
    QuoteResult resultPage = new QuoteResult();

    @When("I fill out {string} required fields oop")
    public void iFillOutRequiredFieldsOop(String userType) {
        Map<String, String> user = getData(userType);
        formPage.fillUsername(user.get("username"));
        formPage.fillEmail(user.get("email"));
        formPage.fillPasswordFields(user.get("password"));
        formPage.fillName(user.get("firstName"), user.get("middleName"), user.get("lastName"));
        formPage.acceptPrivacyPolicy();
    }

    @And("I submit the page oop")
    public void iSubmitThePageOop() {
        formPage.submit();
    }

    @Then("I verify {string} required fields oop")
    public void iVerifyTheRequiredFieldsOop(String userType) {
        Map<String, String> user = getData(userType);
        String actualResult = resultPage.getResultContainerText();
        String passwordText = resultPage.getPasswordText();
        boolean agreedToPrivacyPolicy = resultPage.isAgreedToPrivacyPolicy();
        assertThat(actualResult).contains(
                user.get("username"),
                user.get("email"),
                user.get("firstName"),
                user.get("middleName"),
                user.get("lastName")
        );
        assertThat(passwordText).contains(user.get("password"));
        assertThat(agreedToPrivacyPolicy).isTrue();
    }

    @Given("I go to {string} page oop 1")
    public void iGoToPageOop1(String urlString) {
        if (urlString.equals("quote")) {
            formPage.open("https://skryabin.com/market/quote.html");
        } else throw new Error("Unknown page to open!");
    }

    @When("I fill out {string} required fields oop 1")
    public void iFillOutRequiredFieldsOop1(String userType) {
        Map<String, String> user = getData(userType);
        formPage.fillUsername(user.get("username"));
        formPage.fillName(user);
        formPage.fillEmail(user.get("email"));
        formPage.fillPassword(user.get("password"));
        formPage.selectPrivacyPolicy();
    }

    @And("I submit the page oop 1")
    public void iSubmitThePageOop1() {
        formPage.submit();
    }


    @Given("I open {string} page 1")
    public void iOpenPage1(String url) {
        iGoToPageOop1(url);
    }

    @Then("I don't see {string} error message 1")
    public void iDonTSeeErrorMessage1(String requiredFieldName) {
        error.iDonTSeeErrorMessage(requiredFieldName);
    }

    @Then("I see {string} error message {string} 1")
    public void iSeeErrorMessage1(String requiredFieldName, String message) {
        error.iSeeErrorMessage(requiredFieldName, message);
    }

    @When("I fill out {string} field with {string} 1")
    public void iFillOutFieldWith1(String field, String text) {
        switch (field) {
            case "username": {
                formPage.fillUsername(text);
                break;
            }
            case "email": {
                formPage.fillEmail(text);
                break;
            }
            case "password": {
                formPage.fillOutOnlyPasswordField(text);
                break;
            }
            case "confirmPassword": {
                formPage.fillOutOnlyConfirmPasswordField(text);
                break;
            }
            default:
                throw new Error("Can't recognize" + field + " field to fill out!");
        }
    }

    @When("I fill out name field with first name {string} and last name {string} 1")
    public void iFillOutNameFieldWithFirstNameAndLastName1(String firstName, String lastName) {
        formPage.fillName(firstName, "", lastName);
    }

    @When("I fill out name field with first name {string}, middle name {string}, last name {string} 1")
    public void iFillOutNameFieldWithFirstNameMiddleNameLastName1(String firstName, String middleName, String lastName) {
        formPage.fillName(firstName, middleName, lastName);
    }

    @Then("I verify {string} field value {string} 1")
    public void iVerifyFieldValue1(String field, String value) {
        formPage.assertFieldValue(field, value);
    }
}
