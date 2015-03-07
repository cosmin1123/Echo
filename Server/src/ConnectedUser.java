import java.net.Socket;

/**
 * Created by Vlad on 3/7/2015.
 */
public class ConnectedUser {
    Socket dataSocket;
    Socket incomingSocket;
    String deviceIdentifier;
    public ConnectedUser (Socket dataSocket, Socket incomingSocket, String deviceIdentifier){
        this.dataSocket = dataSocket;
        this.incomingSocket = incomingSocket;
        this.deviceIdentifier = deviceIdentifier;
    }
}
