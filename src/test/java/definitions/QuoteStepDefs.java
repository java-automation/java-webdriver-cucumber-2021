package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import java.util.Locale;

import static support.TestContext.getDriver;

public class QuoteStepDefs {
    @When("I fill out required fields")
    public void iFillOutRequiredFields() {
        getDriver().findElement(By.xpath("//input[@name='username']")).sendKeys("jdoe");
        getDriver().findElement(By.xpath("//input[@name='email']")).sendKeys("jdoe@example.com");
    }

    @And("I print url for {string} page")
    public void iPrintUrlForPage(String page) {
        if (page.toLowerCase().equals("google")) {
            System.out.println("https://google.com");
        } else {
            throw new Error("Unknown url for page: "+page);
        }
    }
}
