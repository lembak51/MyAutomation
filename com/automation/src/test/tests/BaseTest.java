package tests;

import common.AppiumServerJava;
import common.driver.DriverFactory;
import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pages.DesktopPages.DesktopLoginPage;
import pages.WebPages.LoginPages;


public class BaseTest {
    protected LoginPages loginPage;
    protected DesktopLoginPage desktopLoginPage;

    public static WebDriver driver;
    public static WindowsDriver desktop_driver;

    @BeforeTest
    public void setupTestRun() {
        driver = new DriverFactory().getDriver();
        initPages();
    }

    @AfterTest
    public void turnDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
        if (desktop_driver != null) {
            desktop_driver.quit();
            desktop_driver = null;
            AppiumServerJava.stopServer();
        }
    }

    protected void switchToDesktop() {
        AppiumServerJava.startServer();
        desktop_driver = DriverFactory.getInstance();
        initDesktopPages();
    }

    private void initPages() {
        loginPage = new LoginPages(driver);

    }

    private void initDesktopPages() {
        desktopLoginPage = new DesktopLoginPage(desktop_driver);
    }

}
