package pages.webPages;

import common.Config;
import common.PageElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class DashboardPage extends BasePage {

  /*  private final static PageElement userProfileDdb = new PageElement(
            "User Profile Drop Down",
            By.cssSelector("li[class='dropdown text-normal nav-profile']"),
            true);

   */
    private final static PageElement logoutBtn = new PageElement(
            "Logout button",
            By.xpath("//*[@id=\"root\"]/div/header/div/div/button[2]"),
            true);
    private final static PageElement goToCoachesList = new PageElement(
            "Coaches button",
            By.xpath("//*[@id=\"root\"]/div/header/div/button[3]"),
            true);
    private final static  PageElement schoolsBttn = new PageElement(
            "School iten menu",
            By.xpath("//span[contains(text(),'Schools')]"),
            true);
    //*[@id="root"]/div/div/div/div[2]/div/div[2]/div/div[2]/span[1]/div/input

    //body//button[5]
    private final static  PageElement UsersBttn = new PageElement(
            "Users button item menu",
            By.xpath("//body//button[5]"),
            true);
//body//button[6]
    private final static  PageElement FansBttn = new PageElement(
        "Fans button",
        By.xpath("//body//button[6]"),
        true);



    private final static  PageElement stateUsersBttn = new PageElement(
            "State Users button",
            By.xpath("//body//button[7]"),
            true);


    private final static  PageElement coacheVoteBttn = new PageElement(
            "Coaches Vote button",
            By.xpath("//body//button[8]"),
            true);


    public DashboardPage(WebDriver driver) {
        super(driver);
    }
    public void logout(){
        waitToBeVisible(logoutBtn);
        click(logoutBtn);


    }
    public void goToCoachesList(){

        waitToBeVisible(goToCoachesList);
        click(goToCoachesList);
      //waitToBePresent(numberPage,15);;


    }
    public void goToSchoolList(){
        waitToBeVisible(schoolsBttn);
        click(schoolsBttn);
    }

    public void goToFanList(){
        waitToBeVisible(FansBttn);
        click(FansBttn);
    }




    public void goToUsersList(){
        waitToBeVisible(UsersBttn);
        click(UsersBttn);
    }
    public void goToStateUsersList(){
        waitToBeVisible(stateUsersBttn);
        click(stateUsersBttn);
    }

    public void goToCoacheVoteList(){
        waitToBeVisible(coacheVoteBttn);
        click(coacheVoteBttn);
    }


    @Override


        public boolean pageIsDisplayed() {
            waitUntilPageLoad();
            return allRequiredElementDisplayed();
        }








}