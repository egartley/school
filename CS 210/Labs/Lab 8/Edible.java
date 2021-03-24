/*  Evan Gartley
    CS 210
    3/21/2021
    Lab 8
    Edible.java
*/

/**
 * Something that can be eaten
 */
public class Edible extends GroceryItem {

    /**
     * How many calories are in one serving
     */
    private int caloriesPerServing;

    /**
     * Creates a new edible item
     *
     * @param inStock
     * @param retainCost
     * @param wholesaleCost
     */
    public Edible(int inStock, double retainCost, double wholesaleCost) {
        super(inStock, retainCost, wholesaleCost);
    }

}
