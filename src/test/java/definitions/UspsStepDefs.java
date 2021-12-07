package definitions;

import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import static support.TestContext.getDriver;

public class UspsStepDefs {

    @When("I go to Lookup ZIP page by address through {string}")
    public void iGoToLookupZIPPageByAddress(String strategy) throws InterruptedException {
        if (strategy.equals("quick tools")) {
            getDriver().findElement(By.xpath("//ul[@class='nav-list']//a[contains(@class,'nav-first-element')]")).click();
            Thread.sleep(1000);
            getDriver().findElement(By.xpath("//a[@role='menuitem']/img[contains(@alt,'Zip Code')]")).click();
            Thread.sleep(1000);
            getDriver().findElement(By.xpath("(//a[contains(@class,'btn-primary')][@data-location='byaddress'])[1]")).click();
            Thread.sleep(1000);
        } else if (strategy.equals("send")) {
            getDriver().findElement(By.xpath("//a[@id='mail-ship-width']")).click();
            Thread.sleep(1000);
            getDriver().findElement(By.xpath("//h2/a[contains(normalize-space(text()),'Look Up a ZIP Code')]")).click();
            Thread.sleep(1000);
            getDriver().findElement(By.xpath("(//a[contains(@class,'btn-primary')][@data-location='byaddress'])[1]")).click();
            Thread.sleep(1000);
        } else throw new Error("Unknown strategy: " + strategy);
    }
}
