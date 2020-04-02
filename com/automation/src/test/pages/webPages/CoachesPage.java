package pages.webPages;

import common.PageElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CoachesPage extends BasePage {
    private static final PageElement createCoachesBttn = new PageElement(
            "Create Coaches Button",
            By.xpath("//*[@id=\"root\"]/div/div/div/div[1]/div[1]/div/button[2]"),
            true);
    private static final PageElement lastNameSearch = new PageElement(
            "Create Coaches Button",
            By.xpath("//div[contains(@class,'rt-thead -filters')]//div[2]//input[1]"),
            true);
    private static final PageElement deleteButton = new PageElement(
            "Delete button coach",
            By.xpath("//button[contains(@class,'color-inherit')]"),
            true);
    private static final PageElement yesButton = new PageElement(
            "Yes button",
            By.xpath("//button[contains(@class,'variant-contained MuiButton-contained MuiButton-containedPrimary')]"),
            false);

    private static final PageElement coachlAfterSearch = new PageElement(
            "School after search",
            By.xpath("//div[contains(@class,'rt-tr -odd')]"),
            false);

    private static final PageElement listElemants= new PageElement(
            "Name",
            By.xpath("//*[@class='rt-tbody']//*[@class='rt-td flex-center'][4]"),
            false);

private static final PageElement addressSearchFlld = new PageElement(
        "Address Search",
        By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div/div[1]/div[2]/div/div[6]/input"),
        true);
    //div[contains(@class,'rt-tr -odd')]
    //*[@id="root"]/div/div/div/div[2]/div/div[1]/div[3]/div/div/div[1]

    private final static PageElement emptyCoachList = new PageElement(
            "Empty school list",
            By.xpath("//div[contains(@class,'rt-noData')]"),
            false);
    private static final PageElement pageFld = new PageElement(
            "Page field",
            By.xpath("//div[contains(@class,'-pageJump')]//input"),
            false);
    private static final PageElement nextButton = new PageElement(
            "Page field",
            By.xpath("//div[contains(@class,'-next')]//button[1]"),
            false);
    private static final PageElement addressFilter = new PageElement(
            "Address Filter",
            By.xpath("//div[contains(text(),'Address')]"),
            true);


    public CoachesPage(WebDriver driver) {
        super(driver);
    }

    public  void waitSearch (String strSchoolName) {
        PageElement nameSchool = new PageElement(
                " School in the list",
                By.xpath("//div[contains(text(),'" + strSchoolName + "')]"),
                true);
        waitToBeClickable(nameSchool);
    }
    public boolean coachIsDisplayedInList(String strcoachFirstName){
        PageElement coach = new PageElement(
                "New school in the list",
                By.xpath("//div[contains(text(),'" + strcoachFirstName + "')]"),
                false);
        return isElementPresent(coach);
    }


    public void clickOnCoach (String strcoachFirstName){
        PageElement coach = new PageElement(
                "New school in the list",
                By.xpath("//div[contains(text(),'" + strcoachFirstName + "')]"),
                true);
        click(coach);




    }
    @Override
    public boolean pageIsDisplayed() {
        return allRequiredElementDisplayed();
    }

    public void goTocreatepage() {
        click(createCoachesBttn);
    }

    public void searchName (String schoolName){
        enterText(lastNameSearch,schoolName );
        waitToBeClickable(pageFld,5);

    }

    public void searchAddress(String Address){
        enterText( addressSearchFlld, Address);
        waitToBeClickable(pageFld,5);
    }
    public void deletecoach(){
        waitToBeClickable(deleteButton);
        click(deleteButton);
        click(yesButton);
        waitToBePresent(emptyCoachList, 5);
    }
//  public boolean asss(){
//      waitJsLoad();
//      return sortAddress();

//  }
//public void clickOnCoach(){
//    click(coachlAfterSearch);
//}



 public boolean sortAddress() {
     waitJsLoad();
     click(addressFilter);
     waitUntilPageLoad(3);
     click(addressFilter);
     waitUntilPageLoad(3);
     List<WebElement> addresses = findAll(By.xpath("//*[@class='rt-tbody']//*[@class='rt-td flex-center'][4]"));
     int addLength = addresses.size();
     ArrayList addressList = new ArrayList();
     for (int i = 0; i < addLength; i++) {
         // String busNamesFromTable = busNames.get(i).getText().replace(" ", "").toUpperCase();
         addressList.add(addresses.get(i).getText().replace(" ", "").toUpperCase());
     }
     ArrayList<String> arrayListClone = (ArrayList<String>) addressList.clone();
     System.out.println(arrayListClone);
     addressList.sort(Comparator.reverseOrder());
     System.out.println("//////////////////////////");
     System.out.println(addressList);
     if (arrayListClone.equals(addressList)){
         return true;
     };
     return false;
 }

// public voidboolean getAllBusesCountFromTable(PageElement listElemants) {

//     List<WebElement> busNames = findAll(listElemants);
//     ArrayList<String> namesListFromTable = new ArrayList<>();
//     int i;
//     do {
//         waitToBeVisible(listElemants);
//         busNames = findAll(listElemants);
//         for (i = 0; i < busNames.size(); i++) {
//             String busNamesFromTable = busNames.get(i).getText().replace(" ", "").toUpperCase();
//             namesListFromTable.add(busNamesFromTable);
//         }
//         if (isElementPresent(nextButton)) {
//             log.info("Next Button is disabled");
//             break;
//         } else if (isElementPresent(nextButton)) {
//             click(nextButton);
//         }
//         i = 0;
//     } while (isElementPresent(nextButton) );
//

// }

//ublic boolean sortAddress(PageElement listElemants) {


//   List<WebElement> busNames = findAll(listElemants);
//   ArrayList<String> namesListFromTable = new ArrayList<>();
//   ArrayList<String> forSortingList = new ArrayList<>();
//   int i;
//   do {
//       waitToBeVisible(listElemants);
//       busNames = findAll(listElemants);
//       for (i = 0; i < busNames.size(); i++) {
//           String busNamesFromTable = busNames.get(i).getText().replace(" ", "").toUpperCase();
//           namesListFromTable.add(busNamesFromTable);
//           forSortingList.add(busNamesFromTable);
//           namesListFromTable.remove("NONE");
//           forSortingList.remove("NONE");
//       }
//       if (isElementPresent(nextButton)) {
//           log.info("Next Button is disabled");
//           break;
//       } else if (isElementPresent(nextButton)) {
//           click(nextButton);
//       }
//       i = 0;
//   } while (isElementPresent(nextButton));
//   forSortingList.sort(Comparator.naturalOrder());
//   for (i = 0; i < namesListFromTable.size(); i++) {
//       if (!namesListFromTable.get(i).contentEquals(forSortingList.get(i))) {
//           return false;
//       }
//   }
//   return true;

 }