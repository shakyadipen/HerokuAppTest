package com.heroku.app.TestUtilitities;

import com.heroku.app.BaseTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class Testutils extends BaseTest {

    public void getScreenshot() throws IOException {
        Date date=new Date();
        String destination = System.getProperty("user.dir");
        String timestamp=date.toString().replace(":","_");
        File screenshotFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotFile,new File(destination+"\\Screenshots\\"+"error"+timestamp+".png"));

    }

}
