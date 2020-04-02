package pages.webPages;

import common.PageElement;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class SchoolListPage extends BasePage {
    private static final PageElement createSchoolBttn = new PageElement(
            "Create School Bttn",
            By.xpath("//button[contains(@class,'variant-contained MuiButton-contained MuiButton-containedSecondary')]"),
            true);
    private static final  PageElement stateDropDown = new PageElement(
            "State drop-down list",
            By.xpath("//body/div[@id='root']/div[contains(@class,'wrapper')]/div[contains(@class,'wrapper-content')]/div[contains(@class,'q-panel-container q-panel-container color-default q-panel-toggled')]/div[contains(@class,'')]/div[contains(@class,'form-wrapper edit-mode')]/div[contains(@class,'form-group')]/div[2]/div[1]"),
           true);
    private static final  PageElement cityDropDown = new PageElement(
            "City drop-down list",
            By.xpath("//body/div[@id='root']/div[contains(@class,'wrapper')]/div[contains(@class,'wrapper-content')]/div[contains(@class,'q-panel-container q-panel-container color-default q-panel-toggled')]/div[contains(@class,'')]/div[contains(@class,'form-wrapper edit-mode')]/div[contains(@class,'form-group')]/div[4]/div[1]/div[1]"),
           true);
    private static final PageElement alaskaState = new PageElement(
            "Select alaska state",
            By.xpath(".//*[contains(text(),'Alaska')]"),
            false);
    private static final PageElement adakCity = new PageElement(
            "Select alaska state",
            By.xpath(".//*[contains(text(),'Adak')]"),
            false);
    private static final PageElement schoolNameFld = new PageElement(
            "Search School Name",
            By.xpath("//div[contains(@class,'rt-tr')]//div[1]//input[1]"),
            false);

    private static final PageElement pageFld = new PageElement(
            "Page field",
            By.xpath("//div[contains(@class,'-pageJump')]//input"),
            false);

    //button[contains(@class,'color-inherit')]

    private static final PageElement deleteBttn = new PageElement(
            "Delete button school",
            By.xpath("//button[contains(@class,'color-inherit')]"),
            false);
    private static final PageElement yesBttn = new PageElement(
            "Yes button in modal window ",
            By.xpath("//button[contains(@class,'variant-contained MuiButton-contained MuiButton-containedPrimary')]"),
            false);
    private final static PageElement logoutBtn = new PageElement(
            "Logout button",
            By.xpath("//*[@id=\"root\"]/div/header/div/div/button[2]"),
            true);

    private final static PageElement emptySchoolList = new PageElement(
            "Empty school list",
            By.xpath("//div[contains(@class,'rt-noData')]"),
            false);

    //div[contains(@class,'rt-tr -odd')]
    private final static PageElement schoolInList = new PageElement(
            "Element in the school list",
            By.xpath("//div[contains(@class,'rt-tr -odd')]"),
            false);



    public SchoolListPage(WebDriver driver) {
        super(driver);
    }
    public void goToCreateSchoolPage(){
        click(createSchoolBttn);
    }

    public void fillSearchSchoolName (String strSchoolName){
        enterText(schoolNameFld, strSchoolName);
    }
    public boolean schoolIsDisplayedInList(String strSchoolName){
        PageElement school = new PageElement(
                "New school in the list",
                By.xpath("//div[contains(text(),'" + strSchoolName + "')]"),
        true);
        return isElementPresent(school);
    }

    public void searchSchool(String SchoolName){
        waitToBePresent(pageFld,15);
        fillSearchSchoolName(SchoolName);
        waitToBePresent(pageFld,15);

    }
    public void deletSchool(){
        click(deleteBttn);
        click(yesBttn);
        waitToBePresent(emptySchoolList);
    }
    public void clickOnSchool(){
       waitUntilPageLoad(5, true, true, true, true);
        click(schoolInList);

    }


    //div[contains(text(),'QA_Auto_Test46655')]
    @Override
    public boolean pageIsDisplayed() {
        waitUntilPageLoad();
        return allRequiredElementDisplayed();
    }

}
