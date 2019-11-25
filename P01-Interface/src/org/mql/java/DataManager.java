package org.mql.java;

import java.util.List;
import java.util.Vector;

public class DataManager {
	private List<String> data;
	private Sorter sorter;
	private List<Printer> printers;
	
	public DataManager() {
		data = new Vector<>();
		printers = new Vector<>();
	}
	
	public void add(String item) {
		data.add(item);
	}
	
	public void sort() {
		if(sorter != null) {
			String t[] = new String[data.size()];
			data.toArray(t);
			sorter.sort(t);
		}
	}
	
	public String get(int index) {
		return data.get(index);
	}
	
	public int size() {
		return data.size();
	}

	public Sorter getSorter() {
		return sorter;
	}

	public void setSorter(Sorter sorter) {
		this.sorter = sorter;
	}
	
	public void print() {
		String t[] = new String[data.size()];
		data.toArray(t);
		for(Printer p : printers) {
			p.print(t);
		}
	}
	
	public void addPrinter(Printer p) {
		printers.add(p);
	}
}
