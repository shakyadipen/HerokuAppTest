package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SecurePage {
    private WebDriver driver;
    private By pageTitle= By.id("flash");
    private By logout=By.xpath("/html/body/div[2]/div/div/a");
    public SecurePage(WebDriver driver){
        this.driver=driver;
    }
    public String getTitle(){
        return driver.findElement(pageTitle).getText();
       // String getTitle=title.getText();
    }
    public void clickLogout(){
        driver.findElement(logout).click();
    }
}
