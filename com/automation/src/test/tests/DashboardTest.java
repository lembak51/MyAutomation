package tests;


import common.Config;
import common.dataObjects.DashboardDataObject;
import common.dataObjects.UserDataObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest {

    @Test(description = "SQE-673 Dashboard - Release note in new page")
    public void releaseNoteInNewPage(){
        driver.get(Config.BASE_URL);
        Assert.assertTrue(loginPage.pageIsDisplayed(), "Login Page should be displayed ");
        loginPage.makeLogin(Config.BASE_USERNAME, Config.BASE_PASSWORD);//Replace step 2-4
        Assert.assertTrue(dashboardPage.pageIsDisplayed(), "Dashboard Page should be displayed ");
        dashboardPage.clickReleaseNote();
        Assert.assertTrue(releaseNotesPage.getReleaseHeaderText(), "Release Notes page should be displayed");
    }

    @Test(description = "Dashboard - change password: login with new password")
    public void changePasswordLoginWithNewPassword(){
        UserDataObject userDataObject = new UserDataObject();
        DashboardDataObject dashboardDataObject = new DashboardDataObject();
        String expectedText = "You have succesfully changed your password";
        driver.get(Config.BASE_URL);
        Assert.assertTrue(loginPage.pageIsDisplayed(), "Login Page should be displayed ");
        loginPage.makeLogin(Config.BASE_USERNAME, Config.BASE_PASSWORD);//Replace step 2-4
        Assert.assertTrue(dashboardPage.pageIsDisplayed(), "Dashboard Page should be displayed ");
        dashboardPage.openUserTab();
        Assert.assertTrue(usersPage.pageIsDisplayed(), "User page should be displayed");
        usersPage.clickAddUserBtn();
        Assert.assertTrue(addUsersPage.pageIsDisplayed(), "Add Users Page should be displayed");
        addUsersPage.createNewUser(userDataObject, dashboardDataObject);
        dashboardPage.logout();
        Assert.assertTrue(loginPage.pageIsDisplayed(), "Login Page should be displayed ");
        loginPage.makeLogin(userDataObject.UserEmail, dashboardDataObject.NewPassword);//Replace step 2-4
        dashboardPage.clickAgreeTermOfUseBtn();
        Assert.assertTrue(dashboardPage.pageIsDisplayed(), "Dashboard Page should be displayed ");
        dashboardPage.changePassword(dashboardDataObject.NewPassword, dashboardDataObject.NewPassword, dashboardDataObject.ConfirmPassword);
        Assert.assertTrue(dashboardPage.alertWithExpectedText(expectedText), "Alert with text expected text should present");
        dashboardPage.acceptAlert();
        dashboardPage.logout();
        Assert.assertTrue(loginPage.pageIsDisplayed(), "Login Page should be displayed ");
        loginPage.makeLogin(userDataObject.UserEmail, dashboardDataObject.NewPassword);
        Assert.assertTrue(dashboardPage.pageIsDisplayed(), "Dashboard Page should be displayed ");
    }

    @Test(description = "SQE-110 Dashboard - My Mobile with incorrect values")
    public void myMobileWithIncorrectValues(){
        DashboardDataObject dashboardDataObject = new DashboardDataObject();
        String expectedText = "Error: Invalid mobile phone number length (please use 10 digit)";
        driver.get(Config.BASE_URL);
        Assert.assertTrue(loginPage.pageIsDisplayed(), "Login Page should be displayed ");
        loginPage.makeLogin(Config.BASE_USERNAME, Config.BASE_PASSWORD);//Replace step 2-4
        Assert.assertTrue(dashboardPage.pageIsDisplayed(), "Dashboard Page should be displayed ");
        dashboardPage.changeMyMobileNumberWithIncorrectValues(dashboardDataObject.NineDigitsMobileNumber);
        Assert.assertTrue(dashboardPage.alertWithExpectedText(expectedText), "Alert with text expected text should present");
        dashboardPage.acceptAlert();
        Assert.assertTrue(dashboardPage.pageIsDisplayed(), "Dashboard Page should be displayed ");
        dashboardPage.changeMyMobileNumberWithIncorrectValues(dashboardDataObject.ElevenDigitsMobileNumber);
        Assert.assertTrue(dashboardPage.alertWithExpectedText(expectedText), "Alert with text expected text should present");
        dashboardPage.acceptAlert();
        Assert.assertTrue(dashboardPage.pageIsDisplayed(), "Dashboard Page should be displayed ");
    }
    @Test(description = "SQE- 109 Dashboard - Check Voicemail Pin  in Voicemail page")
    public void checkVoicemailPinInVoicemailPage(){
        driver.get(Config.BASE_URL);
        Assert.assertTrue(loginPage.pageIsDisplayed(), "Login Page should be displayed ");
        loginPage.makeLogin(Config.BASE_USERNAME, Config.BASE_PASSWORD);//Replace step 2-4
        Assert.assertTrue(dashboardPage.pageIsDisplayed(), "Dashboard Page should be displayed ");

    }


}
