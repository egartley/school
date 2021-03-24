/*  Evan Gartley
    CS 210
    3/14/2021
    Lab 7
    PositiveInteger.java
*/

/**
 * A positive integer
 */
public class PositiveInteger extends SemiGroup<Integer> {

    private int n;

    /**
     * Creates a new positive integer
     *
     * @param n The value for the integer
     */
    public PositiveInteger(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("PositiveInteger cannot be less than 0!");
        }
        this.n = n;
    }

    public int getN() {
        return n;
    }

    /**
     * Adds the given integer to this one
     * @param i The integer to add
     */
    @Override
    public <Integer> void operator(Integer i) {
        n += (int) i;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Integer)) {
            return false;
        }
        return (int) o == n;
    }

    @Override
    public String toString() {
        return String.valueOf(n);
    }

}
