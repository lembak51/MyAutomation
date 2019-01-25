package tests;


import common.Config;
import common.driver.DriverFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class LoginTest extends BaseTest {

    @Test(description = "SQE-292 Log in (without Remember Me option")
    public void logiInWithoutRememberME(){
        driver.get(Config.BASE_URL);
        Assert.assertTrue(loginPage.pageIsDisplayed());
        loginPage.makeLogin(Config.BASE_USERNAME, Config.BASE_PASSWORD);
        switchToDesktopDriver();
        desktopLoginPage.clickToSignInButton();
    }
}
