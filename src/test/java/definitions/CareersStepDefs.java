package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CareersHome;
import pages.CareersLogin;
import pages.CareersRecruit;

import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static support.TestContext.getData;

public class CareersStepDefs {

    private final CareersHome homePage = new CareersHome();
    private final CareersLogin loginPage = new CareersLogin();
    private final CareersRecruit recruitPage = new CareersRecruit();


    private Map<String, String> credentials;

    @When("I login as {string}")
    public void iLoginAs(String role) {
        homePage.openLoginPage();
        credentials = getData("recruiter", "secrets/careersSecrets");
        loginPage.fillUsername(credentials.get("login"));
        loginPage.fillPassword(credentials.get("password"));
        loginPage.submitCredentials();
    }

    @Then("I verify {string} login")
    public void iVerifyLogin(String role) {
        assertThat(homePage.isLogOutButtonPresent()).isTrue();
        String login = credentials.get("login");
        String profileName = login.substring(0, login.indexOf('@'));
        assertThat(homePage.getProfileName().toLowerCase()).isEqualTo(profileName);
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
}