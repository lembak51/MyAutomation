package common.dataObjects;

public class PhonebookDataObject {

    public String Name = "";
    public String Email = "";
    public String Number = "";

    public PhonebookDataObject(String Name, String Email, String Number){
        this.Name = Name;
        this.Email = Email;
        this.Number = Number;
    }

    public PhonebookDataObject(){
        this(getName(), getEmail(), getNumber());
    }

    public static String getName(){
        return "";
    }

    public static String getEmail(){
        return "";
    }

    public static String getNumber(){
        return "";
    }
}
