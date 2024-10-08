package pages.webPages;

import common.PageElement;
import common.dataObjects.UserDataObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddUsersPage extends BasePage {
    private static final PageElement firstNameFld = new PageElement(
            "First Name Field",
            By.cssSelector("input[data-ng-model='new_user.first_name']"),
            true);
    private static final PageElement lastNameFld = new PageElement(
            "Last Name Field",
            By.cssSelector("input[data-ng-model='new_user.last_name']"),
            true);
    private static final PageElement primaryExtensionFld = new PageElement(
            "Primary Extension Field",
            By.cssSelector("input[data-ng-model='new_user.extension']"),
            true);
    private static final PageElement userEmailFld = new PageElement(
            "Username/Email Field",
            By.cssSelector("input[data-ng-model='new_user.username']"),
            true);
    private static final PageElement jobTitleFld = new PageElement(
            "Job Title Field",
            By.cssSelector("input[data-ng-model='new_user.role']"),
            true);
    private static final PageElement createUserBtn = new PageElement(
            "Create user button",
            By.cssSelector("button[class='btn btn-success']"),
            true);
    private static final PageElement generatePasswordChb = new PageElement(
            "Generate Password Checkbox",
            By.xpath("//span[contains(text(),'Generate Password?')]"),
            false);
    private static final PageElement newPasswordFld = new PageElement(
            "Password Field",
            By.cssSelector("input[data-ng-model='new_user.password']"),
            false);
    private static final PageElement confirmPasswordFld = new PageElement(
            "Confirm Password Field",
            By.cssSelector("input[data-ng-model='new_user.confirm_password']"),
            false);
    private static final PageElement homeBtn = new PageElement(
            "Home button",
            By.cssSelector("ng-include > form > button.btn.btn-primary"),
            true);
    private static final PageElement mobileNumberFld = new PageElement(
            "Mobile Number filed",
            By.cssSelector("input[data-ng-model='new_user.phone']"),
            true);


    public AddUsersPage(WebDriver driver){
        super(driver);
    }

    @Override
    public boolean pageIsDisplayed(){
        return allRequiredElementDisplayed();
    }


    public void fillFirstName(String firstName){
        enterText(firstNameFld, firstName);
    }

    public void fillLastName(String lastName){
        enterText(lastNameFld, lastName);
    }

    public void fillPrimaryExtensionFld(String primaryExtension){
        enterText(primaryExtensionFld, primaryExtension);
    }

    public void fillUserEmailFld(String userEmail){
        enterText(userEmailFld, userEmail);
    }

    public void fillJobTitleFld(String jobTitle){
        enterText(jobTitleFld, jobTitle);
    }

    public void fillPasswordFld(String newPassword){
        enterText(newPasswordFld, newPassword);
    }

    public void fillConfirmPasswordFld(String confirmPassword){
        enterText(confirmPasswordFld, confirmPassword);
    }

    public void fillMobilenumberFld(String mobileNumber){
        enterText(mobileNumberFld, mobileNumber);
    }

    public void selectCheckbox(PageElement element, boolean isNeedToChecked){
        PageElement hiddenLyt = new PageElement(
                "Hidden password layot",
                By.cssSelector("div[ng-hide='new_user.generate_password']"));

        if (getAttribute(hiddenLyt, "class").contains("row") && !isNeedToChecked) {
            click(element);
            log.info("Element is " + element.name + " is checked");
        } else
            log.info("Element is " + element.name + " is unchecked");

    }

    public void createNewUser(UserDataObject userDataObject){
        PageElement findAvailable = new PageElement(
                "Find Available number",
                By.cssSelector("a[id='helpfulArrow']>i"));
        PageElement existPrimaryExtension = new PageElement(
                "Change field for exist Primary Extension",
                By.cssSelector("span[id='dangerTriangle']"));
        waitToBeClickable(homeBtn);
        fillFirstName(userDataObject.Username);
        fillLastName(userDataObject.Username);
        fillPrimaryExtensionFld(userDataObject.PrimaryExtension);
        waitUntilPageLoad();
        if (getAttribute(existPrimaryExtension, "style").equals("display: inline;")) {
            click(findAvailable);
            String newPrimaryExtension = getAttribute(primaryExtensionFld, "value");
            userDataObject.PrimaryExtension = newPrimaryExtension;
        }
        fillUserEmailFld(userDataObject.UserEmail);
        fillJobTitleFld(userDataObject.JobTitle);
        fillMobilenumberFld(userDataObject.MobileNumber);
        selectCheckbox(generatePasswordChb, false);
        fillPasswordFld(userDataObject.NewPassword);
        fillConfirmPasswordFld(userDataObject.ConfirmPassword);
        click(createUserBtn);
        waitUntilPageLoad();
    }
}
