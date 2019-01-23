package tests;

import common.driver.DriverFactory;
import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import pages.*;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected LoginPages loginPage;
    protected DesktopLoginPage desktopLoginPage;

    public static WebDriver driver;
    public static WindowsDriver desktop_driver;

    @BeforeTest
    public void setupTestRun() throws MalformedURLException{
        driver = new DriverFactory().getDriver();
        desktop_driver = getDriver();
        initPages();
    }

    @AfterTest
    public void turnDown(){
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    @BeforeClass
    public void getReady(){
        initPages();
    }

    public WindowsDriver getDriver(){
        if (desktop_driver == null) {
            desktop_driver = DriverFactory.getInstance();
            desktop_driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        }
        return desktop_driver;
    }

    private void initPages(){
        loginPage = new LoginPages(driver);
        desktopLoginPage = new DesktopLoginPage(getDriver());
    }
}
