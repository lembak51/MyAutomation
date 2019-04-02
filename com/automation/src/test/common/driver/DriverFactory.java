package common.driver;

import common.ProjectConfig;
import common.Utils;

import io.appium.java_client.windows.WindowsDriver;
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
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.util.HashMap;
import java.util.Map;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class DriverFactory {
    private String browser;
    private WebDriver driver;
    private Logger log = Logger.getLogger(this.getClass().getSimpleName());
    private DesiredCapabilities capabilities = null;
    private WindowsDriver desktop_driver;
    private ProjectConfig projectConfig = new ProjectConfig();

    public WindowsDriver getInstance() {
        try {
            desktop_driver = new WindowsDriver(new URL(projectConfig.getAppiumUrl()), setDesktopCapabilities());
            desktop_driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return desktop_driver;
    }

    public DriverFactory() {
        this.browser = projectConfig.getBrowser();
    }

    public WebDriver getDriver() {
        setUpDriver(browser);
        return driver;
    }

    private void setUpDriver(String browser) {
        if (browser.equalsIgnoreCase("Chrome")) {
            initChromeDriverPath();
            setChromeCapabilities();
            driver = new ChromeDriver(capabilities);
        } else if (browser.equalsIgnoreCase("IExplorer")) {
            initInternetExplorerDriverPath();
            setInternetExplorerCapabilities();
            driver = new InternetExplorerDriver(capabilities);
        } else if (browser.equalsIgnoreCase("Firefox")) {
            initFirefoxDriverPath();
            setFirefoxCapabilities();
            driver = new FirefoxDriver(capabilities);
        } else if (browser.equalsIgnoreCase("Safari")) {
            initSafariDriverPath();
            setSafariCapabilities();
            driver = new SafariDriver(capabilities);
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    /**
     * initChromeDriverPath method initialize chrome driver on following OS
     */
    private void initChromeDriverPath() {
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

    /**
     * initFirefoxDriverPath method initialize firefox driver on following OS
     */
    private void initFirefoxDriverPath() {
        String firefoxDriverPath = System.getProperty("user.dir") + "/com/automation/src/resources/drivers";
        if (Utils.getSystemName().contains("Win")) {
            firefoxDriverPath += "/windows/geckodriver.exe";
        } else if (Utils.getSystemName().contains("Mac")) {
            firefoxDriverPath += "/mac/geckodriver";
        } else {
            log.info("Firefox we not supported by Linux");
        }
        System.setProperty("webdriver.gecko.driver", firefoxDriverPath);
    }

    /**
     * initSafariDriverPath method initialize safari driver on following OS
     */
    private void initSafariDriverPath() {
        String safariDriverPath = System.getProperty("user.dir") + "/com/automation/src/resources/drivers";
        if (Utils.getSystemName().contains("Mac")) {
            safariDriverPath += "/mac/SafariDriver.safariextz";
        } else {
            log.info("Safari doesn't supported by Windows and Linux");
        }
        System.setProperty("webdriver.safari.driver", safariDriverPath);
    }

    /**
     * initInternetExplorerDriverPath method initialize ie driver on following OS
     */
    private void initInternetExplorerDriverPath() {
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
    private void setChromeCapabilities() {
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
    private void setFirefoxCapabilities() {
        capabilities = DesiredCapabilities.firefox();

        FirefoxOptions firefoxOptions = new FirefoxOptions();
        FirefoxProfile firefoxProfile = new FirefoxProfile();

        firefoxProfile.setPreference("browser.autofocus", true);
        firefoxProfile.setPreference("dom.disable_open_during_load", false);
        capabilities.setCapability(FirefoxDriver.PROFILE, firefoxProfile);
        capabilities.setCapability("marionette", true);
    }

    /**
     * setInternetExplorerCapabilities method set Internet Explorer capabilities to the web driver
     */
    private void setInternetExplorerCapabilities() {
        capabilities = DesiredCapabilities.internetExplorer();

        InternetExplorerOptions ieOptions = new InternetExplorerOptions();

        ieOptions.requireWindowFocus();
        ieOptions.merge(capabilities);
        capabilities.setCapability("requireWindowFocus", true);
        //TODO implementation to add commands to command lin from disable pop-up blocking
    }

    /**
     * setSafariCapabilities method set Safari capabilities to the web driver
     */
    private void setSafariCapabilities() {
        capabilities = DesiredCapabilities.safari();

        SafariOptions safariOptions = new SafariOptions();

        capabilities.setCapability(SafariOptions.CAPABILITY, safariOptions);
        capabilities.setCapability("autoAcceptAlerts", true);
        //TODO implementation to add commands to command line from disable pop-up blocking
    }

    /**
     * setWindowsCapabilities method set Desktop capabilities to the driver
     */
    private DesiredCapabilities setDesktopCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", projectConfig.getTestDeviceName());
        capabilities.setCapability("app", projectConfig.getAppPath());
        capabilities.setCapability("newCommandTimeout", 5000);
        return capabilities;
    }

}
