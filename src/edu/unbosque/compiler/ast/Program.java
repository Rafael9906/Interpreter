package edu.unbosque.compiler.ast;

public class Program implements AST{
	
	private InstructionsList instructions;
	

	public Program(InstructionsList instructions) {
		this.instructions = instructions;
	}
	
	public void interpret() {
		this.instructions.interpret();
	}
	
}
