package tests;


import common.Config;
import common.dataObjects.CallsDataObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CallsTest extends BaseTest {
    String numberForInternalCall = "1001";
    String numberForDestinationCall = "3175229430";

    @BeforeMethod
    public void loginBeforeTest(){
        driver.get(Config.BASE_URL);
        Assert.assertTrue(loginPage.pageIsDisplayed());
        loginPage.makeLogin(Config.BASE_USERNAME, Config.BASE_PASSWORD);
        dashboardPage.pageIsDisplayed();
    }

    @Test(description = "depends methods for SQE-41 Calls tab - Users search")
    public void makeInternalCall(){
        switchToDesktop();
        desktopLoginPage.makeLogin(Config.BASE_USERNAME_FOR_BOLT, Config.BASE_PASSWORD_FOR_BOLT);
        desktopDashboardPage.makeCallToUser(numberForInternalCall);
    }

    @Test(description = "SQE-41 Calls tab - Users search", dependsOnMethods = "makeInternalCall")
    public void callsTabUsersSearch(){
        dashboardPage.openCallsPage();
        Assert.assertTrue(callsPage.pageIsDisplayed(), "Calls page should be displayed");
        callsPage.selectUser("Kristian Gombosh");
        CallsDataObject expectedDataObject = new CallsDataObject().getCalsDateAndTime(numberForInternalCall);
        CallsDataObject actualDataObject = callsPage.getValuesFromTheTable();
        Assert.assertTrue(actualDataObject.isCallDataSame(expectedDataObject));
    }

    @Test(description = "depends methods for SQE-42 Calls tab - Destination and SQE-48 Calls tab - View calls with Incoming Type",dependsOnMethods = "callsTabUsersSearch")
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
        String typeOfCall = "Incoming";
        String fromCallNumber = "3175229431";
        dashboardPage.openCallsPage();
        Assert.assertTrue(callsPage.pageIsDisplayed(), "Calls page should be displayed");
        callsPage.selectUser("Kristian Gombosh");
        CallsDataObject expectedDataObject = new CallsDataObject().getTypeOfCall(numberForDestinationCall, typeOfCall, fromCallNumber);
        CallsDataObject actualDataObject = callsPage.getValuesFromTypeOfCall();
        Assert.assertTrue(actualDataObject.isTypeOfCallSame(expectedDataObject));

    }
}

