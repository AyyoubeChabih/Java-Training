package org.mql.java.generics;

public class LinkedList<T> {
	private T value = null;
	private LinkedList<T> next = null;
	
	public LinkedList() {
		
	}

	public LinkedList(T value) {
		super();
		this.value = value;
	}

	public void add(T value) {
		if(this.value == null) {
			this.value = value;
		}else if(next == null) {
			this.next = new LinkedList<>(value);
		}else {
			next.add(value);
		}
	}

	public T get(int index) {
		if(index == 0) return value;
		else if(next != null) return next.get(index-1);
		else return null;
	}
	
	public int size() {
		if(isEmpty()) return 0;
		else if(next == null) return 1;
		else return next.size() + 1;
	}
	
	public boolean isEmpty() {
		return (value == null && next == null);
	}
	
	public void remove(int index) {
		
	}
}
