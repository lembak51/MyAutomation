package common.dataObjects;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

public class CallsDataObject extends BaseDataObject {

    public String DateTime;
    public String FromNumber;
    public String ToNumber;



    public CallsDataObject(String dateTime, String fromNumber, String toNumber){
        this.DateTime = dateTime;
        this.FromNumber = fromNumber;
        this.ToNumber = toNumber;
    }

    public CallsDataObject(){
        this(null, null, null);
    }

    public CallsDataObject getCalsDateAndTime(String toNumber){
        this.DateTime = getCurrentDateTime();
        this.FromNumber = "1000";
        this.ToNumber = toNumber;
        return this;
    }


    public boolean isCallDataSame(CallsDataObject expectedDataObject){
        return compareStringsWithLog(expectedDataObject.DateTime, this.DateTime) &&
                compareStringsWithLog(expectedDataObject.FromNumber, this.FromNumber) &&
                compareStringsWithLog(expectedDataObject.ToNumber, this.ToNumber);
    }

    public String getCurrentDateTime(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
        Calendar cal = Calendar.getInstance();
        dateFormat.setTimeZone(TimeZone.getTimeZone("EST"));
        return dateFormat.format(cal.getTime()).substring(0,15);
    }
}
