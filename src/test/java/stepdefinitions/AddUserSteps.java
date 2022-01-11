package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobjects.AddNewUser;
import pageobjects.LoginPage;
import pageobjects.Menu;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Silviu_Titirca on 1/11/2022
 */
public class AddUserSteps extends BaseClass{

    private static WebDriver driver;

    @Given("an admin user is logged in")
    public void an_admin_user_is_logged_in() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        setupDriver(driver);

        driver.get("https://opensource-demo.orangehrmlive.com/");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin", "admin123");
        boolean loginSuccessfully = driver.findElement(By.id("welcome")).isDisplayed();
        assertTrue(loginSuccessfully);
        System.out.println("Login was successfully !!!");
    }

    @When("navigating to Admin page")
    public void navigating_to_admin_page() {
        menu = new Menu(driver);
        menu.clickAdmin();
    }

    @Then("new user should be able to be created")
    public void new_user_should_be_able_to_be_created() {
        String employee = randomString();
        addNewUser = new AddNewUser(driver);
        addNewUser.clickOnAddNewUser();
        addNewUser.setEmployeeName(employee);
        addNewUser.setUsername(employee);
        addNewUser.setPassword(employee);
        addNewUser.clickOnSave();
    }

    @Then("admin logout")
    public void admin_logout() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.logout();
        System.out.println("Logged out !");
    }

}
