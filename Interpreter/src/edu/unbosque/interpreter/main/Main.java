package edu.unbosque.interpreter.main;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.io.StringReader;

import edu.unbosque.interpreter.ast.Program;
import edu.unbosque.interpreter.lexer.*;
import edu.unbosque.interpreter.parser.*;
import java_cup.runtime.Symbol;


public class Main {
	
	public static void main(String path) throws Exception {
		Reader reader = null;
		
		//File input = new File("test1.txt");
		File input = new File(path);
				
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