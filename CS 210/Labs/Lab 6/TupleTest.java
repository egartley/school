import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/*  Evan Gartley
    CS 210
    3/4/2021
    Lab 6
    TupleTest.java
*/

/**
 * Class for testing the methods in the Tuple class
 */
public class TupleTest {

    /**
     * Tests the methods in the Tuple class
     *
     * @param args
     */
    public static void main(String[] args) {
        // empty tuple
        Tuple t = new Tuple();
        System.out.println(t);
        // tuple with multiple types of elements
        Tuple t2 = new Tuple(new Object[]{10, 20, 30, "Forty", "Fifty", "Sixty", 70.0, 80.0, 90.0, 100.0});
        System.out.println(t2);
        // make test lists of integers
        ArrayList<Comparable> list = new ArrayList<>();
        for (int i = 1; i < 21; i++) {
            list.add(i);
        }
        ArrayList<Comparable> list2 = new ArrayList<>();
        for (int i = 20; i < 41; i++) {
            list2.add(i);
        }
        ArrayList<Comparable> list3 = new ArrayList<>();
        for (int i = 50; i < 56; i++) {
            list3.add(i);
        }
        Tuple t3 = new Tuple(list2);
        Tuple t4 = new Tuple(list3);
        System.out.println();
        // test the overridden equals method
        System.out.println(t3.equals(list));
        System.out.println(t3.equals(list2));
        // test overridden get method
        System.out.println(t3.get(2));
        // test overridden indexOf method
        System.out.println(t3.indexOf(21));
        System.out.println(t3.indexOf(54));
        // test overridden compareTo method
        System.out.println(t3.compareTo(t4));
        System.out.println();
        sortTest();
    }

    /**
     * Generates a random amount of tuples with random numbers, outputs them, sorts them, and outputs them again
     */
    private static void sortTest() {
        Random r = new Random();
        Tuple[] tuples = new Tuple[1 + r.nextInt(10)];
        for (int i = 0; i < tuples.length; i++) {
            // add new tuple with random amount of random numbers to array
            ArrayList<Comparable> list = new ArrayList<>();
            for (int n = 0; n < 1 + r.nextInt(10); n++) {
                list.add(r.nextInt(1000));
            }
            tuples[i] = new Tuple(list);
        }
        for (Tuple t : tuples) {
            System.out.println(t);
        }
        Arrays.sort(tuples);
        System.out.println();
        // show that the array of tuples was sorted
        for (Tuple t : tuples) {
            System.out.println(t);
        }
    }

}
