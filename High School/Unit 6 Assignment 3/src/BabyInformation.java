import java.util.*;

public class BabyInformation {

	ArrayList<BabyName> names = new ArrayList<BabyName>();

	public BabyInformation(ArrayList<BabyName> n) {
		names = n;
	}

	public int totalBirths() {
		return names.size();
	}

	public String mostPopularName(String gender) {
		BabyName mostPopular = names.get(0);
		int max = 0;
		for (BabyName n : names) {
			if (n.getGender().equals(gender)) {
				if (n.getQuantity() > max) {
					mostPopular = n;
					max = mostPopular.getQuantity();
				}
			}
		}
		return mostPopular.getName();
	}

	public int totalBirthsByGender(String gender) {
		int c = 0;
		for (BabyName name : names) {
			if (name.getGender().equals(gender))
				c++;
		}
		return c;
	}

	public String getSpecificNames(int num, String gender) {
		String r = "";
		for (BabyName n : names)
			if (n.getGender().equals(gender))
				if (n.getName().length() == num)
					r += n.getName() + ", ";
		if (r.equals(""))
			return "None";
		return r.substring(0, r.length() - 2);
	}

	public int getQuantity(String name) {
		for (BabyName n : names)
			if (n.getName().equals(name))
				return n.getQuantity();
		return 0;
	}

	// returns the letter of the most common name, based on gender
	public String mostCommonStartingLetter(String gender) {
		String mcsl = "";
		for (BabyName n : names) {
			if (n.getGender().equals(gender)) {
				mcsl = n.getName().substring(0, 1);
				break;
			}
		}
		return mcsl;
	}

	// returns true if there were more male births than female births
	// returns false if they are equal
	public boolean whichGenderHappenedMore() {
		if (totalBirthsByGender("M") > totalBirthsByGender("F"))
			return true;
		return false;
	}

	// returns a 2D array of random male and female names
	// the dimensions of the array will be controlled by row and col
	public String[][] randomNames(int row, int col) {
		String[][] r = new String[row][col];
		for (int rr = 0; rr < row; rr++) {
			for (int c = 0; c < col; c++) {
				r[rr][c] = names.get((int) (Math.random() * names.size()))
						.getName();
			}
		}
		return r;
	}
}
