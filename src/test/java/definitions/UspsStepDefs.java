package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static support.TestContext.getDriver;

// Home_work_4 Usps

public class UspsStepDefs {
    @When("I go to {string} under {string}")
    public void iGoToUnder(String mail, String business) throws InterruptedException {

        WebElement sendBusiness = getDriver().findElement(By.xpath("//li[@class='menuheader']/a[contains(@href,'business/')]"));
        new Actions(getDriver()).moveToElement(sendBusiness).perform();
        Thread.sleep(3000);

        //getDriver().findElement(By.xpath("//li[@class='tool-eddm']/a[contains(@href,'eddm')]")).click();---- the same as bellow
        getDriver().findElement(By.xpath("//li[@class='tool-eddm']/a[contains(text(),'" + mail + "')]")).click();


    }

    @And("I search for {string}")
    public void iSearchFor(String address) throws InterruptedException {
        getDriver().findElement(By.xpath("//input[@id='cityOrZipCode']")).sendKeys(address);
        Thread.sleep(3000);
    }

    @Then("I click search")
    public void iClickSearch() throws InterruptedException {
        getDriver().findElement(By.xpath("//div[@class='search-btn-container search-btn-wrapper form-group']/a[contains(text(),'Search')]")).click();
        Thread.sleep(7000);
    }


    @And("I choose view as {string} on the map")
    public void iChooseViewAsOnTheMap(String table) throws InterruptedException {

        WebElement refineSearch = getDriver().findElement(By.xpath("//div[@class='col-9 step-1-map-wrapper']"));

        new Actions(getDriver()).moveToElement(refineSearch).perform();
       Thread.sleep(3000);

      //  getDriver().findElement(By.xpath("//a/span[contains(text(),'Table')]")).click(); ----the same as bellow
        getDriver().findElement(By.xpath("//a/span[contains(text(),'" + table + "')]")).click();

        Thread.sleep(5000);


    }


    @When("I select all in the table")
    public void iSelectAllInTheTable() throws InterruptedException {
        getDriver().findElement(By.xpath("//thead/tr[1]/th[1]/label[1]/span[1]")).click();
        ////label/input[@id='select-all-checkboxes']/span[@class='checkbox']

        Thread.sleep(5000);
    }

    @And("I close modal window")
    public void iCloseModalWindow() throws InterruptedException {

        WebElement window = getDriver().findElement(By.xpath("//body/div[@id='drop-off-location-modal']/div[1]/div[1]"));
        new Actions(getDriver()).moveToElement(window).perform();
        Thread.sleep(3000);

        //getDriver().findElement(By.xpath("//div[@class='modal-header']/a[@data-dismiss='modal']/span[@class='visuallyhidden']")).click();

        getDriver().findElement(By.xpath("//a[@id='closeAndUpdateTotals']")).click();
        Thread.sleep(3000);
    }

    @Then("I verify that summary of all rows of Cost column is equal Approximate Cost in Order Summar")
    public void iVerifyThatSummaryOfAllRowsOfCostColumnIsEqualApproximateCostInOrderSummar() throws InterruptedException {

     WebElement summary = getDriver().findElement(By.xpath("//div[@class=' gray-box flex-column']"));
      //  WebDriverWait wait = new WebDriverWait(getDriver(), 5);
      //  wait.until(titleContains("$3810.60"));

     String price = "Approximate Cost";
        WebDriverWait wait = new WebDriverWait(getDriver(), 2);
        wait.until(ExpectedConditions.textToBePresentInElement(summary,price));




    }
}
