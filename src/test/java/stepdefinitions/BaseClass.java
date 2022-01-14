package stepdefinitions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageobjects.AdminPage;
import pageobjects.LoginPage;
import pageobjects.Menu;
import pageobjects.PimPage;

import java.time.Duration;

/**
 * @author Silviu_Titirca on 1/10/2022
 */
public class BaseClass{

    public static WebDriver driver;
    public LoginPage loginPage;
    public Menu menu;
    public AdminPage adminPage;
    public PimPage pimPage;

    //Random for unique email
   public static String randomString(){
       String generatedString = RandomStringUtils.randomAlphabetic(5);
       return  generatedString;
   }

   public static WebDriver setupDriver(){
       WebDriverManager.chromedriver().setup();
       ChromeOptions options = new ChromeOptions();
       //setHeadless on true if running on docker image
       options.setHeadless(true);
       driver = new ChromeDriver(options);
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
       driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
       driver.manage().window().maximize();
       System.out.println("-------------------- Driver initialized --------------");
       return driver;
   }

   public static void closeDriver(WebDriver driver){
       if(!driver.toString().contains("(null)")){
           driver.quit();
           System.out.println("-------------------- Driver closed --------------");
       } else System.out.println("-------------------- Driver already closed --------------");
   }

}
