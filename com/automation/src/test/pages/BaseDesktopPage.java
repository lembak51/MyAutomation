package pages;

import common.AppElement;
import common.AppiumConfig;
import common.PageElement;
import io.appium.java_client.windows.WindowsDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BaseDesktopPage {
    public WindowsDriver driver;
    public boolean doLogging = true;
    protected Logger log;

    public BaseDesktopPage(WindowsDriver driver){
        this.driver = driver;
        if (log == null) {
            log = Logger.getLogger(this.getClass().getName());
        }
    }
    public BaseDesktopPage(BaseDesktopPage page){
        this(page.driver);
        log = Logger.getLogger(page.getClass().getName());
    }


    public WebElement find(By element){
        return this.driver.findElement(element);
    }

    public WebElement find(AppElement element){
        return this.find(element.getLocator());
    }

    public void click(AppElement appElement){
        log.info("Clicking on element: " + appElement.name);
        this.find(appElement).click();
    }

    public void waitToBeClickable(By element, int timeout){
        WebDriverWait wait = new WebDriverWait(this.driver, timeout);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitToBeClickable(By element){
        this.waitToBeClickable(element, 30);
    }

    public void waitToBeClickable(AppElement element, int timeout){
        this.waitToBeClickable(element.getLocator(), timeout);
    }

    public void waitToBeClickable(AppElement element){
        this.waitToBeClickable(element.getLocator(), 30);
    }


}
