import java.util.*;

public class CompareSearch {
	public static void main(String[] args) {
		System.out.println("Table of comparison counts");
		System.out.println("Length\t\tBinary Search\tLinear Search");
		testArrayOfLength(10);
		testArrayOfLength(20);
		testArrayOfLength(100);
		testArrayOfLength(1000);
		testArrayOfLength(10000);
	}

	// This problem generates an array of length length. Then we select a random
	// index of that array and get the element. Then we print out
	// how many comparisons it takes on binary search and linear search.
	// You'll need to update the methods binarySearch and linearSearch
	public static void testArrayOfLength(int length) {
		int[] arr = generateArrayOfLength(length);
		// System.out.println(Arrays.toString(arr));
		int index = (int) (length * Math.random());
		int elem = arr[index];
		System.out.println(length + "\t\t" + binarySearch(arr, elem) + "\t\t"
				+ linearSearch(arr, elem));
	}

	// This method returns a random array of integers of length, len
	// The array will contain numbers from 0 to 100, inclusive
	public static int[] generateArrayOfLength(int len) {
		int[] arr = new int[len];
		for (int i = 0; i < len; i++) {
			arr[i] = (int) (Math.random() * 101);
		}
		Arrays.sort(arr);
		return arr;
	}

	// Do a binary search on array to find number.
	// The method returns the number of comparisons made during a binary search
	public static int binarySearch(int[] array, int number) {

	}

	// Do a linear search on array to find the index of number.
	// The method returns the number of comparisons done.
	public static int linearSearch(int[] array, int number) {

	}
}
