package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import pageobjects.AdminPage;
import pageobjects.LoginPage;
import pageobjects.Menu;
import pageobjects.PimPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Silviu_Titirca on 1/11/2022
 */
public class AddUserSteps extends BaseClass{

    @Before
    public void driverInitialization(){
        driver = setupDriver();
    }

    @After
    public void closeDriver(){
        driver.close();
        System.out.println("-------------------- Driver closed --------------");
    }

    @Given("an admin user is logged in")
    public void an_admin_user_is_logged_in() {
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
        System.out.println("Landed on Admin page !");
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
        System.out.println("New user created successfully !");
    }

    @Then("admin logout")
    public void admin_logout() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.logout();
        System.out.println("Logged out !");
    }

    @When("navigation to PIM page")
    public void navigation_to_pim_page() {
        menu = new Menu(driver);
        menu.clickPIM();
        System.out.println("Landed on PIM page !");
    }
    @Then("new employee should be able to be created")
    public void new_employee_should_be_able_to_be_created() {
        pimPage = new PimPage(driver);
        pimPage.clickOnAddNewUser();
        pimPage.createNewEmployee("Georgel", "Purcel");
        System.out.println("Georgel Purcel user created succesfully !");
    }
    @Then("search for new employee created")
    public void search_for_new_employee_created() {
        menu = new Menu(driver);
        menu.clickPIM();
        pimPage = new PimPage(driver);
        pimPage.searchForAnEmployee("Georgel Purcel");
        System.out.println("Searched for new employee created !");
    }

    @Then("delete the newly created user")
    public void delete_the_newly_created_user() {
        menu = new Menu(driver);
        menu.clickPIM();
        pimPage = new PimPage(driver);
        pimPage.deleteAnEmployee("Georgel Purcel");
        System.out.println("New employee deleted successfully !");
    }

}
