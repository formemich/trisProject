package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import model.ArtificialIntelligence;
import model.GameModel;
import model.Player;
import server.Server;
import view.GameView;
import view.StartGameView;
import view.UserLoginView;

public class GameController implements ActionListener {

	private GameModel gameModel;
	private Player player1, player2;
	private UserLoginView userLoginView;
	private StartGameView startGameView;
	private GameView gameView;
	private ArtificialIntelligence artificialIntelligence;
	private Server server;

	public GameController(GameModel gameModel, Player player1, Player player2, UserLoginView userLoginView,
						  StartGameView startGameView, GameView gameView, ArtificialIntelligence artificialIntelligence, Server server) {
		this.gameModel = gameModel;
		this.player1 = player1;
		this.player2 = player2;
		this.userLoginView = userLoginView;
		this.startGameView = startGameView;
		this.gameView = gameView;
		this.artificialIntelligence = artificialIntelligence;
		this.server = server;
	}

	public void addActionListeners() {
		for (int i = 0; i < gameView.getCells().length; i++) {
			for (int j = 0; j < gameView.getCells().length; j++) {
				gameView.getCellAt(i, j).addActionListener(this);
			}
		}
		gameModel.setDefault();
		gameView.getExitBtn().addActionListener(this);
		userLoginView.getSendBtn().addActionListener(this);
		startGameView.getSendSPBtn().addActionListener(this);
		startGameView.getSendMPBtn().addActionListener(this);
		gameView.getExitBtn().addActionListener(this);
		startGameView.getExitBtn().addActionListener(this);
		startGameView.getMultiButton().addActionListener(this);
	}

