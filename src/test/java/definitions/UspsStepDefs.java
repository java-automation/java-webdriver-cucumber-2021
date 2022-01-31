package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_old.Ac;
import net.bytebuddy.asm.Advice;
import org.assertj.core.api.Assertions;
import org.assertj.core.data.Percentage;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static support.TestContext.*;


public class UspsStepDefs {
    @When("I go to Lookup ZIP page by address")
    public void iGoToLookupZIPPageByAddress() throws InterruptedException {
//        getDriver().findElement(By.xpath("//a[@class='nav-first-element menuitem']")).click();
        WebElement quickToolsMenu = getDriver().findElement(By.xpath("//a[@class='nav-first-element menuitem']"));
//        Actions actions = new Actions(getDriver());
//        actions.moveToElement(quickToolsMenu).perform();
        new Actions(getDriver()).moveToElement(quickToolsMenu).perform(); //hover the mouse over

        getDriver().findElement(By.xpath("//*[@alt='Zip Code™ Lookup Icon']")).click();
        getDriver().findElement(By.xpath("//a[@role='button'][text()='Find by Address']")).click();
    }

    @And("I fill out {string} street, {string} city, {string} state")
    public void iFillOutStreetCityState(String address, String city, String state) throws InterruptedException {
        getDriver().findElement(By.xpath("//input[@name='tAddress']")).sendKeys(address);
        getDriver().findElement(By.xpath("//input[@name='tCity']")).sendKeys(city);
//        To choose a state in drop-down menu:
//        getDriver().findElement(By.xpath("//select[@name='tState']")).click();
//        getDriver().findElement(By.xpath("//select[@name='tState']")).sendKeys(state); //select CA in drop-down

//        OR
//        WebElement selectElement = getDriver().findElement(By.xpath("//select[@name='tState']"));
//        Select select = new Select(selectElement);
//        select.selectByValue(state);

//        OR
//        getDriver().findElement(By.xpath("//select[@name='tState']/option[@value='CA']")).click();

//        OR
        getDriver().findElement(By.xpath("//select[@name='tState']/option[@value='" + state + "']")).click();


        getDriver().findElement(By.xpath("//a[@id='zip-by-address']")).click();
    }

    @Then("I validate {string} zip code exists in the result")
    public void iValidateZipCodeExistsInTheResult(String zip) {
//        variant 1:
//        String zipResult = getDriver().findElement(By.xpath("//div[@id='zipByAddressDiv']")).getText();
//        Assertions.assertThat(zipResult).contains(zip);

//        OR variant 2:

        WebElement resultContainer = getDriver().findElement(By.xpath("//div[@id='zipByAddressDiv']"));

        WebDriverWait wait = new WebDriverWait(getDriver(), 5); //it's an explicit wait - if something we need (in our case it's text) is not shown in 5 seconds, it's going to fail
//        wait.until(ExpectedConditions. ... ); //ждать до момента (...)
        wait.until(ExpectedConditions.textToBePresentInElement(resultContainer, zip));  //ждать до момента, когда появится текст
        //по сути, больше ничего не надо использовать. Wait сам по себе ждет появления нужного текста (zip), если он не появляется, то у нас происходит fail и следовательно fail всего этого шага

    }

    @When("I go to Calculate Price page")
    public void iGoToCalculatePricePage() {
        WebElement quickToolsMenu = getDriver().findElement(By.xpath("//a[@class='nav-first-element menuitem']"));
        new Actions(getDriver()).moveToElement(quickToolsMenu).perform(); //hover the mouse на "Quick tools" menu

        getDriver().findElement(By.xpath("//*[@alt='Calculate a Price Icon']")).click();
    }

    @And("I select {string} with {string}")
    public void iSelectWith(String country, String type) {
        getDriver().findElement(By.xpath("//select[@name='CountryID']/option[text()= '" + country + "']")).click(); //choose state in dropdown menu

        getDriver().findElement(By.xpath("//input[@name='action'][@value='" + type + "']")).click(); //click type (postcard)
    }

