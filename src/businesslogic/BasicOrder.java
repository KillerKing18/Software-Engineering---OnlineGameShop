package businesslogic;

import businesslogic.iterator.Cart;
import businesslogic.iterator.Iterator;
import transfer.Item;
import transfer.User;

public class BasicOrder implements Order
{

    private Cart cart;
    private User user;

    public BasicOrder(Cart cart, User user)
    {
        this.cart = cart;
        this.user = user;
    }


    public Cart getCart()
    {
        return cart;
    }

    public void setCart(Cart cart)
    {
        this.cart = cart;
    }

    public User getUser()
    {
       return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    @Override
    public double calculateTotalPrice()
    {
        return cart.getTotalPrice();
    }

    @Override
    public String orderSummary()
    {
        StringBuilder summary = new StringBuilder();
        Iterator<Item> iterator = cart.getIterator();
        while(iterator.hasNext())
        {
            Item item = iterator.next();
            summary.append(String.format("%s  %s  €%.2f  %n", item.getTitle(), "X" + cart.getUnits(item), item.getPrice() * cart.getUnits(item)));
        }
        return summary.toString();
    }
}
