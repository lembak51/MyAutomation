package common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class AppiumConfig {
    private static String appiumUrl;
    private static String testDeviceName;
    private static String packageName;
    private static String appPath;
    private static String platformName;
    private static String platformVersion;
    private static String startActivity;
    private static String appWaitActivity;
    private static String gpsEnable;


    public static String getAppiumUrl(){
        if (appiumUrl == null) {
            initProperties();
        }
        return appiumUrl;
    }

    public static String getTestDeviceName(){
        if (testDeviceName == null) {
            initProperties();
        }
        return testDeviceName;
    }

    public static String getPackageName(){
        if (packageName == null) {
            initProperties();
        }
        return packageName;
    }


    public static String getAppPath(){
        if (appPath == null) {
            initProperties();
        }
        String path = (System.getProperty("user.dir") + appPath).replace("\\", "//");

        return path;
    }

    public static String getPlatformName(){
        if (platformName == null) {
            initProperties();
        }

        return platformName;
    }

    public static String getPlatformVersion(){
        if (platformVersion == null) {
            initProperties();
        }

        return platformVersion;
    }

    public static String getStartActivity(){
        if (startActivity == null) {
            initProperties();
        }

        return startActivity;
    }

    public static String getAppWaitActivity(){
        if (appWaitActivity == null) {
            initProperties();
        }

        return appWaitActivity;
    }

    public static String getGpsEnable(){
        if (platformVersion == null) {
            initProperties();
        }

        return gpsEnable;
    }

    private static void initProperties(){
        try {
            File file;
            if ((new File("AppiumConfigLocal.properties").exists())) {
                file = new File("AppiumConfigLocal.properties");
            } else {
                file = new File("AppiumConfig.properties");
            }

            FileInputStream fileInput = new FileInputStream(file);
            Properties properties = new Properties();
            properties.load(fileInput);
            fileInput.close();

            platformName = properties.getProperty("platform_name");
            platformVersion = properties.getProperty("platform_version");
            testDeviceName = properties.getProperty("device_name");
            appPath = properties.getProperty("app_path");
            packageName = properties.getProperty("appPackage");
            appWaitActivity = properties.getProperty("waitActivity");
            startActivity = properties.getProperty("startActivity");

            appiumUrl = properties.getProperty("appium_url");
            gpsEnable = properties.getProperty("gps_enable");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
