package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
//        features = "src\\test\\resources\\features",
        features = "src/test/resources/features",
        glue = {"stepdefs"},
        plugin = {
                "pretty",
                "json:target/reports/cucumber.json",
//                "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"
        },
        tags = "@test"
)
public class RunCukesTest {

    @AfterClass
    public static void writeExtentReport() {
        String configFilepath = System.getProperty("user.dir") + "/src/test/resources/config/extent-config.xml";
    }
}
