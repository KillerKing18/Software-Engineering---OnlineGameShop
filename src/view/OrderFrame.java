package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import businesslogic.Order;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class OrderFrame extends JFrame {

	private JPanel contentPane;
	private MainView view;
	private OrderTable orderTable;
	private Order order;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel totalLabel;
	
	private double gift;
	private double fastdelivery;
	

	/**
	 * Create the frame.
	 */
	public OrderFrame(MainView view, Order order) {
		super("Order");
		this.view = view;
		this.order = order;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 497, 461);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		orderTable = new OrderTable(order);
		panel.add(orderTable);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Fast Delivery");
		chckbxNewCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxNewCheckBox.isSelected())
					fastdelivery = 5.95;
				else
					fastdelivery = 0;
			}
		});
		chckbxNewCheckBox.setBounds(94, 23, 107, 23);
		panel_2.add(chckbxNewCheckBox);
		chckbxNewCheckBox.setHorizontalAlignment(SwingConstants.LEFT);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Order as gift");
		chckbxNewCheckBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxNewCheckBox_1.isSelected())
					gift = 2.75;
				else
					gift = 0;
			}
		});
		chckbxNewCheckBox_1.setBounds(94, 49, 107, 23);
		panel_2.add(chckbxNewCheckBox_1);
		chckbxNewCheckBox_1.setHorizontalAlignment(SwingConstants.LEFT);
		
		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("Donate");
		chckbxNewCheckBox_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxNewCheckBox_2.isSelected())
					textField.setEnabled(true);
				else {
					textField.setEnabled(false);
					textField.setText("");;
				}
			}
		});
		chckbxNewCheckBox_2.setBounds(94, 75, 107, 23);
		panel_2.add(chckbxNewCheckBox_2);
		chckbxNewCheckBox_2.setHorizontalAlignment(SwingConstants.LEFT);
		
		JCheckBox chckbxNewCheckBox_3 = new JCheckBox("Discount code");
		chckbxNewCheckBox_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxNewCheckBox_3.isSelected())
					textField_1.setEnabled(true);
				else {
					textField_1.setEnabled(false);
					textField_1.setText("");;
				}
			}
		});
		chckbxNewCheckBox_3.setBounds(94, 101, 107, 23);
		panel_2.add(chckbxNewCheckBox_3);
		chckbxNewCheckBox_3.setHorizontalAlignment(SwingConstants.LEFT);
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.setActionCommand("Refresh");
		btnRefresh.addActionListener(this.view);
		btnRefresh.setBounds(350, 62, 89, 23);
		panel_2.add(btnRefresh);
		
		JLabel lblTotal = new JLabel("TOTAL:");
		lblTotal.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblTotal.setBounds(166, 150, 52, 23);
		panel_2.add(lblTotal);
		
		textField = new JTextField();
		textField.setBounds(205, 75, 128, 22);
		textField.setEnabled(false);
		panel_2.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(205, 101, 128, 22);
		textField_1.setEnabled(false);
		panel_2.add(textField_1);
		
		totalLabel = new JLabel("" + String.format("%.2f", this.order.calculateTotalPrice()));
		totalLabel.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		totalLabel.setBounds(244, 150, 89, 23);
		panel_2.add(totalLabel);
		
		JLabel label = new JLabel("+ 5.95");
		label.setHorizontalAlignment(SwingConstants.TRAILING);
		label.setBounds(287, 27, 46, 14);
		panel_2.add(label);
		
		JLabel label_1 = new JLabel("+ 2.75");
		label_1.setHorizontalAlignment(SwingConstants.TRAILING);
		label_1.setBounds(287, 53, 46, 14);
		panel_2.add(label_1);
	}
	
	public void setTotal(double num) {
		totalLabel.setText("" + String.format("%.2f", num));
	}
	
	public double getDiscount() {
		return textField_1.isEnabled() ?  Double.parseDouble(textField_1.getText()) : 0;
	}
	
	public double getDonation() {
		return textField.isEnabled() ? Double.parseDouble(textField.getText()) : 0;
	}
	
	public double getFastDelivery() {
		return fastdelivery;
	}
	
	public double getGift() {
		return gift;
	}
	
	public void setSummary() {
		orderTable.setSummary(order);
	}
	
	public void setOrder(Order order) {
		this.order = order;
		setSummary();
	}
}
