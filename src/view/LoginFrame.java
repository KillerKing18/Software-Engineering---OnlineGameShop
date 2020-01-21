package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.Color;

@SuppressWarnings("serial")
public class LoginFrame extends JFrame {
	private MainView _view;
	

	private JPanel contentPane;
	private JPanel mainPanel;
	private JLabel lblWelcomeToOnline;
	private JLabel lblUsername;
	private JTextField txtUsername;
	private JLabel lblPassword;
	private JPasswordField passwordField;
	private JLabel lblWrong;
	private JButton loginButton;

	/**
	 * Create the frame.
	 */
	public LoginFrame(MainView view) {
		_view = view;
		initGUI();
	}
	
	private void initGUI() {
		setTitle("OnlineGameShop");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 418, 280);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		mainPanel = new JPanel();
		contentPane.add(mainPanel, BorderLayout.CENTER);
		mainPanel.setLayout(null);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(50, 67, 300, 20);
		mainPanel.add(txtUsername);
		txtUsername.setMaximumSize(new Dimension(300, 20));
		txtUsername.setMinimumSize(new Dimension(500, 20));
		txtUsername.setToolTipText("");
		txtUsername.setHorizontalAlignment(SwingConstants.LEFT);
		txtUsername.setColumns(10);
		
		lblPassword = new JLabel("Password:");
		lblPassword.setBounds(50, 93, 80, 20);
		mainPanel.add(lblPassword);
		lblPassword.setMaximumSize(new Dimension(75, 20));
		lblPassword.setMinimumSize(new Dimension(75, 20));
		lblPassword.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblPassword.setHorizontalAlignment(SwingConstants.LEFT);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(50, 116, 300, 20);
		mainPanel.add(passwordField);
		passwordField.setMaximumSize(new Dimension(300, 20));
		passwordField.setMinimumSize(new Dimension(500, 20));
		passwordField.setHorizontalAlignment(SwingConstants.LEFT);
		
		lblWrong = new JLabel("Incorrect password. Try again.");
		lblWrong.setVisible(false);
		lblWrong.setForeground(Color.RED);
		lblWrong.setBounds(113, 147, 181, 14);
		
		loginButton = new JButton("Login");
		loginButton.setActionCommand("Login");
		loginButton.addActionListener(_view);
		loginButton.setBounds(164, 175, 71, 23);
		mainPanel.add(loginButton);
		
		lblWelcomeToOnline = new JLabel("Welcome to Online Game Shop!");
		lblWelcomeToOnline.setBounds(93, 21, 201, 14);
		mainPanel.add(lblWelcomeToOnline);
		lblWelcomeToOnline.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblWelcomeToOnline.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblUsername = new JLabel("Username:");
		lblUsername.setBounds(50, 45, 80, 20);
		mainPanel.add(lblUsername);
		lblUsername.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblUsername.setMaximumSize(new Dimension(75, 20));
		lblUsername.setMinimumSize(new Dimension(75, 20));
		lblUsername.setHorizontalAlignment(SwingConstants.LEFT);
		
		mainPanel.add(lblWrong);
	}
	
	public String getUsername() {
		return txtUsername.getText();
	}
	
	@SuppressWarnings("deprecation")
	public String getPassword() {
		return passwordField.getText();
	}
	
	public void showLoginError() {
		lblWrong.setVisible(true);
	}
}
