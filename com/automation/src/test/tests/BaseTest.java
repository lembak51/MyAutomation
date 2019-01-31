package tests;

import common.AppiumServerJava;
import common.driver.DriverFactory;
import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pages.desktopPages.DesktopLoginPage;
import pages.webPages.LoginPage;



import pages.webPages.DashboardPage;

public class BaseTest {
    protected LoginPage loginPage;
    protected DashboardPage dashboardPage;
    protected DesktopLoginPage desktopLoginPage;

    public static WebDriver driver;
    public static WindowsDriver desktop_driver;

    @BeforeTest
    public void setupTestRun() {
        driver = new DriverFactory().getDriver();
        initPages();
    }

    @AfterMethod
    public void logoutAfterTest(){
        if(!loginPage.isLogInButtonDisplayed())
            dashboardPage.logout();
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
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
    }

    private void initDesktopPages() {
        desktopLoginPage = new DesktopLoginPage(desktop_driver);
    }

}
