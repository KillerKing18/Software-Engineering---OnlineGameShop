package businesslogic;

public class OrderDonation extends OrderDecorator
{

    private double donationAmount;

    public OrderDonation(Order order, double donationAmount)
    {
        super(order);
        this.donationAmount = donationAmount;
    }

    @Override
    public double calculateTotalPrice()
    {
        return super.calculateTotalPrice() + donationAmount;
    }

    @Override
    public String orderSummary()
    {
        return super.orderSummary() + String.format("Donation  %s  €%.2f  %n", "X1", donationAmount);
    }
}
