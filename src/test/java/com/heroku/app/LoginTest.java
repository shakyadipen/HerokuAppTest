package com.heroku.app;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.SecurePage;
import com.heroku.app.TestUtilitities.JiraCreateIssue;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class LoginTest extends BaseTest{
    //private WebDriver driver;
   /* Using public method
    public WebDriver driver;
   // LoginPage lp;
    public LoginTest(WebDriver driver){
       this.driver=driver;
    }
    */
//    //LoginPage loginpage;
//    @JiraCreateIssue(isCreateIssue=true)
    @JiraCreateIssue(isCreateIssue = true)
    @Test
    public void successfulLogin(){
        LoginPage loginpage=homePage.getFormLink();
        logger.info("Authentication Form clicked");
        loginpage.setMail(username);
        logger.info("Email Entered");
        loginpage.setPassword(password);
        logger.info("Password Entered");

        //loginpage.clickLogin();
        SecurePage securepage=loginpage.clickLogin();
        logger.info("Login button clicked");
        assertTrue(securepage.getTitle().contains("You logged into a secure area!"));
        logger.info("Login done successfully");
        //Assert.assertEquals("",);


//        loginpage=new LoginPage(driver);
//        //lp=new LoginPage(driver);//$$using public method$$//
//        //lp.setMail("tomsmith");//$$ using public method//
//        //lp.setPassword("SuperSecretPassword!");//$$ using public method//
//        loginpage.setMail("tomsmith");//according to test uni
//        loginpage.setPassword("SuperSecretPassword!");//according to test uni
//        loginpage.clickLogin();
        //logout=new SecurePage(driver);
        securepage.clickLogout();
        logger.info("Logout Button Clicked");

    }
    //@Test
//    public void successfulLogout(){
//        SecurePage logout;
//        logout=new SecurePage(driver);
//        logout.clickLogout();
//        logger.info("Logout Button Clicked");
//
//
//    }
}
