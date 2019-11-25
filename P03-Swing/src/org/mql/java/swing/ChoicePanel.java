package org.mql.java.swing;

import java.awt.FlowLayout;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;

public class ChoicePanel extends JPanel{
	public static final int SINGLE = 0;
	public static final int MULTIPLE = 1;
	
	public ChoicePanel(String label, String ...choices) {
		this(SINGLE, label, choices);
	}
	
	public ChoicePanel(int type, String label, String ...choices) {
		setLayout(new FlowLayout(FlowLayout.LEFT));
		if(!label.contains(":")) label += " : ";
		add(new JLabel(label));
		if(type == SINGLE) {
			ButtonGroup g = new ButtonGroup();
			for (int i = 0; i < choices.length; i++) {
				JRadioButton b = new JRadioButton(choices[i]);
				add(b);
				g.add(b);
			}
		} else {
			for (int i = 0; i < choices.length; i++) {
				JCheckBox b = new JCheckBox(choices[i]);
				add(b);
			}
		}
	}

	public String getValue() {
		for (int i = 1; i < getComponentCount(); i++) {
			JToggleButton b = (JToggleButton)getComponent(i);
			if (b.isSelected()) return b.getText();
		}
		return null;
	}
	
	public String[] getValues() {
		Vector<String> choices = new Vector<>();
		for (int i = 1; i < getComponentCount(); i++) {
			JToggleButton b = (JToggleButton)getComponent(i);
			if (b.isSelected()) choices.add(b.getText());
		}
		String t[] = new String[choices.size()];
		choices.toArray(t);
		return t;
	}
}
