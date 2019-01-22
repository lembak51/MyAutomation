package pages;

import common.AppElement;
import common.AppiumConfig;
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

}
