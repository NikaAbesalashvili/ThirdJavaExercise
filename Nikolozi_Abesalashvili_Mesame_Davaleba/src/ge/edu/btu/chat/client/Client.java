package ge.edu.btu.chat.client;

import ge.edu.btu.chat.server.ServerThread;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {

        Socket clientSocket = new Socket("localhost", 8087);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(clientSocket.getOutputStream());

        ServerThread serverThread = new ServerThread();
        Thread thread = new Thread(serverThread);
        thread.start();

        objectOutputStream.writeObject("Hello Dear");
        objectOutputStream.close();
        clientSocket.close();
    }
}
