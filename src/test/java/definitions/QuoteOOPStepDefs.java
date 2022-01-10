package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.QuoteForm;
import pages.QuoteResults;

import java.util.Map;

import static org.assertj.core.api.Assertions.*;
import static support.TestContext.getData;

public class QuoteOOPStepDefs {

    private final QuoteForm form = new QuoteForm();
    private final QuoteResults results = new QuoteResults();

    private Map<String, String> user;
    private boolean isCompleteForm;

    @Given("I go to quote form page OOP")
    public void iGoToQuoteFormPageOOP() {
        form.open();
    }

    @When("I fill out {string} fields with {string} profile OOP")
    public void iFillOutFieldsWithProfileOOP(String whatFields, String profileReference) {
        setFormFillingContext(whatFields, profileReference);

        form.fillUsername(user.get("username"));
        form.fillEmail(user.get("email"));
        form.fillPasswords(user.get("password"));
        form.fillName(user.get("firstName"), user.get("middleName"), user.get("lastName"));
        form.acceptPrivacyPolicy();

        if (isCompleteForm) {
            System.out.println("Filling All!");
        }
    }

    @And("Submit the form OOP")
    public void submitTheFormOOP() {
        form.submit();
    }

    @Then("I verify that submitted fields got saved correctly OOP")
    public void iVerifyThatSubmittedFieldsGotSavedCorrectlyOOP() {
        assertThat(results.getUsername()).isEqualTo(user.get("username"));
        assertThat(results.getEmail()).isEqualTo(user.get("email"));
        assertThat(results.getPassword()).isEqualTo("[entered]");

        String firstName = user.get("firstName");
        String middleName = user.get("middleName");
        String lastName = user.get("lastName");
        assertThat(results.getName()).isEqualTo(firstName + " " + middleName + " " + lastName);
        assertThat(results.getFirstName()).isEqualTo(firstName);
        assertThat(results.getMiddleName()).isEqualTo(middleName);
        assertThat(results.getLastName()).isEqualTo(lastName);

        assertThat(results.getPrivacyPolicy()).isEqualTo("true");

        if (isCompleteForm) {
            System.out.println("Verifying All!");
        }
    }

    private void setFormFillingContext(String whatFields, String profileReference) {
        switch (whatFields.toLowerCase()) {
            case "required" -> isCompleteForm = false;
            case "all" -> isCompleteForm = true;
            default -> throw new Error("Unknown scenario context reference: " + whatFields);
        }
        user = getData(profileReference.toLowerCase().replace(" ", ""));
    }
}
