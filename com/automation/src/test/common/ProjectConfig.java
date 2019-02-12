package common;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ProjectConfig {
    private static String baseUrl;
    private static String baseUser;
    private static String baseUserPassword;
    private static String browser;
    private static String appiumIP;
    private static String appiumPort;
    private static String testDeviceName;
    private static String appPath;
    private static String baseUsernameForBolt;
    private static String basePasswordForBolt;



    public static String getBaseUrl(){
        if (baseUrl == null) {
            initProperties();
        }
        return baseUrl;
    }

    public static String getBaseUser(){
        if (baseUser == null) {
            initProperties();
        }
        return baseUser;
    }

    public static String getBaseUserPassword(){
        if (baseUserPassword == null) {
            initProperties();
        }
        return baseUserPassword;
    }

    public static String getBrowser(){
        if (browser == null) {
            initProperties();
        }
        return browser;
    }

    public static String getAppiumUrl(){
        String appiumUrl ="http://" + getAppiumIP() + ":" + getAppiumPort() + "/wd/hub";
        return appiumUrl;
    }

    public static String getAppiumIP(){
        if (appiumIP == null) {
            initProperties();
        }
        return appiumIP;
    }

    public static int getAppiumPort(){
        if (appiumPort == null) {
            initProperties();
        }
        return Integer.parseInt(appiumPort);
    }

    public static String getTestDeviceName(){
        if (testDeviceName == null) {
            initProperties();
        }
        return testDeviceName;
    }

    public static String getAppPath(){
        if (appPath == null) {
            initProperties();
        }
        return appPath;
    }

    public static String getBaseUsernameForBolt(){
        if (baseUsernameForBolt == null) {
            initProperties();
        }
        return baseUsernameForBolt;
    }

    public static String getBasePasswordForBolt(){
        if (basePasswordForBolt == null) {
            initProperties();
        }
        return basePasswordForBolt;
    }

    private static void initProperties(){
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
            baseUsernameForBolt = properties.getProperty("base_username_for_bolt");
            basePasswordForBolt = properties.getProperty("base_password_for_bolt");
            appiumIP = properties.getProperty("appium_IP");
            appiumPort = properties.getProperty("appium_port");
            appPath = properties.getProperty("app_path");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}