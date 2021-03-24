import java.util.ArrayList;

/*  Evan Gartley
    CS 210
    3/14/2021
    Lab 7
    TruthTable.java
*/

/**
 * Representation of a truth table
 */
public class TruthTable implements Complementable<ArrayList> {

    private ArrayList<ArrayList<Boolean>> table;

    /**
     * Creates a new truth table based on the given 1's and 0's
     *
     * @param table An array of strings of 0's and 1's
     */
    public TruthTable(String[] table) {
        this.table = new ArrayList<>(table.length);
        for (int i = 0; i < table.length; i++) {
            String row = table[i];
            if (row.replace("1", "").replace("0", "").length() > 0) {
                throw new IllegalArgumentException("Must only contain ones and zeroes!");
            }
            this.table.add(new ArrayList<>(row.length()));
            for (int c = 0; c < row.length(); c++) {
                this.table.get(i).add(row.charAt(c) == '1');
            }
        }
    }

    /**
     * Creates a truth table with the given table
     *
     * @param table An existing truth table
     */
    public TruthTable(ArrayList<ArrayList<Boolean>> table) {
        this.table = table;
    }

    public ArrayList<ArrayList<Boolean>> getTable() {
        return table;
    }

    /**
     * Returns the complement ("opposite") of this truth table
     */
    @Override
    public ArrayList<ArrayList<Boolean>> complement() {
        ArrayList<ArrayList<Boolean>> compTable = new ArrayList<>(table.size());
        for (ArrayList<Boolean> row : table) {
            ArrayList<Boolean> add = new ArrayList<>(row.size());
            for (Boolean bit : row) {
                // copy the inverse to complement
                add.add(!bit);
            }
            compTable.add(add);
        }
        return compTable;
    }

    /**
     * Returns whether or not the given truth table has the same values as this one
     *
     * @param o
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof TruthTable)) {
            return false;
        }
        TruthTable other = (TruthTable) o;
        for (int i = 0; i < other.getTable().size(); i++) {
            ArrayList<Boolean> row = this.table.get(i);
            ArrayList<Boolean> otherRow = other.getTable().get(i);
            for (int j = 0; j < row.size(); j++) {
                if (row.get(j) != otherRow.get(j)) {
                    // at least one bit not equal, therefore not equal at all
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public String toString() {
        String out = "";
        for (ArrayList<Boolean> row : table) {
            for (Boolean bit : row) {
                // 1 is true, 0 is false
                out += bit ? "1" : "0";
            }
            out += "\n";
        }
        return out;
    }

}
