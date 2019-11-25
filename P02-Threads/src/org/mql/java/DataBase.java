package org.mql.java;

public class DataBase {

	synchronized public void insert() {
		System.out.println(">> Début insertion "+Thread.currentThread().getName());
		try {
			Thread.sleep(1000);
		} catch (Exception e) {}
		System.out.println(">> Fin insertion "+Thread.currentThread().getName());
	}
	
	synchronized public void select() {
		System.out.println(">> Début selection "+Thread.currentThread().getName());
		try {
			Thread.sleep(1000);
		} catch (Exception e) {}
		System.out.println(">> Fin selection "+Thread.currentThread().getName());
	}
}
