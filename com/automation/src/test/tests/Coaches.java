package tests;


import common.Config;
import common.dataObjects.UserDataObject;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pages.webPages.BasePage;


public class Coaches extends BaseTest {
    @Test(description = "C91040 Create new coaches with male gender", priority = 0)
    public void createCoach()  {
        UserDataObject userDataObject = new UserDataObject();
        driver.get(Config.BASE_URL);
        Assert.assertTrue(loginPage.pageIsDisplayed(), "Login Page should be displayed ");
        loginPage.makeLogin(Config.BASE_USERNAME, Config.BASE_PASSWORD);
        dashboardPage.goToSchoolList();
        Assert.assertTrue(schoolListPage.pageIsDisplayed());
        schoolListPage.goToCreateSchoolPage();
        Assert.assertTrue(createSchoolPage.pageIsDisplayed());
        createSchoolPage.createSchool(userDataObject.SchoolName,"1111","1111");
        Assert.assertTrue(schoolListPage.pageIsDisplayed());
        schoolListPage.searchSchool(userDataObject.SchoolName);
        schoolListPage.schoolIsDisplayedInList(userDataObject.SchoolName);
        dashboardPage.goToCoachesList();
        coachesPage.goTocreatepage();
        createCoachesPage.additionFeld("Auto_coacch_for_school", userDataObject.SchoolName, "test","A2","(111) 111-1111");
        createCoachesPage.fiellFieldsCredentials(userDataObject.EmailCoach, "111");
        createCoachesPage.selectAlaskaState();
        createCoachesPage.selectAdakCity(userDataObject.SchoolName);
        createCoachesPage.clickonGenderMale();
        createCoachesPage.selectDate();
        createCoachesPage.ceateCoach();
        coachesPage.searchName(userDataObject.SchoolName);
        coachesPage.waitSearch(userDataObject.SchoolName);
    }


    @Test(description = "C91041 Create new coaches - Delete Coaches", priority = 1)
    public void createDeleteCoach()  {
        UserDataObject userDataObject = new UserDataObject();
        driver.get(Config.BASE_URL);
        Assert.assertTrue(loginPage.pageIsDisplayed(), "Login Page should be displayed ");
        loginPage.makeLogin(Config.BASE_USERNAME, Config.BASE_PASSWORD);
        dashboardPage.goToSchoolList();
        Assert.assertTrue(schoolListPage.pageIsDisplayed());
        schoolListPage.goToCreateSchoolPage();
        Assert.assertTrue(createSchoolPage.pageIsDisplayed());
        createSchoolPage.createSchool(userDataObject.SchoolName,"1111","1111");
        Assert.assertTrue(schoolListPage.pageIsDisplayed());
        schoolListPage.searchSchool(userDataObject.SchoolName);
        schoolListPage.schoolIsDisplayedInList(userDataObject.SchoolName);
        dashboardPage.goToCoachesList();
        coachesPage.goTocreatepage();
        createCoachesPage.additionFeld("Auto_coacch_for_school", userDataObject.SchoolName, "test","A2","(111) 111-1111");
        createCoachesPage.fiellFieldsCredentials(userDataObject.EmailCoach, "111");
        createCoachesPage.selectAlaskaState();
        createCoachesPage.selectAdakCity(userDataObject.SchoolName);
        createCoachesPage.clickonGenderMale();
        createCoachesPage.selectDate();
        createCoachesPage.ceateCoach();
        coachesPage.searchName(userDataObject.SchoolName);
        coachesPage.waitSearch(userDataObject.SchoolName);
        coachesPage.deletecoach();
    }

