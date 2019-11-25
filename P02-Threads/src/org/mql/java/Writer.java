package org.mql.java;

public class Writer extends Thread {
	private DataBase db;
	
	public Writer(String name, DataBase db) {
		super(name);
		this.db = db;
	}
	
	public void run() {	
		do {
			db.insert();
		} while (true);
	}
}