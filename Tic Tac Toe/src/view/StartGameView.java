package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import mylib.JGradientPanel;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.JRadioButton;
import javax.swing.JList;
import java.awt.SystemColor;
import javax.swing.ListSelectionModel;

@SuppressWarnings("serial")
public class StartGameView extends JFrame {

	private JGradientPanel contentPane;
	private JPanel singlePnl, multiPnl;
	private JRadioButton xBtn, oBtn;
	private JButton sendSPBtn, sendMPBtn, exitBtn, mpBtn;
	private JLabel titleLbl;

	public StartGameView() {
		setResizable(false);
		setTitle("Tris");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 522);
		setLocationRelativeTo(null);
		setIconImage(Toolkit.getDefaultToolkit().getImage("res/data/gameicon/gameicon.png"));
		contentPane = new JGradientPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 137, 466, 0 };
		gbl_contentPane.rowHeights = new int[] { 40, 24, 28, 225, 15, 225, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		JPanel headPnl = new JPanel();
		headPnl.setOpaque(false);
		headPnl.setBackground(Color.DARK_GRAY);
		GridBagConstraints gbc_headPnl = new GridBagConstraints();
		gbc_headPnl.insets = new Insets(0, 0, 5, 0);
		gbc_headPnl.gridwidth = 2;
		gbc_headPnl.fill = GridBagConstraints.BOTH;
		gbc_headPnl.gridx = 0;
		gbc_headPnl.gridy = 0;
		contentPane.add(headPnl, gbc_headPnl);
		GridBagLayout gbl_headPnl = new GridBagLayout();
		gbl_headPnl.columnWidths = new int[] { 468, 0 };
		gbl_headPnl.rowHeights = new int[] { 0, 0 };
		gbl_headPnl.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_headPnl.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		headPnl.setLayout(gbl_headPnl);

		JLabel headLbl = new JLabel("Tris");
		headLbl.setForeground(Color.WHITE);
		headLbl.setBackground(Color.DARK_GRAY);
		headLbl.setFont(new Font("Luminari", Font.BOLD, 70));
		headLbl.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_headLbl = new GridBagConstraints();
		gbc_headLbl.insets = new Insets(0, -1, 0, 0);
		gbc_headLbl.fill = GridBagConstraints.BOTH;
		gbc_headLbl.gridx = 0;
		gbc_headLbl.gridy = 0;
		headPnl.add(headLbl, gbc_headLbl);
		gbc_headLbl.insets = new Insets(0, -1, 0, 0);

		JSeparator separator = new JSeparator();
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.fill = GridBagConstraints.BOTH;
		gbc_separator.gridwidth = 2;
		gbc_separator.insets = new Insets(0, 0, 5, 0);
		gbc_separator.gridx = 0;
		gbc_separator.gridy = 1;
		contentPane.add(separator, gbc_separator);

		JPanel leftPnl = new JPanel();
		leftPnl.setOpaque(false);
		leftPnl.setBackground(Color.DARK_GRAY);
		GridBagConstraints gbc_leftPnl = new GridBagConstraints();
		gbc_leftPnl.gridheight = 4;
		gbc_leftPnl.insets = new Insets(0, 0, 0, 5);
		gbc_leftPnl.fill = GridBagConstraints.BOTH;
		gbc_leftPnl.gridx = 0;
		gbc_leftPnl.gridy = 2;
		contentPane.add(leftPnl, gbc_leftPnl);
		GridBagLayout gbl_leftPnl = new GridBagLayout();
		gbl_leftPnl.columnWidths = new int[] { 0, 13, 0 };
		gbl_leftPnl.rowHeights = new int[] { 0, 0, 0, 32, 0, 0 };
		gbl_leftPnl.columnWeights = new double[] { 1.0, 0.0, Double.MIN_VALUE };
		gbl_leftPnl.rowWeights = new double[] { 0.0, 1.0, 1.0, 0.0, 1.0, Double.MIN_VALUE };
		leftPnl.setLayout(gbl_leftPnl);

		JLabel diffLbl = new JLabel("Scegli la difficolt\u00E0\u00A0:");
		diffLbl.setFont(new Font("SFNS Display", Font.BOLD, 15));
		diffLbl.setForeground(Color.WHITE);
		GridBagConstraints gbc_diffLbl = new GridBagConstraints();
		gbc_diffLbl.insets = new Insets(0, 0, 5, 5);
		gbc_diffLbl.gridx = 0;
		gbc_diffLbl.gridy = 0;
		leftPnl.add(diffLbl, gbc_diffLbl);

		JButton spBtn = new JButton("Single Player");
		spBtn.setForeground(Color.BLACK);
		spBtn.setBackground(Color.DARK_GRAY);
		spBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		spBtn.setFont(new Font("Arial", Font.PLAIN, 15));
		GridBagConstraints gbc_spBtn = new GridBagConstraints();
		gbc_spBtn.fill = GridBagConstraints.BOTH;
		gbc_spBtn.insets = new Insets(0, 0, 5, 5);
		gbc_spBtn.gridx = 0;
		gbc_spBtn.gridy = 1;
		leftPnl.add(spBtn, gbc_spBtn);

		JSeparator separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		GridBagConstraints gbc_separator_2 = new GridBagConstraints();
		gbc_separator_2.fill = GridBagConstraints.BOTH;
		gbc_separator_2.gridheight = 5;
		gbc_separator_2.gridx = 1;
		gbc_separator_2.gridy = 0;
		leftPnl.add(separator_2, gbc_separator_2);

		mpBtn = new JButton("Multi Player");
		mpBtn.setForeground(Color.BLACK);
		mpBtn.setBackground(Color.DARK_GRAY);
		mpBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mpBtn.setFont(new Font("Arial", Font.PLAIN, 15));
		GridBagConstraints gbc_mpBtn = new GridBagConstraints();
		gbc_mpBtn.fill = GridBagConstraints.BOTH;
		gbc_mpBtn.insets = new Insets(0, 0, 5, 5);
		gbc_mpBtn.gridx = 0;
		gbc_mpBtn.gridy = 2;
		leftPnl.add(mpBtn, gbc_mpBtn);

		JSeparator separator_1 = new JSeparator();
		GridBagConstraints gbc_separator_1 = new GridBagConstraints();
		gbc_separator_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_separator_1.insets = new Insets(0, 0, 5, 5);
		gbc_separator_1.gridx = 0;
		gbc_separator_1.gridy = 3;
		leftPnl.add(separator_1, gbc_separator_1);

		exitBtn = new JButton("Esci");
		GridBagConstraints gbc_exitBtn = new GridBagConstraints();
		gbc_exitBtn.insets = new Insets(0, 0, 0, 5);
		gbc_exitBtn.fill = GridBagConstraints.BOTH;
		gbc_exitBtn.gridx = 0;
		gbc_exitBtn.gridy = 4;
		leftPnl.add(exitBtn, gbc_exitBtn);
		exitBtn.setIcon(null);
		exitBtn.setForeground(Color.BLACK);
		exitBtn.setFont(new Font("Arial", Font.PLAIN, 15));
		exitBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		exitBtn.setBackground(Color.DARK_GRAY);

		titleLbl = new JLabel();
		titleLbl.setFont(new Font("SFNS Display", Font.BOLD, 20));
		titleLbl.setForeground(Color.WHITE);
		GridBagConstraints gbc_titleLbl = new GridBagConstraints();
		gbc_titleLbl.insets = new Insets(0, 0, 5, 0);
		gbc_titleLbl.gridx = 1;
		gbc_titleLbl.gridy = 2;
		contentPane.add(titleLbl, gbc_titleLbl);

		singlePnl = new JPanel();
		singlePnl.setOpaque(false);
		GridBagConstraints gbc_singlePnl = new GridBagConstraints();
		gbc_singlePnl.insets = new Insets(0, 0, 5, 0);
		gbc_singlePnl.fill = GridBagConstraints.BOTH;
		gbc_singlePnl.gridx = 1;
		gbc_singlePnl.gridy = 3;
		contentPane.add(singlePnl, gbc_singlePnl);
		GridBagLayout gbl_singlePnl = new GridBagLayout();
		gbl_singlePnl.columnWidths = new int[] { 0, 0 };
		gbl_singlePnl.rowHeights = new int[] { 0, 0, 0, 0 };
		gbl_singlePnl.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_singlePnl.rowWeights = new double[] { 1.0, 1.0, 1.0, Double.MIN_VALUE };
		singlePnl.setLayout(gbl_singlePnl);

		JLabel singleHeadLbl = new JLabel("Seleziona il simbolo:");
		singleHeadLbl.setHorizontalAlignment(SwingConstants.CENTER);
		singleHeadLbl.setForeground(Color.WHITE);
		singleHeadLbl.setFont(new Font("SFNS Display", Font.BOLD, 13));
		singleHeadLbl.setBackground(Color.DARK_GRAY);
		GridBagConstraints gbc_singleHeadLbl = new GridBagConstraints();
		gbc_singleHeadLbl.anchor = GridBagConstraints.SOUTH;
		gbc_singleHeadLbl.insets = new Insets(0, 0, 5, 0);
		gbc_singleHeadLbl.gridx = 0;
		gbc_singleHeadLbl.gridy = 0;
		singlePnl.add(singleHeadLbl, gbc_singleHeadLbl);

		JPanel buttonsPnl = new JPanel();
		buttonsPnl.setEnabled(false);
		buttonsPnl.setOpaque(false);
		buttonsPnl.setBackground(Color.DARK_GRAY);
		GridBagConstraints gbc_buttonsPnl = new GridBagConstraints();
		gbc_buttonsPnl.insets = new Insets(0, 0, 5, 0);
		gbc_buttonsPnl.fill = GridBagConstraints.BOTH;
		gbc_buttonsPnl.gridx = 0;
		gbc_buttonsPnl.gridy = 1;
		singlePnl.add(buttonsPnl, gbc_buttonsPnl);
		GridBagLayout gbl_buttonsPnl = new GridBagLayout();
		gbl_buttonsPnl.columnWidths = new int[] { 100, 100, 0 };
		gbl_buttonsPnl.rowHeights = new int[] { 0, 0 };
		gbl_buttonsPnl.columnWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		gbl_buttonsPnl.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		buttonsPnl.setLayout(gbl_buttonsPnl);

		xBtn = new JRadioButton("X");
		xBtn.setOpaque(false);
		xBtn.setEnabled(false);
		xBtn.setHorizontalAlignment(SwingConstants.CENTER);
		xBtn.setForeground(Color.WHITE);
		xBtn.setFont(new Font("SFNS Display", Font.PLAIN, 15));
		xBtn.setBackground(Color.DARK_GRAY);
		GridBagConstraints gbc_xBtn = new GridBagConstraints();
		gbc_xBtn.insets = new Insets(0, 0, 0, 5);
		gbc_xBtn.gridx = 0;
		gbc_xBtn.gridy = 0;
		buttonsPnl.add(xBtn, gbc_xBtn);

		oBtn = new JRadioButton("O");
		oBtn.setOpaque(false);
		oBtn.setEnabled(false);
		oBtn.setHorizontalAlignment(SwingConstants.CENTER);
		oBtn.setForeground(Color.WHITE);
		oBtn.setFont(new Font("SFNS Display", Font.PLAIN, 15));
		oBtn.setBackground(Color.DARK_GRAY);
		GridBagConstraints gbc_oBtn = new GridBagConstraints();
		gbc_oBtn.gridx = 1;
		gbc_oBtn.gridy = 0;
		buttonsPnl.add(oBtn, gbc_oBtn);

		sendSPBtn = new JButton("Gioca");
		sendSPBtn.setEnabled(false);
		GridBagConstraints gbc_sendSPBtn = new GridBagConstraints();
		gbc_sendSPBtn.fill = GridBagConstraints.BOTH;
		gbc_sendSPBtn.gridx = 0;
		gbc_sendSPBtn.gridy = 2;
		singlePnl.add(sendSPBtn, gbc_sendSPBtn);
		sendSPBtn.setForeground(Color.BLACK);
		sendSPBtn.setFont(new Font("Arial", Font.PLAIN, 15));
		sendSPBtn.setBackground(Color.DARK_GRAY);

		JSeparator separator_3 = new JSeparator();
		GridBagConstraints gbc_separator_3 = new GridBagConstraints();
		gbc_separator_3.fill = GridBagConstraints.BOTH;
		gbc_separator_3.insets = new Insets(0, 0, 5, 0);
		gbc_separator_3.gridx = 1;
		gbc_separator_3.gridy = 4;
		contentPane.add(separator_3, gbc_separator_3);

		multiPnl = new JPanel();
		multiPnl.setOpaque(false);
		GridBagConstraints gbc_multiPnl = new GridBagConstraints();
		gbc_multiPnl.fill = GridBagConstraints.BOTH;
		gbc_multiPnl.gridx = 1;
		gbc_multiPnl.gridy = 5;
		contentPane.add(multiPnl, gbc_multiPnl);
		GridBagLayout gbl_multiPnl = new GridBagLayout();
		gbl_multiPnl.columnWidths = new int[] { 0, 0 };
		gbl_multiPnl.rowHeights = new int[] { 0, 82, 0, 0 };
		gbl_multiPnl.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_multiPnl.rowWeights = new double[] { 1.0, 0.0, 1.0, Double.MIN_VALUE };
		multiPnl.setLayout(gbl_multiPnl);

		JLabel multiHeadLbl = new JLabel("Premi sul bottone quando appare la scritta di connessione stabilita:");
		multiHeadLbl.setHorizontalAlignment(SwingConstants.CENTER);
		multiHeadLbl.setForeground(Color.WHITE);
		multiHeadLbl.setFont(new Font("SFNS Display", Font.BOLD, 13));
		GridBagConstraints gbc_multiHeadLbl = new GridBagConstraints();
		gbc_multiHeadLbl.anchor = GridBagConstraints.SOUTH;
		gbc_multiHeadLbl.insets = new Insets(0, 0, 5, 0);
		gbc_multiHeadLbl.gridx = 0;
		gbc_multiHeadLbl.gridy = 0;
		multiPnl.add(multiHeadLbl, gbc_multiHeadLbl);
		
		JLabel connectionLbl = new JLabel("In attesa di connessione...");
		connectionLbl.setFont(new Font("Dialog", Font.PLAIN, 13));
		connectionLbl.setForeground(Color.RED);
		GridBagConstraints gbc_connectionLbl = new GridBagConstraints();
		gbc_connectionLbl.anchor = GridBagConstraints.WEST;
		gbc_connectionLbl.insets = new Insets(0, 0, 5, 0);
		gbc_connectionLbl.gridx = 0;
		gbc_connectionLbl.gridy = 1;
		multiPnl.add(connectionLbl, gbc_connectionLbl);

		sendMPBtn = new JButton("Gioca");
		sendMPBtn.setEnabled(false);
		sendMPBtn.setForeground(Color.BLACK);
		sendMPBtn.setFont(new Font("Arial", Font.PLAIN, 15));
		sendMPBtn.setBackground(Color.DARK_GRAY);
		GridBagConstraints gbc_sendMPBtn = new GridBagConstraints();
		gbc_sendMPBtn.fill = GridBagConstraints.BOTH;
		gbc_sendMPBtn.gridx = 0;
		gbc_sendMPBtn.gridy = 2;
		multiPnl.add(sendMPBtn, gbc_sendMPBtn);

		xBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				oBtn.setSelected(false);
			}
		});

		oBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xBtn.setSelected(false);
			}
		});

		spBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mpBtn.setForeground(Color.BLACK);
				spBtn.setForeground(Color.RED);
				xBtn.setEnabled(true);
				oBtn.setEnabled(true);
				sendSPBtn.setEnabled(true);
				sendMPBtn.setEnabled(false);
				SwingUtilities.updateComponentTreeUI(contentPane);
			}
		});

		mpBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mpBtn.setForeground(Color.RED);
				spBtn.setForeground(Color.BLACK);
				xBtn.setEnabled(false);
				oBtn.setEnabled(false);
				sendSPBtn.setEnabled(false);
				sendMPBtn.setEnabled(true);
				SwingUtilities.updateComponentTreeUI(contentPane);
			}
		});
	}

	public JGradientPanel getContentPane() {
		return contentPane;
	}
	
	public JLabel getTitleLbl() {
		return titleLbl;
	}

	public JPanel getSinglePnl() {
		return singlePnl;
	}

	public JPanel getMultiPnl() {
		return multiPnl;
	}

	public JRadioButton getxBtn() {
		return xBtn;
	}

	public JRadioButton getoBtn() {
		return oBtn;
	}

	public JButton getSendSPBtn() {
		return sendSPBtn;
	}
	public JButton getMultiButton(){
		return mpBtn;
	}

	public JButton getSendMPBtn() {
		return sendMPBtn;
	}

	public JButton getExitBtn() {
		return exitBtn;
	}

	public int getSignValue() {
		if (oBtn.isSelected())
			return 0;
		else if (xBtn.isSelected())
			return 1;
		else
			return -1;
	}

}
