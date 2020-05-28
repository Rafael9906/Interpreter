package edu.unbosque.compiler.main;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.io.StringReader;

import edu.unbosque.compiler.ast.Program;
import edu.unbosque.compiler.lexer.*;
import edu.unbosque.compiler.parser.*;
import java_cup.runtime.Symbol;


public class Main {
	
	public static void main(String[] args) throws Exception {
		Reader reader = null;
		
		File input = new File("test1.txt");
		
		reader = new FileReader(input);
		
		Lexer scanner = new Lexer(reader);
		parser parser = new parser(scanner);
		
		Program programa_axioma = null;
		
		try {
			programa_axioma = (Program) parser.parse().value;
			programa_axioma.interpret();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	static int contexterror = 0;
}



//Symbol tok = null;  
//do{
//	try {
//		tok = lex.next_token();
//		if(tok.value.toString() != null)
//			System.out.println(tok);
//	} catch (Error e) {
//		System.out.println(e.getMessage() + " in Line: " );
//		break;
//	} 
//}
//while(tok != null);
