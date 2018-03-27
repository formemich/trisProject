package view;

import java.awt.Color;
import java.awt.Cursor;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import mylib.JGradientPanel;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.*;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import java.awt.Font;
import javax.swing.JSeparator;

@SuppressWarnings("serial")
public class GameView extends JFrame {

	private JGradientPanel contentPane;
	private int sec = 0;
	private JLabel minLbl;
	private JLabel secLbl;
	private JButton exitBtn;
	private JButton[][] cells;
	private int x, y;

	Timer timer = new Timer(1000, e -> refreshTime());

	public GameView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 620, 420);
		setIconImage(Toolkit.getDefaultToolkit().getImage("res/data/gameicon/gameicon.png"));
		contentPane = new JGradientPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 327, 99, 0 };
		gbl_contentPane.rowHeights = new int[] { 30, 0, 298, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 1.0, 0.0, 1.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);
		setLocationRelativeTo(null);
		setAlwaysOnTop(true);

		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				timer.start();
			}
		});

		JLabel headLbl = new JLabel("Schermata di gioco");
		headLbl.setForeground(Color.WHITE);
		headLbl.setBackground(Color.DARK_GRAY);
		headLbl.setHorizontalAlignment(SwingConstants.CENTER);
		headLbl.setFont(new Font("SFNS Display", Font.BOLD, 25));
		GridBagConstraints gbc_headLbl = new GridBagConstraints();
		gbc_headLbl.anchor = GridBagConstraints.SOUTHWEST;
		gbc_headLbl.insets = new Insets(0, 0, 5, 5);
		gbc_headLbl.gridx = 0;
		gbc_headLbl.gridy = 0;
		contentPane.add(headLbl, gbc_headLbl);

		JSeparator separator = new JSeparator();
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.fill = GridBagConstraints.BOTH;
		gbc_separator.insets = new Insets(0, 0, 5, 5);
		gbc_separator.gridx = 0;
		gbc_separator.gridy = 1;
		contentPane.add(separator, gbc_separator);

		JPanel bodyPnl = new JPanel();
		bodyPnl.setForeground(Color.WHITE);
		bodyPnl.setBorder(new LineBorder(SystemColor.window, 10));
		bodyPnl.setBackground(SystemColor.window);
		GridBagConstraints gbc_bodyPnl = new GridBagConstraints();
		gbc_bodyPnl.insets = new Insets(0, 0, 0, 5);
		gbc_bodyPnl.fill = GridBagConstraints.BOTH;
		gbc_bodyPnl.gridx = 0;
		gbc_bodyPnl.gridy = 2;
		contentPane.add(bodyPnl, gbc_bodyPnl);
		bodyPnl.setLayout(new GridLayout(3, 3, 0, 0));

		JPanel rightPnl = new JPanel();
		rightPnl.setOpaque(false);
		rightPnl.setForeground(Color.WHITE);
		rightPnl.setBackground(Color.DARK_GRAY);
		GridBagConstraints gbc_rightPnl = new GridBagConstraints();
		gbc_rightPnl.gridheight = 3;
		gbc_rightPnl.fill = GridBagConstraints.BOTH;
		gbc_rightPnl.gridx = 1;
		gbc_rightPnl.gridy = 0;
		contentPane.add(rightPnl, gbc_rightPnl);
		GridBagLayout gbl_rightPnl = new GridBagLayout();
		gbl_rightPnl.columnWidths = new int[] { 0, 0 };
		gbl_rightPnl.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		gbl_rightPnl.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_rightPnl.rowWeights = new double[] { 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE };
		rightPnl.setLayout(gbl_rightPnl);

		JPanel timePnl = new JPanel();
		timePnl.setOpaque(false);
		timePnl.setForeground(Color.WHITE);
		timePnl.setBackground(Color.DARK_GRAY);
		GridBagConstraints gbc_timePnl = new GridBagConstraints();
		gbc_timePnl.gridheight = 2;
		gbc_timePnl.insets = new Insets(0, 0, 5, 0);
		gbc_timePnl.fill = GridBagConstraints.BOTH;
		gbc_timePnl.gridx = 0;
		gbc_timePnl.gridy = 0;
		rightPnl.add(timePnl, gbc_timePnl);
		GridBagLayout gbl_timePnl = new GridBagLayout();
		gbl_timePnl.columnWidths = new int[] { 40, 40 };
		gbl_timePnl.rowHeights = new int[] { 0, 16, 0 };
		gbl_timePnl.columnWeights = new double[] { 0.0, 0.0 };
		gbl_timePnl.rowWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		timePnl.setLayout(gbl_timePnl);

		minLbl = new JLabel("00");
		minLbl.setForeground(Color.WHITE);
		minLbl.setFont(new Font("Arial", Font.BOLD, 40));
		GridBagConstraints gbc_minLbl = new GridBagConstraints();
		gbc_minLbl.gridheight = 2;
		gbc_minLbl.anchor = GridBagConstraints.EAST;
		gbc_minLbl.insets = new Insets(0, 0, 0, 5);
		gbc_minLbl.gridx = 0;
		gbc_minLbl.gridy = 0;
		timePnl.add(minLbl, gbc_minLbl);

		secLbl = new JLabel("00");
		secLbl.setForeground(Color.WHITE);
		secLbl.setFont(new Font("Arial", Font.BOLD, 25));
		GridBagConstraints gbc_secLbl = new GridBagConstraints();
		gbc_secLbl.insets = new Insets(0, 0, 5, 0);
		gbc_secLbl.anchor = GridBagConstraints.SOUTHWEST;
		gbc_secLbl.gridx = 1;
		gbc_secLbl.gridy = 0;
		timePnl.add(secLbl, gbc_secLbl);

		exitBtn = new JButton("Abbandona");
		exitBtn.setFont(new Font("SFNS Display", Font.PLAIN, 15));
		exitBtn.setBackground(Color.WHITE);
		exitBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		GridBagConstraints gbc_exitBtn = new GridBagConstraints();
		gbc_exitBtn.fill = GridBagConstraints.BOTH;
		gbc_exitBtn.gridx = 0;
		gbc_exitBtn.gridy = 5;
		rightPnl.add(exitBtn, gbc_exitBtn);

		cells = new JButton[3][3];

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				cells[i][j] = new JButton();
				cells[i][j].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				cells[i][j].setFont(new Font("SFNS Display", Font.BOLD, 50));

				int thisI = i;
				int thisJ = j;

				cells[i][j].addMouseListener(new MouseListener() {

					@Override
					public void mouseClicked(MouseEvent mouseEvent) {

					}

					@Override
					public void mousePressed(MouseEvent mouseEvent) {

					}

					@Override
					public void mouseReleased(MouseEvent mouseEvent) {

					}

					public void mouseEntered(MouseEvent mouseEvent) {
						x = thisI;
						y = thisJ;
					}

					@Override
					public void mouseExited(MouseEvent mouseEvent) {

					}
				});
				bodyPnl.add(cells[i][j]);

			}
		}
	}

	private void refreshTime() {
		sec++;
		if ((sec % 60) < 10)
			secLbl.setText("0" + sec % 60);
		else
			secLbl.setText("" + sec % 60);
		if ((sec / 60) < 10)
			minLbl.setText("0" + sec / 60);
		else
			minLbl.setText("" + sec / 60);
	}

	public JGradientPanel getContentPane() {
		return contentPane;
	}

	public int getSec() {
		return sec;
	}

	public JLabel getMinLbl() {
		return minLbl;
	}

	public JLabel getSecLbl() {
		return secLbl;
	}

	public JButton getExitBtn() {
		return exitBtn;
	}

	public JButton[][] getCells() {
		return cells;
	}

	public JButton getCellAt(int i, int j) {
		return cells[i][j];
	}

	public Timer getTimer() {
		return timer;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public boolean contains(JButton[][] cells, JButton source) {
		int i = 0;
		for (JButton[] cellsArray : cells) {
			for (JButton cell : cellsArray) {
				if (cell.equals(source))
					i++;
			}
		}
		if (i == 1) {
			return true;
		} else {
			return false;
		}
	}
	
	public void resetTimer() {
		this.sec = 0;
	}
}
