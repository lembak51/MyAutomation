package common;

public class Config {
    static ProjectConfig projectConfig = new ProjectConfig();
    // Base values
    //public static final String BASE_USERNAME = projectConfig.getBaseUser();
    //public static final String BASE_PASSWORD = projectConfig.getBaseUserPassword();
    public static final String BASE_USERNAME = "admin";
    public static final String BASE_PASSWORD = "admin";
    public static final String BASE_URL = projectConfig.getBaseUrl();
    public static final String BASE_USERNAME_FOR_BOLT = projectConfig.getBaseUsernameForBolt();
    public static final String BASE_PASSWORD_FOR_BOLT = projectConfig.getBasePasswordForBolt();
    public static final String INCORRECT_USERNAME = "admin1";
    public static final String INCORRECT_PASSWORD = "admin1";
    public static final String ANOTHER_USERNAME_FOR_BOLT = "kristian.hombosh@swan-qa2.kerauno.io";
    public static final String ANOTHER_PASSWORD_BOLT_BOLT = "B1234567";
}
