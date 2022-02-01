package definitions;

import io.cucumber.java.en.*;
import org.junit.*;
import pages.*;

import java.util.*;

import static support.TestContext.getData;


public class CareersStepDefs {

    CareersForm form = new CareersForm();

    @And("I login as {string}")
    public void iLoginAs(String user) throws InterruptedException {
        form.login();
    }

    @Then("I verify {string} login")
    public void iVerifyLogin(String user) {
        form.verifyLogin();
    }

    @When("I remove {string} position")
    public void iRemovePosition(String position) throws InterruptedException {
        form.getRecruitPage();
        form.deletePosition(position);
    }

    @And("I verify {string} position is removed")
    public void iVerifyPositionIsRemoved(String position) {
        Assert.assertFalse(form.positionExists(position));
    }
}
