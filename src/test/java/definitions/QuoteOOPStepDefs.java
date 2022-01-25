package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.QuoteForm;
import pages.QuoteResult;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;
import static support.TestContext.getData;

public class QuoteOOPStepDefs {

    private final QuoteForm form = new QuoteForm();
    private final QuoteResult results = new QuoteResult();

    private Map<String, String> user;
    private boolean isCompleteForm;

    @Given("I go to quote form page OOP")
    public void iGoToQuoteFormPageOOP() {
        form.open();
    }

    @When("I fill out {string} fields with {string} profile OOP")
    public void iFillOutFieldsWithProfileOOP(String whatFields, String profileReference) {
        setFormFillingContext(whatFields, profileReference);

        String firstName = user.get("firstName");
        String lastName = user.get("lastName");
        System.out.println("Filling form for " + firstName + " " + lastName + ". Full form? " + isCompleteForm);

        form.fillUsername(user.get("username"));
        form.fillEmail(user.get("email"));
        form.fillPasswords(user.get("password"));

        //middle name is optional and can be empty/null
        String middleName = user.get("middleName");
        if (middleName == null || middleName.isEmpty()) {
            form.fillName(firstName, lastName);
            assertThat(form.getName()).isEqualTo(firstName + " " + lastName);
        } else {
            form.fillName(firstName, middleName, lastName);
            assertThat(form.getName()).isEqualTo(firstName + " " + middleName + " " + lastName);
        }

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

    @And("I submit the form OOP")
    public void iSubmitTheFormOOP() {
        form.submit();
    }

    @Then("I verify that submitted fields got saved correctly OOP")
    public void iVerifyThatSubmittedFieldsGotSavedCorrectlyOOP() {
        String firstName = user.get("firstName");
        String lastName = user.get("lastName");
        System.out.println("Verifying form for " + firstName + " " + lastName + ". Full form? " + isCompleteForm);

        assertThat(results.getUsername()).isEqualTo(user.get("username"));
        assertThat(results.getEmail()).isEqualTo(user.get("email"));

        assertThat(results.getResultContainerText()).doesNotContain(user.get("password"));
        assertThat(results.getPassword()).isEqualTo("[entered]");

        //middle name is optional and can be empty/null
        assertThat(results.getFirstName()).isEqualTo(firstName);
        assertThat(results.getLastName()).isEqualTo(lastName);

        String middleName = user.get("middleName");
        if (middleName == null || middleName.isEmpty()) {
            assertThat(form.getName()).isEqualTo(firstName + " " + lastName);
        } else {
            assertThat(form.getName()).isEqualTo(firstName + " " + middleName + " " + lastName);
            assertThat(results.getMiddleName()).isEqualTo(middleName);
        }

        assertThat(results.isAcceptedPrivacyPolicy()).isTrue();

        if (isCompleteForm) {
            assertThat(results.getPhone()).isEqualTo(user.get("phone"));
            assertThat(results.getDateOfBirth()).isEqualTo(user.get("dateOfBirth"));
            assertThat(results.getCountry()).isEqualTo(user.get("countryOfOrigin"));
            assertThat(results.getGender()).isEqualTo(user.get("gender"));
            assertThat(results.isAllowedToContact()).isEqualTo(Boolean.parseBoolean(user.get("allowedToContact")));
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
        user = getData(profileReference, "quote");
    }

    @Then("I don't see {string} error message")
    public void iDonTSeeErrorMessage(String elementName) {
        boolean isErrorVisible = switch (elementName) {
            case "username" -> form.isUsernameErrorVisible();
            case "email" -> form.isEmailErrorVisible();
            case "password" -> form.isPasswordErrorVisible();
            case "confirmPassword" -> form.isConfirmPasswordErrorVisible();
            case "name" -> form.isNameErrorVisible();
            case "agreedToPrivacyPolicy" -> form.isPrivacyPolicyErrorVisible();
            default -> throw new Error("Unknown error message element reference: " + elementName);
        };
        assertThat(isErrorVisible).isFalse();
    }

    @Then("I see {string} error message {string}")
    public void iSeeErrorMessage(String elementName, String message) {
        String errorMessage = switch (elementName) {
            case "username" -> form.getUsernameErrorText();
            case "email" -> form.getEmailErrorText();
            case "password" -> form.getPasswordErrorText();
            case "confirmPassword" -> form.getConfirmPasswordErrorText();
            case "name" -> form.getNameErrorText();
            case "agreedToPrivacyPolicy" -> form.getPrivacyPolicyErrorText();
            default -> throw new Error("Unknown error message element reference: " + elementName);
        };
        assertThat(errorMessage).isEqualTo(message);
    }

    @When("I fill out {string} field with {string}")
    public void iFillOutFieldWith(String inputName, String text) {
        switch (inputName) {
            case "username" -> form.fillUsername(text);
            case "email" -> form.fillEmail(text);
            case "password" -> form.fillPassword(text);
            case "confirmPassword" -> form.fillConfirmPassword(text);
            default -> throw new Error("Unknown input field name reference: " + inputName);
        }
    }

    @When("I fill out name field with first name {string} and last name {string}")
    public void iFillOutNameFieldWithFirstNameAndLastName(String firstName, String lastName) {
        form.fillName(firstName, "", lastName);
    }

    @When("I fill out name field with first name {string}, middle name {string}, last name {string}")
    public void iFillOutNameFieldWithFirstNameMiddleNameLastName(String firstName, String middleName, String lastName) {
        form.fillName(firstName, middleName, lastName);
    }

    @Then("I verify {string} field value {string}")
    public void iVerifyFieldValue(String fieldName, String value) {
        String actualValue = switch (fieldName) {
            case "name" -> form.getName();
            case "email" -> form.getEmail();
            default -> throw new Error("Unknown field name reference: " + fieldName);
        };
        assertThat(actualValue).isEqualTo(value);
    }
}
