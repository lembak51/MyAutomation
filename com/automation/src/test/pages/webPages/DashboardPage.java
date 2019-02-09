package pages.webPages;

import common.Config;
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
    private final static PageElement sidebarUserDevicesSection = new PageElement(
            "Sidebar User & Devices section button",
            By.cssSelector("span[data-i18n='Users & Devices']"),
            true);
    private final static PageElement sidebarUserTab = new PageElement(
            "User section button",
            By.cssSelector("a[href='#/users/user']"),
            false);
    private final static PageElement agreeWithTermOfUseBtn = new PageElement(
            "Agree with Term of use button",
            By.xpath("//*[@class='modal fade ng-isolate-scope in']//button[1]"),
            false);
    private final static PageElement cancelChangePasswordBtn = new PageElement(
            "Cancel Change Password modal",
            By.cssSelector("button[ng-click='cancel()']"),
            false);
    private final static PageElement changeVMPinBtn = new PageElement(
            "Change Voicemail Pin button",
            By.cssSelector("i[ng-click='changeVMPin()']"),
            true);
    private final static PageElement voicemailPinFld = new PageElement(
            "Voicemail field",
            By.cssSelector("input[data-ng-model='newPin']"),
            false);
    private final static PageElement saveVmPinBtn = new PageElement(
            "Save Voicemail Pin button",
            By.cssSelector("button[ng-click='saveVMPin()']"),
            false);
    private final static PageElement showPinBtn = new PageElement(
            "Show Voicemail Pin button",
            By.cssSelector(" form > span:nth-child(4) > a"),
            true);
    private static final PageElement voicemailTab = new PageElement(
            "Voicemail tab button",
            By.cssSelector("a[href='#/pages/voicemail']"),
            false);
    private static final PageElement voicemailPinNumber = new PageElement(
            "Voicemail Pin n=Number",
            By.cssSelector("span[class ='pin ng-binding']"),
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
        waitUntilPageLoad(1);
        waitToBeClickable(userProfileDdb);
        click(userProfileDdb);
        waitToBeClickable(logoutBtn);
        click(logoutBtn);
    }

    public void clickChangePasswordBtn(){
        waitToBeClickable(changePasswordBtn);
        click(changePasswordBtn);
    }

    public void fillOldPassword(String userPassword){
        enterText(oldPasswordFld, userPassword);
    }

    public void fillNewPassword(String newPassword){
        enterText(newPasswordFld, newPassword);
    }

    public void fillConfirmPassword(String confirmPassword){
        enterText(confirmPasswordFld, confirmPassword);
    }

    public void changePassword(String oldPassword, String newPassword, String confirmPassword){
        waitUntilPageLoad(1);
        waitToBeClickable(changePasswordBtn);
        clickChangePasswordBtn();
        waitToBeClickable(cancelChangePasswordBtn);
        fillOldPassword(oldPassword);
        fillNewPassword(newPassword);
        fillConfirmPassword(confirmPassword);
        waitToBeClickable(submitBtn);
        click(submitBtn);
    }

    public boolean alertWithExpectedText(String expectedText){
        waitToBeAlertPresent(1);
        String actualText = getTextFromAlert();
        return actualText.equals(expectedText);
    }

    public void fillMobileNumber(String newMobileNumber){
        enterText(mobileNumberFld, newMobileNumber);
    }

    public void changeMyMobileNumberWithIncorrectValues(String newMobileNumber){
        waitToBeClickable(changeMobileBtn);
        click(changeMobileBtn);
        waitUntilPageLoad(1);
        fillMobileNumber(newMobileNumber);
        click(saveMobileNumberBtn);
    }

    public void openUserTab(){
        waitToBeClickable(sidebarUserDevicesSection);
        click(sidebarUserDevicesSection);
        waitUntilPageLoad(1);
        waitToBeClickable(sidebarUserTab);
        click(sidebarUserTab);
    }

    public void clickAgreeTermOfUseBtn(){
        waitUntilPageLoad(1);
        waitToBeClickable(agreeWithTermOfUseBtn);
        click(agreeWithTermOfUseBtn);

    }

    public void changeVoicemailPin(String voicemailPin){
        waitToBeClickable(changeVMPinBtn);
        click(changeVMPinBtn);
        enterText(voicemailPinFld, voicemailPin);
        waitToBeClickable(saveVmPinBtn);
        click(saveVmPinBtn);
    }
    public boolean getVoicemialPinOnDashboard (String voicemailPin){
        waitToBeClickable(showPinBtn);
        click(showPinBtn);
        String actualVoicemailPin = getText(voicemailPinNumber);
        return actualVoicemailPin.equals(voicemailPin);
    }

    public void switchToVoicemailTab(){
        waitToBeClickable(voicemailTab);
        click(voicemailTab);
    }
    public void clickCancelBtn (){
        waitToBeClickable(cancelChangePasswordBtn);
        click(cancelChangePasswordBtn);
    }
}
