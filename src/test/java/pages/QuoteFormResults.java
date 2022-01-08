package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static support.TestContext.getDriver;

public class QuoteFormResults {

    //constructor
    public QuoteFormResults(){
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(xpath = "//b[@name='firstName']")
    private WebElement firstName;

    @FindBy(xpath = "//b[@name='lastName']")
    private WebElement lastName;

//    private String firstNameValue;
//    private String lastNameValue;

    public String getFirstNameValue(){
        return getDriver().findElement(By.xpath("//b[@name='firstName']")).getText();
    }

    public String getLastNameValue(){
        return lastName.getText();
    }


}
