package pages.webPages;

import common.PageElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import tests.BaseTest;

public class CreateNewFanPage extends BasePage{

    private static final PageElement firstNameField = new PageElement(
            "First name field ",
            By.xpath("//input[contains(@placeholder,'First Name')]"),
            true);

    private static final PageElement lastNameField = new PageElement(
            "Last name field ",
            By.xpath("//input[contains(@placeholder,'Last Name')]"),
            true);

    private static final PageElement emailField = new PageElement(
            "Email name field ",
            By.xpath("//input[contains(@placeholder,'Email')]"),
            true);

    private static final PageElement passwordField = new PageElement(
            "Password name field ",
            By.xpath("//input[contains(@placeholder,'Password')]"),
            true);

    private static final PageElement phoneField = new PageElement(
            "Phone name field ",
            By.xpath("//input[contains(@placeholder,'Phone')]"),
            true);

    private static final PageElement twiterField = new PageElement(
            "Twitter name field ",
            By.xpath("//input[contains(@placeholder,'Twitter')]"),
            true);

    private static final PageElement createFanButton = new PageElement(
            "Create/Update Fan Button ",
            By.xpath("//button[contains(@class,'variant-contained MuiButton-contained MuiButton-containedSecondary')]"),
            true);

    private static final PageElement stateDropDown = new PageElement(
            "State drop-down list ",
            By.xpath("//body/div[@id='root']/div[contains(@class,'wrapper')]/div[contains(@class,'wrapper-content')]/div[contains(@class,'q-panel-container q-panel-container color-default q-panel-toggled')]/div[contains(@class,'')]/div[contains(@class,'form-wrapper edit-mode')]/div[contains(@class,'form-group')]/div[10]/div[1]"),
            true);

    private static final PageElement alaskaState = new PageElement(
            "Select alaska state",
            By.xpath(".//div[contains(text(),'Alaska')]"),
            false);


    private static final PageElement cityDropDown = new PageElement(
            "City drop-down lists",
            By.xpath("//body/div[@id='root']/div[contains(@class,'wrapper')]/div[contains(@class,'wrapper-content')]/div[contains(@class,'q-panel-container q-panel-container color-default q-panel-toggled')]/div[contains(@class,'')]/div[contains(@class,'form-wrapper edit-mode')]/div[contains(@class,'form-group')]/div[12]/div[1]"),
            false);

    private static final PageElement adakCity = new PageElement(
            "Select alaska state",
            By.xpath(".//div[contains(text(),'Adak')]"),
            false);


    private static final PageElement schoolDropDown = new PageElement(
            "School drop-down lists",
            By.xpath("//body/div[@id='root']/div[contains(@class,'wrapper')]/div[contains(@class,'wrapper-content')]/div[contains(@class,'q-panel-container q-panel-container color-default q-panel-toggled')]/div[contains(@class,'')]/div[contains(@class,'form-wrapper edit-mode')]/div[contains(@class,'form-group')]/div[14]/div[1]"),
            false);

    private static final PageElement testSchool = new PageElement(
            "Select alaska state",
            By.xpath(".//div[contains(text(),'test school 1 for v2')]"),
            false);

    private static final PageElement dateFlld = new PageElement(
            "Date field ",
            By.xpath("//input[contains(@class,'form-control')]"),
            false);

    private static final PageElement monthAndYear = new PageElement(
            "Button month and years in data picker ",
            By.xpath("//th[contains(@class,'rdtSwitch')]"),
            false);

    private static final PageElement year2022 = new PageElement(
            "2022 year in data picker ",
            By.xpath("//td[contains(text(),'2022')]"),
            false);

    private static final PageElement monthDec = new PageElement(
            "December month in data picker ",
            By.xpath("//td[contains(text(),'Dec')]"),
            false);

    private static final PageElement number31 = new PageElement(
            "number 31 in data picker ",
            By.xpath("//td[contains(text(),'31')]"),
            false);
    public CreateNewFanPage(WebDriver driver) {super(driver);}

    @Override
    public boolean pageIsDisplayed() {
        return allRequiredElementDisplayed();
    }
    public void selecktAlaskState(){
        click(stateDropDown);
        waitToBeClickable(alaskaState);
        click(alaskaState);
    }
    public void fillFirstName(String strFirstName){
        enterText(firstNameField, strFirstName);
    }
    public void fillLastName(String strLastName){
        enterText(lastNameField, strLastName);
    }
    public void fillEmail(String strEmail){
        enterText(emailField, strEmail);
    }
    public void fillPassword(String strPassword){
        enterText(passwordField, strPassword);
    }
    public void fillPhone(String strPhone){
        enterText(phoneField, strPhone);
    }
    public void fillTwiter(String strTwiter){
        enterText(twiterField, strTwiter);
    }


    public void selecktAdakCity(){
        click(cityDropDown);
        waitToBeClickable(adakCity);
        click(adakCity);
    }

    public void seleckSchool(){
        click(schoolDropDown);
        waitToBeClickable(testSchool);
        click(testSchool);
    }
    public void selectDate (){
        click(dateFlld);
        click(monthAndYear);
        click(monthAndYear);
        click(year2022);
        click(monthDec);
        click(number31);
    }
    public void clickOnCreateUpdateButton (){
    click(createFanButton);
    waitJsLoad();
    waitUntilPageLoad(2,true,true,true,true);
    }
    public void fillAllfield(String strFirstName, String strLastName, String strEmail, String strPassword, String strPhone, String strTwiter){
        fillFirstName(strFirstName);
        fillLastName(strLastName);
        waitJsLoad();
        fillEmail(strEmail);
        waitJsLoad();
        fillPassword(strPassword);
        fillPhone(strPhone);
        fillTwiter(strTwiter);
    }

    public void updateEmail(String strEmail){
        fillEmail(strEmail);
        clickOnCreateUpdateButton();
    }
}
