package pages;

import org.openqa.selenium.support.PageFactory;

import static support.TestContext.getDriver;

public class UpsPage {


    protected String url;
    protected String title;

    //constructor
    public UpsPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public void open() {
        getDriver().get(url);
    }


}
