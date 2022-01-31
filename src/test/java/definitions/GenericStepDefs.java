package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.Select;
import pages.QuoteForm;
import pages.UpsHomePage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Level;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class GenericStepDefs {

    private Map<String,String> lastUsedRequiredFields = new LinkedHashMap<>();
    private Map<String,String> lastUsedNonRequiredFields = new LinkedHashMap<>();

    @And("I print logs to the console")
    public void iPrintLogsToTheConsole() throws InterruptedException {
        Thread.sleep(1000);
        LogEntries logs = getDriver().manage().logs().get(LogType.BROWSER);
        for(LogEntry log : logs) {
            if (log.getLevel().equals(Level.SEVERE)) {
                throw new Error("Severe error: " + log);
            } else {
                System.out.println(log);
            }
        }
    }

    @Given("I print URL for page {string}")
    public void iPrintURLForPage(String page) {
        if (page.equals("google")) {
            System.out.println("https://www.google.com/");
        } else if(page.equals("yahoo")) {
            System.out.println("https://www.yahoo.com/");
        } else {
            System.out.println("Unsupported page: " + page);
        }
    }

    @Given("I go to {string} page oop")
    public void iGoToPageOop(String page) {
        switch (page.toLowerCase()) {
            case "quote" -> new QuoteForm().open();
            case "ups" -> new UpsHomePage().open();
            default -> throw new Error("Unsupported page: " + page);
        }
    }

    @Given("I go to {string} page")
    public void iGoToPage(String page) {
        switch (page.toLowerCase()) {
            case "google" -> getDriver().get("https://www.google.com/");
            case "quote" -> getDriver().get("https://skryabin.com/market/quote.html");
            case "usps" -> getDriver().get("https://usps.com");
            case "converter" -> getDriver().get("https://www.unitconverters.net/");
            case "calculator" -> getDriver().get("http://www.calculator.net/");
            default -> System.out.println("Unsupported page: " + page);
        }
    }

    @And("I print page details")
    public void iPrintPageDetails() {
        System.out.println("Title: " + getDriver().getTitle());
        System.out.println("Current title: " + getDriver().getCurrentUrl());
        System.out.println("Window handle: " + getDriver().getWindowHandle());
        System.out.println("Page source:\n" + getDriver().getPageSource());
    }

    @And("I go back and forward, then refresh the page")
    public void iGoBackAndForwardThenRefreshThePage() {
        getDriver().navigate().back();
        getDriver().navigate().forward();
        getDriver().navigate().refresh();
    }

    @And("I wait")
    public void iWait() throws InterruptedException {
        Thread.sleep(3000);
    }

    @And("I change resolution to {string}")
    public void iChangeResolutionTo(String device_type) {
        int width, height;
        switch (device_type) {
            case "phone" -> {
                width = 400;
                height = 768;
            }
            case "desktop" -> {
                width = 1024;
                height = 768;
            }
            default -> throw new Error("No such device type as " + device_type);
        }
        getDriver().manage().window().setSize(new Dimension(width,height));
    }

    private Map<String,String> generateRequiredFields() {
        Map<String,String> requiredFields = new LinkedHashMap<>();  // insertion-order iteration important for password field
        requiredFields.put("name","Dan Beck");
        requiredFields.put("email","dan@example.com");
        requiredFields.put("password","qwerty");
        requiredFields.put("confirmPassword","qwerty");
        requiredFields.put("username","dan_b");
        lastUsedRequiredFields.clear();
        lastUsedRequiredFields = requiredFields;
        return requiredFields;
    }

    @When("I fill out required fields")
    public void iFillOutRequiredFields() {
        Map<String,String> requiredFields = generateRequiredFields();
        requiredFields.forEach((key,value) ->
                                    getDriver().findElement(By.xpath("//input[@name='" + key + "']")).sendKeys(value));
        getDriver().findElement(By.xpath("//input[@name='agreedToPrivacyPolicy']")).click();

        // filling out name via dialog with first, middle and last name fields
//        getDriver().findElement(By.xpath("//input[@name='name']")).click();
//        getDriver().findElement(By.xpath("//div[@id='nameDialog']//input[@id='firstName']")).sendKeys("Dan");
//        getDriver().findElement(By.xpath("//div[@id='nameDialog']//input[@id='lastName']")).sendKeys("Beck");
//        getDriver().findElement(By.xpath("//span[text()='Save']")).click();
    }

    @Then("I verify the required fields")
    public void iVerifyTheRequiredFields() {
        assertThat(getDriver().findElement(By.xpath("//div[@id='quotePageResult']")).isDisplayed()).isTrue();
        Map<String, String> requiredFieldsExpected = new HashMap<>(lastUsedRequiredFields);
        requiredFieldsExpected.put("password","[entered]");
        requiredFieldsExpected.remove("confirmPassword");
//        String[] names = requiredFieldsExpected.get("name").split(" ");
//        requiredFieldsExpected.put("firstName",names[0]);
//        if (names.length == 2) requiredFieldsExpected.put("lastName",names[1]);
//        if (names.length == 3) {
//            requiredFieldsExpected.put("middleName", names[1]);
//            requiredFieldsExpected.put("lastName", names[2]);
//        }
        requiredFieldsExpected.forEach((key,value) ->
                  assertThat(getDriver().findElement(By.xpath("//b[@name='" + key + "']")).getText()).isEqualTo(value));
    }

    @When("I fill out optional fields")
    public void iFillOutOptionalFields() {
        getDriver().findElement(By.xpath("//input[@name='phone']")).sendKeys("2353456");
        getDriver().findElement(By.xpath("//select[@name='countryOfOrigin']//option[@value='Austria']")).click();
        getDriver().findElement(By.xpath("//input[@value='male']")).click();
        getDriver().findElement(By.xpath("//input[@name='allowedToContact']")).click();
        getDriver().findElement(By.xpath("//textarea[@name='address']")).sendKeys("123 Sweet street, Los Angeles, CA");
        getDriver().findElement(By.xpath("//select[@name='carMake']//option[@value='Ford']")).click();
        getDriver().findElement(By.xpath("//select[@name='carMake']//option[@value='Toyota']")).click();
        getDriver().findElement(By.xpath("//*[@id='thirdPartyButton']")).click();
        getDriver().switchTo().alert().accept();
        getDriver().findElement(By.xpath("//input[@name='dateOfBirth']")).click();
        getDriver().findElement(By.xpath("//select[@class='ui-datepicker-month']//option[@value='2']")).click();
        getDriver().findElement(By.xpath("//select[@class='ui-datepicker-year']//option[@value='2000']")).click();
        getDriver().findElement(By.xpath("//a[@class='ui-state-default'][text()='10']")).click();
        String mainWindow = getDriver().getWindowHandle();
        getDriver().findElement(By.xpath("//button[contains(text(),'Related documents')]")).click();
        ArrayList<String> listOfTabs = new ArrayList<>(getDriver().getWindowHandles());
        for (String tab : listOfTabs) {
            getDriver().switchTo().window(tab);
            if (getDriver().getTitle().equalsIgnoreCase("Documents Page")) {
                getDriver().close();
            }
        }
        getDriver().switchTo().window(mainWindow);
    }

    @And("I view documents")
    public void iViewDocuments() {
        // Be aware that some (in Chrome) or all (in Firefox) values on the quote page may disappear after that
        getDriver().findElement(By.xpath("//a[contains(text(),'View documents')]")).click();
        getDriver().navigate().back();
    }

    @And("I submit the form")
    public void iSubmitTheForm() {
        getDriver().findElement(By.xpath("//button[@id='formSubmit']")).click();
    }

    @Then("I verify that submitted fields saved correctly")
    public void iVerifyThatSubmittedFieldsSavedCorrectly() {
        assertThat(getDriver().findElement(By.xpath("//div[@id='quotePageResult']")).isDisplayed()).isTrue();
        assertThat(getDriver().findElement(By.xpath("//b[@name='name']")).getText()).isEqualTo("Dan Beck");
        assertThat(getDriver().findElement(By.xpath("//b[@name='password']")).getText()).isEqualTo("[entered]");
        assertThat(getDriver().findElement(By.xpath("//b[@name='email']")).getText()).isEqualTo("dan@example.com");
    }

    @When("I verify email field behavior")
    public void iVerifyEmailFieldBehavior() {
        try {
            getDriver().findElement(By.xpath("//input[@name='email']")).clear();
            iWait();
            getDriver().findElement(By.xpath("//input[@name='email']")).sendKeys("a.b@c.d.com");
            iWait();
            getDriver().findElement(By.xpath("//input[@name='email']")).sendKeys(Keys.BACK_SPACE);
            iWait();
            getDriver().findElement(By.xpath("//input[@name='email']")).clear();
            iWait();
            getDriver().findElement(By.xpath("//input[@name='email']")).sendKeys("a.b@cd.com");
            iWait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @When("I select {string} car makes with Actions")
    public void iSelectCarMakesViaActions(String carMakes) {
        String[] makes = carMakes.split(",");
        if (makes.length == 0) return;
        Actions actions = new Actions(getDriver());
        WebElement carMakeSelect = getDriver().findElement(By.xpath("//select[@name='carMake']"));

        actions = actions.click(carMakeSelect.findElement(By.xpath("./option[@value='" + makes[0] + "']")))
                         .keyDown(Keys.CONTROL);
        for (int i=1; i<makes.length; i++) {
            actions = actions.click(carMakeSelect.findElement(By.xpath("./option[@value='" + makes[i] + "']")));
        }
        actions.keyUp(Keys.CONTROL).perform();
        lastUsedNonRequiredFields.put("carMake",carMakes);
    }

    @When("I select {string} car makes with Select")
    public void iSelectCarMakesViaSelect(String carMakes) {
        Select carMakeSelect = new Select(getDriver().findElement(By.xpath("//select[@name='carMake']")));
        String[] makes = carMakes.split(",");
        if (makes.length == 0) return;
        for (String make : makes){
            carMakeSelect.selectByValue(make);
        }
        lastUsedNonRequiredFields.put("carMake",carMakes);
    }

    @Then("I verify car makes")
    public void iVerifyCarMakes() {
        String expectedCarMakes = lastUsedNonRequiredFields.get("carMake");
        String[] makes = expectedCarMakes.split(",");
        String carMakeFieldText = getDriver().findElement(By.xpath("//b[@name='carMake']")).getText();
        String carMakeText = carMakeFieldText;
        for (String make : makes) {
            assertThat(expectedCarMakes).contains(make);
            carMakeFieldText = carMakeFieldText.replace(make,"");
        }
        carMakeFieldText = carMakeFieldText.replaceAll("\\W|_","");
        assertThat(carMakeFieldText).overridingErrorMessage("Unexpected <%s> found in <%s>," +
                 " only <%s> car makes where expected", carMakeFieldText, carMakeText, expectedCarMakes).isEqualTo("");
    }
}
