package definitions;

import io.cucumber.java.en.*;
import org.junit.*;
import org.openqa.selenium.*;
import pages.*;

import java.util.*;

import static java.lang.Thread.sleep;
import static support.TestContext.getData;


public class QuoteOopStepDefs {

    QuoteForm form = new QuoteForm();
    QuoteResults results = new QuoteResults();


    @Given("I go to {string} page and print details oop")
    public void iGoToPageAndPrintDetailsOop(String page) {
        form.open();
    }

    @When("I fill out {string} required fields oop")
    public void iFillOutRequiredFieldsOop(String userType) {
        Map<String, String> user = getData(userType);
        form.fillUsername(user.get("username"));
        form.fillEmail(user.get("email"));
        form.fillPasswordFields(user.get("password"));
        form.fillName(user.get("firstname"), user.get("lastname"));
        form.acceptPrivacyPolicy();
    }

    @And("I submit the page oop")
    public void iSubmitThePageOop() {
        form.submit();
    }

    @Then("I verify {string} required fields oop")
    public void iVerifyTheRequiredFieldsOop(String userType) {
        Map<String, String> user = getData(userType);
        Assert.assertEquals(user.get("username"), results.getUsernameValue());
        Assert.assertEquals(user.get("email"), results.getEmailValue());
        Assert.assertTrue(results.getPasswordValue());
        Assert.assertEquals(user.get("firstname"), results.getFirstNameValue());
        Assert.assertEquals(user.get("lastname"), results.getLastNameValue());
        Assert.assertTrue(results.getNameValue());
        Assert.assertTrue(results.getPrivacyPolicyValue());
    }

    @Then("I don't see {string} error message")
    public void iDonTSeeErrorMessage(String field) {
        form.checkRequiredFieldErrorNotPresent(field);
    }

    @Then("I see {string} error message {string}")
    public void iSeeErrorMessage(String field, String error) {
        form.checkRequiredFieldErrorPresent(field);
        form.checkRequiredFieldErrorIsCorrect(field, error);
    }

    @When("I fill out {string} field with {string}")
    public void iFillOutFieldWith(String field, String value) {
        form.fillField(field, value);
    }

    @When("I fill out name field with first name {string} and last name {string}")
    public void iFillOutNameFieldWithFirstNameAndLastName(String firstName, String lastName) {
        form.fillName(firstName, lastName);
    }

    @Then("I verify {string} field value {string}")
    public void iVerifyFieldValue(String field, String value) throws InterruptedException {
        if(form.returnButtonIsDisplayed()) {
            form.returnBack();
        }
        Map<String, String> user = getData("user");
        form.fillUsername(user.get("username"));
        form.fillEmail(user.get("email"));
        form.fillPasswordFields(user.get("password"));
        form.acceptPrivacyPolicy();
        form.submit();

        form.verifyName(field, value); //TODO: change to be available for any field
        Thread.sleep(2000);
        form.returnBack();
    }

    @When("I fill out name field with first name {string}, middle name {string}, last name {string}")
    public void iFillOutNameFieldWithFirstNameMiddleNameLastName(String firstName, String middleName, String lastName) {
        form.fillName(firstName, middleName, lastName);
    }

}
