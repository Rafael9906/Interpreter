package edu.unbosque.interpreter.ast;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class Read extends Instruction{
	
	private SymbolTable st;
	private Variable v;
	
	
	public Read(SymbolTable st, Variable v) {
		this.st = st;
		this.v = v;
	}


	@Override
	public void checkcontext(SymbolTable st) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void prepInterp(SymbolTable st) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public int interpret() {
		
		int n = Integer.parseInt(JOptionPane.showInputDialog("\nEnter " + this.v.getName() + ": "));
		//v.setValue(n);
		//JOptionPane.showMessageDialog(null, st);
		Variable v = st.exists(this.v.getName());

		//Scanner input = new Scanner(System.in);
		//System.out.println("\nEnter " + this.v.getName() + ": ");
		
		v.setValue(n);
		
		System.out.println("\nRead " + st);
		return v.interpret();
	}
	
}