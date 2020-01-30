import java.util.ArrayList;
import java.util.Arrays;

public class Main {

	public static ArrayList<String> list = new ArrayList<String>();
	public static ArrayList<Integer> numbers = new ArrayList<Integer>();

	public static void main(String[] args) {
		list.add("to");
		list.add("be");
		list.add("or");
		list.add("not");
		list.add("to");
		list.add("be");
		list.add("hamlet");
		System.out.println(list);
		swapPairs(list);
		System.out.println(list);
		System.out.println();
		numbers.add(3);
		numbers.add(8);
		numbers.add(92);
		numbers.add(4);
		numbers.add(2);
		numbers.add(17);
		numbers.add(9);
		System.out.println(intersect(numbers,
				new ArrayList<Integer>(Arrays.asList(3, 1, 12, 4, 9, 17, 9))));
		removeEvenLength(list);
		System.out.println();
		System.out.println(list);
		doubleList(list);
		System.out.println();
		System.out.println(list);
		removeDuplicates(list);
		System.out.println();
		System.out.println(list);
		stutter(list, 4);
		System.out.println();
		System.out.println(list);
	}

	public static double averageVowels(ArrayList<String> words) {
		if (words.isEmpty())
			return 0.0;
		double sum = 0.0;
		for (String word : words) {
			int count = 0;
			for (char c : word.toCharArray()) {
				switch (c) {
				case 'a':
					count++;
					break;
				case 'e':
					count++;
					break;
				case 'i':
					count++;
					break;
				case 'o':
					count++;
					break;
				case 'u':
					count++;
					break;
				}
			}
			sum += count;
		}
		return sum / words.size();
	}

	public static void swapPairs(ArrayList<String> words) {
		for (int i = 0; i < words.size(); i++) {
			if (i % 2 == 0 && i + 1 < words.size()) {
				String prev = words.set(i, words.get(i + 1));
				words.set(i + 1, prev);
			}
		}
	}

	public static ArrayList<Integer> intersect(ArrayList<Integer> one,
			ArrayList<Integer> two) {
		ArrayList<Integer> r = new ArrayList<Integer>();
		for (int n : one) {
			for (int nn : two) {
				if (n == nn) {
					r.add(nn);
					break;
				}
			}
		}
		return r;
	}

	public static void removeEvenLength(ArrayList<String> words) {
		ArrayList<String> indexes = new ArrayList<String>();
		for (String s : words)
			if (s.length() % 2 == 0)
				indexes.add(s);
		words.removeAll(indexes);
	}

	public static void doubleList(ArrayList<String> words) {
		ArrayList<String> i = new ArrayList<String>();
		for (String s : words)
			i.add(s);
		words.addAll(i);
	}

	public static void minToFront(ArrayList<Integer> numbers) {
		int min = numbers.get(0);
		for (int n : numbers)
			min = Math.min(n, min);
		numbers.remove(min);
		numbers.add(0, min);
	}

	public static void removeDuplicates(ArrayList<String> words) {
		int i = 0;
		ArrayList<Integer> indexes = new ArrayList<Integer>();
		ArrayList<String> prev = new ArrayList<String>();
		for (String s : words) {
			for (String ss : words) {
				if (ss.equals(s) && !prev.contains(ss)) {
					prev.add(s);
					if (!indexes.contains(i))
						indexes.add(i);
				}
			}
			i++;
		}
		for (int index : indexes)
			words.remove(index);
	}

	public static void stutter(ArrayList<String> words, int k) {
		ArrayList<String> stuttered = new ArrayList<String>();
		if (k <= 0) {
			words.clear();
			return;
		}
		for (String word : words) {
			for (int i = 0; i < k; i++)
				stuttered.add(word);
		}
		words.clear();
		for (String s : stuttered)
			words.add(s);
	}

}
