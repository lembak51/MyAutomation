package common.dataObjects;

import java.util.logging.Logger;

public abstract class  BaseDataObject {
    private Logger log = Logger.getLogger(this.getClass().getName());

    protected boolean compareStringsWithLog(String originalString, String stringForComparison){
        boolean stringsAreEquals = true;

        if (!originalString.equals(stringForComparison)) {
            stringsAreEquals = false;
            log.info("Values \"" + originalString + "\" and \"" + stringForComparison + "\" are not equals");
        }
        return stringsAreEquals;
    }

    public String AutoTag = "SwanAuto";
}
