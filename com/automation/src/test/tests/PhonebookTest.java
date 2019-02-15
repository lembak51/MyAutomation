package tests;

import common.Config;
import common.dataObjects.PhonebookDataObject;
import common.dataObjects.UserDataObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PhonebookTest extends BaseTest {
    UserDataObject preconditionUserDate = new UserDataObject();
    @BeforeMethod
    public void loginBeforeTest(){
        driver.get(Config.BASE_URL);
        Assert.assertTrue(loginPage.pageIsDisplayed());
        loginPage.makeLogin(Config.BASE_USERNAME, Config.BASE_PASSWORD);
        dashboardPage.pageIsDisplayed();
    }

    @Test(description = "dependent test for SQE-39")
    public void createUserForPhonebook(){
        dashboardPage.openUserTab();
        Assert.assertTrue(usersPage.pageIsDisplayed(), "User page should be displayed");
        usersPage.clickAddUserBtn();
        Assert.assertTrue(addUsersPage.pageIsDisplayed(), "Add Users Page should be displayed");
        addUsersPage.createNewUser(preconditionUserDate);
    }


    @Test(description = "SQE-28 Phonebook tab - User Listing: sort by Mobile")
    public void phonebookTabUserListingSortByMobile(){
        dashboardPage.openPhonebookPage();
        Assert.assertTrue(userListingPage.pageIsDisplayed(), "User Listing page is opened");
        Assert.assertTrue(userListingPage.sortNumberElementsByDesc(), "All mobiles should be sorted by descending");
        Assert.assertTrue(userListingPage.sortNumberElementsByAsc(), "All mobiles should be sorted by ascending");
    }

    @Test(description = "SQE-29 Phonebook tab - User Listing: sort by DID")
    public void phonebookTabUserListingSortByDid(){

        dashboardPage.openPhonebookPage();
        Assert.assertTrue(userListingPage.pageIsDisplayed(), "User Listing page is opened");
        Assert.assertTrue(userListingPage.sortDidElementsByDesc(), "All DID's should be sorted by descending");
        Assert.assertTrue(userListingPage.sortDidElementsByAsc(), "All DID's should be sorted by ascending");
    }

    //TODO should be failed because of https://kerauno.atlassian.net/browse/KER-2061
    @Test(description = "SQE-31 Phonebook tab - User Listing: sort by Departments")
    public void phonebookTabUserListingSortByDepartments(){
        dashboardPage.openPhonebookPage();
        Assert.assertTrue(userListingPage.pageIsDisplayed(), "User Listing page is opened");
        Assert.assertTrue(userListingPage.sortDepartmentElementsByDesc(), "All Department's should be sorted by descending");
        Assert.assertTrue(userListingPage.sortDepartmentElementsByAsc(), "All Department's should be sorted by ascending");
    }

    @Test(description = "SQE-32 Phonebook tab - User Listing: sort by Extensions")
    public void phonebookTabUserListingSortByExtensions(){
        dashboardPage.openPhonebookPage();
        Assert.assertTrue(userListingPage.pageIsDisplayed(), "User Listing page is opened");
        Assert.assertTrue(userListingPage.sortExtensionElementsByDesc(), "All Extensions should be sorted by descending");
        Assert.assertTrue(userListingPage.sortExtensionElementsByAsc(), "All Extensions should be sorted by ascending");
    }

    //TODO should be failed because of issue(extension button is not clickable)
    @Test(description = "SQE-34 Phonebook tab - User Listing: view user information")
    public void phonebookTabUserListingViewUserInformation(){
        dashboardPage.openPhonebookPage();
        Assert.assertTrue(userListingPage.pageIsDisplayed(), "User Listing page is opened");
        PhonebookDataObject expectedDataObject = userListingPage.getValuesFromTheTable();
        PhonebookDataObject actualDataObject = userListingPage.getValuesFromPopUp();
        Assert.assertTrue(actualDataObject.isPhoneBookDataSame(expectedDataObject), "Data from the page and pop-up should be a same");
    }

    @Test(description = "SQE-39 Phonebook tab - User Listing: find user by Name",dependsOnMethods={"createUserForPhonebook"})
    public void userListingFindUserByName(){
        dashboardPage.openPhonebookPage();
        Assert.assertTrue(userListingPage.pageIsDisplayed(),"User Listing page is opened");
        userListingPage.fillUsersSearchFld(preconditionUserDate.Username);
        Assert.assertTrue(userListingPage.isFindInList(preconditionUserDate.Username),"User find in list by Name");
    }

    @Test(description = "SQE-40 Phonebook tab - User Listing: find user by Mobile",dependsOnMethods={"createUserForPhonebook"})
    public void userListingFindUserByMobile(){
        dashboardPage.openPhonebookPage();
        Assert.assertTrue(userListingPage.pageIsDisplayed(),"User Listing page is opened");
        userListingPage.fillUsersSearchFld(preconditionUserDate.MobileNumber);
        Assert.assertTrue(userListingPage.isFindInList(preconditionUserDate.Username),"User find in list by Name");
    }
}