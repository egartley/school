import java.util.Date;

/*  Evan Gartley
    CS 210
    3/21/2021
    Lab 8
    Payment.java
*/

/**
 * Payment information for a customer
 */
public class Payment {

    /**
     * Customer's card's CVV
     */
    private int cvv;
    /**
     * Customer's card's expiration date
     */
    private Date expDate;
    /**
     * The payment's number
     */
    private String number;
    /**
     * The payment type
     */
    private String paymentType;

    /**
     * The customer associated with this payment
     */
    private Customer customer;
    /**
     * The order associated with this payment
     */
    private OrderPayment order;

    /**
     * Creates a new payment for the given customer
     *
     * @param paymentType
     * @param number
     * @param expDate
     * @param cvv
     * @param customer
     */
    public Payment(String paymentType, String number, Date expDate, int cvv, Customer customer) {
        this.paymentType = paymentType;
        this.number = number;
        this.expDate = expDate;
        this.cvv = cvv;
        this.customer = customer;
    }

    public OrderPayment getOrder() {
        return order;
    }

    public void setOrder(OrderPayment order) {
        this.order = order;
    }

    public Date getExpDate() {
        return expDate;
    }

    public void setExpDate(Date expDate) {
        this.expDate = expDate;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

}
