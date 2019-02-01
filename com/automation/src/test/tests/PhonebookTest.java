package tests;

import common.Config;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PhonebookTest extends BaseTest {

    @Test(description = "SQE-28 Phonebook tab - User Listing: sort by Mobile", priority = 1)
    public void phonebookTabUserListingSortByMobile(){
        driver.get(Config.BASE_URL);
        Assert.assertTrue(loginPage.pageIsDisplayed());
        loginPage.makeLogin(Config.BASE_USERNAME, Config.BASE_PASSWORD);
        dashboardPage.openPhonebookPage();
        Assert.assertTrue(userListingPage.pageIsDisplayed(), "User Listing page is opened");
        Assert.assertTrue(userListingPage.sortNumberElementsByDesc(), "All mobiles should be sorted by descending");
        Assert.assertTrue(userListingPage.sortNumberElementsByAsc(), "All mobiles should be sorted by ascending");
    }

    @Test(description = "SQE-29 Phonebook tab - User Listing: sort by DID", priority = 2)
    public void phonebookTabUserListingSortByDid(){
        driver.get(Config.BASE_URL);
        Assert.assertTrue(loginPage.pageIsDisplayed());
        loginPage.makeLogin(Config.BASE_USERNAME, Config.BASE_PASSWORD);
        dashboardPage.openPhonebookPage();
        Assert.assertTrue(userListingPage.pageIsDisplayed(), "User Listing page is opened");
        Assert.assertTrue(userListingPage.sortDidElementsByDesc(), "All DID's should be sorted by descending");
        Assert.assertTrue(userListingPage.sortDidElementsByAsc(), "All DID's should be sorted by ascending");
    }

    //should be failed: https://kerauno.atlassian.net/browse/KER-2061
    @Test(description = "SQE-31 Phonebook tab - User Listing: sort by Departments", priority = 3)
    public void phonebookTabUserListingSortByDepartments(){
        driver.get(Config.BASE_URL);
        Assert.assertTrue(loginPage.pageIsDisplayed());
        loginPage.makeLogin(Config.BASE_USERNAME, Config.BASE_PASSWORD);
        dashboardPage.openPhonebookPage();
        Assert.assertTrue(userListingPage.pageIsDisplayed(), "User Listing page is opened");
        Assert.assertTrue(userListingPage.sortDepartmentElementsByDesc(), "All Department's should be sorted by descending");
        Assert.assertTrue(userListingPage.sortDepartmentElementsByAsc(), "All Department's should be sorted by ascending");
    }

    @Test(description = "SQE-32 Phonebook tab - User Listing: sort by Extensions", priority = 4)
    public void phonebookTabUserListingSortByExtensions(){
        driver.get(Config.BASE_URL);
        Assert.assertTrue(loginPage.pageIsDisplayed());
        loginPage.makeLogin(Config.BASE_USERNAME, Config.BASE_PASSWORD);
        dashboardPage.openPhonebookPage();
        Assert.assertTrue(userListingPage.pageIsDisplayed(), "User Listing page is opened");
        Assert.assertTrue(userListingPage.sortExtensionElementsByDesc(), "All Extensions should be sorted by descending");
        Assert.assertTrue(userListingPage.sortExtensionElementsByAsc(), "All Extensions should be sorted by ascending");
    }
}