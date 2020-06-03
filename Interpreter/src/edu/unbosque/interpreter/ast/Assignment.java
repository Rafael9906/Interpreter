package edu.unbosque.interpreter.ast;

public class Assignment extends Instruction{
	
	private SymbolTable st;
	private Variable v;
	private Expression e;
	
	
	public Assignment(SymbolTable st, Variable v, Expression e) {
		super();
		this.st = st;
		this.v = v;
		this.e = e;
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
		v.setValue(e.interpret());
		System.out.println("\nASSIGN: " + st.toString());
		return 0;
	}
	
	
}
