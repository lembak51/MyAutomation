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


    public UserDataObject(String username, String primaryExtension, String userEmail, String mobileNumber, String NewPassword, String nineDigitsMobileNumber, String elevenDigitsMobileNumber, String voicemailPinNumber) {
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
    }

    public UserDataObject() {
        this(getRandomUsername(), getRandomPrimaryExtension(), getRandomUserEmail(), getRandomMobileNumber(), getRandomNewPassword(), getRandomNineMobileNumber(), getRandomElevenMobileNumber(), getRandomVoicemailPin());
    }


    static String getRandomUsername() {
        return "SwanUser" + Utils.getRandomInt(00, 99);
    }

    static String getRandomPrimaryExtension() {
        return String.valueOf(Utils.getRandomInt(1000, 1200));
    }

    static String getRandomUserEmail() {
        return "Swanteams" + Utils.getRandomInt(100, 999) + "@swanteams.com";
    }

    static String getRandomMobileNumber() {
        return String.valueOf(Utils.getRandomInt(1000000000, 2000000000));
    }

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

    static String getRandomPasswordWithoutLetters() {
        return String.valueOf(Utils.getRandomInt(10000000, 99999999));
    }

    static String getRandomPasswordWithoutNumbers() {
        return Utils.getRandomString(8);
    }
}
