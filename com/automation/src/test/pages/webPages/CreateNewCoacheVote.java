package pages.webPages;

import common.PageElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;

public class CreateNewCoacheVote extends BasePage {


    private static final PageElement maleRadioBttn= new PageElement(
            "Male radio button",
            By.xpath("//body/div[@id='root']/div[contains(@class,'wrapper')]/div[contains(@class,'wrapper-content')]/div[contains(@class,'q-panel-container q-panel-container color-default q-panel-toggled')]/div[contains(@class,'')]/div[contains(@class,'form-wrapper edit-mode')]/div[contains(@class,'form-group')]/div[contains(@class,'MuiFormControl-root form-control disable-underline MuiFormControl-marginDense MuiFormControl-fullWidth')]/div[contains(@class,'form-radio-group right')]/div[contains(@class,'MuiFormGroup-root form-inline')]/label[1]/span[1]"),
            true);
    //iframe[@id='votes_ifr']



    private static final PageElement createCoachVoteBttn = new PageElement(
            "Create/Update coach vote button",
            By.xpath("//button[contains(@class,'variant-contained MuiButton-contained MuiButton-containedSecondary')]"),
            true);

    private static final PageElement stateDropDown = new PageElement(
            "State drop-down list ",
            By.xpath("//div[contains(@class,'form-select-container m-b css-2b097c-container')]"),
            true);
    //div[contains(@class,'MuiTypography-root MuiPaper-root MuiPaper-elevation6 MuiSnackbarContent-root notification-danger MuiTypography-body2')]

