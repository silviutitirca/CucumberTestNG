package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/**
 * @author Silviu_Titirca on 1/10/2022
 */
@CucumberOptions(
        features = "src/test/resources/",
        glue = {"stepdefinitions"},
        dryRun = false,
        monochrome = true,
        plugin = {"pretty","html:test-output"},
        publish = true)
        //tags = "@SmokeTest")
public class TestNGRunner extends AbstractTestNGCucumberTests {
}
