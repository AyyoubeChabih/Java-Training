package org.mql.java.generics;

import java.util.Iterator;
import java.util.Vector;

public class Exemples {

	public Exemples() {
		exp01();
	}

	void exp01() {
		Vector<String> v1 = new Vector<>();
		v1.add("Introspection");
		v1.add("Annotations");
		v1.add("Généricité");

		for (String s : v1) {
			System.out.println(s);
		}
	}
	
	void exp02() {
		LinkedList<String> v1 = new LinkedList<>();
		v1.add("Introspection");
		v1.add("Annotations");
		v1.add("Généricité");
		
		System.out.println(v1.size());
		System.out.println(v1.get(0));
		System.out.println(v1.get(2));
		System.out.println(v1.get(7));
	}
	
	public static void main(String[] args) {
		new Exemples();
	}

}
