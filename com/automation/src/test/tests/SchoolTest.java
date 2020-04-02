package tests;


import common.Config;
import common.PageElement;
import common.dataObjects.UserDataObject;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;


public class SchoolTest extends BaseTest {
        @Test(description = "C91044 Create new school", priority = 0)
        public void createSchool() {
            UserDataObject userDataObject = new UserDataObject();
            driver.get(Config.BASE_URL);
            Assert.assertTrue(loginPage.pageIsDisplayed(), "Login Page should be displayed ");
            loginPage.makeLogin(Config.BASE_USERNAME, Config.BASE_PASSWORD);//Replace step 2-4
            Assert.assertTrue(dashboardPage.pageIsDisplayed());
            dashboardPage.goToSchoolList();
            Assert.assertTrue(schoolListPage.pageIsDisplayed());
            schoolListPage.goToCreateSchoolPage();
            Assert.assertTrue(createSchoolPage.pageIsDisplayed());
            createSchoolPage.createSchool(userDataObject.SchoolName,"1111","1111");
            Assert.assertTrue(schoolListPage.pageIsDisplayed());
            schoolListPage.searchSchool(userDataObject.SchoolName);
            schoolListPage.schoolIsDisplayedInList(userDataObject.SchoolName);
            dashboardPage.logout();

 //    public boolean isSeasonDeleted(String strSeasonName){
 //        PageElement season = new PageElement(
 //                "Season in list of seasons",
 //                By.xpath("//td[contains(.,'" + strSeasonName + "')]"),
 //                false);
 //        return isElementPresent(season);
 //    }


        }
    @Test(description = "C91045 Create new school - Delete new school", priority = 1)
    public void createDeleteSchool() {
        UserDataObject userDataObject = new UserDataObject();
        driver.get(Config.BASE_URL);
        Assert.assertTrue(loginPage.pageIsDisplayed(), "Login Page should be displayed ");
        loginPage.makeLogin(Config.BASE_USERNAME, Config.BASE_PASSWORD);//Replace step 2-4
        Assert.assertTrue(dashboardPage.pageIsDisplayed());
        dashboardPage.goToSchoolList();
        Assert.assertTrue(schoolListPage.pageIsDisplayed());
        schoolListPage.goToCreateSchoolPage();
        Assert.assertTrue(createSchoolPage.pageIsDisplayed());
        createSchoolPage.createSchool(userDataObject.SchoolName,"1111","1111");
        Assert.assertTrue(schoolListPage.pageIsDisplayed());
        schoolListPage.searchSchool(userDataObject.SchoolName);
        schoolListPage.schoolIsDisplayedInList(userDataObject.SchoolName);
        schoolListPage.deletSchool();
        dashboardPage.logout();
        Assert.assertTrue(loginPage.pageIsDisplayed());}

    @Test(description = "C91046 Create new school - Edit Name", priority = 2)
    public void createEditSchool() {
        UserDataObject userDataObject = new UserDataObject();
        driver.get(Config.BASE_URL);
        Assert.assertTrue(loginPage.pageIsDisplayed(), "Login Page should be displayed ");
        loginPage.makeLogin(Config.BASE_USERNAME, Config.BASE_PASSWORD);//Replace step 2-4
        Assert.assertTrue(dashboardPage.pageIsDisplayed());
        dashboardPage.goToSchoolList();
        Assert.assertTrue(schoolListPage.pageIsDisplayed());
        schoolListPage.goToCreateSchoolPage();
        Assert.assertTrue(createSchoolPage.pageIsDisplayed());
        createSchoolPage.createSchool(userDataObject.SchoolName, "1111", "1111");
        Assert.assertTrue(schoolListPage.pageIsDisplayed());
        schoolListPage.searchSchool(userDataObject.SchoolName);
        schoolListPage.schoolIsDisplayedInList(userDataObject.SchoolName);
        schoolListPage.clickOnSchool();
        createSchoolPage.editNmaeSchool("Editebel" + userDataObject.SchoolName);
        schoolListPage.searchSchool("Editebel" + userDataObject.SchoolName );
        Assert.assertTrue(schoolListPage.schoolIsDisplayedInList("Editebel" + userDataObject.SchoolName ));

    }


    }


