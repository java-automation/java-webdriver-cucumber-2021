package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import support.TestContext;

import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static support.TestContext.getDriver;

public class UPSStepDefs extends HelperStepDefs {
    private final WebDriverWait wait = new WebDriverWait(getDriver(), 10, 200);
    Map<String, String> user = TestContext.getData("user");

    @And("I go to {string}")
    public void iGoToCreateAShipment(String textLink) {
        if (getDriver().findElement(By.xpath("//span[@class='icon ups-icon-hamburger']")).isDisplayed()) {
            getDriver().findElement(By.xpath("//span[@class='icon ups-icon-hamburger']")).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'hamburger-menu show')]")));
            getDriver().findElements(By.xpath("//div[contains(@class,'hamburger-menu show')]//li[@class='nav-item']/a"))
                    .stream().filter(el -> el.getText().equals("Shipping"))
                    .collect(Collectors.toList())
                    .get(0).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'hamburger-menu')]//div[@class='sub-menu collapse show']")));
            getDriver().findElements(By.xpath("//div[contains(@class,'hamburger-menu')]//div[@class='sub-menu collapse show']//a"))
                    .stream().filter(el -> el.getText().equals(textLink))
                    .collect(Collectors.toList())
                    .get(0).click();

        } else {
            getDriver().findElement(By.xpath("//div[@id='ups-navigation-container'][1]//a[@id='mainNavDropdown1']")).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='mainNavMenu1']//a")));
            new Actions(getDriver())
                    .moveToElement(
                            getDriver().findElements(By.xpath("//div[@id='mainNavMenu1']//a"))
                                    .stream().filter(el -> el.getText().equals(textLink))
                                    .collect(Collectors.toList())
                                    .get(0))
                    .click()
                    .perform();
        }
        wait.until(ExpectedConditions.textToBePresentInElement(getDriver().findElement(By.xpath("//h1/span")), "Create a Shipment"));
    }

    @When("I fill out origin shipment fields")
    public void iFillOutOriginShipmentFields() throws InterruptedException {
        new Select(getDriver().findElement(By.xpath("//select[@id='origin-cac_country']")))
                .selectByVisibleText(user.get("country"));
        getDriver().findElement(By.xpath("//input[@id='origin-cac_companyOrName']"))
                .sendKeys(("%s %s").formatted(user.get("firstName"), user.get("lastName")));
        new Actions(getDriver())
                .sendKeys(getDriver().findElement(By.xpath("//input[@id='origin-cac_singleLineAddress']")),
                        user.get("street"))
                .perform();
        Thread.sleep(10000);
        // PredefinedStepDefs.iDismissAlert();
        // getDriver().findElement(By.xpath("//input[@id='origin-cac_singleLineAddress']")).sendKeys(user.get("street"));
        if (isPresent(By.xpath("//input[@id='origin-cac_addressLine1']"))) {
            assertEquals(getDriver().findElement(By.xpath("//input[@id='origin-cac_addressLine1']"))
                            .getAttribute("value"),
                    user.get("street"));
        } else {
            assertEquals(
                    getDriver().findElement(By.xpath("//input[@id='origin-cac_singleLineAddress']"))
                            .getAttribute("value"),
                    user.get("street"));
        }
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='origin-cac_postalCode']")));
        getDriver().findElement(By.xpath("//input[@id='origin-cac_postalCode']"))
                .sendKeys(user.get("zipcode"));
        getDriver().findElement(By.xpath("//input[@id='origin-cac_city']"))
                .sendKeys(user.get("city"));
        new Select(getDriver().findElement(By.xpath("//select[@id='origin-cac_state']")))
                .selectByVisibleText(user.get("state"));
        getDriver().findElement(By.xpath("//input[@id='origin-cac_email']"))
                .sendKeys(user.get("email"));
        getDriver().findElement(By.xpath("//input[@id='origin-cac_phone']"))
                .sendKeys(user.get("phone"));

    }

    @And("I submit the shipment form")
    public void iSubmitTheShipmentForm() {

        getDriver().findElement(By.xpath("//button[@id='nbsBackForwardNavigationContinueButton']")).click();
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='ups-section']")));
    }
}
