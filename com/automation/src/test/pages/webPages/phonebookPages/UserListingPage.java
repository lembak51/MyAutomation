package pages.webPages.phonebookPages;

import common.PageElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.webPages.BasePage;

public class UserListingPage extends BasePage {
    private static final PageElement mobileArrowBtn = new PageElement(
            "Mobile Arrow button",
            By.cssSelector("sort-chevron[data-text='Mobile'] > span > span.fa.cursor"), //need to change: sort-chevron[data-text='Mobile']>span>span[1]
            true);
    private static final PageElement firstElementInMobileColumnMsb = new PageElement(
            "First element in Mobile column",
            By.cssSelector("tr > td:nth-child(3) > call"),
            true);
    private static final PageElement didArrowBtn = new PageElement(
            "DID Arrow button",
            By.cssSelector("sort-chevron[data-text='DID'] > span > span.fa.cursor"), //need to change: sort-chevron[data-text='Mobile']>span>span[1]
            true);
    private static final PageElement firstElementInDidColumnMsb = new PageElement(
            "First element in DID column",
            By.cssSelector("tr > td:nth-child(4) > call"),
            true);
    private static final PageElement departmentArrowBtn = new PageElement(
            "Department(s) Arrow button",
            By.cssSelector("sort-chevron[data-text='Department(s)'] > span > span.fa.cursor"), //need to change: sort-chevron[data-text='Mobile']>span>span[1]
            true);
    private static final PageElement firstElementInDepartmentColumnMsb = new PageElement(
            "First element in Department(s) column",
            By.cssSelector("tr:nth-child(1) > td.small > span"),
            true);
    private static final PageElement extensionArrowBtn = new PageElement(
            "Extension(s) Arrow button",
            By.cssSelector("sort-chevron[data-text='Extension(s)'] > span > span.fa.cursor"), //need to change: sort-chevron[data-text='Mobile']>span>span[1]
            true);
    private static final PageElement firstElementInExtensionColumnMsb = new PageElement(
            "First element in Extension(s) column",
            By.cssSelector("td:nth-child(6) > span > call > span.ng-scope > span"),
            true);


    public UserListingPage(WebDriver driver){
        super(driver);
    }

    @Override
    public boolean pageIsDisplayed(){
        return allRequiredElementDisplayed();
    }

    public boolean sortNumberElementsByAsc(){
        return isElementsSorted(mobileArrowBtn, firstElementInMobileColumnMsb, "By asc");
    }

    public boolean sortNumberElementsByDesc(){
        return isElementsSorted(mobileArrowBtn, firstElementInMobileColumnMsb, "By desc");
    }

    public boolean sortDidElementsByAsc(){
        return isElementsSorted(didArrowBtn, firstElementInDidColumnMsb, "By asc");
    }

    public boolean sortDidElementsByDesc(){
        return isElementsSorted(didArrowBtn, firstElementInDidColumnMsb, "By desc");
    }

    public boolean sortDepartmentElementsByAsc(){
        return isElementsSorted(departmentArrowBtn, firstElementInDepartmentColumnMsb, "By asc");
    }

    public boolean sortDepartmentElementsByDesc(){
        return isElementsSorted(departmentArrowBtn, firstElementInDepartmentColumnMsb, "By desc");
    }

    public boolean sortExtensionElementsByAsc(){
        return isElementsSorted(extensionArrowBtn, firstElementInExtensionColumnMsb, "By asc");
    }

    public boolean sortExtensionElementsByDesc(){
        return isElementsSorted(extensionArrowBtn, firstElementInExtensionColumnMsb, "By desc");
    }
}