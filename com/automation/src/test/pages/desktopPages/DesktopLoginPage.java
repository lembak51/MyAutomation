package pages.desktopPages;

import common.DesktopElement;
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
            By.id("UsernameText"),
            false);
    private static final DesktopElement passwordTxt = new DesktopElement(
            "Password field",
            By.id("PasswordText"),
            false);


    public DesktopLoginPage(WindowsDriver driver){
        super(driver);
    }

    private void clickToSignInButton(){
        waitToBeClickable(signInBtn);
        click(signInBtn);
    }

    private void fillFieldUsername(String userEmail){
        WebElement usernameField = desktop_driver.findElementByAccessibilityId("UsernameText");
        usernameField.sendKeys(userEmail);
    }

    private void fillFieldPassword(String userPassword){
        WebElement passwordField = desktop_driver.findElementByAccessibilityId("PasswordText");
        passwordField.sendKeys(userPassword);
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
