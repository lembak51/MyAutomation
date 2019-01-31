package pages.desktopPages;

import common.DesktopElement;
import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.By;

public class DesktopLoginPage extends BasePage {
    private static final DesktopElement signInBtn = new DesktopElement(
            "Sing In button",
            By.name("Sign In"),
            false);

    public DesktopLoginPage(WindowsDriver driver){
        super(driver);
    }

    public void clickToSignInButton(){
        waitToBeClickable(signInBtn);
        click(signInBtn);
    }
}
