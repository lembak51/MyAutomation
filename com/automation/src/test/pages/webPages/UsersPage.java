package pages.webPages;


import common.PageElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UsersPage extends BasePage {
    private static final PageElement createUserBtn = new PageElement(
            "Create new User button",
            By.xpath("//button[contains(@class,'variant-contained MuiButton-contained MuiButton-containedSecondary')]"),
            true);


    private static final PageElement emailField = new PageElement(
            "Email search field",
            By.xpath("//div[4]//input[1]"),
            true);
    //div[4]//input[1]

    //button[contains(@class,'color-inherit')]
    //button[contains(@class,'variant-contained MuiButton-contained MuiButton-containedPrimary')]

    private static final PageElement yesButton = new PageElement(
            "Yes button in modal confirm window",
            By.xpath("//button[contains(@class,'variant-contained MuiButton-contained MuiButton-containedPrimary')]"),
            false);

    private static final PageElement deleteButton = new PageElement(
            "Delete button",
            By.cssSelector("div.wrapper div.wrapper-content div.q-panel-container.q-panel-container.color-default.q-panel-toggled div.q-panel-body div.ReactTable.firstTDPadding.-striped.-highlight:nth-child(3) div.rt-table div.rt-tbody:nth-child(3) div.rt-tr-group div.rt-tr.-odd div.rt-td:nth-child(5) > button.MuiButtonBase-root.MuiIconButton-root.icon-button.color-inherit"),
            false);

    //div[@class='-pageJump']//input
    private static final PageElement pageJumpButton = new PageElement(
            "Field number page",
            By.xpath("//div[@class='-pageJump']//input"),
            true);

    private static final PageElement userNameField = new PageElement(
            "Username field",
            By.xpath("//div[contains(@class,'rt-tr')]//div[1]//input[1]"),
            true);


    public UsersPage(WebDriver driver){
        super(driver);
    }
    public boolean adminIsDisplayedInList(String strUsername){
        PageElement admin = new PageElement(
                "New admin in the list",
                By.xpath("//div[contains(text(),'" + strUsername + "')]"),
                false);
        return isElementPresent(admin);
    }


    public void openNewAdmin(String strUsername){
        PageElement admin = new PageElement(
                "New admin in the list",
                By.xpath("//div[contains(text(),'" + strUsername + "')]"),
                false);
        click(admin);
    }

    public boolean editedAdminIsDisplayedInList(String strUsername){
        PageElement admin = new PageElement(
                "New admin in the list",
                By.xpath("//div[contains(text(),'" + strUsername + "')]"),
                false);
        return isElementPresent(admin);
    }
    public boolean deleteAdminIsNotDisplayedInList(String strUsername){
        PageElement admin = new PageElement(
                "New admin in the list",
                By.xpath("//div[contains(text(),'" + strUsername + "')]"),
                true);
        return isElementPresent(admin);
    }
    @Override
    public boolean pageIsDisplayed(){
        return allRequiredElementDisplayed();
    }
    public void goToCreateusersPage(){
        click(createUserBtn);
    }
    public void searchByEmail(String email){
        enterText(emailField, email);
        waitUntilPageLoad(3, true, true, true,true);
    }

    public void deleteAdmin (){
        click(deleteButton);
        waitToBeClickable(yesButton,5);
        click(yesButton);
        waitToBeClickable( pageJumpButton,5);
        waitUntilPageLoad(3, true, true, true,true);
    }

    public void searchByUsername(String username){

        waitToBeClickable(userNameField,5);
        enterText(userNameField, username);
        waitUntilPageLoad(1, true, true, true,true);
    }
}

