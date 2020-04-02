package pages.webPages;

import common.PageElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StateUsersPage extends BasePage {

    private static final PageElement createStateUsers = new PageElement(
            "Create State Users button",
            By.xpath("//button[contains(@class,'variant-contained MuiButton-contained MuiButton-containedSecondary')]"),
            true);


    private static final PageElement emailSearchField = new PageElement(
            "Email search",
            By.xpath("//div[4]//input[1]"),
            true);
//div[@class='rt-tr -odd']

    private static final PageElement stateUsersAfterSearch = new PageElement(
            "Email Field ",
            By.xpath("//div[@class='rt-tr -odd']"),
            false);

    //button[contains(@class,'color-inherit')]

    private static final PageElement deleteStateUsersBttn = new PageElement(
            "Delete state Users button",
            By.xpath("//button[contains(@class,'color-inherit')]"),
            false);

    private static final PageElement yesBttn = new PageElement(
            "Yes button",
            By.xpath("//button[contains(@class,'variant-contained MuiButton-contained MuiButton-containedPrimary')]"),
            false);

    private static final PageElement nextPageBttn = new PageElement(
            "Pagination next button",
            By.xpath("//div[contains(@class,'-next')]//button[1]"),
            false);
    public StateUsersPage(WebDriver driver) {
        super(driver);
    }
    public void fillEmail(String strEmailField){
        enterText(emailSearchField, strEmailField);
    }

    @Override
    public boolean pageIsDisplayed() {
        return allRequiredElementDisplayed();
    }
    public void searchEmail(String strEmailField){
        fillEmail(strEmailField);
        waitUntilPageLoad(3,true,true,true,true);
    }
    public void goToCreateStateUsersPage(){
        click(createStateUsers);
    }
    public boolean stateUsersIsDisplayedInList(String strEmail){
        enterText(emailSearchField, strEmail);
        waitUntilPageLoad(3,true,true,true,true);
        PageElement stateUsers = new PageElement(
                "New school in the list",
                By.xpath("//div[contains(text(),'" + strEmail + "')]"),
                true);
        return isElementPresent(stateUsers);
    }
    public void clickOnStateUsersAfterSearch(){
        click(stateUsersAfterSearch);
        waitJsLoad();
    }

    public void deleteStateUsers(){
        click(deleteStateUsersBttn);
        waitJsLoad();
        click(yesBttn);
        waitToBeClickable(nextPageBttn);

    }

}
