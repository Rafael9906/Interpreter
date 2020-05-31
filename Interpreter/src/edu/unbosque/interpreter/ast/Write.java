package edu.unbosque.interpreter.ast;

import javax.swing.JOptionPane;

public class Write extends Instruction {
	
	private SymbolTable st;
	private Variable v;
	
	

	public Write(SymbolTable st, Variable v) {
		super();
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
		
		Variable v = st.exists(this.v.getName());
		if(v != null) {
			JOptionPane.showMessageDialog(null, v.getName() + " = " + v.interpret());
			//System.out.print("\n>> " + v.getName() + " = " + v.interpret());
		}
		else {
			JOptionPane.showMessageDialog(null, "\nERROR. Impossible Print. Variable " + this.v.getName() + " don't exists.");
			//System.out.print("\nERROR. Impossible Print. Variable " + this.v.getName() + " don't exists.");
		}
		return 0;
	}

}
