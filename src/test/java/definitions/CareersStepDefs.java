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

    private String username;

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
}