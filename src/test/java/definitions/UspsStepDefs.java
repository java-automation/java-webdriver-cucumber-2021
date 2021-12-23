package definitions;

import io.cucumber.java.Transpose;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
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
                moveMouseToElement(sendButton);
                getDriver().findElement(By.xpath("//li[@class='tool-zip']/a[contains(@href,'zip-code-lookup')]")).click();
            }
            default -> throw new Error("Unknown strategy: " + strategy);
        }
        WebElement findByAddress = getDriver().findElement(By.xpath("//a[@class='btn-primary zip-code-home'][@data-location='byaddress']"));
        new WebDriverWait(getDriver(), 3).until(ExpectedConditions.visibilityOf(findByAddress)).click();
    }

    @And("I fill out {string} street, {string} city, {string} state")
    public void iFillOutStreetCityState(String address, String city, String state) {
        getDriver().findElement(By.xpath("//input[@id='tAddress']")).sendKeys(address);
        getDriver().findElement(By.xpath("//input[@id='tCity']")).sendKeys(city);
        new Select(getDriver().findElement(By.xpath("//select[@id='tState']"))).selectByValue(state);
        getDriver().findElement(By.xpath("//a[@id='zip-by-address']")).click();
    }

    @Then("I validate {string} zip code exists in all results")
    public void iValidateZipCodeExistsInTheResult(String zip) {
        String containerXPath = "//div[@id='zipByAddressDiv']";
        new WebDriverWait(getDriver(), 3).until(ExpectedConditions.visibilityOf(getDriver().findElement(By.xpath(containerXPath))));
        List<WebElement> results = getDriver().findElements(By.xpath(containerXPath + "//li[contains(@class,'list-group-item')]"));
        for (WebElement el : results) assertThat(el.getText()).contains(zip);
    }

    @When("I go to Calculate Price Page")
    public void iGoToCalculatePricePage() {
        moveMouseToElement(getDriver().findElement(By.xpath("//ul[@class='nav-list']/li[contains(@class,'qt-nav')]")));
        getDriver().findElement(By.xpath("//a[@role='menuitem']/img[contains(@alt,'Calculate a Price')]")).click();
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
        String navSearchXPath = "//li[contains(@class,'nav-search')]";
        moveMouseToElement(getDriver().findElement(By.xpath(navSearchXPath)));
        getDriver().findElement(By.xpath(navSearchXPath + "//input[@name='q']")).sendKeys(query);
        getDriver().findElement(By.xpath(navSearchXPath + "//input[@value='Search']")).click();
    }

    @And("I set filters")
    public void iSetFilters(@Transpose List<String> filters) {
        int numOfFilters = filters.size();
        if (numOfFilters < 1) throw new Error("Filter list is empty!");

        By firstBy = By.xpath("//p[@title='" + filters.get(0) + "']");
        new WebDriverWait(getDriver(), 3).until(ExpectedConditions.visibilityOfElementLocated(firstBy));
        getDriver().findElement(firstBy).click();

        WebElement spinner = getDriver().findElement(By.xpath("//div[@class='spinner-content']"));

        for (int i = 1; i < numOfFilters; ++i) {
            waitForElementToBeInvisible(spinner);
            getDriver().findElement(By.xpath("//p[@title='" + filters.get(i) + "']")).click();
        }
        waitForElementToBeInvisible(spinner);
    }

    private void waitForElementToBeInvisible(WebElement element) {
        new WebDriverWait(getDriver(),10).until(ExpectedConditions.invisibilityOf(element));
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

        if (resultsOnLastPage > 0) amountOfPages++;
        else resultsOnLastPage = 10;

        if (amountOfPages > 1) goToSpecificResultsPage(amountOfPages);

        List<WebElement> results = getDriver().findElements(By.xpath("//ul[@id='records']/li"));
        assertThat(results.size()).isEqualTo(resultsOnLastPage);
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

        WebElement spinner = getDriver().findElement(By.xpath("//div[@class='spinner-content']"));
        WebElement footer = getDriver().findElement(By.xpath("//footer"));

        int nextPageValue;
        boolean isNeededPageNumberVisible;
        do {
            WebElement nextPage = getDriver().findElement(nextPageBy);
            nextPageValue = Integer.parseInt(nextPage.getText());
            isNeededPageNumberVisible = ((page <= nextPageValue && goingRight) || (page >= nextPageValue && !goingRight));
            if (!isNeededPageNumberVisible) {
                moveMouseToElement(footer);
                nextPage.click();
                waitForElementToBeInvisible(spinner);
            }
        } while (!isNeededPageNumberVisible);

        moveMouseToElement(footer);
        getDriver().findElement(By.xpath("//ul[@class='pagination']//*[normalize-space(.)='" + page + "']")).click();
        waitForElementToBeInvisible(spinner);
    }

    private void moveMouseToElement(WebElement element) {
        new Actions(getDriver()).moveToElement(element).perform();
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
        getDriver().getWindowHandles().forEach(handle -> getDriver().switchTo().window(handle)); //cycle to the latest one
        assertThat(getDriver().getCurrentUrl()).contains("https://reg.usps.com");
        assertThat(getDriver().findElement(By.xpath("//button[@id='btn-submit']"))).isNotNull();
        assertThat(getDriver().findElement(By.xpath("//a[@id='sign-up-button']"))).isNotNull();
    }

    @And("I go to {int} results page")
    public void iGoToResultsPage(int page) {
        goToSpecificResultsPage(page);
    }

    @When("I go to {string} under {string}")
    public void iGoToUnder(String submenuLabel, String navigationMenuLabel) {
        moveMouseToElement(getDriver().findElement(By.xpath(getNavigationMenuItemXPath(navigationMenuLabel))));
        getDriver().findElement(By.xpath(getSubmenuItemXPath(navigationMenuLabel, submenuLabel))).click();
    }

    private String getSubmenuItemXPath(String menuLabel, String submenuLabel) {
        return getNavigationMenuItemXPath(menuLabel) + "/..//a[@role='menuitem'][normalize-space(.)='" + submenuLabel + "']";
    }

    private String getNavigationMenuItemXPath(String label) {
        return "//ul[@class='nav-list']//a[@class='menuitem'][normalize-space(.)='" + label + "']";
    }

    @And("I search for {string}")
    public void iSearchFor(String address) {
        getDriver().findElement(By.xpath("//input[@id='cityOrZipCode']")).sendKeys(address);
        getDriver().findElement(By.xpath("//a[contains(@class,'eddm-search-btn')]")).click();
        waitForElementToBeInvisible(getDriver().findElement(By.xpath("//div[@class='spinner-content']")));
    }

    @And("I choose view as {string} on the map")
    public void iChooseViewAsOnTheMap(String viewType) {
        getDriver().findElement(By.xpath("//div[contains(@class,'refine-search-tabs')]//span[normalize-space(.)='" + viewType + "']")).click();
    }

    @When("I select all in the table")
    public void iSelectAllInTheTable() {
        getDriver().findElement(By.xpath("//input[@id='select-all-checkboxes']")).click();
    }

    @And("I close modal window")
    public void iCloseModalWindow() {
        WebElement closeButton = getDriver().findElement(By.xpath("//a[@id='closeAndUpdateTotals']"));
        new WebDriverWait(getDriver(),3).until(ExpectedConditions.visibilityOf(closeButton));
        closeButton.click();
        waitForElementToBeInvisible(closeButton);
    }

    @Then("I verify that summary of all rows of Cost column is equal Approximate Cost in Order Summary")
    public void iVerifyThatSummaryOfAllRowsOfCostColumnIsEqualApproximateCostInOrderSummary() throws ParseException {
        String approxCost = getDriver().findElement(By.xpath("//p[@id='approximateCost']")).getText();
        List<WebElement> costElements = getDriver().findElements(By.xpath("//table/tbody//input[contains(@id,'checkbox')]/ancestor::td/following-sibling::td[8]"));

        DecimalFormat df = new DecimalFormat("$0.00");
        BigDecimal totalCost = new BigDecimal(0);
        for (WebElement el : costElements) {
            totalCost = totalCost.add(BigDecimal.valueOf(df.parse(el.getText()).doubleValue()));
        }

        assertThat(df.format(totalCost)).isEqualTo(approxCost);
    }
}
