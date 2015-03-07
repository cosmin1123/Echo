import java.io.IOException;
import java.net.*;

class ListenThread extends Thread {

    public void run() {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(12321);
        } catch (IOException e) {
            e.printStackTrace();
        }
        InetAddress addr = null;
        try {
            addr = InetAddress.getByName("127.0.0.1");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        InetSocketAddress inetSocketAddress = new InetSocketAddress(addr, 12321);
        try {
            serverSocket.bind(inetSocketAddress);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Listening for new connections
        while (true){
            try {
                Socket clientSocket = serverSocket.accept();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Am primit o noua conexiune!");

        }
    }
}
