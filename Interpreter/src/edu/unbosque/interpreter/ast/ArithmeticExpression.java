package edu.unbosque.interpreter.ast;

public class ArithmeticExpression extends Value{
	
	private ArithmeticExpression arex;
	private ArithmeticOperator aop;
	private Term term;
	
	
	public ArithmeticExpression(ArithmeticExpression arex, ArithmeticOperator aop, Term term) {
		
		this.arex = arex;
		this.aop = aop;
		this.term = term;
	}


	public ArithmeticExpression(Term term) {
		
		this.term = term;
	}
	
	
	public int interpret() {
		
		if(arex != null) {
			int val = 0;
			
			switch(aop.getOperator()) {
			
			case "+":
				val = arex.interpret() + term.interpret();
				break;
				
			case "-":
				val =  arex.interpret() - term.interpret();
				break;	
			}
			return val;
		}
		
		else {
			
			return term.interpret();
		}
	}

}
