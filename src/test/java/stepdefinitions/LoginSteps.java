package stepdefinitions;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Silviu_Titirca on 1/10/2022
 */
public class LoginSteps extends BaseClass{

    @BeforeAll
    public static void driverInitialization(){
        driver = setupDriver();
    }

    @AfterAll
    public static void driverClosure(){
        closeDriver(driver);
    }

    @Given("the user is on login page")
    public void the_user_is_on_login_page() {

        driver.get("https://opensource-demo.orangehrmlive.com/");

        boolean pageLoaded = driver.findElement(By.xpath("//*[@id=\"divLogo\"]/img")).isDisplayed();
        Assertions.assertEquals(true, pageLoaded);
        System.out.println("The user is on login page");
    }

    @When("the user enters valid credentials")
    public void the_user_enters_valid_credentials() {
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("admin123");
        System.out.println("The user entered username and password");
    }

    @When("user hits submit button")
    public void user_hits_submit_button() {
        driver.findElement(By.id("btnLogin")).click();
        System.out.println("Clicked on submit button");

    }
    @Then("the user should be logged in successfully")
    public void the_user_should_be_logged_in_successfully() {
        boolean loginSuccessfully = driver.findElement(By.id("welcome")).isDisplayed();
        assertTrue(loginSuccessfully);
        System.out.println("Login was successfully !!!");
    }

    @Then("logout")
    public void logout() {
        driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/logout");
        System.out.println("Logged out !");
    }


}
