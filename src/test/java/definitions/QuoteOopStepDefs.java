package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import pages.QuoteForm;
import pages.SubmittedQuote;

import java.util.Map;
import java.util.NoSuchElementException;

import static support.TestContext.getData;

public class QuoteOopStepDefs {

    QuoteForm form = new QuoteForm(); //page object - we instantiate (create an object) from the subclass QuoteForm

    @Given("I go to {string} page oop")
    public void iGoToPageOop(String page) {
        form.open(); //где form - созданный нами выше объект, open - instant метод из класса, которому принадлежит объект
    }

    @When("I fill out the required fields oop")
    public void iFillOutTheRequiredFieldsOop() {
        Map<String, String> user = getData("user"); //data object. We created it to get data from file user.yml that we created before

        form.fillUsername(user.get("username")); //username - это поле в файле user.yml - same as: form.fillUsername("jdoe");
        form.fillEmail(user.get("email"));
        form.fillPasswordFields(user.get("password"));
        form.fillName(user.get("firstname"), user.get("lastname"));
        form.acceptPrivacyPolicy();
    }

    @And("I submit the page oop")
    public void iSubmitThePageOop() {
        form.submit();
    }

    @Then("I verity the required fields oop")
    public void iVerityTheRequiredFieldsOop() {
        SubmittedQuote resultPage = new SubmittedQuote(); //создаем объект из класса SubmittedQuote
        Map<String, String> user = getData("user");

        resultPage.verifyUsername(user.get("username")); //мы берем значение username (jdoe) из файла user.yml, затем переходим в класс SubmittedQuote в метод verifyUsername()
        resultPage.verifyEmail(user.get("email"));
        resultPage.verifyName(user.get("firstname"), user.get("lastname"));
        resultPage.verifyPassword("password");
    }

    @Then("I don't see {string} error message")
    public void iDonTSeeErrorMessage(String field) {
        form.errorMessageIsNotVisible(field);
    }

    @Then("I see {string} error message {string}")
    public void iSeeErrorMessage(String field, String message) {
        form.errorMessageIsVisible(field, message);
    }


    @When("I fill out {string} field with {string}")
    public void iFillOutFieldWith(String field, String value) {
        switch (field) {
            case "username":
                form.fillUsername(value);
                break;
            case "email":
                form.fillEmail(value);
                break;
            case "password":
                form.fillPasswordField(value);
                break;
            case "confirmPassword":
                form.fillConfirmPasswordField(value);
        }
    }

    @When("I fill out name field with first name {string} and last name {string}")
    public void iFillOutNameFieldWithFirstNameAndLastName(String firstName, String lastName) {
        form.fillName(firstName, lastName);
    }

    @When("I fill out name field with first name {string}, middle name {string}, last name {string}")
    public void iFillOutNameFieldWithFirstNameMiddleNameLastName(String firstName, String middleName, String lastName) {
        form.fillName(firstName, middleName, lastName);
    }

    @Then("I verify {string} field value {string}")
    public void iVerifyFieldValue(String field, String value) {
        form.verifyFieldValue(field, value);
    }
}
