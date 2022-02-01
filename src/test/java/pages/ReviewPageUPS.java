package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ReviewPageUPS extends UpsControls{

    public ReviewPageUPS(){

    }

    @FindBy(xpath = "//div//agent-wrapper/section[@class='ups-section']")
    private WebElement shipFromInfo;

    @FindBy(xpath = "//div[@id='destination_showSummaryAddress']")
    private WebElement shipTo;

    @FindBy(xpath = " //div//shipment-packages//ol/li[@class='ups-list_separator_item ups-package-li-no-bullet ng-star-inserted']")
    private WebElement packageInfo;




}
