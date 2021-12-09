package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import static org.junit.Assert.assertTrue;
import static support.TestContext.getDriver;

public class USPSStepDefs {
    private static final String STREET_XPATH = "//input[@id='tAddress']";
    private static final String STATE_XPATH = "//select[@id='tState']";
    private static final String CITY_XPATH = "//input[@id='tCity']";
    private static final String ZIP_CODE_LINK_XPATH = "//a[@data-gtm-label='zip-code-link']";
    private static final String LOOK_UP_A_ZIP_CODE_XPATH = "//div[@class='zip_code_container']//h1";
    private static final String BY_ADDRESS_BUTTON_XPATH = "//div[@class='link-header-holder']//a[@data-location='byaddress']";
    private static final String FIND_BUTTON_XPATH = "//a[@id='zip-by-address']";
    private static final String HEADER_ZIPCODE_BY_ADDRESS_XPATH = "//div[@class='zip_code_address_results active']//h2";
    private static final String HEADER_ZIPCODE_BY_ADDRESS_TEXT = "ZIP Code™ by Address";
    private static final String ZIPCODE_BY_RESULTS_ADDRESS_XPATH = "//div[@class='zipcode-result-address']";

    @When("I go to Lookup ZIP page by address")
    public void iGoToLookupZIPPageByAddressByResizingInitialWindow() {
        PredefinedStepDefs.iWaitForElementWithXpathToBePresent(ZIP_CODE_LINK_XPATH);
        PredefinedStepDefs.iResizeWindowToAnd(700, 700);
        QuoteStepDefs.click(ZIP_CODE_LINK_XPATH);
        PredefinedStepDefs.iWaitForElementWithXpathToBePresent(LOOK_UP_A_ZIP_CODE_XPATH);
        PredefinedStepDefs.iMaximizeWindow();
        PredefinedStepDefs.iWaitForElementWithXpathToBePresent(BY_ADDRESS_BUTTON_XPATH);
        QuoteStepDefs.click(BY_ADDRESS_BUTTON_XPATH);
        PredefinedStepDefs.iWaitForElementWithXpathToBePresent(STREET_XPATH);
    }


    @And("I fill out {string} street, {string} city, {string} state")
    public void iFillOutStreetCityState(String street, String city, String state) {
        QuoteStepDefs.type(STREET_XPATH, street);
        QuoteStepDefs.type(CITY_XPATH, city);
        QuoteStepDefs.getListOfValue(STATE_XPATH, state);
        QuoteStepDefs.click(FIND_BUTTON_XPATH);
    }

    @Then("I validate {string} zip code exists in the result")
    public void iValidateZipCodeExistsInTheResult(String zipcode) {
        PredefinedStepDefs.iWaitForElementWithXpathToBePresent(HEADER_ZIPCODE_BY_ADDRESS_XPATH);
        assertTrue(QuoteStepDefs.getText(HEADER_ZIPCODE_BY_ADDRESS_XPATH).equals(HEADER_ZIPCODE_BY_ADDRESS_TEXT));
        getDriver().findElements(By.xpath(ZIPCODE_BY_RESULTS_ADDRESS_XPATH))
                .forEach(el -> {
                    assertTrue(el.getText().contains(zipcode));
                    System.out.println(el.getText());
                });
    }
}
