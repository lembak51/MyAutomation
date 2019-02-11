package common.dataObjects;

public class PhonebookDataObject extends BaseDataObject{

    public String Name;
    public String Email;
    public String Number;

    public PhonebookDataObject(String Name, String Email, String Number){
        this.Name = Name;
        this.Email = Email;
        this.Number = Number;
    }

    public PhonebookDataObject(){
        this(null, null, null);
    }

    public boolean isPhoneBookDataSame(PhonebookDataObject expectedPhoneDataObject){
        return compareStringsWithLog(expectedPhoneDataObject.Name, this.Name) &&
                compareStringsWithLog(expectedPhoneDataObject.Email, this.Email) &&
                compareStringsWithLog(expectedPhoneDataObject.Number,this.Number);
    }
}
