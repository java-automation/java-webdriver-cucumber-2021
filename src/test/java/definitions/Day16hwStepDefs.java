package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleContains;
import static support.TestContext.getDriver;

public class Day16hwStepDefs {

    @Given("I find two max numbers in the array")
    public void findTwoMaxArrayNumbers() {
        int[] unsorted = {3, 7, -3, -2, 9, 5, 8, 9};
        System.out.println("Before: " + Arrays.toString(unsorted));

        int[] sorted = getSorted(unsorted);
        System.out.println("After: " + Arrays.toString(sorted));

        System.out.println(String.format("First MaxElement: %d, Second MaxElement: %d", sorted[sorted.length - 1], sorted[sorted.length - 2]));
    }

    int[] getSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int temp = arr[i];
                if (arr[i] > arr[j]) {
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    @Given("I check if {string} is the palindrome")
    public void iCheckIfStringIsThePalindrome(String str) {
        System.out.println("Before: " + str);
        System.out.println("After: " + reverseString(str.toUpperCase()));
        System.out.println("Palindrome: " + checkPalindrome(str.toUpperCase(), reverseString(str.toUpperCase())));
    }

    static String reverseString(String name) {
        String revName = "";
        for (int i = name.length() - 1; i >= 0; i--) {
            revName += name.charAt(i);
        }
        return revName;
    }

    static boolean checkPalindrome(String str1, String str2) {
        return str1.equals(str2);
    }

    @Given("I check if an Arraycontains duplicates")
    public void checkDuplicates() {
        int[] arr = {2, 3, 5, 7, 8, 8};
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    System.out.println("Array contains duplicates");
                    return;
                }
            }
        }
        System.out.println("No duplicates");
    }


    @Given("I write three lines code to find two max numbers in the array")
    public void iWriteThreeLinesCodeToFindTwoMaxNumbersInTheArray() {

        int[] ar1 = {3, 7, -3, -2, 9, 5, 8, 9};
        Arrays.sort(ar1);
        System.out.println(String.format("First Max: %d, Second Max: %d", ar1[ar1.length - 1], ar1[ar1.length - 2]));
    }

    @When("I go to Calculate Price Page")
    public void iGoToCalculatePricePage() {
        getDriver().findElement(By.xpath("//a[@id='mail-ship-width']")).click();
        getDriver().findElement(By.xpath("//a[contains(@href,'calculateretailpostage')]")).click();
    }


    @And("I select Canada with Postcard shape")
    public void iSelectCanadaWithPostcardShape() {
        getDriver().findElement(By.xpath("//select[@id='CountryID']/option [@value='10054']")).click();
        getDriver().findElement(By.xpath("//input [@value='Postcard']")).click();
    }

    @And("I define {string} quantity")
    public void iDefineQuantity(String arg0) {
        getDriver().findElement(By.xpath("//input[@id='quantity-0']")).sendKeys(arg0);
    }

    @Then("I calculate the price and validate cost is {string}")
    public void iCalculateThePriceAndValidateCostIs(String price) {
        getDriver().findElement(By.xpath("//input[@value='Calculate']")).click();
        WebElement resultContainer = getDriver().findElement(By.xpath("//div[@id='total']"));

        WebDriverWait waitSec = new WebDriverWait(getDriver(), 5);
        waitSec.until(webDriver -> resultContainer.getText().length() > 0);

        String resultString = resultContainer.getText();
        System.out.println(resultString);

        assertThat(resultString).contains(price);

    }

    //@d16_hw_Java6
    @When("I perform {string} search")
    public void iPerformSearch(String searchStr) throws InterruptedException {
        //WebElement searchIcon =getDriver().findElement(By.xpath("//a[@name='navsearch']/.."));
        //WebElement searchIcon =getDriver().findElement(By.xpath("//a[@id='navsearch']/following-sibling::*"));
        //WebElement searchIcon =getDriver().findElement(By.xpath("//a[@id='navsearch']/following-sibling::a"));
        //WebElement searchIcon = getDriver().findElement(By.xpath("//a[@id='navsearch']/ancestor::li"));

        //a[@id='navsearch']/ancestor::*         // * means  all of them
        //a[@id='navsearch']/ancestor::li
        //Axes:
        //starting_tag/following-sibling::tagname[predicate]
        //starting_tag/ancestor::tagname[predicate]

        WebElement searchIcon = getDriver().findElement(By.xpath("//a[@id='navsearch']/.."));
        WebElement searchInput = getDriver().findElement(By.xpath("//input[@id='global-header--search-track-search']"));
        //WebElement searchIconHover = getDriver().findElement(By.xpath("//input[@id='global-header--search-track-search']/../input[@value='Search']"));

        Actions actions = new Actions(getDriver());
        actions
                .moveToElement(searchIcon)
                //.sendKeys()  —▶  CharSequence & WebElement
                .sendKeys(searchInput, searchStr)
                .sendKeys(Keys.ENTER)
                .perform();  //execute whole thing

        //searchInput.sendKeys(searchStr + Keys.ENTER);  //different approach & Class, also works

        Thread.sleep(5000);
    }

    @And("I set {string} in filters")
    public void iSetInFilters(String filterText) throws InterruptedException {
     /* //div[@id='dyn_nav_col']//label[contains(text(),'Send')]
        //div[@id='dyn_nav_col']//label[contains(text(),'" + filter +  "')]"   */

        //WebElement filter = getDriver().findElement(By.xpath("//div[@id='dyn_nav_col']//label[contains(text(),'" + filterText + "')]"));

        //var1
     /* By filterLocator = By.xpath("//div[@id='dyn_nav_col']//label[contains(text(),'" + filterText + "')]");
        WebElement filter = getDriver().findElement(filterLocator);

        WebDriverWait wait =new WebDriverWait(getDriver(),5);  //wait obj for visibility
        wait.until(ExpectedConditions.visibilityOf(filter)); */

        //var2
        WebDriverWait wait = new WebDriverWait(getDriver(), 5);

        By filterLocator = By.xpath("//div[@id='dyn_nav_col']//label[contains(text(),'" + filterText + "')]");
        //wait.until(ExpectedConditions.visibilityOfElementLocated(filterLocator));
        wait.until(ExpectedConditions.presenceOfElementLocated(filterLocator));

        WebElement filter = getDriver().findElement(filterLocator);
        filter.click();

        Thread.sleep(2000);
    }

    @Then("I verify that {string} results found")
    public void iVerifyThatResultsFound(String expectTotal) {
        // var1 —▶ check heading
     /* WebElement heading = getDriver().findElement(By.xpath("//span[@id='searchResultsHeading']"));
        assertThat(heading.getText()).contains(expectTotal);*/

        //var2 —▶ {int} instead of {string}
        int expectedCount = Integer.parseInt(expectTotal);
        List<WebElement> totalResults = getDriver().findElements(By.xpath("//ul[@id='records']/li")); //findElements
        assertThat(totalResults.size()).isEqualTo(expectedCount);

        WebElement spinner = getDriver().findElement(By.xpath("//div [@class='white-spinner-container']"));
        WebDriverWait wait = new WebDriverWait(getDriver(), 5);
        wait.until(invisibilityOf(spinner));

    /* construction matrix e.g.
        WebDriverWait wait = new WebDriverWait(getDriver(), 5);
        By spinnerLocator= By.xpath("//div [@class='white-spinner-container']");
        wait.until(visibilityOf(spinnerLocator));
        wait.until(invisibilityOf(spinnerLocator));
        getDriver().findElement(By.xpath("//div[@id='dyn_nav_col']//label[contains(text(),'" + filterText + "')])")).click();
        wait.until(invisibilityOf(spinnerLocator)) */
    }

    @When("I select {string} in results")
    public void iSelectInResults(String result) {
        //getDriver().findElement(By.xpath("//ul[@id='records']//span[text()='Priority Mail Express Shipping | USPS']")).click();
        getDriver().findElement(By.xpath("//ul[@id='records']//span[text()='" + result + "']")).click();
    }

    @And("I click {string} button")
    public void iClickButton(String title) throws InterruptedException {
        //getDriver().findElement(By.xpath("//a[string()='Ship Now  with Priority Mail']")).click(); //2 spaces after 'Ship Now'
        //getDriver().findElement(By.xpath("//a[contains(text(),'Ship Now')]")).click();
        getDriver().findElement(By.xpath("//a[contains(text(),'" + title + "')]")).click();
        Thread.sleep(5000);
    }

    @Then("I validate that Sign In is required")
    public void iValidateThatSignInIsRequired() throws InterruptedException {
        //getDriver().findElement(By.xpath("//button[@id='btn-submit']")).click(); //dead end

        Set<String> windowHandles = getDriver().getWindowHandles(); // ⚯ getDriver().getWindowHandles()= size = 2
        String originalWindowHandle = getDriver().getWindowHandle(); // ⚯ getDriver().getWindowHandle()="CDwindow-DA5DD53FF510447FBC43F5AC90055F4F"//W0

        // windowHandles.forEach(handle -> getDriver().switchTo().window(handle));
        for(String handle: windowHandles){                // for loop instead of 𝞴
            getDriver().switchTo().window(handle);        // switch till the end
        }

        WebDriverWait wait = new WebDriverWait(getDriver(), 5); //⚯ getDriver().getTitle()="USPS.com® - Sign In" //W1
        wait.until(titleContains("Sign In"));

        getDriver().switchTo().window(originalWindowHandle);

       // Thread.sleep(5000);




    }
}





