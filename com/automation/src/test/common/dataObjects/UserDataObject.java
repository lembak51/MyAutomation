package common.dataObjects;



import common.Utils;

public class UserDataObject  {
    public String Username;
    public String PrimaryExtension;
    public String UserEmail;
    public String JobTitle;


    public UserDataObject(String username, String primaryExtension, String userEmail, String jobTitle) {
        this.Username = username;
        this.PrimaryExtension = primaryExtension;
        this.UserEmail = userEmail;
        this.JobTitle = jobTitle;
    }
    public UserDataObject() {
        this(getRandomUsername(), getRandomPrimaryExtension(),getRandomUserEmail(),getRandomJobTitle());
    }



    public static String getRandomUsername() {return"Swan"+ Utils.getRandomInt(000,999)+"team";}
    public static String getRandomPrimaryExtension(){return "" + Utils.getRandomInt(1000,1200);}
    public static String getRandomUserEmail(){return "Swan" + Utils.getRandomInt(100,999) + "teams@swanteams.com"; }
    public static String getRandomJobTitle() {return "QA Swan"+ Utils.getRandomInt(000,100);}
}
