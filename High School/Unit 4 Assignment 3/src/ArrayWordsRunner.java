public class ArrayWordsRunner {

	public static void main(String args[]) {

		String[][] testLetters = { { "z", "w", "r" }, { "a", "a", "h" },
				{ "f", "t", "e" } };

		ArrayWords wordsTest = new ArrayWords(testLetters);
		String selectedWord = "";

		selectedWord = wordsTest.getUpDown(0, 2, 1);
		if (selectedWord.equals("wat")) {
			System.out.println("Part A correct.");
		} else {
			System.out.println("Part A incorrect.");
			System.out.println("Expected: \"wat\". Your output was \""
					+ selectedWord + "\"");
		}

		selectedWord = wordsTest.getLeftRight(1, 2, 1);
		if (selectedWord.equals("ah")) {
			System.out.println("Part B correct.");
		} else {
			System.out.println("Part B incorrect.");
			System.out.println("Expected: \"ah\". Your output was \""
					+ selectedWord + "\"");
		}
	}

}
