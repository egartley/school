public class Main {
	/*
	 * Given a string, return the length of the largest "block" in the string. A
	 * block is a run of adjacent characters that are the same. For example,
	 * maxBlock("soccer") would return 2, whereas maxBlock("family") would
	 * return 1. In addition, maxBlock("") would return 0.
	 */
	public static int maxBlock(String s) {
		if (s.length() == 0)
			return 0;
		char[] cc = s.toCharArray();
		int count = 0, interm = 0;
		for (int i = 0; i < cc.length; i++) {
			char c = cc[i];
			if (i + 1 < cc.length) {
				if (c == cc[i + 1]) {
					int j = i;
					while (cc[j] == c) {
						interm++;
						j++;
						if (j == cc.length)
							break;
					}
				} else {
					interm = 1;
				}
			}
			if (interm > count)
				count = interm;
			if (interm != 0)
				interm = 0;
		}
		return count;
	}

	public static void main(String[] args) {
		
		if (maxBlock("hoopla") == 2)
			System.out.println("correct");
		else
			System.out.println("incorrect");

		if (maxBlock("abbCCCddBBBxx") == 3)
			System.out.println("correct");
		else
			System.out.println("incorrect");

		if (maxBlock("") == 0)
			System.out.println("correct");
		else
			System.out.println("incorrect");

		if (maxBlock("xyz") == 1)
			System.out.println("correct");
		else
			System.out.println("incorrect");

		if (maxBlock("xyzz") == 2)
			System.out.println("correct");
		else
			System.out.println("incorrect");

		if (maxBlock("xxyz") == 2)
			System.out.println("correct");
		else
			System.out.println("incorrect");

		if (maxBlock("abbbcbbbxbbbx") == 3)
			System.out.println("correct");
		else
			System.out.println("incorrect");

		if (maxBlock("XXBBBBbbxx") == 4)
			System.out.println("correct");
		else
			System.out.println("incorrect");

		if (maxBlock("XXBBBbbxxXXXX") == 4)
			System.out.println("correct");
		else
			System.out.println("incorrect");

		if (maxBlock("XX2222BBBbbXX2222") == 4)
			System.out.println("correct");
		else
			System.out.println("incorrect");
	}
}
