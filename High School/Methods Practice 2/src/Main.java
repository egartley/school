public class Main {

	public static void main(String[] args) {

	}

	public static String firstTwo(String s) {
		if (s.length() >= 3) {
			return s.substring(0, 2);
		} else {
			return s;
		}
	}

	public static String helloName(String s) {
		return "Hello " + s + "!";
	}

	public static String firstHalf(String s) {
		if (s.length() % 2 == 0) {
			return s.substring(0, s.length() / 2);
		} else {
			return s + s;
		}
	}

	public static String front22(String s) {
		return firstTwo(s) + firstTwo(s);
	}

	public static boolean given2Ints(int x, int y) {
		return String.valueOf(x).endsWith(
				String.valueOf(y).substring(String.valueOf(y).length() - 1));
	}

	public static boolean mixStart(String s) {
		return s.substring(1, 3).equalsIgnoreCase("ix");
	}

	public static String stringBits(String s) {
		String r = "";
		char[] c = s.toCharArray();
		for (int i = 0; i < c.length; i += 2) {
			r += c[i];
		}
		return r;
	}

	public static String getSandwich(String s) {
		String temp = s;
		int first = temp.toLowerCase().indexOf("bread"), second = -1;
		if (first != -1) {
			temp = temp.substring(first + "bread".length());
			second = temp.toLowerCase().indexOf("bread");
			if (second != -1) {
				return temp.substring(0, second);
			} else {
				return "";
			}
		} else {
			return "";
		}
	}

	public static int codeTimes(String s) {
		String temp = s;
		int count = 0;
		if (temp.contains("co")
				&& temp.substring(temp.indexOf("co") + 1,
						temp.indexOf("co") + 3).equalsIgnoreCase("e")) {
			while (temp.contains("co")
					&& temp.substring(temp.indexOf("co") + 1,
							temp.indexOf("co") + 3).equalsIgnoreCase("e")) {
				count++;
				temp = temp.substring(temp.indexOf("co") + 3);
			}
		} else {
			return 0;
		}
		return count;
	}

	public static String lastThreeUpper(String s) {
		if (s.length() <= 3)
			return s.toUpperCase();
		else
			return s.substring(0, s.length() - 3)
					+ s.substring(s.length() - 3).toUpperCase();
	}

}