package runners;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "/src/test/resources/features",
        glue = {"stepdefs", "utils"},
        plugin = {"pretty", "json:target/reports/cucumber.json"},
        tags = "@test"
)
public class RunCukesTest{
}
