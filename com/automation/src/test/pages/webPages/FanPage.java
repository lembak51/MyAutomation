package pages.webPages;

import common.PageElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FanPage extends BasePage {
    private static final PageElement createFanBttn = new PageElement(
            "Create Fan button",
            By.xpath("//button[contains(@class,'variant-contained MuiButton-contained MuiButton-containedSecondary')]"),
            true);

    private static final PageElement emailSearchField = new PageElement(
            "Email search",
            By.xpath("//div[4]//input[1]"),
            true);

    private static final PageElement newFanInList = new PageElement(
            "New fan after search",
            By.xpath("//div[@class='rt-tr -odd']"),
            false);


    private static final PageElement deleteButton = new PageElement(
            "Delete fan button",
            By.xpath("//button[contains(@class,'color-inherit')]"),
            false);
//button[contains(@class,'variant-contained MuiButton-contained MuiButton-containedPrimary')]

    private static final PageElement yesButton = new PageElement(
            "Yes button in modal window",
            By.xpath("//button[contains(@class,'variant-contained MuiButton-contained MuiButton-containedPrimary')]"),
            false);

    private static final PageElement numberPageField = new PageElement(
            "jump to page field",
            By.xpath("//div[contains(@class,'-pageJump')]//input"),
            false);

    //div[contains(@class,'-pageJump')]//input

    public FanPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean pageIsDisplayed() {
        return allRequiredElementDisplayed();
    }

    public void goToCreateFan(){
        click(createFanBttn);
    }
    public void searchSchool(String strEmail){
        enterText(emailSearchField, strEmail);
        waitUntilPageLoad(3,true,true,true,true);
    }


    public boolean fanIsDisplayedInList(String strEmail){
        enterText(emailSearchField, strEmail);
        waitUntilPageLoad(3,true,true,true,true);
        PageElement fan = new PageElement(
                "New school in the list",
                By.xpath("//div[contains(text(),'" + strEmail + "')]"),
                true);
        return isElementPresent(fan);
    }

    public void  clickOnNewFan(){
        click(newFanInList);


    }
    public void  deleteNewFan() {
        click(deleteButton);
        waitJsLoad();
        click(yesButton);
        waitJsLoad();
        waitUntilPageLoad(3,true,true,true,true);
    }

    }
