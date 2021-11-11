package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Locale;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class JavaStepDefs {

    @Given("I hello world")
    public void iHelloWorld() {
        String message = "Hello World!";
        String text = "I'm an engineer!";
        System.out.println(message + " " + text);

        String firstName = "john";
        System.out.println(firstName.toUpperCase());
        System.out.println(firstName.getClass());
        System.out.println(firstName.length());
        System.out.println(firstName.equals("John"));
        System.out.println(firstName.contains("jo"));
    }

    @And("I say {string}")
    public void iSay(String message) {
        System.out.println(message);
    }

    @Given("I perform actions with {string} and {string}")
    public void iPerformActionsWithAnd(String sVar1, String sVar2) {
        System.out.println("First var is - " + sVar1);
        System.out.println("Second var is - " + sVar2);
        System.out.println("-------------------------");
        System.out.println("First var Uppercase is - " + sVar1.toUpperCase());
        System.out.println("Second var Uppercase is - " + sVar2.toUpperCase());
        System.out.println("-------------------------");
        System.out.println("First var length is - " + sVar1.length());
        System.out.println("Second var length is - " + sVar2.length());
        System.out.println("-------------------------");
        System.out.println("Exact comparison result - " + sVar1.equals(sVar2));
        System.out.println("-------------------------");
        System.out.println("Case insensetive comparison - " + sVar1.equalsIgnoreCase(sVar2));
        System.out.println("-------------------------");
        System.out.println(("Var1 contains Var2 - " + sVar1.contains(sVar2)));
    }

    @And("I say my name {string} {string} with my favorite color {string}")
    public void iSayMyNameWithMyFavoriteColor(String sFirstName, String sLastName, String sColor) {
        System.out.println("Hi, my name is " + sFirstName + " " + sLastName + ",my favorite color is " + sColor);
    }

    @And("I divide an integer {int} by integer {int}")
    public void iDivideAnIntegerByInteger(int iVar1, int iVar2) {
        System.out.println(iVar1 / iVar2);
    }

    @And("I divide an integer {int} by float {string}")
    public void iDivideAnIntegerByFloat(int iVar1, String sVar2) {
        System.out.println(iVar1 / Float.valueOf(sVar2));
    }

    @And("I perform actions with {int} and {int}")
    public void iPerformActionsWithAnd(int num1, int num2) {
        int sum = num1 + num2;
        int difference = num1 - num2;
        int quotient = num1 / num2;
        int product = num1 * num2;
        System.out.println("Sum of " + num1 + " and " + num2 + " is " + sum);
        System.out.println("Difference of " + num1 + " and " + num2 +  " is " + difference);
        System.out.println("Quotient of " + num1 + " and " + num2 + " is " + quotient);
        System.out.println("Product of " + num1 + " and " + num2 + " is " + product);
    }

    @And("I check for not favorite color is {string}")
    public void iCheckForNotFavoriteColorIs(String sColor) {
        String nonFavoriteColor = "Yellow";
        System.out.println("NonFavoriteColor matches - " + Boolean.toString(nonFavoriteColor.intern() == sColor.intern()));
    }

    @And("I compare {string} and {string} strings")
    public void iCompareAndStrings(String sVar1, String sVar2) {
        System.out.println("=>" + sVar1.equals(sVar2));
    }

    @And("I print url for {string} page")
    public void iPrintUrlForPage(String sURL) {
        String sPageUrl;
        switch (sURL.toLowerCase()) {
            case "Google":
                sPageUrl = "https://www.google.com/";
                break;
            case "sample":
                sPageUrl = "https://skryabin.com/webdriver/html/sample.html";
                break;
            case "Yahoo":
                sPageUrl = "https://yahoo.com/";
                break;
            default:
                sPageUrl = "There is no such page on Internet!";
                break;
        }
        System.out.println("URL for " + sURL + " is " + sPageUrl);
    }

    @And("I print if number {string} is positive")
    public void iPrintIfNumberIsPositive(String sVar1) {
        int iVar1;
        boolean bNotNumber = false;
        try {
            iVar1 = Integer.parseInt(sVar1);
        } catch (NumberFormatException e) {
            iVar1 = 0;
            bNotNumber = true;
        }
        if (bNotNumber) {
            System.out.println("Number is not a number (" + sVar1 + ")");
        } else if ((iVar1 >= 0) & ( !bNotNumber)) {
            System.out.println("Number is positive (" + sVar1 + ")");
        } else {
            System.out.println("Number is negative (" + sVar1 + ")");
        }
    }

    @And("I print {string} th day of week")
    public void iPrintThDayOfWeek(String sDay1) {
        int iDay1 = 0;
        boolean bNumber = true;
        String[] sWeekDays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        try {
            iDay1 = Integer.parseInt(sDay1);
        } catch (NumberFormatException e) {
            bNumber = false;
        }
        if ((bNumber) & ((iDay1 >= 1) & (iDay1 <= 7))) {
            System.out.println(sWeekDays[iDay1 - 1]);
        } else {
            System.out.println("Wrong day number");
        }
    }

    @Given("I go to {string} page")
    public void iGoToPage(String sPage) {
        switch (sPage.toLowerCase()) {
            case "google":
                getDriver().navigate().to("https://www.google.com/");
                break;
            case "quote":
                getDriver().navigate().to("https://skryabin.com/webdriver/html/quote.html");
                break;
            default:
                System.out.println("Unsupported page: " + sPage);
        }
    }

    @And("I print page details")
    public void iPrintPageDetails() {
        System.out.println("Current URL: " + getDriver().getCurrentUrl());
        System.out.println("Currnet page title: " + getDriver().getTitle());
        System.out.println("Window handles: " + getDriver().getWindowHandle());
        System.out.println("Page source:" + getDriver().getPageSource());
    }

    @And("I go back and forward, then refresh the page")
    public void iGoBackAndForwardThenRefreshThePage() {
        getDriver().navigate().back();
        getDriver().navigate().forward();
        getDriver().navigate().refresh();
    }

    @And("I change resolution to {string}")
    public void iChangeResolutionTo(String sLayout) {
        System.out.println("Default resolution: " + getDriver().manage().window().getSize().toString());
        switch (sLayout.toLowerCase()) {
            case "phone":
                getDriver().manage().window().setSize(new Dimension(400, 768));
                break;
            case "desktop":
                getDriver().manage().window().setSize(new Dimension(1024, 768));
                break;
            default:
                System.out.println("Incorrect layout name input: " + sLayout);
        }
    }

    @When("I fill out required fields")
    public void iFillOutRequiredFields() {
        getDriver().findElement(By.xpath("//input[@id='name']")).click();
        getDriver().findElement(By.xpath("//input[@id='firstName']")).sendKeys("Dmitry");
        getDriver().findElement(By.xpath("//input[@id='lastName']")).sendKeys("Odintsov");
        getDriver().findElement(By.xpath("//button[normalize-space()='Save']")).click();
        getDriver().findElement(By.xpath("//input[@name='username']")).sendKeys("dodintsov");
        getDriver().findElement(By.xpath("//input[@name='email']")).sendKeys("odintsov@outlook.com");
        getDriver().findElement(By.xpath("//input[@id='password']")).sendKeys("12345");
        getDriver().findElement(By.xpath("//input[@id='confirmPassword']")).sendKeys("12345");
        getDriver().findElement(By.xpath("//input[@name='agreedToPrivacyPolicy']")).click();
    }

    @And("I submit the form")
    public void iSubmitTheForm() {
        getDriver().switchTo().defaultContent();
        getDriver().findElement(By.xpath("//button[@id='formSubmit']")).click();
    }

    @When("I verify email field behavior")
    public void iVerifyEmailFieldBehavior() {
        getDriver().findElement(By.xpath("//input[@name='email']")).clear();
        getDriver().findElement(By.xpath("//input[@name='email']")).sendKeys("outlook.com");
        getDriver().findElement(By.xpath("//input[@name='email']")).submit();
        if (getDriver().findElement(By.xpath("//label[@id='email-error']")).isDisplayed()) {
            getDriver().findElement(By.xpath("//input[@name='email']")).click();
            getDriver().findElement(By.xpath("//input[@name='email']")).sendKeys(Keys.BACK_SPACE);
            getDriver().findElement(By.xpath("//input[@name='email']")).clear();
            getDriver().findElement(By.xpath("//input[@name='email']")).sendKeys("odintsov@outlook.com");
            getDriver().findElement(By.xpath("//input[@name='email']")).submit();
        } else {
            throw new Error("Email field unexpected behavior");
        }
    }

    @Then("I verify that submitted fields saved correctly")
    public void iVerifyThatSubmittedFieldsSavedCorrectly() {
        assertThat(getDriver().findElement(By.xpath("//b[@name='name']")).getText()).isEqualTo("Dmitry Odintsov");
        assertThat(getDriver().findElement(By.xpath("//b[@name='username']")).getText()).isEqualTo("dodintsov");
        assertThat(getDriver().findElement(By.xpath("//b[@name='email']")).getText()).isEqualTo("odintsov@outlook.com");
        assertThat(getDriver().findElement(By.xpath("//b[@name='agreedToPrivacyPolicy']")).getText()).isEqualTo("true");
        assertThat(getDriver().findElement(By.xpath("//b[@name='password']")).getText()).isEqualTo("[entered]");
        List<WebElement> lPassword = getDriver().findElements(By.xpath("//*[normalize-space()='12345']"));
        if (lPassword.size() > 0) {
            throw new Error("Password present on page and could be found!");
        }
    }

    @When("I fill out optional fields")
    public void iFillOutOptionalFields() {
        getDriver().findElement(By.xpath("//input[@name='phone']")).sendKeys("89124536665");
        getDriver().findElement(By.xpath("//input[@name='dateOfBirth']")).sendKeys("01/30/1980");
        getDriver().findElement(By.xpath("//select[@name='countryOfOrigin']")).click();
        getDriver().findElement(By.xpath("//option[@value='Russia']")).click();
        getDriver().findElement(By.xpath("//input[@name='gender' and @value='male']")).click();
        getDriver().findElement(By.xpath("//input[@name='allowedToContact']")).click();
        getDriver().findElement(By.xpath("//textarea[@id='address']")).sendKeys("Some Address");
        getDriver().findElement(By.xpath("//select[@name='carMake']/option[@value='Toyota']")).click();
        getDriver().findElement(By.xpath("//button[@id='thirdPartyButton']")).click();
        getDriver().switchTo().alert().accept();
        getDriver().switchTo().frame("additionalInfo");
        getDriver().findElement(By.xpath("//input[@name='contactPersonName']")).sendKeys("Dima");
        getDriver().findElement(By.xpath("//input[@name='contactPersonPhone']")).sendKeys("89124536665");
    }

    @And("I verify all optional fields saved correctly")
    public void iVerifyAllOptionalFieldsSavedCorrectly() {
        assertThat(getDriver().findElement(By.xpath("//b[@name='countryOfOrigin']")).getText()).isEqualTo("Russia");
        assertThat(getDriver().findElement(By.xpath("//b[@name='dateOfBirth']")).getText()).isEqualTo("01/30/1980");
        assertThat(getDriver().findElement(By.xpath("//b[@name='gender']")).getText()).isEqualTo("male");
        assertThat(getDriver().findElement(By.xpath("//b[@name='allowedToContact']")).getText()).isEqualTo("true");
        assertThat(getDriver().findElement(By.xpath("//b[@name='address']")).getText()).isEqualTo("Some Address");
        assertThat(getDriver().findElement(By.xpath("//b[@name='carMake']")).getText()).isEqualTo("Toyota");
        assertThat(getDriver().findElement(By.xpath("//b[@name='thirdPartyAgreement']")).getText()).isEqualTo("accepted");
        assertThat(getDriver().findElement(By.xpath("//b[@name='contactPersonName']")).getText()).isEqualTo("Dima");
        assertThat(getDriver().findElement(By.xpath("//b[@name='contactPersonPhone']")).getText()).isEqualTo("89124536665");
    }
}