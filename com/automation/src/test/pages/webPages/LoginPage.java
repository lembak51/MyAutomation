package pages.webPages;

import common.PageElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private static final PageElement usernameFld = new PageElement(
            "Email Field ",
            By.cssSelector("input[data-ng-model='username']"),
            true);
    private static final PageElement userPasswordFld = new PageElement(
            "Password Field ",
            By.cssSelector("input[data-ng-model='password']"),
            true);
    private static final PageElement logInBtn = new PageElement(
            "Log in button",
            By.cssSelector("button[ng-hide='loggingIn']"),
            true);
    private static final PageElement rememberMeChb = new PageElement(
            "Remember Me Checkbox",
            By.cssSelector("label[class='ui-checkbox']"),
            true);

    public LoginPage(WebDriver driver){
        super(driver);
    }

    @Override
    public boolean pageIsDisplayed(){
        waitToBeVisible(usernameFld);
        return allRequiredElementDisplayed();
    }

    public void fillFieldUsername(String userEmail){
        enterText(usernameFld, userEmail);
    }

    public void fillFieldPassword(String userPassword){
        enterText(userPasswordFld, userPassword);
    }

    public void clickLogIn(){
        waitToBeClickable(logInBtn);
        click(logInBtn);
    }

    public void makeLogin(String userEmail, String userPassword){
        fillFieldUsername(userEmail);
        fillFieldPassword(userPassword);
        clickLogIn();
    }

    public void makeLoginWithRememberME(String userEmail, String userPassword){
        fillFieldUsername(userEmail);
        fillFieldPassword(userPassword);
        click(rememberMeChb);
        clickLogIn();
    }

    public void loginWithEmptyField(){
        waitToBeClickable(logInBtn);
        clickLogIn();
    }

    public boolean alertText(String expected){
        waitToBeAlertPresent(1);
        String actualText = getTextFromAlert();
        log.info("Expected alert message: " + expected + ".Actual: " + actualText);
        return actualText.equals(expected);
    }


    public String getTextFromEmailField(){
        waitToBeVisible(usernameFld);
        return getAttribute(usernameFld, "value");
    }

    public boolean isLogInButtonDisplayed(){
        waitUntilPageLoad();
        return isElementPresent(logInBtn);
    }
}
