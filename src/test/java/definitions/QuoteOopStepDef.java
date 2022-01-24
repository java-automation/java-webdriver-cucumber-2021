package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.QuoteForm;
import pages.QuoteFormResults;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

import static support.TestContext.getData;
import static support.TestContext.getDriver;

public class QuoteOopStepDef {

    QuoteForm form = new QuoteForm();
    QuoteFormResults formResults = new QuoteFormResults();



    @Given("I go to the {string} page oop")
    public void iGoToThePageOop(String page) {
        form.open("quote");
    }


    @When("I fill out {string} required fields oop")
    public void iFillOutRequiredFieldsOop(String userType ) throws InterruptedException {
        Map<String , String> user = getData(userType);

        form.fillUsername(user.get("username"));
        form.fillEmail(user.get("email"));
        form.fillPassword(user.get("password"));
        form.fillName(user.get("firstName"), user.get("lastName"));
        form.acceptPrivacyPolicy();

    }

    @When("I fill out {string} optional fields OOP")
    public void iFillOutOptionalFieldsOOP(String userType) throws InterruptedException {
        Map<String , String> user = getData(userType);

        form.fillCountryOfOrigin(user.get("country"));
        form.fillPhone(user.get("phone"));
        form.fillDateOfBirth();
        form.fillGender();
        form.fillAddress(user.get("address"));
        form.selectAllowToContact();
        form.selectAgreement();
    }

    @And("I submit a form OOP")
    public void iSubmitAFormOOP() {
        form.submit();
    }

    @Then("I verify {string} the required fields OOP")
    public void iVerifyTheRequiredFieldsOOP(String userType) throws InterruptedException {
        Map<String , String> user = getData(userType);
        assertThat(formResults.getFirstNameResult()).isEqualTo(user.get("firstName"));
        assertThat(formResults.getLastNameResult()).isEqualTo(user.get("lastName"));
        assertThat(formResults.getFullName()).isEqualTo(user.get("firstName")+ " " + user.get("lastName"));
        assertThat(formResults.getEmailResult()).isEqualTo(user.get("email"));
        assertThat(formResults.getGender()).isEqualTo(user.get("gender"));
        assertThat(formResults.getPrivacyPolicyResult()).isEqualTo("true");
        assertThat(formResults.getDateOfBirth()).isEqualTo("09/30/1991");
        assertThat(formResults.getCountryOfOrigin()).isEqualTo(user.get("country"));
        assertThat(formResults.getAddress()).isEqualTo(user.get("address"));
        assertThat(formResults.getPhoneResult()).isEqualTo(user.get("phone"));


    }

    @Then("I don't see {string} error message")
    public void iDonTSeeErrorMessage(String elementName) {

        boolean isErrorVisible = switch (elementName) {
            case "username" -> form.isUsernameErrorVisible();
            case "email" -> form.isEmailErrorVisible();
            case "password" -> form.isPasswordErrorVisible();
            case "name" -> form.isNameErrorVisible();
            case "agreedToPrivacyPolicy" -> form.isPrivacyPolicyErrorVisible();

            default -> throw new Error("Unknown error message element reference: " + elementName);
        };
        assertThat(isErrorVisible).isFalse();
    }

//        bad code
//        WebDriverWait wait = new WebDriverWait(getDriver(),5);
//        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//label[@id='"+ inputField+"-error']")));



    @Then("I see {string} error message {string}")
    public void iSeeErrorMessage(String inputField, String message) {
       assertThat(form.fieldErrorText(inputField).getText()).isEqualTo(message);
    }

    @When("I fill out {string} field with {string}")
    public void iFillOutFieldWith(String field, String text) {
        form.field(field).clear();
        form.filloutField(field,text);
    }

    @Given("I open {string} page")
    public void iOpenPage(String page) {
        form.open(page);
    }

    @When("I fill out name field with first name {string} and last name {string}")
    public void iFillOutNameFieldWithFirstNameAndLastName(String firstName, String lastName) {
        form.fillName(firstName,lastName);
    }


    @Then("I verify {string} field value {string}")
    public void iVerifyFieldValue(String field, String value) {
       assertThat(form.field(field).getAttribute("value")).isEqualTo(value);
    }

    @When("I fill out name field with first name {string}, middle name {string}, last name {string}")
    public void iFillOutNameFieldWithFirstNameMiddleNameLastName(String firstName, String middleName, String lastName) {
        form.fillName(firstName,middleName,lastName);
    }

    @Then("I don't see {string} error message OOP")
    public void iDonTSeeErrorMessageOOP(String arg0) {
//    form.errorNotPresent();
    }
}
