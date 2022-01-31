package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.QuoteForm;
import pages.QuoteResult;

import java.util.Map;


import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getData;

public class QuoteOopStepDefs {

    QuoteForm formPage = new QuoteForm(); //page object - we instantiate (create an object) from the subclass QuoteForm


    @When("I fill out the required fields oop")
    public void iFillOutTheRequiredFieldsOop() {
        Map<String, String> user = getData("user"); //data object. We created it to get data from file user.yml that we created before

        formPage.fillUsername(user.get("username")); //username - это поле в файле user.yml - same as: form.fillUsername("jdoe");
        formPage.fillEmail(user.get("email"));
        formPage.fillPasswordFields(user.get("password"));
        formPage.fillName(user.get("firstname"), user.get("lastname"));
        formPage.acceptPrivacyPolicy();
    }

    @And("I submit the page oop")
    public void iSubmitThePageOop() {
        formPage.submit();
    }

    @Then("I verity the required fields oop")
    public void iVerityTheRequiredFieldsOop() {
        QuoteResult resultPage = new QuoteResult(); //создаем объект из класса QuoteResult (с результатами после заполнения форм и нажатия submit)
        Map<String, String> user = getData("user"); ////data object. We created it to get data from file user.yml that we created before

        //Variant 1 (ссылаемся на методы в класс
        resultPage.verifyUsername(user.get("username")); //мы берем значение username (jdoe) из файла user.yml, затем переходим в класс SubmittedQuote в метод verifyUsername()
        resultPage.verifyEmail(user.get("email"));
        resultPage.verifyName(user.get("firstname"), user.get("lastname"));
        resultPage.verifyPassword("password"); //в методе verifyPassword мы убеждаемся, что на новой странице password не отображен

        //variant 2
        String actualResult = resultPage.getResultContainerText(); //текст всего блока
        String passwordText = resultPage.getPasswordText();
        boolean agreedToPrivacyPolicy = resultPage.isAgreedToPrivacyPolicy();
        assertThat(actualResult).contains(user.get("username"),
                                          user.get("email"),
                                          user.get("firstname"),
                                          user.get("lastname"));
        assertThat(actualResult).doesNotContain(user.get("password"));
        assertThat(agreedToPrivacyPolicy).isTrue();

    }

    @Then("I don't see {string} error message")
    public void iDonTSeeErrorMessage(String field) {
        formPage.errorMessageIsNotVisible(field);
    }

    @Then("I see {string} error message {string}")
    public void iSeeErrorMessage(String field, String message) {
        formPage.errorMessageIsVisible(field, message);
    }


    @When("I fill out {string} field with {string}")
    public void iFillOutFieldWith(String field, String value) {
        switch (field) {
            case "username":
                formPage.fillUsername(value);
                break;
            case "email":
                formPage.fillEmail(value);
                break;
            case "password":
                formPage.fillPasswordField(value);
                break;
            case "confirmPassword":
                formPage.fillConfirmPasswordField(value);
        }
    }

    @When("I fill out name field with first name {string} and last name {string}")
    public void iFillOutNameFieldWithFirstNameAndLastName(String firstName, String lastName) {
        formPage.fillName(firstName, lastName);
    }

    @When("I fill out name field with first name {string}, middle name {string}, last name {string}")
    public void iFillOutNameFieldWithFirstNameMiddleNameLastName(String firstName, String middleName, String lastName) {
        formPage.fillName(firstName, middleName, lastName);
    }

    @Then("I verify {string} field value {string}")
    public void iVerifyFieldValue(String field, String value) {
        formPage.verifyFieldValue(field, value);
    }
}
