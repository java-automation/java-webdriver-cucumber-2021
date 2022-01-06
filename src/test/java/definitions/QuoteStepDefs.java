package definitions;

import io.cucumber.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import static support.TestContext.getDriver;

public class QuoteStepDefs {
    @And("I select few element in Car Make list with Action")
    public void iSelectFewElementInCarMakeListWithAction() {
        new Actions(getDriver()).click(getDriver().findElement(By.xpath("//select[@name='carMake']/option[normalize-space()='Toyota']")))
                .keyDown(Keys.CONTROL)
                .click(getDriver().findElement(By.xpath("//select[@name='carMake']/option[normalize-space()='Other']")))
                .keyUp(Keys.CONTROL)
                .perform();
    }

    @And("I select few elements in Car Make list with Select Class")
    public void iSelectFewElementsInCarMakeListWithSelectClass() {
        Select carMake = new Select(getDriver().findElement(By.xpath("//select[@name='carMake']")));
        carMake.selectByVisibleText("Toyota");
        carMake.selectByVisibleText("Other");
    }
}
