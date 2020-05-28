package view;

import javax.swing.JFrame;

public class Frame extends JFrame{
	
	public Frame() {
		initComponents();
	}
	
	public void initComponents() {
		
		setSize(890,480);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(true);
		
		Panel panel = new Panel(this);
		getContentPane().add(panel);
	}

}
