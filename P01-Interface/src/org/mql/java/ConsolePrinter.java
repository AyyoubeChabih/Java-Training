package org.mql.java;

public class ConsolePrinter implements Printer{
	public void print(String t[]) {
		for (int i = 0; i < t.length; i++) {
			System.out.println(t[i]);
		}
	}
}
