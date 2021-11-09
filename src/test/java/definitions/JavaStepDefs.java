package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static support.TestContext.getDriver;


public class JavaStepDefs {
  @Given("I hello world")
  public void iHelloWorld() {
    System.out.println("Hello World!");
  }

  @And("I say {string}")
  public void iSay(String arg0) {
    System.out.println(arg0);
  }

  @Then("I click month {string} in Date Composer")
  public void iClickMonthStringInDateComposer(String month) {
    PredefinedStepDefs.
            elementWithXpathShouldBeDisplayed("//div[@id='ui-datepicker-div']");
    PredefinedStepDefs.
            iClickOnElementWithXpath("//select[@class='ui-datepicker-month']/option[contains(text(),'" + month + "')]");
  }

  @Then("I click month {int} in Date Composer")
  public void iClickMonthIntInDateComposer(int month) {
    PredefinedStepDefs.
            elementWithXpathShouldBeDisplayed("//div[@id='ui-datepicker-div']");
    PredefinedStepDefs.
            iClickOnElementWithXpath("//select[@class='ui-datepicker-month']/option[@value='" + String.valueOf(month - 1) + "']");
  }

  @Then("I click day {int} in Date Composer")
  public void iClickDayIntInDateComposer(int day) {
    PredefinedStepDefs.
            elementWithXpathShouldBeDisplayed("//div[@id='ui-datepicker-div']");
    PredefinedStepDefs.iClickOnElementWithXpath("//a[contains(@class,'ui-state-default')][text()='" + String.valueOf(day) + "']");
  }

  @Then("I click day {string} in Date Composer")
  public void iClickDayStringInDateComposer(int day) {
    PredefinedStepDefs.
            elementWithXpathShouldBeDisplayed("//div[@id='ui-datepicker-div']");
    PredefinedStepDefs.iClickOnElementWithXpath("//a[contains(@class,'ui-state-default')][text()='" + day + "']");
  }

  @Then("I click year {int} in Date Composer")
  public void iClickYearIntInDateComposer(int year) {
    PredefinedStepDefs.
            elementWithXpathShouldBeDisplayed("//div[@id='ui-datepicker-div']");
    PredefinedStepDefs.
            iClickOnElementWithXpath("//select[@class='ui-datepicker-year']/option[@value='" + String.valueOf(year) + "']");
  }

  @Then("I click year {string} in Date Composer")
  public void iClickYearStringInDateComposer(int year) {
    PredefinedStepDefs.
            elementWithXpathShouldBeDisplayed("//div[@id='ui-datepicker-div']");
    PredefinedStepDefs.
            iClickOnElementWithXpath("//select[@class='ui-datepicker-year']/option[@value='" + year + "']");
  }

  @Then("I click back arrow button in Date Picker to change month")
  public void iClickBackArrowButtonInDatePickerToChangeMonth() {
    int currentMonth = Integer.parseInt(getAttribute("//select[@class='ui-datepicker-month']/option[@selected]", "value"));
    PredefinedStepDefs.iClickOnElementWithXpath("//a[contains(@class,'ui-datepicker-prev')]");
    int monthBack = Integer.parseInt(getAttribute("//select[@class='ui-datepicker-month']/option[@selected]", "value"));
    Assert.assertEquals(currentMonth - 1, monthBack);
  }

  public String getAttribute(String xpath, String attribute) {
    return getDriver()
            .findElement(By.xpath(xpath))
            .getAttribute(attribute);
  }

  @Then("I click forward arrow button in Date Picker to change month")
  public void iClickForwardArrowButtonInDatePickerToChangeMonth() {
    int selectedMonth = Integer.parseInt(getAttribute("//select[@class='ui-datepicker-month']/option[@selected]", "value"));
    PredefinedStepDefs.iClickOnElementWithXpath("//a[contains(@class,'ui-datepicker-next')]");
    int monthForward = Integer.parseInt(getAttribute("//select[@class='ui-datepicker-month']/option[@selected]", "value"));
    Assert.assertEquals(selectedMonth + 1, monthForward);
  }

  @Then("I click keyUp in keyboard")
  public void iClickKeyUpInKeyboard() {
    WebElement month = getDriver().findElement(By.xpath("//select[@class='ui-datepicker-month']"));
    new Actions(getDriver()).sendKeys(month, Keys.ARROW_UP).perform();
    new Actions(getDriver()).sendKeys(month, Keys.ENTER).perform();
  }

  @Then("I click keyDown in keyboard")
  public void iClickKeyDownInKeyboard() {
    WebElement month = getDriver().findElement(By.xpath("//select[@class='ui-datepicker-month']"));
    new Actions(getDriver()).sendKeys(month, Keys.ARROW_DOWN).perform();
    new Actions(getDriver()).sendKeys(month, Keys.ENTER).perform();
  }

  @Given("I perform actions with {string} and {string}")
  public void iPerformActionsWithAnd(String firstVariable, String secondVariable) {
    int firstVariableLength = firstVariable.length();
    int secondVariableLength = secondVariable.length();
    System.out.println("1) Print those variables into console as they are: " + "\n" + firstVariable + "\n" + secondVariable);
    System.out.println("2) Print those variables uppercase into console: " + "\n" + firstVariable.toUpperCase() + "\n" + secondVariable.toUpperCase());
    System.out.println("3) Print those variables length into console: " + "\n" + firstVariableLength + "\n" + secondVariableLength);
    System.out.println("4) Print result of exact comparison of those variables into console: ");
    if (firstVariable.equals(secondVariable)) {
      System.out.println(firstVariable + " matches " + secondVariable);
    }
    else {
      System.out.println(firstVariable + " doesn't matches "+ secondVariable);
    }
    System.out.println("5) Print result of exact comparison ignoring cases of those variables into console: ");
    if(firstVariable.equalsIgnoreCase(secondVariable)) {
      System.out.println(firstVariable + "ignoring cases matches " + secondVariable);
    }
    System.out.println("6) Print result of partial comparison of those variables into console – if first variable contains second:");
    boolean isContains = false;
    for (int i = 0; i < (firstVariableLength - secondVariableLength); i++) {
      if (firstVariable.regionMatches(i, secondVariable, 0, secondVariableLength)){
        isContains = true;
        System.out.println("first variable \""+ firstVariable + "\" contains second: \"" + secondVariable +"\"");
        break;
      }
    }
    if (!isContains) {
      System.out.println("First variable doesn't contain second");
    }
  }
}