import java.util.Date;

/*  Evan Gartley
    CS 210
    3/21/2021
    Lab 8
    OrderPayment.java
*/

/**
 * Payment for an order
 */
public class OrderPayment {

    /**
     * The date of the payment
     */
    private Date paymentDate;
    /**
     * The amount of the payment
     */
    private double amount;

    /**
     * The order associated with this payment
     */
    private Order order;
    /**
     * The payment information
     */
    private Payment payment;

    /**
     * Creates a new order payment
     *
     * @param amount
     * @param date
     * @param payment
     */
    public OrderPayment(double amount, Date date, Payment payment) {
        this.amount = amount;
        paymentDate = date;
        this.payment = payment;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

}
