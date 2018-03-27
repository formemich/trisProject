package server;
import controller.GameController;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.ClassNotFoundException;
import java.lang.Runnable;
import java.lang.Thread;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private ServerSocket server;
    private int port = 1050;
    private int[][] board;
    private GameController gameController;

    public void setGameController(GameController gameController){
        this.gameController = gameController;
    }

    public Server() {
        try {
            server = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void handleConnection() {
        System.out.println("Waiting for client message...");

            try {
                Socket socket = server.accept();
                System.out.println("test1");
                new ConnectionHandler(socket, gameController);
                System.out.println("test2");
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
}
class ConnectionHandler implements Runnable {
    private Socket socket;
    private GameController gameController;
    private ObjectInputStream ois;
    private ObjectOutputStream oos;

    public ConnectionHandler(Socket socket, GameController gameController) {
        this.socket = socket;
        this.gameController = gameController;

        Thread t = new Thread(this);
        t.start();
    }

    public void run() {
        try
        {
            //
            // Read a message sent by client application
            //
            ois = new ObjectInputStream(socket.getInputStream());
            gameController.setBoard((int[][]) ois.readObject());
            System.out.println("Message: board received");

            oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(gameController.getBoard());
            System.out.println("Waiting for client message...");



        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}