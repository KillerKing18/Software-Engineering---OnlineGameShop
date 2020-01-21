package businesslogic;


import java.util.List;

import businesslogic.iterator.Cart;
import transfer.Item;
import transfer.User;

public class MyServiceApplication implements ServiceApplicationInterface {
	
	private UserLogic userLogic;
	private ItemLogic itemLogic;
	private OrderLogic orderLogic;
	private Cart cart;
	
	public MyServiceApplication(){
		userLogic = new UserLogic();
		itemLogic = new ItemLogic();
		cart = new Cart();
	}

	public boolean AddUser(User u) {
		return false;
	}

	public boolean RemoveUser(User u) {
		return false;
	}


	public boolean AddItem(Item it) {
		return false;
	}

	public boolean RemoveItem(Item it) {
		return false;
	}


	public boolean CreateNewUser() {
		return false;
	}


	public boolean LogIn(String name, String password) {
		return userLogic.LogIn(name, password);
	}
	
	public void LogOut()	{
		userLogic.LogOut();
	}
	
	public List<Item> browse(String searchText){
		return itemLogic.browse(searchText);
	}

	public void AddToCart(List<Item> items) {
		cart.addItems(items);
	}
	
	public void EmptyCart() {
		cart.emptyCart();
	}

	public boolean RemoveFromCart(Item it) {
		return false;
	}

	public boolean SubmitOrder() {
		return false;
	}
	
	public void CreateOrder() {
		orderLogic = new OrderLogic(cart, userLogic.getUser());
	}

	public boolean ItemsPayment() {
		return false;
	}
	
	public Cart getCart() {
		return cart;
	}

	@Override
	public Order getOrder() {
		return orderLogic.getOrder();
	}

	@Override
	public void editOrder(double donation, double gift, double delivery, double discount) {
		orderLogic.editOrder(donation, gift, delivery, discount);
	}
}
