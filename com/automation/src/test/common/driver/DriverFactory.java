package common.driver;


import common.ProjectConfig;
import common.Utils;

import io.appium.java_client.windows.WindowsDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverFactory {
    private String browser;
    private WebDriver driver;
    private Logger log = Logger.getLogger(this.getClass().getSimpleName());
    private static WindowsDriver desktop_driver;

    public static WindowsDriver getInstance(){
        try {
            desktop_driver = new WindowsDriver(new URL(ProjectConfig.getAppiumUrl()), getCapabilities());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return desktop_driver;
    }

    public static DesiredCapabilities getCapabilities(){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", ProjectConfig.getTestDeviceName());
        capabilities.setCapability("app", "C:\\Program Files (x86)\\Kerauno\\Bolt\\bolt.exe");
        capabilities.setCapability("newCommandTimeout", 5000);
        return capabilities;
    }

    public DriverFactory() throws MalformedURLException{
        this.browser = new ProjectConfig().getBrowser();
       // this.desktop_driver = new WindowsDriver(new URL(ProjectConfig.getAppiumUrl()), getCapabilities());
    }

    public WebDriver getDriver(){
        setUpDriver(browser);
        return driver;
    }

    private void setUpDriver(String browser){
        if (browser.equalsIgnoreCase("Chrome")) {
            initChromeDriverPath();
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("IE")) {
            initInternetExplorerDriverPath();
            driver = new InternetExplorerDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    private void initChromeDriverPath(){
        String chromeDriverPath = System.getProperty("user.dir") + "/com/automation/src/resources/drivers";

        if (Utils.getSystemName().contains("Win")) {
            chromeDriverPath += "/windows/chromedriver.exe";
        } else if (Utils.getSystemName().contains("Mac")) {
            chromeDriverPath += "/mac/chromedriver";
        } else {
            chromeDriverPath += "/linux/chromedriver";
        }
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
    }

    private void initInternetExplorerDriverPath(){
        String internetExplorerPath = System.getProperty("user.dir") + "/com/automation/src/resources/drivers";

        if (Utils.getSystemName().contains("Win")) {
            internetExplorerPath += "/windows/IEDriverServer.exe";
        } else if (Utils.getSystemName().contains("Mac")) {
            log.info("IE doesn't supported by Mac");
        } else {
            log.info("IE doesn't supported by Linux");
        }
        System.setProperty("webdriver.ie.driver", internetExplorerPath);
    }
}
