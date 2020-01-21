package businesslogic;

public class OrderDiscount extends OrderDecorator
{

    private double discount;

    public OrderDiscount(Order order, double discount)
    {
        super(order);
        this.discount = discount;
    }

    @Override
    public double calculateTotalPrice()
    {
        return super.calculateTotalPrice() - discount;
    }

    @Override
    public String orderSummary()
    {
        return super.orderSummary() + String.format("Discount  %s  -€%.2f  %n", "X1", discount);
    }
}
