package businesslogic;

import businesslogic.iterator.Cart;
import transfer.User;

public class OrderDecorator implements Order
{

    protected Order order;

    public OrderDecorator(Order order)
    {
        this.order = order;
    }

    @Override
    public double calculateTotalPrice()
    {
        return order.calculateTotalPrice();
    }

    @Override
    public String orderSummary()
    {
        return order.orderSummary();
    }

	@Override
	public Cart getCart() {
		return order.getCart();
	}

	@Override
	public User getUser() {
		return order.getUser();
	}
}
