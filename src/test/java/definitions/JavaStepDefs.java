package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class JavaStepDefs {

    @Given("I am dividing {int} by {double}")
    public void division(int i, double d) {
        if ( d % 1 == 0 )
            System.out.println( "RESULT of dividing " + i + " by " + (int) d + " is " + i/(int) d );
        else
            System.out.println( "RESULT of dividing " + i +  " by " + d  + " is " + i/d );
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

    @Given("I go to {string} page")
    public void iGoToPage(String page) {
        switch (page) {
            case "google" -> getDriver().get("https://www.google.com/");
            case "quote" -> getDriver().get("https://skryabin.com/market/quote.html");
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

    @When("I fill out required fields")
    public void iFillOutRequiredFields() {
        getDriver().findElement(By.xpath("//input[@name='name']")).sendKeys("Dan Beck");
        getDriver().findElement(By.xpath("//input[@name='email']")).sendKeys("dan@example.com");
        getDriver().findElement(By.xpath("//input[@name='password']")).sendKeys("qwerty");
        getDriver().findElement(By.xpath("//input[@name='confirmPassword']")).sendKeys("qwerty");
        getDriver().findElement(By.xpath("//input[@name='username']")).sendKeys("dan_b");
        getDriver().findElement(By.xpath("//input[@name='agreedToPrivacyPolicy']")).click();
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
        getDriver().findElement(By.xpath("//button[@id='formSubmit']")).click();
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

    @And("I print {string} day of week")
    public void iPrintDayOfWeek(String ordinal_number) {
        int day_num = Integer.parseInt(ordinal_number);
        switch (day_num) {
            case 1 -> System.out.println("Sunday");
            case 2 -> System.out.println("Monday");
            case 3 -> System.out.println("Tuesday");
            case 4 -> System.out.println("Wednesday");
            case 5 -> System.out.println("Thursday");
            case 6 -> System.out.println("Friday");
            case 7 -> System.out.println("Saturday");
            default -> throw new Error("Invalid entry: " + day_num + ". There are only 7 days in a week!");
        }
    }

    @And("I print if number {string} is positive")
    public void iPrintIfNumberIsPositive(String number) {
        long num = Long.parseLong(number);
        if (num < 0) {
            System.out.println("Number is negative");
        } else if (num > 0) {
            System.out.println("Number is positive");
        } else {
            throw new Error("Zero is neither a positive number nor a negative number.");
        }
    }

}
