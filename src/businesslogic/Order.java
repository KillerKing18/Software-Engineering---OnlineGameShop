package businesslogic;

import businesslogic.iterator.Cart;
import transfer.User;

public interface Order
{

    double calculateTotalPrice();
    String orderSummary();
    Cart getCart();
    User getUser();
}
