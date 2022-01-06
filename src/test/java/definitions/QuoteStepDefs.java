package definitions;

import com.sun.xml.bind.v2.*;
import io.cucumber.java.en.*;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.*;
import org.openqa.selenium.support.ui.*;

import java.util.*;

import static support.TestContext.*;



public class QuoteStepDefs {

    TestData testdata = new TestData();

    @When("I fill out required fields")
    public void iFillOutRequiredFields() {
        getDriver().findElement(By.xpath("//input[@name='username']")).sendKeys(testdata.username1);
        getDriver().findElement(By.xpath("//input[@name='email']")).sendKeys(testdata.email1);
        getDriver().findElement(By.xpath("//input[@id='password']")).sendKeys(testdata.pass1);
        getDriver().findElement(By.xpath("//input[@id='confirmPassword']")).sendKeys(testdata.pass1);
        getDriver().findElement(By.xpath("//input[@id='name']")).sendKeys(testdata.name1);
        getDriver().findElement(By.xpath("//input[@name='agreedToPrivacyPolicy']")).click();
    }

    @And("I submit the page")
    public void iSubmitThePage() {
        getDriver().findElement(By.xpath("//button[@id='formSubmit']")).click();
    }

    @Then("I verify the required fields")
    public void iVerifyTheRequiredFields() {
        Assert.assertEquals(getDriver().findElement(By.xpath("//b[@name='username']")).getText(), testdata.username1);
        Assert.assertEquals(getDriver().findElement(By.xpath("//b[@name='email']")).getText(), testdata.email1);
        Assert.assertEquals(getDriver().findElement(By.xpath("//b[@name='password']")).getText(), testdata.pass1);
        Assert.assertEquals(getDriver().findElement(By.xpath("//b[@name='name']")).getText(), testdata.name1);
        Assert.assertEquals(getDriver().findElement(By.xpath("//b[@name='agreedToPrivacyPolicy']")).getText(), testdata.policy1);
    }

    @And("I go back and forward, then refresh the page")
    public void iGoBackAndForwardThenRefreshThePage() throws InterruptedException {
        getDriver().navigate().back();
        Thread.sleep(3000);
        getDriver().navigate().forward();
        Thread.sleep(3000);
        getDriver().navigate().refresh();
        Thread.sleep(3000);
    }

    @And("I fill out optional fields")
    public void iFillOutOptionalFields() throws InterruptedException {
        getDriver().findElement(By.xpath("//select[@name='countryOfOrigin']//option[@value='" + testdata.countryOfOrigin1 + "']")).click();
        getDriver().findElement(By.xpath("//*[@id='address']")).sendKeys(testdata.address1);
        getDriver().findElement(By.xpath("//input[@name='phone']")).sendKeys(testdata.phone1);
        getDriver().findElement(By.xpath("//input[@value='" + testdata.gender1 + "']")).click();
        getDriver().findElement(By.xpath("//option[@value='" + testdata.carMake1 + "']")).click();
        getDriver().findElement(By.xpath("//input[@id='dateOfBirth']")).sendKeys(testdata.dateOfBirth1);
        getDriver().findElement(By.xpath("//label[@for='dateOfBirth']")).click();
        getDriver().findElement(By.xpath("//input[@name='phone']")).click();
        Thread.sleep(3000);
//      TODO: Continue troubleshooting the iframe - unable to locate element
        getDriver().findElement(By.xpath("//input[@id='contactPersonName']")).click();
        getDriver().findElement(By.xpath("//input[@id='contactPersonName']")).sendKeys(testdata.contactName1);
        getDriver().findElement(By.xpath("//input[@id='contactPersonPhone']")).click();
        getDriver().findElement(By.xpath("//input[@id='contactPersonPhone']")).sendKeys(testdata.contactPhone1);
        if(testdata.allowedToContact1) {
            getDriver().findElement(By.xpath("//input[@name='allowedToContact']")).click();
        }
        if(testdata.thirdPartyButton1) {
            getDriver().findElement(By.xpath("//button[@id='thirdPartyButton']")).click();
        }
        if(testdata.relatedDocs1) {
            getDriver().findElement(By.xpath("//button[contains(text(),'Related documents')]")).click();
        }
        if(testdata.viewDocs1) {
            getDriver().findElement(By.xpath("//a[@id='link']")).click();
        }
        if(testdata.download1) {
            getDriver().findElement(By.xpath("//a[contains(@href,'Documents.pdf')]")).click();
        }
        if(testdata.upload1) {
            getDriver().findElement(By.xpath("//input[@id='attachment']")).click();
        }
//        Refactor code by creating an array of similar id or name selectors
//        Boolean[] arrayOptions = {testdata.allowedToContact1, testdata.thirdPartyAgreem1, testdata.relatedDocs1, testdata.viewDocs1, testdata.download1, testdata.upload1};
//        for (boolean el : arrayOptions) {
//            if(el == true) {
//                //TODO later extract substr of el
//                getDriver().findElement(By.xpath("//*[@id='" + el + "1' or @name='" + el + "1']")).click();
//            }
//        }
    }

    @And("I verify the optional fields")
    public void iVerifyTheOptionalFields() {
//       TODO: verify all optional fields
        Assert.assertEquals(getDriver().findElement(By.xpath("//b[@name='countryOfOrigin']")).getText(), testdata.countryOfOrigin1);
        Assert.assertEquals(getDriver().findElement(By.xpath("//b[@name='location']")).getText(), testdata.address1);
    }

    @And("I select multiple options with Actions")
    public void iSelectMultipleOptionsWithActions() {
        Actions actions = new Actions(getDriver());
        int[] options = {0, 2};
        List<WebElement> dropdown = getDriver().findElements(By.xpath("//*[@name='carMake']//option"));
        for(int i=0; i<options.length; i++) {
            actions.keyDown(Keys.CONTROL)
                    .click(dropdown.get(options[i]))
                    .keyUp(Keys.CONTROL)
                    .perform();
        }

    }

    @And("I select multiple options with Select")
    public void iSelectMultipleOptionsWithSelect() {
        Select selectCarMake = new Select(getDriver().findElement(By.xpath("//*[@name='carMake']")));
        if(selectCarMake.isMultiple()) {
            int[] options = {0, 2};
             for(int i=0; i<options.length; i++) {
                 selectCarMake.selectByIndex(options[i]);
             }
        }
    }

    @And("I verify selected options were displayed")
    public void iVerifySelectedOptionsWereDisplayed() {
        int[] options = {0, 2};
        String optionsSelected = "Ford, BMW";
        Assert.assertEquals(getDriver().findElement(By.xpath("//b[@name='carMake']")).getText(), optionsSelected);
    }
}
