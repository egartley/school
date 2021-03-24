/*  Evan Gartley
    CS 210
    3/21/2021
    Lab 8
    Beverage.java
*/

/**
 * Something that can be drank, with or without alcohol
 */
public class Beverage extends Edible {

    /**
     * Whether or not this beverage contains alcohol
     */
    private boolean alcohol;

    /**
     * Creates a new beverage while setting {@link #alcohol} to false
     *
     * @param inStock
     * @param retainCost
     * @param wholesaleCost
     */
    public Beverage(int inStock, double retainCost, double wholesaleCost) {
        this(inStock, retainCost, wholesaleCost, false);
    }

    /**
     * Creates a new beverage while specifying its alcohol contents
     *
     * @param inStock
     * @param retainCost
     * @param wholesaleCost
     * @param hasAlcohol
     */
    public Beverage(int inStock, double retainCost, double wholesaleCost, boolean hasAlcohol) {
        super(inStock, retainCost, wholesaleCost);
        alcohol = hasAlcohol;
    }

}
