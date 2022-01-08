package definitions;

import io.cucumber.java.Transpose;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;
import static support.TestContext.getDriver;

public class UspsStepDefs {

    @When("I go to Lookup ZIP page by address through {string}")
    public void iGoToLookupZIPPageByAddress(String strategy) {
        WebElement sendButton = getDriver().findElement(By.xpath("//a[@id='mail-ship-width']"));
        switch (strategy) {
            case "quick tools" -> {
                getDriver().findElement(By.xpath("//ul[@class='nav-list']/li[contains(@class,'qt-nav')]")).click();
                getDriver().findElement(By.xpath("//a[@role='menuitem']/img[contains(@alt,'Zip Code')]")).click();
            }
            case "send" -> {
                sendButton.click();
                getDriver().findElement(By.xpath("//a[contains(@href,'ZipLookupAction')]")).click();
            }
            case "mouseover" -> {
                new Actions(getDriver()).moveToElement(sendButton).perform();
                getDriver().findElement(By.xpath("//li[@class='tool-zip']/a[contains(@href,'zip-code-lookup')]")).click();
            }
            default -> throw new Error("Unknown strategy: " + strategy);
        }
        WebElement findByAddress = getDriver().findElement(By.xpath("//a[@class='btn-primary zip-code-home'][@data-location='byaddress']"));
        new WebDriverWait(getDriver(), 3).until(visibilityOf(findByAddress)).click();
    }

    @And("I fill out {string} street, {string} city, {string} state")
    public void iFillOutStreetCityState(String address, String city, String state) {
        getDriver().findElement(By.xpath("//input[@id='tAddress']")).sendKeys(address);
        getDriver().findElement(By.xpath("//input[@id='tCity']")).sendKeys(city);
        new Select(getDriver().findElement(By.xpath("//select[@id='tState']"))).selectByValue(state);
        getDriver().findElement(By.xpath("//a[@id='zip-by-address']")).click();
    }

    @Then("I validate {string} zip code exists in all results")
    public void iValidateZipCodeExistsInTheResults(String zip) {
        By resultLocator = By.xpath("//div[@id='zipByAddressDiv']//li[contains(@class,'list-group-item')]");
        new WebDriverWait(getDriver(), 3).until(presenceOfElementLocated(resultLocator));
        List<WebElement> results = getDriver().findElements(resultLocator);
        for (WebElement el : results) assertThat(el.getAttribute("textContent")).contains(zip);
    }

    @And("I select {string} with {string} shape")
    public void iSelectWithShape(String country, String shape) {
        new Select(getDriver().findElement(By.xpath("//select[@id='CountryID']"))).selectByVisibleText(country);
        getDriver().findElement(By.xpath("//input[@value='" + shape + "']")).click();
    }

    @And("I define {string} quantity")
    public void iDefineQuantity(String quantity) {
        getDriver().findElement(By.xpath("//input[@id='quantity-0']")).sendKeys(quantity);
    }

    @Then("I calculate the price and validate cost is {string}")
    public void iCalculateThePriceAndValidateCostIs(String totalCost) {
        getDriver().findElement(By.xpath("//input[@value='Calculate']")).click();
        assertThat(getDriver().findElement(By.xpath("//*[@id='total']")).getText()).isEqualTo(totalCost);
    }

    @When("I perform {string} search")
    public void iPerformSearch(String query) {
        String navSearchXPath = "//a[@id='navsearch']/..";
        new Actions(getDriver())
                .moveToElement(getDriver().findElement(By.xpath(navSearchXPath)))
                .sendKeys(getDriver().findElement(By.xpath(navSearchXPath + "//input[@name='q']")), query)
                .click(getDriver().findElement(By.xpath(navSearchXPath + "//input[@value='Search']")))
                .perform();

        WebDriverWait wait = new WebDriverWait(getDriver(), 5);
        WebElement spinner =  wait.until(visibilityOfElementLocated(By.cssSelector(".spinner-content")));
        wait.until(invisibilityOf(spinner));
    }

    @And("I set filters")
    public void iSetFilters(@Transpose List<String> filters) {
        int numOfFilters = filters.size();
        if (numOfFilters < 1) throw new Error("Filter list is empty!");

        WebDriverWait wait = new WebDriverWait(getDriver(), 5);
        WebElement spinner =  getDriver().findElement(By.cssSelector(".spinner-content"));

        for (String filter : filters) {
            getDriver().findElement(By.xpath("//div[@id='dyn_nav_col']//p[@title='" + filter + "']")).click();
            wait.until(visibilityOf(spinner));
            wait.until(invisibilityOf(spinner));
        }
    }

    @Then("I verify that {string} results found")
    public void iVerifyThatResultsFound(String amountOfResults) {
        verifyByLabel(amountOfResults);
        verifyByCountingResults(Integer.parseInt(amountOfResults));
    }