    @And("I define {string} quantity")
    public void iDefineQuantity(String quantity) {
        getDriver().findElement(By.xpath("//input[@id='quantity-0']")).sendKeys(quantity);
    }

    @Then("I calculate the price and validate the cost is {string}")
    public void iCalculateThePriceAndValidateTheCostIs(String cost) {
        getDriver().findElement(By.xpath("//input[@value='Calculate']")).click(); //click calculate button

        WebElement resultContainer = getDriver().findElement(By.xpath("//div[@id='total']"));
        WebDriverWait wait = new WebDriverWait(getDriver(), 5);
        wait.until(ExpectedConditions.textToBePresentInElement(resultContainer, cost));

        //Этот вариант на случай, если расчет производится всегда быстро и жать не нужно:
//        String costResult = getDriver().findElement(By.xpath("//div[@id='total']")).getText();
//        Assertions.assertThat(costResult).contains(cost);
    }

    @When("I perform {string} search")
    public void iPerformSearch(String searchInput) {
        WebElement search = getDriver().findElement(By.xpath("//a[@id='navsearch']/..")); //выбираем элемент(кнопка поиска большая в меню)
        Actions actions = new Actions(getDriver());
        actions.moveToElement(search).perform(); //наводим мышь на нее

        WebElement searchField = getDriver().findElement(By.xpath("//input[@id='global-header--search-track-search']")); //обозначаем поле для поиска как searchField
        //затем за одно действие мы вводим текст (searchInput) в поле ввода (searchField) и нажимаем enter вместо клопки поиска:
        actions
                .moveToElement(search)
                .sendKeys(searchField, searchInput)
                .sendKeys(Keys.ENTER)
                .perform();

                            //Variant 2 (full):
//        WebElement search = getDriver().findElement(By.xpath("//a[@id='navsearch']/..")); //выбираем элемент(кнопка поиска большая в меню)
//        new Actions(getDriver()).moveToElement(search).perform(); //наводим мышь на нее (объединили две строки из 1 варианта в одну)
//        //Далее вводим текст (searchInput) в строку поиска и нажимаем кнопку поиска:
//        getDriver().findElement(By.xpath("//input[@id='global-header--search-track-search']")).sendKeys(searchInput); //вводим текст
//        getDriver().findElement(By.xpath("//input[@id='global-header--search-track-search']/../*[@type='submit']")).click(); //нажимаем кнопку поиска (внутри меню)

    }

