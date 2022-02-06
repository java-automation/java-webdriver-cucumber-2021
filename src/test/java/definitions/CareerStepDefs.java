package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CareerLogin;
import pages.CareerNewPositionPage;
import pages.CareersHome;
import pages.CareersRecruit;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getData;

public class CareerStepDefs {
    CareersHome homePage = new CareersHome();
    CareerLogin loginPage = new CareerLogin();
    CareersRecruit recruitPage = new CareersRecruit();
    CareerNewPositionPage newPositionPage = new CareerNewPositionPage();
    Map<String,String> data;


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
        data = getData("position", "career");
        homePage.clickRecruit();
        recruitPage.openNewPosition();
        newPositionPage.createPosition(data);
        newPositionPage.clickSubmit();



    }

    @Then("I verify new position is created")
    public void iVerifyNewPositionIsCreated() {
    }
}
