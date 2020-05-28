package edu.unbosque.compiler.ast;

public class Term extends Value{
	
	private Term term;
	private ArithmeticOperator aop;
	private Value value;
	
	

	public Term(Term term, ArithmeticOperator aop, Value value) {
		this.term = term;
		this.aop = aop;
		this.value = value;
	}
	
	
	public Term(Value value) {
		this.term = null;
		this.aop = null;
		this.value = value;
	}


	@Override
	public int interpret() {
		
		if(term != null) {
			int val = 0;
			
			switch(aop.getOperator()) {
			
			case "*":
				val = term.interpret() * value.interpret();
				break;
				
			case "/":
				val =  term.interpret() / value.interpret();
				break;	
			}
			return val;
		}
		
		else {
			
			return value.interpret();
		}
	}

}
