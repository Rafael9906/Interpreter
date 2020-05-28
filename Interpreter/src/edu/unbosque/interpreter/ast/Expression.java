package edu.unbosque.interpreter.ast;

public class Expression extends Value{
	
	private ArithmeticExpression aex1,aex2;
	private BooleanOperator bop;
	
	
	public Expression(ArithmeticExpression aex1, BooleanOperator bop, ArithmeticExpression aex2) {
		this.aex1 = aex1;
		this.bop = bop;
		this.aex2 = aex2;
	}
	
	
	public Expression(ArithmeticExpression aex1) {
		this.aex1 = aex1;
		this.bop = null;
		this.aex2 = null;
	}


	@Override
	public int interpret() {
		
		if(this.bop != null) {
			int val = 0;
			switch(bop.getOperator()) {
			case "==":
				val = this.aex1.interpret() == this.aex2.interpret()? 1:0;
				break;
			case ">":
				val = this.aex1.interpret() > this.aex2.interpret()? 1:0;
				break;
			case ">=":
				val = this.aex1.interpret() >= this.aex2.interpret()? 1:0;
				break;
			case "<":
				val = this.aex1.interpret() < this.aex2.interpret()? 1:0;
				break;
			case "<=":
				val = this.aex1.interpret() <= this.aex2.interpret()? 1:0;
				break;
			}
			return val;
		}
		else {
			return aex1.interpret();
		}
		
	}
	
	

}
