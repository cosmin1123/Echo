import android.provider.ContactsContract;

import java.io.*;
import java.net.*;

class ListenThread extends Thread {

    public void run() {
        ServerSocket dataServerSocket = null;
        ServerSocket notificationServerSocket = null;
        try {

            InetAddress addr = InetAddress.getByName("127.0.0.1");

            dataServerSocket = new ServerSocket(9565, 50, addr);
            notificationServerSocket = new ServerSocket(34821, 50, addr);

        } catch (IOException e) {
            e.printStackTrace();
        }
        // Listening for new connections
        while (true){
            try {
                Socket clientSocket = dataServerSocket.accept();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Am primit o noua conexiune!");

        }
    }
}

class AnswersThread extends Thread{

    Socket clientSocket;

    public AnswersThread(Socket s){
        clientSocket = s;
    }

    public void run() {
        try {
            ObjectOutputStream os = new ObjectOutputStream(clientSocket.getOutputStream());
            ObjectInputStream is = new ObjectInputStream(clientSocket.getInputStream());

            os.writeObject(Database.getInstance().getNextQuestion());

            int response = is.readInt();

            if (response == 13){
                clientSocket.close();
                return;
            }
            else if (response == 1){
                Message receivedMessage = (Message)is.readObject();
                for (Message q : Database.getInstance().questions){
                    if (q.uniqueIdentifier.equals(receivedMessage.uniqueIdentifier)){

                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

class QuestionThread extends Thread{

    public void run() {

    }

}