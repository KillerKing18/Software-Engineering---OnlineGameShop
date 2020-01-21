package businesslogic;

import businesslogic.iterator.Cart;
import transfer.User;

public class OrderLogic
{

    private Order order;

    public OrderLogic(Cart cart, User user)
    {
        order = new BasicOrder(cart, user);
    }

    public Order getOrder()
    {
        return order;
    }

    public void setOrder(Order order)
    {
        this.order = order;
    }

    private void addDonation(double donation)
    {
        order = new OrderDonation(order, donation);
    }

    private void addPackAsGift(double orderAsGiftPrice)
    {
        order = new OrderAsGift(order, orderAsGiftPrice);
    }

    private void addFastDelivery(double fastDeliveryPrice)
    {
        order = new OrderFastDelivery(order, fastDeliveryPrice);
    }

    private void addDiscount(double discount)
    {
        order = new OrderDiscount(order, discount);
    }

    public void editOrder(double donation, double gift, double delivery, double discount) {
    	order = new BasicOrder(order.getCart(), order.getUser());
    	if(delivery != 0)
    		addFastDelivery(delivery);
    	if(gift != 0)
    		addPackAsGift(gift);
    	if(donation != 0)
    		addDonation(donation); 	
    	if(discount != 0)
    		addDiscount(discount);
    }
}
