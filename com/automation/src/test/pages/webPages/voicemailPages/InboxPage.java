package pages.webPages.voicemailPages;

import common.PageElement;
import common.Utils;
import common.dataObjects.VoicemailDataObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
            By.xpath("//*[@id='app']/div[3]/div/div/div[2]"),
            false);
    private static final PageElement markAsReadBtn = new PageElement(
            "Mark As Read button",
            By.xpath("//div[3]/span/button"),
            false);
    private static final PageElement closeModalBtn = new PageElement(
            "Close modal button",
            By.linkText("Close"),
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

    public void clickToUnreadButton(){
        waitToBeClickable(unreadBtn);
        click(unreadBtn);
    }

    //TODO need to change locator
    public void playVoicemail(){
        WebElement audio = driver.findElement(By.xpath("//div/audio"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].play();", audio);
        Utils.sleep(7000);
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
        return getText(dataInSingleVoicemailMsb).substring(39, getText(dataInSingleVoicemailMsb).indexOf('\n') + 16);
    }

    private String getFolderFromSingleVoicemail(){
        return getText(dataInSingleVoicemailMsb).substring(53, getText(dataInSingleVoicemailMsb).indexOf('\n') + 30).toLowerCase();
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

    public boolean isVoicemailIsPlaying(){
        return true;
    }

    public void clickToMarkAsReadButton(){
        waitToBeClickable(markAsReadBtn);
        click(markAsReadBtn);
    }

    public void clickToCloseButton(){
        waitToBeVisible(closeModalBtn);
        click(closeModalBtn);
    }
}
