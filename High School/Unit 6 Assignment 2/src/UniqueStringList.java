import java.util.ArrayList;

public class UniqueStringList {

	private ArrayList<String> strings;
	private boolean isCaseSensitive;

	public UniqueStringList() {
		strings = new ArrayList<String>();
		isCaseSensitive = true;
	}

	public UniqueStringList(ArrayList<String> arrayList) {
		strings = arrayList;
		isCaseSensitive = true;
	}

	public boolean stringEqual(String a, String b) {
		if (isCaseSensitive)
			return a.equals(b);
		return a.equalsIgnoreCase(b);
	}

	public boolean contains(String s) {
		return strings.contains(s);
	}

	public boolean add(String s) {
		if (!contains(s)) {
			strings.add(s);
			return true;
		}
		return false;
	}

	public void setCaseSensitive(boolean caseSensitive) {
		isCaseSensitive = caseSensitive;
	}

	public boolean isCaseSensitive() {
		return isCaseSensitive;
	}

	public void remove(String s) {
		if (contains(s))
			strings.remove(s);
	}

	public int size() {
		return strings.size();
	}

	public String get(int index) {
		return strings.get(index);
	}

	public String toString() {
		return strings.toString();
	}

}
