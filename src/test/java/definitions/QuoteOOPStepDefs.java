package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.QuoteForm;

import java.util.Map;

import static support.TestContext.getData;

public class QuoteOOPStepDefs {

    private final QuoteForm form = new QuoteForm();

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
            System.out.println("Doing All!");
        }
    }

    @And("Submit the form OOP")
    public void submitTheFormOOP() {
        form.submit();
    }

    @Then("I verify that submitted fields got saved correctly OOP")
    public void iVerifyThatSubmittedFieldsGotSavedCorrectlyOOP() {
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
