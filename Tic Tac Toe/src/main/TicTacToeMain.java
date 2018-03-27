package main;

import controller.GameController;
import model.ArtificialIntelligence;
import model.GameModel;
import model.Player;
import view.GameView;
import view.StartGameView;
import view.UserLoginView;
import server.Server;

import java.io.IOException;

public class TicTacToeMain {

	public static void main(String[] args) throws IOException{

		GameView gameView = new GameView();

		UserLoginView userLoginView = new UserLoginView();
		StartGameView startGameView = new StartGameView();
		ArtificialIntelligence artificialIntelligence = new ArtificialIntelligence();
		userLoginView.setVisible(true);

		Player player1 = new Player();
		Player player2 = new Player();

		GameModel gameModel = new GameModel(player1, player2);
		Server server = new Server();
		GameController gameController = new GameController(gameModel, player1, player2, userLoginView, startGameView, gameView, artificialIntelligence, server);
		gameController.addActionListeners();

		server.setGameController(gameController);


	}

}
