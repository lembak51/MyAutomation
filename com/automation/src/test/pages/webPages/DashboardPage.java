package pages.webPages;

import common.Config;
import common.PageElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

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
            By.cssSelector(" a[ng-hide='pinShow==true || changingPin'] "),
            true);
    private static final PageElement voicemailTab = new PageElement(
            "Voicemail tab button",
            By.cssSelector("a[href='#/pages/voicemail']"),
            false);
    private static final PageElement voicemailPinNumber = new PageElement(
            "Voicemail Pin n=Number",
            By.cssSelector("span[class ='pin ng-binding']"),
            false);
    private static final PageElement cancelVMPinBtn = new PageElement(
            "Cancel Voicemail Pin number button",
            By.cssSelector("button[ng-click='cancelVMPin()']"),
            false);
    private static final PageElement hidePinBtn = new PageElement(
            "Hide Pin number button",
            By.cssSelector("span[ng-show='pinShow && !changingPin']  > a"));
    private static final PageElement changePictureBtn = new PageElement(
            "Change Picture button",
            By.cssSelector("span[class='ng-scope']>a[ng-click='open()']"),
            true);
    private static final PageElement chooseFileBtn = new PageElement(
            "Choose file button",
            By.xpath("//*[@class='row']/div/a"));
    private static final PageElement uploadNewProfilePictureBtn = new PageElement(
            "Upload New Profile Picture button",
            By.cssSelector("button[ng-click='setProfilePicture()']"));
    private static final PageElement closeChangeProfilePictureBtn = new PageElement(
            "Close Change Profile Picture modal button ",
            By.cssSelector("a[ng-click='close()']"));
    private static final PageElement phonebookBtn = new PageElement(
            "Phonebook button",
            By.cssSelector("li[ng-show='user.navigation.pages_phonebook']"),
            true);
    private static final  PageElement callsTabBtn = new PageElement(
            "Calls tab button",
            By.cssSelector("li[ng-show='user.navigation.pages_calls']"));
    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean pageIsDisplayed() {
        waitUntilPageLoad();
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

    public void openPhonebookPage() {
        waitUntilPageLoad();
        waitToBeClickable(phonebookBtn);
        click(phonebookBtn);
    }
    public void openCallsPage(){
        waitToBeClickable(callsTabBtn);
        click(callsTabBtn);
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
        waitUntilPageLoad();
        waitToBeClickable(changePasswordBtn);
        clickChangePasswordBtn();
        waitUntilPageLoad();
        fillOldPassword(oldPassword);
        fillNewPassword(newPassword);
        fillConfirmPassword(confirmPassword);
        waitToBeClickable(submitBtn);
        click(submitBtn);
    }

    public void fillMobileNumber(String newMobileNumber) {
        enterText(mobileNumberFld, newMobileNumber);
    }

    public void changeMyMobileNumberWithIncorrectValues(String newMobileNumber) {
        waitUntilPageLoad(10, false, false, true, false);
        waitToBeClickable(changeMobileBtn);
        click(changeMobileBtn);
        fillMobileNumber(newMobileNumber);
        click(saveMobileNumberBtn);
    }

    public void openUserTab() {
        waitToBeClickable(sidebarUserDevicesSection);
        click(sidebarUserDevicesSection);
        waitUntilPageLoad();
        waitToBeClickable(sidebarUserTab);
        click(sidebarUserTab);
    }

    public void clickAgreeTermOfUseBtn() {
        waitUntilPageLoad(2);
        waitToBeClickable(agreeWithTermOfUseBtn);
        click(agreeWithTermOfUseBtn);

    }

    public void changeVoiceMailPin(String voiceMailPin) {
        waitToBeClickable(changeVMPinBtn);
        click(changeVMPinBtn);
        waitUntilPageLoad();
        enterText(voicemailPinFld, voiceMailPin);
        waitToBeClickable(saveVmPinBtn);
        click(saveVmPinBtn);
    }

    public boolean getVoiceMailPinOnDashboard(String expectedVoiceMailPin) {
        waitToBeClickable(showPinBtn);
        click(showPinBtn);
        String actualVoiceMailPin = getText(voicemailPinNumber);
        log.info("Actual Voice Mail Pin: " + actualVoiceMailPin + ".Expected: " + expectedVoiceMailPin);
        return actualVoiceMailPin.equals(expectedVoiceMailPin);
    }

    public void switchToVoiceMailTab() {
        waitToBeClickable(voicemailTab);
        click(voicemailTab);
    }

    public void clickCancelBtn() {
        waitToBeClickable(cancelChangePasswordBtn);
        click(cancelChangePasswordBtn);
    }

    public void clickHidePinBtn() {
        waitToBeClickable(hidePinBtn);
        click(hidePinBtn);
    }

    public boolean getHideStatusVMPin(String hiddenText) {
        PageElement getHiddenText = new PageElement(
                "Hidden Text",
                By.xpath("//*[@class='pin']//strong"));
        String actualText = getText(getHiddenText);
        return actualText.equals(hiddenText);
    }

    public void changeVoicemailPinWithoutSave(String voicemailPin) {
        waitToBeClickable(changeVMPinBtn);
        click(changeVMPinBtn);
        enterText(voicemailPinFld, voicemailPin);
        waitToBeClickable(cancelVMPinBtn);
        click(cancelVMPinBtn);

    }

    public void uploadProfilePicture() {
        waitToBeClickable(changePictureBtn);
        click(changePictureBtn);
        waitUntilPageLoad();
        waitToBeClickable(chooseFileBtn);
        click(chooseFileBtn);
        uploadNewPhoto("C:\\Users\\admin\\Downloads\\9fdbf585d17c95f7a31ccacdb6466af9.jpg");
        waitToBeClickable(closeChangeProfilePictureBtn);
        click(closeChangeProfilePictureBtn);
    }


}
