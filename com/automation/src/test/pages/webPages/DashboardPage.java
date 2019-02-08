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
    private static final PageElement phonebookBtn = new PageElement(
            "Phonebook button",
            By.cssSelector("li[ng-show='user.navigation.pages_phonebook']"),
            true);

    public DashboardPage(WebDriver driver){
        super(driver);
    }

    @Override
    public boolean pageIsDisplayed(){
        waitUntilPageLoad(1);
        return allRequiredElementDisplayed();
    }

    public void logout(){
        waitUntilPageLoad();
        waitToBeClickable(userProfileDdb);
        click(userProfileDdb);
        waitToBeClickable(logoutBtn);
        click(logoutBtn);
    }

    public void openPhonebookPage(){
        waitToBeClickable(phonebookBtn);
        click(phonebookBtn);
    }
}
