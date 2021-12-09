package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;

import static support.TestContext.getDriver;

public class QuoteStepDefs {
    @When("I fill out required fields")
    public void iFillOutRequiredFields() {
        getDriver().findElement(By.xpath("//input[@name='name']")).click();
        getDriver().findElement(By.xpath("//input[@name='firstName']")).sendKeys("Simon");
        getDriver().findElement(By.xpath("//input[@name='lastName']")).sendKeys("Garfunkel");
        getDriver().findElement(By.xpath("//span[text()='Save']")).click();
        getDriver().findElement(By.xpath("//input[@name='username']")).sendKeys("sgarfunkel");
        getDriver().findElement(By.xpath("//input[@name='email']")).sendKeys("sgarfunkel@mail.com");
        getDriver().findElement(By.xpath("//input[@id='password']")).sendKeys("12345");
        getDriver().findElement(By.xpath("//input[@id='confirmPassword']")).sendKeys("12345");
        getDriver().findElement(By.xpath("//input[@name='agreedToPrivacyPolicy']")).click();
    }
    @And("I fill optional fields")
    public void iFillOptionalFields() {
        getDriver().findElement(By.xpath("//input[@name='phone']")).sendKeys("15553467701");
        getDriver().findElement(By.xpath("//input[@id='dateOfBirth']")).sendKeys("01/01/2000");
        getDriver().findElement(By.xpath("//select[@name='countryOfOrigin']/option[@value='Italy']")).click();
        getDriver().findElement(By.xpath("//input[@value='male']")).click();
        getDriver().findElement(By.xpath("//input[@name='allowedToContact']")).click();
        getDriver().findElement(By.xpath("//textarea[@id='address']")).sendKeys("11 Main St., Mountain View, CA, 94256");
        getDriver().findElement(By.xpath("//select[@name='carMake']/option[@value='Toyota']")).click();
        getDriver().switchTo().frame("additionalInfo");
        getDriver().findElement(By.xpath("//input[@id='contactPersonName']")).sendKeys("Penelopa Cruz");
        getDriver().findElement(By.xpath("//input[@id='contactPersonPhone']")).sendKeys("15550308912");
        getDriver().switchTo().defaultContent();
        getDriver().findElement(By.xpath("//button[@id='thirdPartyButton']")).click();
        getDriver().switchTo().alert().accept();

    }
    @And("I submit the page")
    public void iSubmitThePage() {
        getDriver().findElement(By.xpath("//button[@id='formSubmit']")).click();
    }

    @Then("I verify the required fields")
    public void iVerifyTheRequiredFields() {
        String firstNameResult = getDriver().findElement(By.xpath("//b[@name='firstName']")).getText();
        if (firstNameResult.equals("Simon")) {
            System.out.println("First name is correct");
        } else {
            throw new Error("Incorrect first name: " + firstNameResult);
        }
        String lastNameResult = getDriver().findElement(By.xpath("//b[@name='lastName']")).getText();
        if (lastNameResult.equals("Garfunkel")) {
            System.out.println("Last name is correct");
        } else {
            throw new Error("Incorrect last name: " + lastNameResult);
        }
        String fullNameResult = getDriver().findElement(By.xpath("//b[@name='name']")).getText();
        if (fullNameResult.equals("Simon Garfunkel")) {
            System.out.println("Full name is correct");
        } else {
            throw new Error("Incorrect full name: " + fullNameResult);
        }
        String passwordResult = getDriver().findElement(By.xpath("//b[@name='password']")).getText();
        if (passwordResult.equals("[entered]")) {
            System.out.println("Password entered");
        } else {
            throw new Error("Password not entered");
        }
        String usernameResult = getDriver().findElement(By.xpath("//b[@name='username']")).getText();
        if (usernameResult.equals("sgarfunkel")) {
            System.out.println("Username is correct");
        } else {
            throw new Error("Incorrect username: " + usernameResult);
        }
        String emailResult = getDriver().findElement(By.xpath("//b[@name='email']")).getText();
        if (emailResult.equals("sgarfunkel@mail.com")) {
            System.out.println("Email is correct");
        } else {
            throw new Error("Incorrect email: " + emailResult);
        }
        String privacyResult = getDriver().findElement(By.xpath("//b[@name='agreedToPrivacyPolicy']")).getText();
        if (privacyResult.equals("true")) {
            System.out.println("Agreed to Privacy Policy");
        } else {
            throw new Error("Not agreed to Privacy Policy");

        }
        String countryResult = getDriver().findElement(By.xpath("//b[@name='countryOfOrigin']")).getText();
        Assertions.assertThat(countryResult).isEqualTo("Italy");
        String carMakeResult = getDriver().findElement(By.xpath("//b[@name='carMake']")).getText();
        Assertions.assertThat(carMakeResult).isEqualTo("Toyota");
        String genderResult = getDriver().findElement(By.xpath("//b[@name='gender']")).getText();
        Assertions.assertThat(genderResult).isEqualTo("male");
        String phoneResult = getDriver().findElement(By.xpath("//b[@name='phone']")).getText();
        Assertions.assertThat(phoneResult).isEqualTo("15553467701");
        String allowedToContactResult = getDriver().findElement(By.xpath("//b[@name='allowedToContact']")).getText();
        Assertions.assertThat(allowedToContactResult).isEqualTo("true");
        String contactNameResult = getDriver().findElement(By.xpath("//b[@name='contactPersonName']")).getText();
        Assertions.assertThat(contactNameResult).isEqualTo("Penelopa Cruz");
        String contactPhoneResult = getDriver().findElement(By.xpath("//b[@name='contactPersonPhone']")).getText();
        Assertions.assertThat(contactPhoneResult).isEqualTo("15550308912");
        String dateOfBirthResult = getDriver().findElement(By.xpath("//b[@name='dateOfBirth']")).getText();
        Assertions.assertThat(dateOfBirthResult).isEqualTo("01/01/2000");
        String addressResult = getDriver().findElement(By.xpath("//b[@name='address']")).getText();
        Assertions.assertThat(addressResult).isEqualTo("11 Main St., Mountain View, CA, 94256");
        String thirdPartyResult = getDriver().findElement(By.xpath("//b[@name='thirdPartyAgreement']")).getText();
        Assertions.assertThat(thirdPartyResult).isEqualTo("accepted");

    }
}
