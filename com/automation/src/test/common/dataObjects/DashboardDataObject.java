package common.dataObjects;

import common.Utils;

public class DashboardDataObject extends BaseDataObject {
    public String NewPassword;
    public String ConfirmPassword;
    public String NineDigitsMobileNumber;
    public String ElevenDigitsMobileNumber;
    public String VoicemailPinNumber;


    public DashboardDataObject(String NewPassword, String nineDigitsMobileNumber, String elevenDigitsMobileNumber, String voicemailPinNumber) {
        this.NewPassword = NewPassword;
        this.ConfirmPassword = NewPassword;
        this.NineDigitsMobileNumber = nineDigitsMobileNumber;
        this.ElevenDigitsMobileNumber = elevenDigitsMobileNumber;
        this.VoicemailPinNumber = voicemailPinNumber;
    }

    public DashboardDataObject getPasswordWithLetters() {
        this.NewPassword = getRandomPasswordWithoutLetters();
        this.ConfirmPassword = NewPassword;
        return this;
    }

    public DashboardDataObject getPasswordWithNumber() {
        this.NewPassword = getRandomPasswordWithoutNumbers();
        this.ConfirmPassword = NewPassword;
        return this;
    }

    public DashboardDataObject() {
        this(getRandomNewPassword(), getRandomNineMobileNumber(), getRandomElevenMobileNumber(), getRandomVoicemailPin());
    }

    static String getRandomNewPassword() {
        return "Swanteam" + Utils.getRandomInt(000, 999);
    }

    static String getRandomNineMobileNumber() {
        return String.valueOf(Utils.getRandomInt(100000000, 200000000));
    }

    static String getRandomElevenMobileNumber() {
        return String.valueOf(Utils.getRandomInt(1000000000, 2000000000) + String.valueOf(Utils.getRandomInt(0, 9)));
    }

    static String getRandomVoicemailPin() {
        return String.valueOf(Utils.getRandomInt(0000, 9999));
    }

    static String getRandomPasswordWithoutLetters() {
        return String.valueOf(Utils.getRandomInt(00000000, 99999999));
    }

    static String getRandomPasswordWithoutNumbers() {
        return Utils.getRandomString(8);
    }
}
