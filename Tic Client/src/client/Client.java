package client;

import java.awt.datatransfer.Clipboard;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.ClassNotFoundException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client{
    private Controller controller;
    private int[][] board;
    private ClientGameView clientGameView;
    public void setController(Controller controller){
        this.controller = controller;
    }
    public void setClient() {
        try {

            InetAddress host = InetAddress.getLocalHost();
            Socket socket = new Socket(host.getHostName(), 1050);
<<<<<<< HEAD
            sendObj(board, socket);
            receiveObj(board, socket);


=======
            int[][] board;

            //
            // Send a message to the client application
            //
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject("Hello There...");

            //
            // Read and display the response message sent by server application
            //
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
//            board = (Controller.getBoard());
            ois.readObject();
            System.out.println("Message: board created");

            ois.close();
            oos.close();
>>>>>>> fa289f0ddeeff43603c980a691aef8ccec988717
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void setBoard(int[][] board){

        this.board = board;
    }
    public void sendObj(int[][] board, Socket socket) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        oos.writeObject(board);
        System.out.println("Message: board sent.");
        //oos.close();

    }
    public void receiveObj(int[][] board, Socket socket) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        setBoard((int[][]) ois.readObject());
        System.out.println("Message: board received");
        //ois.close();
    }

}