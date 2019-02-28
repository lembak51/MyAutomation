package common.dataObjects;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

public class CallsDataObject extends BaseDataObject {

    public String DateTime;
    public String FromNumber;
    public String ToNumber;

    public CallsDataObject(String dateTime){
        this.DateTime = dateTime;
        this.FromNumber = "1000";
        this.ToNumber= "1001";
    }
    public CallsDataObject(){this.getCurrentDateTime();}
    public boolean isCallDataSame(CallsDataObject expectedDataObject){
        return compareStringsWithLog(expectedDataObject.DateTime, this.DateTime) &&
                compareStringsWithLog(expectedDataObject.FromNumber, this.FromNumber) &&
                compareStringsWithLog(expectedDataObject.ToNumber,this.ToNumber);
    }

    public String getCurrentDateTime(){
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
        dateFormat.setTimeZone(TimeZone.getTimeZone("EST"));
        return String.valueOf(dateFormat);
    }
}
