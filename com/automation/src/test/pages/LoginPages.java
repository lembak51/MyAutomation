package pages;

import common.PageElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPages extends BasePage {
    private static final PageElement emailField = new PageElement(
            "Email Field ",
            By.cssSelector("input[data-ng-model='username']"),
            true);

    private static final PageElement passwordField = new PageElement(
            "Password Field ",
            By.cssSelector("input[data-ng-model='password']"),
            true);
    private static final PageElement logiInButton = new PageElement(
            "Log in button",
            By.cssSelector("button[ng-hide='loggingIn']"),
            true);

    public LoginPages(WebDriver driver){
        super(driver);
    }

    @Override
    public boolean pageIsDisplayed(){
        waitToBeVisible(logiInButton);
        return allRequiredElementDisplayed();
    }

    public void fillEmailField(String userEmail){enterText(emailField,userEmail);}
    public void fillPasswordField(String userPassword){enterText(passwordField,userPassword);}
    public void clickLogIn(){
        click(logiInButton);
    }
    public void makeLogin(String userEmail, String userPassword){
        this.fillEmailField(userEmail);
        this.fillPasswordField(userPassword);
        this.clickLogIn();
    }
}
