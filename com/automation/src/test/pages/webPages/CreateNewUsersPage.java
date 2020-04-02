package pages.webPages;

import common.PageElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateNewUsersPage extends BasePage {
    private static final PageElement firstField = new PageElement(
            "First name  field",
            By.xpath("//input[@placeholder='First Name']"),
            true);


    private static final PageElement lastField = new PageElement(
            "Last name field ",
            By.xpath("//input[@placeholder='Last Name']"),
            true);

    private static final PageElement emailField = new PageElement(
            "Email field ",
            By.xpath("//input[@placeholder='Email']"),
            true);

    private static final PageElement usernameField = new PageElement(
            "Username field ",
            By.xpath("//input[@placeholder='Username']"),
            true);

    private static final PageElement passwordField = new PageElement(
            "Password field ",
            By.xpath("//input[@placeholder='Password']"),
            true);

    private static final PageElement createUserBttn = new PageElement(
            "Create Users Button ",
            By.xpath("//button[contains(@class,'variant-contained MuiButton-contained MuiButton-containedSecondary')]"),
            true);


    public CreateNewUsersPage(WebDriver driver) {super(driver);}
    public void fillFirstName(String strFirstName){
        enterText(firstField, strFirstName);
    }
    public void fillLastField(String strLastField){
        enterText(lastField, strLastField);
    }
    public void fillEmail(String strEmailField){
        enterText(emailField, strEmailField);
    }
    public void fillUsername(String strUsernameField){
        enterText(usernameField, strUsernameField);
    }
    public void fillPassword(String strPassword){
        enterText(passwordField, strPassword);
    }
    @Override
    public boolean pageIsDisplayed() {
        return allRequiredElementDisplayed();
    }

    public void createNewAdmin(String FirstName, String LastField, String EmailField, String UsernameField, String Password){
        fillFirstName(FirstName);
        waitJsLoad();
        fillLastField(LastField);
        waitJsLoad();
        fillEmail(EmailField);
        waitJsLoad();
        fillUsername(UsernameField);
        waitJsLoad();
        fillPassword(Password);
        waitJsLoad();
        click(createUserBttn);
        waitJsLoad();
    }
    public void editUsernameAdmin(String newUsernameField){
        fillUsername(newUsernameField);
        click(createUserBttn);
        waitJsLoad();
    }

    public void editPassword(String newPassword){
        fillPassword(newPassword);
        click(createUserBttn);
        waitJsLoad();
        waitUntilPageLoad(1);
    }

}

