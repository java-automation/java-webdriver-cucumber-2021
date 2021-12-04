package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Map;

import static org.assertj.core.api.Assertions.*;
import static support.TestContext.getDriver;

public class CustomStepDefs {

    private static final Map<String, String> profileOne = Map.ofEntries(
            Map.entry("username", "jdoe"),
            Map.entry("email", "john.doe@corp.com"),
            Map.entry("password", "jsecret"),
            Map.entry("name", "John Vitaljevich Doe"),
            Map.entry("phone", "2223456789"),
            Map.entry("dateofbirth", "11/01/1990"),
            Map.entry("countryoforigin", "Canada"),
            Map.entry("gender", "male"),
            Map.entry("allowedtocontact", "true"),
            Map.entry("address", "111 222 Street San Jose CA US 75000"),
            Map.entry("carmake", "BMW"),
            Map.entry("contactname", "Juanita Alvares"),
            Map.entry("contactphone", "+1 (222) 987-6543"),
            Map.entry("3rdpartyagreement", "accepted"),
            Map.entry("attachment", "downloadedResume.pdf")
    );

    private static final Map<String, String> profileTwo = Map.ofEntries(
            Map.entry("username", "msmith"),
            Map.entry("email", "monica.smith@corp.com"),
            Map.entry("password", "msecret"),
            Map.entry("name", "Monica Ivanovich Smith"),
            Map.entry("phone", "3333456789"),
            Map.entry("dateofbirth", "01/25/1995"),
            Map.entry("countryoforigin", "USA"),
            Map.entry("gender", "female"),
            Map.entry("allowedtocontact", "false"),
            Map.entry("address", "222 111 Avenue San Jose CA US 75000"),
            Map.entry("carmake", "Toyota, Other"),
            Map.entry("contactname", "Albert Navarro"),
            Map.entry("contactphone", "+1 (333) 987-6543"),
            Map.entry("3rdpartyagreement", "declined"),
            Map.entry("attachment", "downloadedResume.pdf")
    );

    private Map<String, String> workingProfile;
    private boolean fullForm;

    @Given("I go to {string} page")
    public void iGoToPage(String websiteReference) {
        getDriver().get(getURLUsingKnownReference(websiteReference));
    }

    public static String getURLUsingKnownReference(String websiteReference) {
        return switch (websiteReference.toLowerCase()) {
            case "google" -> "https://google.com";
            case "yahoo" -> "https://yahoo.com";
            case "bing" -> "https://bing.com";
            case "gibiru" -> "https://gibiru.com";
            case "duckduckgo" -> "https://duckduckgo.com";
            case "swisscows" -> "https://swisscows.com";
            case "search encrypt" -> "https://searchencrypt.com";
            case "startpage" -> "https://startpage.com";
            case "yandex" -> "https://yandex.com";
            case "boardreader" -> "https://boardreader.com";
            case "ecosia" -> "https://ecosia.org";
            case "quote form" -> "https://skryabin.com/market/quote.html";
            case "portnov campus" -> "https://portnov.com";
            case "portnov online" -> "https://portnov.net";
            case "hidden button" -> "http://uitestingplayground.com/scrollbars";
            default -> throw new Error("Unknown URL reference: " + websiteReference);
        };
    }

    @And("I print page details")
    public void iPrintPageDetails() throws InterruptedException {
        System.out.println("Page URL: " + getDriver().getCurrentUrl());
        System.out.println("Page title: " + getDriver().getTitle());
        System.out.println("Window handle: " + getDriver().getWindowHandle());
        System.out.println("All handles: " + getDriver().getWindowHandles());
        System.out.println("Page source: " + getDriver().getPageSource());
        Thread.sleep(1000);
    }

    @And("I go back and forward, then refresh the page")
    public void iGoBackAndForwardThenRefreshThePage() throws InterruptedException {
        getDriver().navigate().back();
        Thread.sleep(1000);
        getDriver().navigate().forward();
        Thread.sleep(1000);
        getDriver().navigate().refresh();
        Thread.sleep(1000);
    }

    @And("I change resolution to {string}")
    public void iChangeResolutionTo(String desiredResolutionReference) throws InterruptedException {
        int width;
        int height;
        switch (desiredResolutionReference.toLowerCase()) {
            case "phone" -> { width = 400; height = 768; }
            case "desktop" -> { width = 1024; height = 768; }
            default -> throw new Error("Unknown resolution reference: " + desiredResolutionReference);
        }
        getDriver().manage().window().setSize(new Dimension(width, height));
        Thread.sleep(1000);
    }

    @And("Submit the form")
    public void submitTheForm() {
        getDriver().findElement(By.xpath("//*[@id='formSubmit']")).click();
    }

    private void verifySummaryElementIsDisplayedAndHasValue(String summaryXPath, String value) {
        WebElement summaryElement = getDriver().findElement(By.xpath(summaryXPath));
        assertThat(summaryElement.isDisplayed()).isTrue();
        assertThat(summaryElement.getText()).isEqualTo(value);
    }

