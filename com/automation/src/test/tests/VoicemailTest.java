package tests;

import common.Config;
import common.dataObjects.VoicemailDataObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VoicemailTest extends BaseTest {
    @BeforeMethod
    private void loginBeforeTest() {
        driver.get(Config.BASE_URL);
        Assert.assertTrue(loginPage.pageIsDisplayed());
        loginPage.makeLogin(Config.BASE_USERNAME, Config.BASE_PASSWORD);
        dashboardPage.pageIsDisplayed();
        createNewVoicemail();
    }

    @Test(description = "SQE-2 Voicemail tab - Mark as Read")
    public void voicemailTabMarkAsRead() {
        dashboardPage.switchToVoiceMailTab();
        Assert.assertTrue(inboxPage.pageIsDisplayed(), "Inbox tab is opened");
        inboxPage.openUnreadSection();
        VoicemailDataObject expectedDataObject = inboxPage.getValuesFromTable();
        inboxPage.openFirstVoicemailInTable();
        VoicemailDataObject actualDataObject = inboxPage.getValuesFromModal();
        Assert.assertTrue(actualDataObject.isVoicemailDataSame(expectedDataObject), "Voicemail Data are the same");
        inboxPage.playVoicemail();
        Assert.assertTrue(inboxPage.isVoicemailFolderDisappearAfterClick(), "Voicemail should be marked in lists as Read");
        inboxPage.clickToCloseButton();
        Assert.assertTrue(inboxPage.isVoicemailDisappearFromTheTable(expectedDataObject.Date), "VM should be removed from the unread list.");
    }

    //TODO: issue with drop-down menu
    @Test(description = "SQE-13 Voicemail tab - Change Folder")
    public void voicemailTabChangeFolder() {
        dashboardPage.switchToVoiceMailTab();
        Assert.assertTrue(inboxPage.pageIsDisplayed(), "Inbox tab is opened");
        inboxPage.openUnreadSection();
        VoicemailDataObject expectedDataObject = inboxPage.getValuesFromTable();
        inboxPage.openFirstVoicemailInTable();
        VoicemailDataObject actualDataObject = inboxPage.getValuesFromModal();
        Assert.assertTrue(actualDataObject.isVoicemailDataSame(expectedDataObject), "Voicemail Data are the same");
        inboxPage.clickToChangeFolderButton();
        Assert.assertTrue(inboxPage.isMenuItemsDisplayed(), "Menus are the sames");
        inboxPage.clickToReadButton();
        inboxPage.clickToCloseButton();
        inboxPage.openReadSection();
    }

    @Test(description = "SQE-16 Voicemail tab - Download Voicemail")
    public void voicemailTabDownloadVoicemail() {
        dashboardPage.switchToVoiceMailTab();
        Assert.assertTrue(inboxPage.pageIsDisplayed(), "Inbox tab is opened");
        inboxPage.openUnreadSection();
        VoicemailDataObject expectedDataObject = inboxPage.getValuesFromTable();
        inboxPage.openFirstVoicemailInTable();
        VoicemailDataObject actualDataObject = inboxPage.getValuesFromModal();
        Assert.assertTrue(actualDataObject.isVoicemailDataSame(expectedDataObject), "Voicemail Data are the same");
        Assert.assertTrue(inboxPage.downloadVoicemail(), "Voicemail should be download with mp3 format");
    }

    @Test(description = "SQE-30 Voicemail tab - Delete Single Voicemail")
    public void voicemailTabDeleteSingleVoicemail() {

        dashboardPage.switchToVoiceMailTab();
        Assert.assertTrue(inboxPage.pageIsDisplayed(), "Inbox tab is opened");
        inboxPage.openReadSection();
        VoicemailDataObject expectedDataObject = inboxPage.getValuesFromTable();
        inboxPage.openFirstVoicemailInTable();
        VoicemailDataObject actualDataObject = inboxPage.getValuesFromModal();
        Assert.assertTrue(actualDataObject.isVoicemailDataSame(expectedDataObject), "Voicemail Data are the same");
    }

    private void createNewVoicemail() {
        switchToDesktop();
        desktopLoginPage.makeLogin(Config.ANOTHER_USERNAME_FOR_BOLT, Config.ANOTHER_PASSWORD_BOLT_BOLT);
        desktopDashboardPage.makeCallToUser("1000");
    }
}
