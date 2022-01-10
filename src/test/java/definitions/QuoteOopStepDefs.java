package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.QuoteForm;
import pages.QuoteSubmittedPage;

import java.util.Map;

import static support.TestContext.getData;

public class QuoteOopStepDefs {

    QuoteForm form = new QuoteForm();

    QuoteSubmittedPage page = new QuoteSubmittedPage();




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
}
