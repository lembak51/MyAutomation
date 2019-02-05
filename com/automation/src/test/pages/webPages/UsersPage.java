package pages.webPages;


import common.PageElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UsersPage extends BasePage {
    private static final PageElement addUserBtn = new PageElement(
            "Add new User button",
            By.cssSelector("button[ng-click ='addUser()']"),
            true);



    UsersPage(WebDriver driver){
        super(driver);
    }

    @Override
    public boolean pageIsDisplayed(){
        return allRequiredElementDisplayed();
    }
    public void clickAddUserBtn(){
        waitToBeClickable(addUserBtn);
        click(addUserBtn);
    }
}
