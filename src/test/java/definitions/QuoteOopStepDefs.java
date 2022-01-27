package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.QuoteForm;
import pages.QuoteResult;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getData;

public class QuoteOopStepDefs {

    QuoteForm formPage = new QuoteForm();
    QuoteResult resultPage = new QuoteResult();

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
}