package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import pages.QuoteForm;
import pages.SubmitedInfoQuoteForm;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.bouncycastle.cms.RecipientId.password;
import static support.TestContext.getData;

public class QuoteOopStepDefs {

    QuoteForm form = new QuoteForm();
    SubmitedInfoQuoteForm formInfo = new SubmitedInfoQuoteForm();

    Map<String, String> user = getData("user");

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
        assertThat(formInfo.getSubmittedFormData())
                .contains(user.get("username"), user.get("firstName"), user.get("lastName"), user.get("email"));
        assertThat(formInfo.getSubmittedFormData())
                .doesNotContain(user.get("password"));
        assertThat(formInfo.getAgreedToPrivacyPolicy()).isEqualTo("true");
    }
}
