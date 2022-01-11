package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;
import static support.TestContext.getData;
import static support.TestContext.getDriver;

public class QuoteStepDefs {

    private Map<String, String> workingProfile;
    private boolean isCompleteForm;

    @And("Submit the form")
    public void submitTheForm() {
        getDriver().findElement(By.xpath("//*[@id='formSubmit']")).click();
    }

    private void verifyElementValueInSummary(String relSummaryXPath, String value) {
        assertThat(getDriver().findElement(By.xpath("//*[@id='quotePageResult']" + relSummaryXPath)).getText()).isEqualTo(value);
    }

    /*
        This method assumes that workingProfile has been associated with one of the existing presets and
        fullForm need to be true for full verification
    */
    @Then("I verify that submitted fields got saved correctly")
    public void iVerifyThatSubmittedFieldsGotSavedCorrectly() {
        verifyElementValueInSummary("//*[@name='username']", workingProfile.get("username"));
        verifyElementValueInSummary("//*[@name='email']", workingProfile.get("email"));
        verifyElementValueInSummary("//*[@name='password']", "[entered]");

        String firstName = workingProfile.get("firstName");
        String middleName = workingProfile.get("middleName");
        String lastName = workingProfile.get("lastName");
        verifyElementValueInSummary("//*[@name='name']", firstName + " " + middleName + " " + lastName);
        verifyElementValueInSummary("//*[@name='firstName']", firstName);
        verifyElementValueInSummary("//*[@name='middleName']", middleName);
        verifyElementValueInSummary("//*[@name='lastName']", lastName);

        verifyElementValueInSummary("//*[@name='agreedToPrivacyPolicy']", "true");

        if (isCompleteForm) {
            verifyElementValueInSummary("//*[@name='phone']", workingProfile.get("phone"));
            verifyElementValueInSummary("//*[@name='dateOfBirth']", workingProfile.get("dateOfBirth"));
            verifyElementValueInSummary("//*[@name='countryOfOrigin']", workingProfile.get("countryOfOrigin"));
            verifyElementValueInSummary("//*[@name='gender']", workingProfile.get("gender"));

            //ignoring the case when checkbox was checked, but then unchecked again - in that case we would have a label saying "Allowed to Contact false"
            if (workingProfile.get("allowedToContact").equalsIgnoreCase("true")) {
                verifyElementValueInSummary("//*[@name='allowedToContact']", workingProfile.get("allowedToContact"));
            }
            verifyElementValueInSummary("//*[@name='address']", workingProfile.get("address"));
            verifyElementValueInSummary("//*[@name='carMake']", workingProfile.get("carMake"));
            verifyElementValueInSummary("//*[@name='contactPersonName']", workingProfile.get("contactName"));
            verifyElementValueInSummary("//*[@name='contactPersonPhone']", workingProfile.get("contactPhone"));
            verifyElementValueInSummary("//*[@name='thirdPartyAgreement']", workingProfile.get("thirdPartyAgreement"));
            verifyElementValueInSummary("//*[@name='attachmentName']", workingProfile.get("attachment"));
        }
    }

    private void setFormFillingContext(String whatFields, String profileReference) {
        switch (whatFields.toLowerCase()) {
            case "required" -> isCompleteForm = false;
            case "all" -> isCompleteForm = true;
            default -> throw new Error("Unknown scenario context reference: " + whatFields);
        }
        workingProfile = getData(profileReference.toLowerCase().replace(" ", ""));
    }

