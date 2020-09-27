package fileReceiver;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static int portNumber;

    public static void main(String[] args) {
        try {
            portNumber = parseArgs(args);
        } catch (IllegalArgumentException exception) {
            printHint();
            return;
        }
        run();
    }

    private static void run() {
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(portNumber);
            System.out.println("Server " + InetAddress.getLocalHost() + " is running.");
        } catch (IllegalArgumentException exception) {
            System.err.println("Illegal arguments: " + exception.getMessage());
            return;
        } catch (IOException e) {
            System.err.println("Cannot create server: " + e.getMessage());
            return;
        }

        try{
            while (true) {
                Socket clientSocket = serverSocket.accept();
                Receiver receiver = new Receiver(clientSocket);
                receiver.start();
                System.out.println("Client " + clientSocket.getInetAddress() + " is connected");
            }
        } catch (IOException e) {
            System.err.println("Cannot accept a client request: " + e.getMessage());
        }
    }

    private static void printHint() {
        System.err.println("Please set the correct server port");
        System.err.println("Expected input: [PORT_NUMBER]");
    }

    private static Integer parseArgs(String[] args) throws IllegalArgumentException {
        int portNumber;
        if (args.length == 1) {
            portNumber = Integer.parseInt(args[0]);
        } else {
            throw new IllegalArgumentException();
        }
        return portNumber;
    }
}