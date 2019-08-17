package utils;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import stepdefs.DriverFactory;

import java.io.IOException;

public class Hooks extends DriverFactory{
    @Before
    public void setUp() throws IOException {
        System.out.println("This is the before hook");

        driver = new DriverFactory().getDriver();
        driver.manage().window().maximize();
        testURL = propReader.readProperty("testURL");
    }

    @After
    public void tearDown() {
        System.out.println("This is the after hook\nClosing the browser...");
        new DriverFactory().destroyDriver();
    }
}
