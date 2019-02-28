package tests;


import common.Config;
import common.dataObjects.CallsDataObject;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;

import org.testng.annotations.Test;
    public class CallsTest extends BaseTest {
        @BeforeMethod
        public void loginBeforeTest(){
            driver.get(Config.BASE_URL);
            Assert.assertTrue(loginPage.pageIsDisplayed());
            loginPage.makeLogin(Config.BASE_USERNAME, Config.BASE_PASSWORD);
            dashboardPage.pageIsDisplayed();
        }
        @Test(description = "depends methods for Users search")
        public void makeCall (){
            switchToDesktop();
            desktopLoginPage.makeLogin(Config.BASE_USERNAME_FOR_BOLT, Config.BASE_PASSWORD_FOR_BOLT);
            desktopDashboardPage.makeCallToUser("1001");
        }

        @Test(description = "Calls tab - Users search",dependsOnMethods ="makeCall")
        public void callsTabUsersSearch(){
            dashboardPage.openCallsPage();
            Assert.assertTrue(callsPage.pageIsDisplayed(),"Calls page should be displayed");
            callsPage.selectUser("Kristian Gombosh");
            CallsDataObject expectedDataObject =  new CallsDataObject();
            CallsDataObject actualDataObject = callsPage.getValuesFromTheTable();
            Assert.assertTrue(actualDataObject.isCallDataSame(expectedDataObject));

        }
    }

