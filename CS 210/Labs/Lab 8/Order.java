import java.util.Date;

/*  Evan Gartley
    CS 210
    3/21/2021
    Lab 8
    Order.java
*/

/**
 * An order for an item by a customer at a store
 */
public class Order {

    /**
     * The charge for this order
     */
    private double charge;
    /**
     * This order's date
     */
    private Date orderDate;

    /**
     * The item associated with this order
     */
    private OrderItem item;
    /**
     * The customer this order is for
     */
    private Customer customer;
    /**
     * Delivery information for this order
     */
    private DeliveryInfo info;
    /**
     * The store this order is for
     */
    private GroceryStore store;
    /**
     * The payment for this order
     */
    private OrderPayment payment;

    /**
     * Creates a new order
     *
     * @param charge
     * @param orderDate
     * @param info
     * @param payment
     * @param item
     */
    public Order(double charge, Date orderDate, DeliveryInfo info, OrderPayment payment, OrderItem item) {
        this.charge = charge;
        this.orderDate = orderDate;
        this.info = info;
        this.payment = payment;
        this.item = item;
    }

    public void setGroceryStore(GroceryStore store) {
        this.store = store;
    }

    public GroceryStore getStore() {
        return store;
    }

    public double getCharge() {
        return charge;
    }

    public void setCharge(double charge) {
        this.charge = charge;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

}
