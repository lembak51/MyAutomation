package common.dataObjects;

public class VoicemailDataObject extends BaseDataObject {

    public String Date;
    public String Duration;
    public String Folder;

    public VoicemailDataObject(String Date, String Duration, String Folder) {
        this.Date = Date;
        this.Duration = Duration;
        this.Folder = Folder;
    }

    public VoicemailDataObject() {
        this(null, null, null);
    }

    public boolean isVoicemailDataSame(VoicemailDataObject expectedVoicemailDataObject){
        return compareStringsWithLog(expectedVoicemailDataObject.Date, this.Date) &&
                compareStringsWithLog(expectedVoicemailDataObject.Duration, this.Duration) &&
                compareStringsWithLog(expectedVoicemailDataObject.Folder,this.Folder);
    }
}
