package common;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ProjectConfig {
    private static String baseUrl;
    private static String baseUser;
    private static String baseUserPassword;
    private static String browser;


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

            baseUrl = properties.getProperty("base_url");
            baseUser = properties.getProperty("base_user");
            baseUserPassword = properties.getProperty("base_user_password");
            browser = properties.getProperty("browser_name");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}