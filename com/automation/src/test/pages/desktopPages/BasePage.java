package pages.desktopPages;

import common.DesktopElement;
import common.PageElement;
import common.ProjectConfig;
import common.driver.DriverFactory;
import io.appium.java_client.MobileBy;
import io.appium.java_client.windows.WindowsDriver;
import org.apache.log4j.Logger;
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

    public BasePage(WindowsDriver driver){
        this.desktop_driver = driver;
        log = Logger.getLogger(this.getClass().getName());
    }


    protected WebElement find(By element) {
        return this.desktop_driver.findElement(element);
    }

    public WebElement find(DesktopElement element) {
        return this.find(element.getLocator());
    }

    protected void click(DesktopElement desktopElement) {
        log.info("Clicking on element: " + desktopElement.name);
        this.find(desktopElement).click();
    }

    protected void waitToBeClickable(By element, int timeout) {
        WebDriverWait wait = new WebDriverWait(this.desktop_driver, timeout);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void waitToBeClickable(By element) {
        this.waitToBeClickable(element, 30);
    }

    protected void waitToBeClickable(DesktopElement element, int timeout) {
        this.waitToBeClickable(element.getLocator(), timeout);
    }

    protected void waitToBeClickable(DesktopElement element) {
        this.waitToBeClickable(element.getLocator(), 30);
    }

    public String getText(DesktopElement desktopElement) {
        log.info("Getting text of element: " + desktopElement.name);
        return this.find(desktopElement).getText();
    }

    public void enterText(DesktopElement desktopElement, String text) {
        this.enterText(desktopElement, text, true);
    }

    public void enterText(DesktopElement desktopElement, String text, boolean clearField) {
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
    * @param element the By object with element name
     * @return the Boolean object with status of the element
     */
    public boolean isElementPresent(By element) {
        boolean elementFound;
        try {
            this.find(element);
            elementFound = true;
        } catch (NoSuchElementException e) {
            elementFound = false;
        }
        return elementFound;
    }

    /**
     * Check is element present in the desktop
     * @param element the DestopElement object with element
     * @return the Boolean object with status of the element
     */
    public boolean isElementPresent(DesktopElement element) {
        return this.isElementPresent(element.getLocator());
    }

    /**
     * Deploy application from the sleep using icons
     */
    protected void deployAppicationUsingIcon() {
        try{
            click(boltApplicationIconBtn);
            log.info("Open application from the desktop menu");
        } catch (NoSuchElementException e){
            click(notificationOverflowBtn);
            click(openBoltBtn);
            log.info("Open application from the tray meny");
        }
    }

    /**
     * Deploy application from the sleep using driver
     */
    protected void deployApplicationUsingDriver(){
        desktop_driver = new DriverFactory().getInstance();
    }
}
