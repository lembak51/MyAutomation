package common.dataObjects;


import common.Utils;

public class UserDataObject {
    public String Username;
    public String PrimaryExtension;
    public String UserEmail;
    public String JobTitle;
    public String MobileNumber;
    public String NewPassword;
    public String ConfirmPassword;
    public String NineDigitsMobileNumber;
    public String ElevenDigitsMobileNumber;
    public String VoicemailPinNumber;
    public String EmailCoach;
    public String SchoolName;
    public String RandomNumber;


    public UserDataObject(String username, String primaryExtension, String userEmail, String mobileNumber, String NewPassword, String nineDigitsMobileNumber, String elevenDigitsMobileNumber, String voicemailPinNumber,String emailCoach,String schoolName,  String randomNumber) {
        this.Username = username;
        this.PrimaryExtension = primaryExtension;
        this.UserEmail = userEmail;
        this.JobTitle = "QA Swan";
        this.MobileNumber = mobileNumber;
        this.NewPassword = NewPassword;
        this.ConfirmPassword = NewPassword;
        this.NineDigitsMobileNumber = nineDigitsMobileNumber;
        this.ElevenDigitsMobileNumber = elevenDigitsMobileNumber;
        this.VoicemailPinNumber = voicemailPinNumber;
        this.EmailCoach = emailCoach;
        this.SchoolName = schoolName;
        this.RandomNumber = randomNumber;
    }

    public UserDataObject() {
        this(getRandomUsername(), getRandomPrimaryExtension(),  getRandomUserEmail(), getRandomMobileNumber(), getRandomNewPassword(), getRandomNineMobileNumber(), getRandomElevenMobileNumber(), getRandomVoicemailPin(), getRandomEmailCoach(), getRandomSchoolName(), getRandomNumber());
    }


    static String getRandomUsername() {
        return "SwanUser" + Utils.getRandomInt(10, 99);
    }

    static String getRandomPrimaryExtension() {
        return String.valueOf(Utils.getRandomInt(1000, 1200));
    }


    static String getRandomUserEmail() {
        return "Swanteams+" + Utils.getRandomInt(100, 999) + "@swanteams.com";
    }
    static String getRandomMobileNumber() {
        return String.valueOf(Utils.getRandomInt(1000000000, 2000000000));
    }
    static String getRandomNumber(){return String.valueOf(Utils.getRandomInt(1000, 1200));}

    public UserDataObject getPasswordWithLetters() {
        this.NewPassword = getRandomPasswordWithoutLetters();
        this.ConfirmPassword = NewPassword;
        return this;
    }

    public UserDataObject getPasswordWithNumber() {
        this.NewPassword = getRandomPasswordWithoutNumbers();
        this.ConfirmPassword = NewPassword;
        return this;
    }

    static String getRandomNewPassword() {
        return "Swanteam" + Utils.getRandomInt(100, 999);
    }

    static String getRandomNineMobileNumber() {
        return String.valueOf(Utils.getRandomInt(100000000, 200000000));
    }

    static String getRandomElevenMobileNumber() {
        return String.valueOf(Utils.getRandomInt(1000000000, 2000000000) + String.valueOf(Utils.getRandomInt(0, 9)));
    }

    static String getRandomVoicemailPin() {
        return String.valueOf(Utils.getRandomInt(1000, 9999));
    }
    static String getRandomEmailCoach() {return "volodymyr.lembak+" + Utils.getRandomInt(100, 999) + "@swanlogic.com"; }
    static String getRandomSchoolName() {
        return "QA_Auto_Test" + Utils.getRandomInt(10, 90000);
    }

    static String getRandomPasswordWithoutLetters() {
        return String.valueOf(Utils.getRandomInt(10000000, 99999999));
    }

    static String getRandomPasswordWithoutNumbers() {
        return Utils.getRandomString(8);
    }

}
