package definitions;

import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import static support.TestContext.getDriver;

public class CalculatorStepDefs {
    @When("I navigate to {string}")
    public void iNavigateTo(String finCalc) {
        getDriver().findElement(By.xpath("//ul[@class='hl']//a[contains(text(), 'Auto Loan')]"));

    }
}