    /*
        This method assumes that workingProfile has been associated with one of the existing presets and
        fullForm need to be true for full verification
    */
    @Then("I verify that submitted fields got saved correctly")
    public void iVerifyThatSubmittedFieldsGotSavedCorrectly() throws InterruptedException {
        verifySummaryElementIsDisplayedAndHasValue("//*[@id='quotePageResult']//*[@name='username']", workingProfile.get("username"));
        verifySummaryElementIsDisplayedAndHasValue("//*[@id='quotePageResult']//*[@name='email']", workingProfile.get("email"));
        verifySummaryElementIsDisplayedAndHasValue("//*[@id='quotePageResult']//*[@name='password']", "[entered]");
        verifySummaryElementIsDisplayedAndHasValue("//*[@id='quotePageResult']//*[@name='name']", workingProfile.get("name"));
        verifySummaryElementIsDisplayedAndHasValue("//*[@id='quotePageResult']//*[@name='agreedToPrivacyPolicy']", "true");
        if (fullForm) {
            verifySummaryElementIsDisplayedAndHasValue("//*[@id='quotePageResult']//*[@name='phone']", workingProfile.get("phone"));
            verifySummaryElementIsDisplayedAndHasValue("//*[@id='quotePageResult']//*[@name='dateOfBirth']", workingProfile.get("dateofbirth"));
            verifySummaryElementIsDisplayedAndHasValue("//*[@id='quotePageResult']//*[@name='countryOfOrigin']", workingProfile.get("countryoforigin"));
            verifySummaryElementIsDisplayedAndHasValue("//*[@id='quotePageResult']//*[@name='gender']", workingProfile.get("gender"));

            //ignoring the case when checkbox was checked, but then unchecked again - in that case we would have a label saying "Allowed to Contact false"
            if (workingProfile.get("allowedtocontact").equalsIgnoreCase("true")) {
                verifySummaryElementIsDisplayedAndHasValue("//*[@id='quotePageResult']//*[@name='allowedToContact']", workingProfile.get("allowedtocontact"));
            }
            verifySummaryElementIsDisplayedAndHasValue("//*[@id='quotePageResult']//*[@name='address']", workingProfile.get("address"));
            verifySummaryElementIsDisplayedAndHasValue("//*[@id='quotePageResult']//*[@name='carMake']", workingProfile.get("carmake"));
            verifySummaryElementIsDisplayedAndHasValue("//*[@id='quotePageResult']//*[@name='contactPersonName']", workingProfile.get("contactname"));
            verifySummaryElementIsDisplayedAndHasValue("//*[@id='quotePageResult']//*[@name='contactPersonPhone']", workingProfile.get("contactphone"));
            verifySummaryElementIsDisplayedAndHasValue("//*[@id='quotePageResult']//*[@name='thirdPartyAgreement']", workingProfile.get("3rdpartyagreement"));
            verifySummaryElementIsDisplayedAndHasValue("//*[@id='quotePageResult']//*[@name='attachmentName']", workingProfile.get("attachment"));
        }
        Thread.sleep(5000);
    }

    private void setFormFillingContext(String scenarioContext, String profileReference) {
        switch (scenarioContext.toLowerCase()) {
            case "required" -> fullForm = false;
            case "all" -> fullForm = true;
            default -> throw new Error("Unknown scenario context reference: " + scenarioContext);
        }
        switch (profileReference.toLowerCase()) {
            case "john doe" -> workingProfile = profileOne;
            case "monica smith" -> workingProfile = profileTwo;
            default -> throw new Error("Unknown profile reference: " + profileReference);
        }
    }

    @When("I fill out {string} fields with {string} profile")
    public void iFillOutFieldsWithProfile(String scenarioContext, String profileReference) throws InterruptedException {
        setFormFillingContext(scenarioContext, profileReference);
        getDriver().findElement(By.xpath("//input[@name='username']")).sendKeys(workingProfile.get("username"));
        getDriver().findElement(By.xpath("//input[@name='email']")).sendKeys(workingProfile.get("email"));
        getDriver().findElement(By.xpath("//input[@name='password']")).sendKeys(workingProfile.get("password"));
        getDriver().findElement(By.xpath("//input[@name='confirmPassword']")).sendKeys(workingProfile.get("password"));
        getDriver().findElement(By.xpath("//input[@name='name']")).sendKeys(workingProfile.get("name"));
        getDriver().findElement(By.xpath("//input[@name='agreedToPrivacyPolicy']")).click();
        if (fullForm) {
            getDriver().findElement(By.xpath("//input[@name='phone']")).sendKeys(workingProfile.get("phone"));
            getDriver().findElement(By.xpath("//input[@name='dateOfBirth']")).sendKeys(workingProfile.get("dateofbirth"));

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
        Thread.sleep(3000);
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
