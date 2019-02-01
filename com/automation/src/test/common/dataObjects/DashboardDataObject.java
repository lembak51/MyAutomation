package common.dataObjects;

import common.Utils;

public class DashboardDataObject {
    public String NewPassword = "";


    public DashboardDataObject(){
        getRandomNewPassword();
    }

    public static String getRandomNewPassword(){
        return "Swanteam" + Utils.getRandomInteger(3);
    }
}
