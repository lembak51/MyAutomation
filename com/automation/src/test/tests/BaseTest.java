package tests;

import common.ProjectConfig;
import common.driver.DriverFactory;
import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import pages.DesktopPages.DesktopLoginPage;
import pages.WebPages.LoginPages;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected LoginPages loginPage;
    protected DesktopLoginPage desktopLoginPage;

    public static WebDriver driver;
    public static WindowsDriver desktop_driver;

    protected void switchToDesktopDriver(){
        desktop_driver = getDriver();
    }

    @BeforeTest
    public void setupTestRun() throws MalformedURLException{
        driver = new DriverFactory().getDriver();
        initPages();
    }

    @AfterTest
    public void turnDown(){
        if (driver != null) {
            driver.quit();
            driver = null;
        }
        if (desktop_driver != null) {
            desktop_driver.quit();
            desktop_driver = null;
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
