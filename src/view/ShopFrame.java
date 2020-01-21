package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.util.List;
import java.awt.Color;
import javax.swing.JSeparator;

import transfer.Item;

@SuppressWarnings("serial")
public class ShopFrame extends JFrame {
	private MainView _view;
	private Controller _control;
	
	private JLabel iconLabel;
	private JTextField textField;
	private BrowseTable browseTable;
	private CartTable cartTable;
	private JLabel label;

	public ShopFrame(MainView view, Controller control, String user) {
		_view = view;
		_control = control;
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setTitle("OnlineGameShop");
		this.setSize(1150, 700);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1128, 671);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(59, 82, 665, 26);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel(user);
		lblNewLabel.setBackground(Color.DARK_GRAY);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(879, 34, 117, 20);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Logout");
		btnNewButton.setActionCommand("Logout");
		btnNewButton.addActionListener(_view);
		btnNewButton.setBounds(1011, 30, 90, 29);
		panel.add(btnNewButton);
		
		iconLabel = new JLabel("");
		iconLabel.setBounds(879, 82, 222, 324);
		panel.add(iconLabel);
		
		browseTable = new BrowseTable(iconLabel);
		_control.addObserver(browseTable);
		browseTable.setBounds(59, 126, 795, 235);
		panel.add(browseTable);
		
		JButton btnNewButton_1 = new JButton("Search");
		btnNewButton_1.setActionCommand("Browse");
		btnNewButton_1.addActionListener(_view);
		btnNewButton_1.setBounds(739, 81, 115, 29);
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("ONLINE GAME SHOP");
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setFont(new Font("DejaVu Sans", Font.BOLD, 25));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(284, 16, 371, 50);
		panel.add(lblNewLabel_2);
		
		cartTable = new CartTable(_control.getCart(), iconLabel);
		_control.addObserver(cartTable);
		cartTable.setBounds(59, 440, 795, 172);
		panel.add(cartTable);
		
		JButton btnNewButton_2 = new JButton("Check Out");
		btnNewButton_2.setActionCommand("Check Out");
		btnNewButton_2.addActionListener(_view);
		btnNewButton_2.setBounds(879, 440, 222, 83);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Add to Cart");
		btnNewButton_3.setActionCommand("Add to Cart");
		btnNewButton_3.addActionListener(_view);
		btnNewButton_3.setBounds(59, 377, 795, 29);
		panel.add(btnNewButton_3);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.DARK_GRAY);
		separator.setForeground(Color.DARK_GRAY);
		separator.setBounds(59, 422, 1042, 7);
		panel.add(separator);
		
		JButton btnNewButton_4 = new JButton("Empty Cart");
		btnNewButton_4.setActionCommand("Empty Cart");
		btnNewButton_4.addActionListener(_view);
		btnNewButton_4.setBounds(879, 535, 222, 77);
		panel.add(btnNewButton_4);
		
		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTotal.setBounds(59, 631, 55, 14);
		panel.add(lblTotal);
		
		label = new JLabel("0");
		label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label.setBounds(124, 631, 117, 14);
		panel.add(label);
		_view = view;
		initGUI();
	}
	
	public void initGUI() {
		
	}
	
	public String getSearchText() {
		return textField.getText();
	}
	
	public List<Item> getSelectedItems(){
		return browseTable.getSelectedItems();
	}
	
	public void setTotal() {
		label.setText("" + String.format("%.2f", cartTable.getTotal()));
	}
	
	public void setTotal(String str) {
		label.setText(str);
	}
}
