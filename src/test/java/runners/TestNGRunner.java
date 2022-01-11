package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/**
 * @author Silviu_Titirca on 1/10/2022
 */
@CucumberOptions(
        features = "src/test/resources/Admin.feature",
        glue = {"stepdefinitions"},
        dryRun = true,
        publish = true)
public class TestNGRunner extends AbstractTestNGCucumberTests {
    public TestNGRunner() {
    }
}
