/*  Evan Gartley
    CS 210
    3/21/2021
    Lab 8
    GroceryItem.java
*/

/**
 * An item that can be found in a grocery store
 */
public class GroceryItem {

    /**
     * How many of this item are in stock
     */
    private int inStock;
    /**
     * How much it costs to retain this item
     */
    private double retainCost;
    /**
     * The wholesale cost
     */
    private double wholesaleCost;

    /**
     * Creates a new grocery item
     *
     * @param inStock
     * @param retainCost
     * @param wholesaleCost
     */
    public GroceryItem(int inStock, double retainCost, double wholesaleCost) {
        this.inStock = inStock;
        this.retainCost = retainCost;
        this.wholesaleCost = wholesaleCost;
    }

}
