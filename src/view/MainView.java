package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class MainView implements ActionListener  {
	private LoginFrame loginFrame;
	private ShopFrame shopFrame;
	private OrderFrame orderFrame;
	
	private Controller _control;
	
	public MainView(Controller control) {
		_control = control;
		loginFrame = new LoginFrame(this);
		loginFrame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String str = arg0.getActionCommand();
		switch(str) {
		case "Login":
			if(_control.LogIn(loginFrame.getUsername(),loginFrame.getPassword())) {
				loginFrame.setVisible(false);
				shopFrame = new ShopFrame(this, _control, loginFrame.getUsername());
				shopFrame.setVisible(true);
				loginFrame = null;
			}
			else
				loginFrame.showLoginError();
			break;
		case "Browse":
			_control.browse(shopFrame.getSearchText());
			break;
		case "Add to Cart":
			_control.addToCart(shopFrame.getSelectedItems());
			shopFrame.setTotal();
			break;
		case "Empty Cart":
			_control.emptyCart();
			shopFrame.setTotal("0");
			break;
		case "Logout":
			_control.emptyCart();
			shopFrame.setVisible(false);
			shopFrame = null;
			loginFrame = new LoginFrame(this);
			loginFrame.setVisible(true);
			break;
		case "Check Out":
			if(!_control.getCart().getItems().isEmpty()) {
				_control.CreateOrder();
				shopFrame.setVisible(false);
				shopFrame = null;
				orderFrame = new OrderFrame(this, _control.getOrder());
				orderFrame.setVisible(true);
			}			
			break;
		case "Refresh":
			try{
				_control.editOrder(orderFrame.getDonation(), orderFrame.getGift(), orderFrame.getFastDelivery(), orderFrame.getDiscount());
			}
			catch (Exception e) {
				JOptionPane.showMessageDialog(orderFrame, "Introduce a correct number", "Error", JOptionPane.ERROR_MESSAGE);
			}
			orderFrame.setTotal(_control.getOrder().calculateTotalPrice());
			orderFrame.setOrder(_control.getOrder());
			break;
		default:
			break;
		}
	}
}
