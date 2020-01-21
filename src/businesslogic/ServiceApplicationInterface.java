package businesslogic;

import java.util.List;

import businesslogic.iterator.Cart;
import transfer.Item;
import transfer.User;

public interface ServiceApplicationInterface {

	public boolean AddUser(User u);
	public boolean RemoveUser(User u);

	public boolean AddItem(Item it);
	public boolean RemoveItem(Item it);


	public boolean CreateNewUser();


	public boolean LogIn(String name, String password);
	public void LogOut();
	
	public List<Item> browse(String searchText);

	public void AddToCart(List<Item> items);
	public boolean RemoveFromCart(Item it);
	public void EmptyCart();
	public boolean SubmitOrder();
	public boolean ItemsPayment();
	
	public Cart getCart();
	
	public void CreateOrder();
	public Order getOrder();
	public void editOrder(double donation, double gift, double delivery, double discount);
}
