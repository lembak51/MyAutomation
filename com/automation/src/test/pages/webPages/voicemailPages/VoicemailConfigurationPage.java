package pages.webPages.voicemailPages;


import common.PageElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.webPages.BasePage;

public class VoicemailConfigurationPage extends BasePage {

    private static final PageElement voicemailPinFld = new PageElement(
            "Voicemail Field",
            By.xpath("//*[@class='row']/div/input"),
            true);

    public VoicemailConfigurationPage(WebDriver driver){
        super(driver);
    }

    @Override
    public boolean pageIsDisplayed(){
        return allRequiredElementDisplayed();
    }

    public boolean getVoicemailPin(String pinFromDashboard){
        String actualPin = getText(voicemailPinFld);
        return actualPin.equals(pinFromDashboard);
    }
}
