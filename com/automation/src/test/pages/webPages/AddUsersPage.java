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


    AddUsersPage(WebDriver driver){
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
}
