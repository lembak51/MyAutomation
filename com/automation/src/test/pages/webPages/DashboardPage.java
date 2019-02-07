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
    private final static PageElement submitBtn = new PageElement(
            "Submit button",
            By.cssSelector("button[class='btn btn-success']"),
            false);
    private final static PageElement changeMobileBtn = new PageElement(
            "Change mobile number button",
            By.cssSelector("i[ng-click='changingMobile = true;changeMobile()']"),
            true);
    private final static PageElement mobileNumberFld = new PageElement(
            "My Mobile number field",
            By.cssSelector("input[data-ng-model='newMobile']"),
            true);
    private final static PageElement saveMobileNumberBtn = new PageElement(
            "Save Mobile Number button",
            By.cssSelector("button[ng-hide ='ad_phone_set']"),
            true);
    private final static  PageElement sidebarUserDevicesSection = new PageElement(
            "Sidebar User & Devices section button",
            By.cssSelector("span[data-i18n='Users & Devices']"),
            true);
    private final static  PageElement sidebarUserTab = new PageElement(
            "User section button",
            By.cssSelector("a[href='#/users/user']"),
            false);

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean pageIsDisplayed() {
        waitToBePresent(userProfileDdb);
        return allRequiredElementDisplayed();
    }

    public void clickReleaseNote() {
        waitToBeClickable(releaseNoteBtn);
        click(releaseNoteBtn);
    }

    public void logout() {
        waitUntilPageLoad();
        waitToBeClickable(userProfileDdb);
        click(userProfileDdb);
        waitToBeClickable(logoutBtn);
        click(logoutBtn);
    }

    public void clickChangePasswordBtn() {
        waitToBeClickable(changePasswordBtn);
        click(changePasswordBtn);
    }

    public void fillOldPassword(String userPassword) {
        enterText(oldPasswordFld, userPassword);
    }

    public void fillNewPassword(String newPassword) {
        enterText(newPasswordFld, newPassword);
    }

    public void fillConfirmPassword(String confirmPassword) {
        enterText(confirmPasswordFld, confirmPassword);
    }

    public void changePassword(String oldPassword, String newPassword, String confirmPassword) {
        clickChangePasswordBtn();
        fillOldPassword(oldPassword);
        fillNewPassword(newPassword);
        fillConfirmPassword(confirmPassword);
        click(submitBtn);
    }

    public boolean alertWithExpectedText(String expectedText) {
        waitToBeAlertPresent(1);
        String actualText = getTextFromAlert();
        return actualText.equals(expectedText);
    }

    public void fillMobileNumber(String newMobileNumber) {
        enterText(mobileNumberFld, newMobileNumber);
    }

    public void changeMyMobileNumberWithIncorrectValues(String newMobileNumber) {
        waitToBeClickable(changeMobileBtn);
        click(changeMobileBtn);
        fillMobileNumber(newMobileNumber);
        click(saveMobileNumberBtn);
    }

    public void openUserTab(){
        waitToBeClickable(sidebarUserDevicesSection);
        click(sidebarUserDevicesSection);
        waitToBeClickable(sidebarUserTab);
        click(sidebarUserTab);
    }

}
