package pages.webPages;

import common.PageElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class CoacheVote extends BasePage {

    private static final PageElement createCoacheVoteBttn= new PageElement(
            "Create/Update coach vote button",
            By.xpath("//button[contains(@class,'variant-contained MuiButton-contained MuiButton-containedSecondary')]"),
            true);

    public CoacheVote(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean pageIsDisplayed() {
        return allRequiredElementDisplayed();
    }
    public void goToCreatecoachVote(){
        waitJsLoad();
        click(createCoacheVoteBttn);
        CreateNewCoacheVote B=new CreateNewCoacheVote();
        B.tryFirst();
        System.out.println(B.k);


    }

// public void updateCoacheVote(){

//     CreateNewCoacheVote сreateNewCoacheVote = new CreateNewCoacheVote();
//     String indexStateInTheArray = сreateNewCoacheVote.return CreateNewCoacheVote("dsd");
//     PageElement state = new PageElement(
//             "State in list",
//             By.xpath("//div[contains(text(),'" + indexStateInTheArray + "')]"),
//             true);

// }
}
