package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static support.TestContext.getDriver;

public class QuoteStepDefs {
    @When("I fill out the required fields")
    public void iFillOutTheRequiredFields() {
        getDriver().findElement(By.xpath("//input[@name='name']")).click();
        getDriver().findElement(By.xpath("//input[@name='firstName']")).sendKeys("john");
        getDriver().findElement(By.xpath("//input[@name='lastName']")).sendKeys("doe");
        getDriver().findElement(By.xpath("//span[text()='Save']")).click();
//        System.out.println(getDriver().findElement(By.xpath("//input[@name='name']")).getAttribute("value"));

        getDriver().findElement(By.xpath("//input[@name='username']")).sendKeys("jdoe");
        getDriver().findElement(By.xpath("//input[@name='email']")).sendKeys("jdoe@gmail.com");
        getDriver().findElement(By.xpath("//input[@name='password']")).sendKeys("qwerty");
        getDriver().findElement(By.xpath("//input[@name='confirmPassword']")).sendKeys("qwerty");

        WebElement privacyPolicy = getDriver().findElement(By.xpath("//input[@name='agreedToPrivacyPolicy']")); // проверка на случай, если чек-бокс выбран автоматом
        if (!privacyPolicy.isSelected()){
            getDriver().findElement(By.xpath("//input[@name='agreedToPrivacyPolicy']")).click();
        }
    }

    @And("I submit the page")
    public void iSubmitThePage() {
        getDriver().findElement(By.xpath("//button[@id='formSubmit']")).submit();
    }

    @Then("I verity the required fields")
    public void iVerityTheRequiredFields() {
        String usernameResult = getDriver().findElement(By.xpath("//b[@name='username']")).getText();
        if (!usernameResult.equals("jdoe"))
            throw new Error("Incorrect username: " + usernameResult);
        //OR variant 2
        Assertions.assertThat(usernameResult).isEqualTo("jdoe");

        String nameResult = getDriver().findElement(By.xpath("//b[@name='name']")).getText();
        Assertions.assertThat(nameResult).isEqualTo("john doe");

        String emailResult = getDriver().findElement(By.xpath("//b[@name='email']")).getText();
        Assertions.assertThat(emailResult).isEqualTo("jdoe@gmail.com");

        //OR check everything at once
        String resultText = getDriver().findElement(By.xpath("//div[@id='quotePageResult']")).getText();
        Assertions.assertThat(resultText).contains("jdoe");
        Assertions.assertThat(resultText).contains("john doe");
        Assertions.assertThat(resultText).contains("jdoe@gmail.com");
        Assertions.assertThat(resultText).doesNotContain("qwerty"); //не содержит пароль
        //OR
        Assertions.assertThat(resultText).contains("jdoe", "john doe", "jdoe@gmail.com");
        Assertions.assertThat(resultText).doesNotContain("qwerty"); //не содержит пароль

    }

    @And("I click on Related Documents")
    public void iClickOnRelatedDocuments() {
        getDriver().findElement(By.xpath("//button[contains(@onclick, 'new')]")).click();
    }


    @And("I verify {string} is on the list")
    public void iVerifyIsOnTheList(String document) {
        String originalHandle = getDriver().getWindowHandle();
        //switch webdriver focus to the new window
        getDriver().getWindowHandles().forEach(handle -> getDriver().switchTo().window(handle));

        String windowText = getDriver().findElement(By.xpath("//body")).getText();
        Assertions.assertThat(windowText).contains(document);

        getDriver().switchTo().window(originalHandle);

    }

    @And("I {string} third party agreement")
    public void iThirdPartyAgreement(String action) {
        getDriver().findElement(By.xpath("//button[@id='thirdPartyButton']")).click();

        switch(action) {
            case "accept":
                getDriver().switchTo().alert().accept();
                break;
            case "decline":
                getDriver().switchTo().alert().dismiss();
                break;
        }


    }

    @And("I enter {string} as a contact person with a phone {string}")
    public void iEnterAsAContactPersonWithAPhone(String contactName, String contactPhone) {
        // Тк данный элемент у нас iframe, мы должны сначала переключиться на него и затем обратно:
        getDriver().switchTo().frame("additionalInfo"); //name="additionalInfo" мы взяли из html документа в инспекте

        //Затем вводим нужные данные в поля:
        getDriver().findElement(By.xpath("//input[@id='contactPersonName']")).sendKeys(contactName);
        getDriver().findElement(By.xpath("//input[@id='contactPersonPhone']")).sendKeys(contactPhone);

        //Переключаемся обратно из frame в обычный режим:
        getDriver().switchTo().defaultContent();



    }
}
