package edu.unbosque.compiler.ast;

public class Variable extends Value{
	
	private String name;
	private int value;
	
	public Variable(String name) {
		this.name = name;
		this.value = 0;
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
		return this.value;
	}
	
	@Override
	public String toString() {
		return "[" + this.name + ":" + this.value + "]";
	}
	

}
