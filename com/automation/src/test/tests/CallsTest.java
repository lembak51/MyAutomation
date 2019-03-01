package tests;


import common.Config;
import common.dataObjects.CallsDataObject;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;

import org.testng.annotations.Test;
    public class CallsTest extends BaseTest {
        String numberForMakeCall = "1001";
        String numberForDestinationMakeCall = "3175229430";
        @BeforeMethod
        public void loginBeforeTest(){
            driver.get(Config.BASE_URL);
            Assert.assertTrue(loginPage.pageIsDisplayed());
            loginPage.makeLogin(Config.BASE_USERNAME, Config.BASE_PASSWORD);
            dashboardPage.pageIsDisplayed();
        }
        @Test(description = "depends methods for Calls tab - Users search")
        public void makeCall (){
            switchToDesktop();
            desktopLoginPage.makeLogin(Config.BASE_USERNAME_FOR_BOLT, Config.BASE_PASSWORD_FOR_BOLT);
            desktopDashboardPage.makeCallToUser(numberForMakeCall);
        }
        @Test(description = "depends methods for Users search")
        public void makeCallToDestination (){
            switchToDesktop();
            desktopLoginPage.makeLogin(Config.BASE_USERNAME_FOR_BOLT, Config.BASE_PASSWORD_FOR_BOLT);
            desktopDashboardPage.makeCallToUser(numberForDestinationMakeCall);
        }


        @Test(description = "SQE-41 Calls tab - Users search",dependsOnMethods ="makeCall")
        public void callsTabUsersSearch(){
            dashboardPage.openCallsPage();
            Assert.assertTrue(callsPage.pageIsDisplayed(),"Calls page should be displayed");
            callsPage.selectUser("Kristian Gombosh");
            CallsDataObject expectedDataObject =  new CallsDataObject().getCalsDateAndTime(numberForMakeCall);
            CallsDataObject actualDataObject = callsPage.getValuesFromTheTable();
            Assert.assertTrue(actualDataObject.isCallDataSame(expectedDataObject));

        }
        @Test(description = "SQE-42 Calls tab - Destination",dependsOnMethods = "makeCallToDestination")
        public void callsTabDestination(){
            dashboardPage.openCallsPage();
            Assert.assertTrue(callsPage.pageIsDisplayed(),"Calls page should be displayed");
            callsPage.selectUserUsingDestination(numberForDestinationMakeCall);
            CallsDataObject expectedDataObject =  new CallsDataObject().getCalsDateAndTime(numberForDestinationMakeCall);
            CallsDataObject actualDataObject = callsPage.getValuesFromTheTable();
            Assert.assertTrue(actualDataObject.isCallDataSame(expectedDataObject));

        }
        @Test(description = "SQE-48 Calls tab - View calls with Incoming Type",dependsOnMethods = "makeCallToDestination")
        public void viewCallsWithIncomingType(){
            String typeOfCall = "Incoming";
            dashboardPage.openCallsPage();
            Assert.assertTrue(callsPage.pageIsDisplayed(),"Calls page should be displayed");
            callsPage.selectUser("Kristian Gombosh");
            CallsDataObject expectedDataObject =  new CallsDataObject().getTypeOfCall(numberForDestinationMakeCall,typeOfCall);
            CallsDataObject actualDataObject = callsPage.getValuesFromTheTable();
            Assert.assertTrue(actualDataObject.isCallDataSame(expectedDataObject));

        }
    }

