package stepdefs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.PropertyReader;


public class DriverFactory {

    protected static WebDriver driver;
    public static String driverPath = System.getProperty("user.dir") + "\\drivers\\";
    public String browser = null;
    public static String testURL = null;
    public static PropertyReader propReader = new PropertyReader();

    public DriverFactory() {
        initialize();
    }

    public void initialize() {
        if (driver == null)
            createNewDriverInstance();
    }

    private void createNewDriverInstance() {
        browser = propReader.readProperty("browser");

        if (browser.equalsIgnoreCase("chrome")) {
            driverPath = driverPath + "\\chromedriver.exe";
            System.out.println("Driver Path: " + driverPath);
            System.setProperty("webdriver.chrome.driver", driverPath);
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driverPath = driverPath + "\\geckodriver.exe";
            System.out.println("Driver Path: " + driverPath);
            System.setProperty("webdriver.gecko.driver", driverPath);
            driver = new FirefoxDriver();
        } else {
            System.out.println("can't read browser type");
        }
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void destroyDriver() {
        driver.quit();
        driver = null;
    }
}