package org.mql.java.application;

public class Test {

	public Test() {
		exp01();
	}
	
	public void exp01() {
		Processus p1 = new Processus("P1");
		Processus p2 = new Processus("P2");
		p1.start();
		p2.start();
	}
	
	public static void main(String[] args) {
		new Test();
	}

}
