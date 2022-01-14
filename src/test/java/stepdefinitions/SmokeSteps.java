package stepdefinitions;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * @author Silviu_Titirca on 1/14/2022
 */
public class SmokeSteps extends BaseClass{

    @BeforeAll
    public static void driverInitialization() {
        driver = setupDriver();
    }

    @AfterAll
    public static void driverClosure(){
        closeDriver(driver);
    }

    @Given("JUnit and Cucumber dependencies are latest in POM")
    public void j_unit_and_cucumber_dependencies_are_latest_in_pom() {
        System.out.println("Checking dependencies ...");
    }
    @When("running this test")
    public void running_this_test() {
        System.out.println("Test run is in progress ...");
    }
    @Then("build should be successfully")
    public void build_should_be_successfully() {
        System.out.println("Building successfully ...");
    }
    @Then("this test shall not fail")
    public void this_test_shall_not_fail() {
        System.out.println("Test is successfully !");
    }

}
