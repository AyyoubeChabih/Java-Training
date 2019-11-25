package org.mql.java.application;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Pingouin extends JPanel implements Runnable{
	private static int counter = 0;
	private Thread runner;
	private int x = 300;
	private int y = 100;
	private int size = 30;
	private int step = 5;
	private String folder = "resources/seq/";
	private String ext = ".gif";
	private String sources[] = {
			"stop", "right1", "right2", "right3", "left1", "left2", "left3"
	};
	private Image film[];
	private int current = 0;
	
	public Pingouin(String name) {
		runner = new Thread(this, name);
		counter++;
		y += counter * 30;
		setLocation(x, y); // obligatoire car LayoutManager = null
		setSize(size, size); // obligatoire car LayoutManager = null
		loadImages();
	}
	
	public void loadImages() {
		film = new Image[sources.length];
		for (int i = 0; i < film.length; i++) {
			// Factory bean --> Design Pattern
			ImageIcon icon = new ImageIcon(folder+sources[i]+ext);
			film[i] = icon.getImage(); // Factory method
		}
	}

	public void run() {
		do {
			double choice = Math.random() * 100;
			if(choice < 45) goRight(3);
			else if(choice < 90) goLeft(3);
			else stop();
		}while(true);
	}
	
	public void goRight(int n) {
		for (int j = 0; j < n; j++) {
			for (int i = 1; i < 4; i++) {
				current = i;
				x += step;
				setLocation(x, y);
				repaint();
				pause(100);
			}	
		}
	}
	
	public void goLeft(int n) {
		for (int j = 0; j < n; j++) {
			for (int i = 4; i < 7; i++) {
				current = i;
				x -= step;
				setLocation(x, y);
				repaint();
				pause(100);
			}
		}
	}

	public void stop() {
		current = 0;
		repaint();
		pause((int)(Math.random() * 3000 + 2000)); // Math.random() -> double entre 0 et 1
	}
	
	public static void pause(long duration) {
		try {
			Thread.sleep(duration);
		}catch(Exception e) {}
	}

	public void start() {
		runner.start();
	}
	
	protected void paintComponent(Graphics g) { // on ne jamais l'appeler directement
		super.paintComponent(g); // la forme par defaut du panneau
		g.drawImage(film[current], 0, 0, this); // observer pour suiver le progress de telechargement de l'image
	}
	
}