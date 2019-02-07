package pages.webPages.phonebookPages;

import common.PageElement;
import common.dataObjects.PhonebookDataObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.webPages.BasePage;

public class UserListingPage extends BasePage {
    private static final PageElement mobileArrowBtn = new PageElement(
            "Mobile Arrow button",
            By.cssSelector("sort-chevron[data-text='Mobile'] > span > span.fa.cursor"),
            true);
    private static final PageElement firstElementInMobileColumnMsb = new PageElement(
            "First element in Mobile column",
            By.cssSelector("tr > td:nth-child(3) > call"),
            true);
    private static final PageElement didArrowBtn = new PageElement(
            "DID Arrow button",
            By.cssSelector("sort-chevron[data-text='DID'] > span > span.fa.cursor"),
            true);
    private static final PageElement firstElementInDidColumnMsb = new PageElement(
            "First element in DID column",
            By.cssSelector("tr > td:nth-child(4) > call"),
            true);
    private static final PageElement departmentArrowBtn = new PageElement(
            "Department(s) Arrow button",
            By.cssSelector("sort-chevron[data-text='Department(s)'] > span > span.fa.cursor"),
            true);
    private static final PageElement firstElementInDepartmentColumnMsb = new PageElement(
            "First element in Department(s) column",
            By.cssSelector("tr:nth-child(1) > td.small > span"),
            true);
    private static final PageElement extensionArrowBtn = new PageElement(
            "Extension(s) Arrow button",
            By.cssSelector("sort-chevron[data-text='Extension(s)'] > span > span.fa.cursor"),
            true);
    private static final PageElement firstElementInExtensionColumnMsb = new PageElement(
            "First element in Extension(s) column",
            By.cssSelector("td:nth-child(6) > span > call > span.ng-scope > span"),
            true);
    private static final PageElement firstNameinTableMsb = new PageElement(
            "First name in table",
            By.xpath("//tr[1]/td[1]/strong"),
            false);
    private static final PageElement firstEmailInTableMsb = new PageElement(
            "First email in the table",
            By.xpath("//tr[1]/td[2]/a"),
            false);
    private static final PageElement firstNumberInTableMsb = new PageElement(
            "First number in the table",
            By.xpath("//tr[1]/td[3]/call/span[2]/span"),
            false);
    private static final PageElement firstNameinPopUpMsb = new PageElement(
            "First name in pop-up",
            By.xpath("//div[2]/div/div[1]/div[2]/span[1]"),
            false);
    private static final PageElement firstEmailInPopUpMsb = new PageElement(
            "First email in the pop-up",
            By.xpath("//div/strong/a"),
            false);
    private static final PageElement firstNumberInPopUpMsb = new PageElement(
            "First number in the pop-up",
            By.xpath("//strong/strong/span"),
            false);


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

    public String getNameTextFromTheTable(){
        return getText(firstNameinTableMsb);
    }

    public String getEmailTextFromTheTable(){
        return getText(firstEmailInTableMsb);
    }

    public String getNumberTextFromTheTable(){
        return getText(firstNumberInTableMsb);
    }

    public String getNameTextFromThePopUp(){
        return getText(firstNameinPopUpMsb);
    }

    public String getEmailTextFromThePopUp(){
        return getText(firstEmailInPopUpMsb);
    }

    public String getNumberTextFromThePopUp(){
        return getText(firstNumberInPopUpMsb);
    }

    public PhonebookDataObject getValuesFromTheTable(){
        PhonebookDataObject expectedDataObject = new PhonebookDataObject();
        expectedDataObject.Name = getNameTextFromTheTable();
        expectedDataObject.Email = getEmailTextFromTheTable();
        expectedDataObject.Number = getNumberTextFromTheTable();
        return expectedDataObject;
    }

    public PhonebookDataObject getValuesFromPopUp(){
        PhonebookDataObject actualDataObject = new PhonebookDataObject();
        actualDataObject.Name = getNameTextFromThePopUp();
        actualDataObject.Email = getEmailTextFromThePopUp();
        actualDataObject.Number = getNumberTextFromThePopUp();
        return actualDataObject;
    }

}
