public class Main {

	public static String[] countries = new String[] { "United States ",
			"China        ", "Saudi Arabia   ", "Russia      ",
			"United Kingdom", "India      ", "France     ", "Japan      ",
			"Germany      ", "South Korea" };
	public static String[] titles = new String[] { "Budget (billion USD)",
			"Main battle tanks", "Aircraft Carriers", "Warfare Ships	",
			"Cruisers	", "Destroyers	", "Frigates	", "Corvettes	",
			"Nuclear submarines", "Non-nuclear submarines" };

	public static double[][] stats = new double[][] {
			{ 615.5, 8850, 10, 33, 22, 62, 6, 0, 72, 0 },
			{ 216.4, 9151, 1, 4, 0, 29, 49, 34, 14, 60 },
			{ 80.8, 600, 0, 0, 0, 3, 4, 4, 0, 0 },
			{ 70, 15398, 1, 0, 6, 18, 13, 48, 45, 22 },
			{ 61.8, 227, 1, 6, 0, 6, 13, 0, 11, 0 },
			{ 53.2, 6464, 2, 1, 0, 11, 14, 26, 2, 14 },
			{ 53.1, 200, 1, 4, 0, 11, 11, 0, 10, 0 },
			{ 47.7, 688, 0, 3, 0, 34, 9, 0, 0, 18 },
			{ 43.9, 410, 0, 0, 0, 0, 11, 5, 0, 5 },
			{ 34.4, 2514, 0, 1, 0, 12, 14, 36, 0, 23 } };

	public static void main(String[] args) {
		print();
		System.out.println("\n");
		printAverages();
		System.out.println();
		printMaxes();
		System.out.println();
		printMost();

	}

	public static double averageStatistic(int i) {
		return (stats[0][i] + stats[1][i] + stats[2][i] + stats[3][i]
				+ stats[4][i] + stats[5][i] + stats[6][i] + stats[7][i]
				+ stats[8][i] + stats[9][i]) / 10;
	}

	public static void printAverages() {
		for (int i = 0; i < 10; i++) {
			if (i >= 3 && i <= 7)
				System.out.println("Average " + titles[i].trim() + ":		"
						+ averageStatistic(i));
			else
				System.out.println("Average " + titles[i].trim() + ":	"
						+ averageStatistic(i));
		}
	}

	public static void print() {
		System.out.print("		  ");
		for (String title : titles) {
			System.out.print(title + "	  ");
		}
		System.out.println();
		for (int i = 0; i < countries.length; i++) {
			System.out.println();
			for (int k = 0; k < 260; k++) {
				System.out.print("-");
			}
			System.out.println();
			System.out.print(countries[i] + "		");
			for (int j = 0; j < stats[i].length; j++) {
				if (j != 0)
					System.out.print((int) stats[i][j] + "			");
				else
					System.out.print(stats[i][j] + "			");
			}
		}
	}

	public static double getMaxStat(int i) {
		double max = 0;
		for (double[] d : stats)
			max = Math.max(max, d[i]);
		return max;
	}

	public static void printMaxes() {
		for (int i = 0; i < titles.length; i++) {
			if (i == 1 || i == 2 || i == 3 || i == 5) {
				System.out.println("Most " + titles[i].trim() + ":		"
						+ (int) getMaxStat(i));
			} else if (i == 4) {
				System.out.println("Most " + titles[i].trim() + ":			"
						+ (int) getMaxStat(i));
			} else if (i == 6 || i == 7) {
				System.out.println("Most " + titles[i].trim() + ":			"
						+ (int) getMaxStat(i));
			} else {
				if (i != 0)
					System.out.println("Most " + titles[i].trim() + ":	"
							+ (int) getMaxStat(i));
				else
					System.out.println("Most " + titles[i].trim() + ":	"
							+ getMaxStat(i));
			}

		}
	}

	public static int getMost(int statColumn) {
		int most = 0;
		double prev = 0;
		for (int row = 0; row < stats.length; row++) {
			most = (int) Math.max(prev, stats[row][statColumn]);
			prev = stats[row][statColumn];
		}
		return most;
	}

	public static void printMost() {
		for (int i = 0; i < titles.length; i++) {
			String c = countries[getMost(i)].trim();
			if (i == 2 || i == 4 || i == 8) {
				System.out.println(c + "		has the most " + titles[i]);
			} else {
				if (i != 0)
					System.out.println(c + "	has the most " + titles[i]);
				else
					System.out.println(c + "	has the highest " + titles[i]);
			}
		}
	}

}
