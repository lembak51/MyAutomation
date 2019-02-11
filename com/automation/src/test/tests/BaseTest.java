package tests;

import common.AppiumServerJava;
import common.driver.DriverFactory;
import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import pages.desktopPages.DesktopLoginPage;
import pages.webPages.*;

import pages.webPages.phonebookPages.UserListingPage;

public class BaseTest {
    protected LoginPage loginPage;
    protected DashboardPage dashboardPage;
    protected DesktopLoginPage desktopLoginPage;
    protected ReleaseNotesPage releaseNotesPage;
    protected UsersPage usersPage;
    protected AddUsersPage addUsersPage;
    protected VoicemailPage voicemailPage;
    protected UserListingPage userListingPage;

    public static WebDriver driver;
    public static WindowsDriver desktop_driver;

    @BeforeMethod
    public void setupTestRun() {
        driver = new DriverFactory().getDriver();
        initPages();
    }

    @AfterMethod
    public void logoutAfterTest() {
        if (!loginPage.isLogInButtonDisplayed())
            dashboardPage.logout();


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

    private void initPages(){
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        releaseNotesPage = new ReleaseNotesPage(driver);
        usersPage = new UsersPage(driver);
        addUsersPage = new AddUsersPage(driver);
        voicemailPage = new VoicemailPage(driver);
        userListingPage = new UserListingPage(driver);
    }

    private void initDesktopPages(){
        desktopLoginPage = new DesktopLoginPage(desktop_driver);
    }

}
