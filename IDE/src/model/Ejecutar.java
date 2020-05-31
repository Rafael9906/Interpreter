package model;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;

import edu.unbosque.interpreter.ast.Program;
import edu.unbosque.interpreter.lexer.*;
import edu.unbosque.interpreter.main.Main;
import edu.unbosque.interpreter.parser.*;

public class Ejecutar {

	public void ejecutar() throws Exception {
		Main m = new Main();
		m.main("test1.txt");
	}
	
}
	

	
	

