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
}