    private static final PageElement alertSameState = new PageElement(
            "Alert  ",
            By.xpath("//div[contains(@class,'MuiTypography-root MuiPaper-root MuiPaper-elevation6 MuiSnackbarContent-root notification-danger MuiTypography-body2')]"),
            true);
    private static final PageElement alertSameState1 = new PageElement(
            "Alert  ",
            By.xpath("//div[contains(@class,'MuiTypography-root MuiPaper-root MuiPaper-elevation6 MuiSnackbarContent-root notification-danger MuiTypography-body20')]"),
            true);
    //div[contains(@class,'MuiTypography-root MuiPaper-root MuiPaper-elevation6 MuiSnackbarContent-root notification-danger MuiTypography-body2')]
    //body/div[@id='root']/div[contains(@class,'wrapper')]/div[contains(@class,'wrapper-content')]/div[contains(@class,'q-panel-container q-panel-container color-default q-panel-toggled')]/div[contains(@class,'')]/div[contains(@class,'form-wrapper edit-mode')]/div[contains(@class,'form-group')]/div[contains(@class,'MuiFormControl-root form-control disable-underline MuiFormControl-marginDense MuiFormControl-fullWidth')]/div[contains(@class,'form-radio-group right')]/div[contains(@class,'MuiFormGroup-root form-inline')]/label[1]/span[1]
    public CreateNewCoacheVote(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean pageIsDisplayed() {
        return allRequiredElementDisplayed();
    }

    public void clickOnRadioBttn(){
        waitJsLoad();
        click(maleRadioBttn);

    }
public void fillIfrema (String strVote){
    driver.switchTo().frame("votes_ifr");
    driver.findElement(By.id("tinymce")).click();
    driver.findElement(By.id("tinymce")).sendKeys(strVote);
    driver.switchTo().defaultContent();
//    click(createCoachVoteBttn);
//  waitUntilPageLoad(3,true,true,true,true);
}
    public void tryFirst ( ) {
        clickOnRadioBttn();


        ArrayList<String> stateList = new ArrayList();
        stateList.add("Armed Forces - Americas");
        stateList.add("Alaska");
        stateList.add("Armed Forces - Europe/Africa/Canada");
        stateList.add("Armed Forces - Pacific");
        stateList.add("Arkansas");
        stateList.add("Alabama");
        stateList.add("American Samoa");
        stateList.add("Arizona");
        stateList.add("California");
        stateList.add("Connecticut");
        stateList.add("Colorado");
        stateList.add("District of Columbia");
        stateList.add("Delaware");
        stateList.add("Florida");
        stateList.add("Federated States of Micronesia");
        stateList.add("Georgia");
        stateList.add("Guam");
        stateList.add("Hawaii");
        stateList.add("Iowa");
        stateList.add("Idaho");
        stateList.add("Illinois");
        stateList.add("Indiana");
        stateList.add("Kansas");
        stateList.add("Kentucky");
        stateList.add("Louisiana");
        stateList.add("Massachusetts");
        stateList.add("Maryland");
        stateList.add("Maine");
        stateList.add("Marshall Islands");
        stateList.add("Michigan");
        stateList.add("Missouri");
        stateList.add("Northern Mariana Islands");
        stateList.add("Mississippi");
        stateList.add("North Carolina");
        stateList.add("North Dakota");
        stateList.add("Nebraska");
        stateList.add("Montana");
        stateList.add("New Hampshire");
        stateList.add("New Jersey");
        stateList.add("New Mexico");
        stateList.add("Nevada");
        stateList.add("New York");
        stateList.add("Oklahoma");
        stateList.add("Oregon");
        stateList.add("Pennsylvania");
        stateList.add("Puerto Rico");
        stateList.add("Palau");
        stateList.add("Rhode Island");
        stateList.add("South Carolina");
        stateList.add("South Dakota");
        stateList.add("Tennessee");
        stateList.add("Texas");
        stateList.add("Virgin Islands");
        stateList.add("Vermont");
        stateList.add("Washington");
        stateList.add("Wisconsin");
        stateList.add("Virginia");
        stateList.add("West Virginia");
        stateList.add("British Columbia");
        stateList.add("Manitoba");
        stateList.add("Alberta");
        stateList.add("Wyoming");
        stateList.add("New Brunswick");
        stateList.add("Newfoundland");
        stateList.add("Nova Scotia");
        stateList.add("Northwest Territories");
        stateList.add("Nunavut");
        stateList.add("Ontario");
        stateList.add("Prince Edward Island");
        stateList.add("Quebec");
        stateList.add("Saskatchewan");
        stateList.add("Yukon Territory");


        //int k = stateList.size();
        //    do {
        //        for (int k = 0; k <= 74; k++) {
        //            String indexStateInTheArray;
        //            indexStateInTheArray = stateList.get(k);
        //            PageElement state = new PageElement(
        //                    "State in list",
        //                    By.xpath("//div[contains(text(),'" + indexStateInTheArray + "')]"),
        //                    true);
        //            System.out.println(indexStateInTheArray);
        //            click(stateDropDown);
        //            click(state);
        //            waitJsLoad();
        //            click(createCoachVoteBttn);
        //            waitToBePresent(alertSameState,2);
        //            waitJsLoad();


        //        } }while (isElementPresent(alertSameState) == true);


        for (int k = 0; k <= 74; k++) {
            CreateNewCoacheVote A=new  CreateNewCoacheVote("");
            String indexStateInTheArray;
            indexStateInTheArray = stateList.get(k);
            PageElement state = new PageElement(
                    "State in list",
                    By.xpath("//div[contains(text(),'" + indexStateInTheArray + "')]"),
                    true);
            System.out.println(indexStateInTheArray);
            click(stateDropDown);
            click(state);
            waitJsLoad();
            click(createCoachVoteBttn);
            waitJsLoad();
            if (isElementPresent(alertSameState) == false) {
                break;
            }


        }


    }}







//   String[] stateList = new String["Armed Forces - Americas", "Alaska",
//   "Armed Forces - Europe/Afr",
//   "Armed Forces - Pacific",
//   "Arkansas",
//   "Alabama",
//   "American Samoa",
//   "Arizona",
//   "California",
//   "Connecticut",
//   "Colorado",
//   "District of Columbia",
//   "Delaware",
//   "Florida",
//   "Federated States of Micro",
//   "Georgia",
//   "Guam",
//   "Hawaii",
//   "Iowa",
//   "Idaho",
//   "Illinois",
//   "Indiana",
//   "Kansas",
//   "Kentucky",
//   "Louisiana",
//   "Massachusetts",
//   "Maryland",
//   "Maine",
//   "Marshall Islands",;
//   "Michigan",
//   "Missouri",
//   "Northern Mariana Islands",
//   "Mississippi",
//   "North Carolina",
//   "North Dakota",
//   "Nebraska",
//   "Montana",
//   "New Hampshire",
//   "New Jersey",
//   "New Mexico",
//   "Nevada",
//   "New York",
//   "Oklahoma",
//   "Oregon",
//   "Pennsylvania",
//   "Puerto Rico",
//   "Palau",
//   "Rhode Island",
//   "South Carolina",
//   "South Dakota",
//   "Tennessee",
//   "Texas",
//   "Virgin Islands",
//   "Vermont",
//   "Washington",
//   "Wisconsin",
//   "Virginia",
//   "West Virginia",
//   "British Columbia",
//   "Manitoba",
//   "Alberta",
//   "Wyoming",
//   "New Brunswick",
//   "Newfoundland",
//   "Nova Scotia",
//   "Northwest Territories",
//   "Nunavut",
//   "Ontario",
//   "Prince Edward Island",
//   "Quebec",
//   "Saskatchewan",






























//   ArrayList<String> stateList = new ArrayList();
//   stateList.add("Armed Forces - Americas");
//   stateList.add("Alaska");
//   stateList.add("Armed Forces - Europe/Africa/Canada");
//   stateList.add("Armed Forces - Pacific");
//   stateList.add("Arkansas");
//   stateList.add("Alabama");
//   stateList.add("American Samoa");
//   stateList.add("Arizona");
//   stateList.add("California");
//   stateList.add("Connecticut");
//   stateList.add("Colorado");
//   stateList.add("District of Columbia");
//   stateList.add("Delaware");
//   stateList.add("Florida");
//   stateList.add("Federated States of Micronesia");
//   stateList.add("Georgia");
//   stateList.add("Guam");
//   stateList.add("Hawaii");
//   stateList.add("Iowa");
//   stateList.add("Idaho");
//   stateList.add("Illinois");
//   stateList.add("Indiana");
//   stateList.add("Kansas");
//   stateList.add("Kentucky");
//   stateList.add("Louisiana");
//   stateList.add("Massachusetts");
//   stateList.add("Maryland");
//   stateList.add("Maine");
//   stateList.add("Marshall Islands");
//   stateList.add("Michigan");
//   stateList.add("Missouri");
//   stateList.add("Northern Mariana Islands");
//   stateList.add("Mississippi");
//   stateList.add("North Carolina");
//   stateList.add("North Dakota");
//   stateList.add("Nebraska");
//   stateList.add("Montana");
//   stateList.add("New Hampshire");
//   stateList.add("New Jersey");
//   stateList.add("New Mexico");
//   stateList.add("Nevada");
//   stateList.add("New York");
//   stateList.add("Oklahoma");
//   stateList.add("Oregon");
//   stateList.add("Pennsylvania");
//   stateList.add("Puerto Rico");
//   stateList.add("Palau");
//   stateList.add("Rhode Island");
//   stateList.add("South Carolina");
//   stateList.add("South Dakota");
//   stateList.add("Tennessee");
//   stateList.add("Texas");
//   stateList.add("Virgin Islands");
//   stateList.add("Vermont");
//   stateList.add("Washington");
//   stateList.add("Wisconsin");
//   stateList.add("Virginia");
//   stateList.add("West Virginia");
//   stateList.add("British Columbia");
//   stateList.add("Manitoba");
//   stateList.add("Alberta");
//   stateList.add("Wyoming");
//   stateList.add("New Brunswick");
//   stateList.add("Newfoundland");
//   stateList.add("Nova Scotia");
//   stateList.add("Northwest Territories");
//   stateList.add("Nunavut");
//   stateList.add("Ontario");
//   stateList.add("Prince Edward Island");
//   stateList.add("Quebec");
//   stateList.add("Saskatchewan");
//   stateList.add("Yukon Territory");