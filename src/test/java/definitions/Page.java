package definitions;

import org.openqa.selenium.support.*;

import static support.TestContext.getDriver;

public class Page {

    //constructor?


    public static void open(String page) {
        getDriver().navigate().to(page);
    }

}
