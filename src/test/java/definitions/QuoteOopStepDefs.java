package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.xpath.operations.Quo;
import pages.QuoteForm;
import pages.QuoteFormResult;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getData;

public class QuoteOopStepDefs {

    QuoteForm form = new QuoteForm();
    QuoteFormResult formResults = new QuoteFormResult();
    Map<String, String > user = getData("user");

    @Given("I go to {string} page oop")
    public void iGoToPageOop(String page) {
        form.open();
        
    }

    @When("I fill out {string} required fields oop")
    public void iFillOutRequiredFieldsOop(String userType) {
        form.fillUsername(user.get("username"));
        form.fillEmail(user.get("email"));
        form.fillPasswords(user.get("password"));
        form.fillName(user.get("firstName"), user.get("lastName"));
        form.selectGender();
        form.fillPhoneNumber(user.get("phone"));
        form.contactPersonName(user.get("contact name"));
        form.acceptPrivacyPolicy();
    }

    @And("I submit the page oop")
    public void iSubmitThePageOop() {
        form.submit();

    }

    @Then("I verify {string} required fields oop")
    public void iVerifyTheRequiredFieldsOop(String userType) {
        Map <String, String> user = getData(userType);

        assertThat(formResults.getFirstNameResult()).isEqualTo(user.get("firstName"));
        assertThat(formResults.getLastNameResult()).isEqualTo(user.get("lastName"));
        assertThat(formResults.getEmailResult()).isEqualTo(user.get("email"));
        assertThat(formResults.getFullName()).isEqualTo(user.get("name"));
        assertThat(formResults.getGenderType()).isEqualTo(user.get("gender"));
        assertThat(formResults.getPolicyResult()).isEqualTo(user.get("policy"));
        assertThat(formResults.getPhoneNumber()).isEqualTo(user.get("phone"));

//        assertThat(formResults.getPrivacyPolicyResult()).isEqualTo(user.get("privacy policy"));


    }

    @Then("I don't see {string} error message")
    public void iDonTSeeErrorMessage(String fieldName) {
        assertThat(form.isErrorMessageVisible(fieldName)).isFalse();
        
    }

    @And("I see {string} error message {string}")
    public void iSeeErrorMessage(String fieldName, String message) {
        assertThat(form.getErrorMessage(fieldName)).isEqualTo(message);
    }

    @When("I fill out {string} field with {string}")
    public void iFillOutFieldWith(String field, String text) {
    }
}
