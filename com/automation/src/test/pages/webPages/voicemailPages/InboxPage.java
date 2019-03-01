package pages.webPages.voicemailPages;

import common.PageElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.webPages.BasePage;

public class InboxPage extends BasePage {
    private static final PageElement voicemailConfigurationBtn = new PageElement(
            "Voicemail Configuration button",
            By.cssSelector("a[data-toggle='voicemail']"),
            true);
    private static final PageElement inboxBtn = new PageElement(
            "Inbox Configuration button",
            By.cssSelector("a[data-toggle='inbox']"),
            true);
    private static final PageElement voicemailGreetingBtn = new PageElement(
            " Voicemail Greeting button",
            By.cssSelector("a[data-toggle='greetings']"),
            true);
    private static final PageElement unreadBtn = new PageElement(
            "Unread button",
            By.cssSelector("a > i[class='fa fa-circle color-danger pull-right']"),
            true);

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
}
