package com.heroku.app;

import Pages.AlertPage;
import com.heroku.app.TestUtilitities.JiraCreateIssue;
import org.testng.Assert;
import org.testng.annotations.Test;



public class AlertTest extends BaseTest{
    @JiraCreateIssue(isCreateIssue = true)
    @Test
    public void alertTest(){
        AlertPage alertpage=homePage.getAlertLink();

        alertpage.clickJs();
        logger.info("Alert Link CLicked");
       // driver.switchTo().alert().accept();
        Assert.assertTrue(alertpage.getAlertText().contains("I am JS Alert"));
        logger.info("Assertion to check the Alerttext");
        alertpage.acceptAlert();
        logger.info("Accept the alert window");
       // Assert.assertTrue((alertpage.getResultText().contains("You successfully clicked an alert")));

    }
}
