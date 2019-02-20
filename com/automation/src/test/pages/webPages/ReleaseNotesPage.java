package pages.webPages;

import common.PageElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ReleaseNotesPage extends BasePage {
    private static final PageElement releaseHeaderText = new PageElement(
            "Release Header Text",
            By.cssSelector("h1[class='hg-article-title']"),
            true);

    public ReleaseNotesPage(WebDriver driver){
        super(driver);
    }

    @Override
    public boolean pageIsDisplayed(){
        return allRequiredElementDisplayed();
    }

    public boolean getReleaseHeaderText(){
        switchToTab(1);
        String releaseHeaderText = getText(ReleaseNotesPage.releaseHeaderText);
        switchToTab(0);
        return releaseHeaderText.equals("Release Notes");
    }

}
