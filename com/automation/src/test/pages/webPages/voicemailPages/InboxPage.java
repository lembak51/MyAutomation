package pages.webPages.voicemailPages;

import common.PageElement;
import common.dataObjects.VoicemailDataObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import pages.webPages.BasePage;

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
    private static final PageElement firstVoicemailInTableBtn = new PageElement(
            "First Voicemail in table",
            By.xpath("//*[@id=\"voicemail\"]/tbody[1]/tr/td[2]"),
            true);
    private static final PageElement dateInVoicemailTableMsb = new PageElement(
            "Date in voicemail table",
            By.xpath("//*[@id='voicemail']/tbody[1]/tr/td[4]"),
            false);
    private static final PageElement durationInVoicemailTableMsb = new PageElement(
            "Duration   in voicemail table",
            By.xpath("//*[@id='voicemail']/tbody[1]/tr/td[3]"),
            false);
    private static final PageElement folderInVoicemailTableMsb = new PageElement(
            "Folder in voicemail table",
            By.xpath("//*[@id='voicemail']/tbody[1]/tr/td[5]"),
            false);
    private static final PageElement dateInSingleVoicemailMsb = new PageElement(
            "Date in single voicemail",
            By.xpath("//*[@id=\"app\"]/div[3]/div/div/div[2]/text()[1]"),
            false);
    private static final PageElement durationInSingleVoicemailMsb = new PageElement(
            "Duration single in voicemail",
            By.xpath("//*[@id=\"app\"]/div[3]/div/div/div[2]/text()[2]"),
            false);
    private static final PageElement folderInSingleVoicemailMsb = new PageElement(
            "Folder in single voicemail",
            By.xpath("//*[@id=\"app\"]/div[3]/div/div/div[2]/span/text()"),
            false);
    private static final PageElement markAsReadBtn = new PageElement(
            "Mark As Read button",
            By.xpath("//*[@id=\"app\"]/div[3]/div/div/div[3]/div[3]/span/button"),
            false);
    )

    public InboxPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean pageIsDisplayed() {
        return allRequiredElementDisplayed();
    }

    public void openVoicemailConfigurationPage() {
        waitToBeClickable(voicemailConfigurationBtn);
        click(voicemailConfigurationBtn);
    }

    public void clickToUnreadButton() {
        waitToBeClickable(unreadBtn);
        click(unreadBtn);
    }

    //TODO need to change locator
    public void playVoicemail() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("document.querySelector('#audioElement').play();");
    }

    private String getDateFromTable() {
        return getText(dateInVoicemailTableMsb);
    }

    private String getDurationFromTable() {
        return getText(durationInVoicemailTableMsb);
    }

    private String getFolderFromTable() {
        return getText(folderInVoicemailTableMsb);
    }

    private String getDateFromSingleVoicemail() {
        return getText(dateInSingleVoicemailMsb);
    }

    private String getDurationFromSingleVoicemail() {
        return getText(durationInSingleVoicemailMsb);
    }

    private String getFolderFromSingleVoicemail() {
        return getText(folderInSingleVoicemailMsb);
    }

    public VoicemailDataObject getValuesFromTable() {
        VoicemailDataObject expectedDataObject = new VoicemailDataObject();
        expectedDataObject.Date = getDateFromTable();
        expectedDataObject.Duration = getDurationFromTable();
        expectedDataObject.Folder = getFolderFromTable();
        return expectedDataObject;
    }

    public VoicemailDataObject getValuesFromModal() {
        VoicemailDataObject actualDataObject = new VoicemailDataObject();
        actualDataObject.Date = getDateFromSingleVoicemail();
        actualDataObject.Duration = getDurationFromSingleVoicemail();
        actualDataObject.Folder = getFolderFromSingleVoicemail();
        return actualDataObject;
    }

    public void openFirstVoicemailInTable() {
        waitToBeClickable(firstVoicemailInTableBtn);
        click(folderInSingleVoicemailMsb);
    }

    public boolean isVoicemailIsPlaying() {
        return true;
    }

    public void clickToMarkAsReadButton() {
        waitToBeClickable(markAsReadBtn);
        click(markAsReadBtn);
    }

}
