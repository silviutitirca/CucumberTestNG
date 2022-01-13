package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageobjects.AdminPage;
import pageobjects.LoginPage;
import pageobjects.Menu;
import pageobjects.PimPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Silviu_Titirca on 1/11/2022
 */
public class AddUserSteps extends BaseClass{

    private static WebDriver driver;
    WebDriverManager wdm = WebDriverManager.chromedriver().browserInDocker();

    @Given("an admin user is logged in")
    public void an_admin_user_is_logged_in() {

        //WebDriverManager.chromedriver().setup();
        driver = wdm.create();
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
        adminPage = new AdminPage(driver);
        adminPage.clickOnAddNewUser();
        adminPage.setEmployeeName(employee);
        adminPage.setUsername(employee);
        adminPage.setPassword(employee);
        adminPage.clickOnSave();
    }

    @Then("admin logout")
    public void admin_logout() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.logout();
        System.out.println("Logged out !");
        driver.close();
    }

    @When("navigation to PIM page")
    public void navigation_to_pim_page() {
        menu = new Menu(driver);
        menu.clickPIM();
    }
    @Then("new employee should be able to be created")
    public void new_employee_should_be_able_to_be_created() {
        pimPage = new PimPage(driver);
        pimPage.clickOnAddNewUser();
        pimPage.createNewEmployee("Georgel", "Purcel");
    }
    @Then("search for new employee created")
    public void search_for_new_employee_created() {
        menu = new Menu(driver);
        menu.clickPIM();
        pimPage = new PimPage(driver);
        pimPage.searchForAnEmployee("Georgel Purcel");
    }

    @Then("delete the newly created user")
    public void delete_the_newly_created_user() {
        menu = new Menu(driver);
        menu.clickPIM();
        pimPage = new PimPage(driver);
        pimPage.deleteAnEmployee("Georgel Purcel");
        wdm.quit();
    }

}
