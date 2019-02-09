package common.dataObjects;

import common.Utils;

public class DashboardDataObject {
    public String NewPassword;
    public String ConfirmPassword;
    public String NineDigitsMobileNumber;
    public String ElevenDigitsMobileNumber;
    public String VoicemailPinNumber;
    public String NewPasswordWithoutLetters;
    public String ConfirmPasswordWithoutLetters;


    public DashboardDataObject(String NewPassword, String nineDigitsMobileNumber, String elevenDigitsMobileNumber, String voicemailPinNumber, String newPasswordWithoutLetters){
        this.NewPassword = NewPassword;
        this.ConfirmPassword = NewPassword;
        this.NineDigitsMobileNumber = nineDigitsMobileNumber;
        this.ElevenDigitsMobileNumber = elevenDigitsMobileNumber;
        this.VoicemailPinNumber = voicemailPinNumber;
        this.NewPasswordWithoutLetters = newPasswordWithoutLetters;
        this.ConfirmPasswordWithoutLetters = newPasswordWithoutLetters;
    }

    public DashboardDataObject(){
        this(getRandomNewPassword(), getRandomNineMobileNumber(), getRandomElevenMobileNumber(), getRandomVoicemailPin(),getRandomPasswordWithoutLetters());
    }

    public static String getRandomNewPassword(){
        return "Swanteam" + Utils.getRandomInteger(3);
    }

    public static String getRandomNineMobileNumber(){
        return "" + Utils.getRandomInt(100000000, 200000000);
    }

    public static String getRandomElevenMobileNumber(){
        return "" + Utils.getRandomInt(1000000000, 2000000000) + Utils.getRandomInt(0, 9);
    }

    public static String getRandomVoicemailPin(){
        return "" + Utils.getRandomInt(0000, 9999);
    }
    public static String getRandomPasswordWithoutLetters(){
        return "" + Utils.getRandomInt(00000000, 99999999);
    }
}
