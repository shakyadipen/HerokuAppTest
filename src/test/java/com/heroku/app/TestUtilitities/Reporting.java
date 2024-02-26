package com.heroku.app.TestUtilitities;

import Pages.LoginPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.heroku.app.BaseTest;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
//import org.apache.logging.log4j.core.util.FileUtils;
//import org.apache.commons.io.Fileutils;
import java.io.File;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

//import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Reporting extends TestListenerAdapter {
    public ExtentReports extent;
    public ExtentHtmlReporter htmlReporter;
    public ExtentTest logger;
    //private Object driver;

    public void onStart(ITestContext testContext) {

        String dateFormat = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        String ReportName = "HerokuApp" + dateFormat + ".html";
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/" + ReportName);
        htmlReporter.loadXMLConfig(System.getProperty("user.dir")+ "/extent-report-config.xml");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Host Name", "LocalHost");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("User", "Shakya");

        htmlReporter.config().setDocumentTitle("Heroku App Test");
        htmlReporter.config().setReportName("Functional Test Report");
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setTheme(Theme.DARK);
    }

    public void onTestSuccess(ITestResult tr){
        logger=extent.createTest(tr.getName());
        logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
    }
    public void onTestFailure (ITestResult result){

        logger=extent.createTest(result.getName());
        logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName(), ExtentColor.RED));
        String screenshotPath=System.getProperty("user.dir"+"\\Screenshots\\"+result.getName()+".png");
        System.out.println("test failed with screenshot");
        ///For jira integration-Start
        boolean islogIssue = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(JiraCreateIssue.class).isCreateIssue();

        if (islogIssue) {

            JiraServiceProvider JiraServiceProvider = new JiraServiceProvider("https://shakyadipen.atlassian.net", "shakyadipen@gmail.com", "ATATT3xFfGF0fQfLZsA_Ljjb6wy5kW2_BGsm6FgJu2-ifugXgSvGUSqYqoFwDzVYViqT3zZKkaasNvnSKkkBVlR2Qyyjrp4DtX3oTKUByVKz3qXOMUiuEGf85cndVtzV4Rhh01-zz3GAST4b58ZjJxbeWue4GqWsckQswg9-NR3nP3b76cSe9zI=A283FCCD", "EC");

            String issueDescription = "Failure Reason from Automation Testing\n\n" + result.getThrowable().getMessage() + "\n";

            issueDescription.concat(ExceptionUtils.getFullStackTrace(result.getThrowable()));

            String issueSummary = result.getMethod().getConstructorOrMethod().getMethod().getName() + " Failed in Automation Testing";

            JiraServiceProvider.createJiraIssue("Bug", issueSummary, issueDescription);
        }
         //Date date=new Date();
        //String timestamp=date.toString().replace(":","_").replace("","_");
        Testutils screen=new Testutils();
        try {
            screen.getScreenshot();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //This much for jira integration-End
//        String screenshotPath=System.getProperty("user.dir"+"\\Screenshots\\"+"fails"+".png");
//        File sc= ((TakesScreenshot)BaseTest(driver).getScreenshotAs(OutputType.FILE);
//       TakesScreenshot ts = (TakesScreenshot)driver;
//        File source = ts.getScreenshotAs(OutputType.FILE);
//        String destination = System.getProperty("user.dir") + "\\Screenshots\\"+"error"+timestamp+".png";
//        File finalDestination = new File(destination);
//        try {
//            FileUtils.copyFile(source, finalDestination);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
    }
    public void onTestSkip(ITestResult tr){
        logger=extent.createTest(tr.getName());
        logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.YELLOW));
    }
    public void onFinish(ITestContext testContext){
        extent.flush();

    }
}
