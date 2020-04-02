package tests;


import common.Config;
import common.dataObjects.UserDataObject;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    private String alertErrorText = "Invalid username or password. Please try again.";

    @Test(description = "C91052 Log with valid credential", priority = 0)
    public void logInWithoutRememberME(){
        driver.get(Config.BASE_URL);
        Assert.assertTrue(loginPage.pageIsDisplayed(), "Login Page should be displayed ");
        loginPage.makeLogin(Config.BASE_USERNAME, Config.BASE_PASSWORD);//Replace step 2-4
        Assert.assertTrue(dashboardPage.pageIsDisplayed());
    }
    //INCORRECT_USERNAME
   // @Test(description = "C91018 Log in with invalid username")
    // public void loginWithInvalidUsername(){
    //      driver.get(Config.BASE_URL);
    //     Assert.assertTrue(loginPage.pageIsDisplayed(), "Login Page should be displayed ");
    //    loginPage.makeLogin(Config.INCORRECT_USERNAME, Config.BASE_PASSWORD);//Replace step 2-4
    //     Assert.assertTrue(loginPage.alertInvalidCredential());
    //  }

    @Test(description = "SQE-297 Log in (incorrect username)", priority = 1)
    public void logInIncorrectUserName(){
        driver.get(Config.BASE_URL);
        loginPage.makeLogin(Config.INCORRECT_USERNAME, Config.BASE_PASSWORD);//Replace step
        Assert.assertTrue(loginPage.isErrormMesegWhenLogin(alertErrorText), "Alert should be present with text");
        Assert.assertTrue(loginPage.pageIsDisplayed(), "Login page should be displayed");
    }

    @Test(description = "SQE-296 Log in (incorrect password)", priority = 2)
    public void logInIncorrectPassword(){
        driver.get(Config.BASE_URL);
        loginPage.makeLogin(Config.BASE_USERNAME, Config.INCORRECT_PASSWORD );//Replace step
        Assert.assertTrue(loginPage.isErrormMesegWhenLogin(alertErrorText), "Alert should be present with text");
        Assert.assertTrue(loginPage.pageIsDisplayed(), "Login page should be displayed");

    }
    @Test(description = "C91052 Log with - Log out", priority = 3)
    public void logInLogout(){
        driver.get(Config.BASE_URL);
        Assert.assertTrue(loginPage.pageIsDisplayed(), "Login Page should be displayed ");
        loginPage.makeLogin(Config.BASE_USERNAME, Config.BASE_PASSWORD);//Replace step 2-4
        Assert.assertTrue(dashboardPage.pageIsDisplayed());
        dashboardPage.logout();
        Assert.assertTrue(loginPage.pageIsDisplayed());
    }

}