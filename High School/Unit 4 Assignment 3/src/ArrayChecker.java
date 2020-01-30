public class ArrayChecker {

	public int[][] numbers;

	public ArrayChecker(int[][] numbers) {
		this.numbers = numbers;
	}

	public int arrayInstance(int n) {
		int r = 0;
		for (int[] i : numbers) {
			for (int k : i) {
				if (k == n)
					r++;
			}
		}
		return r;
	}

	public int arrayDivisor(int n) {
		int r = 0;
		for (int[] i : numbers) {
			for (int k : i) {
				if (k % n == 0)
					r++;
			}
		}
		return r;
	}

}
