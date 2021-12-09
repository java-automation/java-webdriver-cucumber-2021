package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import static org.assertj.core.api.Assertions.assertThat;


import static support.TestContext.getDriver;

public class QuoteStepDefs {
    @When("I fill out required fields")
    public void iFillOutRequiredFields() {
        getDriver().findElement(By.xpath("//input[@name='username']")).sendKeys("AliceL");
        getDriver().findElement(By.xpath("//input[@name='email']")).sendKeys("AliceL@test.com");
        getDriver().findElement(By.xpath("//input[@id='password']")).sendKeys("abc123");
        getDriver().findElement(By.xpath("//input[@id='confirmPassword']")).sendKeys("abc123");
        getDriver().findElement(By.xpath("//input[@id='name']")).sendKeys("Alice Liddell");
        getDriver().findElement(By.xpath("//input[contains(@name,'PrivacyPolicy')]")).click();

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
//        String pageSubmitted = getDriver().findElement(By.xpath("//legend[contains(text(),'Submitted Application')]")).getText();
//        System.out.println(pageSubmitted);
//
//        String usernameResult = getDriver().findElement(By.xpath("//b[@name='username']")).getText();
//        if (!usernameResult.equals("AliceL")){
//            throw new Error ("Incorrect username: " + usernameResult);
//        }
//        String nameResult = getDriver().findElement(By.xpath("//b[@name='name']")).getText();
//        if (!nameResult.equals("Alice Liddell")){
//            throw new Error("Incorrect name: "+ nameResult);
//        }
//        String emailResult = getDriver().findElement(By.xpath("//b[@name='email']")).getText();
//        if (!emailResult.equals("AliceL@test.com")){
//            throw new Error("Incorrect email: "+ emailResult);
//        }
//        String passwordResult = getDriver().findElement(By.xpath("//b[@name='password']")).getText();
//        if (!passwordResult.equals("[entered]")){
//            throw new Error ("Incorrect or not masked password: " + passwordResult);
//        }
//        String privacyPolicyResult = getDriver().findElement(By.xpath("//b[@name='agreedToPrivacyPolicy']")).getText();
//        if (!privacyPolicyResult.equals("true")){
//            throw new Error ("Incorrect result for Agreed To Privacy Policy: "+ privacyPolicyResult);

      String resultText = getDriver().findElement(By.xpath("//div[@id='quotePageResult']")).getText();
        System.out.println(resultText);

        assertThat(resultText).contains("AliceL", "Alice Liddell", "AliceL@test.com", "Lewis", "1234567","true");
        assertThat(resultText).doesNotContain("abc123");

        String agreed = getDriver().findElement(By.xpath("//b[@name='agreedToPrivacyPolicy']")).getText();
        assertThat(agreed).isEqualTo("true");

        String allowed =getDriver().findElement(By.xpath("//b[@name='allowedToContact']")).getText();
        assertThat(allowed).isEqualTo("true");

        String password = getDriver().findElement(By.xpath("//b[@name='password']")).getText();
        assertThat(password).isEqualTo("[entered]");
       }


    @And("I fill out optional fields")
    public void iFillOutOptionalFields() throws InterruptedException {
        getDriver().findElement(By.xpath("//button[@id='thirdPartyButton']")).click();
        getDriver().switchTo().alert().accept();


        String mainWindow = getDriver().getWindowHandle();
        getDriver().findElement(By.xpath("//button[contains(text(),'Related documents')]")).click();
        ArrayList<String> listOfTabs = new ArrayList<String>(getDriver().getWindowHandles());
        for (String tab : listOfTabs) {
            getDriver().switchTo().window(tab);
            if (getDriver().getTitle().equalsIgnoreCase("Documents Page")) {
                getDriver().close();
            }
        }
        getDriver().switchTo().window(mainWindow);


        getDriver().findElement(By.xpath("//a[@id='link']")).click();
        getDriver().navigate().back();
        Thread.sleep(500);


        getDriver().switchTo().frame("additionalInfo");
        getDriver().findElement(By.xpath("//input[@id='contactPersonName']")).sendKeys("Lewis");
        getDriver().findElement(By.xpath("//input[@id='contactPersonPhone']")).sendKeys("1234567");
        getDriver().switchTo().defaultContent();

        getDriver().findElement(By.xpath("//input[@name='allowedToContact']")).click();


    }
}
