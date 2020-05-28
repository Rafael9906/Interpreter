package edu.unbosque.interpreter.ast;

public class Operator {
	
	private String operator;

	public Operator(String operator) {
		super();
		this.operator = operator;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}
	
}
