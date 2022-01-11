package stepdefinitions;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import pageobjects.AdminPage;
import pageobjects.LoginPage;
import pageobjects.Menu;
import pageobjects.PimPage;

import java.time.Duration;

/**
 * @author Silviu_Titirca on 1/10/2022
 */
public class BaseClass{

    public WebDriver driver;
    public LoginPage loginPage;
    public Menu menu;
    public AdminPage adminPage;
    public PimPage pimPage;

    //Random for unique email
   public static String randomString(){
       String generatedString = RandomStringUtils.randomAlphabetic(5);
       return  generatedString;
   }

   public void setupDriver(WebDriver driver){
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
       driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
       driver.manage().window().maximize();
   }


}
