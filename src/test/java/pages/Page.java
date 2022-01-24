package pages;

import org.openqa.selenium.support.PageFactory;

import static support.TestContext.getDriver;

public class Page {

    protected String url;
    protected String title;

    //constructor

    public Page(){

        PageFactory.initElements(getDriver(),this);
    }

    public  void open(){
        getDriver().get(url);
    }

    public void refreshPage(){
        getDriver().navigate().refresh();
    }
}
