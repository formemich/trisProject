import client.ClientGameView;
import client.Client;
import client.Controller;

public class ClientMain {
    public static void main(String[] args){

        ClientGameView clientgameView = new ClientGameView();
        Client client = new Client();
        clientgameView.setVisible(true);
        client.setClient();
<<<<<<< HEAD
        Controller controller = new Controller(client, clientgameView);
        controller.addActionListeners();

        client.setController(controller);


=======
        Controller Controller = new Controller(client, clientgameView);
        Controller.addActionListeners();
>>>>>>> fa289f0ddeeff43603c980a691aef8ccec988717
    }

}
