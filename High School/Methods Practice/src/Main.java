public class Main {

	public static void main(String[] args) {
		System.out.println("isEven(5) = " + isEven(5));
		System.out.println();
		System.out.println("areaCircle(12.4) = " + areaCircle(12.4));
		System.out.println();
		System.out.println("minimum3(0.3, 0.03, 0.33) = "
				+ minimum3(0.3, 0.03, 0.33));
		System.out.println();
		System.out.println("stringTimes(\"ABC\") = " + stringTimes("ABC", 3));
		System.out.println();
		System.out.println("removeYak(\"yakpakYAK\") = "
				+ removeYak("yakpakYAK"));
		System.out.println();
		System.out.println("removeVowels(\"abcdefghijklmnopqrstuvwxyz\") = "
				+ removeVowels("abcdefghijklmnopqrstuvwxyz"));
		System.out.println();
		System.out.println("multipleOfThree(6) = " + multipleOfThree(6));
		System.out.println();
		System.out.println("isTriangle(3, 2, 5) = " + isTriangle(3, 2, 5));
		System.out.println();
		System.out
				.println("numToWord(\"I have 54 iPhones and 32 iPads and 1233 Macs\") = "
						+ numToWord("I have 54 iPhones and 32 iPads and 1233 Macs"));
		System.out.println();
		System.out.println("sdrawkcab(\"joker\") = " + sdrawkcab("joker"));
	}

	public static boolean isEven(int n) {
		return n % 2 == 0;
	}

	public static int areaCircle(double r) {
		return (int) Math.round(Math.PI * r * r);
	}

	public static double minimum3(double a, double b, double c) {
		return Math.min(Math.min(a, b), c);
	}

	public static String stringTimes(String s, int n) {
		String r = s;
		for (int i = 0; i < n; i++)
			r += s;
		return r;
	}

	public static String removeYak(String s) {
		return s.replaceAll("yak", "").replaceAll("YAK", "");
	}

	public static String removeVowels(String s) {
		return s.replaceAll("a", "").replaceAll("e", "").replaceAll("i", "")
				.replaceAll("o", "").replaceAll("u", "").replaceAll("A", "")
				.replaceAll("E", "").replaceAll("I", "").replaceAll("O", "")
				.replaceAll("U", "");
	}

	public static boolean multipleOfThree(int n) {
		return n % 3 == 0;
	}

	public static boolean isTriangle(int a, int b, int c) {
		int side1 = Math.min(Math.min(a, b), c), side2, side3;
		if (side1 == a) {
			side2 = Math.min(b, c);
			if (side2 == b) {
				side3 = c;
			} else {
				side3 = b;
			}
		} else if (side1 == b) {
			side2 = Math.min(a, c);
			if (side2 == a) {
				side3 = c;
			} else {
				side3 = a;
			}
		} else {
			side2 = Math.min(a, b);
			if (side2 == a) {
				side3 = b;
			} else {
				side3 = a;
			}
		}
		return side3 < (side1 + side2);
	}

	public static String numToWord(String s) {
		return s.replaceAll("1", "one").replace("2", "two")
				.replace("3", "three").replace("4", "four")
				.replace("5", "five").replace("6", "six").replace("7", "seven")
				.replace("8", "eight").replace("9", "nine")
				.replace("0", "zero");
	}

	public static String sdrawkcab(String s) {
		char[] a = s.toCharArray(), build = new char[s.length()];
		for (int i = a.length; i > 0; i--) {
			build[build.length - i] = a[i - 1];
		}
		return String.copyValueOf(build);
	}

}