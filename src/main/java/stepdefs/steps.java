package stepdefs;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.en.And;
import cucumber.api.java.en.But;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class steps {

    public static WebDriver driver;

    @Given("^user is on homepage$")
    public void user_is_on_homepage() throws Throwable {
        System.out.println("Hello World!!!");

//        System.setProperty("webdriver.gecko.driver","/Users/Documents/geckodriver");
//        System.setProperty("webdriver.chrome.driver","MentionPathtothisdriver/chromedriver");
//        System.setProperty("webdriver.gecko.driver","C:\Users\Harshal Purohit\IdeaProjects\MyFW\HelloWorld\drivers\\geckodriver.exe");
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Harshal Purohit\\IdeaProjects\\MyFW\\HelloWorld\\drivers\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://automationpractice.com/index.php");
    }

    @When("^user navigates to Login Page$")
    public void user_navigates_to_Login_Page() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^user enters username and Password$")
    public void user_enters_username_and_Password() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^success message is displayed$")
    public void success_message_is_displayed() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
