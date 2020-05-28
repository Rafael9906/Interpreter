package edu.unbosque.interpreter.ast;

public class Program implements AST{
	
	private InstructionsList instructions;
	

	public Program(InstructionsList instructions) {
		this.instructions = instructions;
	}
	
	public void interpret() {
		this.instructions.interpret();
	}
	
}
