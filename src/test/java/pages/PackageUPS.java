package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static support.TestContext.getDriver;

public class PackageUPS extends UpsControls {

    public PackageUPS() {

        //PageFactory.initElements(getDriver(), this);
    }

    WebDriverWait wait = new WebDriverWait(getDriver(), 5);
    //fields

    @FindBy(xpath = "//select[@id='nbsPackagePackagingTypeDropdown0']")
    private WebElement packagingType;

    @FindBy(xpath = "//input[@id='nbsPackagePackageWeightField0']]")
    private WebElement weight;


    public void fillPackaging(String value) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@id='nbsPackagePackagingTypeDropdown0']")));
        new Select(packagingType).selectByVisibleText(value);
    }
        public void fillPackageWeight (String value){
            weight.sendKeys(value);
        }
    }
