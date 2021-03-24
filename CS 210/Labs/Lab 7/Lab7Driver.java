/*  Evan Gartley
    CS 210
    3/14/2021
    Lab 7
    Lab7Driver.java
*/

/**
 * Class for testing others in lab 7
 */
public class Lab7Driver {

    public static void main(String[] args) {
        // test truth table methods
        TruthTable table = new TruthTable(new String[]{"1101", "0010", "1001", "0001"});
        TruthTable table2 = new TruthTable(new String[]{"0101", "1010", "1100", "0010"});
        System.out.println(table);
        System.out.println(table2);
        System.out.println("Complement of table2:");
        System.out.println(new TruthTable(table2.complement()));
        System.out.println("Table 1 equals 2:");
        System.out.println(table.equals(table2));
        System.out.println();
        // test positive integer methods
        PositiveInteger n1 = new PositiveInteger(2);
        PositiveInteger n2 = new PositiveInteger(7);
        System.out.println("n1: " + n1);
        System.out.println("n2: " + n2);
        n1.operator(3);
        System.out.println("Adding 3 to n1: " + n1);
        System.out.println("n1 equals n2: " + n1.equals(n2));
        System.out.println();
        // test rgb color methods
        RGBColor color1 = new RGBColor(100, 87, 11);
        RGBColor color2 = new RGBColor(97, 21, 198);
        RGBColor color3 = new RGBColor(98, 54, 104);
        System.out.println("color1: " + color1);
        System.out.println("color2: " + color2);
        System.out.println("color3: " + color3);
        System.out.println("Complement of color2:");
        System.out.println(new RGBColor(color2.complement()));
        System.out.println("Blending color1 and color2");
        color1.operator(color2);
        System.out.println(color1);
        System.out.println("blend equals color3: " + color1.equals(color3));
    }

}