    private void verifyByLabel(String amountOfResults) {
        assertThat(getDriver().findElement(By.xpath("//*[@id='searchResultsHeading']")).getText()).contains(amountOfResults);
    }

    private void verifyByCountingResults(int totalResults) {
        int amountOfPages = totalResults / 10;
        int resultsOnLastPage = totalResults % 10;

        if (resultsOnLastPage > 0) ++amountOfPages;
        else resultsOnLastPage = 10;

        if (amountOfPages > 1) goToSpecificResultsPage(amountOfPages);

        List<WebElement> results = getDriver().findElements(By.xpath("//ul[@id='records']/li"));
        assertThat(results.size()).isEqualTo(resultsOnLastPage);

        goToSpecificResultsPage(1);
    }

    private void goToSpecificResultsPage(int page) {
        if (page < 1) throw new Error("Invalid page number: " + page);

        int currentPage = Integer.parseInt(getDriver().findElement(By.xpath("//ul[@class='pagination']//li[contains(@class,'active')]")).getText());
        if (currentPage == page) return;

        boolean goingRight = page - currentPage > 0;
        By nextPageBy;
        if (goingRight) {
            nextPageBy = By.xpath("//ul[@class='pagination']/li[@class='next']/preceding-sibling::li[1]");
        } else {
            nextPageBy = By.xpath("//ul[@class='pagination']/li[contains(@class,'prev')]/following-sibling::li[1]");
        }

        WebDriverWait wait = new WebDriverWait(getDriver(), 5);
        Actions actions = new Actions(getDriver());
        WebElement spinner = getDriver().findElement(By.cssSelector(".spinner-content"));

        int nextPageValue;
        boolean isTargetPageVisible;
        do {
            WebElement nextPage = getDriver().findElement(nextPageBy);
            nextPageValue = Integer.parseInt(nextPage.getText());
            isTargetPageVisible = ((page <= nextPageValue && goingRight) || (page >= nextPageValue && !goingRight));
            if (isTargetPageVisible) {
                getDriver().findElement(By.xpath("//ul[@class='pagination']//*[normalize-space(.)='" + page + "']")).click();
            } else {
                nextPage.click();
            }
            wait.until(visibilityOf(spinner));
            wait.until(invisibilityOf(spinner));
            actions.moveToElement(getDriver().findElement(By.xpath("//footer"))).perform();
        } while (!isTargetPageVisible);
    }

    @When("I select {string} in results")
    public void iSelectInResults(String resultToChoose) {
        getDriver().findElement(By.xpath("//ul[@id='records']//a//*[normalize-space(.)='" + resultToChoose + "']")).click();
    }

    @And("I click {string} button")
    public void iClickButton(String buttonText) {
        getDriver().findElement(By.xpath("//a[@class='button--primary'][contains(normalize-space(.),'" + buttonText + "')]")).click();
    }

    @Then("I validate that Sign In is required")
    public void iValidateThatSignInIsRequired() {
        String originalWindow = getDriver().getWindowHandle();

        getDriver().getWindowHandles().forEach(handle -> getDriver().switchTo().window(handle)); //cycle to the latest one

        assertThat(getDriver().getCurrentUrl()).contains("https://reg.usps.com");
        assertThat(getDriver().findElement(By.xpath("//button[@id='btn-submit']"))).isNotNull();
        assertThat(getDriver().findElement(By.xpath("//a[@id='sign-up-button']"))).isNotNull();

        getDriver().switchTo().window(originalWindow);
    }

    @And("I go to {int} results page")
    public void iGoToResultsPage(int page) {
        goToSpecificResultsPage(page);
    }

    @When("I go to {string} under {string}")
    public void iGoToUnder(String subMenuLabel, String navMenuLabel) {
        new Actions(getDriver())
                .moveToElement(getDriver().findElement(By.xpath(getNavMenuItemXPath(navMenuLabel))))
                .click(getDriver().findElement(By.xpath(getSubMenuItemXPath(navMenuLabel, subMenuLabel))))
                .perform();
    }

    private String getSubMenuItemXPath(String navMenuLabel, String subMenuLabel) {
        return getNavMenuItemXPath(navMenuLabel) + "/..//a[@role='menuitem'][normalize-space(.)='" + subMenuLabel + "']";
    }

    private String getNavMenuItemXPath(String label) {
        return "//ul[@class='nav-list']//a[contains(@class,'menuitem')][normalize-space(.)='" + label + "']";
    }

