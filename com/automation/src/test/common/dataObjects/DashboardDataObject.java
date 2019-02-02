package common.dataObjects;

import common.Utils;

public class DashboardDataObject {
    public String NewPassword = "";
    public DashboardDataObject(String NewPassword){
        this.NewPassword = NewPassword;
    }

    public DashboardDataObject(){
        this(getRandomNewPassword());
    }

    public static String getRandomNewPassword(){
        return "Swanteam" + Utils.getRandomInteger(3);
    }
}
