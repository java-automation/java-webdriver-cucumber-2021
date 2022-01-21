package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import pages.ErrorQuote;
import pages.QuoteForm;
import pages.QuoteSubmittedPage;

import java.util.Map;

import static support.TestContext.getData;
import static support.TestContext.getDriver;

public class QuoteOopStepDefs {

    QuoteForm form = new QuoteForm();

    QuoteSubmittedPage page = new QuoteSubmittedPage();

    ErrorQuote error = new ErrorQuote();


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
    public void iVerifyRequiredFieldsOop(String application) {
        System.out.println(application);

        page.verifyUsernameIsDisplayed();
        page.verifyFirstNameIsDisplayed();
        page.verifyLastNameIsDisplayed();
        page.verifyEmailIsDisplayed();
        page.verifyPrivacyPolicyIsDisplayed();
        page.verifyNameIsDisplayed();


    }

    //Home_work_01_19_22/1

    @Then("I don't see {string} error message")
    public void iDonTSeeErrorMessage(String field) {

        switch (field) {

            case "username": {
                // getDriver().findElements(By.xpath("//label[@id='username-error']")).size();
                Assertions.assertThat(getDriver().findElements(By.xpath("//label[@id='username-error']")).size()).isEqualTo(0);
                break;
            }

            case "email": {

                Assertions.assertThat(getDriver().findElements(By.xpath("/label[@id='email-error']")).size()).isEqualTo(0);
                break;
            }

            case "password": {

                Assertions.assertThat(getDriver().findElements(By.xpath("//label[@id='password-error']")).size()).isEqualTo(0);
                break;
            }
            case "name": {

                Assertions.assertThat(getDriver().findElements(By.xpath("//label[@id='name-error']")).size()).isEqualTo(0);
                break;
            }

            case "agreedToPrivacyPolicy": {

                Assertions.assertThat(getDriver().findElements(By.xpath("//label[@id='agreedToPrivacyPolicy-error']")).size()).isEqualTo(0);
                break;
            }


            default: {
                throw new Error(" Not Found ");

            }
        }
    }

    @Then("I see {string} error message {string}")
    public void iSeeErrorMessage(String field, String errorText) {

        switch (field) {

            case "username": {

                Assertions.assertThat(getDriver().findElements(By.xpath("//label[@id='username-error']")).equals(errorText));
                break;
            }

            case "email": {

                Assertions.assertThat(getDriver().findElements(By.xpath("//label[@id='email-error']")).equals(errorText));
                break;
            }

            case "password": {

                Assertions.assertThat(getDriver().findElements(By.xpath("//label[@id='password-error']")).equals(errorText));
                break;
            }
            case "name": {

                Assertions.assertThat(getDriver().findElements(By.xpath("//label[@id='name-error']")).equals(errorText));
                break;
            }

            case "agreedToPrivacyPolicy": {

                Assertions.assertThat(getDriver().findElements(By.xpath("//label[@id='agreedToPrivacyPolicy-error']")).equals(errorText));
                break;
            }
            case "confirmPassword": {

                Assertions.assertThat(getDriver().findElements(By.xpath("//label[@id='confirmPassword-error']")).equals(errorText));
                break;
            }

            default: {
                throw new Error(" Not Found ");

            }
        }
    }


//    @Then("I see {string} error message {string}")
//    public void iSeeErrorMessage(String fieldName, String errorText) {
//
//        Map<String, String> errorT = getData(errorText);
//        error.seeUsernameError(errorT.get(fieldName));
//        error.seeEmailError(errorT.get(fieldName));
//        error.seePasswordFieldError(errorT.get(fieldName));
//        error.seeNameError(errorT.get(fieldName));
//        error.seeAcceptPrivacyPolicyError();
//
//    }
//}


// Home_work_01_19_22

    @When("I fill out {string} field with {string}")
    public void iFillOutFieldWith(String field, String value) {

      //  getDriver().findElement(By.xpath("//input[@name='username']")).sendKeys(value);

//        if (!field.isBlank()) {
//            getDriver().findElement(By.name(field)).clear();
//        }

        getDriver().findElement(By.name(field)).sendKeys(value);



   }


    @Given("I open {string} page")
    public void iOpenPage(String url) {

        getDriver().get(url);
    }

    //Home_work_01_19_22/6

    @When("I fill out name field with first name {string} and last name {string}")
    public void iFillOutNameFieldWithFirstNameAndLastName(String firstName, String lastName) throws InterruptedException {

        getDriver().findElement(By.xpath("//input[@id='name']")).click();


       getDriver().findElement(By.xpath("//input[@id='firstName']")).sendKeys(firstName);

       getDriver().findElement(By.xpath("//input[@id='lastName']")).sendKeys(lastName);

        Thread.sleep(2000);

        getDriver().findElement(By.xpath("//button[@class='ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only']")).click();

    }


    @Then("I verify {string} field value {string}")
    public void iVerifyFieldValue(String nameOfTheField, String actualName) throws InterruptedException {

        getDriver().findElements(By.name(nameOfTheField)).equals(actualName);

        getDriver().findElement(By.xpath("//input[@id='name']")).click();

        Thread.sleep(3000);


    }

    @When("I fill out name field with first name {string}, middle name {string}, last name {string}")
    public void iFillOutNameFieldWithFirstNameMiddleNameLastName(String firstName, String middleName, String lastName) throws InterruptedException {

        getDriver().findElement(By.xpath("//input[@id='firstName']")).sendKeys(firstName);

        getDriver().findElement(By.xpath("//input[@id='middleName']")).sendKeys(middleName);

        getDriver().findElement(By.xpath("//input[@id='lastName']")).sendKeys(lastName);


        Thread.sleep(3000);

        getDriver().findElement(By.xpath("//button[@class='ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only']")).click();


    }
}
