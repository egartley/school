import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		System.out.println("1. rowSum(new int[][] {{2, 2}, {4, 9}}, 1) = "
				+ rowSum(new int[][] { { 2, 2 }, { 4, 9 } }, 1));
		System.out.println("\n2. oddColumn(new int[][] {{5, 0}, {7, 3}}, 1) = "
				+ oddColumn(new int[][] { { 5, 0 }, { 7, 3 } }, 1));
		System.out
				.println("\n3. elementsOf(new double[][] {{4, 5, 1}, {9, 13, 0}, {3, 1, 1}}) = "
						+ elementsOf(new double[][] { { 4, 5, 1 },
								{ 9, 13, 0 }, { 3, 1, 1 } }));
		System.out
				.println("\n4. isSquare(new String[][] {{\"\", \"\"}, {\"\"}}) = "
						+ isSquare(new String[][] { { "", "" }, { "" } }));
		System.out.println("\n5. setRandom(new int[][] {{5, 0}, {7, 3}}) = "
				+ arrayString(setRandom(new int[][] { { 5, 0 }, { 7, 3 } })));
		System.out
				.println("\n6. setThirdFrogurt(new String[][] {{\"a\", \"a\", \"a\"}, {\"b\", \"b\", \"b\"}, {\"c\", \"c\", \"c\"}}) = "
						+ arrayString(setThirdFrogurt(new String[][] {
								{ "a", "a", "a" }, { "b", "b", "b" },
								{ "c", "c", "c" } })));
		System.out
				.println("\n7. everyOther(new String[][] {{\"a\", \"a\", \"a\"}, {\"b\", \"b\", \"b\"}, {\"c\", \"c\", \"c\"}}) = "
						+ arrayString(everyOther(
								new String[][] { { "a", "a", "a", "a" },
										{ "b", "b", "b", "b" },
										{ "c", "c", "c", "c" },
										{ "d", "d", "d", "d" } }, "x")));
		System.out
				.println("\n8. isValidIndex(new int[][] {{2, 2}, {4, 9}}, 2, 1) = "
						+ isValidIndex(new int[][] { { 2, 2 }, { 4, 9 } }, 2, 1));
		System.out
				.println("\n9. fourCorners(new String[][] {{\"2\", \"2\"}, {\"3\", \"3\"}, {\"4\", \"4\"}, {\"5\", \"5\"}}) = ");
		fourCorners(new String[][] { { "2", "2", "2", "2" },
				{ "3", "3", "3", "3" }, { "4", "4", "4", "4" },
				{ "5", "5", "5", "5" } });
		System.out
				.println("\n10. printMiddleRow(new int[][] {{2, 2}, {3, 3}, {4, 4}, {5, 5}, {6, 6}}) = ");
		printMiddleRow(new int[][] { { 2, 2 }, { 3, 3 }, { 4, 4 }, { 5, 5 }, { 6, 6 } });
		System.out
				.println("\n\n11. allBanana(new String[][] {{\"2\", \"2\"}, {\"banana\", \"3\"}, {\"4\", \"4\"}, {\"5\", \"5\"}}) = "
						+ allBanana(new String[][] { { "2", "2", "2", "2" },
								{ "banana", "3", "3", "3" },
								{ "4", "4", "4", "4" }, { "5", "5", "5", "5" } }));
		System.out
				.println("\n12. diagonalSum(new int[][] { { 2, 2 }, { 3, 3 } }) = "
						+ diagonalSum(new int[][] { { 2, 2 }, { 3, 3 }}));
	}

	public static String arrayString(int[][] array) {
		String r = "{";
		for (int i = 0; i < array.length; i++) {
			r += "{";
			for (int k = 0; k < array[i].length; k++) {
				r += String.valueOf(array[i][k]);
				if (k + 1 != array[i].length)
					r += ", ";
			}
			r += "}";
			if (i + 1 != array.length)
				r += ", ";
		}
		return r + "}";
	}

	public static String arrayString(Object[][] array) {
		String r = "{";
		for (int i = 0; i < array.length; i++) {
			r += "{";
			for (int k = 0; k < array[i].length; k++) {
				r += String.valueOf(array[i][k]);
				if (k + 1 != array[i].length)
					r += ", ";
			}
			r += "}";
			if (i + 1 != array.length)
				r += ", ";
		}
		return r + "}";
	}

	public static int rowSum(int[][] n, int ri) {
		int sum = n[ri][0];
		for (int i = 1; i < n[ri].length; i++) {
			sum += n[ri][i];
		}
		return sum;
	}

	public static int oddColumn(int[][] n, int ci) {
		int odds = 0;
		for (int i = 0; i < n.length; i++)
			if (n[i][ci] % 2 != 0 && n[i][ci] != 0)
				odds++;
		return odds;
	}

	public static int elementsOf(double[][] d) {
		return d.length * d[0].length;
	}

	public static boolean isSquare(String[][] s) {
		for (int i = 0; i < s.length; i++)
			if (s.length != s[i].length)
				return false;
		return true;
	}

	public static int[][] setRandom(int[][] n) {
		for (int i = 0; i < n.length; i++)
			for (int j = 0; j < n[i].length; j++)
				n[i][j] = (int) (Math.random() * 10 + 1);
		return n;
	}

	public static String[][] setThirdFrogurt(String[][] s) {
		for (int r = 0; r < s.length; r++)
			s[r][2] = "frogurt";
		return s;
	}

	public static String[][] everyOther(String[][] s, String val) {
		for (int i = 0; i < s.length; i++)
			for (int k = 0; k < s[i].length; k += 2)
				s[i][k] = val;
		return s;
	}

	public static boolean isValidIndex(int[][] n, int r, int c) {
		return n.length > r && n[0].length > c;
	}

	public static void fourCorners(String[][] s) {
		System.out.println(Arrays.toString(new String[] { s[0][0],
				s[s.length - 1][0], s[0][s.length - 1],
				s[s.length - 1][s.length - 1] }));
	}

	public static void printMiddleRow(int[][] n) {
		for (int i = 0; i < n[n.length / 2].length; i++)
			System.out.print(n[n.length / 2][i] + " ");
	}

	public static boolean allBanana(String[][] s) {
		for (String[] ss : s)
			for (String sss : ss)
				if (!sss.equals("banana"))
					return false;
		return true;
	}

	public static int diagonalSum(int[][] n) {
		int sum = n[n.length - 1][0];
		for (int i = n.length - 2; i >= 0; i--) {
			for (int j = 1; j < n[i].length; j++) {
				sum += n[i][j];
			}
		}
		return sum;
	}

}
