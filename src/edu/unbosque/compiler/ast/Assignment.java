package edu.unbosque.compiler.ast;

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
		v.setValue(e.interpret());
		System.out.println("\nASSIGN: " + st);
		return 0;
	}
	
	
}
