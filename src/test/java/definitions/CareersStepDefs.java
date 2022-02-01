package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CareerRecruite;
import pages.CareersHome;
import pages.CareersLogin;
import pages.Page;

import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static support.TestContext.getData;

public class CareersStepDefs extends Page {
    CareersHome homePage = new CareersHome();
    CareersLogin loginPage = new CareersLogin();
    CareerRecruite recruitPage = new CareerRecruite();

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
        assertFalse(isElementPresent(recruitPage.getCardPosition()));
    }
}
