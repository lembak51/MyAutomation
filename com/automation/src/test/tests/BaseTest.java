package tests;

import common.AppiumServer;
import common.CommandLineHelper;
import common.driver.DriverFactory;
import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.webPages.*;

import pages.webPages.phonebookPages.UserListingPage;

public class BaseTest {
    protected LoginPage loginPage;
    protected DashboardPage dashboardPage;
    protected ReleaseNotesPage releaseNotesPage;
    protected UsersPage usersPage;
    protected AddUsersPage addUsersPage;
    protected VoicemailPage voicemailPage;
    protected UserListingPage userListingPage;
    private String windowTitle;
    public static WebDriver driver;
    public static WindowsDriver desktop_driver;

    @BeforeMethod
    public void setupTestRun() {
        driver = new DriverFactory().getDriver();
        initPages();
    }

    @AfterMethod
    public void logoutAfterTest() {
        try {
            if (!loginPage.isLogInButtonDisplayed())
                dashboardPage.logout();
        } finally {
            if (driver != null) {
                driver.quit();
                driver = null;
            }
            if (desktop_driver != null) {
                new CommandLineHelper().killProcessBolt();
                desktop_driver = null;
                new AppiumServer().stopServer();
            }
        }
    }

    protected void switchToDesktop() {
        new AppiumServer().startServer();
        desktop_driver = new DriverFactory().getInstance();
        initDesktopPages();
    }

    private void initPages() {
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        releaseNotesPage = new ReleaseNotesPage(driver);
        usersPage = new UsersPage(driver);
        addUsersPage = new AddUsersPage(driver);
        voicemailPage = new VoicemailPage(driver);
        userListingPage = new UserListingPage(driver);
    }

    private void initDesktopPages() {
    }

}
