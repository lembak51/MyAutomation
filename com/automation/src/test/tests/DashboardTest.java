package tests;


import common.Config;
import common.dataObjects.UserDataObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest {
    @BeforeMethod
    public void loginBeforeTest(){
        driver.get(Config.BASE_URL);
        Assert.assertTrue(loginPage.pageIsDisplayed());
        loginPage.makeLogin(Config.BASE_USERNAME, Config.BASE_PASSWORD);
        dashboardPage.pageIsDisplayed();
    }

    @Test(description = "SQE-673 Dashboard - Release note in new page")
    public void releaseNoteInNewPage(){
        dashboardPage.clickReleaseNote();
        Assert.assertTrue(releaseNotesPage.getReleaseHeaderText(), "Release Notes page should be displayed");
    }

    @Test(description = "SQE-113 Dashboard - change password: login with new password")
    public void changePasswordLoginWithNewPassword(){
        UserDataObject userDataObject = new UserDataObject();
        String expectedText = "You have succesfully changed your password";
        dashboardPage.openUserTab();
        Assert.assertTrue(usersPage.pageIsDisplayed(), "User page should be displayed");
        usersPage.clickAddUserBtn();
        Assert.assertTrue(addUsersPage.pageIsDisplayed(), "Add Users Page should be displayed");
        addUsersPage.createNewUser(userDataObject);
        dashboardPage.logout();
        Assert.assertTrue(loginPage.pageIsDisplayed(), "Login Page should be displayed ");
        loginPage.makeLogin(userDataObject.UserEmail, userDataObject.NewPassword);//Replace step 2-4 login test
        dashboardPage.clickAgreeTermOfUseBtn();
        Assert.assertTrue(dashboardPage.pageIsDisplayed(), "Dashboard Page should be displayed ");
        dashboardPage.changePassword(userDataObject.NewPassword, userDataObject.NewPassword, userDataObject.ConfirmPassword);
        Assert.assertTrue(dashboardPage.isAlertTextAsExpected(expectedText), "Alert with text expected text should present");
        dashboardPage.acceptAlert();
        dashboardPage.logout();
        Assert.assertTrue(loginPage.pageIsDisplayed(), "Login Page should be displayed ");
        loginPage.makeLogin(userDataObject.UserEmail, userDataObject.NewPassword);//Replace step 2-4 login test
        Assert.assertTrue(dashboardPage.pageIsDisplayed(), "Dashboard Page should be displayed ");
    }

    @Test(description = "SQE-110 Dashboard - My Mobile with incorrect values")
    public void myMobileWithIncorrectValues(){
        UserDataObject userDataObject = new UserDataObject();
        String expectedText = "Error: Invalid mobile phone number length (please use 10 digit)";
        dashboardPage.changeMyMobileNumberWithIncorrectValues(userDataObject.NineDigitsMobileNumber);
        Assert.assertTrue(dashboardPage.isAlertTextAsExpected(expectedText), "Alert with text expected text should present");
        dashboardPage.acceptAlert();
        Assert.assertTrue(dashboardPage.pageIsDisplayed(), "Dashboard Page should be displayed ");
        dashboardPage.changeMyMobileNumberWithIncorrectValues(userDataObject.ElevenDigitsMobileNumber);
        Assert.assertTrue(dashboardPage.isAlertTextAsExpected(expectedText), "Alert with text expected text should present");
        dashboardPage.acceptAlert();
        Assert.assertTrue(dashboardPage.pageIsDisplayed(), "Dashboard Page should be displayed ");
    }

    //TODO Bug, in attribute does not change voicemail pin number. But in field pin number is changed
    @Test(description = "SQE- 109 Dashboard - Check Voicemail Pin  in Voicemail page")
    public void checkVoicemailPinInVoicemailPage(){
        UserDataObject userDataObject = new UserDataObject();
        dashboardPage.changeVoiceMailPin(userDataObject.VoicemailPinNumber);//Replace step 2-4
        Assert.assertTrue(dashboardPage.getVoiceMailPinOnDashboard(userDataObject.VoicemailPinNumber), "Voicemail Pin displayed in field with numbers from step 3");
        dashboardPage.switchToVoiceMailTab();
        Assert.assertTrue(inboxPage.pageIsDisplayed(),"Inbox page is displayed");
        inboxPage.openVoicemailConfigurationPage();
        Assert.assertTrue(voicemailConfigurationPage.pageIsDisplayed(),"Voicemail Configuration page is opened");
        Assert.assertTrue(voicemailConfigurationPage.getVoicemailPin(userDataObject.VoicemailPinNumber), "Voicemail Pin displayed with numbers from step 3");//Replace step 6-7
    }

    @Test(description = "SQE-108 Dashboard - change password: new password without letters")
    public void changePasswordNewPasswordWithoutLetters(){
        UserDataObject userDataObject = new UserDataObject().getPasswordWithLetters();
        String expectedText = "Error: Password must include at least one letter!";
        dashboardPage.changePassword(Config.BASE_PASSWORD, userDataObject.NewPassword, userDataObject.ConfirmPassword);
        Assert.assertTrue(dashboardPage.isAlertTextAsExpected(expectedText), "Alert with text expected text should present");
        dashboardPage.acceptAlert();
        dashboardPage.clickCancelBtn();
        Assert.assertTrue(dashboardPage.pageIsDisplayed(), "Dashboard page should be displayed");
    }

    @Test(description = "SQE-106 Dashboard  - change password: new password without numbers")
    public void changePasswordNewPasswordWithoutNumbers(){
        UserDataObject userDataObject = new UserDataObject().getPasswordWithNumber();
        String expectedText = "Error: Password must include at least one number!";
        dashboardPage.changePassword(Config.BASE_PASSWORD, userDataObject.NewPassword, userDataObject.ConfirmPassword);
        Assert.assertTrue(dashboardPage.isAlertTextAsExpected(expectedText), "Alert with text expected text should present");
        dashboardPage.acceptAlert();
        dashboardPage.clickCancelBtn();
        Assert.assertTrue(dashboardPage.pageIsDisplayed(), "Dashboard page should be displayed");
    }

    @Test(description = "SQE-105 Dashboard  - change password: passwords are not the same")
    public void changePasswordAreNotTheSame(){
        UserDataObject userDataObject = new UserDataObject().getPasswordWithNumber();
        UserDataObject userDataObjectForNewPassword = new UserDataObject().getPasswordWithLetters();
        String expectedText = "New Password and Confirm Password must be the same.";
        dashboardPage.changePassword(Config.BASE_PASSWORD, userDataObject.NewPassword, userDataObjectForNewPassword.NewPassword);
        Assert.assertTrue(dashboardPage.isAlertTextAsExpected(expectedText), "Alert with text expected text should present");
        dashboardPage.acceptAlert();
        dashboardPage.clickCancelBtn();
        Assert.assertTrue(dashboardPage.pageIsDisplayed(), "Dashboard page should be displayed");
    }

    @Test(description = "SQE-104 Dashboard - change password: wrong old password")
    public void changePasswordWrongOldPassword(){
        UserDataObject userDataObject = new UserDataObject();
        String expectedText = "Old password must match your current password";
        dashboardPage.changePassword(userDataObject.NewPassword, userDataObject.NewPassword, userDataObject.ConfirmPassword);
        Assert.assertTrue(dashboardPage.isAlertTextAsExpected(expectedText), "Alert with text expected text should present");
        dashboardPage.acceptAlert();
        dashboardPage.clickCancelBtn();
        Assert.assertTrue(dashboardPage.pageIsDisplayed(), "Dashboard page should be displayed");
    }

    @Test(description = "SQE-101 Dashboard - Change Voicemail Pin")
    public void changeVoicemailPin(){
        UserDataObject userDataObject = new UserDataObject();
        UserDataObject userDataObjectForNewVoicEmail = new UserDataObject();
        dashboardPage.changeVoiceMailPin(userDataObject.VoicemailPinNumber);//Replace step 2-4
        Assert.assertTrue(dashboardPage.getVoiceMailPinOnDashboard(userDataObject.VoicemailPinNumber), "Voicemail Pin displayed in field with numbers from step 3");
        dashboardPage.clickHidePinBtn();
        Assert.assertTrue(dashboardPage.getHideStatusVMPin("(Hidden)"));
        dashboardPage.changeVoicemailPinWithoutSave(userDataObjectForNewVoicEmail.VoicemailPinNumber);
        Assert.assertTrue(dashboardPage.getVoiceMailPinOnDashboard(userDataObject.VoicemailPinNumber), "Voicemail Pin displayed in field with numbers from step 3");
    }

    //TODO add method of the screenshoot comparator
    @Test(description = "SQE-107 Dashboard - Change Profile Picture without Upload button")
    public void changeProfilePictureWithoutUploadButton(){
        dashboardPage.uploadProfilePicture();
    }
}
