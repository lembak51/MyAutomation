package common;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ProjectConfig {
    private String baseUrl;
    private String baseUser;
    private String baseUserPassword;
    private String browser;
    private String appiumIP;
    private String appiumPort;
    private String testDeviceName;
    private String appPath;
    private String baseUsernameForBolt;
    private String basePasswordForBolt;


    public String getBaseUrl() {
        if (baseUrl == null) {
            initProperties();
        }
        return baseUrl;
    }

    public String getBaseUser() {
        if (baseUser == null) {
            initProperties();
        }
        return baseUser;
    }

    public String getBaseUserPassword() {
        if (baseUserPassword == null) {
            initProperties();
        }
        return baseUserPassword;
    }

    public String getBrowser() {
        if (browser == null) {
            initProperties();
        }
        return browser;
    }

    public String getAppiumUrl() {
        String appiumUrl = "http://" + getAppiumIP() + ":" + getAppiumPort() + "/wd/hub";
        return appiumUrl;
    }

    public String getAppiumIP() {
        if (appiumIP == null) {
            initProperties();
        }
        return appiumIP;
    }

    public int getAppiumPort() {
        if (appiumPort == null) {
            initProperties();
        }
        return Integer.parseInt(appiumPort);
    }

    public String getTestDeviceName() {
        if (testDeviceName == null) {
            initProperties();
        }
        return testDeviceName;
    }

    public String getAppPath() {
        if (appPath == null) {
            initProperties();
        }
        return appPath;
    }

    public String getBaseUsernameForBolt() {
        if (basePasswordForBolt == null) {
            initProperties();
        }
        return baseUsernameForBolt;
    }

    public String getBasePasswordForBolt() {
        if (basePasswordForBolt == null) {
            initProperties();
        }
        return basePasswordForBolt;
    }

    private void initProperties() {
        try {
            File file;
            if ((new File("ConfigProjectLocal.properties").exists())) {
                file = new File("ConfigProjectLocal.properties");
            } else {
                file = new File("ConfigProject.properties");
            }
            FileInputStream fileInput = new FileInputStream(file);
            Properties properties = new Properties();
            properties.load(fileInput);
            fileInput.close();
            //web properties
            baseUrl = properties.getProperty("base_url");
            baseUser = properties.getProperty("base_user");
            baseUserPassword = properties.getProperty("base_user_password");
            browser = properties.getProperty("browser_name");
            //desktop properties
            testDeviceName = properties.getProperty("device_name");
            appiumIP = properties.getProperty("appium_IP");
            appiumPort = properties.getProperty("appium_port");
            appPath = properties.getProperty("app_path");
            baseUsernameForBolt = properties.getProperty("base_username_for_bolt");
            basePasswordForBolt = properties.getProperty("base_password_for_bolt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}