package definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.QuoteForm;
import pages.QuoteFormResults;

import java.util.Map;

import org.junit.Assert;

import static org.assertj.core.api.Assertions.assertThat;

import static support.TestContext.getData;

public class QuoteOopStepDef {

    QuoteForm form = new QuoteForm();
    QuoteFormResults formResults = new QuoteFormResults();



    @Given("I go to the {string} page oop")
    public void iGoToThePageOop(String page) {
        form.open();
    }


    @When("I fill out {string} required fields oop")
    public void iFillOutRequiredFieldsOop(String userType ) {
        Map<String , String> user = getData(userType);

        form.fillUsername(user.get("username"));
        form.fillEmail(user.get("email"));
        form.fillPassword(user.get("password"));
        form.fillName(user.get("firstName"), user.get("lastName"));
        form.acceptPrivacyPolicy();
        form.submit();
    }


    @Then("I verify {string} the required fields OOP")
    public void iVerifyTheRequiredFieldsOOP(String userType) {
        Map<String , String> user = getData(userType);
        form.nameValue();
        assertThat(formResults.getFirstNameValue().contains(user.get("firstName")));
        formResults.getFirstNameValue().equals(user.get("firstName"));

    }
}
