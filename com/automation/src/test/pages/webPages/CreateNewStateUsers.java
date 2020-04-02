package pages.webPages;

import common.PageElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateNewStateUsers extends BasePage {


    private static final PageElement firstNameField = new PageElement(
            "First Name field",
            By.xpath("//input[contains(@placeholder,'First Name')]"),
            true);


    private static final PageElement lastNameField = new PageElement(
            "Last Name field",
            By.xpath("//input[contains(@placeholder,'Last Name')]"),
            true);

    private static final PageElement emailField = new PageElement(
            "Email field",
            By.xpath("//input[contains(@placeholder,'Email')]"),
            true);

    private static final PageElement phoneField = new PageElement(
            "Phone field",
            By.xpath("//input[contains(@placeholder,'Phone')]"),
            true);


    private static final PageElement passwordField = new PageElement(
            "Password field",
            By.xpath("//input[contains(@placeholder,'Password')]"),
            true);


    private static final PageElement twitterField = new PageElement(
            "Twiter field",
            By.xpath("//input[contains(@placeholder,'Twitter')]"),
            true);


    private static final PageElement createStateUsersButton = new PageElement(
            "Create update state users button",
            By.xpath("//button[contains(@class,'variant-contained MuiButton-contained MuiButton-containedSecondary')]"),
            true);

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


    private static final PageElement stateDropDown = new PageElement(
            "State drop-down list ",
            By.xpath("//body/div[@id='root']/div[contains(@class,'wrapper')]/div[contains(@class,'wrapper-content')]/div[contains(@class,'q-panel-container q-panel-container color-default q-panel-toggled')]/div[contains(@class,'')]/div[contains(@class,'form-wrapper edit-mode')]/div[contains(@class,'form-group')]/div[10]/div[1]"),
            true);

    private static final PageElement alaskaState = new PageElement(
            "Select alaska state",
            By.xpath(".//div[contains(text(),'Alaska')]"),
            false);

    public CreateNewStateUsers(WebDriver driver) {
        super(driver);
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
        enterText(twitterField, strTwiter);
    }
    @Override
    public boolean pageIsDisplayed() {
        return allRequiredElementDisplayed();
    }

    public void selecktAlaskState(){
        click(stateDropDown);
        waitToBeClickable(alaskaState);
        click(alaskaState);
    }

    public void selectDate (){
        click(dateFlld);
        click(monthAndYear);
        click(monthAndYear);
        click(year2022);
        click(monthDec);
        click(number31);
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

    public void clickOnCreateUpdateButton (){
        click(createStateUsersButton);
        waitJsLoad();
        waitUntilPageLoad(2,true,true,true,true);
    }
    public void updateEmail (String strEmail){
        fillEmail(strEmail);
        click(createStateUsersButton);
        waitUntilPageLoad(2,true,true,true,true);
    }
}
