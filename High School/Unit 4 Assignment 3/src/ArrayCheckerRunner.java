public class ArrayCheckerRunner {
	public static void main(String[] args) {
		int[][] testNums = { { 5, 24, 55, 12 }, { 100, 12, 26, 81 },
				{ 9, 43, 12, 3 }, { 39, 63, 9, 10 } };

		ArrayChecker testChecker = new ArrayChecker(testNums);

		int nineInstances = testChecker.arrayInstance(9);
		int threeDivisor = testChecker.arrayDivisor(3);

		System.out.println("If this compiled, Part A and B are correct!");

		if (nineInstances == 2) {
			System.out.println("Part C is correct!");
		} else {
			System.out.println("Part C is incorrect.");
			System.out.println("Expected 2. Your output was " + nineInstances);
		}

		if (threeDivisor == 10) {
			System.out.println("Part D is correct!");
		} else {
			System.out.println("Part D is incorrect.");
			System.out.println("Expected 10. Your output was " + threeDivisor);
		}
	}
}
