package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Map;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getData;
import static support.TestContext.getDriver;

public class QuoteStepDef {

    Map<String,String> user = getData("user");
  //  Map<String,String> user = getData("admin");

    @When("I fill out required fields")
    public void iFillOutRequiredFields() {
        getDriver().findElement(By.xpath("//input[@name='username']")).sendKeys(user.get("username"));
        getDriver().findElement(By.xpath("//input[@name='email']")).sendKeys(user.get("email"));
        getDriver().findElement(By.xpath("//input[@name='password']")).sendKeys(user.get("password"));
        getDriver().findElement(By.xpath("//input[@name='confirmPassword']")).sendKeys(user.get("password"));

        WebElement nameElement = getDriver().findElement(By.xpath("//input[@id='name']")); // variable

        nameElement.click();
        getDriver().findElement(By.id("firstName")).sendKeys(user.get("firstName"));
        getDriver().findElement(By.xpath("//input[@id='lastName']")).sendKeys(user.get("lastName"));
        getDriver().findElement(By.xpath("//span[text()='Save']")).click();

        String nameValue =nameElement.getAttribute("value");
        System.out.println(nameValue);

        WebElement privacyPolicy = getDriver().findElement(By.name("agreedToPrivacyPolicy"));
        if (!privacyPolicy.isSelected()) { // if it's not selected then click on it!
            privacyPolicy.click();
        }
    }

    @And("I submit the page")
    public void iSubmitThePage() {
        getDriver().findElement(By.xpath("//button[@id='formSubmit']")).click();
    }

    @Then("I verify the required fields")
    public void iVerifyTheRequiredFields() {

//        String usernameResults = getDriver().findElement(By.xpath("//b[@name='username']")).getText();
//        if (usernameResults.equals("jdoe")) {
//            throw new Error ("Incorrect username: " + usernameResults);
//        }
//        Assert.assertEquals(usernameResults,"joe");
//        Assert.assertTrue(usernameResults.equals("rroe"));
//        assertThat(usernameResults).isEqualTo("joe");
        WebElement resultEl = getDriver().findElement(By.xpath("//div[@id='quotePageResult']"));
        WebDriverWait wait = new WebDriverWait(getDriver(),3);
        wait.until(ExpectedConditions.visibilityOf(resultEl));

        String  result = resultEl.getText();
        assertThat(result).contains(user.get("username"),user.get("email"),user.get("firstName")); // you can use different values here!
        assertThat(result).contains("[entered]");

    }

    @Then("I fill out optional fields")
    public void iFillOutOptionalFields() {
        getDriver().findElement(By.xpath("//input[@name='phone']")).sendKeys("9161234567");

        WebElement countryOfOriginEl = getDriver().findElement(By.name("countryOfOrigin"));
        new Select(countryOfOriginEl).selectByValue("Russia");

        getDriver().findElement(By.xpath("//input[@name='gender' and @value='female']")).click();

        getDriver().findElement(By.xpath("//input[@name='allowedToContact']")).click();

        getDriver().findElement(By.id("address")).sendKeys("33 test street, test city 33, 95333");

        WebElement carMakeEl = getDriver().findElement(By.xpath("//select[@name='carMake']"));
        new Select(carMakeEl).selectByValue("Ford");

        WebElement	iframe	=	getDriver().findElement(By.xpath("//iframe[@name='additionalInfo']"));
        getDriver().switchTo().frame(iframe);
        //do	smth	within	iframe	...
        getDriver().findElement(By.id("contactPersonName")).sendKeys("Contact Person Test Name");
        getDriver().findElement(By.id("contactPersonPhone")).sendKeys("9165557788");
        getDriver().switchTo().defaultContent();

        String	firstWindow	=	getDriver().getWindowHandle();
//	trigger	new	window	to	open...
        getDriver().findElement(By.xpath("//input[@id='relatedDocuments']/..//button")).click();
//	switch	to	new	window
        for	(String	window	:	getDriver().getWindowHandles())	{
            getDriver().switchTo().window(window);
        }
//	do	smth	on	the	new	window...
        assertThat(getDriver().getTitle()).contains("Documents Page");

        getDriver().switchTo().window(firstWindow);

        getDriver().findElement(By.xpath("//button[@id='thirdPartyButton']")).click();
        getDriver().switchTo().alert().accept();

    }

    @When("I fill out DOB as {int} and month {string} and year {int}")
    public void iFillOutDOBAsAndMonthAndYear(int day, String month, int year)  {
        getDriver().findElement(By.id("dateOfBirth")).click();

        WebElement selectYearElement = getDriver().
                findElement(By.xpath("//select[@data-handler='selectYear']"));
        Select selectYear = new Select(selectYearElement);
        selectYear.selectByValue(String.valueOf(year));

        WebElement selectMonthElement = getDriver().findElement(By.
                xpath("//select[@data-handler='selectMonth']"));
        selectMonthElement.click();
        new Select(selectMonthElement).selectByVisibleText(month);

        getDriver().findElement(By.
                xpath("//td[@data-handler='selectDay']//a[contains(text(),'" + day + "')]")).click();

    }

    @And("I verify the optional fields")
    public void iVerifyTheOptionalFields() {
        WebElement resultEl = getDriver().findElement(By.xpath("//div[@id='quotePageResult']"));
        WebDriverWait wait = new WebDriverWait(getDriver(),3);
        wait.until(ExpectedConditions.visibilityOf(resultEl));

        String  result = resultEl.getText();
        assertThat(result).contains("05/11/1988", "9165557788", "Russia","33 test street","Ford");

        String thirdPartyAgree = getDriver().
                findElement(By.xpath("//b[@name='thirdPartyAgreement']")).getText();

        assertThat(thirdPartyAgree).isEqualTo("accepted");

    }
}
