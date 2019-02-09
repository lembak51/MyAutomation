package pages.webPages;


import common.PageElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class VoicemailPage extends BasePage{
    private static final PageElement voicemailConfigurationBtn = new PageElement(
            "Voicemail Configuration button",
            By.cssSelector("a[data-toggle='voicemail']"),
            true);
    private static final PageElement voicemailPinFld = new PageElement(
            "Voicemail Field",
            By.cssSelector("input[data-ng-model='modify_user.voicemail_secret']"),
            false);

    public VoicemailPage(WebDriver driver){
        super(driver);
    }

    @Override
    public boolean pageIsDisplayed(){
        return allRequiredElementDisplayed();
    }


    public boolean getVoicemailPin (String pinFromDashboard){
        waitToBeClickable(voicemailConfigurationBtn);
        click(voicemailConfigurationBtn);
        String actualPin = getAttribute(voicemailPinFld,"placeholder");
        return actualPin.equals(pinFromDashboard);
    }
}
