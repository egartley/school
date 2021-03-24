/*  Evan Gartley
    CS 210
    3/21/2021
    Lab 8
    OrderItem.java
*/

/**
 * The item for an order
 */
public class OrderItem {

    /**
     * How many of the item are in the order
     */
    private int number;

    /**
     * The item for the order
     */
    private GroceryItem item;

    /**
     * Creates a new order for the given item and amount
     *
     * @param number
     * @param item
     */
    public OrderItem(int number, GroceryItem item) {
        this.number = number;
        this.item = item;
    }

    public GroceryItem getItem() {
        return item;
    }

    public void setItem(GroceryItem item) {
        this.item = item;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

}
