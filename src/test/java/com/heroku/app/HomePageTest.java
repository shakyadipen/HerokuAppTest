package com.heroku.app;
import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
public class HomePageTest extends BaseTest {
    /*
    //%%using public method
   public WebDriver driver;
   public HomePageTest(WebDriver driver){
          this.driver=driver;
             }
    */
    @Test
    public void homePageTest(){
        /* using public method
//        hp=new HomePage(driver);
//        hp.getFormLink();

         */

        homePage.getFormLink();//according to uni
    }

}
