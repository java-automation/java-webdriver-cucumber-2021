package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.QuoteForm;
import pages.QuoteResults;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

        String firstName = user.get("firstName");
        String middleName = user.get("middleName");
        String lastName = user.get("lastName");
        form.fillName(firstName, middleName, lastName);
        assertThat(form.getName()).isEqualTo(firstName + " " + middleName + " " + lastName);

        form.acceptPrivacyPolicy();

        if (isCompleteForm) {
            form.fillPhone(user.get("phone"));

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
            LocalDate parsedDate = LocalDate.parse(user.get("dateOfBirth"), formatter);
            String year = String.valueOf(parsedDate.getYear());
            String month = String.valueOf(parsedDate.getMonthValue());
            String day = String.valueOf(parsedDate.getDayOfMonth());
            form.fillDateOfBirth(year, month, day);

            form.selectCountry(user.get("countryOfOrigin"));
            form.selectGender(user.get("gender"));

            //workaround to generate both "true" and "false" outputs on results page
            form.allowToContact();
            if (user.get("allowedToContact").equals("false")) form.disallowToContact();

            form.fillAddress(user.get("address"));
            form.selectCarMakes(user.get("carMake").split(", "));
            form.fillAdditionalInfo(user.get("contactName"), user.get("contactPhone"));

            if (user.get("thirdPartyAgreement").equalsIgnoreCase("accepted")) form.accept3rdPartyAgreement();
            else form.decline3rdPartyAgreement();

            String currentDir = System.getProperty("user.dir");
            form.attachFile(currentDir + "/src/test/resources/data/" + user.get("attachment"));
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
            assertThat(results.getPhone()).isEqualTo(user.get("phone"));
            assertThat(results.getDateOfBirth()).isEqualTo(user.get("dateOfBirth"));
            assertThat(results.getCountry()).isEqualTo(user.get("countryOfOrigin"));
            assertThat(results.getGender()).isEqualTo(user.get("gender"));
            assertThat(results.getAllowedToContact()).isEqualTo(user.get("allowedToContact"));
            assertThat(results.getAddress()).isEqualTo(user.get("address"));
            assertThat(results.getCarMake()).isEqualTo(user.get("carMake"));
            assertThat(results.getContactName()).isEqualTo(user.get("contactName"));
            assertThat(results.getContactPhone()).isEqualTo(user.get("contactPhone"));
            assertThat(results.getThirdPartyAgreement()).isEqualTo(user.get("thirdPartyAgreement"));
            assertThat(results.getAttachmentName()).isEqualTo(user.get("attachment"));
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
