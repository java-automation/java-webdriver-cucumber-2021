package definitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class DataTablesStepDefs {
    @When("I type <query> into element with xpath {string}")
    public void iTypeStringIntoElementWithXpath(String searchQuery, String xpath) {
        getDriver().findElement(By.xpath(xpath)).sendKeys(searchQuery);
    }

    @Then("element with xpath {string} should contain text <text>")
    public void elementWithXpathShouldContainTextString(String xpath, String expectedText) {
        String actualText = getDriver().findElement(By.xpath(xpath)).getText();
        assertThat(actualText).containsIgnoringCase(expectedText);
    }

    @Given("I print data From DataTable")
    public void iPrintDataFromDataTable(DataTable table) {
        List<Map<String, String>> data = table.asMaps();
        System.out.println(data);
        for (Map<String, String> element : data) {
            System.out.println(element.get("query"));
        }
    }
}
