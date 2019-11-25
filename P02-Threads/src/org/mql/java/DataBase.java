package org.mql.java;

public class DataBase {

	synchronized public void insert() {
		System.out.println(">> D�but insertion "+Thread.currentThread().getName());
		try {
			Thread.sleep(1000);
		} catch (Exception e) {}
		System.out.println(">> Fin insertion "+Thread.currentThread().getName());
	}
	
	synchronized public void select() {
		System.out.println(">> D�but selection "+Thread.currentThread().getName());
		try {
			Thread.sleep(1000);
		} catch (Exception e) {}
		System.out.println(">> Fin selection "+Thread.currentThread().getName());
	}
}
