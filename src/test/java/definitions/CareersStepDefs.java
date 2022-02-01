package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import pages.LoginCareers;

import java.util.Map;

import static support.TestContext.getData;
import static support.TestContext.getDriver;

public class CareersStepDefs {

    LoginCareers loginPage = new LoginCareers();

    Map<String, String> user = getData("recruiter");


    @And("I login as {string}")
    public void iLoginAs(String userType)  {

        getDriver().findElement(By.xpath("//i[@class='fa fa-fw fa-sign-in']")).click();


        loginPage.fillUserName(user.get("username"));
        loginPage.fillPassword(user.get("password"));

        loginPage.clickSubmit();

    }

    @Then("I verify {string} login")
    public void iVerifyLogin(String userType) {


    }
}
