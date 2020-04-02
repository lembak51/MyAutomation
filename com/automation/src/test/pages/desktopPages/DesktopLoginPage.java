package pages.desktopPages;

import common.DesktopElement;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DesktopLoginPage extends BasePage {
    private static final DesktopElement signInBtn = new DesktopElement(
            "Sign In button",
            By.className("Sign_in"),
            false);
    private static final DesktopElement usernameFld  = new DesktopElement(
            "Username Field",
            MobileBy.AccessibilityId("UsernameText"),
            false);
    private static final DesktopElement passwordFld  = new DesktopElement(
            "Username Field",
            MobileBy.AccessibilityId("PasswordText"),
            false);

    public DesktopLoginPage(WindowsDriver driver){
        super(driver);
    }

    private void clickToSignInButton(){
        waitToBeClickable(signInBtn);
        click(signInBtn);
    }

    private void fillFieldUsername(String userEmail){
        enterText(usernameFld,userEmail);
    }

    private void fillFieldPassword(String userPassword){
        enterText(passwordFld,userPassword);
    }

    public void makeLogin(String userEmail, String userPassword){
        waitUntilLoad(2);
        fillFieldUsername(userEmail);
        fillFieldPassword(userPassword);
        clickToSignInButton();
        waitUntilLoad(5);
        if (isSignInButtonDisplayed())
            clickToSignInButton();
    }

    private boolean isSignInButtonDisplayed(){
        return isElementPresent(signInBtn);
    }

}