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
        form.fillName(user.get("firstName"), user.get("lastName"));
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
}
