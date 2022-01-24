package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class QuoteResult extends Page {

   public QuoteResult() {
      url  = "https://skryabin.com/market/result.html";
      title = "Submitted Result";

   }

   @FindBy(id="quotePageResult")
   private WebElement resultContainer;

   @FindBy(xpath = "//b[@name='password']")
   private WebElement password;

   @FindBy(xpath = "//b[@name='agreedToPrivacyPolicy]")
   private WebElement agreedToPrivacyPolicy;


   public String getResultContainerText(){
      return resultContainer.getText();
   }

   public String getPasswordText(){
      return password.getText();
   }

   public boolean isAgreedToPrivacyPolicy(){
      return Boolean.parseBoolean( agreedToPrivacyPolicy.getText());
   }
}
