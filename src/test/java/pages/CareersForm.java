package pages;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

import java.util.*;

import static support.TestContext.getData;
import static support.TestContext.getDriver;

public class CareersForm {

    Map<String, String> user = getData("careers");
    Actions actions = new Actions(getDriver());
    WebDriverWait wait = new WebDriverWait(getDriver(), 5);

    //constructor
    public CareersForm() {
        PageFactory.initElements(getDriver(), this);
    }

    //fields
    @FindBy(xpath = "//a[contains(@href,'login')]")
    private WebElement loginButton;

    @FindBy(xpath = "//label[@for='loginUsername']/..//input")
    private WebElement username;

    @FindBy(xpath = "//label[@for='loginPassword']/..//input")
    private WebElement password;

    @FindBy(xpath = "//*[@id='loginButton']")
    private WebElement submit;

    @FindBy(xpath = "//a[contains(@href,'candidates')]")
    private WebElement usernameAfterLogin;

    @FindBy(xpath = "//*[contains(@class,'fa-home')]/..")
    private WebElement careersButton;

    @FindBy(xpath = "//a[contains(@href,'recruit')]//button")
    private WebElement recruitButton;

    @FindBy(xpath = "//a[contains(@href,'new_position')]//h4")
    private WebElement newPositionLink;

    @FindBy(xpath = "//label[@for='positionTitle']/..//input")
    private WebElement positionTitle;

    @FindBy(xpath = "//label[@for='positionDescription']/..//textarea")
    private WebElement positionDescription;

    @FindBy(xpath = "//label[@for='positionCity']/..//input")
    private WebElement positionCity;

    @FindBy(xpath = "//select//option[@value='NC']")
    private WebElement positionState;

    @FindBy(xpath = "//input[@id='positionDateOpen']")
    private WebElement positionDate;

    @FindBy(xpath = "//button[@id='positionSubmit']")
    private WebElement positionSubmit;

    //methods
    public void login() throws InterruptedException {
        loginButton.click();
        Thread.sleep(2000);
        username.sendKeys(user.get("email"));
        password.sendKeys(user.get("password"));
        submit.click();
    }

    public void verifyLogin() {
        Assert.assertEquals(usernameAfterLogin.getText(), user.get("username"));
    }

    public void getRecruitPage() {
        recruitButton.click();
    }

    public void deletePosition(String position) throws InterruptedException {
        Thread.sleep(2000);
        WebElement positionCard = getDriver().findElement(By.xpath("//h4[text()='" + position + "']/ancestor::*[contains(@class,'card bg-white mb-3')]"));
        WebElement positionTitle = getDriver().findElement(By.xpath("//h4[text()='" + position + "']/ancestor::*[contains(@class,'card bg-white mb-3')]//button"));
        //wait.until(ExpectedConditions.visibilityOf(positionTitle));
        actions.moveToElement(positionCard).perform();
        positionTitle.click();
    }

    public boolean positionExists(String position) {
        if (getDriver().findElements(By.xpath("//h4[text()='" + position + "']")).size() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public void createPosition() {
        recruitButton.click();
        newPositionLink.click();
        positionTitle.sendKeys("QA Manager II");
        positionDescription.sendKeys("We are looking for a reliable Manager of Quality Assurance to ensure that all external and internal requirements are met before our product reaches our customers. You will be responsible for inspecting procedures and outputs and identifying mistakes or non-conformity issues.");
        positionCity.sendKeys("Raleigh");
        positionDate.sendKeys("03/01/2022");
        positionState.click();
        positionSubmit.click();
    }

    public void waitForPositionsPage() {
        wait.until(ExpectedConditions.visibilityOf(careersButton));
    }

    public boolean positionIsCreated() {
        if(positionExists("QA Manager II")) {
            return true;
        } else {
            return false;
        }
    }

    public void removePosition() throws InterruptedException {
        deletePosition("QA Manager II");
    }

    public boolean positionIsRemoved() {
        if(!positionExists("QA Manager II")) {
            return true;
        } else {
            return false;
        }
    }
}
