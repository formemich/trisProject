import client.ClientGameView;
import client.Client;
import client.Controller;

public class ClientMain {
    public static void main(String[] args){

        ClientGameView clientgameView = new ClientGameView();
        Client client = new Client();
        clientgameView.setVisible(true);
        client.setClient();
        Controller Controller = new Controller(client, clientgameView);
        Controller.addActionListeners();


    }

}
