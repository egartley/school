import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(wordSort(new String[]{"ojhdoiqwhdioqwhdw", "sdsasahfdiwr", "dada", "ojdoiahdfioahd", "abbada"})));
	}

	public static int median(int[] n) {
		if (n.length % 2 == 0) {
			// 1, 2, 3, 4
			return (n[n.length / 2] + n[n.length / 2 + 1]) / 2;
		} else {
			// 1, 2, 3, 4, 5
			return n[n.length / 2 + 1];
		}
	}

	public static double sampleStdev(int[] n) {
		double mean = n[0], sum;
		for (int i : n)
			mean += n[i];
		mean /= n.length;
		sum = Math.pow(n[0] - mean, 2);

		for (int i = 1; i < n.length; i++)
			sum += Math.pow(n[i] - mean, 2);

		return Math.sqrt(sum / (n.length - 1));
	}

	public static double percentEven(int[] n) {
		int evens = 0;
		for (int i : n)
			if (i % 2 == 0)
				evens++;
		return evens / n.length;
	}

	public static int priceIsRight(int[] bids, int correctPrice) {
		int closest = 0, i = 0;
		int[] ranges = new int[bids.length];
		boolean allOver = true;
		for (int bid : bids)
			ranges[i] = correctPrice - bid;
		for (int range : ranges)
			if (range >= 0)
				allOver = false;
		if (allOver)
			return -1;
		Arrays.sort(ranges);
		for (int bid : bids)
			if (correctPrice - bid < ranges[0])
				closest = bid;
		return closest;
	}
	
	public static int mode(int[] n) {
		if (n.length == 1)
			return n[0];
		int[] amounts = new int[n.length];
		for (int i = 0; i < n.length; i++)
			amounts[i] = n[i];
		Arrays.sort(amounts);
		return amounts[amounts.length - 1];
	}
	
	public static String[] wordSort(String[] s) {
		int[] lengths = new int[s.length];
		for (int i = 0; i < s.length; i++) {
			lengths[i] = s[i].length();
		}
		String[] sorted = new String[s.length];
		Arrays.sort(lengths);
		for (int i : lengths) {
			for (int j = 0; j < s.length; j++) {
				if (i == s[j].length()) {
					sorted[j] = s[j];
				}
			}
		}
		return sorted;
	}

}