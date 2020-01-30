import java.util.Arrays;

public class SelectionSortWithNoHelp {
	public static void main(String[] args) {
		int[] array1 = generateArrayOfLength(10);
		int[] array2 = generateArrayOfLength(100);

		System.out.print("First array: ");
		System.out.println(Arrays.toString(array1));
		System.out.print("Second array: ");
		System.out.println(Arrays.toString(array2));
		System.out.println();

		// sort first array
		selectionSort(array1);
		// sort second array
		selectionSort(array2);

		System.out.print("First array sorted: ");
		System.out.println(Arrays.toString(array1));
		System.out.print("Second array sorted: ");
		System.out.println(Arrays.toString(array2));
	}

	public static int[] generateArrayOfLength(int length) {
		int[] arr = new int[length];
		for (int i = 0; i < length; i++) {
			arr[i] = (int) (Math.random() * 100);
		}
		return arr;
	}

	/*
	 * Selection sort takes in an array of integers and returns a sorted array
	 * of the same integers.
	 */
	public static int[] selectionSort(int[] arr) {
		int comps = 0;

		for (int i = 0; i < arr.length; i++) {
			int base = arr[i];
			for (int k = i; k < arr.length; k++) {
				comps++;
				if (arr[k] < base) {
					arr[i] = arr[k];
					arr[k] = base;
				}
			}
		}

		System.out.println(comps);
		return arr;
	}
}