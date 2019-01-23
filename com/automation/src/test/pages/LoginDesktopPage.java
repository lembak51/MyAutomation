package pages;

import common.AppElement;
import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.By;

public class LoginDesktopPage extends BaseDesktopPage {
    private static final AppElement signInBtn = new AppElement(
            "Sing In button",
            By.name("Sign In"),
            false);

    public LoginDesktopPage(WindowsDriver driver){
        super(driver);
    }


    public void clickOnSignInButton(){
        waitToBeClickable(signInBtn);
        click(signInBtn);
    }
}
