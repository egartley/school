import java.util.Arrays;

public class Main {
	/*
	 * We have data for two users, A and B, each with a String name and an int
	 * id. The goal is to order the users such as for sorting. Return -1 if A
	 * comes before B, 1 if A comes after B, and 0 if they are the same. Order
	 * first by the String names, and then by the id numbers if the names are
	 * the same.
	 */
	public static int userCompare(String aName, int aId, String bName, int bId) {
		String[] ab = new String[]{aName, bName};
		String[] original = ab;
		Arrays.sort(ab);
		if (!Arrays.equals(ab, original)) {
			if (ab[0].equals(aName))
				return -1;
			else
				return 1;
		} else {
			if (aName.equalsIgnoreCase(bName)) {
				if (aId < bId)
					return -1;
				else if (aId > bId)
					return 1;
				else
					return 0;
			} else {
				return -1;
			}
		}
	}

	public static void main(String[] args) {
		if (userCompare("bb", 1, "zz", 2) != -1)
			System.out.println("incorrect");
		else
			System.out.println("correct");
		
		if (userCompare("bb", 1, "aa", 2) != 1)
			System.out.println("incorrect");
		else
			System.out.println("correct");
		
		if (userCompare("bb", 1, "bb", 1) != 0)
			System.out.println("incorrect");
		else
			System.out.println("correct");
		
		if (userCompare("bb", 5, "bb", 1) != 1)
			System.out.println("incorrect");
		else
			System.out.println("correct");
		
		if (userCompare("bb", 5, "bb", 10) != -1)
			System.out.println("incorrect");
		else
			System.out.println("correct");
		
		if (userCompare("adam", 1, "bob", 2) != -1)
			System.out.println("incorrect");
		else
			System.out.println("correct");
		
		if (userCompare("bob", 1, "bob", 2) != -1)
			System.out.println("incorrect");
		else
			System.out.println("correct");
		
		if (userCompare("bzb", 1, "bob", 2) != 1)
			System.out.println("incorrect");
		else
			System.out.println("correct");
	}

}