	public void reset() {
		for (int i = 0; i < gameView.getCells().length; i++) {
			for (int j = 0; j < gameView.getCells().length; j++) {
				gameView.getCellAt(i, j).setText("");
				gameView.getCellAt(i, j).setEnabled(true);
				gameModel.setDefault();
			}
		}
		gameModel.setMovesCounter(0);
		artificialIntelligence.setTurns(0);
		gameModel.getPlayer1().setTurns(0);
		gameView.getTimer().stop();
		gameView.resetTimer();
		gameView.getSecLbl().setText("00");
		gameView.getMinLbl().setText("00");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		boolean proceed = true;
		if (gameView.contains(gameView.getCells(), (JButton) e.getSource())) {
			if (player2.isIA()) {
				gameModel.setOwner(player1);
				setCell(gameView.getX(),gameView.getY());
				gameModel.proceed();
					if (gameModel.checkWinner()) {
						player1Won();
						proceed = false;
					} else if (gameModel.getMovesCounter() == 9) {
						nobodyWon();
						proceed = false;
					}
				boolean done = false;
				if (proceed) {
					do {
						if (gameModel.getMovesCounter() < 9) {
							gameModel.setOwner(artificialIntelligence);
							int x = artificialIntelligence.getX();
							int y = artificialIntelligence.getY();
							if (gameView.getCellAt(x, y).isEnabled()) {
								setCell(x,y);
								gameModel.proceed();
								done = true;
								if (gameModel.checkWinner()) {
									player2Won();
								} else if (gameModel.getMovesCounter() == 9) {
									nobodyWon();
								}
							}
						}
					} while (!done);
				}
				if (gameModel.endGame()) {
					for (JButton[] btn : gameView.getCells()) {
						for (JButton button : btn) {
							button.setEnabled(false);
						}
					}
				}
			}else{
				gameModel.setOwner(player1);
				setCell(gameView.getX(),gameView.getY());
				gameModel.proceed();
				if (gameModel.checkWinner()) {
					player1Won();
					proceed = false;
				} else if (gameModel.getMovesCounter() == 9) {
					nobodyWon();
					proceed = false;
				}
				boolean done = false;
				if (proceed) {
					do {
						if (gameModel.getMovesCounter() < 9) {
							gameModel.setOwner(player2);
							//server.refreshBoard();
							gameModel.proceed();
								done = true;
								if (gameModel.checkWinner()) {
									player2Won();
								} else if (gameModel.getMovesCounter() == 9) {
									nobodyWon();
								}

						}
					} while (!done);
				}
				if (gameModel.endGame()) {
					for (JButton[] btn : gameView.getCells()) {
						for (JButton button : btn) {
							button.setEnabled(false);
						}
					}
				}
			}
			/////////////////////dovrei giocare con remoto
		}

		if (e.getSource().equals(userLoginView.getSendBtn())) {
			if (userLoginView.getNameField().getText().length() > 0
					&& userLoginView.getSurnameField().getText().length() > 0) {
				gameModel.getPlayer1().setName(userLoginView.getNameField().getText());
				gameModel.getPlayer1().setSurname(userLoginView.getSurnameField().getText());
				gameModel.getPlayer2().setIA(true);
				userLoginView.dispose();
				startGameView.setVisible(true);
				startGameView.getTitleLbl().setText("Benvenuto " + gameModel.getPlayer1().getName() + "!");
			} else {
				userLoginView.getErrLbl().setText("Dati mancanti!");
			}
		}
		if (e.getSource().equals(startGameView.getSendSPBtn())) {
			if (startGameView.getxBtn().isSelected() || startGameView.getoBtn().isSelected()) {
				if (gameModel.isJustPlayed()) {
					reset();
				}
				if (startGameView.getxBtn().isSelected()) {
					player1.setSign(1);
					player2.setSign(0);
					artificialIntelligence.setSign(0);
				} else if (startGameView.getoBtn().isSelected()) {
					player1.setSign(0);
					player2.setSign(1);
					artificialIntelligence.setSign(1);
				}
				player2.setName(artificialIntelligence.getName());
				player2.setIA(true);
				startGameView.dispose();
				gameView.setVisible(true);
			}
		}
		if(e.getSource().equals(startGameView.getMultiButton())){

				server.handleConnection();

			gameView.setVisible(true);


		}
		if (e.getSource().equals(gameView.getExitBtn())) {
			gameView.dispose();
			reset();
			gameModel.setJustPlayed(true);
			startGameView.setVisible(true);
			for (JButton[] btn : gameView.getCells()) {
				for (JButton button : btn) {
					button.setEnabled(false);
				}
			}
		}
		if (e.getSource().equals(startGameView.getExitBtn())) {
			System.exit(0);
		}
	}
	public int[][] getBoard(){
		return gameModel.getBoard();
	}
	public void setBoard(int[][] board){
		 gameModel.setBoard(board);
	}
	public void player1Won(){
		gameView.getTimer().stop();
		JOptionPane.showMessageDialog(gameView,
				"Ha vinto il giocatore 1\nTurni: " + gameModel.getMovesCounter() + "\nTempo: "
						+ gameView.getMinLbl().getText() + ":" + gameView.getSecLbl().getText());
		gameView.dispose();
		gameModel.setJustPlayed(true);
		startGameView.setVisible(true);
	}
	public void player2Won(){
		gameView.getTimer().stop();
		JOptionPane.showMessageDialog(gameView,
				"Ha vinto il giocatore 2\nTurni: " + gameModel.getMovesCounter()
						+ "\nTempo: " + gameView.getMinLbl().getText() + ":"
						+ gameView.getSecLbl().getText());
		gameModel.setMovesCounter(0);
		gameView.dispose();
		gameModel.setJustPlayed(true);
		startGameView.setVisible(true);
	}
	public void nobodyWon(){
		gameView.getTimer().stop();
		JOptionPane.showMessageDialog(gameView, "Pareggio!\nTurni: " + gameModel.getMovesCounter()
				+ "\nTempo: " + gameView.getMinLbl().getText() + ":" + gameView.getSecLbl().getText());
		gameView.dispose();
		gameModel.setJustPlayed(true);
		startGameView.setVisible(true);
	}
	public void setCell(int x,int y){
		gameView.getCellAt(x,y).setEnabled(false);
		gameView.getCellAt(x,y).setText(gameModel.convertSymbol(gameModel.getOwner().getSign()));
		gameModel.setMove(x,y,gameModel.getOwner());
	}
}
