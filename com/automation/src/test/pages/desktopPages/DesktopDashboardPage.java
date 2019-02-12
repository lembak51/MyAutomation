package pages.desktopPages;

import common.DesktopElement;
import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.By;

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

    public void logout(){
        waitUntilLoad();
        waitToBeClickable(softponeBtn);
        click(softponeBtn);
        waitToBeClickable(signOutBtn);
        click(signOutBtn);
    }
}
