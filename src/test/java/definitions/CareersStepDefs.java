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
import pages.CareersNewPosition;
import pages.CareersRecruitPage;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getData;
import static support.TestContext.getDriver;

public class CareersStepDefs {

    CareersHomePage homePage = new CareersHomePage();
    CareersLoginPage loginPage = new CareersLoginPage();
    CareersRecruitPage recruitPage = new CareersRecruitPage();
    CareersNewPosition newPosition = new CareersNewPosition();

    Map<String, String> logins;
    Map<String, String> position;

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

    private void removePositionCommon(String sTitle) {
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.elementToBeClickable(recruitPage.getPositionByTitle(sTitle)));
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].click();", recruitPage.getCloseCardButtonByTitle(sTitle));
    }

    @When("I remove {string} position")
    public void iRemovePosition(String sPosition) {
        homePage.recruitButton.click();
        removePositionCommon(sPosition);
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

    @When("I create new position")
    public void iCreateNewPosition() {
        position = getData("newPosition");
        homePage.recruitButton.click();
        recruitPage.clickNewPositionLink();
        newPosition.setPositionTitle(position.get("title"));
        newPosition.setPositionDescription(position.get("description"));
        newPosition.setPositionCity(position.get("city"));
        newPosition.setPositionStateByVisibleText(position.get("state"));
        newPosition.setPositionDateOpen(position.get("dateOpen"));
        newPosition.clickSubmitButton();
    }

    @Then("I verify new position is created")
    public void iVerifyNewPositionIsCreated() {
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.elementToBeClickable(recruitPage.getPositionByTitle(position.get("title"))));
    }

    @When("I remove new position")
    public void iRemoveNewPosition() {
        removePositionCommon(position.get("title"));
    }

    @And("I verify new position is removed")
    public void iVerifyNewPositionIsRemoved() {
        iVerifyPositionIsRemoved(position.get("title"));
    }
}
