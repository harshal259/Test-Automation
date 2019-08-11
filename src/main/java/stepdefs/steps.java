package stepdefs;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utils.CommonUtils;

import org.apache.http.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;


public class steps extends DriverFactory {

    private static WebDriver driver = null;
    public static String browser = null;
    public static String driverPath = System.getProperty("user.dir") + "\\drivers\\";
    public CommonUtils commonutils = null;
    
    public steps()
    {commonutils = new CommonUtils();}

    @Before
    public void setUp() throws IOException {
        System.out.println("This is the before hook");

        driver = new DriverFactory().getDriver();
        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        testURL = propReader.readProperty("testURL");
//        driver.get(testURL);
    }

    @After
    public void tearDown() {
        System.out.println("This is the after hook\nClosing the browser...");
        new DriverFactory().destroyDriver();
    }

    @Given("^user is on homepage$")
    public void user_is_on_homepage() {
        System.out.println("Hello World!!!\nScenario Started....");
        System.out.println("Page Title is: " + driver.getTitle());
    }
   
    
    @Given("^user is on home page$")
	public void user_is_on_home_page() throws Throwable {
		driver.get("https://www.facebook.com");
		String title = driver.getTitle();
		System.out.println(driver.getTitle());
//		assertEquals(title, "Facebook � log in or sign up");
	  
	}
    
    @Then("^user created a new account by entering details$")
	public void user_created_a_new_account_by_entering_details() throws Throwable {
    	driver.findElement(By.xpath("//input[@name = 'firstname']")).sendKeys("test");
    	 driver.findElement(By.xpath("//input[@name = 'lastname']")).sendKeys("your skill");
    	 driver.findElement(By.xpath("//input[@name = 'reg_email__']")).sendKeys("abc@abc.com");
    	 driver.findElement(By.xpath("//input[@name = 'reg_passwd__']")).sendKeys("test123");
    	 
    	 commonutils.selectDropdown(driver.findElement(By.xpath("//*[@id=\"day\"]"))).selectByValue("3");
    	 commonutils.selectDropdown(driver.findElement(By.xpath("//*[@id=\"month\"]"))).selectByValue("3");
    	 commonutils.selectDropdown(driver.findElement(By.xpath("//*[@id=\"year\"]"))).selectByValue("2015");
	   
    	 driver.findElement(By.xpath("//input[@value='2']")).click();;
	}
    
    @Then("^user click on Data ploicy link$")
	public void user_click_on_Data_ploicy_link() throws Throwable {
    	String parentWindow = driver.getWindowHandle();
    	//System.out.println(parentWindow);
    	driver.manage().timeouts().implicitlyWait(05, TimeUnit.SECONDS);

    	driver.findElement(By.xpath("//a[@id='privacy-link']")).click();
    	System.out.println("clicked");

    	Set<String> windows = driver.getWindowHandles();

    	for (String w1 : windows) {
    		
    		if(w1.equalsIgnoreCase(parentWindow))
    		{
    			continue;}
    		else
    		
    		{driver.switchTo().window(w1);
    		System.out.println(driver.getCurrentUrl());
    		}
    		
    	}
    	driver.switchTo().window(parentWindow);
    	System.out.println("Hi we are at parent window "+ driver.getCurrentUrl());
	    
	}

    
    @Then("^I clear the entered data and reentered it through excel$")
    public void i_clear_the_entered_data_and_reentered_it_through_excel() throws Throwable {
    	
    	  String path = System.getProperty("user.dir") + "\\src\\test\\resources\\config\\test.xlsx";
    	driver.findElement(By.xpath("//input[@name = 'firstname']")).clear();
    	driver.findElement(By.xpath("//input[@name = 'firstname']")).sendKeys(commonutils.ExcelInput(1, 0, 0, path));

    	driver.findElement(By.xpath("//input[@name = 'lastname']")).clear();
    	driver.findElement(By.xpath("//input[@name = 'lastname']")).sendKeys(commonutils.ExcelInput(1, 1, 0, path));

    	driver.findElement(By.xpath("//input[@name = 'reg_passwd__']")).clear();
    	driver.findElement(By.xpath("//input[@name = 'reg_passwd__']")).sendKeys(commonutils.ExcelInput(1, 2, 0, path));
    	 
    	driver.findElement(By.xpath("//input[@name = 'reg_email__']")).clear();
    	driver.findElement(By.xpath("//input[@name = 'reg_email__']")).sendKeys(commonutils.ExcelInput(1, 3, 0, path));
      
    }

}
