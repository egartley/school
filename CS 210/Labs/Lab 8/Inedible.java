/*  Evan Gartley
    CS 210
    3/21/2021
    Lab 8
    Inedible.java
*/

/**
 * Something that cannot be eaten
 */
public class Inedible extends GroceryItem {

    /**
     * Creates a new inedible item
     *
     * @param inStock
     * @param retainCost
     * @param wholesaleCost
     */
    public Inedible(int inStock, double retainCost, double wholesaleCost) {
        super(inStock, retainCost, wholesaleCost);
    }

}
