package stepdefs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.PropertyReader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DriverFactory {

    protected static WebDriver driver;
    public static String driverPath;
    public static String platform = System.getProperty("os.name");
    public static String browser = null;
    public static String testURL = null;
    public static PropertyReader propReader = new PropertyReader();
    public static Connection conn = null;
    public static Statement stmt = null;
    public static ResultSet resultSet = null;

    public DriverFactory() {
        initialize();
    }

    public void initialize() {
        if (driver == null)
            createNewDriverInstance();
    }

    private void createNewDriverInstance() {
        System.out.println("OS is: " + platform);
        browser = propReader.readProperty("browser");
        switch (browser) {

            case "chrome":

                if (platform.contains("Windows"))
                    driverPath = System.getProperty("user.dir") + "\\drivers\\" + "chromedriver.exe";
                else
//                driverPath = System.getProperty("user.dir") + "/drivers/" + "chromedriver";
                    driverPath = "/usr/bin/chromedriver";
                System.out.println("Driver Path: " + driverPath);
                System.setProperty("webdriver.chrome.driver", driverPath);

                ChromeOptions options = new ChromeOptions();
                options.addArguments("--no-sandbox");
                options.addArguments("--headless");
                options.addArguments("start-maximized"); // open Browser in maximized mode
                options.addArguments("--disable-extensions"); // disabling extensions
                options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems

                driver = new ChromeDriver(options);
                break;

            case "firefox":
                if (platform.contains("Windows"))
                    driverPath = System.getProperty("user.dir") + "\\drivers\\" + "geckodriver.exe";
                else
                    driverPath = System.getProperty("user.dir") + "/drivers/" + "geckodriver";
                System.out.println("Driver Path: " + driverPath);
                System.setProperty("webdriver.gecko.driver", driverPath);
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
                break;

            case "msedge":
                if (platform.contains("Windows"))
//                    driverPath = System.getProperty("user.dir") + "\\drivers\\" + "msedgedriver.exe";
                    driverPath = "C:\\Projects\\drivers\\msedgedriver.exe";
                else
                    driverPath = System.getProperty("user.dir") + "/drivers/" + "msedgedriver";
                System.out.println("Driver Path: " + driverPath);
                System.setProperty("webdriver.edge.driver", driverPath);

                EdgeOptions edgeoptions = new EdgeOptions();
                edgeoptions.addArguments("--no-sandbox");
                edgeoptions.addArguments("--headless");
                edgeoptions.addArguments("start-maximized"); // open Browser in maximized mode
                edgeoptions.addArguments("--disable-extensions"); // disabling extensions
                edgeoptions.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems

                driver = new EdgeDriver(edgeoptions);
                driver.manage().window().maximize();
                break;

            default:
                System.out.println("can't read browser type");
        }
    }

    public WebDriver getDriver() {
        return driver;
    }

    public static String getTestURL() {
        return testURL = propReader.readProperty("testURL");
    }

    public void destroyDriver() {
        driver.quit();
        driver = null;
    }

    public Connection getDBConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "root", "root");
        return conn;
    }
}
