package edu.unbosque.interpreter.ast;

public class InstructionsList implements AST{
	
	private InstructionsList insList;
	private Instruction ins;
	
	
	public InstructionsList(InstructionsList insList, Instruction ins) {
		this.insList = insList;
		this.ins = ins;
	}
	
	
	public InstructionsList(Instruction ins) {
		this.insList = null;
		this.ins = ins;
	}
	
	public void interpret() {
		
		if(insList != null) {
			insList.interpret();
		}
		ins.interpret();
	}
	
}
