package pages;

import org.openqa.selenium.support.PageFactory;

import static support.TestContext.getDriver;

public class Page {
    //we extract everything that was duplicated in the other classes to this one

    protected String url; //обозначаем эту переменную, но ее значение присвоено в других классах
    protected String title;

    //constructor
    public Page() { //extracted constructor
        PageFactory.initElements(getDriver(), this);
    }

    //methods
    public void open() {
        getDriver().get(url);
    }

    public void refreshPage() {
        getDriver().navigate().refresh();
    }

}
