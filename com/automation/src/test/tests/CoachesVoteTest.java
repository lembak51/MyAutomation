package tests;

import common.Config;
import common.dataObjects.UserDataObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.webPages.CoacheVote;

public class CoachesVoteTest extends BaseTest {

    @Test(description = "C91042 Create new coaches - Edit First name and Last name", priority = 2)
    public void createCoachVote()  {

        driver.get(Config.BASE_URL);
        Assert.assertTrue(loginPage.pageIsDisplayed(), "Login Page should be displayed ");
        loginPage.makeLogin(Config.BASE_USERNAME, Config.BASE_PASSWORD);
        dashboardPage.goToCoacheVoteList();
        Assert.assertTrue(coacheVote.pageIsDisplayed());
        coacheVote.goToCreatecoachVote();
        createNewCoacheVote.fillIfrema("auto_text");
        createNewCoacheVote.tryFirst();
        Assert.assertTrue(coacheVote.pageIsDisplayed());



    }
}
