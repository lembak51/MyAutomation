package tests;

import common.Config;
import common.dataObjects.UserDataObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class StateUsersTest extends BaseTest {

    @Test(description = "C91057 Create state user", priority = 0)
    public void createStateUsers(){
        UserDataObject userDataObject = new UserDataObject();
        driver.get(Config.BASE_URL);
        Assert.assertTrue(loginPage.pageIsDisplayed(), "Login Page should be displayed ");
        loginPage.makeLogin(Config.BASE_USERNAME, Config.BASE_PASSWORD);//Replace step 2-4
        Assert.assertTrue(dashboardPage.pageIsDisplayed());
        dashboardPage.goToStateUsersList();
        stateUsersPage.goToCreateStateUsersPage();
        createNewStateUsers.fillAllfield("QA_Automation", "StateUsers" + userDataObject.RandomNumber, userDataObject.EmailCoach, "1111", "111 111-1111", "Auto");
        createNewStateUsers.selecktAlaskState();
        createNewStateUsers.selectDate();
        createNewStateUsers.clickOnCreateUpdateButton();
        Assert.assertTrue(stateUsersPage.stateUsersIsDisplayedInList(userDataObject.EmailCoach));
    }

    @Test(description = "C91059 Create state user - Update Email", priority = 1)
    public void updateEmail(){
        UserDataObject userDataObject = new UserDataObject();
        driver.get(Config.BASE_URL);
        Assert.assertTrue(loginPage.pageIsDisplayed(), "Login Page should be displayed ");
        loginPage.makeLogin(Config.BASE_USERNAME, Config.BASE_PASSWORD);//Replace step 2-4
        Assert.assertTrue(dashboardPage.pageIsDisplayed());
        dashboardPage.goToStateUsersList();
        stateUsersPage.goToCreateStateUsersPage();
        createNewStateUsers.fillAllfield("QA_Automation", "StateUsers" + userDataObject.RandomNumber, userDataObject.EmailCoach, "1111", "111 111-1111", "Auto");
        createNewStateUsers.selecktAlaskState();
        createNewStateUsers.selectDate();
        createNewStateUsers.clickOnCreateUpdateButton();
        stateUsersPage.searchEmail(userDataObject.EmailCoach);
        stateUsersPage.clickOnStateUsersAfterSearch();
        Assert.assertTrue(createNewStateUsers.pageIsDisplayed());
        createNewStateUsers.updateEmail("update" + userDataObject.EmailCoach);
        Assert.assertTrue(stateUsersPage.stateUsersIsDisplayedInList("update" + userDataObject.EmailCoach));

    }

    @Test(description = "C91060 Create state user - delete state user ", priority = 2)
    public void deletStateUsers(){
        UserDataObject userDataObject = new UserDataObject();
        driver.get(Config.BASE_URL);
        Assert.assertTrue(loginPage.pageIsDisplayed(), "Login Page should be displayed ");
        loginPage.makeLogin(Config.BASE_USERNAME, Config.BASE_PASSWORD);//Replace step 2-4
        Assert.assertTrue(dashboardPage.pageIsDisplayed());
        dashboardPage.goToStateUsersList();
        stateUsersPage.goToCreateStateUsersPage();
        createNewStateUsers.fillAllfield("QA_Automation", "StateUsers" + userDataObject.RandomNumber, userDataObject.EmailCoach, "1111", "111 111-1111", "Auto");
        createNewStateUsers.selecktAlaskState();
        createNewStateUsers.selectDate();
        createNewStateUsers.clickOnCreateUpdateButton();
        Assert.assertTrue(stateUsersPage.stateUsersIsDisplayedInList(userDataObject.EmailCoach));
        stateUsersPage.deleteStateUsers();
        Assert.assertFalse(stateUsersPage.stateUsersIsDisplayedInList(userDataObject.EmailCoach));

    }
}
