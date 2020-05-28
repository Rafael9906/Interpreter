package edu.unbosque.interpreter.ast;

public class IfInstruction extends Instruction {
	
	private Expression exp;
	private InstructionsList insts;
	private InstructionsList sinoinsts;
	
	
	public IfInstruction(Expression exp, InstructionsList insts, InstructionsList sinoinsts) {
		this.exp = exp;
		this.insts = insts;
		this.sinoinsts = sinoinsts;
	}
	
	public IfInstruction(Expression exp, InstructionsList insts) {
		this.exp = exp;
		this.insts = insts;
		this.sinoinsts = null;
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
		
		if(exp.interpret() == 1) {
			insts.interpret();
		}
		else {
			if(sinoinsts != null) {
				sinoinsts.interpret();
			}
		}
		return 0;
	}

}
