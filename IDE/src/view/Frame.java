package view;

import javax.swing.JFrame;

public class Frame extends JFrame{
	
	public Frame() {
		initComponents();
	}
	
	public void initComponents() {
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		
		Panel panel = new Panel(this);
		getContentPane().add(panel);
	}

}
