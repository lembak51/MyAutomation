package pages.webPages;

import common.PageElement;
import io.appium.java_client.android.nativekey.PressesKey;
import io.appium.java_client.windows.PressesKeyCode;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreateSchoolPage extends BasePage {
    private static final PageElement stateDropDown = new PageElement(
            "States Drop-Down Lists",
            By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div/div/div[2]/div"),
            true);
    private static final PageElement alaskaState = new PageElement(
            "Select alaska state",
            By.xpath(".//*[contains(text(),'Alaska')]"),
            false);

    private static final PageElement adakCity = new PageElement(
            "Select alaska state",
            By.xpath(".//*[contains(text(),'Adak')]"),
            false);
    private static final PageElement cityDropDown = new PageElement(
            "City Drop-Down Lists",
            By.xpath("//body/div[@id='root']/div[contains(@class,'wrapper')]/div[contains(@class,'wrapper-content')]/div[contains(@class,'q-panel-container q-panel-container color-default q-panel-toggled')]/div[contains(@class,'')]/div[contains(@class,'form-wrapper edit-mode')]/div[contains(@class,'form-group')]/div[4]/div[1]/div[1]"),
            true);
    //input[@placeholder='Name']
    private static final PageElement nameFld = new PageElement(
            "Name Field",
            By.xpath("//input[@placeholder='Name']"),
            true);
    private static final PageElement addressFld = new PageElement(
            "Address Field",
            By.xpath("//input[contains(@placeholder,'Address')]"),
            true);
    //input[contains(@placeholder,'Zip Code')]

    private static final PageElement zipFld = new PageElement(
            "Zip Field",
            By.xpath("//input[contains(@placeholder,'Zip Code')]"),
            true);
    //span[contains(text(),'Create School')]
    private static final PageElement createSchoolBttn = new PageElement(
            "Create School",
            By.xpath("//span[contains(text(),'Create School')]"),
            false);
    private static final PageElement UpdateSchoolBttn = new PageElement(
            "Update School button",
            By.xpath("//button[contains(@class,'variant-contained MuiButton-contained MuiButton-containedSecondary')]"),
            false);

    public CreateSchoolPage(WebDriver driver) {
        super(driver);
    }
    public void fillState(String strStateName){
        enterText(stateDropDown, strStateName);
    }

    public void fillCity(String strCityName){
        enterText(cityDropDown, strCityName);
    }
    public void fillName(String strSchoolName){
        enterText(nameFld, strSchoolName);
    }

    public void fillAddress(String strAddress){
        enterText(addressFld, strAddress);
    }
    public void fillZipCode(String strZip){
        enterText(zipFld, strZip);
    }

    public void createSchool( String SchoolName, String address, String zip)  {
        click(stateDropDown);
        click(alaskaState);
        click(cityDropDown);
        click(adakCity);
        fillName(SchoolName);
        fillAddress(address);
        fillZipCode(zip);
        click(createSchoolBttn);

    }
    public void editNmaeSchool ( String SchoolName){
        fillName(SchoolName);
        click(UpdateSchoolBttn);

    }
    @Override
    public boolean pageIsDisplayed() {
        return allRequiredElementDisplayed();
    }
}
