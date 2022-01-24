package pages;

import org.openqa.selenium.support.PageFactory;

import static support.TestContext.getDriver;

public class Page {

    protected String url;      // protected: means accessible only by subclasses (QuoteForm, QuoteFormResult)
    protected String title;

    //constructor
    public Page() {
        PageFactory.initElements(getDriver(), this);  //init means initialization
    }

    public void open() {
        getDriver().get(url);
    }

    public void refreshPage() {
        getDriver().navigate().refresh();
    }

}
