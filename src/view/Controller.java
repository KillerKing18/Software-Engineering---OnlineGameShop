package view;

import java.util.ArrayList;
import java.util.List;

import businesslogic.Order;
import businesslogic.ServiceApplicationInterface;
import businesslogic.iterator.Cart;
import transfer.Item;

public class Controller implements Observable<ShopObserver>{
	private ServiceApplicationInterface _appService;
	
	private List<ShopObserver> _observers;
	
	public Controller(ServiceApplicationInterface appService){
		_appService = appService;
		_observers = new ArrayList<ShopObserver>();
	}
	
	public boolean LogIn(String username, String password) {
		return _appService.LogIn(username, password);
	}
	
	public void browse(String searchText) {
		notifyBrowsed(_appService.browse(searchText));
	}
	
	public void addToCart(List<Item> items) {
		_appService.AddToCart(items);
		notifyAddedToCart(items);
	}
	
	public void emptyCart() {
		_appService.EmptyCart();
		notifyEmptyCart();
	}
	
	public Cart getCart() {
		return _appService.getCart();
	}
	
	public void CreateOrder() {
		_appService.CreateOrder();
	}
	
	public Order getOrder() {
		return _appService.getOrder();
	}
	
	public void editOrder(double donation, double gift, double delivery, double discount) {
		_appService.editOrder(donation, gift, delivery, discount);
	}
	
	private void notifyRegistered(ShopObserver o) {
		o.registered();
	}
	
	private void notifyBrowsed(List<Item> items) {
		for(ShopObserver o : _observers)
			o.browsed(items);
	}
	
	private void notifyAddedToCart(List<Item> items) {
		for(ShopObserver o : _observers)
			o.addToCart(getCart());
	}
	
	private void notifyEmptyCart() {
		for(ShopObserver o : _observers)
			o.emptyCart();
	}

	@Override
	public void addObserver(ShopObserver o) {
		if(o != null && !_observers.contains(o)) {
			_observers.add(o);
			notifyRegistered(o);
		}
	}

	@Override
	public void removeObserver(ShopObserver o) {
		if(o != null && _observers.contains(o))
			_observers.remove(o);
	}
}
