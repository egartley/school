import java.util.AbstractList;

/*  Evan Gartley
    CS 210
    3/14/2021
    Lab 7
    Semigroup.java
*/

public abstract class SemiGroup<AnyType> {

    public abstract <AnyType> void operator(AnyType t);

    /**
     * Combines the given list of elements together into a singular result
     * 
     * @param list The list of elements to put together
     * @return The result of all elements being added
     * 
     * @see #operator(Object) 
     */
    public static <AnyType extends SemiGroup> SemiGroup combine(AbstractList<AnyType> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("List cannot be empty when combining!");
        }
        SemiGroup result = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            result.operator(list.get(i));
        }
        return result;
    }

}
