package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.QuoteForm;
import support.TestContext;

import java.util.Map;

public class QuoteOopStepDefs {

    QuoteForm form = new QuoteForm();


    @Given("I go to {string} page oop")
    public void iGoToPageOop(String urlString) {
        if (urlString.equals("quote")) {
            form.open("https://skryabin.com/market/quote.html");
        } else throw new Error("Unknown page to open!");
    }

    @When("I fill out {string} required fields oop")
    public void iFillOutRequiredFieldsOop(String userType) {
        Map<String, String> user = TestContext.getData(userType);
        form.fillUsername(user.get("username"));
        form.fillName(user);
        form.fillEmail(user.get("email"));
        form.fillPassword(user.get("password"));
        form.selectPrivacyPolicy();
    }

    @And("I submit the page oop")
    public void iSubmitThePageOop() {
        form.submit();
    }


}
