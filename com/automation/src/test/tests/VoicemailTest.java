package tests;

import common.Config;
import common.dataObjects.VoicemailDataObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VoicemailTest extends BaseTest {
    private String numberForLeaveVoicemail = "1000";

    @BeforeMethod
    private void createNewVoicemail() {
        switchToDesktop();
        desktopLoginPage.makeLogin(Config.ANOTHER_USERNAME_FOR_BOLT, Config.ANOTHER_PASSWORD_BOLT_BOLT);
        desktopDashboardPage.makeCallToUser(numberForLeaveVoicemail);
    }

    @Test(description = "SQE-2 Voicemail tab - Mark as Read")
    public void voicemailTabMarkAsRead() {
        loginBeforeTest();
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

    @Test(description = "SQE-13 Voicemail tab - Change Folder")
    public void voicemailTabChangeFolder() {
        loginBeforeTest();
        dashboardPage.switchToVoiceMailTab();
        Assert.assertTrue(inboxPage.pageIsDisplayed(), "Inbox tab is opened");
        inboxPage.openUnreadSection();
        VoicemailDataObject expectedDataObject = inboxPage.getValuesFromTable();
        inboxPage.openFirstVoicemailInTable();
        VoicemailDataObject actualDataObject = inboxPage.getValuesFromModal();
        Assert.assertTrue(actualDataObject.isVoicemailDataSame(expectedDataObject), "Voicemail Data are the same");
        inboxPage.clickToChangeFolderButton();
        Assert.assertTrue(inboxPage.isMenuItemsDisplayed(false, true, true, true, true), "Menus are the sames");
        inboxPage.moveVoicemailToReadFolder();
        Assert.assertTrue(inboxPage.isVoicemailDisappearFromTheTable(expectedDataObject.Date), "VM should be present in the unread list.");
        inboxPage.openSelectedVoicemail(expectedDataObject.Date);
        inboxPage.clickToChangeFolderButton();
        Assert.assertTrue(inboxPage.isMenuItemsDisplayed(true, false, true, true, true), "Menus are the sames");
        inboxPage.moveVoicemailToWorkFolder();
        Assert.assertTrue(inboxPage.isVoicemailDisappearFromTheTable(expectedDataObject.Date), "VM should be present in the unread list.");
        inboxPage.openSelectedVoicemail(expectedDataObject.Date);
        inboxPage.clickToChangeFolderButton();
        Assert.assertTrue(inboxPage.isMenuItemsDisplayed(true, true, false, true, true), "Menus are the sames");
        inboxPage.moveVoicemailToFamilyFolder();
        Assert.assertTrue(inboxPage.isVoicemailDisappearFromTheTable(expectedDataObject.Date), "VM should be present in the unread list.");
        inboxPage.openSelectedVoicemail(expectedDataObject.Date);
        inboxPage.clickToChangeFolderButton();
        Assert.assertTrue(inboxPage.isMenuItemsDisplayed(true, true, true, false, true), "Menus are the sames");
        inboxPage.moveVoicemailToFriendsFolder();
        Assert.assertTrue(inboxPage.isVoicemailDisappearFromTheTable(expectedDataObject.Date), "VM should be present in the unread list.");
    }

    @Test(description = "SQE-16 Voicemail tab - Download Voicemail")
    public void voicemailTabDownloadVoicemail() {
        loginBeforeTest();
        dashboardPage.switchToVoiceMailTab();
        Assert.assertTrue(inboxPage.pageIsDisplayed(), "Inbox tab is opened");
        inboxPage.openUnreadSection();
        VoicemailDataObject expectedDataObject = inboxPage.getValuesFromTable();
        inboxPage.openFirstVoicemailInTable();
        VoicemailDataObject actualDataObject = inboxPage.getValuesFromModal();
        Assert.assertTrue(actualDataObject.isVoicemailDataSame(expectedDataObject), "Voicemail Data are the same");
        Assert.assertTrue(inboxPage.isFileDownloaded(), "Voicemail should be download with mp3 format");
    }

    //TODO may be failed because of https://kerauno.atlassian.net/browse/SQE-982
    @Test(description = "SQE-30 Voicemail tab - Delete Single Voicemail")
    public void voicemailTabDeleteSingleVoicemail() {
        loginBeforeTest();
        dashboardPage.switchToVoiceMailTab();
        Assert.assertTrue(inboxPage.pageIsDisplayed(), "Inbox tab is opened");
        inboxPage.openUnreadSection();
        VoicemailDataObject expectedDataObject = inboxPage.getValuesFromTable();
        inboxPage.openFirstVoicemailInTable();
        VoicemailDataObject actualDataObject = inboxPage.getValuesFromModal();
        Assert.assertTrue(actualDataObject.isVoicemailDataSame(expectedDataObject), "Voicemail Data are the same");
        inboxPage.clickToMarkAsReadButton();
        Assert.assertTrue(inboxPage.isVoicemailFolderDisappearAfterClick(), "Voicemail should be marked in lists as Read");
        inboxPage.deleteVoicemail();
        inboxPage.openReadSection();
        Assert.assertTrue(inboxPage.isVoicemailDisappearFromTheTable(expectedDataObject.Date), "VM should be removed from the unread list.");
    }
}
