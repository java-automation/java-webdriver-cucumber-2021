package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;
import static support.TestContext.getData;
import static support.TestContext.getDriver;

public class QuoteStepDefs {

    private Map<String, String> workingProfile;
    private boolean fullForm;

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

        if (fullForm) {
            verifyElementValueInSummary("//*[@name='phone']", workingProfile.get("phone"));
            verifyElementValueInSummary("//*[@name='dateOfBirth']", workingProfile.get("dateofbirth"));
            verifyElementValueInSummary("//*[@name='countryOfOrigin']", workingProfile.get("countryoforigin"));
            verifyElementValueInSummary("//*[@name='gender']", workingProfile.get("gender"));

            //ignoring the case when checkbox was checked, but then unchecked again - in that case we would have a label saying "Allowed to Contact false"
            if (workingProfile.get("allowedtocontact").equalsIgnoreCase("true")) {
                verifyElementValueInSummary("//*[@name='allowedToContact']", workingProfile.get("allowedtocontact"));
            }
            verifyElementValueInSummary("//*[@name='address']", workingProfile.get("address"));
            verifyElementValueInSummary("//*[@name='carMake']", workingProfile.get("carmake"));
            verifyElementValueInSummary("//*[@name='contactPersonName']", workingProfile.get("contactname"));
            verifyElementValueInSummary("//*[@name='contactPersonPhone']", workingProfile.get("contactphone"));
            verifyElementValueInSummary("//*[@name='thirdPartyAgreement']", workingProfile.get("3rdpartyagreement"));
            verifyElementValueInSummary("//*[@name='attachmentName']", workingProfile.get("attachment"));
        }
    }

    private void setFormFillingContext(String scenarioContext, String profileReference) {
        switch (scenarioContext.toLowerCase()) {
            case "required" -> fullForm = false;
            case "all" -> fullForm = true;
            default -> throw new Error("Unknown scenario context reference: " + scenarioContext);
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

        if (fullForm) {
            getDriver().findElement(By.xpath("//input[@name='phone']")).sendKeys(workingProfile.get("phone"));

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy"); //01/25/1995
            LocalDate parsedDate = LocalDate.parse(workingProfile.get("dateofbirth"), formatter);
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
            countryOfOriginSelect.selectByValue(workingProfile.get("countryoforigin"));

            String genderXPath = "//input[@name='gender']" + "[@value='" + workingProfile.get("gender") + "']";
            getDriver().findElement(By.xpath(genderXPath)).click();

            if (workingProfile.get("allowedtocontact").equalsIgnoreCase("true")) {
                getDriver().findElement(By.xpath("//input[@name='allowedToContact']")).click();
            }

            getDriver().findElement(By.xpath("//textarea[@name='address']")).sendKeys(workingProfile.get("address"));

            String carMakeValue = workingProfile.get("carmake");
            String[] carMakeOptions = carMakeValue.split(", ");
            Select carMakeSelect = new Select(getDriver().findElement(By.xpath("//select[@name='carMake']")));
            for (String carMakeOption : carMakeOptions) { carMakeSelect.selectByValue(carMakeOption); }

            getDriver().switchTo().frame("additionalInfo");
            getDriver().findElement(By.xpath("//input[@id='contactPersonName']")).sendKeys(workingProfile.get("contactname"));
            getDriver().findElement(By.xpath("//input[@id='contactPersonPhone']")).sendKeys(workingProfile.get("contactphone"));
            getDriver().switchTo().defaultContent();

            getDriver().findElement(By.xpath("//*[@id='thirdPartyButton']")).click();
            if (workingProfile.get("3rdpartyagreement").equalsIgnoreCase("accepted")) { getDriver().switchTo().alert().accept(); }
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
}
