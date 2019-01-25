package common.driver;

import common.ProjectConfig;
import common.Utils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariOptions;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class DriverFactory {
    private String browser;
    private WebDriver driver;
    private Logger log = Logger.getLogger(this.getClass().getSimpleName());
    private DesiredCapabilities capabilities = null;

    public DriverFactory(){
        this.browser = new ProjectConfig().getBrowser();
    }

    public WebDriver getDriver(){
        setUpDriver(browser);
        return driver;
    }

    private void setUpDriver(String browser){
        if (browser.equalsIgnoreCase("Chrome")) {
            initChromeDriverPath();
            setChromeCapabilities();
            driver = new ChromeDriver(capabilities);
        } else if (browser.equalsIgnoreCase("IE")) {
            initInternetExplorerDriverPath();
            driver = new InternetExplorerDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    /**
     * initChromeDriverPath method initialize chrome driver on following OS
     */
    private void initChromeDriverPath(){
        String chromeDriverPath = System.getProperty("user.dir")+  "/com/automation/src/resources/drivers";

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


    /**
     * setChromeCapabilities method set chrome capabilities to the web driver
     */
    private void setChromeCapabilities(){
        capabilities = DesiredCapabilities.chrome();

        ChromeOptions chOptions = new ChromeOptions();
        Map<String, Object> chromePreferences = new HashMap<String, Object>();

        chromePreferences.put("credentials_enable_service", false);
        chOptions.setExperimentalOption("prefs", chromePreferences);
        chOptions.addArguments("--disable-plugins",
                "--disable-extensions",
                "--disable-popup-blocking");

        capabilities.setCapability(ChromeOptions.CAPABILITY, chOptions);
        capabilities.setCapability("applicationCacheEnable", false);
    }

    /**
     * setFirefoxCapabilities method set Firefox capabilities to the web driver
     */
    private void setFirefoxCapabilities(){
        capabilities = DesiredCapabilities.firefox();

        FirefoxOptions firefoxOptions = new FirefoxOptions();
        FirefoxProfile firefoxProfile = new FirefoxProfile();

        firefoxProfile.setPreference("browser.autofocus",true);
        firefoxProfile.setPreference("dom.disable_open_during_load", false);
        capabilities.setCapability(FirefoxDriver.PROFILE, firefoxProfile);
        capabilities.setCapability("marionette", true);
    }

    /**
     * setInternetExplorerCapabilities method set Internet Explorer capabilities to the web driver
     */
    private void setInternetExplorerCapabilities(){
        capabilities = DesiredCapabilities.internetExplorer();

        InternetExplorerOptions ieOptions = new InternetExplorerOptions();

        ieOptions.requireWindowFocus();
        ieOptions.merge(capabilities);
        capabilities.setCapability("requireWindowFocus", true);
    }


    /**
     * setSafariCapabilities method set Safari capabilities to the web driver
     */
    private void setSafariCapabilities(){
        capabilities = DesiredCapabilities.safari();

        SafariOptions safariOptions = new SafariOptions();
        safariOptions.setUseCleanSession(true);

        capabilities.setCapability(SafariOptions.CAPABILITY,safariOptions);
        capabilities.setCapability("autoAcceptAlerts",true);
        //TODO implementation to add commands to command line from disable pop-up blocking
    }


}
