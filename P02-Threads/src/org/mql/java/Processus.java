package org.mql.java;

public class Processus extends Thread {
	
	public Processus(String name) {
		super(name);
	}
	
	public void run() {	
		System.out.println("I am " + Thread.currentThread().getName());
	}
}
