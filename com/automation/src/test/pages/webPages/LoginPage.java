package pages.webPages;

import common.Config;
import common.PageElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private static final PageElement usernameFld = new PageElement(
            "Email Field ",
            By.xpath("//*[@id=\"root\"]/div/div/div/div/div/div/div[2]/div/div/div[2]/div/input"),
            true);
    private static final PageElement userPasswordFld = new PageElement(
            "Password Field ",
            By.xpath("//*[@id=\"root\"]/div/div/div/div/div/div/div[2]/div/div/div[4]/div/input"),
            true);
    private static final PageElement logInBtn = new PageElement(
            "Log in button",
            By.xpath("//*[@id=\"root\"]/div/div/div/div/div/div/div[2]/div/div/button"),
            true);

    private static final PageElement alertInvalidCredential = new PageElement(
            "Alert",
            By.cssSelector("#root > div.MuiSnackbar-root.MuiSnackbar-anchorOriginTopCenter.notification > div"),
            false);
  /*  private static final PageElement rememberMeChb = new PageElement(
            "Remember Me Checkbox",
            By.cssSelector("label[class='ui-checkbox']"),
              true);
              //*[@id="root"]/div[1]/div
*/

    public LoginPage(WebDriver driver){
        super(driver);
    }

    @Override
    public boolean pageIsDisplayed(){
        waitUntilPageLoad(1, false, false, true, false);
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
        waitUntilPageLoad();
        waitToBeClickable(logInBtn);
        fillFieldUsername(userEmail);
        fillFieldPassword(userPassword);
        clickLogIn();
    }

    public void makeLoginWithRememberME(String userEmail, String userPassword){
        fillFieldUsername(userEmail);
        fillFieldPassword(userPassword);
        clickLogIn();
    }
//
//public void loginWithinvalidusername
    //      waitToBeClickable(logInBtn);
    //      fillFieldUsername(Config.INCORRECT_USERNAME)
//     fillFieldPassword(userPassword);
    //    clickLogIn();
// }
    //
    public String getTextFromEmailField(){
        waitToBeVisible(usernameFld);
        return getAttribute(usernameFld, "value");
    }

    public boolean isLogInButtonDisplayed(){
        waitUntilPageLoad();
        return isElementPresent(logInBtn);
    }
    public boolean isErrormMesegWhenLogin(String expectedText){
        waitToBeVisible(alertInvalidCredential,4);
        waitToBeVisible(alertInvalidCredential,4);
        waitToBeVisible(alertInvalidCredential,4);
        String actualText = getText(alertInvalidCredential);
        log.info("Actual Alert Text: " + actualText + ".Expected: " + expectedText);
        return actualText.equals(expectedText);
    }
}
















