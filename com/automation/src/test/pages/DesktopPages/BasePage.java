package pages.DesktopPages;

import common.DesktopElement;
import io.appium.java_client.windows.WindowsDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
    public WindowsDriver desktop_driver;
    public boolean doLogging = true;
    protected Logger log;

    BasePage(WindowsDriver driver){
        this.desktop_driver = driver;
        if (log == null) {
            log = Logger.getLogger(this.getClass().getName());
        }
    }

    public BasePage(BasePage page){
        this(page.desktop_driver);
        log = Logger.getLogger(page.getClass().getName());
    }


    public WebElement find(By element){
        return this.desktop_driver.findElement(element);
    }

    public WebElement find(DesktopElement element){
        return this.find(element.getLocator());
    }

    public void click(DesktopElement desktopElement){
        log.info("Clicking on element: " + desktopElement.name);
        this.find(desktopElement).click();
    }

    public void waitToBeClickable(By element, int timeout){
        WebDriverWait wait = new WebDriverWait(this.desktop_driver, timeout);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitToBeClickable(By element){
        this.waitToBeClickable(element, 30);
    }

    public void waitToBeClickable(DesktopElement element, int timeout){
        this.waitToBeClickable(element.getLocator(), timeout);
    }

    public void waitToBeClickable(DesktopElement element){
        this.waitToBeClickable(element.getLocator(), 30);
    }


}
