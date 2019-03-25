package pages.webPages.voicemailPages;

import common.PageElement;
import common.Utils;
import common.dataObjects.VoicemailDataObject;
import org.openqa.selenium.*;
import pages.webPages.BasePage;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InboxPage extends BasePage {
    private static final PageElement inboxBtn = new PageElement(
            "Inbox Configuration button",
            By.cssSelector("a[data-toggle='inbox']"),
            true);
    private static final PageElement voicemailConfigurationBtn = new PageElement(
            "Voicemail Configuration button",
            By.cssSelector("a[data-toggle='voicemail']"),
            true);
    private static final PageElement voicemailGreetingBtn = new PageElement(
            " Voicemail Greeting button",
            By.cssSelector("a[data-toggle='greetings']"),
            true);
    private static final PageElement unreadBtn = new PageElement(
            "Unread button",
            By.cssSelector("a > i[class='fa fa-circle color-danger pull-right']"),
            true);
    private static final PageElement readBtn = new PageElement(
            "Read button",
            By.cssSelector("a > i[class='fa fa-circle color-grey pull-right']"),
            true);
    private static final PageElement workBtn = new PageElement(
            "Work button",
            By.cssSelector("a > i[class='fa fa-circle color-warning pull-right']"),
            true);
    private static final PageElement familyBtn = new PageElement(
            "Family button",
            By.cssSelector("a > i[class='fa fa-circle color-success pull-right']"),
            true);
    private static final PageElement friendsdBtn = new PageElement(
            "Friends button",
            By.cssSelector("a > i[class='fa fa-circle color-primary pull-right']"),
            true);
    private static final PageElement firstVoicemailInTableBtn = new PageElement(
            "First Voicemail in table",
            By.xpath("//*[@id='voicemail']/tbody[1]/tr"),
            false);
    private static final PageElement dateInVoicemailTableMsb = new PageElement(
            "Date in voicemail table",
            By.cssSelector("#voicemail > tbody:nth-child(1) > tr[class='mail-unread'] > td:nth-child(4)"),
            false);
    private static final PageElement durationInVoicemailTableMsb = new PageElement(
            "Duration   in voicemail table",
            By.cssSelector("#voicemail > tbody:nth-child(1) > tr[class='mail-unread'] > td:nth-child(3)"),
            false);
    private static final PageElement folderInVoicemailTableMsb = new PageElement(
            "Folder in voicemail table",
            By.cssSelector("#voicemail > tbody:nth-child(1) > tr[class='mail-unread'] > td:nth-child(5) > i.fa.fa-circle.color-danger.pull-right"),
            false);
    private static final PageElement dataInSingleVoicemailMsb = new PageElement(
            "Data in single voicemail",
            By.cssSelector("div[class='modal-body ng-binding ng-scope']"),
            false);
    private static final PageElement markAsReadBtn = new PageElement(
            "Mark As Read button",
            By.cssSelector("span[ng-show] > button[ng-click]"),
            false);
    private static final PageElement closeModalBtn = new PageElement(
            "Close modal button",
            By.linkText("Close"),
            false);
    private static final PageElement changeFolderBtn = new PageElement(
            "Change folder button",
            By.cssSelector("div.modal-footer.ng-scope > div[class] > button"),
            false);
    private static PageElement firstElementInChangeFolderBtn = new PageElement(
            "First element in Change folder menu button",
            By.cssSelector("div.btn-group.open > ul > li[ng-if] > a"),
            false);
    private static PageElement readMenuItemBtn = new PageElement(
            "Read menu item button",
            By.cssSelector("a[ng-click=\"changeBox('Old');\"]"),
            false);
    private static PageElement workMenuItemBtn = new PageElement(
            "Work menu item button",
            By.cssSelector("a[ng-click=\"changeBox('Work');\"]"),
            false);
    private static PageElement familyMenuItemBtn = new PageElement(
            "Family menu item button",
            By.cssSelector("a[ng-click=\"changeBox('Family');\"]"),
            false);
    private static PageElement friendsMenuItemBtn = new PageElement(
            "Friends menu item button",
            By.cssSelector("a[ng-click=\"changeBox('Friends');\"]"),
            false);
    private static PageElement deleteVoicemailBtn = new PageElement(
            "Delete Voicemail button",
            By.cssSelector("a[ng-click=\"delete();\"]"),
            false);
    private static PageElement confirmBtn = new PageElement(
            "Confirm button",
            By.cssSelector("button[ng-click=\"confirm()\"]"),
            false);
    private static PageElement downloadBtn = new PageElement(
            "Download Voicemail button",
            By.cssSelector("a[class=\"btn btn-success btn-sm\"]"),
            false);


    public InboxPage(WebDriver driver){
        super(driver);
    }

    @Override
    public boolean pageIsDisplayed(){
        return allRequiredElementDisplayed();
    }

    public void openVoicemailConfigurationPage(){
        waitToBeClickable(voicemailConfigurationBtn);
        click(voicemailConfigurationBtn);
    }

    public void openUnreadSection(){
        waitToBeClickable(unreadBtn);
        click(unreadBtn);
    }

    public void openReadSection(){
        waitUntilPageLoad(1);
        waitToBeClickable(readBtn);
        click(readBtn);
    }

    private void openWorkSection(){
        waitToBeClickable(workBtn);
        click(workBtn);
    }

    private void openFamilySection(){
        waitToBeClickable(familyBtn);
        click(familyBtn);
    }

    private void openFriendsSection(){
        waitToBeClickable(friendsdBtn);
        click(friendsdBtn);
    }


    public void playVoicemail(){
        WebElement audio = driver.findElement(By.xpath("//div/audio"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].play();", audio);
        waitUntilPageLoad(7);
    }

    //TODO need to change method
    public boolean isFileDownloaded(){
        waitToBeClickable(downloadBtn);
        click(downloadBtn);
        File dir = new File(System.getProperty("user.home") + "/Downloads/");
        File[] dirContents = dir.listFiles();
        for (int i = 0; i < dirContents.length; i++) {
            if (dirContents[i].getName().contains(".mp3")) {
                dirContents[i].delete();
                return true;
            }
        }
        return false;
    }

    private String getDateFromTable(){
        return getText(dateInVoicemailTableMsb);
    }

    private String getDurationFromTable(){
        return getText(durationInVoicemailTableMsb);
    }

    private String getFolderFromTable(){
        return getAttribute(folderInVoicemailTableMsb, "ng-show").substring(16, 21).toLowerCase();
    }

    private String getDateFromSingleVoicemail(){
        return getText(dataInSingleVoicemailMsb).substring(6, getText(dataInSingleVoicemailMsb).indexOf('\n'));
    }

    private String getDurationFromSingleVoicemail(){
        return getText(dataInSingleVoicemailMsb).substring(40, getText(dataInSingleVoicemailMsb).indexOf('\n') + 16);
    }

    private String getFolderFromSingleVoicemail(){
        return getText(dataInSingleVoicemailMsb).substring(54, getText(dataInSingleVoicemailMsb).indexOf('\n') + 30).toLowerCase();
    }

    public VoicemailDataObject getValuesFromTable(){
        VoicemailDataObject expectedDataObject = new VoicemailDataObject();
        expectedDataObject.Date = getDateFromTable();
        expectedDataObject.Duration = getDurationFromTable();
        expectedDataObject.Folder = getFolderFromTable();
        return expectedDataObject;
    }

    public VoicemailDataObject getValuesFromModal(){
        VoicemailDataObject actualDataObject = new VoicemailDataObject();
        actualDataObject.Date = getDateFromSingleVoicemail();
        actualDataObject.Duration = getDurationFromSingleVoicemail();
        actualDataObject.Folder = getFolderFromSingleVoicemail();
        return actualDataObject;
    }

    public void openFirstVoicemailInTable(){
        waitToBeClickable(firstVoicemailInTableBtn);
        click(firstVoicemailInTableBtn);
    }

    public void clickToChangeFolderButton(){
        waitToBeClickable(changeFolderBtn);
        click(changeFolderBtn);
    }

    public void clickToMarkAsReadButton(){
        waitToBeClickable(markAsReadBtn);
        click(markAsReadBtn);
    }

    public void clickToCloseButton(){
        waitToBeVisible(closeModalBtn);
        click(closeModalBtn);
    }

    public boolean isVoicemailDisappearFromTheTable(String tmp_date){
        PageElement voicemail = new PageElement(
                "VM in list",
                By.xpath("//td[contains(.,'" + tmp_date + "')]"),
                false);
        log.info("Voicemail with following date disappear from the table  " + tmp_date);
        return isElementPresent(voicemail);
    }

    public boolean isVoicemailFolderDisappearAfterClick(){
        String stringBeforeClick = getText(dataInSingleVoicemailMsb);
        waitToBeClickable(markAsReadBtn);
        click(markAsReadBtn);
        String stringAfterClick = getText(dataInSingleVoicemailMsb);
        log.info("Word before click is: " + stringBeforeClick + "and value after click is: " + stringAfterClick);
        return stringBeforeClick.equals(stringAfterClick);
    }

    public boolean isMenuItemsDisplayed(boolean isUnread, boolean isRead, boolean isWork, boolean isFamily, boolean isFriends){
        ArrayList<String> al = new ArrayList<>();
        if (isUnread) al.add("Unread");
        if (isRead) al.add("Read");
        if (isWork) al.add("Work");
        if (isFamily) al.add("Family");
        if (isFriends) al.add("Friends");
        ArrayList<String> obtainedList = new ArrayList<>();
        List<WebElement> elementList = findAll(firstElementInChangeFolderBtn);
        for (WebElement we : elementList) {
            obtainedList.add(we.getText());
        }
        log.info("List of items are: " + Arrays.toString(al.toArray()) + ". List of items after click are: " + Arrays.toString(obtainedList.toArray()));
        return al.equals(obtainedList);
    }

    private void clickToReadButton(){
        waitToBeClickable(readMenuItemBtn);
        click(readMenuItemBtn);
    }


    private void clickToWorkButton(){
        waitToBeClickable(workMenuItemBtn);
        click(workMenuItemBtn);
    }

    private void clickToFamilyButton(){
        waitToBeClickable(familyMenuItemBtn);
        click(familyMenuItemBtn);
    }

    private void clickToFriendsButton(){
        waitToBeClickable(friendsMenuItemBtn);
        click(friendsMenuItemBtn);
    }

    public void deleteVoicemail(){
        waitToBeClickable(deleteVoicemailBtn);
        click(deleteVoicemailBtn);
        waitToBeClickable(confirmBtn);
        click(confirmBtn);
    }

    public void openSelectedVoicemail(String tmp_date){
        PageElement voicemail = new PageElement(
                "VM in list",
                By.xpath("//td[contains(.,'" + tmp_date + "')]"),
                false);
        click(voicemail);
    }

    public void moveVoicemailToReadFolder(){
        clickToReadButton();
        clickToCloseButton();
        waitUntilPageLoad(1);
        openReadSection();
    }

    public void moveVoicemailToWorkFolder(){
        clickToWorkButton();
        clickToCloseButton();
        waitUntilPageLoad(1);
        openWorkSection();
    }

    public void moveVoicemailToFamilyFolder(){
        clickToFamilyButton();
        clickToCloseButton();
        waitUntilPageLoad(1);
        openFamilySection();
    }

    public void moveVoicemailToFriendsFolder(){
        clickToFriendsButton();
        clickToCloseButton();
        waitUntilPageLoad(1);
        openFriendsSection();
    }
}
