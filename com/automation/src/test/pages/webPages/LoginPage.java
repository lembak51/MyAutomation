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
        waitToBeVisible(logInBtn);
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
        this.fillFieldUsername(userEmail);
        this.fillFieldPassword(userPassword);
        this.clickLogIn();
    }

    public void makeLoginWithRememberME(String userEmail, String userPassword){
        this.fillFieldUsername(userEmail);
        this.fillFieldPassword(userPassword);
        click(rememberMeChb);
        this.clickLogIn();
    }

    public void loginWithEmptyField(){
        waitToBeClickable(logInBtn);
        clickLogIn();
    }

    public boolean alertText(){
        waitToBeAlertPresent(4);
        String actualText = getTextFromAlert();
        return actualText.equals("Error: Email / Password Combination is not correct!");
    }


    public String getTextFromEmailField(){
        waitToBeVisible(usernameFld);
        String UserEmail = getAttribute(usernameFld, "value");
        return UserEmail;
    }

    public boolean isLogInButtonDisplayed(){
        waitUntilPageLoad();
        return isElementPresent(logInBtn);
    }
}
