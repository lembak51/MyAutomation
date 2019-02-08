package pages.webPages;


import common.PageElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UsersPage extends BasePage {
    private static final PageElement addUserBtn = new PageElement(
            "Add new User button",
            By.cssSelector("button[ng-click ='addUser()']"),
            true);
    private static final PageElement usersCount = new PageElement(
            "User count",
            By.cssSelector("h4[class='text-primary ng-binding ng-scope']"),
            true);


    public UsersPage(WebDriver driver){
        super(driver);
    }

    @Override
    public boolean pageIsDisplayed(){
        return allRequiredElementDisplayed();
    }

    public void clickAddUserBtn(){
        waitToBeClickable(addUserBtn);
        click(addUserBtn);
        if (isElementPresent(usersCount)) {
            click(addUserBtn);
        }
    }
}
