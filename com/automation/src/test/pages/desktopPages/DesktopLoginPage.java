package pages.desktopPages;

import common.DesktopElement;
import io.appium.java_client.MobileBy;
import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DesktopLoginPage extends BasePage {
    private static final DesktopElement signInBtn = new DesktopElement(
            "Sign In button",
            By.name("Sign In"),
            false);
    private static final DesktopElement usernameTxt = new DesktopElement(
            "Username field",
            MobileBy.AccessibilityId("UsernameText"),
            false);
    private static final DesktopElement passwordTxt = new DesktopElement(
            "Password field",
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
        enterText(usernameTxt, userEmail);
    }

    private void fillFieldPassword(String userPassword){
        enterText(passwordTxt, userPassword);
    }

    public void makeLogin(String userEmail, String userPassword){
        fillFieldUsername(userEmail);
        fillFieldPassword(userPassword);
        clickToSignInButton();
        if (isSignInButtonDisplayed()) clickToSignInButton();
        else System.out.println("IDK how to rewrite this");
    }

    private boolean isSignInButtonDisplayed(){
        waitUntilLoad();
        return isElementPresent(signInBtn);
    }


}
