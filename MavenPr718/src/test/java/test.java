import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.Assert;
import org.testng.annotations.*;

import utilitis.baseUrl;
import Application.*;


import java.io.FileNotFoundException;
import java.sql.Driver;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class test {
    WebDriver driver;
    ExtentReports reports = new ExtentReports();
    ExtentTest test ;
    ExtentSparkReporter spark;


    @BeforeMethod
    @Parameters({"browser","url"})
    public void setup(String browser,String url){
      baseUrl base = new baseUrl();
      if(browser.equalsIgnoreCase("firefox")){
          driver= new FirefoxDriver();
          driver.get(url);
          driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
          driver.manage().window().maximize();


      } else if (browser.equalsIgnoreCase("chrome")) {
          driver = new ChromeDriver();

          driver.get(url);
          driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
          driver.manage().window().maximize();

      }

      spark = new ExtentSparkReporter("src/main/java/Reporting/reports.html");
      reports.attachReporter(spark);

    }



    public void testTheSway(){
        WebElement SwayName = driver.findElement(By.className("form_group"));
        WebElement credit = driver.findElement(RelativeLocator.with(By.className("login_logo")).above(SwayName));
        System.out.println(credit.getText());

    }@Test
    public void LogIn () throws InterruptedException  {
        //ClassLoader classLoader = test.class.getClassLoader();
        //URl resource = classLoader.getResource("BooK1(1).xlsx");
     //   assert resource !=null;
        String pageTitle = driver.getTitle();
        ExtentTest test = reports.createTest("Login Test", "heeeee bhabha");
        if (pageTitle.equals("Swag Las")) {
            System.out.println("paaaas  regop");
            test.log(Status.PASS,"paaaased");
        } else {
            System.out.println("Wrong page title");
            test.log(Status.FAIL,"NYoso nje");
        }


// test.log(Status.INFO, "Website loaded successfully");
     // ExtentTest test = reports.createTest("Login Test", "Verify login functionality with invalid credentials");
        Login LG = new Login(driver);
        LG.UserName();
        LG.Pasword();
        LG.LoginB();
        Thread.sleep(2000);
        /*
        test.log(Status.PASS,"it has login successfully");
      Products PD = new Products(driver);
        PD.clickOnProducts();
        PD.clickOnAddToCart();
       // LG.BarM();
        Thread.sleep(2000);
        test.log(Status.PASS,"it has added the item to cart");
      Cart Ct = new Cart(driver);
        Ct.check();
        Thread.sleep(200);
        test.log(Status.PASS,"it has successfully checked out in cart");
        CheckOut ck = new CheckOut(driver);
        ck.fName();
        ck.lName();
        ck.Code();
        ck.BtnCon();
        test.log(Status.PASS,"it has successfully add personal information");
        Thread.sleep(2000);
        Confirmation cn = new Confirmation(driver);
        cn.confB();
        Thread.sleep(2000);
        test.log(Status.PASS,"Order has been confirmed");*/

    }
 /* @Test
    public void LoginInvalid () throws InterruptedException {
        test = reports.createTest("Test website login","Try to logIn with Invalid Logins");
        Login lg = new Login(driver);
        lg.UserNameInvalid();
        lg.PaswordInvalid();
        lg.LoginB();
        Thread.sleep(2000);
        test.log(Status.FAIL, "Failed to login");
    } */
    @AfterMethod
    public void tearDwn(){

        reports.flush();
        driver.quit();
    }
}
