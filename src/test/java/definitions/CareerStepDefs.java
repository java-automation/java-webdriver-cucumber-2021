package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CareerLogin;
import pages.CareersHome;
import pages.CareersRecruit;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getData;

public class CareerStepDefs {
    CareersHome homePage = new CareersHome();
    CareerLogin loginPage = new CareerLogin();
    CareersRecruit recruitPage = new CareersRecruit();


    @And("I login as {string}")
    public void iLoginAs(String role) {
        Map<String,String> recruiter = getData(role, "career");

        homePage.clickLogin();
        loginPage.login(recruiter);

    }

    @Then("I verify {string} login")
    public void iVerifyLogin(String role) {
        Map<String,String> recruiter = getData(role, "career");
        String actualName = homePage.getLoggedUserNameText();
        assertThat(recruiter.get("name")).isEqualTo(actualName);
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
        recruitPage.openNewPosition();

        Map<String,String> data = getData("position", "career");




    }
}
