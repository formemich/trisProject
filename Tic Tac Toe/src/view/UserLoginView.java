package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import mylib.JGradientPanel;

import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JSeparator;

@SuppressWarnings("serial")
public class UserLoginView extends JFrame {

	private JGradientPanel contentPane;
	private JTextField nameField, surnameField;
	private JLabel nameLbl;
	private JLabel surnameLbl;
	private JLabel headLbl;
	private JLabel errLbl;
	private JSeparator separator;
	private JButton sendBtn;

	public UserLoginView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 375, 500);
		setIconImage(Toolkit.getDefaultToolkit().getImage("res/data/gameicon/gameicon.png"));
		contentPane = new JGradientPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 187 };
		gbl_contentPane.rowHeights = new int[] { 30, 14, 0, 0, 0, 0, 75, 30 };
		gbl_contentPane.columnWeights = new double[] { 1.0 };
		gbl_contentPane.rowWeights = new double[] { 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 1.0 };
		contentPane.setLayout(gbl_contentPane);

		headLbl = new JLabel("Accedi");
		headLbl.setForeground(Color.WHITE);
		headLbl.setFont(new Font("SFNS Display", Font.BOLD, 35));
		headLbl.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_headLbl = new GridBagConstraints();
		gbc_headLbl.anchor = GridBagConstraints.SOUTHWEST;
		gbc_headLbl.insets = new Insets(0, 0, 5, 0);
		gbc_headLbl.gridx = 0;
		gbc_headLbl.gridy = 0;
		contentPane.add(headLbl, gbc_headLbl);

		separator = new JSeparator();
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.fill = GridBagConstraints.BOTH;
		gbc_separator.insets = new Insets(0, 0, 5, 0);
		gbc_separator.gridx = 0;
		gbc_separator.gridy = 1;
		contentPane.add(separator, gbc_separator);

		nameLbl = new JLabel("Nome:");
		nameLbl.setForeground(Color.WHITE);
		nameLbl.setFont(new Font("SFNS Display", Font.BOLD, 13));
		nameLbl.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_nameLbl = new GridBagConstraints();
		gbc_nameLbl.anchor = GridBagConstraints.SOUTHWEST;
		gbc_nameLbl.insets = new Insets(0, 0, 5, 0);
		gbc_nameLbl.gridx = 0;
		gbc_nameLbl.gridy = 2;
		contentPane.add(nameLbl, gbc_nameLbl);

		nameField = new JTextField();
		nameField.setHorizontalAlignment(SwingConstants.CENTER);
		nameField.setForeground(Color.WHITE);
		nameField.setBackground(Color.DARK_GRAY);
		nameField.setFont(new Font("SFNS Display", Font.PLAIN, 13));
		GridBagConstraints gbc_nameField = new GridBagConstraints();
		gbc_nameField.insets = new Insets(0, 0, 5, 0);
		gbc_nameField.fill = GridBagConstraints.HORIZONTAL;
		gbc_nameField.gridx = 0;
		gbc_nameField.gridy = 3;
		contentPane.add(nameField, gbc_nameField);
		nameField.setColumns(10);

		surnameLbl = new JLabel("Cognome:");
		surnameLbl.setForeground(Color.WHITE);
		surnameLbl.setFont(new Font("SFNS Display", Font.BOLD, 13));
		surnameLbl.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_surnameLbl = new GridBagConstraints();
		gbc_surnameLbl.anchor = GridBagConstraints.SOUTHWEST;
		gbc_surnameLbl.insets = new Insets(0, 0, 5, 0);
		gbc_surnameLbl.gridx = 0;
		gbc_surnameLbl.gridy = 4;
		contentPane.add(surnameLbl, gbc_surnameLbl);

		surnameField = new JTextField();
		surnameField.setHorizontalAlignment(SwingConstants.CENTER);
		surnameField.setForeground(Color.WHITE);
		surnameField.setFont(new Font("SFNS Display", Font.PLAIN, 13));
		surnameField.setColumns(10);
		surnameField.setBackground(Color.DARK_GRAY);
		GridBagConstraints gbc_surnameField = new GridBagConstraints();
		gbc_surnameField.insets = new Insets(0, 0, 5, 0);
		gbc_surnameField.fill = GridBagConstraints.HORIZONTAL;
		gbc_surnameField.gridx = 0;
		gbc_surnameField.gridy = 5;
		contentPane.add(surnameField, gbc_surnameField);

		errLbl = new JLabel("");
		errLbl.setForeground(Color.RED);
		errLbl.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		GridBagConstraints gbc_errLbl = new GridBagConstraints();
		gbc_errLbl.anchor = GridBagConstraints.WEST;
		gbc_errLbl.insets = new Insets(0, 0, 5, 0);
		gbc_errLbl.gridx = 0;
		gbc_errLbl.gridy = 6;
		contentPane.add(errLbl, gbc_errLbl);

		sendBtn = new JButton("Avanti");
		sendBtn.setForeground(Color.BLACK);
		sendBtn.setBackground(Color.DARK_GRAY);
		sendBtn.setFont(new Font("SFNS Display", Font.BOLD, 25));
		sendBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		GridBagConstraints gbc_sendBtn = new GridBagConstraints();
		gbc_sendBtn.fill = GridBagConstraints.BOTH;
		gbc_sendBtn.gridx = 0;
		gbc_sendBtn.gridy = 7;
		contentPane.add(sendBtn, gbc_sendBtn);

		nameField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				errLbl.setText("");
			}
		});

		surnameField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				errLbl.setText("");
			}
		});

		nameField.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char keyChar = e.getKeyChar();
				if (((JTextField) e.getSource()).getText().length() == 0) {
					e.setKeyChar(Character.toUpperCase(keyChar));
				}
			}
		});

		surnameField.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char keyChar = e.getKeyChar();
				if (((JTextField) e.getSource()).getText().length() == 0) {
					e.setKeyChar(Character.toUpperCase(keyChar));
				}
			}
		});

	}

	public JGradientPanel getContentPane() {
		return contentPane;
	}

	public JTextField getNameField() {
		return nameField;
	}

	public JTextField getSurnameField() {
		return surnameField;
	}

	public JLabel getNameLbl() {
		return nameLbl;
	}

	public JLabel getSurnameLbl() {
		return surnameLbl;
	}

	public JLabel getHeadLbl() {
		return headLbl;
	}

	public JLabel getErrLbl() {
		return errLbl;
	}

	public JSeparator getSeparator() {
		return separator;
	}

	public JButton getSendBtn() {
		return sendBtn;
	}

}
