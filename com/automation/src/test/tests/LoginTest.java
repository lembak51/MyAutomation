package tests;


import common.Config;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    private String alertErrorText = "Error: Email / Password Combination is not correct!";

    @Test(description = "SQE-292 Log in (without Remember Me option")
    public void logInWithoutRememberME(){
        driver.get(Config.BASE_URL);
        Assert.assertTrue(loginPage.pageIsDisplayed(), "Login Page should be displayed ");
        loginPage.makeLogin(Config.BASE_USERNAME, Config.BASE_PASSWORD);//Replace step 2-4
        Assert.assertTrue(dashboardPage.pageIsDisplayed(), "Dashboard Page should be displayed ");
    }

    @Test(description = "SQE-298 Log in, (Empty fields)")
    public void loginEmptyFields(){
        driver.get(Config.BASE_URL);
        Assert.assertTrue(loginPage.pageIsDisplayed(), "Login Page should be displayed ");
        loginPage.loginWithEmptyField();
        Assert.assertTrue(loginPage.isAlertTextAsExpected(alertErrorText), "Alert should be present with text");
        loginPage.acceptAlert();
        Assert.assertTrue(loginPage.pageIsDisplayed(),"Login page should be displayed");
    }

    @Test(description = "SQE-297 Log in (incorrect email)")
    public void logInIncorrectEmail(){
        driver.get(Config.BASE_URL);
        Assert.assertTrue(loginPage.pageIsDisplayed(), "Login Page should be displayed ");
        loginPage.makeLogin(Config.INCORRECT_USERNAME, Config.BASE_PASSWORD);//Replace step
        Assert.assertTrue(loginPage.isAlertTextAsExpected(alertErrorText), "Alert should be present with text");
        loginPage.acceptAlert();
        Assert.assertTrue(loginPage.pageIsDisplayed(), "Login page should be displayed");
    }

    @Test(description = "SQE-296 Log in (incorrect password)")
    public void logInIncorrectPassword(){
        driver.get(Config.BASE_URL);
        Assert.assertTrue(loginPage.pageIsDisplayed());
        loginPage.makeLogin(Config.BASE_USERNAME, Config.INCORRECT_PASSWORD);//Replace step
        Assert.assertTrue(loginPage.isAlertTextAsExpected(alertErrorText), "Alert should be present with text");
        loginPage.acceptAlert();
        Assert.assertTrue(loginPage.pageIsDisplayed(), "Login page should be displayed");
    }

    @Test(description = "SQE-293 Log in (via Remember Me option")
    public void logInViaRememberME(){
        driver.get(Config.BASE_URL);
        Assert.assertTrue(loginPage.pageIsDisplayed(), "Login Page should be displayed ");
        loginPage.makeLoginWithRememberME(Config.BASE_USERNAME, Config.BASE_PASSWORD);//Replace step 2-5
        Assert.assertTrue(dashboardPage.pageIsDisplayed(), "Dashboard Page should be displayed ");
        dashboardPage.logout();
        Assert.assertEquals(Config.BASE_USERNAME, loginPage.getTextFromEmailField(), "Email field should be contains the credential of the previous user who was logged in");

    }
}