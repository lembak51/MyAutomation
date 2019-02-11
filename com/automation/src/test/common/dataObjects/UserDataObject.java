package common.dataObjects;


import common.Utils;

public class UserDataObject {
    public String Username;
    public String PrimaryExtension;
    public String UserEmail;
    public String JobTitle;


    public UserDataObject(String username, String primaryExtension, String userEmail){
        this.Username = username;
        this.PrimaryExtension = primaryExtension;
        this.UserEmail = userEmail;
        this.JobTitle = "QA Swan";
    }

    public UserDataObject(){
        this(getRandomUsername(), getRandomPrimaryExtension(), getRandomUserEmail());
    }


    public static String getRandomUsername(){
        return "SwanUser" + Utils.getRandomInt(00, 99);
    }

    public static String getRandomPrimaryExtension(){
        return String.valueOf(Utils.getRandomInt(1000, 1200));
    }

    public static String getRandomUserEmail(){
        return "Swanteams" + Utils.getRandomInt(100, 999) + "@swanteams.com";
    }

}