    @When("I fill out {string} fields with {string} profile")
    public void iFillOutFieldsWithProfile(String scenarioContext, String profileReference) throws InterruptedException {
        setFormFillingContext(scenarioContext, profileReference);
        getDriver().findElement(By.xpath("//input[@name='username']")).sendKeys(workingProfile.get("username"));
        getDriver().findElement(By.xpath("//input[@name='email']")).sendKeys(workingProfile.get("email"));
        getDriver().findElement(By.xpath("//input[@name='password']")).sendKeys(workingProfile.get("password"));
        getDriver().findElement(By.xpath("//input[@name='confirmPassword']")).sendKeys(workingProfile.get("password"));

        getDriver().findElement(By.xpath("//input[@name='name']")).click();
        getDriver().findElement(By.xpath("//input[@id='firstName']")).sendKeys(workingProfile.get("firstName"));
        getDriver().findElement(By.xpath("//input[@id='middleName']")).sendKeys(workingProfile.get("middleName"));
        getDriver().findElement(By.xpath("//input[@id='lastName']")).sendKeys(workingProfile.get("lastName"));
        getDriver().findElement(By.xpath("//*[@id='nameDialog']/..//*[text()='Save']")).click();

        getDriver().findElement(By.xpath("//input[@name='agreedToPrivacyPolicy']")).click();

        if (isCompleteForm) {
            getDriver().findElement(By.xpath("//input[@name='phone']")).sendKeys(workingProfile.get("phone"));

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy"); //01/25/1995
            LocalDate parsedDate = LocalDate.parse(workingProfile.get("dateOfBirth"), formatter);
            String year = String.valueOf(parsedDate.getYear());
            String month = String.valueOf(parsedDate.getMonthValue() - 1);
            String day = String.valueOf(parsedDate.getDayOfMonth());
            getDriver().findElement(By.xpath("//input[@name='dateOfBirth']")).click();
            Select yearSelect = new Select(getDriver().findElement(By.xpath("//*[@id='ui-datepicker-div']//select[@data-handler='selectYear']")));
            yearSelect.selectByValue(year);
            Select monthSelect = new Select(getDriver().findElement(By.xpath("//*[@id='ui-datepicker-div']//select[@data-handler='selectMonth']")));
            monthSelect.selectByValue(month);
            Thread.sleep(1000);
            getDriver().findElement(By.xpath("//*[@id='ui-datepicker-div']//td[@data-handler='selectDay']/a[contains(text(),'" + day + "')]")).click();

            Select countryOfOriginSelect = new Select(getDriver().findElement(By.xpath("//select[@name='countryOfOrigin']")));
            countryOfOriginSelect.selectByValue(workingProfile.get("countryOfOrigin"));

            String genderXPath = "//input[@name='gender']" + "[@value='" + workingProfile.get("gender") + "']";
            getDriver().findElement(By.xpath(genderXPath)).click();

            if (workingProfile.get("allowedToContact").equalsIgnoreCase("true")) {
                getDriver().findElement(By.xpath("//input[@name='allowedToContact']")).click();
            }

            getDriver().findElement(By.xpath("//textarea[@name='address']")).sendKeys(workingProfile.get("address"));

            selectCarMakeWithSelectClass(workingProfile.get("carMake"));

            getDriver().switchTo().frame("additionalInfo");
            getDriver().findElement(By.xpath("//input[@id='contactPersonName']")).sendKeys(workingProfile.get("contactName"));
            getDriver().findElement(By.xpath("//input[@id='contactPersonPhone']")).sendKeys(workingProfile.get("contactPhone"));
            getDriver().switchTo().defaultContent();

            getDriver().findElement(By.xpath("//*[@id='thirdPartyButton']")).click();
            if (workingProfile.get("thirdPartyAgreement").equalsIgnoreCase("accepted")) { getDriver().switchTo().alert().accept(); }
            else { getDriver().switchTo().alert().dismiss(); }

            String currentDirectory = System.getProperty("user.dir");
            String fileSeparator = System.getProperty("file.separator");
            String pathToFile = String.join(fileSeparator, currentDirectory, "src", "test", "resources", "data", workingProfile.get("attachment"));
            getDriver().findElement(By.xpath("//input[@name='attachment']")).sendKeys(pathToFile);
        }
    }

    @When("I verify email field behavior")
    public void iVerifyEmailFieldBehavior() throws InterruptedException {
        getDriver().findElement(By.xpath("//input[@name='email']")).sendKeys("john.doe@corp.#");
        Thread.sleep(1000);
        getDriver().findElement(By.xpath("//input[@name='email']")).submit();
        Thread.sleep(1000);
        getDriver().findElement(By.xpath("//input[@name='email']")).sendKeys(Keys.BACK_SPACE);
        Thread.sleep(1000);
        getDriver().findElement(By.xpath("//input[@name='email']")).clear();
        Thread.sleep(1000);
        getDriver().findElement(By.xpath("//input[@name='email']")).sendKeys("john.doe@corp.com");
        getDriver().findElement(By.xpath("//input[@name='email']")).submit();
        Thread.sleep(1000);
    }

    @Then("I select {string} in Car Make Select with {string}")
    public void iSelectInCarMakeSelectWith(String options, String strategy) {
        switch (strategy.toLowerCase()) {
            case "select" -> selectCarMakeWithSelectClass(options);
            case "actions" -> selectCarMakeWithActions(options);
            default -> throw new Error("Unknown strategy: " + strategy);
        }
    }

    private void selectCarMakeWithActions(String options) {
        String[] carMakeOptions = options.split(", ");
        Actions actions = new Actions(getDriver());
        actions.keyDown(Keys.CONTROL).perform();
        for (String carMakeOption : carMakeOptions) {
            actions
                    .moveToElement(getDriver().findElement(By.xpath("//select[@name='carMake']/option[@value='" + carMakeOption + "']")))
                    .click()
                    .perform();
        }
        actions.keyUp(Keys.CONTROL).perform();
    }

    private void selectCarMakeWithSelectClass(String options) {
        String[] carMakeOptions = options.split(", ");
        Select carMakeSelect = new Select(getDriver().findElement(By.xpath("//select[@name='carMake']")));
        for (String carMakeOption : carMakeOptions) { carMakeSelect.selectByValue(carMakeOption); }
    }
}
