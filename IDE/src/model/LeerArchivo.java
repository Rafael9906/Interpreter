package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LeerArchivo {
	
	public  String leerTexto(String ruta){
				
		  String texto = "";
		
		  File archivo = new File(ruta);
		
		  try {
		
		   FileReader fr = new FileReader(archivo);
		
		   BufferedReader buffer = new BufferedReader(fr);
	
		   boolean fin = false;
		
		   StringBuffer sbf = new StringBuffer();
		
		   		
		   String nl = System.getProperty("line.separator");
				
		   while(fin == false){
		
		    String linea = buffer.readLine();
		
		
		    if(linea != null){
		    	sbf.append(linea + nl);
		    }
		
		    else{
		    	fin = true;
		    }
		
		   }
		
		   texto = sbf.toString();
	
		  }
		
		 catch (FileNotFoundException e) {
		
		   e.printStackTrace();
		
		  }
		
		  catch (IOException e) {
	
		
		   e.printStackTrace();
		
		  }
		   				
		  return texto;
		
		 }
		
		 
	}
