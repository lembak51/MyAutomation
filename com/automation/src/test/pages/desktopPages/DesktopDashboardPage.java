package pages.desktopPages;

import common.DesktopElement;
import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DesktopDashboardPage extends BasePage {
    private static final DesktopElement softponeBtn = new DesktopElement(
            "Softphone button",
            By.id("Menu.MenuItem.Softphone"),
            false);
    private static final DesktopElement signOutBtn = new DesktopElement(
            "Sign Out button",
            By.name("_Sign Out"),
            false);

    public DesktopDashboardPage(WindowsDriver driver){
        super(driver);
    }


    private void fillNumberFld(String userNumber){
        WebElement numberFld = desktop_driver.findElementByAccessibilityId("DialNumberTextBox");
        numberFld.sendKeys(userNumber);
    }
    private void clickCallBtn(){
        WebElement callBtn= desktop_driver.findElementByAccessibilityId("CallButton");
        callBtn.click();
    }
    private void clickEndCallBtn(){
        WebElement callBtn= desktop_driver.findElementByAccessibilityId("EndCall");
        callBtn.click();
    }

    public void makeCallToUser(String userNumber){
      //  waitUntilLoad(1);
        deployApplicationUsingDriver();
        fillNumberFld(userNumber);
        clickCallBtn();
        waitUntilLoad(15);
        clickEndCallBtn();
    }
}
