package utils;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import stepdefs.DriverFactory;

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
}
