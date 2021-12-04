package definitions;

import io.cucumber.java.en.Given;

import static support.TestContext.getDriver;

public class GenericStepDefs {
    @Given("I go to the {string} page")
    public void iGoToThePage(String url) {

            getDriver().get(url);
        }
    }
