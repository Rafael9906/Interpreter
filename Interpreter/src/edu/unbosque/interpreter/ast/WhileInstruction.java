package edu.unbosque.interpreter.ast;

public class WhileInstruction extends Instruction{
	
	private InstructionsList insts;
	private Expression exp;
	
	
	public WhileInstruction(InstructionsList insts,Expression exp) {
		this.insts = insts;
		this.exp = exp;
	}


	public InstructionsList getInsts() {
		return insts;
	}

	public void setInsts(InstructionsList insts) {
		this.insts = insts;
	}
	
	public Expression getExp() {
		return exp;
	}

	public void setExp(Expression exp) {
		this.exp = exp;
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
		
		do {
			insts.interpret();
		}
		while(exp.interpret() == 1);
			
		return 0;
	}

}
