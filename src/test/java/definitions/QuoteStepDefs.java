package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Date;
import java.util.Map;

import static support.TestContext.getData;
import static support.TestContext.getDriver;
import static org.assertj.core.api.Assertions.assertThat;

public class QuoteStepDefs {

    Map<String, String> user = getData("user");

    @When("I fill out required fields")
    public void iFillOutRequiredFields() {
        getDriver().findElement(By.xpath("//input[@name='username']")).sendKeys(user.get("username"));
        getDriver().findElement(By.xpath("//input[@name='email']")).sendKeys(user.get("email"));
        getDriver().findElement(By.xpath("//input[@name='password']")).sendKeys(user.get("password"));
        getDriver().findElement(By.xpath("//input[@name='confirmPassword']")).sendKeys(user.get("password"));

        WebElement nameElement = getDriver().findElement(By.xpath("//input[@id='name']"));
        nameElement.click();
        getDriver().findElement(By.xpath("//input[@id='firstName']")).sendKeys(user.get("firstName"));
        getDriver().findElement(By.xpath("//input[@id='lastName']")).sendKeys(user.get("lastName"));
        getDriver().findElement(By.xpath("//span[text()='Save']")).click();
        System.out.println(nameElement.getAttribute("value"));

//        getDriver().findElement(By.xpath("//input[@name='username']")).sendKeys("user123");
//        getDriver().findElement(By.xpath("//input[@name='email']")).sendKeys("user123@yahoo.com");
//        getDriver().findElement(By.xpath("//input[@name='password']")).sendKeys("password123");
//        getDriver().findElement(By.xpath("//input[@name='confirmPassword']")).sendKeys("password123");
//
//        WebElement nameElement = getDriver().findElement(By.xpath("//input[@id='name']"));
//        nameElement.click();
//        getDriver().findElement(By.xpath("//input[@id='firstName']")).sendKeys("Amanda");
//        getDriver().findElement(By.xpath("//input[@id='lastName']")).sendKeys("Smith");
//        getDriver().findElement(By.xpath("//span[text()='Save']")).click();
//        System.out.println(nameElement.getAttribute("value"));

        WebElement privacyPolicy = getDriver().findElement(By.xpath("//input[@name='agreedToPrivacyPolicy']"));
        if (!privacyPolicy.isSelected()) {
            privacyPolicy.click();
        }
    }

    @And("I submit the page")
    public void iSubmitThePage() {
        getDriver().findElement(By.xpath("//button[@id='formSubmit']")).click();
    }

    @Then("I verify the required fields")
    public void iVerifyTheRequiredFields() {

        String resultText = getDriver().findElement(By.xpath("//div[@id='quotePageResult']")).getText();
        System.out.println(resultText);
        assertThat(resultText).contains(user.get("username"), user.get("firstName") + " " + user.get("lastName"), user.get("email"));
        assertThat(resultText).doesNotContain(user.get("password"));

//        String resultText = getDriver().findElement(By.xpath("//div[@id='quotePageResult']")).getText();
//        System.out.println(resultText);
//        assertThat(resultText).contains("user123", "Amanda Smith", "user123@yahoo.com");
//        assertThat(resultText).doesNotContain("password123");

        String agreed = getDriver().findElement(By.xpath("//b[@name='agreedToPrivacyPolicy']")).getText();
        assertThat(agreed).isEqualTo("true");

        String password = getDriver().findElement(By.xpath("//b[@name='password']")).getText();
        assertThat(password).isEqualTo("[entered]");
    }
    @And("I click on Related Documents")
    public void iClickOnRelatedDocuments() {
        getDriver().findElement(By.xpath("//button[contains(@onclick, 'new')]")).click();
    }

    @And("I verify {string} is in the list")
    public void iVerifyIsInTheList(String document) throws InterruptedException {
        String originalHandle = getDriver().getWindowHandle();

        // switch webdriver focus to a new window
        getDriver().getWindowHandles().forEach(handle -> getDriver().switchTo().window(handle));
        String windowText = getDriver().findElement(By.xpath("//body")).getText();
        assertThat(windowText).contains(document);

        // switch back
        getDriver().switchTo().window(originalHandle);
    }

    @And("I {string} third party agreement")
    public void iThirdPartyAggreemnt(String action) throws InterruptedException {
        getDriver().findElement(By.xpath("//button[@id='thirdPartyButton']")).click();
        switch (action) {
            case "accept":
                getDriver().switchTo().alert().accept();
                break;
            default:
                getDriver().switchTo().alert().dismiss();
        }
    }


    @And("I enter {string} as contact person with a phone {string}")
    public void iEnterAsContactPersonWithAPhone(String contactName, String contactPhone) throws InterruptedException {

        getDriver().switchTo().frame("additionalInfo");

        getDriver().findElement(By.xpath("//input[@id='contactPersonName']")).sendKeys(contactName);
        getDriver().findElement(By.xpath("//input[@id='contactPersonPhone']")).sendKeys(contactPhone);

        getDriver().switchTo().defaultContent();

        Thread.sleep(2000);
    }
}
