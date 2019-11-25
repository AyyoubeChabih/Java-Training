package org.mql.java;

public class Reader extends Thread {
	private DataBase db;
	
	public Reader(String name, DataBase db) {
		super(name);
		this.db = db;
	}
	
	public void run() {	
		do {
			db.select();
		} while (true);
	}
}
