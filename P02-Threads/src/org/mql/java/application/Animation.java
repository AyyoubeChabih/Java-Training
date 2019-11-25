package org.mql.java.application;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Animation extends JFrame implements ActionListener{
	private JPanel screen;
	private int counter = 0;
	public Animation() {
		screen = new JPanel();
		screen.setLayout(null);
		screen.setBackground(Color.BLACK);
		getContentPane().add("Center", screen);
		
		JButton b1 = new JButton("Nouveau Pingouin"); 
		getContentPane().add("South", b1);
		b1.addActionListener(this);
		
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true); // toujours est la derniere instruction
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		counter++;
		Pingouin p1 = new Pingouin("P" + counter);
		screen.add(p1);
		p1.start();
	}
	
	public static void main(String[] args) {
		new Animation();
	}

}
