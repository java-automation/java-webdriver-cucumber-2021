package definitions;

import io.cucumber.java.en.*;
import org.junit.*;
import org.openqa.selenium.*;
import pages.*;

import java.util.*;

import static support.TestContext.getData;


public class QuoteOopStepDefs {

    QuoteForm form = new QuoteForm();
    QuoteResults results = new QuoteResults();


    @Given("I go to {string} page and print details oop")
    public void iGoToPageAndPrintDetailsOop(String page) {
        form.open();
    }

    @When("I fill out {string} required fields oop")
    public void iFillOutRequiredFieldsOop(String userType) {
        Map<String, String> user = getData(userType);
        form.fillUsername(user.get("username"));
        form.fillEmail(user.get("email"));
        form.fillPasswordFields(user.get("password"));
        form.fillName(user.get("firstname"), user.get("lastname"));
        form.acceptPrivacyPolicy();
    }

    @And("I submit the page oop")
    public void iSubmitThePageOop() {
        form.submit();
    }

    @Then("I verify {string} required fields oop")
    public void iVerifyTheRequiredFieldsOop(String userType) {
        Map<String, String> user = getData(userType);
        Assert.assertEquals(user.get("username"), results.getUsernameValue());
        Assert.assertEquals(user.get("email"), results.getEmailValue());
        Assert.assertTrue(results.getPasswordValue());
        Assert.assertEquals(user.get("firstname"), results.getFirstNameValue());
        Assert.assertEquals(user.get("lastname"), results.getLastNameValue());
        Assert.assertTrue(results.getNameValue());
        Assert.assertTrue(results.getPrivacyPolicyValue());
    }

}
