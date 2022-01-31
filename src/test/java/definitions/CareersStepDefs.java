package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CareersHomePage;
import pages.CareersLoginPage;
import pages.CareersRecruitPage;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getData;
import static support.TestContext.getDriver;

public class CareersStepDefs {

    CareersHomePage homePage = new CareersHomePage();
    CareersLoginPage loginPage = new CareersLoginPage();
    CareersRecruitPage recruitPage = new CareersRecruitPage();

    Map<String, String> logins;

    @And("I login as {string}")
    public void iLoginAs(String sRole) {
        logins = getData("recruiter");
        homePage.loginButton.click();
        loginPage.setUsername(logins.get("login"));
        loginPage.setPassword(logins.get("password"));
        loginPage.submitButton.click();
    }

    @Then("I verify {string} login")
    public void iVerifyLogin(String sRole) {
        new WebDriverWait(getDriver(), 5).until(ExpectedConditions.elementToBeClickable(homePage.logoutButton));
        assertThat(homePage.getLoginName()).isEqualTo(logins.get("name"));
    }

    @When("I remove {string} position")
    public void iRemovePosition(String sPosition) {
        homePage.recruitButton.click();
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.elementToBeClickable(recruitPage.getPositionByTitle(sPosition)));
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].click();", recruitPage.getCloseCardButtonByTitle(sPosition));
    }

    @And("I verify {string} position is removed")
    public void iVerifyPositionIsRemoved(String sTitle) {
        try {
            new WebDriverWait(getDriver(), 10).until(ExpectedConditions.invisibilityOfElementLocated(recruitPage.getPositionByTitle(sTitle)));
            assertThat(getDriver().findElement(recruitPage.getPositionByTitle(sTitle)).isDisplayed()).isFalse();
        } catch (NoSuchElementException e) {
            assertThat(true).isTrue();
        }
    }
}
