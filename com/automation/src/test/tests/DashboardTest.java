package tests;


import common.Config;
import common.dataObjects.DashboardDataObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest {

    @Test(description = "SQE-673 Dashboard - Release note in new page")
    public void releaseNoteInNewPage() {
        driver.get(Config.BASE_URL);
        Assert.assertTrue(loginPage.pageIsDisplayed(), "Login Page should be displayed ");
        loginPage.makeLogin(Config.BASE_USERNAME, Config.BASE_PASSWORD);//Replace step 2-4
        Assert.assertTrue(dashboardPage.pageIsDisplayed(), "Dashboard Page should be displayed ");
        dashboardPage.clickReleaseNote();
        Assert.assertTrue(releaseNotesPage.getReleaseHeaderText(), "Release Notes page should be displayed");
    }

    @Test(description = "SQE --- Change password")
    public void changePassword() {
        DashboardDataObject dashboardDataObject = new DashboardDataObject();
        String expectedText = "You have succesfully changed your password";
        driver.get(Config.BASE_URL);
        Assert.assertTrue(loginPage.pageIsDisplayed(), "Login Page should be displayed ");
        loginPage.makeLogin(Config.BASE_USERNAME, Config.BASE_PASSWORD);//Replace step 2-4
        Assert.assertTrue(dashboardPage.pageIsDisplayed(), "Dashboard Page should be displayed ");
        dashboardPage.changePassword(Config.BASE_PASSWORD, dashboardDataObject.NewPassword, dashboardDataObject.NewPassword);
        Assert.assertTrue(dashboardPage.alertWithExpectedText(expectedText), "Alert with text expected text should present");
        dashboardPage.acceptAlert();
        dashboardPage.logout();
        dashboardPage.waitUntilPageLoad();
        Assert.assertTrue(loginPage.pageIsDisplayed(), "Login Page should be displayed ");
        loginPage.makeLogin(Config.BASE_USERNAME, dashboardDataObject.NewPassword);
        Assert.assertTrue(dashboardPage.pageIsDisplayed(), "Dashboard Page should be displayed ");
    }

    @Test(description = "SQE-110 Dashboard - My Mobile with incorrect values")
    public void myMobileWithIncorrectValues() {
        DashboardDataObject dashboardDataObject = new DashboardDataObject();
        String expectedText = "Error: Invalid mobile phone number length (please use 10 digit)";
        driver.get(Config.BASE_URL);
        Assert.assertTrue(loginPage.pageIsDisplayed(), "Login Page should be displayed ");
        loginPage.makeLogin(Config.BASE_USERNAME, Config.BASE_PASSWORD);//Replace step 2-4
        Assert.assertTrue(dashboardPage.pageIsDisplayed(), "Dashboard Page should be displayed ");
        dashboardPage.changeMyMobileNumberWithIncorrectValues(dashboardDataObject.IncorrectMobileDigits9);
        Assert.assertTrue(dashboardPage.alertWithExpectedText(expectedText), "Alert with text expected text should present");
        dashboardPage.acceptAlert();
        Assert.assertTrue(dashboardPage.pageIsDisplayed(), "Dashboard Page should be displayed ");
        dashboardPage.changeMyMobileNumberWithIncorrectValues(dashboardDataObject.IncorrectMobileDigits11);
        Assert.assertTrue(dashboardPage.alertWithExpectedText(expectedText), "Alert with text expected text should present");
        dashboardPage.acceptAlert();
        Assert.assertTrue(dashboardPage.pageIsDisplayed(), "Dashboard Page should be displayed ");
    }

}
