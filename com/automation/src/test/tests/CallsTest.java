package tests;


import common.Config;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CallsTest extends BaseTest {
    @BeforeMethod
    public void loginBeforeTest(){
        driver.get(Config.BASE_URL);
        Assert.assertTrue(loginPage.pageIsDisplayed());
        loginPage.makeLogin(Config.BASE_USERNAME, Config.BASE_PASSWORD);
        dashboardPage.pageIsDisplayed();
    }
    @Test
    public void makeCall (){
        switchToDesktop();
        desktopLoginPage.makeLogin(Config.BASE_USERNAME_FOR_BOLT, Config.BASE_PASSWORD_FOR_BOLT);
        desktopDashboardPage.makeCallToUser("1001");
    }


    public void callsTabUsersSearch(){

    }
}
