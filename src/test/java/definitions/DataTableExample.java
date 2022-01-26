package definitions;

import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.Map;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class DataTableExample {
    WebDriver driver = null;

/*    @Given("^I am on new user registration page$")
    public void goToFacebook() {
        //Intiate web browser instance. driver = new FirefoxDriver();
        driver.navigate().to("https://www.facebook.com/");
    }*/

    @When("I enter invalid data on the page")
    public void enterData(Map<String, String> map){
        System.out.println("start enterData");
        //Enter data
        driver.findElement(By.name("firstname")).sendKeys(map.get("First Name"));
        driver.findElement(By.name("lastname")).sendKeys(map.get("First Name"));
        driver.findElement(By.name("reg_email__")).sendKeys(map.get("First Name"));
        driver.findElement(By.name("reg_email_confirmation__")).
                sendKeys(map.get("First Name"));
        driver.findElement(By.name("reg_passwd__")).sendKeys(map.get("First Name"));

        Select dropdownB = new Select(driver.findElement(By.name("birthday_day")));
        dropdownB.selectByValue("15");

        Select dropdownM = new Select(driver.findElement(By.name("birthday_month")));
        dropdownM.selectByValue("6");

        Select dropdownY = new Select(driver.findElement(By.name("birthday_year")));
        dropdownY.selectByValue("1990");

        driver.findElement(By.className("_58mt")).click();
        // Click submit button driver.findElement(By.name("websubmit")).click();
    }

/*    @Then("^User registration should be unsuccessful$")
    public void User_registration_should_be_unsuccessful() {
        if(driver.getCurrentUrl().equalsIgnoreCase("https://www.facebook.com/")){
            System.out.println("Test Pass");
        } else {
            System.out.println("Test Failed");
        }
        driver.close();
    }*/

    @Given("I am on the new user registration page")
    public void iAmOnTheNewUserRegistrationPage() {
        System.out.println("start iAmOnTheNewUserRegistrationPage");
        driver.navigate().to("https://www.facebook.com/");
    }

    @Then("the user registration should be unsuccessful")
    public void theUserRegistrationShouldBeUnsuccessful() {
        System.out.println("start theUserRegistrationShouldBeUnsuccessful");
        if(driver.getCurrentUrl().equalsIgnoreCase("https://www.facebook.com/")){
            System.out.println("Test Pass");
        } else {
            System.out.println("Test Failed");
        }
        driver.close();
    }


}
