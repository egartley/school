import java.util.ArrayList;

/*  Evan Gartley
    CS 210
    3/21/2021
    Lab 8
    Inventory.java
*/

/**
 * An inventory, or stock, for a grocery store
 */
public class Inventory {

    /**
     * The store that this inventory belongs to
     */
    private GroceryStore store;
    /**
     * The items in the inventory
     */
    private ArrayList<GroceryItem> items;

    /**
     * Creates a new, empty inventory for the store
     *
     * @param store
     */
    public Inventory(GroceryStore store) {
        this(store, new ArrayList<>());
    }

    /**
     * Creates a new inventory with the given store and items
     *
     * @param store
     * @param items
     */
    public Inventory(GroceryStore store, ArrayList<GroceryItem> items) {
        this.items = items;
    }

    /**
     * Adds the item to this inventory
     *
     * @param item
     */
    public void addItem(GroceryItem item) {

    }

    /**
     * Removes the item from this inventory
     *
     * @param item
     */
    public void removeItem(GroceryItem item) {

    }

    public GroceryItem getItem(int i) {
        return null;
    }

    public ArrayList<GroceryItem> getItems() {
        return items;
    }

    public GroceryStore getStore() {
        return store;
    }

}
