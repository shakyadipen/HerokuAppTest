package com.heroku.app;

import Pages.SecurePage;
import com.heroku.app.TestUtilitities.JiraCreateIssue;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest{
    //private WebDriver driver;
    SecurePage logout;
    @Test
    @JiraCreateIssue(isCreateIssue = true)
    public void logoutTest(){
        logout=new SecurePage(driver);
        logout.clickLogout();
        logger.info("Logout Button Clicked");


    }
}
