/*  Evan Gartley
    CS 210
    3/14/2021
    Lab 7
    RGBColor.java
*/

/**
 * A color represented by red, green and blue values
 */
public class RGBColor extends SemiGroup<Integer[]> implements Complementable<Integer[]> {

    /**
     * The red, green and blue values
     */
    private Integer[] values;

    /**
     * Creates a new color with the given RGB values
     *
     * @param r Red value
     * @param g Green value
     * @param b Blue value
     */
    public RGBColor(int r, int g, int b) {
        if (r < 0 || r > 255 || g < 0 || g > 255 || b < 0 || b > 255) {
            throw new IllegalArgumentException("Values out of range!");
        }
        values = new Integer[]{r, g, b};
    }

    /**
     * Creates a new color with the given RGB values
     *
     * @param values The red, green and blue values
     */
    public RGBColor(Integer[] values) {
        this(values[0], values[1], values[2]);
    }

    public Integer[] getValues() {
        return values;
    }

    /**
     * Blends this color and the given color together
     *
     * @param other The color to blend
     */
    @Override
    public <AnyType> void operator(AnyType other) {
        if (!(other instanceof RGBColor)) {
            throw new IllegalArgumentException("Must specify another RGBColor!");
        }
        RGBColor otherColor = (RGBColor) other;
        Integer[] otherValues = otherColor.getValues();
        values = new Integer[]{(values[0] + otherValues[0]) / 2, (values[1] + otherValues[1]) / 2, (values[2] + otherValues[2]) / 2};
    }

    /**
     * Returns the complement of this color
     *
     * @return The complement of this color
     */
    @Override
    public Integer[] complement() {
        return new Integer[]{255 - values[0], 255 - values[1], 255 - values[2]};
    }

    /**
     * Returns whether or not this color and the other have the same RGB values
     *
     * @param o The other color
     * @return Whether or not this color and the other have the same RGB values
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof RGBColor)) {
            return false;
        }
        return values[0] == ((RGBColor) o).getValues()[0] && values[1] == ((RGBColor) o).getValues()[1] && values[2] == ((RGBColor) o).getValues()[2];
    }

    @Override
    public String toString() {
        return "[" + values[0] + ", " + values[1] + ", " + values[2] + "]";
    }

}
