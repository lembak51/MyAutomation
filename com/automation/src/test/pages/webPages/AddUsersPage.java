package pages.webPages;

import common.PageElement;
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
    private static final  PageElement createUserBtn = new PageElement(
            "Create user nutton",
            By.cssSelector("button[class='btn btn-success']"),
            true);
    private static final  PageElement generatePasswordChb = new PageElement(
            "Generate Password Checkbox",
            By.cssSelector("input[data-ng-model='new_user.generate_password']"),
            true);
    private static final PageElement newPasswordFld = new PageElement(
            "Password Field",
            By.cssSelector("input[data-ng-model='new_user.password']"),
            false);
    private  static  final  PageElement confirmPasswordFld = new PageElement(
            "Confirm Password Field",
            By.cssSelector("input[data-ng-model='new_user.confirm_password']"),
            false);


    public AddUsersPage(WebDriver driver){
        super(driver);
    }

    @Override
    public boolean pageIsDisplayed(){
        return allRequiredElementDisplayed();
    }


    public void fillFirstName(String firstName) {
        enterText(firstNameFld, firstName);
    }
    public void fillLastName(String lastName) {
        enterText(lastNameFld, lastName);
    }
    public void fillPrimaryExtensionFld(String primaryExtension) {
        enterText(primaryExtensionFld, primaryExtension);
    }
    public void fillUserEmailFld(String userEmail) {
        enterText(userEmailFld, userEmail);
    }
    public void fillJobTitleFld(String jobTitle){
        enterText(jobTitleFld,jobTitle);
    }
    public void fillPasswordFld(String newPassword){
        enterText(newPasswordFld,newPassword);
    }
    public void fillConfirmPasswordFld(String confirmPassword){
        enterText(confirmPasswordFld,confirmPassword);
    }

    public void createNewUser(String firstName, String lastName, String primaryExtension,String userEmail, String jobTitle, String newPassword, String confirmPassword){
        waitUntilPageLoad();
        fillFirstName(firstName);
        fillLastName(lastName);
        fillPrimaryExtensionFld(primaryExtension);
        fillUserEmailFld(userEmail);
        fillJobTitleFld(jobTitle);
        click(generatePasswordChb);
        fillPasswordFld(newPassword);
        fillConfirmPasswordFld(confirmPassword);
        click(createUserBtn);
    }
}
