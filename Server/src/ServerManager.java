import android.provider.ContactsContract;

import java.io.IOException;
import java.net.*;

/**
 * Created by Vlad on 3/7/2015.
 */

public class ServerManager {


    public ServerManager() {}

    public void run(){
        (new ListenThread()).run();
    }
}
