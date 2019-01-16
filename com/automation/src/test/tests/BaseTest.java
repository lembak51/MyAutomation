package tests;

import common.driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pages.*;

public class BaseTest {


    public static WebDriver driver;

    @BeforeTest
    public void setupTestRun(){
        driver = new DriverFactory().getDriver();
        initPages();
    }

    @AfterTest
    public void turnDown(){
        if(driver != null) {
            driver.quit();
            driver = null;
        }
    }

    private void initPages(){
    }
}
