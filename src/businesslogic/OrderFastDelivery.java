package businesslogic;

public class OrderFastDelivery extends OrderDecorator
{

    private double fastDeliveryCost;

    public OrderFastDelivery(Order order, double fastDeliveryCost)
    {
        super(order);
        this.fastDeliveryCost = fastDeliveryCost;
    }

    @Override
    public double calculateTotalPrice()
    {
        return super.calculateTotalPrice() + fastDeliveryCost;
    }

    @Override
    public String orderSummary()
    {
        return super.orderSummary() + String.format("Fast Delivery  %s  €%.2f  %n", "X1", fastDeliveryCost);
    }
}
