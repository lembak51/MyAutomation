package tests;

import common.driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pages.*;

public class BaseTest {

    protected ExamplePage examplePage;
    protected ExampleDashboardPage exampleDashboardPage;
    protected ExampleAddNewUserPage exampleAddNewUserPage;

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
        examplePage = new ExamplePage(driver);
        exampleDashboardPage = new ExampleDashboardPage(driver);
        exampleAddNewUserPage = new ExampleAddNewUserPage(driver);
    }
}
