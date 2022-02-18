package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.*;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static support.TestContext.getData;
import static support.TestContext.getPositionDataFromFile;

public class CareersStepDefs extends Page {
    CareersHome homePage = new CareersHome();
    CareersLogin loginPage = new CareersLogin();
    CareerRecruit recruitPage = new CareerRecruit();
    CareersNewPosition newPositionPage = new CareersNewPosition();
    Map<String, String> newPositionData = getData("new_position", "careers");
    Map<String, String> automation = getPositionDataFromFile("automation", "positions");

    @And("I login as {string}")
    public void iLoginAs(String role) {
        Map<String, String> careersData = getData(role, "careers");
        homePage.clickLogin();
        loginPage.login(careersData.get("username"), careersData.get("password"));
    }

    @Then("I verify {string} login")
    public void iVerifyLogin(String role) {
        Map<String, String> careersData = getData(role, "careers");
        assertEquals(homePage.getLoggedUserName(), careersData.get("name"));
    }

    @When("I remove {string} position")
    public void iRemovePosition(String title) {
        homePage.clickRecruit();
        recruitPage.removePositionByTitle(title);
    }

    @And("I verify {string} position is removed")
    public void iVerifyPositionIsRemoved(String title) {
        boolean isVisible = recruitPage.isPositionCardVisible(title);
        assertThat(isVisible).isFalse();
    }

    @When("I create new position")
    public void iCreateNewPosition() {
        homePage.clickRecruit();
        recruitPage.clickNewPosition();
        newPositionPage.createPosition(automation);
    }

    @Then("I verify new position is created")
    public void iVerifyNewPositionIsCreated() {
        assertTrue(recruitPage.isPositionCardVisible(automation.get("title")));
    }

    @When("I remove new position")
    public void iRemoveNewPosition() {
        throw new Error("Position " + automation.get("title") + " is not removed!");
        // recruitPage.removePositionByTitle(automation.get("title"));
    }

    @And("I verify new position is removed")
    public void iVerifyNewPositionIsRemoved() {
        iVerifyPositionIsRemoved(automation.get("title"));
    }
}
