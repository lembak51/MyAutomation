package common;

public class Config {
    static ProjectConfig projectConfig = new ProjectConfig();
    // Base values
    public static final String BASE_USERNAME = projectConfig.getBaseUser();
    public static final String BASE_PASSWORD = projectConfig.getBaseUserPassword();
    public static final String BASE_URL = projectConfig.getBaseUrl();
}