    @And("I set {string} in filters")
    public void iSetInFilters(String filter) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 3);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='dyn_nav_col']"))); //ждем, пока на странице появится блок с чекбоксами (presence - элемент не обязательно видим, но присутсвиует в DOM)
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='dyn_nav_col']"))); //variant with visibility instead of presence

        getDriver().findElement(By.xpath("//label[@class='checkbox-label'][contains(text(), '" + filter + "')]")).click(); //выбираем фильтр filter

        //чтобы убедиться, что страница загрузилась полностью (то есть спиннер пропал) после выбора фильтра:
        WebElement spinner = getDriver().findElement(By.xpath("//div[@class='white-spinner-container']")); //обозначаем тот элемент как spinner
        wait.until(ExpectedConditions.invisibilityOf(spinner)); //убеждаемся, что его не видно
    }

    @Then("I verify that {string} results found")
    public void iVerifyThatResultsFound(String numberNeeded) {
        // Variant 1 (найти нужную цифру (numberNeeded) как часть строки):
        String result = getDriver().findElement(By.xpath("//span[@id='searchResultsHeading']")).getText();
        Assertions.assertThat(result).contains(numberNeeded);

        // Variant 2 (тоже найти нужную цифру (numberNeeded) как часть строки)):
//        WebElement result = getDriver().findElement(By.xpath("//span[@id='searchResultsHeading']"));
//        Assertions.assertThat(result.getText()).contains(numberNeeded);

        // Variant 3 (найти реальное количество результатов (ссылок) на странице):
        int numberNeededInt = Integer.parseInt(numberNeeded); //конвертируем данное нам число из String в int формат
        List<WebElement> numberOfResults = getDriver().findElements(By.xpath("//ul[@id='records']/li")); // xpath - выбираем контейнер и затем /li - все результаты (ссылки), расположенные в нем
        Assertions.assertThat(numberOfResults.size()).isEqualTo(numberNeededInt); //проверяем, что количество результатов (numberOfResults) равно нужному нам числу (numberNeededInt) (в формате int)
    }

    @When("I select {string} in results")
    public void iSelectInResults(String variant) {
        getDriver().findElement(By.xpath("//ul[@id='records']//span[contains(text(), '" + variant + "')]")).click();
    }

    @And("I click {string} button")
    public void iClickButton(String buttonName) {
        getDriver().findElement(By.xpath("//a[text()='"+ buttonName +" ']")).click();
    }

    @Then("I validate that Sign in is required")
    public void iValidateThatSignInIsRequired() {
        Set<String> windowHandles = getDriver().getWindowHandles();
        String originalWindowHandle = getDriver().getWindowHandle(); //сахраняем текущее окно
        for (String handle : windowHandles) {  //for-loop to switch to the last window (пока не дойдем до последнего окна)
            getDriver().switchTo().window(handle);
        }

        //or use this instead of a classic for-loop to switch to the last window
        //windowHandles.forEach(handle -> getDriver().switchTo().window(handle)); //java 8 and newer

        WebDriverWait wait = new WebDriverWait(getDriver(), 5);
        wait.until(ExpectedConditions.titleContains("Sign In")); //do verification (case sensitive!)

        //and then we switch back to the original page
        getDriver().switchTo().window(originalWindowHandle);
    }

    @When("I go to {string} under {string}")
    public void iGoToUnder(String link, String tab) {
        WebElement tabMenu = getDriver().findElement(By.xpath("//a[@class='menuitem'][contains(text(), '" + tab + "')]"));
        new Actions(getDriver()).moveToElement(tabMenu).perform(); ////hover the mouse on business tab

        getDriver().findElement(By.xpath("//a[text()='" + link + "']")).click();

        //OR variant 2 (немного другая компановка)
//        WebElement menuTab = getDriver().findElement(By.xpath("//a[@class='menuitem'][contains(text(), '" + tab + "')]")); //находим расположение tab
//        WebElement linkUnderMenu = getDriver().findElement(By.xpath("//a[text()='" + link + "']")); //накоджим расположение link в меню tab
//
//        new Actions(getDriver()).moveToElement(menuTab).click(linkUnderMenu).perform(); //наводим мышь на tab, затем кликаем на link
    }

    @And("I search for {string}")
    public void iSearchFor(String address) {
        //Variant 1:
//        getDriver().findElement(By.xpath("//input[@id='cityOrZipCode']")).sendKeys(address);
//        getDriver().findElement(By.xpath("//a[contains(@class, 'eddm-search-btn')]")).click();

        //Variant 2:
        WebElement searchField = getDriver().findElement(By.xpath("//input[@id='cityOrZipCode']")); //обозначаем поле поиска
        new Actions(getDriver()).moveToElement(searchField).click(searchField).sendKeys(address).sendKeys(Keys.ENTER).perform(); //наводим мышь на поле, кликаем на него, вставляем текст(address), нажимаем enter

        //Variant 3:
//        getDriver().findElement(By.id("cityOrZipCode")).sendKeys(address);
//        getDriver().findElement(By.xpath("//a[contains(@class, 'eddm-search-btn')]")).click();
//        getDriver().findElement(By.cssSelector(".eddm-search-btn")).click(); //СSS (то же самое, что и строчкой выше)

    }

    @And("I choose view as {string} on the map")
    public void iChooseViewAsOnTheMap(String viewOption) throws InterruptedException {
        WebElement spinner = getDriver().findElement(By.xpath("//div[@class='white-spinner-container']")); //обозначаем spinner
        WebDriverWait wait = new WebDriverWait(getDriver(), 10); //обозначаем wait
        wait.until(ExpectedConditions.visibilityOf(spinner)); //ждем, пока исчезнет spinner
        wait.until(ExpectedConditions.invisibilityOf(spinner)); //ждем, пока исчезнет spinner

        //getDriver().findElement(By.xpath("//a[@value='table-tab-list-view']")).click(); //нажимает на нужную кнопку после того, как спиннер исчез
        getDriver().findElement(By.xpath("//span[text()='" + viewOption + "']")).click();
        getDriver().findElement(By.xpath("//span[text()='" + viewOption + "']")).click();
    }

    @When("I select all in the table")
    public void iSelectAllInTheTable() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='d-flex flex-row']//span[@class='checkbox']")));
        getDriver().findElement(By.xpath("//tr[@class='target-audience-table-header']//span[@class='checkbox']")).click();
        //getDriver().findElement(By.xpath("//div[@class='d-flex flex-row']//span[@class='checkbox']")).click();
    }

    @And("I close modal window")
    public void iCloseModalWindow() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 3);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='closeAndUpdateTotals']"))); //element to be clickable
        getDriver().findElement(By.xpath("//a[@id='closeAndUpdateTotals']")).click();
    }

    @Then("I verify that summary of all rows of Cost column is equal Approximate Cost in Order Summary")
    public void iVerifyThatSummaryOfAllRowsOfCostColumnIsEqualApproximateCostInOrderSummary() {
        String totalRoutesText = getDriver().findElement(By.xpath("//p[@id='totalRoutesSelected']")).getText(); //берем строку с числом как текст
        int totalRoutes = Integer.parseInt(totalRoutesText); //превращаем страку с числом в int формат

        List<WebElement> costElements = getDriver().findElements(By.xpath("//table[contains(@class, 'target-audience-table')]//td[9]")); //выбираем xpath сразу ко всему столбцу (9 по счету) и загоняем их в List
        Assertions.assertThat(costElements.size()).isEqualTo(totalRoutes); //убеждаемся, что количество элементов в List совпадает с числом totalRoutes

        WebDriverWait wait = new WebDriverWait(getDriver(), 5); //инишиируем wait для будущей loop
        double totalCostSum = 0;
        for (WebElement costElement : costElements) {
            wait.until(webDriver -> !costElement.getText().isEmpty()); //ждем, пока он не empty (поставили ! в начале)
        // параметр Webdriver driver -> while(true) (это для строки выше)
            double costElementDouble = Double.parseDouble(costElement.getText().replace("$", "")); //переводим текстовый формат в double и убираем значок $, чтобы осталось голое число
            totalCostSum += costElementDouble; //суммируем все сосканированные числа
        }

        String approximateCostText = getDriver().findElement(By.xpath("//p[@id='approximateCost']")).getText().replace("$", ""); //обозначаем approximate cost element и сразу убираем $
        double approximateCostInt = Double.parseDouble(approximateCostText); //переводим текст в double формат
        Assertions.assertThat(approximateCostInt).isCloseTo(totalCostSum, Percentage.withPercentage(1)); //сравниваем указанное число на странице с рассчитанной суммой (используем isCloseTo, потому что приблизительно сравниваем, где (1) - это допущение пограшности в 1%)
        System.out.println("Approximate cost: " + approximateCostInt);
        System.out.println("Cost calculated: " + totalCostSum);
    }

    @And("I perform {string} help search")
    public void iPerformHelpSearch(String searchText) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(getDriver(), 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='slds-button slds-button_brand search-button']")));
        Thread.sleep(3000);

        WebElement searchField = getDriver().findElement(By.xpath("//div[@class='search-field-wrapper slds-size_1-of-1 smallOnlyDisplay']")); //обозначаем searchField для дальнейшего использования


        //searchField.sendKeys(searchText); //вводим текст
        new Actions(getDriver()).moveToElement(searchField).click().sendKeys(searchText).sendKeys(Keys.ENTER).perform();

    }

    @Then("I verify that no results of {string} available in help search")
    public void iVerifyThatNoResultsOfAvailableInHelpSearch(String textToFind) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='slds-has-dividers--bottom uiAbstractList']")));

        String searchResult = getDriver().findElement(By.xpath("//div[@class='slds-has-dividers--bottom uiAbstractList']")).getText();
        Assertions.assertThat(searchResult).doesNotContain(textToFind);
    }

    @When("I navigate to {string} heading link")
    public void iNavigateToHeadingLink(String link) {
        getDriver().findElement(By.xpath("//a[@id='link-locator']")).click();
    }

    @And("I search for location {string}")
    public void iSearchForLocation(String address) throws InterruptedException {
        WebElement searchField = getDriver().findElement(By.xpath("//input[@id='city-state-input']"));

        WebDriverWait wait = new WebDriverWait(getDriver(), 3);
        wait.until(ExpectedConditions.visibilityOf(searchField));

        new Actions(getDriver()).moveToElement(searchField).click().sendKeys(address).sendKeys(Keys.ENTER).perform();
    }

    @Then("I verify closest location phone number is {string}")
    public void iVerifyClosestLocationPhoneNumberIs(String phoneNumber) throws InterruptedException {
        //div[@id='resultBox']//div[@class='list-item-location popover-trigger']
        WebDriverWait wait = new WebDriverWait(getDriver(), 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='resultBox']"))); //ждем появления всего блока с результатами
        Thread.sleep(3000);
        getDriver().findElement(By.xpath("//div[@id='resultBox']//div[@class='list-item-location popover-trigger']")).click(); //выберется всегда самый первый результат
        Thread.sleep(3000);
        String resultBlock = getDriver().findElement(By.xpath("//p[@id='detailTollFree']")).getText();
        //div[@class='col-md-4 col-sm-4 col-xs-12 location-address-phone']
        Assertions.assertThat(resultBlock).contains(phoneNumber);
    }




    //UPS
    @And("I go to Create a Shipment")
    public void iGoToCreateAShipment() {
        getDriver().findElement(By.xpath("//a[@id='tabs_0_tab_2']/span")).click();
    }
    Map<String, String> upsUser = getData("upsUser");

    @When("I fill out origin shipment fields")
    public void iFillOutOriginShipmentFields() throws InterruptedException {
        getDriver().findElement(By.xpath("//select[@name='cac_country']/option[contains(text(), '" + upsUser.get("country") + "')]"));
        getDriver().findElement(By.xpath("//input[@name='cac_companyOrName']")).sendKeys(upsUser.get("name"));

//        WebElement zip = getDriver().findElement(By.xpath("//input[@name='cac_postalCode']"));
//        WebDriverWait wait = new WebDriverWait(getDriver(), 3);
//        wait.until(ExpectedConditions.invisibilityOf(zip));
//        zip.sendKeys(upsUser.get("zip"));
//        getDriver().findElement(By.xpath("//input[@name='cac_city']")).sendKeys(upsUser.get("city"));
//        getDriver().findElement(By.xpath("//select[@name='cac_state']/option[contains(text(), '" + upsUser.get("state") +"')]"));

        getDriver().findElement(By.xpath("//input[@name='cac_email']")).sendKeys(upsUser.get("email"));
        getDriver().findElement(By.xpath("//input[@name='cac_phone']")).sendKeys(upsUser.get("phone"));

        getDriver().findElement(By.xpath("//input[@name='cac_singleLineAddress']")).sendKeys(upsUser.get("address"));
        Thread.sleep(1000);
        getDriver().findElement(By.xpath("//input[@name='cac_singleLineAddress']")).sendKeys(Keys.ENTER);
    }

    @And("I submit the shipment form")
    public void iSubmitTheShipmentForm() throws InterruptedException {
        //getDriver().findElement(By.xpath("//button[@id='nbsBackForwardNavigationContinueButton']")).click();
        Thread.sleep(1000);
        //Тк нам мешает баннер, мы прибегаем к Java Script:
        WebElement element = getDriver().findElement(By.xpath("//button[@id='nbsBackForwardNavigationContinueButton']"));
        JavascriptExecutor executor = (JavascriptExecutor)getDriver();
        executor.executeScript("arguments[0].click();", element);
    }

    @And("I close the cookie window")
    public void iCloseTheCookieWindow() {
        WebElement cookieWindow = getDriver().findElement(By.xpath("//div[@role='alert']"));
        if (cookieWindow.isDisplayed()) {
                getDriver().findElement(By.xpath("//div[@role='alert']/button/span")).click();
        }
    }

    @Then("I verify origin shipment fields submitted")
    public void iVerifyOriginShipmentFieldsSubmitted() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='origin_showSummaryAddress']")));
        String block = getDriver().findElement(By.xpath("//div[@id='origin_showSummaryAddress']")).getText();
        Assertions.assertThat(block).contains(upsUser.get("name"));
        Assertions.assertThat(block).contains(upsUser.get("address"));
        Assertions.assertThat(block).contains(upsUser.get("email"));
        Assertions.assertThat(block).contains(upsUser.get("phone"));
    }

    @When("I fill out destination shipment fields")
    public void iFillOutDestinationShipmentFields() throws InterruptedException {
        getDriver().findElement(By.xpath("//input[@name='cac_companyOrName']")).sendKeys(upsUser.get("nameDestination"));
        getDriver().findElement(By.xpath("//input[@name='cac_singleLineAddress']")).sendKeys(upsUser.get("addressDestination"));
        Thread.sleep(1000);
        getDriver().findElement(By.xpath("//input[@name='cac_singleLineAddress']")).sendKeys(Keys.ENTER);
    }

    @And("I {string} residential address")
    public void iResidentialAddress(String conformation) {
        //div[@class='modal-content']
        WebDriverWait wait = new WebDriverWait(getDriver(), 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='nbsAddressClassificationContinue']")));
        switch (conformation) {
            case "confirm":
                getDriver().findElement(By.xpath("//common-switch[@controlid='vm.residentialAddressControlId']/label/span")).click();
                break;
            case "dismiss":
                break;
            default:
                throw new Error("Unknown action: " + conformation);
        }
        getDriver().findElement(By.xpath("//button[@id='nbsAddressClassificationContinue']")).click(); //button continue
    }

    @And("I set {string} type and weight")
    public void iSetTypeAndWeight(String type) {
        //select[@id='nbsPackagePackagingTypeDropdown0']/option[contains(text(), 'Packaging')]
        getDriver().findElement(By.xpath("//input[@id='nbsPackagePackageWeightField0']")).click();
        getDriver().findElement(By.xpath("//input[@id='nbsPackagePackageWeightField0']")).sendKeys(upsUser.get("weight"));
        WebElement selector = getDriver().findElement(By.xpath("//select[@id='nbsPackagePackagingTypeDropdown0']"));
        new Select(selector).selectByVisibleText(type);
    }

    @Then("I verify {string} appear")
    public void iVerifyAppear(String text) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='nbsBalanceBarTotalCharges']")));
        String totalCharges = getDriver().findElement(By.xpath("//span[@id='nbsBalanceBarTotalCharges']")).getText();
        Assertions.assertThat(totalCharges).containsIgnoringCase(text);
    }

    @And("I select {string} delivery option")
    public void iSelectDeliveryOption(String option) {
       getDriver().findElement(By.xpath("//div[@id='" + option + "']")).click();
    }


    @And("I set description and check {string} type if available")
    public void iSetDescriptionAndCheckTypeIfAvailable(String deliveryType) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='nbsShipmentDescription']")));
        getDriver().findElement(By.xpath("//input[@id='nbsShipmentDescription']")).sendKeys(upsUser.get("description"));

        WebElement saturdayDelivery = getDriver().findElement(By.xpath("//div/strong[contains(text(), 'Saturday Delivery')]/../.."));
        JavascriptExecutor executor = (JavascriptExecutor)getDriver();
        executor.executeScript("arguments[0].click();", saturdayDelivery);
    }

    @And("I check {string}")
    public void iCheck(String deliveryOption) throws InterruptedException {
        String initialTotalCharges = getDriver().findElement(By.xpath("//span[@id='nbsBalanceBarTotalCharges']")).getText(); //изначальная total charges

        //getDriver().findElement(By.xpath("//label/div/strong[contains(text(), 'Deliver only to receiver')]")).click();
        //getDriver().findElement(By.xpath("//label[@for='nbsDirectDeliveryOnlyOptionBaseOptionSwitch']")).click();
        WebElement element = getDriver().findElement(By.xpath("//label[@for='nbsDirectDeliveryOnlyOptionBaseOptionSwitch']"));
        JavascriptExecutor executor = (JavascriptExecutor)getDriver();
        executor.executeScript("arguments[0].click();", element);

        Thread.sleep(2000);
        String finalTotalCharges = getDriver().findElement(By.xpath("//span[@id='nbsBalanceBarTotalCharges']")).getText();
        Assertions.assertThat(initialTotalCharges).isNotEqualTo(finalTotalCharges);
    }

    @Then("I verify total charges changed")
    public void iVerifyTotalChargesChanged() {
       //в предыдущем методе
    }

    @And("I select {string} payment type")
    public void iSelectPaymentType(String paymentType) {
        getDriver().findElement(By.xpath("//label/span[contains(text(), '" + paymentType + "')]")).click();
    }

    @And("I submit the shipment form to review")
    public void iSubmitTheShipmentFormToReview() {
        WebElement element = getDriver().findElement(By.xpath("//button[@id='nbsBackForwardNavigationReviewPrimaryButton']"));
        JavascriptExecutor executor = (JavascriptExecutor)getDriver();
        executor.executeScript("arguments[0].click();", element);
    }

    @Then("I review all recorded details on the review page")
    public void iReviewAllRecordedDetailsOnTheReviewPage() {
//        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='origin_showSummaryAddress']")));

        String info = getDriver().findElement(By.xpath("//div[@id='origin_showSummaryAddress']")).getText();
        Assertions.assertThat(info).contains(upsUser.get("name"));
        String info2 = getDriver().findElement(By.xpath("//div[@id='destination_showSummaryAddress']")).getText();
        Assertions.assertThat(info2).contains(upsUser.get("nameDestination"));
    }

    @And("I cancel the shipment form")
    public void iCancelTheShipmentForm() {
        WebElement element = getDriver().findElement(By.xpath("//button[@id='nbsBackForwardNavigationCancelShipmentButton']"));
        JavascriptExecutor executor = (JavascriptExecutor)getDriver();
        executor.executeScript("arguments[0].click();", element);
        //getDriver().findElement(By.xpath("//button[@id='nbsBackForwardNavigationCancelShipmentButton']")).click();
        //div[@class='modal-content'] - pop up window
        getDriver().findElement(By.xpath("//button[@id='nbsCancelShipmentWarningYes']")).click(); //yes

    }

    @Then("I verify shipment form is reset")
    public void iVerifyShipmentFormIsReset() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 7);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='iw_placeholder1473252365894']"))); //block

        getDriver().findElement(By.xpath("//input[@name='cac_companyOrName']")).getText().isEmpty(); //name field
        getDriver().findElement(By.xpath("//input[@name='cac_singleLineAddress']")).getText().isEmpty(); //address field
        getDriver().findElement(By.xpath("//input[@name='cac_email']")).getText().isEmpty(); //email field
        getDriver().findElement(By.xpath("//input[@name='cac_phone']")).getText().isEmpty(); //email field
    }
}







