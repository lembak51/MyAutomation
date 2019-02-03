package common.dataObjects;

import common.Utils;

public class DashboardDataObject {
    public String NewPassword = "";
    public String IncorrectMobileDigits9 = "";
    public String IncorrectMobileDigits11 = "";

    public DashboardDataObject(String NewPassword, String IncorrectMobileDigits9, String IncorrectMobileDigits11) {
        this.NewPassword = NewPassword;
        this.IncorrectMobileDigits9 = IncorrectMobileDigits9;
        this.IncorrectMobileDigits11 = IncorrectMobileDigits11;
    }

    public DashboardDataObject() {
        this(getRandomNewPassword(), getRandomIncorrectMobileNumber9(), getRandomIncorrectMobileNumber11());
    }

    public static String getRandomNewPassword() {
        return "Swanteam" + Utils.getRandomInteger(3);
    }

    public static String getRandomIncorrectMobileNumber9() {
        return "" + Utils.getRandomInt(100000000, 200000000);
    }

    public static String getRandomIncorrectMobileNumber11() {
        return "" + Utils.getRandomInt(1000000000, 2000000000) + Utils.getRandomInt(0, 9);
    }
}
