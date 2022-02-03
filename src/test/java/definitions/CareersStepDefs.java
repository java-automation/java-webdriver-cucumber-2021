package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CareersHome;
import pages.CareersRecruiterPage;
import pages.LoginCareers;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getData;

public class CareersStepDefs {

    LoginCareers loginPage = new LoginCareers();
    CareersHome homePage = new CareersHome();
    CareersRecruiterPage recruitPage = new CareersRecruiterPage();

    Map<String, String> recruiterData = getData("recruiter");


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
}
