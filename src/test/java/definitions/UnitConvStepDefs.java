package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class UnitConvStepDefs {
    @Then("I choose {string} tab")
    public void iChooseTab(String sTab) {
        WebElement selectedTab = getDriver().findElement(By.xpath("//li[@id='menuon']/a"));
        if (!selectedTab.getText().trim().equals(sTab)) {
            getDriver().findElement(By.xpath("//a[normalize-space()='" + sTab + "']")).click();
        }
    }

    @And("I set from {string} to {string} units")
    public void iSetFromToUnits(String sFromUnit, String sToUnit) {
        getDriver().findElement(By.xpath("//select[@id='calFrom']/option[normalize-space()='" + sFromUnit + "']")).click();
        getDriver().findElement(By.xpath("//select[@id='calTo']/option[normalize-space()='" + sToUnit + "']")).click();
    }

    @Then("I set {string} to From field and check result is {string}")
    public void iSetToFromFieldAndCheckResultIs(String sValue, String sResult) {
        // first algorithm
//        double dToVal;
//        double dResult = Double.parseDouble(sResult);
//        getDriver().findElement(By.xpath("//input[@name='fromVal']")).sendKeys(sValue);
//        dToVal = Double.parseDouble(getDriver().findElement(By.xpath("//input[@name='toVal']")).getAttribute("value"));
//        assertThat(String.format("%.1f",dToVal)).isEqualTo(String.format("%.1f",dResult));
        // second algorithm
        String sToVal = "";
        getDriver().findElement(By.xpath("//input[@name='fromVal']")).sendKeys(sValue);
        sToVal = getDriver().findElement(By.xpath("//input[@name='toVal']")).getAttribute("value");
        assertThat(sToVal).contains(sResult);
    }

}
