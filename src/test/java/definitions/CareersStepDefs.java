package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CareersHome;
import pages.CareersRecruiterPage;
import pages.LoginCareers;
import pages.OpenPositionCareers;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getData;

public class CareersStepDefs {

    LoginCareers loginPage = new LoginCareers();
    CareersHome homePage = new CareersHome();
    CareersRecruiterPage recruitPage = new CareersRecruiterPage();
    OpenPositionCareers newPosition = new OpenPositionCareers();

    Map<String, String> recruiterData = getData("recruiter");
    Map<String, String> createPosition = getData("newPosition");


    @And("I login as {string}")
    public void iLoginAs(String userType)  {

        homePage.clickLogin();
        loginPage.login(recruiterData.get("username"),recruiterData.get("password"));

//        loginPage.fillUserName(user.get("username"));
//        loginPage.fillPassword(user.get("password"));
//        loginPage.clickSubmit();

    }

    @Then("I verify {string} login")
    public void iVerifyLogin(String userType) {
        Map<String, String> recruiterData = getData(userType);
        String actualName = homePage.getLoggedUserNameText();
        assertThat(actualName).isEqualTo(recruiterData.get("name"));


    }

    @When("I remove {string} position")
    public void iRemovePosition(String title) throws InterruptedException {
        homePage.clickRecruit();
        Thread.sleep(1000);
        recruitPage.removePositionByTitle(title);
    }

    @And("I verify {string} position is removed")
    public void iVerifyPositionIsRemoved(String title) {
        boolean isVisible = recruitPage.isPositionCardVisible(title);
        assertThat(isVisible).isFalse();
    }

    @When("I create new position")
    public void iCreateNewPosition()  {
        homePage.clickRecruit();
        recruitPage.clickNewPosition();


        newPosition.fillOutTitle(createPosition.get("title"));
        newPosition.fillDescription(createPosition.get("description"));
        newPosition.fillOutCity(createPosition.get("city"));
       // newPosition.fillOutState(createPosition.get("state"));
        newPosition.fillOutDate(createPosition.get("date open"));

        newPosition.fillOutState();

        newPosition.clickSubmitPosition();


    }

    @Then("I verify new position is created")
    public void iVerifyNewPositionIsCreated() {

        recruitPage.getResultOfNewPosition();

    }

    @When("I remove new position")
    public void iRemoveNewPosition() {

        recruitPage.removePositionByTitle("Senior QA Engineer in test");

    }

    @And("I verify new position is removed")
    public void iVerifyNewPositionIsRemoved() {
        boolean isVisible = recruitPage.isPositionCardVisible("Senior QA Engineer in test");
        assertThat(isVisible).isFalse();

    }
}
