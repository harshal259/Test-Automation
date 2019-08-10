package stepdefs;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class steps extends DriverFactory {

    private static WebDriver driver = null;
    public static String browser = null;
    public static String driverPath = System.getProperty("user.dir") + "\\drivers\\";
    public static String testURL = null;


    @Before
    public void setUp() throws IOException {
        System.out.println("This is the before hook");

        driver = new DriverFactory().getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        testURL = propReader.readProperty("testURL");
        driver.get(testURL);
    }

    @After
    public void tearDown() {
        System.out.println("This is the after hook\nClosing the browser...");
        new DriverFactory().destroyDriver();
    }

    @Given("^user is on homepage$")
    public void user_is_on_homepage() throws Throwable {
        System.out.println("Hello World!!!\nScenario Started....");
        System.out.println("Page Title is: " + driver.getTitle());
    }


}
