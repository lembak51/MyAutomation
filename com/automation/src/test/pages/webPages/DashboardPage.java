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

    public DashboardPage(WebDriver driver){
        super(driver);
    }

    @Override
    public boolean pageIsDisplayed(){
        waitToBePresent(userProfileDdb);
        return allRequiredElementDisplayed();
    }

    public void logout(){
        waitUntilPageLoad();
        waitToBeClickable(userProfileDdb);
        click(userProfileDdb);
        waitToBeClickable(logoutBtn);
        click(logoutBtn);
    }
}
