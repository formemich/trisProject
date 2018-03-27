package client;

import client.Client;
import client.ClientGameView;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {

	private Client client;
	private ClientGameView clientGameView;
	private int board[][];

	public int[][] getBoard() {
		return board;
	}

	public void setBoard(int[][] board) {
		this.board = board;
	}

	public Controller(Client client, ClientGameView	clientGameview) {
		this.client = client;
		this.clientGameView = clientGameview;
		this.board = new int[3][3];
	}

	public void addActionListeners() {
		for (int i = 0; i < clientGameView.getCells().length; i++) {
			for (int j = 0; j < clientGameView.getCells().length; j++) {
				clientGameView.getCellAt(i, j).addActionListener(this);
			}
		}
		clientGameView.getExitBtn().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		boolean proceed = true;
		if (clientGameView.contains(clientGameView.getCells(), (JButton) e.getSource())) {
			((JButton) e.getSource()).setEnabled(false);
			((JButton) e.getSource()).setText("X");
			
		}
		if (e.getSource().equals(clientGameView.getExitBtn())) {
			clientGameView.dispose();
			for (JButton[] btn : clientGameView.getCells()) {
				for (JButton button : btn) {
					button.setEnabled(false);
				}
			}
		}
	}
}
