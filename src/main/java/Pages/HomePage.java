package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;
    //public WebDriver driver;//$$Using public method
    public HomePage(WebDriver driver){
        this.driver=driver;
    }
    //private By formAuthenticationLink= By.linkText("Form Authentication");
    //public void getFormLink(){
        public LoginPage  getFormLink(){
        //driver.findElement(formAuthenticationLink).click();
        clickLink("Form Authentication");
       // clickLink(formAuthenticationLink);
        return new LoginPage(driver);
    }
    public AlertPage getAlertLink(){
        clickLink("JavaScript Alerts");
        return new AlertPage(driver);
    }
    public void clickLink(String linkText){
      driver.findElement(By.linkText(linkText)).click();

    }

}


