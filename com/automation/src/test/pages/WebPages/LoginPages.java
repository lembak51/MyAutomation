package pages.WebPages;

import common.PageElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.WebPages.BasePage;

public class LoginPages extends BasePage {
    private static final PageElement usernameFld = new PageElement(
            "Email Field ",
            By.cssSelector("input[data-ng-model='username']"),
            true);
    private static final PageElement userpasswordFld = new PageElement(
            "Password Field ",
            By.cssSelector("input[data-ng-model='password']"),
            true);
    private static final PageElement logiInBtn = new PageElement(
            "Log in button",
            By.cssSelector("button[ng-hide='loggingIn']"),
            true);

    public LoginPages(WebDriver driver){
        super(driver);
    }

    @Override
    public boolean pageIsDisplayed(){
        waitToBeVisible(logiInBtn);
        return allRequiredElementDisplayed();
    }

    public void fillEmailField(String userEmail){
        enterText(usernameFld, userEmail);
    }

    public void fillPasswordField(String userPassword){
        enterText(userpasswordFld, userPassword);
    }

    public void clickLogIn(){
        click(logiInBtn);
    }

    public void makeLogin(String userEmail, String userPassword){
        this.fillEmailField(userEmail);
        this.fillPasswordField(userPassword);
        this.clickLogIn();
    }
}
