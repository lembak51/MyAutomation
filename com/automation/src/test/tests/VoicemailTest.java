package tests;

import common.Config;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VoicemailTest extends BaseTest {
    @BeforeMethod
    private void loginBeforeTest(){
        driver.get(Config.BASE_URL);
        Assert.assertTrue(loginPage.pageIsDisplayed());
        loginPage.makeLogin(Config.BASE_USERNAME, Config.BASE_PASSWORD);
        dashboardPage.pageIsDisplayed();
        createNewVoicemail();
    }

    @Test(description = "SQE-2 Voicemail tab - Mark as Read")
    public void voicemailTabMarkAsRead(){
        dashboardPage.switchToVoiceMailTab();
        Assert.assertTrue(inboxPage.pageIsDisplayed()," Inbox tab is opened");
        inboxPage.clickToUnreadButton();
    }

    @Test(description = "SQE-13 Voicemail tab - Change Folder")
    public void voicemailTabChangeFolder(){
    }

    @Test(description = "SQE-16 Voicemail tab - Download Voicemail")
    public void voicemailTabDownloadVoicemail(){
    }

    @Test(description = "SQE-30 Voicemail tab - Delete Single Voicemail")
    public void voicemailTabDeleteSingleVoicemail(){
    }

    private void createNewVoicemail(){
        switchToDesktop();
        desktopLoginPage.makeLogin(Config.ANOTHER_USERNAME_FOR_BOLT, Config.ANOTHER_PASSWORD_BOLT_BOLT);
        desktopDashboardPage.makeCallToUser("1000");
    }
}
