package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.*;

import java.util.Map;

import static org.junit.Assert.assertEquals;
import static support.TestContext.getData;

public class CareersStepDefs extends Page {
    CareersHome homePage = new CareersHome();
    CareersLogin loginPage = new CareersLogin();
    CareerRecruit recruitPage = new CareerRecruit();
    CareersNewPosition newPosition = new CareersNewPosition();

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
        Assertions.assertThat(isVisible).isFalse();
    }

    @When("I create new position")
    public void iCreateNewPosition() {
        Map<String, String> newPositionData = getData("new_position", "careers");
        homePage.clickRecruit();
        recruitPage.clickNewPosition();
        newPosition.fillTitle(newPositionData.get("title"));
        System.out.println(newPositionData.get("description"));
        newPosition.fillDescription(newPositionData.get("description"));
        newPosition.fillCity(newPositionData.get("city"));
        newPosition.fillState(newPositionData.get("state"));
        newPosition.fillDateOpen(newPositionData.get("dateOpen"));
        newPosition.submit();
    }

    @Then("I verify new position is created")
    public void iVerifyNewPositionIsCreated() {
        Map<String, String> newPositionData = getData("new_position", "careers");
        wait.until(ExpectedConditions.visibilityOf(recruitPage.positionCard(newPositionData.get("title"))));
        Assert.assertTrue(recruitPage.isPositionCardVisible(newPositionData.get("title")));

    }

    @When("I remove new position")
    public void iRemoveNewPosition() {
        Map<String, String> newPositionData = getData("new_position", "careers");
        recruitPage.removePositionByTitle(newPositionData.get("title"));
    }

    @And("I verify new position is removed")
    public void iVerifyNewPositionIsRemoved() {
        Map<String, String> newPositionData = getData("new_position", "careers");
        iVerifyPositionIsRemoved(newPositionData.get("title"));
    }
}