    @Test(description = "C91042 Create new coaches - Edit First name and Last name", priority = 2)
    public void editCoach()  {
        UserDataObject userDataObject = new UserDataObject();
        driver.get(Config.BASE_URL);
        Assert.assertTrue(loginPage.pageIsDisplayed(), "Login Page should be displayed ");
        loginPage.makeLogin(Config.BASE_USERNAME, Config.BASE_PASSWORD);
        dashboardPage.goToSchoolList();
        Assert.assertTrue(schoolListPage.pageIsDisplayed());
        schoolListPage.goToCreateSchoolPage();
        Assert.assertTrue(createSchoolPage.pageIsDisplayed());
        createSchoolPage.createSchool(userDataObject.SchoolName,"1111","1111");
        Assert.assertTrue(schoolListPage.pageIsDisplayed());
        schoolListPage.searchSchool(userDataObject.SchoolName);
        schoolListPage.schoolIsDisplayedInList(userDataObject.SchoolName);
        dashboardPage.goToCoachesList();
        coachesPage.goTocreatepage();
        createCoachesPage.additionFeld("Auto_coacch_for_school", userDataObject.SchoolName, "test","A2","(111) 111-1111");
        createCoachesPage.fiellFieldsCredentials(userDataObject.EmailCoach, "111");
        createCoachesPage.selectAlaskaState();
        createCoachesPage.selectAdakCity(userDataObject.SchoolName);
        createCoachesPage.clickonGenderMale();
        createCoachesPage.selectDate();
        createCoachesPage.ceateCoach();
        coachesPage.searchName(userDataObject.SchoolName);
        coachesPage.clickOnCoach(userDataObject.SchoolName);
        createCoachesPage.editFirstLastName("Editable auto coach"+ userDataObject.RandomNumber, userDataObject.SchoolName);
        createCoachesPage.updateCoach();
        coachesPage.searchName(userDataObject.SchoolName);
        Assert.assertTrue(coachesPage.coachIsDisplayedInList("Editable auto coach"+userDataObject.RandomNumber));
    }
//div[contains(@class,'rt-tr -odd')]
@Test(description = "C91039 Create new coaches with female gender", priority = 3)
public void femaleCoach()  {
    UserDataObject userDataObject = new UserDataObject();
    driver.get(Config.BASE_URL);
    Assert.assertTrue(loginPage.pageIsDisplayed(), "Login Page should be displayed ");
    loginPage.makeLogin(Config.BASE_USERNAME, Config.BASE_PASSWORD);
    dashboardPage.goToSchoolList();
    Assert.assertTrue(schoolListPage.pageIsDisplayed());
    schoolListPage.goToCreateSchoolPage();
    Assert.assertTrue(createSchoolPage.pageIsDisplayed());
    createSchoolPage.createSchool(userDataObject.SchoolName,"1111","1111");
    Assert.assertTrue(schoolListPage.pageIsDisplayed());
    schoolListPage.searchSchool(userDataObject.SchoolName);
    schoolListPage.schoolIsDisplayedInList(userDataObject.SchoolName);
    dashboardPage.goToCoachesList();
    coachesPage.goTocreatepage();
    createCoachesPage.additionFeld("Auto_coacch_for_school", userDataObject.SchoolName, "test","A2","(111) 111-1111");
    createCoachesPage.fiellFieldsCredentials(userDataObject.EmailCoach, "111");
    createCoachesPage.selectAlaskaState();
    createCoachesPage.selectAdakCity(userDataObject.SchoolName);
    createCoachesPage.clickonGenderFemale();
    createCoachesPage.selectDate();
    createCoachesPage.ceateCoach();
    coachesPage.searchName(userDataObject.SchoolName);
    Assert.assertTrue(coachesPage.coachIsDisplayedInList(userDataObject.SchoolName));
}


    @Test(description = "Create new coaches - Search Address", priority = 4)
    public void searchByAddress()  {
        UserDataObject userDataObject = new UserDataObject();
        driver.get(Config.BASE_URL);
        Assert.assertTrue(loginPage.pageIsDisplayed(), "Login Page should be displayed ");
        loginPage.makeLogin(Config.BASE_USERNAME, Config.BASE_PASSWORD);
        dashboardPage.goToSchoolList();
        Assert.assertTrue(schoolListPage.pageIsDisplayed());
        schoolListPage.goToCreateSchoolPage();
        Assert.assertTrue(createSchoolPage.pageIsDisplayed());
        createSchoolPage.createSchool(userDataObject.SchoolName,"1111","1111");
        Assert.assertTrue(schoolListPage.pageIsDisplayed());
        schoolListPage.searchSchool(userDataObject.SchoolName);
        schoolListPage.schoolIsDisplayedInList(userDataObject.SchoolName);
        dashboardPage.goToCoachesList();
        coachesPage.goTocreatepage();
        createCoachesPage.additionFeld("Auto_coacch_for_school", userDataObject.SchoolName, "SpecialAddress","A2","(111) 111-1111");
        createCoachesPage.fiellFieldsCredentials(userDataObject.EmailCoach, "111");
        createCoachesPage.selectAlaskaState();
        createCoachesPage.selectAdakCity(userDataObject.SchoolName);
        createCoachesPage.clickonGenderFemale();
        createCoachesPage.selectDate();
        createCoachesPage.ceateCoach();
        coachesPage.searchAddress("SpecialAddress");
        Assert.assertTrue(coachesPage.coachIsDisplayedInList(userDataObject.SchoolName));
    }

    @Test(description = "Create new coaches - Search Address", priority = 5)
    public void sortAddress()  {
        UserDataObject userDataObject = new UserDataObject();
        driver.get(Config.BASE_URL);
        Assert.assertTrue(loginPage.pageIsDisplayed(), "Login Page should be displayed ");
        loginPage.makeLogin(Config.BASE_USERNAME, Config.BASE_PASSWORD);
        dashboardPage.goToCoachesList();
        Assert.assertTrue(coachesPage.sortAddress());

    }
}
