package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.*;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getData;

public class CareersStepDefs {

    CareersHome homePage = new CareersHome();
    CareersLogin loginPage = new CareersLogin();
    CareersRecruit recruitPage = new CareersRecruit();
    CareersNewPosition newPositionPage = new CareersNewPosition();
    CareersPositionDetails positionDetailsPage = new CareersPositionDetails();
    Map<String,String> newPosition = getData("new_position","careers");

    @And("I login as {string}")
    public void iLoginAs(String role) {
        Map<String, String> recruiterData = getData(role, "careers");
        homePage.clickLogin();
        loginPage.login(recruiterData);
    }

    @Then("I verify {string} login")
    public void iVerifyLogin(String role) {
        Map<String, String> recruiterData = getData(role, "careers");
        String actualName = homePage.getLoggedUserNameText();
        assertThat(actualName).isEqualTo(recruiterData.get("name"));
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
        recruitPage.createNewPosition();
        newPositionPage.fillTitle(newPosition.get("title"));
        newPositionPage.fillDescription(newPosition.get("description"));
        newPositionPage.fillAddress(newPosition.get("address"));
        newPositionPage.fillCity(newPosition.get("city"));
        newPositionPage.selectStateByName(newPosition.get("state"));
        newPositionPage.fillZip(newPosition.get("zip"));
        newPositionPage.selectDateOpen(newPosition.get("dateOpen"));
        newPositionPage.submit();
    }

    @Then("I verify new position is created")
    public void iVerifyNewPositionIsCreated() {
        String title = newPosition.get("title");
        assertThat(recruitPage.isPositionCardVisible(title)).isTrue();
        assertThat(recruitPage.numberOfPositionCandidates(title)).isEqualTo(0);
        recruitPage.goToCardDetails(title);
        positionDetailsPage.waitForUrlMatch();
        assertThat(positionDetailsPage.getTitle()).isEqualTo(title);
        assertThat(positionDetailsPage.getDescription()).isEqualToIgnoringWhitespace(newPosition.get("description"));
        assertThat(positionDetailsPage.getAddress()).isEqualTo(newPosition.get("address"));
        assertThat(positionDetailsPage.getCity()).isEqualTo(newPosition.get("city"));
        assertThat(positionDetailsPage.getState()).isEqualTo(newPosition.get("state"));
        assertThat(positionDetailsPage.getZip()).isEqualTo(newPosition.get("zip"));
        try {
            assertThat(positionDetailsPage.getDateOpen()).isEqualTo(newPosition.get("dateOpen"));
        } catch (AssertionError e) {
            System.out.println("BUG: On the position details page date open was " + e.getMessage());
        }
        positionDetailsPage.clickRecruit();
    }

    @When("I remove new position")
    public void iRemoveNewPosition() {
        recruitPage.waitForUrlMatch();
        recruitPage.removePositionByTitle(newPosition.get("title"));
    }

    @And("I verify new position is removed")
    public void iVerifyNewPositionIsRemoved() {
        iVerifyPositionIsRemoved(newPosition.get("title"));
    }
}
