package edu.unbosque.interpreter.ast;

public class Variable extends Value{
	
	private String name;
	private int value;
	private SymbolTable st;
	
	
	public Variable(String name, SymbolTable st) {
		this.name = name;
		this.value = 0;
		this.st = st;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	public int interpret() {
		Variable v = st.exists(name);
		return v.getValue();
	}
	
	
	@Override
	public String toString() {
		Variable v = st.exists(name);
		return "[" + this.name + ":" + v.getValue() + "]";
	}
	

}
