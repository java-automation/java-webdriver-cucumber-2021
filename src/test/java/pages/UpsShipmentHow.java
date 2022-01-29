package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Comparator;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static support.TestContext.getDriver;

public class UpsShipmentHow extends UpsShipmentPage {

    public UpsShipmentHow() {
        urlRegExp = ".*www.ups.com/ship/guided/pickup-service.*";
    }

    // fields
    @FindBy(xpath = "//span[@id='total-charges-spinner']")
    private WebElement totalCharges;

    @FindBy(xpath = "//span[@id='total-charges-spinner']//spinner/img")
    private WebElement totalChargesSpinner;

    @FindBy(xpath = "//div[@class='ups-accordion_list']//p[contains(@class,'serviceCard_footer-price')]")
    private List<WebElement> allServices;

    // methods
    public boolean verifyTotalChargesPresent() {
        waitForUrlMatch();
        wait.until(ExpectedConditions.invisibilityOf(totalChargesSpinner));
        return totalCharges.getText().matches(".*\\$\\d+.\\d+.*");
    }

    public String getTotalCharges() {
        wait.until(ExpectedConditions.invisibilityOf(totalChargesSpinner));
        return totalCharges.getText();
    }

    public void selectCheapestOption() {
        wait.until(driver -> urlMatches());
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        WebElement minPriceElem = allServices.stream().min(Comparator.comparingDouble(elem -> {
            try { return formatter.parse(elem.getText()).doubleValue();
            } catch (ParseException e) {
                throw new Error(e);
            }})).orElseThrow();
        ((JavascriptExecutor)getDriver()).executeScript("arguments[0].scrollIntoView({" +
                                                 "behavior: 'auto',block: 'center',inline: 'center'});", minPriceElem);
        String minPrice = minPriceElem.getText();
        minPriceElem.click();
        assertThat(minPrice).isEqualTo(getTotalCharges());
    }
}
