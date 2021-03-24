import java.util.ArrayList;
import java.util.Date;

/*  Evan Gartley
    CS 210
    3/21/2021
    Lab 8
    Customer.java
*/

/**
 * A customer with a name, id and join date
 */
public class Customer {

    /**
     * The customer's ID
     */
    private String custId;
    /**
     * The customer's name
     */
    private String name;
    /**
     * When the customer joined
     */
    private Date joinDate;

    /**
     * The customer's order
     */
    private Order order;
    /**
     * A collection of the customer's payments
     */
    private ArrayList<Payment> payments;

    /**
     * Creates a new customer with the specified id, name and join date
     *
     * @param custId
     * @param name
     * @param joinDate
     */
    public Customer(String custId, String name, Date joinDate) {
        this.custId = custId;
        this.name = name;
        this.joinDate = joinDate;
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public ArrayList<Payment> getPayments() {
        return payments;
    }

    public void addPayment(Payment payment) {
        payments.add(payment);
    }

}
