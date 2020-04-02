package tests;

import common.Config;
import common.dataObjects.UserDataObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.webPages.FanPage;

public class FansTest extends BaseTest {

        @Test(description = "C91044 Create new fan", priority = 0)
        public void createSchool() {
            UserDataObject userDataObject = new UserDataObject();
            driver.get(Config.BASE_URL);
            Assert.assertTrue(loginPage.pageIsDisplayed(), "Login Page should be displayed ");
            loginPage.makeLogin(Config.BASE_USERNAME, Config.BASE_PASSWORD);//Replace step 2-4
            Assert.assertTrue(dashboardPage.pageIsDisplayed());
            dashboardPage.goToFanList();
            fanPage.goToCreateFan();
            createNewFanPage.fillAllfield("QA_Automation","Fan"+ userDataObject.RandomNumber,userDataObject.EmailCoach,"1111","111 111-1111", "Auto");
            createNewFanPage.selecktAlaskState();
            createNewFanPage.selecktAdakCity();
            createNewFanPage.seleckSchool();
            createNewFanPage.selectDate();
            createNewFanPage.clickOnCreateUpdateButton();
            Assert.assertTrue(fanPage.fanIsDisplayedInList(userDataObject.EmailCoach));
}

    @Test(description = "C91053 Create new fan - Update email", priority = 1)
    public void updateEmail(){
        UserDataObject userDataObject = new UserDataObject();
        driver.get(Config.BASE_URL);
        Assert.assertTrue(loginPage.pageIsDisplayed(), "Login Page should be displayed ");
        loginPage.makeLogin(Config.BASE_USERNAME, Config.BASE_PASSWORD);//Replace step 2-4
        Assert.assertTrue(dashboardPage.pageIsDisplayed());
        dashboardPage.goToFanList();
        fanPage.goToCreateFan();
        createNewFanPage.fillAllfield("QA_Automation", "Fan" + userDataObject.RandomNumber, userDataObject.EmailCoach, "1111", "111 111-1111", "Auto");
        createNewFanPage.selecktAlaskState();
        createNewFanPage.selecktAdakCity();
        createNewFanPage.seleckSchool();
        createNewFanPage.selectDate();
        createNewFanPage.clickOnCreateUpdateButton();
        Assert.assertTrue(fanPage.fanIsDisplayedInList(userDataObject.EmailCoach));
        fanPage.clickOnNewFan();
        createNewFanPage.updateEmail("Editebel"+ userDataObject.EmailCoach);
        Assert.assertTrue(fanPage.fanIsDisplayedInList("Editebel"+ userDataObject.EmailCoach));
    }

    @Test(description = "C91044Create new fan - Delete new fan", priority = 2)
    public void deleteNewFan() {
        UserDataObject userDataObject = new UserDataObject();
        driver.get(Config.BASE_URL);
        Assert.assertTrue(loginPage.pageIsDisplayed(), "Login Page should be displayed ");
        loginPage.makeLogin(Config.BASE_USERNAME, Config.BASE_PASSWORD);//Replace step 2-4
        Assert.assertTrue(dashboardPage.pageIsDisplayed());
        dashboardPage.goToFanList();
        fanPage.goToCreateFan();
        createNewFanPage.fillAllfield("QA_Automation","Fan"+ userDataObject.RandomNumber,userDataObject.EmailCoach,"1111","111 111-1111", "Auto");
        createNewFanPage.selecktAlaskState();
        createNewFanPage.selecktAdakCity();
        createNewFanPage.seleckSchool();
        createNewFanPage.selectDate();
        createNewFanPage.clickOnCreateUpdateButton();
        Assert.assertTrue(fanPage.fanIsDisplayedInList(userDataObject.EmailCoach));
        fanPage.deleteNewFan();
        Assert.assertFalse(fanPage.fanIsDisplayedInList(userDataObject.EmailCoach));
        }
}

