package tests;

import common.Config;
import common.dataObjects.UserDataObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UsersTest extends BaseTest {

    @Test(description = "C91047 Create new User", priority = 0)
    public void createNewUser() {
        UserDataObject userDataObject = new UserDataObject();
        driver.get(Config.BASE_URL);
        Assert.assertTrue(loginPage.pageIsDisplayed(), "Login Page should be displayed ");
        loginPage.makeLogin(Config.BASE_USERNAME, Config.BASE_PASSWORD);
        dashboardPage.goToUsersList();
        usersPage.goToCreateusersPage();
        createNewUsersPage.createNewAdmin("QA","Automation",userDataObject.EmailCoach,"automation"+ userDataObject.RandomNumber,"1111");
        Assert.assertTrue(usersPage.pageIsDisplayed());
        Assert.assertTrue(usersPage.adminIsDisplayedInList(userDataObject.EmailCoach));
    }

    @Test(description = "C91048 Create new user -Edit Username", priority = 1)
    public void editUsername() {
        UserDataObject userDataObject = new UserDataObject();
        driver.get(Config.BASE_URL);
        Assert.assertTrue(loginPage.pageIsDisplayed(), "Login Page should be displayed ");
        loginPage.makeLogin(Config.BASE_USERNAME, Config.BASE_PASSWORD);
        dashboardPage.goToUsersList();
        usersPage.goToCreateusersPage();
        createNewUsersPage.createNewAdmin("QA","Automation",userDataObject.EmailCoach,"automation"+ userDataObject.RandomNumber,"1111");
        Assert.assertTrue(usersPage.pageIsDisplayed());
        Assert.assertTrue(usersPage.adminIsDisplayedInList(userDataObject.EmailCoach));
        usersPage.openNewAdmin("automation"+ userDataObject.RandomNumber);
        createNewUsersPage.editUsernameAdmin("Editautomation"+ userDataObject.RandomNumber);
        Assert.assertTrue(usersPage.editedAdminIsDisplayedInList("Editautomation"+ userDataObject.RandomNumber));
        dashboardPage.logout();
        loginPage.makeLogin("Editautomation"+ userDataObject.RandomNumber, "1111");
        Assert.assertTrue(loginPage.pageIsDisplayed(),"1122");
    }
    @Test(description = "C91050 Create new user -Edit Password", priority = 2)
    public void editPassword() {
        UserDataObject userDataObject = new UserDataObject();
        driver.get(Config.BASE_URL);
        Assert.assertTrue(loginPage.pageIsDisplayed(), "Login Page should be displayed ");
        loginPage.makeLogin(Config.BASE_USERNAME, Config.BASE_PASSWORD);
        dashboardPage.goToUsersList();
        usersPage.goToCreateusersPage();
        createNewUsersPage.createNewAdmin("QA", "Automation", userDataObject.EmailCoach, "automation" + userDataObject.RandomNumber, "1111");
        Assert.assertTrue(usersPage.pageIsDisplayed());
        Assert.assertTrue(usersPage.adminIsDisplayedInList(userDataObject.EmailCoach));
        usersPage.openNewAdmin("automation" + userDataObject.RandomNumber);
        createNewUsersPage.editPassword("2222");
        dashboardPage.logout();
        loginPage.makeLogin("automation"+ userDataObject.RandomNumber, "2222");
        Assert.assertTrue(loginPage.pageIsDisplayed(),"1122");
    }
    @Test(description = "C91050 Create new user - Delete Admin", priority = 3)
    public void deleteAdmin() {
        UserDataObject userDataObject = new UserDataObject();
        driver.get(Config.BASE_URL);
        Assert.assertTrue(loginPage.pageIsDisplayed(), "Login Page should be displayed ");
        loginPage.makeLogin(Config.BASE_USERNAME, Config.BASE_PASSWORD);
        dashboardPage.goToUsersList();
        usersPage.goToCreateusersPage();
        createNewUsersPage.createNewAdmin("QA", "Automation", userDataObject.EmailCoach, "automation" + userDataObject.RandomNumber, "1111");
        Assert.assertTrue(usersPage.pageIsDisplayed());
        Assert.assertTrue(usersPage.adminIsDisplayedInList(userDataObject.EmailCoach));
        usersPage.searchByEmail(userDataObject.EmailCoach);
        usersPage.deleteAdmin();
        usersPage.searchByUsername("automation" + userDataObject.RandomNumber);
        Assert.assertFalse(usersPage.deleteAdminIsNotDisplayedInList("automation" + userDataObject.RandomNumber));
    }
}
