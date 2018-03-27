
package model;

public class GameModel {

	private int[][] board;
	private Player player1, player2, owner, winner;
	private int movesCounter;
	private boolean justPlayed;


	/**
	 * Constructor
	 */

	public GameModel(Player player1, Player player2) {
		this.board = new int[3][3];
		this.player1 = player1;
		this.player2 = player2;
		this.owner = player1;
		this.movesCounter = 0;
		this.justPlayed = false;
	}

	/**
	 * Getters and Setters
	 */

	public int[][] getBoard() {
		return board;
	}

	public void setBoard(int[][] board) {
		this.board = board;
	}

	public Player getPlayer1() {
		return player1;
	}

	public void setPlayer1(Player player1) {
		this.player1 = player1;
	}

	public Player getPlayer2() {
		return player2;
	}

	public void setPlayer2(Player player2) {
		this.player2 = player2;
	}

	public Player getOwner() {
		return owner;
	}

	public void setOwner(Player owner) {

		this.owner = owner;
	}

	public Player getWinner() {
		return winner;
	}

	public void setWinner(Player winner) {
		this.winner = winner;
	}

	public int getMovesCounter() {
		return movesCounter;
	}

	public void setMovesCounter(int movesCounter) {
		this.movesCounter = movesCounter;
	}

	public String convertSymbol(int sign) {
		if (sign == 0)
			return "0";
		else
			return "X";
	}

	public boolean isJustPlayed() {
		return justPlayed;
	}

	public void setJustPlayed(boolean justPlayed) {
		this.justPlayed = justPlayed;
	}
	/**
	 * Methods which control the game
	 */

	// method which resets the board
	public void setDefault() {
		for (int i = 0; i < this.board.length; i++) {
			for (int j = 0; j < this.board.length; j++) {
				board[i][j] = -1;
			}
		}
	}

	// if there's not a winner or the game doesn't end, let's increase the counter
	// and proceed
	public void proceed() {
		this.movesCounter++;
	}

	// method which changes the current player
	public void changeOwner() {
		if (movesCounter % 2 == 1) {
			setOwner(player1);
			owner.setTurns(owner.getTurns() + 1);
			proceed();
		} else {
			setOwner(player2);
			owner.setTurns(owner.getTurns() + 1);
			proceed();
		}
	}

	// method which gets a move from a player and validates it
	public void setMove(int x, int y, Player player) {
		if (x >= 0 && y >= 0 && x < 3 && y < 3) {
			if (board[x][y] == -1)
				board[x][y] = player.getSign();
			player.setTurns(player.getTurns() + 1);
		}
	}

	// method which checks if there's a winner and returns true if it exists
	public boolean checkWinner() {
		// rows control
		for (int i = 0; i < 3; i++)
			if (board[i][0] == board[i][1] && board[i][0] == board[i][2] && board[i][0] != -1)
				return true;
		// columns control
		for (int i = 0; i < 3; i++)
			if (board[0][i] == board[1][i] && board[0][i] == board[2][i] && board[0][i] != -1)
				return true;
		// diagonals control
		if (board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[0][0] != -1)
			return true;
		if (board[0][2] == board[1][1] && board[0][2] == board[2][0] && board[0][2] != -1)
			return true;
		return false;

	}

	// method which checks the conditions for the end of game
	public boolean endGame() {
		if (movesCounter == 9 || checkWinner())
			return true;
		else
			return false;
	}


}
