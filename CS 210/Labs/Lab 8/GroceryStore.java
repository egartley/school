import java.util.ArrayList;
import java.util.Date;

/*  Evan Gartley
    CS 210
    3/21/2021
    Lab 8
    GroceryStore.java
*/

/**
 * A grocery store with a location, id, inventory and orders
 */
public class GroceryStore {

    /**
     * The ID of the store
     */
    private String id;
    /**
     * The store's name
     */
    private String name;
    /**
     * The store's address
     */
    private String address;

    /**
     * The store's current orders
     */
    private ArrayList<Order> orders;
    /**
     * The store's inventory
     */
    private Inventory inventory;

    /**
     * Creates a new grocery store
     *
     * @param id
     * @param name
     * @param address
     */
    public GroceryStore(String id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
        inventory = new Inventory(this);
        orders = new ArrayList<>();
    }

    /**
     * Adds an order to the store
     *
     * @param order
     */
    public void addOrder(Order order) {

    }

    /**
     * Adds the specified grocery item to the inventory
     *
     * @param item
     */
    public void addToInventory(GroceryItem item) {

    }

    /**
     * Removes the specified item from the store's inventory
     *
     * @param item
     */
    public void removeFromInventory(GroceryItem item) {

    }

    public Inventory getInventory() {
        return inventory;
    }

    public Order getOrder(Date orderDate) {
        return null;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

}
