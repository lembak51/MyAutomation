package pages.desktopPages;

import common.DesktopElement;
import common.ProjectConfig;
import io.appium.java_client.windows.WindowsDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

abstract class BasePage {
    private WindowsDriver desktop_driver;
    public boolean doLogging = true;
    protected Logger log;

    BasePage(WindowsDriver driver){
        this.desktop_driver = driver;
        log = Logger.getLogger(this.getClass().getName());
    }


    protected WebElement find(By element){
        return this.desktop_driver.findElement(element);
    }

    public WebElement find(DesktopElement element){
        return this.find(element.getLocator());
    }

    protected void click(DesktopElement desktopElement){
        log.info("Clicking on element: " + desktopElement.name);
        this.find(desktopElement).click();
    }

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
     * Waits default(1 sec) timeout period
     *
     */
    protected void waitUntilLoad() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Waits default(1 sec) timeout period
     *
     * @param timeout  the Int object representing the value in second that need to wait
     *
     */
    protected void waitUntilLoad(int timeout) {
        try {
            Thread.sleep(timeout*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
