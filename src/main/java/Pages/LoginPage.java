package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver=driver;

    }
    //public WebDriver driver;//$$using public method
    private By emailField= By.id("username");
    private By passwordField=By.id("password");
    private By loginButton=By.className("radius");

    public void setMail(String email){

        driver.findElement(emailField).sendKeys(email);
    }
    public void setPassword(String pwd){
        driver.findElement(passwordField).sendKeys(pwd);

    }
    public SecurePage clickLogin(){

        driver.findElement(loginButton).click();
        return new SecurePage(driver);
    }

}
