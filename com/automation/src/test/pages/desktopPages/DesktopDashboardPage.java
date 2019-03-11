package pages.desktopPages;


import common.DesktopElement;
import io.appium.java_client.MobileBy;
import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DesktopDashboardPage extends BasePage {
    private static final DesktopElement numberFld = new DesktopElement(
            "Number Field",
            MobileBy.AccessibilityId("DialNumberTextBox"),
            false);
    private static final DesktopElement callBtn = new DesktopElement(
            "Call button",
            MobileBy.AccessibilityId("CallButton"),
            false);
    private static final DesktopElement endCallBtn = new DesktopElement(
            "End Call button",
            MobileBy.AccessibilityId("EndCall"),
            false);



    public DesktopDashboardPage(WindowsDriver driver){
        super(driver);
    }

    private void fillNumberFld(String userNumber){
       enterText(numberFld,userNumber);
    }

    private void clickCallBtn(){
        waitToBeClickable(callBtn);
        click(callBtn);
    }

    private void clickEndCallBtn(){
      waitToBeClickable(endCallBtn);
      click(endCallBtn);
    }

    public void makeCallToUser(String userNumber){
        waitUntilLoad(2);
        deployApplicationUsingDriver();
        fillNumberFld(userNumber);
        clickCallBtn();
        waitUntilLoad(15);
        clickEndCallBtn();
    }
}
