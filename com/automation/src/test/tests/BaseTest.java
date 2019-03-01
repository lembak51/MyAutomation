package tests;

import common.AppiumServer;
import common.CommandLineHelper;
import common.driver.DriverFactory;
import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.desktopPages.DesktopDashboardPage;
import pages.desktopPages.DesktopLoginPage;

import pages.webPages.*;

import pages.webPages.phonebookPages.UserListingPage;
import pages.webPages.voicemailPages.InboxPage;
import pages.webPages.voicemailPages.VoicemailConfigurationPage;

public class BaseTest {
    protected LoginPage loginPage;
    protected DashboardPage dashboardPage;
    protected ReleaseNotesPage releaseNotesPage;
    protected UsersPage usersPage;
    protected AddUsersPage addUsersPage;
    protected VoicemailConfigurationPage voicemailConfigurationPage;
    protected UserListingPage userListingPage;
    protected DesktopLoginPage desktopLoginPage;
    protected DesktopDashboardPage desktopDashboardPage;
    protected InboxPage inboxPage;

    public WebDriver driver;
    public WindowsDriver desktop_driver;


    @BeforeMethod
    public void setupTestRun(){
        driver = new DriverFactory().getDriver();
        initPages();
    }

    @AfterMethod
    public void logoutAfterTest(){
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

    protected void switchToDesktop(){
        new AppiumServer().startServer();
        desktop_driver = new DriverFactory().getInstance();
        initDesktopPages();
    }

    private void initPages(){
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        releaseNotesPage = new ReleaseNotesPage(driver);
        usersPage = new UsersPage(driver);
        addUsersPage = new AddUsersPage(driver);
        voicemailConfigurationPage = new VoicemailConfigurationPage(driver);
        userListingPage = new UserListingPage(driver);
        inboxPage = new InboxPage(driver);
    }

    private void initDesktopPages(){
        desktopLoginPage = new DesktopLoginPage(desktop_driver);
        desktopDashboardPage = new DesktopDashboardPage(desktop_driver);
    }
}
