package businesslogic;

public class OrderAsGift extends OrderDecorator
{

    private double orderAsGiftPrice;

    public OrderAsGift(Order order, double orderAsGiftPrice)
    {
        super(order);
        this.orderAsGiftPrice = orderAsGiftPrice;
    }

    @Override
    public double calculateTotalPrice()
    {
        return super.calculateTotalPrice() + orderAsGiftPrice;
    }

    @Override
    public String orderSummary()
    {
    	return super.orderSummary() + String.format("Pack as gift  %s  €%.2f  %n", "X1", orderAsGiftPrice);
    }
}
