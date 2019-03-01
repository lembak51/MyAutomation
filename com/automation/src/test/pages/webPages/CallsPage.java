package pages.webPages;


import common.PageElement;
import common.dataObjects.CallsDataObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CallsPage extends BasePage{
    public static final PageElement userSearchChb = new PageElement(
            "User Search Checkbox",
            By.xpath("//*[@class='form-group col-md-6']//label[@class='ui-checkbox']"),
            true);
    public static final  PageElement userSelectFld = new PageElement(
            "User select modal",
            By.cssSelector("div[ng-click='open()']"));
    public static final  PageElement okSelectUsersBtn = new PageElement(
            "OK button on select users modal",
            By.cssSelector("button[ng-click='ok()']"));
    public static final  PageElement viewCallsBtn = new PageElement(
            "View Calls button",
            By.cssSelector("button[ng-click='runReport(1)']"),
            true);

    public static final  PageElement firstDateTimeInTable = new PageElement(
            "First Date Time in Table",
            By.xpath("//*[@class='col-md-12']//tbody[2]//a[@class='link ng-binding']"));
    public static final PageElement firstFromCallNumber = new PageElement(
            "From call number",
            By.xpath("//*[@class='col-md-12']//tbody[2]//td[3]//call"));
    public static final PageElement firstToCallNumber = new PageElement(
            "To call number",
            By.xpath("//*[@class='col-md-12']//tbody[2]//td[4]//call"));
    public static final PageElement toDestinationFld = new PageElement(
            "To/Destination field",
            By.cssSelector("input[data-ng-model='search_data.to']"));
    public static final PageElement firstTypeOfCallInTable = new PageElement(
            "To/Destination field",
            By.cssSelector("//*[@class='col-md-12']//tbody[2]//td[2]"));


    public CallsPage(WebDriver driver){
        super(driver);
    }

    @Override
    public boolean pageIsDisplayed(){
        return allRequiredElementDisplayed();
    }

    public void fillToDestinationFld(String destinatioNumber){enterText(toDestinationFld,destinatioNumber);}

    public void selectUserUsingDestination(String destinatioNumber){
        fillToDestinationFld(destinatioNumber);
        waitUntilPageLoad();
        waitToBeClickable(viewCallsBtn);
        click(viewCallsBtn);
    }


    public void selectUser(String username){
        waitToBeClickable(userSearchChb);
        click(userSearchChb);
        waitUntilPageLoad();
        waitToBeClickable(userSelectFld);
        click(userSelectFld);
        waitUntilPageLoad();
        PageElement userChb = new PageElement(
                "User Checkbox",
                By.xpath("//*[@class='modal-content']//tbody//tr//label//span[contains(text(),'" +username+ "')]")
        );
        waitToBeClickable(userChb);
        click(userChb);
        waitToBeClickable(okSelectUsersBtn);
        click(okSelectUsersBtn);
        waitUntilPageLoad(2);
        waitToBeClickable(viewCallsBtn);
        click(viewCallsBtn);
    }

    private String getDateTimeText (){return getText(firstDateTimeInTable).substring(0,15);}
    private String getFromCallNumber(){return getAttribute(firstFromCallNumber,"number");}
    private String getToCallNumber(){return getAttribute(firstToCallNumber,"number");}
    private String getTypeOfCall(){return getText(firstTypeOfCallInTable);}

    public CallsDataObject getValuesFromTheTable(){
        CallsDataObject expectedCallDataObject = new CallsDataObject();
        expectedCallDataObject.DateTime = getDateTimeText();
        expectedCallDataObject.FromNumber =getFromCallNumber();
        expectedCallDataObject.ToNumber = getToCallNumber();
        return expectedCallDataObject;
    }

    public CallsDataObject getValuesFromTypeOfCall(){
        CallsDataObject expectedCallDataObject = new CallsDataObject();
        expectedCallDataObject.TypeOfCall = getTypeOfCall();
        expectedCallDataObject.DateTime = getDateTimeText();
        expectedCallDataObject.FromNumber =getFromCallNumber();
        expectedCallDataObject.ToNumber = getToCallNumber();
        return expectedCallDataObject;
    }
}
