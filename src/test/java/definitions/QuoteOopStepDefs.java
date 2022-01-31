package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.QuoteForm;


import java.util.Map;

import static support.TestContext.getData;

public class QuoteOopStepDefs {

    QuoteForm form = new QuoteForm();
    Map<String, String> user = getData("user");


    @Given("I go to {string} page oop")
    public void iGoToPageOop(String arg0) {
        form.open();
    }

    @When("I fill out required fields oop")
    public void iFillOutRequiredFieldsOop() {
        form.fillUsername(user.get("username"));
        form.fillEmail(user.get("email"));
        form.fillPasswordFields(user.get("password"));
        form.fillName(user.get("firstName"), user.get("lastName"));
        form.acceptPrivacyPolicy();

    }


    @And("I submit the page oop")
    public void iSubmitThePageOop() {
        form.submit();
    }

    @Then("I verify the required fields oop")
    public void iVerifyTheRequiredFieldsOop() {
    }
}
