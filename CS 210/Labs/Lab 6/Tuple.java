import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/*  Evan Gartley
    CS 210
    3/4/2021
    Lab 6
    Tuple.java
*/

/**
 * Re-creation of the tuple object type from Python
 */
public class Tuple extends ArrayList<Object> implements Comparable<Tuple> {

    /**
     * Internal representation of the tuple's data
     */
    private Object[] data = new Object[10];

    /**
     * Creates a new, empty tuple
     */
    public Tuple() {
        super();
    }

    /**
     * Creates a new tuple with the specified items
     *
     * @param items The items to include in the tuple
     */
    public Tuple(Object[] items) {
        super();
        if (items == null) {
            throw new NullPointerException("Cannot pass in null array for new tuple");
        }
        // copy the first 10 elements of items into data
        data = Arrays.copyOf(items, data.length);
    }

    /**
     * Creates a new tuple with the items from the specified collection
     *
     * @param items A collection of the items to include
     */
    public Tuple(Collection<Comparable> items) {
        super();
        if (items == null) {
            throw new NullPointerException("Cannot pass in null collection for new tuple");
        }
        // copy the first 10 elements of items into data
        data = Arrays.copyOf(items.toArray(data), data.length);
    }

    /**
     * Returns whether or not the specified object is equal to this tuple, specifically their contents
     *
     * @param o The other object to check for equivalence
     * @return Whether or not the object is equal to the tuple
     */
    @Override
    public boolean equals(Object o) {
        boolean contentsEqual = true;
        if (!(o instanceof List)) {
            try {
                throw new Exception("Other object must be a list");
            } catch (Exception e) {
                return false;
            }
        } else {
            List<Object> other = (List<Object>) o;
            for (int i = 0; i < data.length; i++) {
                contentsEqual = other.get(i).equals(data[i]);
                if (!contentsEqual) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Returns the index of the first instance of the specified object in the tuple, or -1 if it doesn't exist
     *
     * @param o The object to look for
     * @return Index of the first instance of the specified object in the tuple, or -1 if it doesn't exist
     */
    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < data.length; i++) {
            if (o.equals(data[i])) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Returns the object at the specified index
     *
     * @param index The index of the object to get
     * @return The object at the specified index
     */
    @Override
    public Object get(int index) {
        return data[index];
    }

    /**
     * Returns a string representation of the tuple
     *
     * @return String represetnation of the tuple
     */
    @Override
    public String toString() {
        return Arrays.toString(data).replace("[", "(").replace("]", ")");
    }

    /**
     * Compares the contents of this tuple and the specified tuple
     *
     * @param o The other tuple to compare contents to
     * @return Comparison of the tuples' contents or 0 if equal
     */
    @Override
    public int compareTo(Tuple o) {
        for (int i = 0; i < data.length; i++) {
            try {
                if (!(data[i] instanceof Comparable) || !(o.get(i) instanceof Comparable)) {
                    throw new Exception("Tuple element is not an instance of Comparable!");
                }
                Comparable c1 = (Comparable) data[i];
                Comparable c2 = (Comparable) o.get(i);
                int result = c1.compareTo(c2);
                if (result != 0) {
                    return result;
                }
            } catch (IndexOutOfBoundsException e) {
                // data.length is more than o's if we get here
                return data.length - i;
            } catch (Exception e) {
                e.printStackTrace();
                return -1;
            }
        }
        return 0;
    }

}
