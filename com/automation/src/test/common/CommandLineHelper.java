package common;

import java.io.IOException;

public class CommandLineHelper {

    public void killProcessBolt(){
        try {
            Runtime.getRuntime().exec("TASKKILL /F /IM Bolt.exe");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
