package tests;


import common.Config;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(description = "SQE-292 Log in (without Remember Me option", priority = 1)
    public void logInWithoutRememberME(){
        driver.get(Config.BASE_URL);
        Assert.assertTrue(loginPage.pageIsDisplayed(), "Login Page should be displayed ");
        loginPage.makeLogin(Config.BASE_USERNAME, Config.BASE_PASSWORD);//Replace step 2-4
        Assert.assertTrue(dashboardPage.pageIsDisplayed(), "Dashboard Page should be displayed ");
    }

    @Test(description = "SQE-298 Log in, (Empty fields)", priority = 2)
    public void loginEmptyFields(){
        driver.get(Config.BASE_URL);
        Assert.assertTrue(loginPage.pageIsDisplayed(), "Login Page should be displayed ");
        loginPage.loginWithEmptyField();
        Assert.assertTrue(loginPage.alertText(), "Alert should be present with text");
        loginPage.acceptAlert();
        Assert.assertTrue(loginPage.pageIsDisplayed(),"Login page should be displayed");
    }

    @Test(description = "SQE-297 Log in (incorrect email)", priority = 3)
    public void logInIncorrectEmail(){
        driver.get(Config.BASE_URL);
        Assert.assertTrue(loginPage.pageIsDisplayed(), "Login Page should be displayed ");
        loginPage.makeLogin(Config.INCORRECT_USERNAME, Config.BASE_PASSWORD);//Replace step
        Assert.assertTrue(loginPage.alertText(), "Alert should be present with text");
        loginPage.acceptAlert();
        Assert.assertTrue(loginPage.pageIsDisplayed(), "Login page should be displayed");
    }

    @Test(description = "SQE-296 Log in (incorrect password)", priority = 4)
    public void logInIncorrectPassword(){
        driver.get(Config.BASE_URL);
        Assert.assertTrue(loginPage.pageIsDisplayed());
        loginPage.makeLogin(Config.BASE_USERNAME, Config.INCORRECT_PASSWORD);//Replace step
        Assert.assertTrue(loginPage.alertText(), "Alert should be present with text");
        loginPage.acceptAlert();
        Assert.assertTrue(loginPage.pageIsDisplayed(), "Login page should be displayed");
    }

    @Test(description = "SQE-293 Log in (via Remember Me option", priority = 5)
    public void logInViaRememberME(){
        driver.get(Config.BASE_URL);
        Assert.assertTrue(loginPage.pageIsDisplayed(), "Login Page should be displayed ");
        loginPage.makeLoginWithRememberME(Config.BASE_USERNAME, Config.BASE_PASSWORD);//Replace step 2-5
        Assert.assertTrue(dashboardPage.pageIsDisplayed(), "Dashboard Page should be displayed ");
        dashboardPage.logout();
        Assert.assertEquals(Config.BASE_USERNAME, loginPage.getTextFromEmailField(), "Email field contains the credential of the previous user who was logged in");

    }
}