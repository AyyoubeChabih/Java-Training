package org.mql.java;

public class Test {
	
	public Test() {
		exp02();
	}
	
	public void exp02() {
		DataBase db = new DataBase(); // resources partagée
		Reader r1 = new Reader("R01",db);
		Writer w1 = new Writer("W01",db);
		r1.start();
		w1.start();
	}
	
	public static void main(String[] args) {
		new Test();
	}
}