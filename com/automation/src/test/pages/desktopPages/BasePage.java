package pages.desktopPages;

import common.DesktopElement;
import common.PageElement;
import common.ProjectConfig;
import common.driver.DriverFactory;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.windows.WindowsDriver;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

abstract class BasePage {
    protected WindowsDriver desktop_driver;
    public boolean doLogging = true;
    protected Logger log;
    private static final DesktopElement notificationOverflowBtn = new DesktopElement(
            "Windows notifcation center button",
            MobileBy.AccessibilityId("1502"));
    private static final DesktopElement openBoltBtn = new DesktopElement(
            "Bolt application open button",
            By.xpath("//button[@ProcessID='13396'"));
    private static final DesktopElement boltApplicationIconBtn = new DesktopElement(
            "Bolt application button on the ",
            MobileBy.AccessibilityId("Kerauno.Bolt.v2"));

    BasePage(WindowsDriver driver){
        PropertyConfigurator.configure(System.getProperty("user.dir") + "/com/automation/src/resources/log4j.properties");
        this.desktop_driver = driver;
        log = Logger.getLogger(this.getClass().getName());
    }

    /**
     * Find the first WebElement using the given method.
     * This method is affected by the 'implicit wait' times in force at the time of execution. The findElement(..) invocation will return a matching row,
     * or try again repeatedly until the configured timeout is reached. findElement should not be used to look for non-present elements
     *
     * @param element the By object with element name
     */
    protected WebElement find(By element){
        return this.desktop_driver.findElement(element);
    }

    protected WebElement find(MobileBy element){
        return this.desktop_driver.findElement(element);
    }

    public WebElement find(DesktopElement element){
        return this.find(element.getLocator());
    }

    /**
     * Click this element. If this causes a new page to load, you should discard all references to this
     * element and any further operations performed on this element will throw a StaleElementReferenceException.
     * There are some preconditions for an element to be clicked. The element must be visible and it must have a height and width greater then 0.
     *
     * @param desktopElement the DesktopElement object with element
     */
    protected void click(DesktopElement desktopElement){
        log.info("Clicking on element: " + desktopElement.name);
        this.find(desktopElement).click();
    }

    /**
     * Waits for the specified timeout period for an element to be clickable.
     *
     * @param element the DesktopElement object with element
     * @param timeout the length of time in seconds to wait, as an integer.
     */
    protected void waitToBeClickable(By element, int timeout){
        WebDriverWait wait = new WebDriverWait(this.desktop_driver, timeout);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void waitToBeClickable(By element){
        this.waitToBeClickable(element, 30);
    }

    protected void waitToBeClickable(DesktopElement element, int timeout){
        this.waitToBeClickable(element.getLocator(), timeout);
    }

    protected void waitToBeClickable(DesktopElement element){
        this.waitToBeClickable(element.getLocator(), 30);
    }

    /**
     * Get the visible (i.e. not hidden by CSS) text of this element, including sub-elements.
     *
     * @param desktopElement the DesktopElement object with element.
     */
    public String getText(DesktopElement desktopElement){
        log.info("Getting text of element: " + desktopElement.name);
        return this.find(desktopElement).getText();
    }

    /**
     * Get the visible (i.e. not hidden by CSS) text of this element, including sub-elements.
     *
     * @param desktopElement the DesktopElement object with element.
     * @param text           the text that must be entered into DesktopElement.
     */
    public void enterText(DesktopElement desktopElement, String text){
        this.enterText(desktopElement, text, true);
    }

    public void enterText(DesktopElement desktopElement, String text, boolean clearField){
        log.info("Entering text \"" + text + "\" to element: " + desktopElement.name);
        this.find(desktopElement).click();
        if (clearField) {
            this.find(desktopElement).clear();
        }
        this.find(desktopElement).sendKeys(text);
    }

    /**
     * Waits default(1 sec) timeout period
     */
    protected void waitUntilLoad(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Waits default(1 sec) timeout period
     *
     * @param timeout the Int object representing the value in second that need to wait
     */
    protected void waitUntilLoad(int timeout){
        try {
            Thread.sleep(timeout * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Check is element present in the desktop
     *
     * @param element the By object with element name
     * @return the Boolean object with status of the element
     */
    public boolean isElementPresent(By element){
        return this.find(element).isDisplayed();
    }


    /**
     * Check is element present in the desktop
     *
     * @param element the DesktopElement object with element
     * @return the Boolean object with status of the element
     */
    public boolean isElementPresent(DesktopElement element){
        return this.isElementPresent(element.getLocator());
    }

    /**
     * Deploy application from the sleep using icons
     */
    protected void deployAppicationUsingIcon(){
        try {
            click(boltApplicationIconBtn);
            log.info("Open application from the desktop menu");
        } catch (NoSuchElementException e) {
            click(notificationOverflowBtn);
            click(openBoltBtn);
            log.info("Open application from the tray menu");
        }
    }

    /**
     * Deploy application from the sleep using driver
     */
    protected void deployApplicationUsingDriver(){
        desktop_driver = new DriverFactory().getInstance();
    }
}
