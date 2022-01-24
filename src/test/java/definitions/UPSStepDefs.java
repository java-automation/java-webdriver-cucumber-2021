package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import support.TestContext;

import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static support.TestContext.getDriver;

public class UPSStepDefs extends HelperStepDefs {
    public static final By CONFIRM_BUTTON = By.xpath("//button[@id='preferences_prompt_submit'][contains(text(),'Confirm')]");
    public static final By CLOSE_BUTTON_WEBSITE_COOKIES = By.xpath("//div[@class='implicit_privacy_prompt implicit_consent']/button/span[@class='icon ups-icon-x']");
    public static final By DROP_DOWN_MENU_ADDRESS = By.xpath("//ngb-typeahead-window[@class='dropdown-menu show ng-star-inserted']/button");
    public static final By DROP_DOWN_MENU_ADDRESS_SUGGESTED_ADDRESSES = By.xpath("//ngb-typeahead-window[@class='dropdown-menu show ng-star-inserted']/button/ngb-highlight");
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
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@id='origin-cac_country']")));
        if (isVisible(CLOSE_BUTTON_WEBSITE_COOKIES)) {
            getDriver().findElement(CLOSE_BUTTON_WEBSITE_COOKIES).click();
        }
        new Select(getDriver().findElement(By.xpath("//select[@id='origin-cac_country']")))
                .selectByVisibleText(user.get("country"));
        getDriver().findElement(By.xpath("//input[@id='origin-cac_companyOrName']"))
                .sendKeys(("%s %s").formatted(user.get("firstName"), user.get("lastName")));
        new Actions(getDriver())
                .sendKeys(getDriver().findElement(By.xpath("//input[@id='origin-cac_singleLineAddress']")),
                        user.get("street"))
                .perform();
        Thread.sleep(3000);
        new Actions(getDriver())
                .sendKeys(getDriver().findElement(By.xpath("//input[@id='origin-cac_singleLineAddress']")), Keys.ENTER)
                .perform();
        cookieSettingsWindowBlocks();
        Thread.sleep(3000);
        if (isPresent(By.xpath("//input[@id='origin-cac_addressLine1']"))) {
            cookieSettingsWindowBlocks();
            assertEquals(getDriver().findElement(By.xpath("//input[@id='origin-cac_addressLine1']"))
                            .getAttribute("value"),
                    user.get("street"));
        } else if (isPresent(By.xpath("//div[@class='ng-star-inserted']/p[@class='ng-star-inserted']"))) {
            cookieSettingsWindowBlocks();
            String enteredAddress = getDriver().findElement(By.xpath("//div[@class='ng-star-inserted']/p[@class='ng-star-inserted']"))
                    .getText();
            System.out.println("Entered Address: " + enteredAddress);
            Assert.assertTrue(enteredAddress.contains(user.get("street")));
        } else {
            cookieSettingsWindowBlocks();
            assertEquals(
                    getDriver().findElement(By.xpath("//input[@id='origin-cac_singleLineAddress']"))
                            .getAttribute("value"),
                    user.get("street"));
        }
        cookieSettingsWindowBlocks();
        //  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='origin-cac_postalCode']")));
        cookieSettingsWindowBlocks();
        if (isPresent(By.xpath("//input[@id='origin-cac_postalCode']"))) {
            getDriver().findElement(By.xpath("//input[@id='origin-cac_postalCode']"))
                    .sendKeys(user.get("zipcode"));
            getDriver().findElement(By.xpath("//input[@id='origin-cac_city']"))
                    .sendKeys(user.get("city"));
            new Select(getDriver().findElement(By.xpath("//select[@id='origin-cac_state']")))
                    .selectByVisibleText(user.get("state"));
        }

        cookieSettingsWindowBlocks();
        getDriver().findElement(By.xpath("//input[@id='origin-cac_email']"))
                .sendKeys(user.get("email"));
        cookieSettingsWindowBlocks();
        getDriver().findElement(By.xpath("//input[@id='origin-cac_phone']"))
                .sendKeys(user.get("phone"));
        cookieSettingsWindowBlocks();

    }

    private void cookieSettingsWindowBlocks() {
        if (isPresent(CONFIRM_BUTTON)) {
            getDriver().findElement(CONFIRM_BUTTON).click();
            wait.until(ExpectedConditions.invisibilityOfElementLocated(CONFIRM_BUTTON));
        }
    }

    @And("I submit the shipment form")
    public void iSubmitTheShipmentForm() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@id='nbsBackForwardNavigationContinueButton']"))).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='ups-section']")));
    }

    @Then("I verify origin shipment fields submitted")
    public void iVerifyOriginShipmentFieldsSubmitted() {
        String shipTo = getDriver().findElement(By.xpath("//div[@class='ups-section']")).getText();
        System.out.println("Ship to: " + shipTo);
        assertTrue(shipTo.contains(user.get("street")));
    }
}
