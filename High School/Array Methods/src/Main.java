import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(wordsRemoved(new String[] { "a",
				"bb", "b", "ccc" }, 1)));
	}

	public static int lastIndexOf(int[] n, int find) {
		int i = -1;
		for (int j = 0; j < n.length; j++)
			if (n[j] == find)
				i = j;
		return i;
	}

	public static int range(int[] n) {
		int max = n[0];
		for (int i : n)
			max = Math.max(max, i);
		int min = n[0];
		for (int i : n)
			max = Math.min(min, i);
		return max - min;
	}

	public static int countRange(int[] n, int max, int min) {
		int count = 0;
		for (int i : n)
			if (i <= max && i >= min)
				count++;
		return count;
	}

	public static int oneLessSum(int[] n) {
		if (n.length == 1)
			return 0;
		if (n.length == 2)
			return n[0];
		int sum = n[0];
		for (int i = 1; i < n.length - 1; i++)
			sum += n[i];
		return sum;
	}

	public static int[] swapPlaces(int[] n) {
		int[] swapped = new int[n.length];
		swapped[0] = n[n.length - 1];
		swapped[n.length - 1] = n[0];
		for (int i = 1; i < n.length - 2; i++)
			swapped[i] = n[i];
		return swapped;
	}

	public static String longestWord(String[] s) {
		String longest = "";
		for (String i : s)
			if (longest.length() < i.length())
				longest = i;
		return longest;
	}

	public static int mostVowels(String[] s) {
		int vowels = 0;
		for (int i = 0; i < s.length; i++) {
			String word = s[i];
			vowels = Math.max(vowels,
					instancesOf(word, "a") + instancesOf(word, "e")
							+ instancesOf(word, "i") + instancesOf(word, "o")
							+ instancesOf(word, "u"));
		}
		return vowels;
	}

	public static int[] changeNumber(int[] n, int old, int replace) {
		int indexOld = 0;
		int[] changed = Arrays.copyOf(n, n.length);
		for (int i = 0; i < n.length; i++) {
			if (n[i] == old) {
				indexOld = i;
				break;
			}
		}
		changed[indexOld] = replace;
		return changed;
	}

	public static boolean threeThrees(int[] n) {
		if (instancesOf(n, 3) < 3)
			return false;
		boolean nextToEachOther = false;
		for (int i = 0; i < n.length - 4; i++)
			nextToEachOther = n[i] == 3 && n[i + 1] == 3 && n[i + 2] == 3;
		return nextToEachOther;
	}

	public static String[] wordsRemoved(String[] s, int length) {
		int omitted = 0, ri = 0;
		int[] omittedIndexes = new int[s.length];
		for (int i = 0; i < s.length; i++) {
			if (s[i].length() == length) {
				omitted++;
				omittedIndexes[i] = 1;
			}
		}
		String[] censored = new String[s.length - omitted];
		for (int i = 0; i < s.length; i++) {
			if (omittedIndexes[i] == 1) {
				i++;
				if (i >= censored.length) {
					if (ri == censored.length) {
						ri--;
						i -= 2;
					}
					censored[ri] = s[i];
					break;
				}
			}
			censored[ri] = s[i];
			ri++;
		}
		return censored;
	}

	public static int instancesOf(String s, String key) {
		int instances = 0;
		s = s.toLowerCase();
		key = key.toLowerCase();
		while (s.indexOf(key) != -1) {
			instances++;
			s = s.substring(s.indexOf(key) + key.length());
		}
		return instances;
	}

	public static int instancesOf(int[] n, int key) {
		int instances = 0;
		for (int i : n)
			if (i == key)
				instances++;
		return instances;
	}

}