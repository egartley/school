package gartley;

import java.util.*;

public class LeakyStack {

	private final Object NONE = new Object();
	
	private ArrayList<Object> data;

	public LeakyStack(int size) {
		data = new ArrayList<>(size);
		for (int i = 0; i < size; i++) {
			data.add(NONE);
		}
	}

	private int getNextAvailableIndex() {
		int i = 0;
		while (i < data.size()) {
			if (data.get(i).equals(NONE)) {
				return i;
			}
			i++;
		}
		return -1;
	}

	private void fullPush(Object o) {
		ArrayList<Object> clone = (ArrayList<Object>) data.clone();
		for (int i = 0; i < data.size() - 1; i++) {
			data.set(i, clone.get(i + 1));
		}
		data.set(data.size() - 1, o);
	}

	public void push(Object o) {
		int i = getNextAvailableIndex();
		if (i != -1) {
			data.set(i, o);
		} else {
			fullPush(o);
		}
	}

	public Object pop() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		int index = getNextAvailableIndex() - 1;
		Object popped = data.get(index);
		data.set(index, NONE);
		return popped;
	}

	public Object top() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		int index = getNextAvailableIndex();
		if (index > 0) {
			return data.get(index - 1);
		}
		return NONE;
	}

	public int size() {
		int size = 0, i = 0;
		while (i < data.size()) {
			if (data.get(i).equals(NONE)) {
				break;
			} else {
				size++;
			}
			i++;
		}
		return size;
	}

	public int capacity() {
		return data.size();
	}

	public boolean isEmpty() {
		return data.get(0).equals(NONE);
	}

	public boolean isFull() {
		return !data.get(data.size() - 1).equals(NONE);
	}

}
