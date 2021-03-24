/*  Evan Gartley
    CS 210
    3/21/2021
    Lab 8
    Food.java
*/

/**
 * Food the can be eaten
 */
public class Food extends Edible {

    /**
     * Creates a new food
     *
     * @param inStock
     * @param retainCost
     * @param wholesaleCost
     */
    public Food(int inStock, double retainCost, double wholesaleCost) {
        super(inStock, retainCost, wholesaleCost);
    }

}
