package view;

import java.util.List;

import businesslogic.iterator.Cart;
import transfer.Item;

public interface ShopObserver {
	public void registered();
	
	public void browsed(List<Item> items);
	
	public void addToCart(Cart cart);
	
	public void emptyCart();	
}