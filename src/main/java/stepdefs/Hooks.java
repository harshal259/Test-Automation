package stepdefs;

import io.cucumber.java.*;
import utils.CommonUtils;

import java.io.IOException;
import java.sql.SQLException;

public class Hooks extends DriverFactory{

    @Before
    public void setUp() throws IOException, SQLException, ClassNotFoundException {
        System.out.println("This is the before hook");
//        conn = getDBConnection();

        driver = new DriverFactory().getDriver();
        driver.manage().window().maximize();
        testURL = propReader.readProperty("testURL");
    }

    @After
    public void tearDown() throws SQLException{
        System.out.println("This is the after hook\nClosing the browser...");
        new DriverFactory().destroyDriver();
//        conn.close();
    }

    @AfterStep
    public void captureScreenshot() throws Exception {
        CommonUtils.takeSnapShot(driver);
    }
}
