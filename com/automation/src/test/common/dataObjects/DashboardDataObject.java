package common.dataObjects;

import common.Utils;

public class DashboardDataObject {
    public String NewPassword;
    public String ConfirmPassword;
    public String NineDigitsMobileNumber;
    public String ElevenDigitsMobileNumber;

    public DashboardDataObject(String NewPassword, String nineDigitsMobileNumber, String elevenDigitsMobileNumber){
        this.NewPassword = NewPassword;
        this.ConfirmPassword = NewPassword;
        this.NineDigitsMobileNumber = nineDigitsMobileNumber;
        this.ElevenDigitsMobileNumber = elevenDigitsMobileNumber;
    }

    public DashboardDataObject(){
        this(getRandomNewPassword(), getRandomNineMobileNumber(), getRandomElevenMobileNumber());
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
}
