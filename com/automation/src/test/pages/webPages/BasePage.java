package pages.webPages;

import com.google.common.base.Function;
import common.PageElement;
import common.Utils;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public abstract class BasePage {

    protected WebDriver driver;
    protected Logger log;

    protected BasePage(WebDriver driver){
        this.driver = driver;
        log = Logger.getLogger(this.getClass().getCanonicalName());
    }

    public abstract boolean pageIsDisplayed();


    public String getText(PageElement pageElement){
        log.info("Getting text of element: " + pageElement.name);
        return this.find(pageElement).getText();
    }

    public void enterText(PageElement pageElement, String text){
        this.enterText(pageElement, text, true);
    }

    public void enterText(PageElement pageElement, String text, boolean clearField){
        log.info("Entering text \"" + text + "\" to element: " + pageElement.name);
        this.find(pageElement).click();
        if (clearField) {
            this.find(pageElement).clear();
        }
        this.find(pageElement).sendKeys(text);
    }

    public void click(PageElement pageElement){
        log.info("Clicking on element: " + pageElement.name);
        this.find(pageElement).click();
    }

    public WebElement find(By element){
        return this.driver.findElement(element);
    }

    public WebElement find(PageElement element){
        return this.find(element.getLocator());
    }

    public List<WebElement> findAll(By element){
        return this.driver.findElements(element);
    }

    public List<WebElement> findAll(PageElement element){
        return this.findAll(element.getLocator());
    }

    /**
     * Gets all elements on the page from the page object.
     *
     * @return a list of all the elements in this object.
     */
    public List<PageElement> getElements(){
        List<PageElement> elements = new ArrayList<PageElement>();
        for (Field field : this.getClass().getDeclaredFields()) {
            if (field.getType().getSimpleName().equals("PageElement")) {
                try {
                    field.setAccessible(true);
                    elements.add((PageElement) field.get(PageElement.class));
                    field.setAccessible(false);
                } catch (IllegalAccessException ignored) {
                    System.out.println(ignored.toString());
                }
            }
        }
        return elements;
    }

    /**
     * Gets the required elements for this page.
     *
     * @return an array of the required elements on this page.
     */
    public List<PageElement> getRequiredElements(){
        ArrayList<PageElement> requiredElements = new ArrayList<PageElement>();
        for (PageElement ele : this.getElements()) {
            if (ele.required) {
                requiredElements.add(ele);
            }
        }
        return requiredElements;
    }

    /**
     * Returns an array of all the required elements that were not visible on the current page.
     *
     * @return all the elements in the array that were not visible.
     */
    public ArrayList<PageElement> getMissingRequiredElements(List<PageElement> requiredElements){
        ArrayList<PageElement> elements = new ArrayList<PageElement>(requiredElements);
        for (PageElement ele : requiredElements) {
            if (this.isElementPresent(ele)) {
                elements.remove(ele);
            } else {
                log.info("Missed required element: " + ele.name);
            }
        }
        return elements;
    }

    protected boolean allRequiredElementDisplayed(){
        log.info("Checking if all required elements present on page");
        return this.getMissingRequiredElements(this.getRequiredElements()).isEmpty();
    }

    public boolean isElementPresent(By element){
        boolean elementFound;
        try {
            this.find(element);
            elementFound = true;
        } catch (NoSuchElementException e) {
            elementFound = false;
        }
        return elementFound;
    }

    public boolean isElementPresent(PageElement element){
        return this.isElementPresent(element.getLocator());
    }

    /**
     * Waits for the specified timeout period for an element to be visible.
     *
     * @param element the By object representing the element to wait for.
     * @param timeout the length of time in seconds to wait, as an integer.
     */
    public void waitToBeVisible(final By element, int timeout){
        Wait<WebDriver> wait = new FluentWait<WebDriver>(this.driver)
                .withTimeout(timeout, TimeUnit.SECONDS)
                .pollingEvery(1, TimeUnit.SECONDS)
                .ignoreAll(Arrays.asList(ElementNotVisibleException.class, NoSuchElementException.class, StaleElementReferenceException.class, WebDriverException.class));
        wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver input){
                return input.findElement(element);
            }
        });
    }

    public void waitToBeVisible(By element){
        this.waitToBeVisible(element, 30);
    }

    public void waitToBeVisible(PageElement element, int timeout){
        this.waitToBeVisible(element.getLocator(), timeout);
    }

    public void waitToBeVisible(PageElement element){
        this.waitToBeVisible(element.getLocator(), 30);
    }

    /**
     * Waits for the specified timeout period for an element to be invisible.
     *
     * @param element the By object representing the element to wait for.
     * @param timeout the length of time in seconds to wait, as an integer.
     */
    public void waitToBeInvisible(By element, int timeout){
        WebDriverWait wait = new WebDriverWait(this.driver, timeout);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(element));
    }

    public void waitToBeInvisible(By element){
        this.waitToBeInvisible(element, 60);
    }

    public void waitToBeInvisible(PageElement element, int timeout){
        log.info("Wait to be invisible " + element.name + " ...");
        this.waitToBeInvisible(element.getLocator(), timeout);
    }

    public void waitToBeInvisible(PageElement element){
        this.waitToBeInvisible(element.getLocator(), 60);
    }

    /**
     * Waits for the specified timeout period for an element to be clickable.
     *
     * @param element the By object representing the element to wait for.
     * @param timeout the length of time in seconds to wait, as an integer.
     */
    public void waitToBeClickable(By element, int timeout){
        WebDriverWait wait = new WebDriverWait(this.driver, timeout);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitToBeClickable(By element){
        this.waitToBeClickable(element, 30);
    }

    public void waitToBeClickable(PageElement element, int timeout){
        this.waitToBeClickable(element.getLocator(), timeout);
    }

    public void waitToBeClickable(PageElement element){
        this.waitToBeClickable(element.getLocator(), 30);
    }

    /**
     * Waits for the specified timeout period for an element to be present.
     *
     * @param element the By object representing the element to wait for.
     * @param timeout the length of time in seconds to wait, as an integer.
     */
    public void waitToBePresent(By element, int timeout){
        WebDriverWait wait = new WebDriverWait(this.driver, timeout);
        wait.until(ExpectedConditions.presenceOfElementLocated(element));
    }

    public void waitToBePresent(By element){
        this.waitToBePresent(element, 30);
    }

    public void waitToBePresent(PageElement element, int timeout){
        this.waitToBePresent(element.getLocator(), timeout);
    }

    public void waitToBePresent(PageElement element){
        this.waitToBePresent(element.getLocator(), 30);
    }

    public void selectFromSelectBox(PageElement selectBox, String value){
        log.info("Selecting \"" + value + "\" from: " + selectBox.name);
        Select dropdown = new Select(find(selectBox));
        dropdown.selectByVisibleText(value);
    }

    public void selectFromDropdown(WebElement dropdown){
        Select listDropdown = new Select(dropdown);
        List<WebElement> list = listDropdown.getOptions();
        listDropdown.selectByIndex(Utils.getRandomInteger(list.size()));
    }

    public void waitToBeAlertPresent(int timeout){
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            wait.until(ExpectedConditions.alertIsPresent());
        } catch (NoAlertPresentException ex) {
            log.info("No Alert Present");
        }
    }

    public String getTextFromAlert(){
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        log.info("Alert Text" + alertText);
        return alertText;
    }


    public void acceptAlert(){
        driver.switchTo().alert().accept();
    }

    /**
     * Waits for the specified timeout period for an element to be present.
     *
     * @param element   the By object representing the element to wait for.
     * @param attribute attribute of the element
     */
    public String getAttribute(PageElement element, String attribute){
        return driver.findElement(element.locator).getAttribute(attribute);
    }

    public void waitUntilPageLoad(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public boolean isElementsSorted(PageElement arrowButton, PageElement element, String order){
        ArrayList<String> obtainedList = new ArrayList<>();
        List<WebElement> elementList = findAll(element);
        for (WebElement we : elementList) {
            //obtainedList.add(we.getText().toUpperCase());
            obtainedList.add(we.getText());
        }
        if (order == "By asc") {
            waitToBeClickable(arrowButton);
            click(arrowButton);
        } else if (order == "By desc") {
            waitToBeClickable(arrowButton);
            click(arrowButton);
            click(arrowButton);
        } else System.out.println("Please choose type of sort");
        List<WebElement> elementList1 = findAll(element);
        ArrayList<String> obtainedAfterClickList = new ArrayList<>();
        for (WebElement we : elementList1) {
            //obtainedAfterClickList.add(we.getText().toUpperCase());
            obtainedAfterClickList.add(we.getText());
        }
        ArrayList<String> sortedList = new ArrayList<>();
        for (String s : obtainedList) {
            sortedList.add(s);
        }
        if (order == "By asc")
            Collections.sort(sortedList);
        else if (order == "By desc") Collections.sort(sortedList, Collections.reverseOrder());
        else System.out.println("Please choose type of sort");
        System.out.println(obtainedList);
        System.out.println(obtainedAfterClickList);
        System.out.println(sortedList);
        return obtainedAfterClickList.equals(sortedList);
    }
}