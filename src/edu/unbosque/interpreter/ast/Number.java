package edu.unbosque.interpreter.ast;

public class Number extends Value{
	
	private int N;
	
	public Number(String s) {
		try {
			this.N = Integer.parseInt(s);
		}
		catch (NumberFormatException e){
			this.N = -1;
		}
	}
	
	
	public String toString() {
		return ("" + this.N);
	}
	
	
	public int interpret() {
		return this.N;
	}

}
