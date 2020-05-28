package edu.unbosque.interpreter.ast;

public abstract class Instruction implements AST {
	
	public abstract void checkcontext(SymbolTable st);
	
	public abstract void prepInterp(SymbolTable st);
	
	public abstract int interpret();

}
