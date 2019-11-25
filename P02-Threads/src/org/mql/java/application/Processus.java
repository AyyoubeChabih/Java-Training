package org.mql.java.application;

public class Processus implements Runnable{
	private Thread runner;

	public Processus(String name) {
		runner = new Thread(this, name);
	}
	
	public void run() {
		do {
			System.out.println(Thread.currentThread().getName());
			pause(1000);
		}while(true);
	}
	
	public static void pause(long duration) {
		try {
			Thread.sleep(duration);
		}catch(Exception e) {}
	}

	public void start() {
		runner.start();
	}
	
}
