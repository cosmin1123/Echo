import java.net.Socket;

/**
 * Created by Vlad on 3/7/2015.
 */
public class ConnectedUser {
    Socket socket;
    String deviceIdentifier;
    public ConnectedUser (Socket socket, String deviceIdentifier){
        this.socket = socket;
        this.deviceIdentifier = deviceIdentifier;
    }
}
