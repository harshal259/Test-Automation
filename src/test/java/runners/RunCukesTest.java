package runners;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
//        features = "/var/lib/jenkins/workspace/MyFW/src/test/resources/features",
//        features = "C:\\Program Files (x86)\\Jenkins\\workspace\\Test-Automation\\src\\test\\resources\\features",
        features = "src\\test\\resources\\features",
        glue = {"stepdefs", "utils"},
        plugin = {"pretty", "json:target/reports/cucumber.json"},
        tags = "@test"
)
public class RunCukesTest{
}
