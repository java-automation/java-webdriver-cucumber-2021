package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CareersHome;
import pages.CareersLogin;
import pages.CareersNewPosition;
import pages.CareersRecruit;

import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static support.TestContext.getData;

public class CareersStepDefs {

    private final CareersHome homePage = new CareersHome();
    private final CareersLogin loginPage = new CareersLogin();
    private final CareersRecruit recruitPage = new CareersRecruit();
    private final CareersNewPosition newPositionPage = new CareersNewPosition();

    private String username;
    private Map<String, String> positionData;

    @When("I login as {string}")
    public void iLoginAs(String role) {
        homePage.openLoginPage();

        Map<String, String> credentials = getData("recruiter", "secrets/careers");
        String email = credentials.get("email");
        username = email.substring(0, email.indexOf('@'));

        loginPage.login(credentials);
    }

    @Then("I verify {string} login")
    public void iVerifyLogin(String role) {
        assertThat(homePage.isLogOutButtonPresent()).isTrue();
        assertThat(homePage.getProfileName().toLowerCase()).isEqualTo(username);
        if (role.equals("recruiter")) {
            assertThat(homePage.isRecruitButtonPresent()).isTrue();
        }
    }

    @When("I remove {string} position")
    public void iRemovePosition(String positionTitle) {
        homePage.openRecruitPage();
        recruitPage.removePosition(positionTitle);
    }

    @And("I verify {string} position is removed")
    public void iVerifyPositionIsRemoved(String positionTitle) {
        assertThat(recruitPage.isPositionVisible(positionTitle)).isFalse();
    }

    @When("I create new position")
    public void iCreateNewPosition() {
        homePage.openRecruitPage();
        recruitPage.clickNewPosition();
        positionData = getData("position", "careers");
        newPositionPage.createPositionFromMap(positionData);
    }

    @Then("I verify new position is created")
    public void iVerifyNewPositionIsCreated() {
        assertThat(recruitPage.isPositionVisible(positionData.get("title"))).isTrue();
    }

    @When("I remove new position")
    public void iRemoveNewPosition() {
        recruitPage.removePosition(positionData.get("title"));
    }

    @And("I verify new position is removed")
    public void iVerifyNewPositionIsRemoved() {
        assertThat(recruitPage.isPositionVisible(positionData.get("title"))).isFalse();
    }
}