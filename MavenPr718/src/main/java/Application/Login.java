package Application;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class Login
{
    WebDriver driver;
    public By UserNam = By.xpath("//*[@id=\"user-name\"]");
    public By LoginB = By.xpath("//*[@id=\"login-button\"]");
    public By Password = By.xpath("//*[@id=\"password\"]");
    public By LogOut =  By.xpath("//*[@id=\"logout_sidebar_link\"]");
    public By Menu = By .xpath("//*[@id=\"react-burger-menu-btn\"]");

;
    public  Login (WebDriver driver)  {
        this.driver = driver;

    }
  public void UserName () {

        driver.findElement(UserNam).sendKeys("standard_user");
    }
    public void UserNameInvalid () {

        driver.findElement(UserNam).sendKeys("Samkelo");
    }


public void LoginB (){
    driver.findElement(LoginB).click();
}
public void Pasword ( ){
        driver.findElement(Password).sendKeys("secret_sauce");
}
    public void PaswordInvalid ( ){
        driver.findElement(Password).sendKeys("Swipleft");
    }
public void BarM (){
        driver.findElement(Menu).click();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    WebElement LT = wait.until(ExpectedConditions.elementToBeClickable(LogOut));
    LT.click();
}

}
