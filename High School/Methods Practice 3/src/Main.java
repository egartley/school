public class Main {

	public static void main(String[] args) {
		System.out.println("lsToOnes(\"Hello\") = " + lsToOnes("Hello"));
		System.out.println();
		System.out.println("oneIsTheLoneliestNumber(11347129) = "
				+ oneIsTheLoneliestNumber(11347129));
		System.out.println();
		System.out.println("tripleA(\"aaabbcccc\") = " + tripleA("aaabbcccc"));
		System.out.println();
		System.out.print("increasingNums(10, 3, 13) = ");
		increasingNums(10, 3, 13);
		System.out.println("\n");
		System.out.print("ordinalNum(31) = ");
		ordinalNum(31);
		System.out.println("\n");
		System.out.println("daysToSeconds(4) = " + daysToSeconds(4));
		System.out.println();
		System.out.println("tugOfWar(92) = " + tugOfWar(92));
		System.out.println();
		System.out.println("stringAddition(\"2+44\") = "
				+ stringAddition("2+44"));
		System.out.println();
		System.out.println("stringAdditionTake2(\"100++1\") = "
				+ stringAdditionTake2("100++1"));
		System.out.println();
		System.out.println("ghostHunters(\"Hellobob\") = "
				+ ghostHunters("Hellobob"));
	}

	public static String lsToOnes(String s) {
		return s.replaceAll("l", "1");
	}

	public static int oneIsTheLoneliestNumber(int n) {
		return Integer.parseInt(String.valueOf(n).replaceAll("1", "2"));
	}

	public static boolean tripleA(String s) {
		return s.contains("aaa");
	}

	public static void increasingNums(int x, int y, int z) {
		int max = Math.max(Math.max(x, y), z);
		int min, mid;
		if (max == x) {
			min = Math.min(y, z);
			if (min == y)
				mid = z;
			else
				mid = y;
		} else if (max == y) {
			min = Math.min(x, z);
			if (min == x)
				mid = z;
			else
				mid = x;
		} else {
			min = Math.min(x, y);
			if (min == x)
				mid = y;
			else
				mid = x;
		}
		System.out.print(min + ", " + mid + ", " + max);
	}

	public static void ordinalNum(int n) {
		String s = String.valueOf(n);
		if (s.endsWith("1") && !s.equals("11")) {
			System.out.print(n + "st");
		} else if (s.endsWith("2") && !s.equals("12")) {
			System.out.print(n + "nd");
		} else if (s.endsWith("3") && !s.equals("13")) {
			System.out.print(n + "rd");
		} else {
			System.out.print(n + "th");
		}
	}

	public static int daysToSeconds(int n) {
		return n * 86400;
	}

	public static int tugOfWar(int n) {
		if (n / 10 == 0)
			return 0;
		String firstHalf = String.valueOf(n).substring(0,
				String.valueOf(n).length() / 2);
		String secondHalf = String.valueOf(n).substring(
				String.valueOf(n).length() / 2 + 1);
		int sum1 = 0, sum2 = 0;
		if (String.valueOf(n).length() % 2 != 0) {
			n = Integer.parseInt(firstHalf + secondHalf);
		}
		for (int i = 0; i < firstHalf.length(); i++)
			sum1 += firstHalf.toCharArray()[i];
		for (int i = 0; i < secondHalf.length(); i++)
			sum2 += secondHalf.toCharArray()[i];
		if (sum1 == sum2)
			return 0;
		else if (sum1 > sum2)
			return -1;
		else
			return 1;
	}

	public static String stringAddition(String expression) {
		if (!expression.contains("+"))
			return "NOT POSSIBLE";
		return String
				.valueOf(Integer.parseInt(expression.substring(0,
						expression.indexOf("+")))
						+ Integer.parseInt(expression.substring(expression
								.indexOf("+") + 1)));
	}

	public static String stringAdditionTake2(String expression) {
		if (!expression.contains("+"))
			return "NOT POSSIBLE";
		String pluses = expression.substring(expression.indexOf("+"),
				expression.lastIndexOf("+") + 1);
		int lastAdd = Integer.parseInt(expression.substring(0,
				expression.indexOf("+")));
		int multipler = Integer.parseInt(expression.substring(expression
				.lastIndexOf("+") + 1));
		int e = 0;
		while (pluses.contains("+")) {
			e++;
			if (pluses.length() != 1)
				pluses = pluses.substring(1);
			else
				break;
		}
		return String.valueOf(lastAdd + (e * multipler));
	}

	public static boolean ghostHunters(String hunt) {
		if (hunt.toLowerCase().contains("boo")) {
			if (hunt.toLowerCase().indexOf("boo") < hunt.length() - 3) {
				return !hunt
						.toLowerCase()
						.substring(hunt.toLowerCase().indexOf("boo") + 3,
								hunt.toLowerCase().indexOf("boo") + 4)
						.equalsIgnoreCase("o");
			} else {
				return true;
			}
		} else {
			return false;
		}
	}
}