    @And("I search for {string}")
    public void iSearchFor(String address) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        getDriver().findElement(By.id("cityOrZipCode")).sendKeys(address);
        getDriver().findElement(By.cssSelector(".eddm-search-btn")).click();
        WebElement spinner = getDriver().findElement(By.id("searchProcessing"));
        wait.until(visibilityOf(spinner));
        wait.until(invisibilityOf(spinner));
    }

    @And("I choose view as {string} on the map")
    public void iChooseViewAsOnTheMap(String viewType) {
        getDriver().findElement(By.xpath("//div[contains(@class,'refine-search-tabs')]//span[normalize-space(.)='" + viewType + "']")).click();
    }

    @When("I select all in the table")
    public void iSelectAllInTheTable() {
        getDriver().findElement(By.id("select-all-checkboxes")).click();
    }

    @And("I close modal window")
    public void iCloseModalWindow() {
        WebDriverWait wait = new WebDriverWait(getDriver(),3);
        WebElement closeButton = getDriver().findElement(By.id("closeAndUpdateTotals"));
        wait.until(visibilityOf(closeButton)).click();
        wait.until(invisibilityOf(closeButton));
    }

    @Then("I verify that summary of all rows of Cost column is equal Approximate Cost in Order Summary")
    public void iVerifyThatSummaryOfAllRowsOfCostColumnIsEqualApproximateCostInOrderSummary() throws ParseException {
        int costColumnIndex = getCostColumnIndex();
        String costElementsXPath = "//table[contains(@class,'target-audience')]/tbody//input[contains(@id,'checkbox')]/ancestor::td/following-sibling::td[" + costColumnIndex + "]";
        List<WebElement> costElements = getDriver().findElements(By.xpath(costElementsXPath));
        assertThat(costElements.size()).isEqualTo(Integer.parseInt(getDriver().findElement(By.id("totalRoutesSelected")).getText()));

        //approximate cost is not localized, so we don't care about localization that much and just use this pattern
        DecimalFormat df = new DecimalFormat("$0.00");
        BigDecimal totalCost = new BigDecimal(0);
        for (WebElement el : costElements) {
            totalCost = totalCost.add(BigDecimal.valueOf(df.parse(el.getText()).doubleValue()));
        }

        assertThat(df.format(totalCost)).isEqualTo(getDriver().findElement(By.id("approximateCost")).getText());
    }

    private int getCostColumnIndex() {
        List<WebElement> headersList = getDriver().findElements(By.xpath("//table[contains(@class,'target-audience')]/thead//th"));
        for (int i = 0; i < headersList.size(); ++i)
            if (headersList.get(i).getText().equals("Cost")) return i;
        throw new Error("Couldn't locate 'Cost' column.");
    }

    @When("I go to {string} tab")
    public void iGoToTab(String navMenuLabel) {
        getDriver().findElement(By.xpath(getNavMenuItemXPath(navMenuLabel))).click();
    }

    @And("I perform {string} help search")
    public void iPerformHelpSearch(String query) {
        getDriver().findElement(By.xpath("//div[@class='searchBox']//input")).sendKeys(query + Keys.ENTER);
        By firstResultLocator = By.xpath("//div[@class='resultsWrapper']//li[contains(@class,'kbResultStencil')]");
        new WebDriverWait(getDriver(), 10).until(visibilityOfElementLocated(firstResultLocator));
    }

    @Then("I verify that no results of {string} available in help")
    public void iVerifyThatNoResultsOfAvailableInHelp(String query) {
        By resultLocator = By.xpath("//div[@class='resultsWrapper']//li[contains(@class,'kbResultStencil')]");
        List<WebElement> results = getDriver().findElements(resultLocator);
        for (WebElement el : results) {
            assertThat(el.getText()).doesNotContainIgnoringCase(query);
        }
    }

    @When("I navigate to {string} heading link")
    public void iNavigateToHeadingLink(String linkLabel) {
        getDriver().findElement(By.xpath("//a[contains(@id,'link')][normalize-space(.)='" + linkLabel + "']")).click();
    }

    @And("I search for location {string}")
    public void iSearchForLocation(String address) {
        getDriver().findElement(By.xpath("//input[@id='city-state-input']")).sendKeys(address);
        getDriver().findElement(By.xpath("//a[@id='searchLocations']")).click();
    }

    @Then("I verify closest location phone number is {string}")
    public void iVerifyClosestLocationPhoneNumberIs(String phone) {
        new WebDriverWait(getDriver(), 3)
                .until(visibilityOfElementLocated(By.xpath("//div[@id='searchResultMap']//div[@class='esri-view-surface']")));

        getDriver().findElement(By.xpath("//div[@id='resultBox']//div[contains(@class,'list-item-location')]")).click();

        assertThat(getDriver().findElement(By.xpath("//div[@id='po-location-detail']//div[@class='phone-wrapper']")).getText()).contains(phone);
    }
}
