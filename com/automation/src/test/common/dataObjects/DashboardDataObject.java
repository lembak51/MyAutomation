package common.dataObjects;

import common.Utils;

public class DashboardDataObject {
    public String NewPassword;
    public String ConfirmPassword;
    public String NineDigitsMobileNumber;
    public String ElevenDigitsMobileNumber;
    public String VoicemailPinNumber;


    public DashboardDataObject(String NewPassword, String nineDigitsMobileNumber, String elevenDigitsMobileNumber, String voicemailPinNumber){
        this.NewPassword = NewPassword;
        this.ConfirmPassword = NewPassword;
        this.NineDigitsMobileNumber = nineDigitsMobileNumber;
        this.ElevenDigitsMobileNumber = elevenDigitsMobileNumber;
        this.VoicemailPinNumber = voicemailPinNumber;
    }

    public DashboardDataObject getPasswordWithLetters(){
        this.NewPassword = getRandomPasswordWithoutLetters();
        this.ConfirmPassword = NewPassword;
        return this;
    }
    public DashboardDataObject getPasswordWithNumber(){
        this.NewPassword = getRandomPasswordWithoutNumbers();
        this.ConfirmPassword = NewPassword;
        return this;
    }

    public DashboardDataObject(){
        this(getRandomNewPassword(), getRandomNineMobileNumber(), getRandomElevenMobileNumber(), getRandomVoicemailPin());
    }

    public static String getRandomNewPassword(){
        return "Swanteam" + Utils.getRandomInteger(3);
    }

    public static String getRandomNineMobileNumber(){
        return String.valueOf(Utils.getRandomInt(100000000, 200000000));
    }

    public static String getRandomElevenMobileNumber(){
        return String.valueOf(Utils.getRandomInt(1000000000, 2000000000) + String.valueOf(Utils.getRandomInt(0, 9)));
    }

    public static String getRandomVoicemailPin(){
        return String.valueOf(Utils.getRandomInt(0000, 9999));
    }

    public static String getRandomPasswordWithoutLetters(){
        return String.valueOf(Utils.getRandomInt(00000000, 99999999));
    }

    public static String getRandomPasswordWithoutNumbers(){
        return Utils.getRandomString(8);
    }
}
