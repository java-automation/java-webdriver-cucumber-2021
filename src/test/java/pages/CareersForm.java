package pages;

import com.gargoylesoftware.htmlunit.*;
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

    @FindBy(xpath = "//a[contains(@href,'recruit')]")
    private WebElement recruitButton;


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

}
