package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class QuoteStepDefs {
    @When("I fill out required fields")
    public void iFillOutRequiredFields() {
        getDriver().findElement(By.name("username")).sendKeys("Julia");
        getDriver().findElement(By.name("email")).sendKeys("yulia@example.com");
        getDriver().findElement(By.name("password")).sendKeys("12345");
        getDriver().findElement(By.name("confirmPassword")).sendKeys("12345");
        getDriver().findElement(By.name("name")).sendKeys("Julia K");
        getDriver().findElement(By.name("agreedToPrivacyPolicy")).click();
    }

    @And("I submit the form")
    public void iSubmitTheForm() {
        getDriver().findElement(By.id("formSubmit")).click();
    }

    @Then("I verify the required fields after submitting")
    public void iVerifyTheRequiredFieldsAfterSubmitting() {
     String usernameResult = getDriver().findElement(By.name("username")).getText();
     String emailResult = getDriver().findElement(By.name("email")).getText();
     String passwordResult = getDriver().findElement(By.name("password")).getText();
     String nameResult = getDriver().findElement(By.name("name")).getText();
     String agreedToPrivacyPolicyResult = getDriver().findElement(By.name("agreedToPrivacyPolicy")).getText();

        assertThat(usernameResult).isEqualTo("Julia");
        assertThat(emailResult).isEqualTo("yulia@example.com");
        assertThat(passwordResult).isEqualTo("[entered]");
        assertThat(passwordResult).doesNotContain("12345");
        assertThat(nameResult).isEqualTo("Julia K");
        assertThat(agreedToPrivacyPolicyResult).isEqualTo("true");

    }


}
