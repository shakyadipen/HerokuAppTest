package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertPage {
    private WebDriver driver;
    public AlertPage(WebDriver driver){
        this.driver=driver;
    }
    private By jsalert= By.xpath("//*[@id=\"content\"]/div/ul/li[1]/button");
    private By result=By.id("result");
    public AlertPage clickJs(){
        driver.findElement(jsalert).click();
        return new AlertPage(driver);
    }
    public void acceptAlert(){
        driver.switchTo().alert().accept();
    }
    public String getAlertText(){
        return driver.switchTo().alert().getText();

    }
    public String getResultText(){
        return driver.findElement(result).getText();
    }
}
