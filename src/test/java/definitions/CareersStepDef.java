package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class CareersStepDef {

//    public WebElement getTopNavButton(String caption){
//        return getDriver().findElement(By.xpath("//nav[contains(@class,'fixed-top')]" +
//                                                                     "//button[contains(text(),'" + caption + "')]"));
//    }
//
//    public WebElement getBottomNavButton(String caption){
//        return getDriver().findElement(By.xpath("//nav[contains(@class,'fixed-bottom')]" +
//                                                                     "//button[contains(text(),'" + caption + "')]"));
//    }
//
//    @And("I login as {string}")
//    public void iLoginAs(String role) {
//        getTopNavButton("Login").click();
//        if (role.equals("recruiter")) {
//            getDriver().findElement(By.xpath("//label[@for='loginUsername']" +
//                                             "/following-sibling::input")).sendKeys("student@example.com");
//            getDriver().findElement(By.xpath("//label[@for='loginPassword']" +
//                                             "/following-sibling::input")).sendKeys("welcome");
//        } else {
//            throw new Error("Role \"" + role + "\" is not supported for login.");
//        }
//        getDriver().findElement(By.id("loginButton")).click();
//    }
//
//    @Then("I verify {string} login")
//    public void iVerifyLogin(String role) {
//        assertThat(getTopNavButton("Logout").isDisplayed()).isTrue();
//        if (role.equals("recruiter")) {
//            assertThat(getTopNavButton("Recruit").isDisplayed()).isTrue();
//        } else {
//            throw new Error("Role \"" + role + "\" is not supported for login.");
//        }
//    }
//
//    @When("I remove {string} position")
//    public void iRemovePosition(String position) {
//        getTopNavButton("Recruit").click();
//        assertThat(getTopNavButton("Careers").isDisplayed()).isTrue();
//        WebElement card = getDriver().findElement(By.xpath("//*[contains(@class,'card-title')]" +
//                                         "[contains(text(),'" + position + "')]"));
//        new Actions(getDriver()).moveToElement(card).perform();
//        getDriver().findElement(By.xpath("//*[contains(@class,'card-title')]" +
//                                         "[contains(text(),'" + position + "')]/ancestor::div[2]" +
//                                         "//button[contains(@class,'close')]")).click();
//    }
//
//    @And("I verify {string} position is removed")
//    public void iVerifyPositionIsRemoved(String position) {
//        new WebDriverWait(getDriver(),3,200).until(driver ->
//                            getDriver().findElements(By.xpath("//*[contains(@class,'card-title')]" +
//                                                              "[contains(text(),'" + position + "')]")).size() == 0);
//        getTopNavButton("Careers").click();
//        getTopNavButton("Recruit").click();
//        assertThat(getDriver().findElements(By.xpath("//*[contains(@class,'card-title')]" +
//                                                       "[contains(text(),'" + position + "')]")).size()).isEqualTo(0);
//    }
}
