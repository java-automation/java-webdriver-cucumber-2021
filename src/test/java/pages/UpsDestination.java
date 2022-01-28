package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Map;

import static support.TestContext.getData;

public class UpsDestination extends Page {

    public UpsDestination() {
        url = "https://www.ups.com/ship/guided/destination";
    }

    Map<String, String> shipToData = getData("destinationHW", "ups");
    public final By SWITCH_YES_MODAL_WINDOW = By.xpath("//span[@aria-hidden='true']/span[@class='ups-lever_switch_yes']");

    @FindBy(id = "origin_showSummaryAddress")
    private WebElement resultContainer;

    @FindBy(id = "destination-cac_country")
    private WebElement country;

    @FindBy(xpath = "//input[@id='destination-cac_companyOrName']")
    private WebElement companyOrName;

    @FindBy(id = "destination-cac_singleLineAddress")
    private WebElement address;

    @FindBy(id = "destination-cac_email")
    private WebElement email;

    @FindBy(id = "destination-cac_phone")
    private WebElement phone;

    @FindBy(xpath = "//ngb-typeahead-window/button")
    private List<WebElement> suggestionsList;

    @FindBy(xpath = "//button[@id='destination-singleLineAddressEditButton']/../p")
    private WebElement filledAddress;

    @FindBy(xpath = "//button[@id='nbsBackForwardNavigationContinueButton']")
    private WebElement continueButton;

    @FindBy(css = ".modal-content")
    private WebElement modalWindow;

    @FindBy(css = "div.modal-content span.ups-icon-x")
    private WebElement closeButtonModalWindow;

    @FindBy(xpath = "//button[@id='nbsAddressClassificationContinue']")
    private WebElement continueButtonModalWindow;

    @FindBy(xpath = "//div[@class='modal-content']//div[@class='ups-group ups-group_condensed']")
    private WebElement shipToAddressContainer;

    @FindBy(xpath = "//span[@class='ups-lever_switch_no']")
    private WebElement switchNo;

    @FindBy(xpath ="//span[@aria-hidden='true']/span[@class='ups-lever_switch_yes']")
    private WebElement switchYes;

    public String getResultSummary() {
        return resultContainer.getText();
    }

    public WebElement getShipToAddressContainer() {
        return shipToAddressContainer;
    }

    public void selectCountry(String value) {
        new Select(country).selectByVisibleText(value);
    }

    public void fillName(String value) {
        companyOrName.sendKeys(value);
    }

    public String getFullShipToName() {
        return ("%s %s %s").formatted(shipToData.get("firstName"), shipToData.get("middleName"), shipToData.get("lastName"));
    }

    public void fillAddress(String value) {
        address.sendKeys(value);
        suggestionsList.get(0).click();
        System.out.println("filledAddress.getText() = " + filledAddress.getText());
        // assertThat(filledAddress.getText()).isEqualTo(value);
    }

    public void fillPhone(String value) {
        phone.sendKeys(value);
    }

    public void fillEmail(String value) {
        email.sendKeys(value);
    }

    public void closeModalWindow() {
        if (closeButtonModalWindow.isDisplayed())
            closeButtonModalWindow.click();
    }

    public void switchNoToYes() {
        switchNo.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(SWITCH_YES_MODAL_WINDOW));
    }

    public void continueModalWindow() {
        if (closeButtonModalWindow.isDisplayed()) {
            continueButtonModalWindow.click();
        }
    }
}
