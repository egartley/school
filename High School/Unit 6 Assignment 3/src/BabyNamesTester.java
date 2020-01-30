import java.util.*;
import java.io.*;

public class BabyNamesTester {
	public static void main(String[] args) throws IOException {
		for (int year = 1880; year <= 2016; year++) {
			printInformation(year);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private static void printInformation(int year) {
		System.out
				.println("----------------------------------------\nBaby names for the year of "
						+ year);
		ArrayList<BabyName> names = new ArrayList<BabyName>();
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(new File(
					System.getProperty("user.dir") + "\\src\\res\\yob" + year
							+ ".txt")));
			String line = "";
			while ((line = br.readLine()) != null) {
				String[] entries = line.split(",");
				names.add(new BabyName(entries[0], entries[1], Integer
						.valueOf(entries[2])));
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Could not output information for the year of "
					+ year + "!");
			return;
		}
		BabyInformation bi = new BabyInformation(names);
		String[][] rand = bi.randomNames(5, 5);
		System.out.println("Random names:");
		for (String[] s : rand) {
			System.out.println(Arrays.toString(s));
		}
		if (bi.whichGenderHappenedMore()) {
			System.out.println("\nThere were more males than female");
		} else {
			System.out.println("\nThere were more females than male");
		}
		System.out.println("Most common starting letter (M): "
				+ bi.mostCommonStartingLetter("M"));
		System.out.println("Most common starting letter (F): "
				+ bi.mostCommonStartingLetter("F"));
		System.out.println("Occurances of \"Paul\": " + bi.getQuantity("Paul"));
		System.out.println("Occurances of \"Katherine\": "
				+ bi.getQuantity("Katherine"));
		System.out.println("Total births (M): " + bi.totalBirthsByGender("M"));
		System.out.println("Total births (F): " + bi.totalBirthsByGender("F"));
		System.out.println("Total births (~): " + bi.totalBirths());
		System.out.println("Names with 2 letters (M): "
				+ bi.getSpecificNames(2, "M"));
		System.out.println("Names with 2 letters (F): "
				+ bi.getSpecificNames(2, "F"));
		System.out.println("Most popular name (M): " + bi.mostPopularName("M"));
		System.out.println("Most popular name (F): " + bi.mostPopularName("F"));
	}
}
