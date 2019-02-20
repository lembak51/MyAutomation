package pages.webPages;


import common.PageElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VoicemailPage extends BasePage{
    private static final PageElement voicemailConfigurationBtn = new PageElement(
            "Voicemail Configuration button",
            By.cssSelector("a[data-toggle='voicemail']"),
            true);
    private static final PageElement voicemailPinFld = new PageElement(
            "Voicemail Field",
            By.xpath("//*[@class='row']/div/input"),
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
        String actualPin = getText(voicemailPinFld);
        return actualPin.equals(pinFromDashboard);
    }
}
