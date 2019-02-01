package pages.webPages;

import common.PageElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage extends BasePage {

    private final static PageElement userProfileDdb = new PageElement(
            "User Profile Drop Down",
            By.cssSelector("li[class='dropdown text-normal nav-profile']"),
            true);
    private final static PageElement logoutBtn = new PageElement(
            "Logout button",
            By.cssSelector("a[ng-click='logout()']"),
            false);
    private final static PageElement releaseNoteBtn = new PageElement(
            "Release Notes Links",
            By.cssSelector("span>a[target='_blank']"),
            true);
    private final static PageElement changePasswordBtn = new PageElement(
            "Change Password button",
            By.cssSelector("button[ng-click='changePassword()']"),
            true);
    private final static PageElement oldPasswordFld = new PageElement(
        "Old Password Field",
        By.cssSelector("input[data-ng-model='oldpassword']"),
        false);
    private final static PageElement newPasswordFld = new PageElement(
            "New Password Field",
            By.cssSelector("input[data-ng-model='newpassword']"),
            false);
    private final static PageElement confirmPasswordFld = new PageElement(
            "Confirm Password Field",
            By.cssSelector("input[data-ng-model='confirmpassword']"),
            false);

    public DashboardPage(WebDriver driver){
        super(driver);
    }

    @Override
    public boolean pageIsDisplayed(){
        waitToBePresent(userProfileDdb);
        return allRequiredElementDisplayed();
    }

    public void clickReleaseNote(){
        waitToBeClickable(releaseNoteBtn);
        click(releaseNoteBtn);
    }

    public void logout(){
        waitUntilPageLoad();
        waitToBeClickable(userProfileDdb);
        click(userProfileDdb);
        waitToBeClickable(logoutBtn);
        click(logoutBtn);
    }
    public void clickChangePasswordBtn(){
        waitToBeClickable(changePasswordBtn);
        click(changePasswordBtn);
    }
}
