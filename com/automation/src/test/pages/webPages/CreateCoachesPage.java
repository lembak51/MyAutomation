package pages.webPages;

import common.PageElement;
import common.dataObjects.UserDataObject;
import io.appium.java_client.windows.PressesKeyCode;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import java.security.Key;

public class CreateCoachesPage extends BasePage {
    private static final PageElement firstNameFld = new PageElement(
            "Field First Name",
            By.xpath("//input[contains(@placeholder,'First Name')]"),
            true);
    private static final PageElement lastNameFld = new PageElement(
            "Field Last Name",
            By.xpath("//input[contains(@placeholder,'Last Name')]"),
            true);
    private static final PageElement addressFld = new PageElement(
            "Field Address",
            By.xpath("//input[contains(@placeholder,'Address')]"),
            true);

    private static final PageElement maleGenderRadioBttn = new PageElement(
            "Male gender radio button",
            By.xpath("//span[contains(text(),'Male')]"),
            true);

    private static final PageElement femaleGenderRadioBttn = new PageElement(
            "Female gender radio button",
            By.xpath("//span[contains(text(),'Female')]"),
            true);

    private static final PageElement coedGenderRadioBttn = new PageElement(
            "coed gender radio button",
            By.xpath("//span[contains(text(),'Coed')]"),
            true);

    private static final PageElement phoneFld = new PageElement(
            "Phone field",
            By.xpath("//input[contains(@placeholder,'Phone')]"),
            true);

    private static final PageElement emailFld = new PageElement(
            "Email field",
            By.xpath("//input[contains(@placeholder,'Email')]"),
            true);

    private static final PageElement passwordFld = new PageElement(
            "Password field",
            By.xpath("//input[contains(@placeholder,'Password')]"),
            true);
    private static final PageElement stateDropdown = new PageElement(
            "Drop down list with state",
            By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div/div/div[16]/div/div/div[1]"),
            true);
    private static final PageElement alaskaState = new PageElement(
            "Select alaska state",
            By.xpath(".//div[contains(text(),'Alaska')]"),
            false);
    private static final PageElement male = new PageElement(
            "Select alaska state",
            By.xpath(".//div[contains(text(),'Male')]"),
            false);


    private static final PageElement schoolFlld = new PageElement(
            "School name field",
            By.xpath("//input[@id='react-select-10-input']"),
            true);

    private static final PageElement forclickschoolFlld = new PageElement(
            "School name field",
            By.xpath("//body/div[@id='root']/div[contains(@class,'wrapper')]/div[contains(@class,'wrapper-content')]/div[contains(@class,'q-panel-container q-panel-container color-default q-panel-toggled')]/div[contains(@class,'')]/div[contains(@class,'form-wrapper edit-mode')]/div[contains(@class,'form-group')]/div[20]/div[1]"),
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

    private static final PageElement divisionFld = new PageElement(
            "Division Field",
            By.xpath("//input[contains(@placeholder,'Division')]"),
            true);
    private static final PageElement createCoachBttn= new PageElement(
            "Create coach button",
            By.xpath("//span[contains(text(),'Create Coach')]"),
            true);
    private static final PageElement cityDropdown = new PageElement(
            "Ciry drop down",
            By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[18]/div[1]/div[1]"),
            true);

    private static final PageElement adakCity = new PageElement(
            "Select Adak City",
            By.xpath(".//div[contains(text(),'Adak')]"),
            false);
    private static final PageElement updateCoachBttn= new PageElement(
            "Create coach button",
            By.xpath("//span[contains(text(),'Update Coach')]"),
            true);
    //div[contains(text(),'Alaska')]

    //td[contains(@class,'rdtMonth rdtActive')]

    public CreateCoachesPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean pageIsDisplayed() {
        return allRequiredElementDisplayed();
    }
    public void fiellFieldsCredentials(String EmailCoach, String Password){
        enterText( emailFld, EmailCoach);
        enterText( passwordFld, Password);

}
    public void fillAdditionField(String FirstName, String LastName, String Address, String Division, String Phone){
        enterText( firstNameFld, FirstName);
        enterText( lastNameFld, LastName);
        enterText( addressFld, Address);
        enterText( divisionFld, Division);
        enterText( phoneFld , Phone);
    }
    public void fillFieldSchool(String Schoolname){
        enterText( schoolFlld, Schoolname);
    }
    public  void clickOnName (String strSchoolName) {
        PageElement nameSchool = new PageElement(
                " School in the list",
                By.xpath("//div[contains(text(),'" + strSchoolName + "')]"),
                true);
        click(nameSchool);
    }
    public void selectAlaskaState()  {
        click(stateDropdown);
        waitToBeClickable(alaskaState);
        click(alaskaState);

    }
    public void selectAdakCity(String SchoolName){
        click(cityDropdown);
        click(adakCity);
        click( forclickschoolFlld);
//        fillFieldSchool(SchoolName);
        clickOnName(SchoolName);


    }
    public void clickonGenderCoed (){
        click(coedGenderRadioBttn);
    }

    public void clickonGenderMale(){
        click(maleGenderRadioBttn);
    }
    public void clickonGenderFemale(){
        click(femaleGenderRadioBttn);
    }


    public void selectDate (){
        click(dateFlld);
        click(monthAndYear);
        click(monthAndYear);
        click(year2022);
        click(monthDec);
        click(number31);
    }
    public void additionFeld(String FirstName, String LastName, String Address, String Division, String Phone){
       fillAdditionField(FirstName, LastName, Address, Division,  Phone);
    }
    public void ceateCoach(){
    click(createCoachBttn);
    waitUntilPageLoad(5, true, true, true, true);
    }

    public void editFirstLastName(String FirstName, String LastName){
        enterText( firstNameFld, FirstName);
        enterText( lastNameFld, LastName);}

    public void updateCoach(){
        click(updateCoachBttn);
        waitUntilPageLoad(5, true, true, true, true);
    }


}
