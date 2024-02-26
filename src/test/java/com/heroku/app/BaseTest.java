package com.heroku.app;

import Pages.HomePage;
import Pages.LoginPage;
import com.google.common.io.Files;
import com.heroku.app.TestUtilitities.ReadConfig;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
//import org.testng.reporters.Files;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    ReadConfig readconfig=new ReadConfig();
    String url=readconfig.getApplicationUrl();
    String username=readconfig.getUsername();
    String password=readconfig.getPassword();
    //public static WebDriver driver;//according to test uni
    public static Logger logger;
    public static WebDriver driver;//%% using public method
    protected HomePage homePage;//acxcording to testuniversity
    @BeforeClass
    public void setup() throws InterruptedException {
        logger=Logger.getLogger("HerokuAppTesting");
        PropertyConfigurator.configure("log4j.properties");
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + ".\\Resources\\chromedriver.exe");
        driver = new ChromeDriver();
//        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + ".\\Resources\\msedgedriver.exe");
//        driver=new EdgeDriver();
        homePage=new HomePage(driver);//according to test uni
        driver.get(url);
        logger.info("Browser Opened With link");
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Thread.sleep(5);
    }
//    @AfterMethod
//    public void recordFailure(ITestResult result){
//       if(ITestResult.FAILURE == result.getStatus()){
//            var camera=(TakesScreenshot)driver;
//            File screenshot= camera.getScreenshotAs(OutputType.FILE);
//            System.out.println("ScreenshotTaken"+screenshot.getAbsolutePath());
//            try{
//                Files.move(screenshot, new File("resources/screenshot/test.png"));
//            }catch(IOException e){
//                e.printStackTrace();
//            }
////            try{
////                Files.move(screenshot, new File("resources/screenshot/"+result.getName()));
////            }
////            catch(IOException e){
////                e.printStackTrace();
////            }
//        }
//
//    }

    @AfterClass
    public void teardown(){
        driver.quit();
        logger.info("Browser closed");
    }
//    public static void main(String[] args) throws InterruptedException {
//        BaseClass bp = new BaseClass();
//        bp.setup();
//        bp.teardown();
//
//    }

}
