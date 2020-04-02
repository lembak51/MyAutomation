package pages.desktopPages;


import common.DesktopElement;
import io.appium.java_client.MobileBy;
import io.appium.java_client.windows.WindowsDriver;

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
    public void makeCallToUser(String userNumber, int callDuration){
        waitUntilLoad(2);
        deployApplicationUsingDriver();
        fillNumberFld(userNumber);
        clickCallBtn();
        waitUntilLoad(callDuration);
        clickEndCallBtn();
    }
    private void clickCallBtn(){
        waitToBeClickable(callBtn);
        click(callBtn);
    }

    private void clickEndCallBtn(){
      waitToBeClickable(endCallBtn);
      click(endCallBtn);
    }


}
