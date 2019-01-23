package pages;

import common.DesktopElement;
import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.By;

public class DesktopLoginPage extends BaseDesktopPage {
    private static final DesktopElement signInBtn = new DesktopElement(
            "Sing In button",
            By.name("Sign In"),
            false);

    public DesktopLoginPage(WindowsDriver driver){
        super(driver);
    }
}
