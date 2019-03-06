package tests;


import common.Config;
import common.dataObjects.CallsDataObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CallsTest extends BaseTest {
    private String numberForInternalCall = "1001";
    private String numberForDestinationCall = "3175229430";
    private String typeOfCall = "Incoming";
    private String fromCallNumber = "3175229431";
    private String selectUser = "Kristian Gombosh";

    @BeforeMethod
    public void loginBeforeTest(){
        driver.get(Config.BASE_URL);
        Assert.assertTrue(loginPage.pageIsDisplayed());
        loginPage.makeLogin(Config.BASE_USERNAME, Config.BASE_PASSWORD);
        dashboardPage.pageIsDisplayed();
    }

    @Test(description = "SQE-11 Calls should be present in calls list of the preconditions test cases for SQE-41")
    public void makeInternalCall(){
        switchToDesktop();
        desktopLoginPage.makeLogin(Config.BASE_USERNAME_FOR_BOLT, Config.BASE_PASSWORD_FOR_BOLT);
        desktopDashboardPage.makeCallToUser(numberForInternalCall);
    }

    @Test(description = "SQE-41 Calls tab - Users search", dependsOnMethods = "makeInternalCall")
    public void callsTabUsersSearch(){
        dashboardPage.openCallsPage();
        Assert.assertTrue(callsPage.pageIsDisplayed(), "Calls page should be displayed");
        callsPage.selectUser(selectUser);
        CallsDataObject expectedDataObject = new CallsDataObject().getCalsDateAndTime(numberForInternalCall);
        CallsDataObject actualDataObject = callsPage.getValuesFromTheTable();
        Assert.assertTrue(actualDataObject.isCallDataSame(expectedDataObject));
    }

    @Test(description = "SQE-11 Calls should be present in calls list of the preconditions test cases for SQE-41", dependsOnMethods = "callsTabUsersSearch")
    public void makeCallToDestination(){
        switchToDesktop();
        desktopLoginPage.makeLogin(Config.BASE_USERNAME_FOR_BOLT, Config.BASE_PASSWORD_FOR_BOLT);
        desktopDashboardPage.makeCallToUser(numberForDestinationCall);
    }

    @Test(description = "SQE-42 Calls tab - Destination", dependsOnMethods = "makeCallToDestination")
    public void callsTabDestination(){
        dashboardPage.openCallsPage();
        Assert.assertTrue(callsPage.pageIsDisplayed(), "Calls page should be displayed");
        callsPage.selectUserUsingDestination(numberForDestinationCall);
        CallsDataObject expectedDataObject = new CallsDataObject().getCalsDateAndTime(numberForDestinationCall);
        CallsDataObject actualDataObject = callsPage.getValuesFromTheTable();
        Assert.assertTrue(actualDataObject.isCallDataSame(expectedDataObject));

    }

    @Test(description = "SQE-48 Calls tab - View calls with Incoming Type", dependsOnMethods = "makeCallToDestination")
    public void viewCallsWithIncomingType(){
        dashboardPage.openCallsPage();
        Assert.assertTrue(callsPage.pageIsDisplayed(), "Calls page should be displayed");
        callsPage.selectUser(selectUser);
        CallsDataObject expectedDataObject = new CallsDataObject().getTypeOfCall(typeOfCall, fromCallNumber);
        CallsDataObject actualDataObject = callsPage.getValuesFromTypeOfCall();
        Assert.assertTrue(actualDataObject.isTypeOfCallSame(expectedDataObject));

    }
}

