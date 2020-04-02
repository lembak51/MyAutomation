package tests;

import common.AppiumServer;
import common.CommandLineHelper;
import common.Config;
import common.driver.DriverFactory;
import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.desktopPages.DesktopDashboardPage;
import pages.desktopPages.DesktopLoginPage;
import pages.webPages.*;


public class BaseTest {
    protected LoginPage loginPage;
    protected DashboardPage dashboardPage;
    protected CoachesPage coachesPage;
    protected CreateCoachesPage createCoachesPage;
    protected SchoolListPage schoolListPage;
    protected CreateSchoolPage createSchoolPage;
    protected UsersPage usersPage;
    protected CreateNewUsersPage createNewUsersPage;
    protected FanPage fanPage;
    protected CreateNewFanPage createNewFanPage;
    protected CreateNewStateUsers createNewStateUsers;
    protected StateUsersPage stateUsersPage;
    protected CoacheVote coacheVote;
    protected CreateNewCoacheVote createNewCoacheVote;


    public WebDriver driver;


    @BeforeMethod
    public void setupTestRun() {
        driver = new DriverFactory().getDriver();
        initPages();
    }
//@AfterMethod
//public void tearDown(){
//    driver.close();
//    driver.quit();
//
// }

  /*(  @AfterMethod
    public void logoutAfterTest(){
        try {
            if (!loginPage.isLogInButtonDisplayed())
                dashboardPage.logout();
        } catch (WebDriverException ignored) {
        } finally {
            if (driver != null) {
                driver.quit();
                driver = null;
            }

        }
    }
*/


    private void initPages(){
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        coachesPage = new CoachesPage(driver);
        createCoachesPage = new CreateCoachesPage(driver);
        schoolListPage = new SchoolListPage(driver);
        createSchoolPage = new CreateSchoolPage(driver);
        usersPage = new UsersPage(driver);
        createNewUsersPage = new CreateNewUsersPage(driver);
        fanPage = new FanPage(driver);
        createNewFanPage = new CreateNewFanPage(driver);
        createNewStateUsers = new CreateNewStateUsers(driver);
        stateUsersPage = new StateUsersPage(driver);
        coacheVote = new CoacheVote(driver);
        createNewCoacheVote = new CreateNewCoacheVote(driver);

    }



    protected void loginBeforeTest(){
        driver.get(Config.BASE_URL);
        Assert.assertTrue(loginPage.pageIsDisplayed());
        loginPage.makeLogin(Config.BASE_USERNAME, Config.BASE_PASSWORD);
        dashboardPage.pageIsDisplayed();

    }


}
